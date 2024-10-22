/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import excepciones.PersistenciaException;
import interfaces.IHistorialReservasDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad
 * HistorialReservas. Proporciona operaciones para crear, leer, actualizar y
 * eliminar registros de historial de reservas en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HistorialReservasDAO  {

    private final IConexion conexion;

    // Constructor
    public HistorialReservasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    // Método para agregar un historial de reserva
//    public void agregarHistorialReservas(HistorialReservas historialReservas) throws PersistenciaException {
//        EntityManager em = this.conexion.crearConexion();
//        try {
//            em.getTransaction().begin();
//
//            em.persist(historialReservas); // Persiste el objeto HistorialReservas
//
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
//            }
//            throw new PersistenciaException("No se pudo agregar el historial de reservas.");
//        }
//    }
//
//    // Método para obtener un historial de reserva por ID
//    public HistorialReservas obtenerHistorialReservasPorId(Long id) throws PersistenciaException {
//        EntityManager em = this.conexion.crearConexion();
//        try {
//            return em.find(HistorialReservas.class, id); // Buscar HistorialReservas por ID
//        } catch (Exception e) {
//            throw new PersistenciaException("No se pudo encontrar el historial de reservas por id: " + id);
//        }
//    }
//
//    // Método para obtener todos los historiales de reserva
//    public List<HistorialReservas> obtenerTodosLosHistorialesReservas() throws PersistenciaException {
//        EntityManager em = this.conexion.crearConexion();
//        try {
//            return em.createQuery("SELECT hr FROM HistorialReservas hr", HistorialReservas.class).getResultList(); // Consulta para obtener todos los historiales de reservas
//        } catch (Exception e) {
//            throw new PersistenciaException("No se pudieron encontrar el historial de reservas.");
//        }
//
//    }
//
//    // Método para actualizar un historial de reserva
//    public void actualizarHistorialReservas(HistorialReservas historialReservas) throws PersistenciaException {
//        EntityManager em = this.conexion.crearConexion();
//        try {
//            em.getTransaction().begin();
//            em.merge(historialReservas); // Actualizar el historial existente
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
//            }
//            throw new PersistenciaException("No se pudo actualizar el historial de reservas.");
//        }
//    }
//
//    // Método para eliminar un historial de reserva
//    public void eliminarHistorialReservas(Long id) throws PersistenciaException {
//        EntityManager em = this.conexion.crearConexion();
//        try {
//            em.getTransaction().begin();
//            HistorialReservas historialReservas = em.find(HistorialReservas.class, id); // Buscar el historial por ID
//            if (historialReservas != null) {
//                em.remove(historialReservas); // Eliminar el historial
//            }
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
//            }
//            throw new PersistenciaException("No se pudo eliminar el historial de reservas.");
//        }
//    }
//
//    // Método para cerrar el EntityManager y EntityManagerFactory
//    public void cerrar() {
//        EntityManager em = this.conexion.crearConexion();
//        if (em != null && em.isOpen()) {
//            em.close();
//        }
//    }

}
