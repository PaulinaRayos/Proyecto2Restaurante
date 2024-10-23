/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.IConexion;
import entidadesJPA.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

    private final IConexion conexion;

    // Constructor
    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    // Método para agregar un cliente
    public void agregarCliente(Cliente cliente) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            em.getTransaction().begin();

            em.persist(cliente);

            em.getTransaction().commit();

            em.close();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo agregar el cliente a la base de datos: " + e);
        }
    }

    @Override
    public void insercionMasiva() throws PersistenciaException {
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

        EntityManager em = this.conexion.crearConexion();

        try {
            em.getTransaction().begin();

            for (int i = 0; i < 20; i++) {
                String nombre = nombres.get(i);
                String apellidoPaterno = apellidosPaternos.get(i);
                String apellidoMaterno = apellidosMaternos.get(i);
                String telefono = prefix.get(i % prefix.size()) + "392630" + (i % 10);

                Cliente cliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, Encriptacion.encriptar(telefono));

                em.persist(cliente);

            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo realizar la insercion masiva.");
        }

    }

    // Método para obtener un cliente por ID
    public Cliente obtenerClientePorId(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(Cliente.class, id); // Encontrar cliente por ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo encontrar el cliente en la base de datos por id: " + id);
        }
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList(); // Consulta para obtener todos los clientes
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo encontrar el cliente en la base de datos por id: ");
        }
    }

    public Long obtenerIdClientePorNombre(String nombreCompleto) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        Long idCliente = null;

        try {
            String jpql = "SELECT c.id FROM Cliente c WHERE CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', c.apellidoMaterno) = :nombreCompleto";
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            query.setParameter("nombreCompleto", nombreCompleto);

            List<Long> resultados = query.getResultList();
            if (!resultados.isEmpty()) {
                idCliente = resultados.get(0);
            }
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo obtener el id del cliente por el nombre: " + nombreCompleto);
        } finally {
            em.close();
        }
        return idCliente;
    }

    // Método para obtener los nombres completos de todos los clientes
    public List<Object[]> obtenerNombresYTelefonosDeClientes() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            // Consulta JPQL para obtener los nombres concatenados y los teléfonos encriptados
            String jpql = "SELECT CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', c.apellidoMaterno), c.telefono FROM Cliente c";
            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            List<Object[]> clientes = query.getResultList();

            // Desencriptar los teléfonos antes de devolver la lista
            for (Object[] cliente : clientes) {
                String telefonoEncriptado = (String) cliente[1];
                cliente[1] = Encriptacion.decriptar(telefonoEncriptado); // Desencriptar el teléfono
            }

            return clientes;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron obtener los nombres y teléfonos de los clientes.");
        } finally {
            em.close();
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
