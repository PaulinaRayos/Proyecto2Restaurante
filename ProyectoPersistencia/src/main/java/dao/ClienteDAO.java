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
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import recursos.Encriptacion;

/**
 * Interfaz que define los métodos para el acceso a datos de la entidad Cliente.
 * Proporciona operaciones para crear, leer, actualizar y eliminar clientes en
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public class ClienteDAO implements IClienteDAO {

    private final IConexion conexion;

    /**
     * Constructor de la clase ClienteDAO.
     *
     * @param conexion Objeto que proporciona la conexión a la base de datos.
     */
    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param cliente El cliente a agregar.
     * @throws PersistenciaException Si ocurre un error al intentar agregar el
     * cliente.
     */
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
        } finally {
            em.close();
        }
    }

    /**
     * Realiza una inserción masiva de clientes en la base de datos con datos
     * predefinidos.
     *
     * @throws PersistenciaException Si ocurre un error al intentar realizar la
     * inserción masiva.
     */
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

    /**
     * Obtiene un cliente por su ID.
     *
     * @param id El ID del cliente a buscar.
     * @return El cliente correspondiente al ID proporcionado, o null si no se
     * encuentra.
     * @throws PersistenciaException Si ocurre un error al intentar buscar el
     * cliente.
     */
    public Cliente obtenerClientePorId(Long id) throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.find(Cliente.class, id); // Encontrar cliente por ID
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo encontrar el cliente en la base de datos por id: " + id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene todos los clientes de la base de datos.
     *
     * @return Una lista de todos los clientes.
     * @throws PersistenciaException Si ocurre un error al intentar obtener los
     * clientes.
     */
    public List<Cliente> obtenerTodosLosClientes() throws PersistenciaException {
        EntityManager em = this.conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList(); // Consulta para obtener todos los clientes
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo encontrar el cliente en la base de datos por id: ");
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el ID de un cliente dado su nombre completo.
     *
     * @param nombreCompleto El nombre completo del cliente.
     * @return El ID del cliente, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error al intentar obtener el
     * ID.
     */
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

    /**
     * Obtiene los nombres completos y los teléfonos de todos los clientes.
     *
     * @return Una lista de arreglos de objetos, donde cada arreglo contiene el
     * nombre completo y el teléfono desencriptado de un cliente.
     * @throws PersistenciaException Si ocurre un error al intentar obtener los
     * nombres y teléfonos.
     */
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

    /**
     * Obtiene el cliente por medio de su nombre completo
     *
     * @param nombreCompleto el nombre del cliente a encontrar
     * @return El resultado de la busqueda
     */
    public Cliente obtenerClientePorNombre(String nombreCompleto) {
        EntityManager em = this.conexion.crearConexion();
        try {
            TypedQuery<Cliente> query = em.createQuery(
                    "SELECT c FROM Cliente c WHERE CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', c.apellidoMaterno) = :nombreCompleto", Cliente.class);
            query.setParameter("nombreCompleto", nombreCompleto);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;  // Cliente no encontrado
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
