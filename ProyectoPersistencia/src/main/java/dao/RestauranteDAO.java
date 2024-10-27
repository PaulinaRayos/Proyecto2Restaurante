/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Restaurante;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author pauli
 */
public class RestauranteDAO implements IRestauranteDAO {

    private final IConexion conexion;

    public RestauranteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

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

    @Override
    public List<Object[]> buscarCiudadesYDireccionesRestaurantes() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            String jpql = "SELECT r.ciudad, r.direccion FROM Restaurante r";
            Query query = em.createQuery(jpql);
            List<Object[]> resultados = query.getResultList();
            System.out.println("Cantidad de restaurantes encontrados: " + resultados.size());
            return resultados;
        } catch (Exception e) {
            e.printStackTrace(); // Agrega esto para ver detalles del error
            throw new PersistenciaException("No se pudieron encontrar los restaurantes.");
        }
    }

    public Restaurante obtenerPorId(Long idRestaurante) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();

        try {
            return em.find(Restaurante.class, idRestaurante); // Usar el método find para obtener el objeto
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el Restaurante.", e);
        } finally {
            em.close(); // Asegurarte de cerrar el EntityManager
        }
    }
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

}
