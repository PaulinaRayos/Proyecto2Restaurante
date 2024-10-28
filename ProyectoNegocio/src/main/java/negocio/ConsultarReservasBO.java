/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.ClienteDAO;
import dao.MesaDAO;
import dao.ReservaDAO;
import dto.ReservaDTO;
import entidadesJPA.Cliente;
import entidadesJPA.Reserva;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import interfaces.IConsultarReservasBO;
import interfaces.IMesaDAO;
import interfaces.IReservaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pauli
 */
public class ConsultarReservasBO implements IConsultarReservasBO {

    private final IConexion conexion;
    private final IReservaDAO reservaDAO;
    private final IMesaDAO mesaDAO;
    private final IClienteDAO clienteDAO;

    public ConsultarReservasBO() {
        this.conexion = new Conexion();
        this.reservaDAO = new ReservaDAO(conexion);
        this.mesaDAO = new MesaDAO(conexion);
        this.clienteDAO = new ClienteDAO(conexion);
    }

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
                reservaDTO.setNumeroPersonas(reserva.getNumPersonas());
                reservaDTO.setEstado(reserva.getEstado());
                reservaDTO.setIdMesa(reserva.getMesa().getId());
                reservaDTO.setIdCliente(reserva.getCliente().getId()); // Suponiendo que tienes acceso al cliente

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
                reservaDTO.setIdCliente(reserva.getCliente().getId()); // Suponiendo que tienes acceso al cliente

                return reservaDTO;
            } else {
                throw new PersistenciaException("No se encontró la reserva con id: " + idReserva);
            }
        } catch (PersistenciaException e) {
            // Manejo adicional de la excepción, si es necesario
            throw new PersistenciaException("Error al obtener la reserva con id: " + idReserva, e);
        }
    }
}
