/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidadesJPA.Reserva;
import interfaces.IReservaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad Reserva.
 * Proporciona operaciones para crear, leer, actualizar y eliminar reservas en
 * la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ReservaDAO implements IReservaDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    // Constructor
    public ReservaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu_restaurante");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para agregar una reserva
    public void agregarReserva(Reserva reserva) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(reserva); // Persiste la entidad Reserva
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para obtener una reserva por ID
    public Reserva obtenerReservaPorId(int id) {
        return entityManager.find(Reserva.class, id); // Buscar la reserva por su ID
    }

    // Método para obtener todas las reservas
    public List<Reserva> obtenerTodasLasReservas() {
        return entityManager.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList(); // Consulta para obtener todas las reservas
    }

    // Método para obtener reservas por estado
    public List<Reserva> obtenerReservasPorEstado(String estado) {
        return entityManager.createQuery("SELECT r FROM Reserva r WHERE r.estado = :estado", Reserva.class)
                .setParameter("estado", estado)
                .getResultList();
    }

    // Método para actualizar una reserva
    public void actualizarReserva(Reserva reserva) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(reserva); // Actualizar la reserva existente
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para eliminar una reserva por ID
    public void eliminarReserva(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Reserva reserva = entityManager.find(Reserva.class, id); // Buscar la reserva por ID
            if (reserva != null) {
                entityManager.remove(reserva); // Eliminar la reserva
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para cerrar el EntityManager y EntityManagerFactory
    public void cerrar() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

}
