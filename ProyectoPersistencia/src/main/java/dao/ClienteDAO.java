/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidadesJPA.Cliente;
import interfaces.IClienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad Cliente.
 * Proporciona operaciones para crear, leer, actualizar y eliminar clientes en
 * la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ClienteDAO implements IClienteDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    // Constructor
    public ClienteDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu_restaurante");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para agregar un cliente
    public void agregarCliente(Cliente cliente) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(cliente); // Persiste el objeto Cliente
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para obtener un cliente por ID
    public Cliente obtenerClientePorId(int id) {
        return entityManager.find(Cliente.class, id); // Encontrar cliente por ID
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList(); // Consulta para obtener todos los clientes
    }

    // Método para actualizar un cliente
    public void actualizarCliente(Cliente cliente) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(cliente); // Actualizar el cliente existente
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revertir la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para eliminar un cliente
    public void eliminarCliente(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Cliente cliente = entityManager.find(Cliente.class, id); // Encontrar cliente por ID
            if (cliente != null) {
                entityManager.remove(cliente); // Eliminar cliente
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revertir la transacción si ocurre un error
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
