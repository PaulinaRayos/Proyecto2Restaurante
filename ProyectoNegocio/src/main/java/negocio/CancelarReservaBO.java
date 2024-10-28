/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.ReservaDAO;
import entidadesJPA.Reserva;
import interfaces.ICancelarReservaBO;
import interfaces.IReservaDAO;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que implementa la lógica de negocio para la cancelación de reservas en
 * un restaurante. Se encarga de gestionar la cancelación de reservas y el
 * cálculo de posibles multas asociadas.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class CancelarReservaBO implements ICancelarReservaBO {

    private final IConexion conexion;
    private final IReservaDAO reservaDAO;

    /**
     * Constructor de la clase CancelarReservaBO. Inicializa las interfaces
     * necesarias para la conexión y el acceso a los datos.
     */
    public CancelarReservaBO() {
        this.conexion = new Conexion();
        this.reservaDAO = new ReservaDAO(conexion);
    }

    /**
     * Método para cancelar una reserva. Verifica que el ID de la reserva no sea
     * nulo, obtiene la reserva desde la base de datos, y realiza las
     * validaciones necesarias para proceder con la cancelación. También calcula
     * la multa correspondiente según el tiempo restante hasta la fecha de la
     * reserva.
     *
     * @param idReserva ID de la reserva a cancelar.
     * @throws Exception Si ocurre un error al cancelar la reserva o si la
     * reserva no se encuentra.
     */
    @Override
    public void cancelarReserva(Long idReserva) throws Exception {
        // Verificar que el ID de la reserva no sea nulo
        if (idReserva == null) {
            throw new IllegalArgumentException("El ID de la reserva no puede ser nulo.");
        }

        // Obtener la reserva desde la base de datos
        Reserva reserva = reservaDAO.obtenerReservaPorId(idReserva);
        if (reserva == null) {
            throw new Exception("Reserva no encontrada con ID: " + idReserva);
        }

        // Verificar si la reserva ya fue cancelada
        if ("Cancelada".equals(reserva.getEstado())) {
            throw new Exception("La reserva ya está cancelada.");
        }

        // Calcular la multa
        Date fechaActual = new Date();
        long diff = reserva.getFechaHora().getTime() - fechaActual.getTime();
        long diffHours = diff / (60 * 60 * 1000);

        BigDecimal multa = BigDecimal.ZERO;

        if (diffHours > 48) {
            // Sin multa
        } else if (diffHours > 24) {
            // Multa del 25%
            multa = reserva.getCosto().multiply(new BigDecimal("0.25"));
        } else {
            // Multa del 50%
            multa = reserva.getCosto().multiply(new BigDecimal("0.50"));
        }

        // Cambiar el estado de la reserva a "Cancelada"
        reserva.setEstado("Cancelada");
        reserva.setFechaCancelacion(fechaActual);
        reserva.setMulta(multa);

        try {
            // Actualizar la reserva en la base de datos
            reservaDAO.actualizarReserva(reserva);
        } catch (Exception e) {
            System.out.println("Error al cancelar la reserva: " + e.getMessage());
            throw new Exception("No se pudo cancelar la reserva.", e);
        }
    }

}
