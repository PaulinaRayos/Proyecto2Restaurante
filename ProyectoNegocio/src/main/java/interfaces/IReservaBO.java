/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ReservaDTO;
import java.util.List;

/**
 *
 * @author pauli
 */
public interface IReservaBO {

    boolean actualizarReserva(ReservaDTO reservaDTO) throws Exception;

    boolean cancelarReserva(int idReserva) throws Exception;

    boolean crearReserva(ReservaDTO reservaDTO) throws Exception;

    List<ReservaDTO> obtenerReservasPorCliente(int idCliente) throws Exception;
    

    
    
}
