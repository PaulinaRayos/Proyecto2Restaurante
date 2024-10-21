/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidadesJPA.Mesa;
import interfaces.IMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad Mesa.
 * Proporciona operaciones para crear, leer, actualizar y eliminar mesas en la
 * base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class MesaDAO implements IMesaDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    // Constructor
    public MesaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu_restaurante");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para agregar una mesa
    public void agregarMesa(Mesa mesa) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(mesa); // Persiste la entidad Mesa
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para obtener una mesa por ID
    public Mesa obtenerMesaPorId(Long id) {
        return entityManager.find(Mesa.class, id); // Buscar la mesa por su ID
    }

    // Método para obtener todas las mesas
    public List<Mesa> obtenerTodasLasMesas() {
        return entityManager.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList(); // Consulta para obtener todas las mesas
    }

    // Método para actualizar una mesa
    public void actualizarMesa(Mesa mesa) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(mesa); // Actualizar la mesa existente
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para eliminar una mesa por ID
    public void eliminarMesa(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Mesa mesa = entityManager.find(Mesa.class, id); // Buscar la mesa por ID
            if (mesa != null) {
                entityManager.remove(mesa); // Eliminar la mesa
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
