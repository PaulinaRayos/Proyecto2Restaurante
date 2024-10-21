/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Reserva;
import excepciones.PersistenciaException;
import interfaces.IReservaDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad Reserva.
 * Proporciona operaciones para crear, leer, actualizar y eliminar reservas en
 * la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ReservaDAO implements IReservaDAO {

    private final IConexion conexion;

    // Constructor
    public ReservaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    // Método para agregar una reserva
    public void agregarReserva(Reserva reserva) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(reserva); // Persiste la entidad Reserva
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo agregar la reserva.");
        }
    }

    // Método para obtener una reserva por ID
    @Override
    public Reserva obtenerReservaPorId(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(Reserva.class, id); // Buscar la reserva por su ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener la reserva con id: " + id);
        }

    }

    // Método para obtener todas las reservas
    public List<Reserva> obtenerTodasLasReservas() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList(); // Consulta para obtener todas las reservas
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener las reservas.");
        }

    }

    // Método para obtener reservas por estado
    public List<Reserva> obtenerReservasPorEstado(String estado) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT r FROM Reserva r WHERE r.estado = :estado", Reserva.class)
                    .setParameter("estado", estado)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener las reservas con el estado: " + estado);
        }

    }

    // Método para actualizar una reserva
    public void actualizarReserva(Reserva reserva) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(reserva); // Actualizar la reserva existente
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo actualizar la reserva con id: " + reserva.getId());
        }
    }

    // Método para eliminar una reserva por ID
    public void eliminarReserva(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Reserva reserva = em.find(Reserva.class, id); // Buscar la reserva por ID
            if (reserva != null) {
                em.remove(reserva); // Eliminar la reserva
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revierte la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo eliminar la reserva con id: " + id);
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
