/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidadesJPA.HistorialReservas;
import excepciones.PersistenciaException;
import interfaces.IHistorialReservasDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad
 * HistorialReservas. Proporciona operaciones para crear, leer, actualizar y
 * eliminar registros de historial de reservas en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HistorialReservasDAO implements IHistorialReservasDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    // Constructor
    public HistorialReservasDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu_restaurante");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para agregar un historial de reserva
    public void agregarHistorialReservas(HistorialReservas historialReservas) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(historialReservas); // Persiste el objeto HistorialReservas
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para obtener un historial de reserva por ID
    public HistorialReservas obtenerHistorialReservasPorId(Long id) {
        return entityManager.find(HistorialReservas.class, id); // Buscar HistorialReservas por ID
    }

    // Método para obtener todos los historiales de reserva
    public List<HistorialReservas> obtenerTodosLosHistorialesReservas() {
        return entityManager.createQuery("SELECT hr FROM HistorialReservas hr", HistorialReservas.class).getResultList(); // Consulta para obtener todos los historiales de reservas
    }

    // Método para actualizar un historial de reserva
    public void actualizarHistorialReservas(HistorialReservas historialReservas) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(historialReservas); // Actualizar el historial existente
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para eliminar un historial de reserva
    public void eliminarHistorialReservas(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            HistorialReservas historialReservas = entityManager.find(HistorialReservas.class, id); // Buscar el historial por ID
            if (historialReservas != null) {
                entityManager.remove(historialReservas); // Eliminar el historial
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
