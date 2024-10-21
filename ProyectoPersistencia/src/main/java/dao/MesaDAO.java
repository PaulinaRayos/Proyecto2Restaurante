/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Mesa;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad Mesa.
 * Proporciona operaciones para crear, leer, actualizar y eliminar mesas en la
 * base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class MesaDAO implements IMesaDAO {

    private final IConexion conexion;

    // Constructor
    public MesaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    // Método para agregar una mesa
    public void agregarMesa(Mesa mesa) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(mesa); // Persiste la entidad Mesa
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo agregar la mesa.");
        }
    }

    // Método para obtener una mesa por ID
    public Mesa obtenerMesaPorId(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(Mesa.class, id); // Buscar la mesa por su ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener la mesa con id: " + id);
        }

    }

    // Método para obtener todas las mesas
    public List<Mesa> obtenerTodasLasMesas() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList(); // Consulta para obtener todas las mesas
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron obtener las mesa.");
        }

    }

    // Método para actualizar una mesa
    public void actualizarMesa(Mesa mesa) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(mesa); // Actualizar la mesa existente
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo actualizar la mesa con id: " + mesa.getId());
        }
    }

    // Método para eliminar una mesa por ID
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

    // Método para cerrar el EntityManager y EntityManagerFactory
    public void cerrar() {
        EntityManager em = this.conexion.crearConexion();
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
