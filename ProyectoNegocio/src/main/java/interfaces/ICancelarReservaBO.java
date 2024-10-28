/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 * Interfaz que define la lógica de negocio para la cancelación de reservas en
 * un restaurante. Proporciona un método para cancelar reservas existentes en la
 * base de datos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public interface ICancelarReservaBO {

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
    void cancelarReserva(Long idReserva) throws Exception;

}
