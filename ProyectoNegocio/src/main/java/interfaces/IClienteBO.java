/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ClienteDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio relacionadas con el cliente.
 * Proporciona métodos para manejar las operaciones CRUD y consultas de
 * clientes.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IClienteBO {

    /**
     * Método para realizar una inserción masiva de clientes en la base de
     * datos. Llama al método correspondiente en el DAO para llevar a cabo la
     * operación.
     *
     * @throws NegocioException Si ocurre un error durante la inserción masiva
     * de clientes.
     */
    public void insercionMasiva() throws NegocioException;

    /**
     * Método para obtener los nombres completos y teléfonos de los clientes
     * desde la capa de negocio.
     *
     * @return Lista de objetos que contienen nombres y teléfonos de los
     * clientes.
     * @throws NegocioException Si ocurre un error al obtener la información.
     */
    public List<Object[]> obtenerNombresYTelefonosDeClientes() throws NegocioException;

    /**
     * Método para obtener el ID de un cliente a partir de su nombre completo.
     *
     * @param nombreCompleto Nombre completo del cliente.
     * @return ID del cliente correspondiente.
     * @throws NegocioException Si ocurre un error al obtener el ID del cliente.
     */
    public Long obtenerIdClientePorNombre(String nombreCompleto) throws NegocioException;

    /**
     * Método para obtener un cliente por su ID y mapearlo a un objeto
     * ClienteDTO.
     *
     * @param id ID del cliente a buscar.
     * @return Objeto ClienteDTO que representa al cliente encontrado.
     * @throws NegocioException Si ocurre un error al obtener el cliente.
     */
    public ClienteDTO obtenerClientePorId(Long id) throws NegocioException;

    /**
     * Método para obtener un cliente a partir de su nombre completo.
     *
     * @param nombreCompleto Nombre completo del cliente a buscar.
     * @return Objeto ClienteDTO correspondiente al cliente encontrado, o null
     * si no se encuentra.
     */
    public ClienteDTO obtenerClientePorNombre(String nombreCompleto);

    /**
     * Método para obtener una lista de teléfonos de clientes desencriptados.
     *
     * @return Lista de teléfonos desencriptados de los clientes.
     * @throws NegocioException Si ocurre un error al obtener los teléfonos.
     */
    public List<String> obtenerTelefonosDesencriptados() throws NegocioException;

    /**
     * Método para obtener todos los clientes en la base de datos.
     *
     * @return Lista de objetos ClienteDTO que representan a todos los clientes.
     * @throws NegocioException Si ocurre un error al obtener la lista de
     * clientes.
     */
    public List<ClienteDTO> obtenerTodosLosClientes() throws NegocioException;

    /**
     * Método para obtener todos los clientes junto con sus teléfonos
     * desencriptados.
     *
     * @return Lista de objetos ClienteDTO que representan a todos los clientes
     * con su información y teléfonos desencriptados.
     * @throws NegocioException Si ocurre un error al obtener los clientes.
     */
    public List<ClienteDTO> obtenerTodosLosClientesConTelefonoDesencriptado() throws NegocioException;

}
