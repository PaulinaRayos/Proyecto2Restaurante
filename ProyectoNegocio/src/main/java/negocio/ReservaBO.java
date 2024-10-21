
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.ReservaDAO;
import dto.ReservaDTO;
import entidadesJPA.Cliente;
import entidadesJPA.Mesa;
import entidadesJPA.Reserva;
import interfaces.IMesaDAO;
import interfaces.IClienteDAO;
import interfaces.IReservaBO;
import interfaces.IReservaDAO;
import java.util.List;

/**
 *
 * @author pauli
 */
public class ReservaBO implements IReservaBO {

    private final IReservaDAO reservaDAO;
    private final IMesaDAO mesaDAO;
    private final IClienteDAO clienteDAO;

    public ReservaBO(IReservaDAO reservaDAO, IMesaDAO mesaDAO, IClienteDAO clienteDAO) {
        this.reservaDAO = reservaDAO;
        this.mesaDAO = mesaDAO;
        this.clienteDAO = clienteDAO;
    }

    public void agregarReserva(ReservaDTO reservaDTO) throws Exception {

        if (reservaDTO.getIdCliente() == null || reservaDTO.getIdMesa() == null) {
            throw new IllegalArgumentException("El ID del cliente y la mesa no pueden ser nulos.");
        }

        // Crear objeto de reserva a partir de DTO
        Reserva reserva = new Reserva();
        reserva.setFechaHora(reservaDTO.getFechaHora());
        reserva.setNumPersonas(reservaDTO.getNumeroPersonas());
        reserva.setCosto(reservaDTO.getCosto()); // Suponiendo que tienes un costo calculado
        reserva.setEstado("Pendiente"); // Estado inicial de la reserva

        // Cargar el cliente desde la base de datos
        Cliente cliente = clienteDAO.obtenerClientePorId(reservaDTO.getIdCliente());
        if (cliente == null) {
            throw new Exception("Cliente no encontrado con ID: " + reservaDTO.getIdCliente());
        }
        reserva.setCliente(cliente); // Asignar el cliente cargado a la reserva

        // Cargar la mesa desde la base de datos
        Mesa mesa = mesaDAO.obtenerMesaPorId(reservaDTO.getIdMesa());
        if (mesa == null) {
            throw new Exception("Mesa no encontrada con ID: " + reservaDTO.getIdMesa());
        }
        reserva.setMesa(mesa); // ID de la mesa

        try {
            // Persistir la reserva usando el DAO
            reservaDAO.agregarReserva(reserva);
        } catch (Exception e) {
            // Manejo de la excepción (puedes propagarla o manejarla según tu lógica)
            System.out.println("Error al crear la reserva: " + e.getMessage());
            throw new Exception("No se pudo crear la reserva.", e);
        }

    }

    public void actualizarReserva(ReservaDTO reservaDTO) throws Exception {
        // Verificar que el ID de la reserva no sea nulo
        if (reservaDTO.getIdReserva() == null) {
            throw new IllegalArgumentException("El ID de la reserva no puede ser nulo.");
        }

        // Buscar la reserva existente en la base de datos
        Reserva reservaExistente = reservaDAO.obtenerReservaPorId(reservaDTO.getIdReserva());
        if (reservaExistente == null) {
            throw new Exception("Reserva no encontrada con ID: " + reservaDTO.getIdReserva());
        }

        // Actualizar los campos de la reserva existente
        reservaExistente.setFechaHora(reservaDTO.getFechaHora());
        reservaExistente.setNumPersonas(reservaDTO.getNumeroPersonas());
        reservaExistente.setCosto(reservaDTO.getCosto()); // Asegúrate de que el costo se calcula correctamente
        reservaExistente.setEstado(reservaDTO.getEstado()); // Si deseas permitir cambiar el estado

        // Cargar la mesa y el cliente solo si sus IDs son diferentes (opcional)
        if (!reservaExistente.getCliente().getId().equals(reservaDTO.getIdCliente())) {
            Cliente cliente = new Cliente();
            cliente.setId(reservaDTO.getIdCliente());
            reservaExistente.setCliente(cliente); // Asignar el nuevo cliente
        }

        // Si deseas permitir la actualización de la mesa, carga la mesa desde la base de datos
        Mesa mesa = mesaDAO.obtenerMesaPorId(reservaDTO.getIdMesa());
        if (mesa == null) {
            throw new Exception("Mesa no encontrada con ID: " + reservaDTO.getIdMesa());
        }
        reservaExistente.setMesa(mesa); // Asignar la mesa

        try {
            // Persistir los cambios usando el DAO
            reservaDAO.actualizarReserva(reservaExistente);
        } catch (Exception e) {
            System.out.println("Error al actualizar la reserva: " + e.getMessage());
            throw new Exception("No se pudo actualizar la reserva.", e);
        }

    }

    public void cancelarReserva(Long idReserva) throws Exception {

    }

    public List<ReservaDTO> obtenerReservasPorCliente(Long idCliente) throws Exception {

        return null;

    }

}
