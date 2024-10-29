/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.ClienteDAO;
import dao.ReservaDAO;
import dto.ReservaDTO;
import entidadesJPA.Cliente;
import entidadesJPA.Reserva;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import interfaces.IConsultarReservasBO;
import interfaces.IReservaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la lógica de negocio para consultar reservas en el
 * sistema. Proporciona métodos para obtener información sobre reservas junto
 * con los datos de los clientes asociados.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ConsultarReservasBO implements IConsultarReservasBO {

    private final IConexion conexion; // Conexión a la base de datos
    private final IReservaDAO reservaDAO; // DAO para manejar reservas
    private final IClienteDAO clienteDAO; // DAO para manejar clientes

    /**
     * Constructor de la clase ConsultarReservasBO. Inicializa las conexiones y
     * los DAOs necesarios.
     */
    public ConsultarReservasBO() {
        this.conexion = new Conexion();
        this.reservaDAO = new ReservaDAO(conexion);
        this.clienteDAO = new ClienteDAO(conexion);
    }

    /**
     * Método para obtener todas las reservas junto con la información del
     * cliente asociado.
     *
     * @return Lista de objetos ReservaDTO que contienen información de reservas
     * y clientes.
     * @throws Exception Si ocurre un error al obtener las reservas con los
     * clientes.
     */
    @Override
    public List<ReservaDTO> obtenerReservasConClientes() throws Exception {
        try {
            List<Reserva> reservas = reservaDAO.obtenerTodasLasReservas();
            List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
            List<ReservaDTO> reservasConClientes = new ArrayList<>();

            for (Reserva reserva : reservas) {
                // Crear un DTO con la información de la reserva
                ReservaDTO reservaDTO = new ReservaDTO();
                reservaDTO.setIdReserva(reserva.getId());
                reservaDTO.setFechaHora(reserva.getFechaHora());
                reservaDTO.setNumeroPersonas(reserva.getNumPersonas());
                reservaDTO.setEstado(reserva.getEstado());
                reservaDTO.setIdMesa(reserva.getMesa().getId());
                // Suponiendo que tienes un método para obtener el cliente por ID
                Cliente cliente = clienteDAO.obtenerClientePorId(reserva.getCliente().getId());
                if (cliente != null) {
                    // Setear información del cliente en el DTO, si es necesario
                    reservaDTO.setIdCliente(cliente.getId());
                }
                reservasConClientes.add(reservaDTO);
            }
            return reservasConClientes;
        } catch (PersistenciaException e) {
            throw new Exception("Error al obtener reservas con clientes: " + e.getMessage(), e);
        }
    }

    /**
     * Método para obtener todas las reservas del sistema y convertirlas en
     * objetos ReservaDTO.
     *
     * @return Lista de objetos ReservaDTO que representan todas las reservas.
     * @throws Exception Si ocurre un error al obtener las reservas desde la
     * capa de persistencia.
     */
    @Override
    public List<ReservaDTO> obtenerTodasLasReservas() throws Exception {
        try {
            // Llama al DAO para obtener todas las reservas
            List<Reserva> reservas = reservaDAO.obtenerTodasLasReservas();
            List<ReservaDTO> reservasDTO = new ArrayList<>();

            // Convertir cada Reserva a ReservaDTO
            for (Reserva reserva : reservas) {
                ReservaDTO reservaDTO = new ReservaDTO();
                reservaDTO.setIdReserva(reserva.getId());
                reservaDTO.setFechaHora(reserva.getFechaHora());
                reservaDTO.setFechaCancelacion(reserva.getFechaCancelacion());
                reservaDTO.setFechaHoraCreada(reserva.getFechaHoraCreada());
                reservaDTO.setNumeroPersonas(reserva.getNumPersonas());
                reservaDTO.setEstado(reserva.getEstado());
                reservaDTO.setCosto(reserva.getCosto());
                reservaDTO.setMulta(reserva.getMulta());
                reservaDTO.setIdMesa(reserva.getMesa().getId());
                reservaDTO.setIdCliente(reserva.getCliente().getId());

                // Agregar el DTO a la lista
                reservasDTO.add(reservaDTO);
            }
            return reservasDTO;
        } catch (PersistenciaException e) {
            throw new Exception("Error al obtener todas las reservas: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene el estado de una reserva por su ID.
     *
     * @param idReserva El ID de la reserva a buscar.
     * @return El estado de la reserva.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public String obtenerEstadoReservaPorId(Long idReserva) throws PersistenciaException {
        try {
            return reservaDAO.obtenerEstadoReservaPorId(idReserva);
        } catch (PersistenciaException e) {
            // Manejo adicional de la excepción, si es necesario
            throw new PersistenciaException("Error al obtener el estado de la reserva con id: " + idReserva, e);
        }
    }

    /**
     * Obtiene una reserva por su ID.
     *
     * @param idReserva El ID de la reserva a buscar.
     * @return Un objeto ReservaDTO que representa la reserva.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    @Override
    public ReservaDTO obtenerReservaPorId(Long idReserva) throws PersistenciaException {
        try {
            // Llama al DAO para obtener la reserva
            Reserva reserva = reservaDAO.obtenerReservaPorId(idReserva);
            if (reserva != null) {
                // Convertir Reserva a ReservaDTO
                ReservaDTO reservaDTO = new ReservaDTO();
                reservaDTO.setIdReserva(reserva.getId());
                reservaDTO.setFechaHora(reserva.getFechaHora());
                reservaDTO.setNumeroPersonas(reserva.getNumPersonas());
                reservaDTO.setEstado(reserva.getEstado());
                reservaDTO.setIdMesa(reserva.getMesa().getId());
                reservaDTO.setIdCliente(reserva.getCliente().getId());
                reservaDTO.setCosto(reserva.getCosto());
                reservaDTO.setFechaHoraCreada(reserva.getFechaHoraCreada());
                reservaDTO.setMulta(reserva.getMulta());
                reservaDTO.setFechaCancelacion(reserva.getFechaCancelacion());

                return reservaDTO;
            } else {
                throw new PersistenciaException("No se encontró la reserva con id: " + idReserva);
            }
        } catch (PersistenciaException e) {
            // Manejo adicional de la excepción, si es necesario
            throw new PersistenciaException("Error al obtener la reserva con id: " + idReserva, e);
        }
    }



    public List<Reserva> obtenerReservasActivasPorClienteYRestaurante(Long idCliente, Long idRestaurante) {
        return reservaDAO.obtenerReservasActivasPorClienteYRestaurante(idCliente, idRestaurante);
    }

    @Override
    public Reserva obtenerReservaActiva(Long idCliente, Long idRestaurante) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
