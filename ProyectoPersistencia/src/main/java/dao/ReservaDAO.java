/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Reserva;
import excepciones.PersistenciaException;
import interfaces.IReservaDAO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Clase que implementa la interfaz IReservaDAO y proporciona métodos para el
 * acceso a datos de la entidad Reserva. Permite realizar operaciones CRUD
 * (crear, leer, actualizar y eliminar) sobre las reservas en la base de datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public class ReservaDAO implements IReservaDAO {

    private final IConexion conexion;

    /**
     * Constructor de la clase ReservaDAO.
     *
     * @param conexion Objeto que proporciona la conexión a la base de datos.
     */
    public ReservaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega una nueva reserva a la base de datos.
     *
     * @param reserva La reserva a agregar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
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

    /**
     * Obtiene una reserva por su ID.
     *
     * @param id El ID de la reserva a buscar.
     * @return La reserva correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public Reserva obtenerReservaPorId(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(Reserva.class, id); // Buscar la reserva por su ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener la reserva con id: " + id);
        }

    }

    /**
     * Obtiene todas las reservas de la base de datos.
     *
     * @return Una lista de todas las reservas.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public List<Reserva> obtenerTodasLasReservas() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList(); // Consulta para obtener todas las reservas
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener las reservas.");
        }

    }

    /**
     * Obtiene reservas de la base de datos que coinciden con el estado
     * proporcionado.
     *
     * @param estado El estado de las reservas a buscar.
     * @return Una lista de reservas que coinciden con el estado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
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

    /**
     * Actualiza una reserva existente en la base de datos.
     *
     * @param reserva La reserva a actualizar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
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

    /**
     * Obtiene el estado de una reserva por su ID.
     *
     * @param id El ID de la reserva a buscar.
     * @return El estado de la reserva correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public String obtenerEstadoReservaPorId(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            Reserva reserva = em.find(Reserva.class, id); // Buscar la reserva por su ID
            if (reserva != null) {
                return reserva.getEstado(); // Devolver el estado de la reserva
            } else {
                throw new PersistenciaException("No se encontró una reserva con id: " + id);
            }
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener el estado de la reserva con id: " + id);
        } finally {
            // Cerrar el EntityManager si se creó en este método
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void cancelarReserva(Long idReserva, Date fechaCancelacion, BigDecimal multa) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Reserva reserva = em.find(Reserva.class, idReserva);
            if (reserva != null) {
                reserva.setEstado("Cancelada");
                reserva.setFechaCancelacion(fechaCancelacion);
                reserva.setMulta(multa);
                em.merge(reserva); // Actualizar la reserva
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo cancelar la reserva con id: " + idReserva);
        } finally {
            em.close();
        }
    }

    /**
     * Cierra el EntityManager si está abierto.
     */
    public void cerrar() {
        EntityManager em = this.conexion.crearConexion();
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
