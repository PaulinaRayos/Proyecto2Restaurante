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
import javax.persistence.Query;

/**
 *
 * @author pauli
 */
public class RestauranteDAO implements IRestauranteDAO {

    private final IConexion conexion;

    public RestauranteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    public void guardarOActualizarRestaurante(Restaurante restaurante) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();

        try {
            em.getTransaction().begin();

            if (restaurante.getId() == null) {
                em.persist(restaurante); // Crear un nuevo restaurante
            } else {
                em.merge(restaurante); // Actualizar el restaurante existente
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar o actualizar el restaurante", e);
        } finally {
            em.close();
        }
    }

    public Restaurante buscarRestauranteUnico() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        Restaurante restaurante = null;

        try {
            // Buscar el restaurante existente (solo uno)
            Query query = em.createQuery("SELECT r FROM Restaurante r");
            List<Restaurante> restaurantes = query.getResultList();

            if (!restaurantes.isEmpty()) {
                restaurante = restaurantes.get(0); // Asumimos que solo hay un restaurante
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar restaurante", e);
        } finally {
            em.close();
        }

        return restaurante;
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
}
