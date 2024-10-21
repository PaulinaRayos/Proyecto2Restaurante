/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidadesJPA.TipoMesa;
import interfaces.ITipoMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad
 * TipoMesa. Proporciona operaciones para crear, leer, actualizar y eliminar
 * tipos de mesa en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class TipoMesaDAO implements ITipoMesaDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    // Constructor
    public TipoMesaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu_restaurante");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para agregar un tipo de mesa
    public void agregarTipoMesa(TipoMesa tipoMesa) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(tipoMesa); // Persiste la entidad TipoMesa
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para obtener un tipo de mesa por ID
    public TipoMesa obtenerTipoMesaPorId(Long id) {
        return entityManager.find(TipoMesa.class, id); // Buscar el tipo de mesa por su ID
    }

    // Método para obtener todos los tipos de mesa
    public List<TipoMesa> obtenerTodosLosTiposMesa() {
        return entityManager.createQuery("SELECT t FROM TipoMesa t", TipoMesa.class).getResultList(); // Consulta para obtener todos los tipos de mesa
    }

    // Método para actualizar un tipo de mesa
    public void actualizarTipoMesa(TipoMesa tipoMesa) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(tipoMesa); // Actualizar el tipo de mesa existente
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción si ocurre un error
            }
            e.printStackTrace();
        }
    }

    // Método para eliminar un tipo de mesa por ID
    public void eliminarTipoMesa(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TipoMesa tipoMesa = entityManager.find(TipoMesa.class, id); // Buscar el tipo de mesa por ID
            if (tipoMesa != null) {
                entityManager.remove(tipoMesa); // Eliminar el tipo de mesa
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
