/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import conexion.Conexion;
import conexion.IConexion;
import dao.ReservaDAO;
import dto.ReservaDTO;
import entidadesJPA.Reserva;
import interfaces.IReservaDAO;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import negocio.ReservaBO;

/**
 *
 * @author pauli
 */
public class pruebaReservaBO {

    private ReservaBO reservaBO;
    private IConexion conexion;
    private IReservaDAO reservaDAO; // Instancia real del DAO

    public void setUp() {
        // Inicializar las instancias reales de los DAOs
        this.conexion = new Conexion();
        reservaDAO = new ReservaDAO(conexion);
        // Crear una instancia de ReservaBO con los DAOs reales
        reservaBO = new ReservaBO();
    }

    public void testAgregarReserva() throws Exception {
        // Crear un DTO de prueba
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setIdCliente(13L); // ID de un cliente existente en la base de datos
        reservaDTO.setIdMesa(7L); // ID de una mesa existente en la base de datos
        reservaDTO.setFechaHora((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-10-25 13:00:00")));
        reservaDTO.setNumeroPersonas(2);
        reservaDTO.setCosto(new BigDecimal(100.0));

        try {
            // Ejecutar el método de negocio
            reservaBO.agregarReserva(reservaDTO);
            System.out.println("Reserva creada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear la reserva: " + e.getMessage());
            throw new Exception("Prueba fallida al intentar crear la reserva.", e);
        }

        /*// Verificar en la base de datos si la reserva fue creada correctamente
        Reserva reservaNueva = reservaDAO.obtenerReservaPorId(reservaDTO.getIdReserva());
        if (reservaNueva != null) {
            System.out.println("La reserva fue encontrada en la base de datos. Prueba exitosa.");
        } else {
            System.out.println("La reserva no se encontró en la base de datos. Prueba fallida.");
        }*/
    }

    public void testActualizarReserva() throws Exception {
        // Suponemos que ya existe una reserva en la base de datos con ID 1
        long idReservaExistente = 1L; // Cambia esto al ID de una reserva que existe

        // Obtener la reserva existente
        Reserva reservaExistente = reservaDAO.obtenerReservaPorId(idReservaExistente);
        if (reservaExistente == null) {
            throw new Exception("No se encontró la reserva existente con ID: " + idReservaExistente);
        }

        // Crear un DTO para la actualización con los nuevos valores
        ReservaDTO reservaDTOActualizar = new ReservaDTO();
        reservaDTOActualizar.setIdReserva(reservaExistente.getId()); // Usar el ID de la reserva existente
        reservaDTOActualizar.setIdCliente(reservaExistente.getCliente().getId()); // Mantener el mismo cliente
        reservaDTOActualizar.setIdMesa(5L); // Cambiar a otro ID de mesa existente en la base de datos
        reservaDTOActualizar.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-10-11 15:00:00")); // Nueva fecha y hora
        reservaDTOActualizar.setNumeroPersonas(6); // Cambiar el número de personas
        reservaDTOActualizar.setCosto(new BigDecimal(150.0)); // Nuevo costo
        reservaDTOActualizar.setEstado("Pendiente"); // Establecer un valor para el estado

        try {
            // Ejecutar el método de negocio para actualizar la reserva
            reservaBO.actualizarReserva(reservaDTOActualizar);
            System.out.println("Reserva actualizada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar la reserva: " + e.getMessage());
            throw new Exception("Prueba fallida al intentar actualizar la reserva.", e);
        }

        // Verificar en la base de datos si la reserva fue actualizada correctamente
        Reserva reservaActualizada = reservaDAO.obtenerReservaPorId(reservaDTOActualizar.getIdReserva());
        if (reservaActualizada != null) {
            // Verificar que los valores sean los esperados
            if (reservaActualizada.getNumPersonas() == 6
                    && reservaActualizada.getCosto().compareTo(new BigDecimal(150.0)) == 0
                    && reservaActualizada.getFechaHora().equals(reservaDTOActualizar.getFechaHora())
                    && reservaActualizada.getEstado().equals(reservaDTOActualizar.getEstado())) { // Verifica también el estado
                System.out.println("La reserva fue actualizada correctamente en la base de datos. Prueba exitosa.");
            } else {
                System.out.println("La reserva no se actualizó correctamente. Prueba fallida.");
            }
        } else {
            System.out.println("La reserva no se encontró en la base de datos después de la actualización. Prueba fallida.");
        }
    }
}
