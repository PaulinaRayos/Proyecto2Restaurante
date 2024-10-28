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
 *
 * @author Chris
 */
public class ClienteBO implements IClienteBO {

    private final IConexion conexion;
    private IClienteDAO cdao;

    public ClienteBO() {
        this.conexion = new Conexion();
        this.cdao = new ClienteDAO(conexion);
    }

    @Override
    public void insercionMasiva() throws NegocioException {
        try {
            this.cdao.insercionMasiva();
        } catch (PersistenciaException e) {
            throw new NegocioException("No se ha podido realizar la insercion masiva.");
        }
    }

    // Método para obtener los nombres completos de los clientes desde la capa de negocio
    public List<Object[]> obtenerNombresYTelefonosDeClientes() throws NegocioException {
        try {
            return cdao.obtenerNombresYTelefonosDeClientes();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los nombres y teléfonos de los clientes", e);
        }
    }

    public Long obtenerIdClientePorNombre(String nombreCompleto) throws NegocioException {
        try {
            return cdao.obtenerIdClientePorNombre(nombreCompleto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo obtener el id del cliente por el nombre: " + nombreCompleto);
        }
    }

    public ClienteDTO obtenerClientePorId(Long id) throws NegocioException {
        try {
            Cliente cliente = cdao.obtenerClientePorId(id);
            return mapearClienteAClienteDTO(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener el id del cliente: " + id);
        }
    }

    public ClienteDTO obtenerClientePorNombre(String nombreCompleto) {
        Cliente cliente = cdao.obtenerClientePorNombre(nombreCompleto);
        if (cliente != null) {
            return ConvertidorGeneral.convertidoraDTO(cliente, ClienteDTO.class);
        } else {
            return null;  // Cliente no encontrado
        }
    }

    public List<String> obtenerTelefonosDesencriptados() throws NegocioException {
        try {
            return cdao.obtenerTelefonosDesencriptados();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los teléfonos de los clientes: " + e.getMessage(), e);
        }

    }

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
