/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Reserva;
import excepciones.PersistenciaException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Reserva. Proporciona métodos para realizar operaciones de creación, lectura,
 * actualización y eliminación (CRUD) de reservas en la base de datos.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
public interface IReservaDAO {

    /**
     * Actualiza una reserva existente en la base de datos.
     *
     * @param reserva La reserva a actualizar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void actualizarReserva(Reserva reserva) throws PersistenciaException;

    /**
     * Agrega una nueva reserva a la base de datos.
     *
     * @param reserva La reserva a agregar.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    void agregarReserva(Reserva reserva) throws PersistenciaException;

    /**
     * Cierra el EntityManager si está abierto.
     */
    void cerrar();

    /**
     * Obtiene una reserva por su ID.
     *
     * @param id El ID de la reserva a buscar.
     * @return La reserva correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    Reserva obtenerReservaPorId(Long id) throws PersistenciaException;

    /**
     * Obtiene reservas de la base de datos que coinciden con el estado
     * proporcionado.
     *
     * @param estado El estado de las reservas a buscar.
     * @return Una lista de reservas que coinciden con el estado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    List<Reserva> obtenerReservasPorEstado(String estado) throws PersistenciaException;

    /**
     * Obtiene todas las reservas de la base de datos.
     *
     * @return Una lista de todas las reservas.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    List<Reserva> obtenerTodasLasReservas() throws PersistenciaException;

    /**
     * Obtiene el estado de una reserva por su ID.
     *
     * @param id El ID de la reserva a buscar.
     * @return El estado de la reserva correspondiente al ID proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    String obtenerEstadoReservaPorId(Long id) throws PersistenciaException;

    /**
     * Cancela una reserva específica, actualizando su estado y aplicando una
     * multa si es necesario.
     *
     * @param idReserva el ID de la reserva a cancelar
     * @param fechaCancelacion la fecha en que se realiza la cancelación
     * @param multa la multa a aplicar por la cancelación de la reserva
     * @throws PersistenciaException si ocurre un error al cancelar la reserva
     */
    void cancelarReserva(Long idReserva, Date fechaCancelacion, BigDecimal multa) throws PersistenciaException;

}
