/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.Reserva;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Reserva. Proporciona métodos para realizar operaciones de creación, lectura,
 * actualización y eliminación (CRUD) de reservas en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IReservaDAO {

    // Método para actualizar una reserva
    void actualizarReserva(Reserva reserva) throws PersistenciaException;

    // Método para agregar una reserva
    void agregarReserva(Reserva reserva) throws PersistenciaException;

    // Método para cerrar el EntityManager y EntityManagerFactory
    void cerrar() throws PersistenciaException;

    // Método para eliminar una reserva por ID
    void eliminarReserva(int id) throws PersistenciaException;

    // Método para obtener una reserva por ID
    Reserva obtenerReservaPorId(int id) throws PersistenciaException;

    // Método para obtener reservas por estado
    List<Reserva> obtenerReservasPorEstado(String estado) throws PersistenciaException;

    // Método para obtener todas las reservas
    List<Reserva> obtenerTodasLasReservas() throws PersistenciaException;

}
