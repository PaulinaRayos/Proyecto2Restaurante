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
public interface IAgregarReservaBO {

    void actualizarReserva(ReservaDTO reservaDTO) throws Exception;



    void agregarReserva(ReservaDTO reservaDTO) throws Exception;

    List<ReservaDTO> obtenerReservasPorCliente(Long idCliente) throws Exception;
    

    
    
}
