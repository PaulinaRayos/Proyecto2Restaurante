/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.TipoMesa;
import excepciones.PersistenciaException;
import interfaces.ITipoMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad
 * TipoMesa. Proporciona operaciones para crear, leer, actualizar y eliminar
 * tipos de mesa en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class TipoMesaDAO implements ITipoMesaDAO {

    private final IConexion conexion;

    // Constructor
    public TipoMesaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    // Método para agregar un tipo de mesa
    public void agregarTipoMesa(TipoMesa tipoMesa) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(tipoMesa); // Persiste la entidad TipoMesa
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo agregar el tipo de mesa.");
        }
    }

    // Método para obtener un tipo de mesa por ID
    public TipoMesa obtenerTipoMesaPorId(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(TipoMesa.class, id); // Buscar el tipo de mesa por su ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener el tipo de mesa con id: " + id);
        }

    }

    // Método para obtener todos los tipos de mesa
    public List<TipoMesa> obtenerTodosLosTiposMesa() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT t FROM TipoMesa t", TipoMesa.class).getResultList(); // Consulta para obtener todos los tipos de mesa
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron obtener los tipos de mesa.");
        }
    }

    // Método para actualizar un tipo de mesa
    public void actualizarTipoMesa(TipoMesa tipoMesa) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(tipoMesa); // Actualizar el tipo de mesa existente
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo actualizar el tipo de mesa con id: " + tipoMesa.getId());
        }
    }

    // Método para eliminar un tipo de mesa por ID
    public void eliminarTipoMesa(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            TipoMesa tipoMesa = em.find(TipoMesa.class, id); // Buscar el tipo de mesa por ID
            if (tipoMesa != null) {
                em.remove(tipoMesa); // Eliminar el tipo de mesa
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo eliminar el tipo de mesa con id: " + id);
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
