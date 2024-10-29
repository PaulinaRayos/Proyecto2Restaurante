/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Restaurante;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz IRestauranteDAO y proporciona métodos para
 * el acceso a datos de la entidad Restaurante. Permite realizar operaciones
 * CRUD (crear, leer, actualizar y eliminar) sobre los restaurantes en la base
 * de datos. Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public class RestauranteDAO implements IRestauranteDAO {

    private final IConexion conexion;

    /**
     * Constructor de la clase RestauranteDAO.
     *
     * @param conexion Objeto que proporciona la conexión a la base de datos.
     */
    public RestauranteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Guarda un nuevo restaurante en la base de datos o actualiza uno
     * existente.
     *
     * @param restaurante El restaurante a guardar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public void guardarRestaurante(Restaurante restaurante) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();

        try {
            em.getTransaction().begin();

            em.persist(restaurante); // Crear un nuevo restaurante

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar o actualizar el restaurante", e);
        } finally {
            em.close();
        }
    }

    /**
     * Busca las ciudades y direcciones de todos los restaurantes en la base de
     * datos.
     *
     * @return Una lista de arreglos de objetos, donde cada arreglo contiene la
     * ciudad y la dirección de un restaurante.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public List<Object[]> buscarCiudadesYDireccionesRestaurantes() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            String jpql = "SELECT r.ciudad, r.direccion FROM Restaurante r";
            Query query = em.createQuery(jpql);
            List<Object[]> resultados = query.getResultList();
            return resultados;
        } catch (Exception e) {
            e.printStackTrace(); // Agrega esto para ver detalles del error
            throw new PersistenciaException("No se pudieron encontrar los restaurantes.");
        }
    }

    /**
     * Obtiene un restaurante de la base de datos por su ID.
     *
     * @param idRestaurante El ID del restaurante a buscar.
     * @return El restaurante correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public Restaurante obtenerPorId(Long idRestaurante) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();

        try {
            return em.find(Restaurante.class, idRestaurante); // Método find para obtener el objeto
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el Restaurante.", e);
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }

    /**
     * Obtiene todos los restaurantes de la base de datos.
     *
     * @return Una lista de todos los restaurantes.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public List<Restaurante> obtenerTodosLosRestaurantes() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        List<Restaurante> restaurantes;

        try {
            TypedQuery<Restaurante> query = em.createQuery("SELECT r FROM Restaurante r", Restaurante.class);
            restaurantes = query.getResultList();
        } catch (PersistenceException e) {
            throw new PersistenciaException("Error al obtener todos los restaurantes", e);
        } finally {
            em.close();
        }

        return restaurantes;
    }

    /**
     * Obtiene la hora de apaertura del restaurante.
     *
     * @param idRestaurante el id del restaurante al que le pertenece el horario
     * apertura
     * @param diaSemana el dia de la semana
     * @return la hora de apertura.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public Date obtenerHoraApertura(Long idRestaurante, String diaSemana) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            TypedQuery<Date> query = em.createQuery(
                    "SELECT h.horaApertura FROM Horario h WHERE h.restaurante.id = :idRestaurante AND h.diaSemana = :diaSemana",
                    Date.class
            );
            query.setParameter("idRestaurante", idRestaurante);
            query.setParameter("diaSemana", diaSemana);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la hora de apertura");
        }
    }

    /**
     * Obtiene la hora de cierre del restaurante.
     *
     * @param idRestaurante el id del restaurante al que le pertenece el horario
     * cierre
     * @param diaSemana el dia de la semana
     * @return la hora de cirre.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public Date obtenerHoraCierre(Long idRestaurante, String diaSemana) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            TypedQuery<Date> query = em.createQuery(
                    "SELECT h.horaCierre FROM Horario h WHERE h.restaurante.id = :idRestaurante AND h.diaSemana = :diaSemana",
                    Date.class
            );
            query.setParameter("idRestaurante", idRestaurante);
            query.setParameter("diaSemana", diaSemana);
            return query.getSingleResult();
        } catch (Exception e) {
            return null; // O manejar el caso en que no se encuentre horario
        }
    }

}
