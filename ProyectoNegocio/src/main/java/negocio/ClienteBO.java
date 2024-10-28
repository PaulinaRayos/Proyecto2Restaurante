/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import conversiones.ConvertidorGeneral;
import dao.ClienteDAO;
import dto.ClienteDTO;
import entidadesJPA.Cliente;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IClienteBO;
import interfaces.IClienteDAO;
import java.util.ArrayList;
import java.util.List;
import recursos.Encriptacion;

/**
 * Clase que implementa la lógica de negocio para las operaciones relacionadas
 * con los clientes. Esta clase se encarga de gestionar la inserción masiva de
 * clientes en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ClienteBO implements IClienteBO {

    private final IConexion conexion; // Interfaz para la conexión a la base de datos
    private final IClienteDAO cdao; // Interfaz para las operaciones de cliente

    /**
     * Constructor de la clase ClienteBO. Inicializa las interfaces necesarias
     * para la conexión y el acceso a los datos de clientes.
     */
    public ClienteBO() {
        this.conexion = new Conexion();
        this.cdao = new ClienteDAO(conexion);
    }

    /**
     * Método para realizar una inserción masiva de clientes en la base de
     * datos. Llama al método correspondiente en el DAO para llevar a cabo la
     * operación.
     *
     * @throws NegocioException Si ocurre un error durante la inserción masiva
     * de clientes.
     */
    @Override
    public void insercionMasiva() throws NegocioException {
        try {
            this.cdao.insercionMasiva(); // Llamada al método del DAO
        } catch (PersistenciaException e) {
            // Manejo de excepción si la inserción falla
            throw new NegocioException("No se ha podido realizar la insercion masiva.");
        }
    }

    /**
     * Método para obtener los nombres completos y teléfonos de los clientes
     * desde la capa de negocio.
     *
     * @return Lista de objetos que contienen nombres y teléfonos de los
     * clientes.
     * @throws NegocioException Si ocurre un error al obtener la información.
     */
    @Override
    public List<Object[]> obtenerNombresYTelefonosDeClientes() throws NegocioException {
        try {
            return cdao.obtenerNombresYTelefonosDeClientes();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los nombres y teléfonos de los clientes", e);
        }
    }

    /**
     * Método para obtener el ID de un cliente a partir de su nombre completo.
     *
     * @param nombreCompleto Nombre completo del cliente.
     * @return ID del cliente correspondiente.
     * @throws NegocioException Si ocurre un error al obtener el ID del cliente.
     */
    @Override
    public Long obtenerIdClientePorNombre(String nombreCompleto) throws NegocioException {
        try {
            return cdao.obtenerIdClientePorNombre(nombreCompleto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo obtener el id del cliente por el nombre: " + nombreCompleto);
        }
    }

    /**
     * Método para obtener un cliente por su ID y mapearlo a un objeto
     * ClienteDTO.
     *
     * @param id ID del cliente a buscar.
     * @return Objeto ClienteDTO que representa al cliente encontrado.
     * @throws NegocioException Si ocurre un error al obtener el cliente.
     */
    @Override
    public ClienteDTO obtenerClientePorId(Long id) throws NegocioException {
        try {
            Cliente cliente = cdao.obtenerClientePorId(id);
            return mapearClienteAClienteDTO(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener el id del cliente: " + id);
        }
    }

    /**
     * Método para obtener un cliente a partir de su nombre completo.
     *
     * @param nombreCompleto Nombre completo del cliente a buscar.
     * @return Objeto ClienteDTO correspondiente al cliente encontrado, o null
     * si no se encuentra.
     */
    @Override
    public ClienteDTO obtenerClientePorNombre(String nombreCompleto) {
        Cliente cliente = cdao.obtenerClientePorNombre(nombreCompleto);
        if (cliente != null) {
            return ConvertidorGeneral.convertidoraDTO(cliente, ClienteDTO.class);
        } else {
            return null;  // Cliente no encontrado
        }
    }

    /**
     * Método para obtener una lista de teléfonos de clientes desencriptados.
     *
     * @return Lista de teléfonos desencriptados de los clientes.
     * @throws NegocioException Si ocurre un error al obtener los teléfonos.
     */
    @Override
    public List<String> obtenerTelefonosDesencriptados() throws NegocioException {
        try {
            return cdao.obtenerTelefonosDesencriptados();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los teléfonos de los clientes: " + e.getMessage(), e);
        }

    }

    /**
     * Método para obtener todos los clientes en la base de datos.
     *
     * @return Lista de objetos ClienteDTO que representan a todos los clientes.
     * @throws NegocioException Si ocurre un error al obtener la lista de
     * clientes.
     */
    @Override
    public List<ClienteDTO> obtenerTodosLosClientes() throws NegocioException {
        try {
            List<Cliente> clientes = cdao.obtenerTodosLosClientes();
            // Convertir la lista de Cliente a ClienteDTO
            List<ClienteDTO> clientesDTO = new ArrayList<>();
            for (Cliente cliente : clientes) {
                clientesDTO.add(ConvertidorGeneral.convertidoraDTO(cliente, ClienteDTO.class));
            }
            return clientesDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener todos los clientes", e);
        }
    }

    /**
     * Método para obtener todos los clientes junto con sus teléfonos
     * desencriptados.
     *
     * @return Lista de objetos ClienteDTO que representan a todos los clientes
     * con su información y teléfonos desencriptados.
     * @throws NegocioException Si ocurre un error al obtener los clientes.
     */
    @Override
    public List<ClienteDTO> obtenerTodosLosClientesConTelefonoDesencriptado() throws NegocioException {
        try {
            List<Cliente> clientes = cdao.obtenerTodosLosClientes();
            List<ClienteDTO> clientesDTO = new ArrayList<>();

            for (Cliente cliente : clientes) {
                String telefonoDesencriptado = Encriptacion.decriptar(cliente.getTelefono());
                ClienteDTO clienteDTO = new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), telefonoDesencriptado);
                clientesDTO.add(clienteDTO);
            }

            return clientesDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los clientes desencriptados", e);
        }
    }

    /**
     * Método para mapear un objeto Cliente a un objeto ClienteDTO.
     *
     * @param cliente Objeto Cliente que se desea mapear.
     * @return Objeto ClienteDTO correspondiente al cliente, o null si el
     * cliente es nulo.
     */
    public ClienteDTO mapearClienteAClienteDTO(Cliente cliente) {
        if (cliente == null) {
            return null; // Retorna null si el cliente es nulo
        }

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(cliente.getId()); // Mapea el ID
        clienteDTO.setNombre(cliente.getNombre()); // Mapea el nombre
        clienteDTO.setApellidoPaterno(cliente.getApellidoPaterno()); // Mapea el apellido paterno
        clienteDTO.setApellidoMaterno(cliente.getApellidoMaterno()); // Mapea el apellido materno
        clienteDTO.setTelefono(cliente.getTelefono()); // Mapea el teléfono

        return clienteDTO; // Retorna el objeto mapeado
    }
}
