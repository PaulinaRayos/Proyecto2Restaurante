/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad Reserva.
 * Se utiliza para transferir datos de reservas entre la capa de presentación y
 * la capa de negocio.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ReservaDTO {

    private Long idReserva; // Identificador único de la reserva
    private Date fechaHora; // Fecha y hora de la reserva
    private int numeroPersonas; // Número de personas para la reserva
    private BigDecimal costo; // Costo total de la reserva
    private String estado; // Estado actual de la reserva (e.g., activa, cancelada)
    private Date fechaCancelacion; // Fecha en que se canceló la reserva, si aplica
    private BigDecimal multa; // Multa aplicada en caso de cancelación tardía
    private Long idCliente; // Identificador del cliente que realizó la reserva
    private Long idMesa; // Identificador de la mesa asignada a la reserva
    private Date fechaHoraCreada; // Fecha y hora en que se creó la reserva

    // Constructor por defecto
    /**
     * Constructor por defecto de la clase ReservaDTO. Inicializa un objeto de
     * reserva con valores predeterminados.
     */
    public ReservaDTO() {
    }

    /**
     * Constructor de la clase ReservaDTO con todos los atributos.
     *
     * @param idReserva Identificador de la reserva.
     * @param fechaHora Fecha y hora de la reserva.
     * @param numeroPersonas Número de personas para la reserva.
     * @param costo Costo total de la reserva.
     * @param estado Estado actual de la reserva.
     * @param fechaCancelacion Fecha de cancelación, si aplica.
     * @param multa Multa aplicada, si aplica.
     * @param idCliente Identificador del cliente.
     * @param idMesa Identificador de la mesa asignada.
     */
    public ReservaDTO(Long idReserva, Date fechaHora, int numeroPersonas, BigDecimal costo, String estado, Date fechaCancelacion, BigDecimal multa, Long idCliente, Long idMesa) {
        this.idReserva = idReserva;
        this.fechaHora = fechaHora;
        this.numeroPersonas = numeroPersonas;
        this.costo = costo;
        this.estado = estado;
        this.fechaCancelacion = fechaCancelacion;
        this.multa = multa;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
    }

    /**
     * Constructor de la clase ReservaDTO, omitiendo el idReserva.
     *
     * @param fechaHora Fecha y hora de la reserva.
     * @param numeroPersonas Número de personas para la reserva.
     * @param costo Costo total de la reserva.
     * @param estado Estado actual de la reserva.
     * @param fechaCancelacion Fecha de cancelación, si aplica.
     * @param multa Multa aplicada, si aplica.
     * @param idCliente Identificador del cliente.
     * @param idMesa Identificador de la mesa asignada.
     * @param fechaHoraCreada Fecha y hora en que se creó la reserva.
     */
    public ReservaDTO(Date fechaHora, int numeroPersonas, BigDecimal costo, String estado, Date fechaCancelacion, BigDecimal multa, Long idCliente, Long idMesa, Date fechaHoraCreada) {
        this.fechaHora = fechaHora;
        this.numeroPersonas = numeroPersonas;
        this.costo = costo;
        this.estado = estado;
        this.fechaCancelacion = fechaCancelacion;
        this.multa = multa;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
        this.fechaHoraCreada = fechaHoraCreada;
    }

    // Getters y Setters
    /**
     * Obtiene el identificador de la reserva.
     *
     * @return El identificador de la reserva.
     */
    public Long getIdReserva() {
        return idReserva;
    }

    /**
     * Establece el identificador de la reserva.
     *
     * @param idReserva El identificador de la reserva.
     */
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * Obtiene la fecha y hora de la reserva.
     *
     * @return La fecha y hora de la reserva.
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la reserva.
     *
     * @param fechaHora La fecha y hora de la reserva.
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el número de personas para la reserva.
     *
     * @return El número de personas.
     */
    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    /**
     * Establece el número de personas para la reserva.
     *
     * @param numeroPersonas El número de personas.
     */
    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    /**
     * Obtiene el costo total de la reserva.
     *
     * @return El costo de la reserva.
     */
    public BigDecimal getCosto() {
        return costo;
    }

    /**
     * Establece el costo total de la reserva.
     *
     * @param costo El costo de la reserva.
     */
    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    /**
     * Obtiene el estado actual de la reserva.
     *
     * @return El estado de la reserva.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la reserva.
     *
     * @param estado El estado de la reserva.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de cancelación de la reserva, si aplica.
     *
     * @return La fecha de cancelación.
     */
    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    /**
     * Establece la fecha de cancelación de la reserva, si aplica.
     *
     * @param fechaCancelacion La fecha de cancelación.
     */
    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    /**
     * Obtiene la multa aplicada en caso de cancelación tardía.
     *
     * @return La multa aplicada.
     */
    public BigDecimal getMulta() {
        return multa;
    }

    /**
     * Establece la multa aplicada en caso de cancelación tardía.
     *
     * @param multa La multa aplicada.
     */
    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    /**
     * Obtiene el identificador del cliente que realizó la reserva.
     *
     * @return El identificador del cliente.
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente que realizó la reserva.
     *
     * @param idCliente El identificador del cliente.
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el identificador de la mesa asignada a la reserva.
     *
     * @return El identificador de la mesa.
     */
    public Long getIdMesa() {
        return idMesa;
    }

    /**
     * Establece el identificador de la mesa asignada a la reserva.
     *
     * @param idMesa El identificador de la mesa.
     */
    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    /**
     * Obtiene la fecha y hora en que se creó la reserva.
     *
     * @return La fecha y hora de creación de la reserva.
     */
    public Date getFechaHoraCreada() {
        return fechaHoraCreada;
    }

    /**
     * Establece la fecha y hora en que se creó la reserva.
     *
     * @param fechaHoraCreada La fecha y hora de creación de la reserva.
     */
    public void setFechaHoraCreada(Date fechaHoraCreada) {
        this.fechaHoraCreada = fechaHoraCreada;
    }
}
