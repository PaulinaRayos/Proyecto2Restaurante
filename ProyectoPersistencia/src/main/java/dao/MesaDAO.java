/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Mesa;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz IMesaDAO y proporciona métodos para el
 * acceso a datos de la entidad Mesa. Permite realizar operaciones CRUD (crear,
 * leer, actualizar y eliminar) sobre las mesas en la base de datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public class MesaDAO implements IMesaDAO {

    private final IConexion conexion;

    /**
     * Constructor de la clase MesaDAO.
     *
     * @param conexion Objeto que proporciona la conexión a la base de datos.
     */
    public MesaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega una nueva mesa a la base de datos.
     *
     * @param mesa La mesa a agregar.
     * @return
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public long agregarMesa(Mesa mesa) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(mesa); // Persiste la entidad Mesa
            em.getTransaction().commit();

            // Retorna el ID de la mesa recién creada
            return mesa.getId();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo agregar la mesa.");
        } finally {
            em.close(); // Asegúrate de cerrar el EntityManager
        }
    }

    /**
     * Inserta una lista de mesas en la base de datos de manera masiva.
     *
     * @param mesas La lista de mesas a insertar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public void insertarMesas(List<Mesa> mesas) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();

        try {
            em.getTransaction().begin();

            for (Mesa mesa : mesas) {
                em.persist(mesa); // Guardar cada mesa en la base de datos
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al insertar mesas", e);
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }

    /**
     * Obtiene una mesa por su ID.
     *
     * @param id El ID de la mesa a buscar.
     * @return La mesa correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public Mesa obtenerMesaPorId(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(Mesa.class, id); // Buscar la mesa por su ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener la mesa con id: " + id);
        }

    }

    /**
     * Obtiene todas las mesas de la base de datos.
     *
     * @return Una lista de todas las mesas.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public List<Mesa> obtenerTodasLasMesas() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        List<Mesa> mesas = null;

        try {
            String jpql = "SELECT m FROM Mesa m JOIN FETCH m.restaurante";
            TypedQuery<Mesa> query = em.createQuery(jpql, Mesa.class);
            mesas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            em.close();
        }

        return mesas;
    }

    /**
     * Obtiene el costo de reserva de una mesa por su ID.
     *
     * @param idMesa El ID de la mesa.
     * @return El costo de reserva de la mesa, o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public BigDecimal obtenerCostoPorIdMesa(Long idMesa) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        BigDecimal precioReserva = null;

        try {
            Mesa mesa = em.find(Mesa.class, idMesa);
            if (mesa != null && mesa.getTipoMesa() != null) {
                precioReserva = mesa.getTipoMesa().getPrecioReserva();
            } else {
                System.out.println("La mesa o su tipo no se encontraron.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            em.close(); // Cerrar EntityManager
        }

        return precioReserva; // Retornar el precio o null si no se encontró
    }

    /**
     * Obtiene la cantidad total de mesas en la base de datos.
     *
     * @return La cantidad total de mesas.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public long obtenerCantidadDeMesas() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            String jpql = "SELECT COUNT(m) FROM Mesa m";
            return (long) em.createQuery(jpql).getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al contar mesas en la base de datos", e);
        }
    }

    /**
     * Obtiene el ID del restaurante asociado a una mesa específica.
     *
     * @param idMesa el ID de la mesa para la cual se desea obtener el ID del
     * restaurante
     * @return el ID del restaurante asociado a la mesa
     * @throws PersistenciaException si ocurre un error al obtener el ID del
     * restaurante
     */
    @Override
    public Long obtenerIdRestaurantePorIdMesa(Long idMesa) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            Mesa mesa = em.find(Mesa.class, idMesa); // Busca la mesa por su ID
            if (mesa != null) {
                return mesa.getRestaurante().getId(); // Retorna el ID del restaurante
            } else {
                throw new PersistenciaException("Mesa no encontrada con id: " + idMesa);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el ID del restaurante para la mesa con id: " + idMesa, e);
        } finally {
            em.close(); // Asegúrate de cerrar el EntityManager
        }
    }

    /**
     * Elimina una mesa de la base de datos por su ID.
     *
     * @param id El ID de la mesa a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public void eliminarMesa(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Mesa mesa = em.find(Mesa.class, id); // Buscar la mesa por ID
            if (mesa != null) {
                em.remove(mesa); // Eliminar la mesa
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo eliminar la mesa con id: " + id);
        }
    }

}
