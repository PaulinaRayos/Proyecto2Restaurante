
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
import entidadesJPA.Mesa;
import entidadesJPA.Reserva;
import interfaces.IMesaDAO;
import interfaces.IClienteDAO;
import interfaces.IReservaDAO;
import java.util.List;
import interfaces.IAgregarReservaBO;

/**
 *
 * @author pauli
 */
public class AgregarReservaBO implements IAgregarReservaBO {

    private final IConexion conexion;
    private final IReservaDAO reservaDAO;
    private final IMesaDAO mesaDAO;
    private final IClienteDAO clienteDAO;

    public AgregarReservaBO() {
        this.conexion = new Conexion();
        this.reservaDAO = new ReservaDAO(conexion);
        this.mesaDAO = new MesaDAO(conexion);
        this.clienteDAO = new ClienteDAO(conexion);
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

    @Override
    public void actualizarReserva(ReservaDTO reservaDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public List<ReservaDTO> obtenerReservasPorCliente(Long idCliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
