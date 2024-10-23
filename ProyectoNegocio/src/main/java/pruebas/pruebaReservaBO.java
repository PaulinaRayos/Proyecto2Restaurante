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
import negocio.AgregarReservaBO;
import negocio.CancelarReservaBO;

/**
 *
 * @author pauli
 */
public class pruebaReservaBO {

    private AgregarReservaBO reservaBO;
    private CancelarReservaBO cancelarReservaBO;
    private IConexion conexion;
    private IReservaDAO reservaDAO; // Instancia real del DAO

    public void setUp() {
        // Inicializar las instancias reales de los DAOs
        this.conexion = new Conexion();
        reservaDAO = new ReservaDAO(conexion);
        // Crear una instancia de AgregarReservaBO con los DAOs reales
        reservaBO = new AgregarReservaBO();
        cancelarReservaBO = new CancelarReservaBO();
    }

    public void testAgregarReserva() throws Exception {
        // Crear un DTO de prueba
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setIdCliente(13L); // ID de un cliente existente en la base de datos
        reservaDTO.setIdMesa(1L); // ID de una mesa existente en la base de datos
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

    public void testCancelarReserva() throws Exception {
        // ID de una reserva existente en la base de datos que queremos cancelar
        Long idReserva = 12L;

        try {
            // Ejecutar el método de negocio para cancelar la reserva
            cancelarReservaBO.cancelarReserva(idReserva);
            System.out.println("Reserva cancelada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al cancelar la reserva: " + e.getMessage());
            throw new Exception("Prueba fallida al intentar cancelar la reserva.", e);
        }
    }
}
