
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;


import dao.ReservaDAO;
import dto.ReservaDTO;
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
public class ReservaBO implements IReservaBO{
  
    private final IReservaDAO reservaDAO;
    private final IMesaDAO mesaDAO;
    private final IClienteDAO clienteDAO;
    
    public ReservaBO(IReservaDAO reservaDAO, IMesaDAO mesaDAO, IClienteDAO clienteDAO) {
        this.reservaDAO = reservaDAO;
        this.mesaDAO = mesaDAO;
        this.clienteDAO = clienteDAO;
    }
    
        public boolean crearReserva(ReservaDTO reservaDTO) throws Exception {
             if (reservaDTO == null || reservaDTO.getFechaHora() == null || reservaDTO.getNumeroPersonas() <= 0) {
        throw new IllegalArgumentException("Los datos de la reserva son inválidos.");
    }
             ReservaDAO reservaDAO = new ReservaDAO();
    try {
        // Crear objeto de reserva a partir de DTO
        Reserva reserva = new Reserva();
        reserva.setFechaHora(reservaDTO.getFechaHora());
        reserva.setNumPersonas(reservaDTO.getNumeroPersonas());
        reserva.setCosto(reservaDTO.getCosto()); // Suponiendo que tienes un costo calculado
        reserva.setEstado("Pendiente"); // Estado inicial de la reserva
        reserva.setCliente(reservaDTO.getIdCliente()); // ID del cliente
        reserva.setMesa(reservaDTO.getIdMesa()); // ID de la mesa

        // Llama al método del DAO para crear la reserva
        boolean resultado = reservaDAO.crearReserva(reserva);
            
              // Retorna el resultado
        return resultado;
    } catch (Exception e) {
        // Manejo de excepciones
        throw new Exception("Error al crear la reserva: " + e.getMessage(), e);
    }


    }
        
            public boolean actualizarReserva(ReservaDTO reservaDTO) throws Exception {

        return false;

    }
            
             public boolean cancelarReserva(int idReserva) throws Exception {
        
        return false;
        
    }  
                 public List<ReservaDTO> obtenerReservasPorCliente(int idCliente) throws Exception {

        return null;

    }
  
}
