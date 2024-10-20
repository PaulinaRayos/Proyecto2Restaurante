/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidadesJPA.HistorialReservas;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * HistorialReservas. Proporciona métodos para realizar operaciones de creación,
 * lectura, actualización y eliminación (CRUD) de registros de historial de
 * reservas en la base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface IHistorialReservasDAO {

    // Método para actualizar un historial de reserva
    void actualizarHistorialReservas(HistorialReservas historialReservas);

    // Método para agregar un historial de reserva
    void agregarHistorialReservas(HistorialReservas historialReservas);

    // Método para cerrar el EntityManager y EntityManagerFactory
    void cerrar();

    // Método para eliminar un historial de reserva
    void eliminarHistorialReservas(int id);

    // Método para obtener un historial de reserva por ID
    HistorialReservas obtenerHistorialReservasPorId(int id);

    // Método para obtener todos los historiales de reserva
    List<HistorialReservas> obtenerTodosLosHistorialesReservas();

}