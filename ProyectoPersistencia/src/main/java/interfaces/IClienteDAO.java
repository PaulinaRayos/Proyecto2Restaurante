/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ClienteDTO;
import entidadesJPA.Cliente;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Cliente. Proporciona métodos para realizar operaciones de creación, lectura,
 * actualización y eliminación (CRUD) de clientes en la base de datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public interface IClienteDAO {

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param cliente El cliente a agregar.
     * @throws PersistenciaException Si ocurre un error al intentar agregar el
     * cliente.
     */
    void agregarCliente(Cliente cliente) throws PersistenciaException;

    /**
     * Cierra el EntityManager si está abierto.
     */
    void cerrar();

    /**
     * Realiza una inserción masiva de clientes en la base de datos con datos
     * predefinidos.
     *
     * @throws PersistenciaException Si ocurre un error al intentar realizar la
     * inserción masiva.
     */
    void insercionMasiva() throws PersistenciaException;

    /**
     * Obtiene un cliente por su ID.
     *
     * @param id El ID del cliente a buscar.
     * @return El cliente correspondiente al ID proporcionado, o null si no se
     * encuentra.
     * @throws PersistenciaException Si ocurre un error al intentar buscar el
     * cliente.
     */
    Cliente obtenerClientePorId(Long id) throws PersistenciaException;

    /**
     * Obtiene el ID de un cliente dado su nombre completo.
     *
     * @param nombreCompleto El nombre completo del cliente.
     * @return El ID del cliente, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error al intentar obtener el
     * ID.
     */
    Long obtenerIdClientePorNombre(String nombreCompleto) throws PersistenciaException;

    /**
     * Obtiene los nombres completos y los teléfonos de todos los clientes.
     *
     * @return Una lista de arreglos de objetos, donde cada arreglo contiene el
     * nombre completo y el teléfono desencriptado de un cliente.
     * @throws PersistenciaException Si ocurre un error al intentar obtener los
     * nombres y teléfonos.
     */
    List<Object[]> obtenerNombresYTelefonosDeClientes() throws PersistenciaException;

    /**
     * Obtiene todos los clientes de la base de datos.
     *
     * @return Una lista de todos los clientes.
     * @throws PersistenciaException Si ocurre un error al intentar obtener los
     * clientes.
     */
    List<Cliente> obtenerTodosLosClientes() throws PersistenciaException;

    /**
     * Obtiene el cliente por medio de su nombre completo
     *
     * @param nombreCompleto el nombre del cliente a encontrar
     * @return El resultado de la busqueda
     */
    Cliente obtenerClientePorNombre(String nombreCompleto);

    /**
     * Obtiene los telefonos desencriptados de los clientes
     *
     * @return La lista de los telefonos desencriptados
     * @throws PersistenciaException Si ocurre un error al obtener los telefonos
     * desencriptados
     */
    List<String> obtenerTelefonosDesencriptados() throws PersistenciaException;

    /**
     * Obtiene todos los clientes con su telefono desencriptado
     *
     * @return La lista de los clientes con sus telefonos desencriptados
     * @throws PersistenciaException Si ocurre un error al obtener todos los
     * clientes con su telefono desencriptado
     */
    List<ClienteDTO> obtenerTodosLosClientesConTelefonoDesencriptado() throws PersistenciaException;

}
