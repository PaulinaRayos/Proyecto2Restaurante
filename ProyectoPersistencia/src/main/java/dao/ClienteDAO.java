/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidadesJPA.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import recursos.Encriptacion;

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
    public void agregarCliente(Cliente cliente) throws PersistenciaException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(cliente); // Persiste el objeto Cliente
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revertir la transacción si ocurre un error
            }
            throw new PersistenciaException("No se pudo agregar el cliente a la base de datos: " + e);
        }
    }

    @Override
    public void insercionMasiva() {
        List<String> nombres = Arrays.asList("Chris", "Ana", "Luis", "Maria", "Pedro", "Lucia", "Jorge", "Sofia",
                "Diego", "Valeria", "Carlos", "Fernanda", "David", "Camila", "Oscar",
                "Daniela", "Fernando", "Paula", "Miguel", "Andrea");

        List<String> apellidosPaternos = Arrays.asList("Elizalde", "Gonzalez", "Martinez", "Hernandez", "Lopez",
                "Perez", "Garcia", "Ramirez", "Sanchez", "Castro",
                "Moreno", "Ortiz", "Vargas", "Mendoza", "Diaz",
                "Silva", "Gutierrez", "Vega", "Cruz", "Ortega");

        List<String> apellidosMaternos = Arrays.asList("Andrade", "Reyes", "Torres", "Flores", "Ramos",
                "Jimenez", "Aguilar", "Soto", "Alvarez", "Ruiz",
                "Castillo", "Romero", "Salazar", "Mora", "Herrera",
                "Pineda", "Navarro", "Montoya", "Valdez", "Serrano");

        List<String> prefix = Arrays.asList("6441", "6442", "6444");

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        for (int i = 0; i < 20; i++) {
            String nombre = nombres.get(i);
            String apellidoPaterno = apellidosPaternos.get(i);
            String apellidoMaterno = apellidosMaternos.get(i);
            String telefono = prefix.get(i % prefix.size()) + "392630" + (i % 10);

            Cliente cliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, Encriptacion.encriptar(telefono));

            entityManager.persist(cliente);

        }
        transaction.commit();
        entityManager.close();
    }

    // Método para obtener un cliente por ID
    public Cliente obtenerClientePorId(int id) throws PersistenciaException {
        try {
            return entityManager.find(Cliente.class, id); // Encontrar cliente por ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo encontrar el cliente en la base de datos por id: " + id);
        }
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() throws PersistenciaException {
        try {
            return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList(); // Consulta para obtener todos los clientes
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo encontrar el cliente en la base de datos por id: ");
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
