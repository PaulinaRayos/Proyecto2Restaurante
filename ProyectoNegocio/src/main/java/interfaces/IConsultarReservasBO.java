/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ReservaDTO;
import entidadesJPA.Reserva;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los métodos para consultar reservas en el sistema.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IConsultarReservasBO {

    /**
     * Método para obtener todas las reservas junto con la información del
     * cliente asociado.
     *
     * @return Lista de objetos ReservaDTO que contienen información de reservas
     * y clientes.
     * @throws Exception Si ocurre un error al obtener las reservas con los
     * clientes.
     */
    List<ReservaDTO> obtenerReservasConClientes() throws Exception;

    /**
     * Método para obtener todas las reservas del sistema y convertirlas en
     * objetos ReservaDTO.
     *
     * @return Lista de objetos ReservaDTO que representan todas las reservas.
     * @throws Exception Si ocurre un error al obtener las reservas desde la
     * capa de persistencia.
     */
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

    // Método para obtener la reserva activa del cliente
    Reserva obtenerReservaActiva(Long idCliente, Long idRestaurante) throws PersistenciaException;

    List<Reserva> obtenerReservasActivasPorClienteYRestaurante(Long idCliente, Long idRestaurante);

}
