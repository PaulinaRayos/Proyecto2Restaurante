/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ReservaDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author pauli
 */
public interface IConsultarReservasBO {

    List<ReservaDTO> obtenerReservasConClientes() throws Exception;

    List<ReservaDTO> obtenerTodasLasReservas() throws Exception;

    /**
     * Obtiene el estado de una reserva por su ID.
     *
     * @param idReserva El ID de la reserva a buscar.
     * @return El estado de la reserva.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    String obtenerEstadoReservaPorId(Long idReserva) throws PersistenciaException;

    /**
     * Obtiene una reserva por su ID.
     *
     * @param idReserva El ID de la reserva a buscar.
     * @return Un objeto ReservaDTO que representa la reserva.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    ReservaDTO obtenerReservaPorId(Long idReserva) throws PersistenciaException;
    
}
