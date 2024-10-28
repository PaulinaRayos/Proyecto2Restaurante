/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad
 * HistorialReserva. Se utiliza para transferir datos del historial de reservas
 * entre la capa de presentación y la capa de negocio.
 *
 * Esta clase incluye atributos para almacenar información relevante sobre las
 * reservas realizadas, incluyendo detalles como costo, ubicación, fecha y hora
 * de la reserva, multas, y referencias a otras entidades como reservas, tipos
 * de mesa y clientes.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HistorialReservasDTO {

    private Long idHistorial; // Identificador único del historial de reservas
    private BigDecimal costo; // Costo asociado a la reserva
    private String ubicacion; // Ubicación de la mesa reservada
    private Date fechaHoraReserva; // Fecha y hora en que se realizó la reserva
    private BigDecimal multa; // Multa asociada a la reserva, si aplica
    private Long idReserva; // Identificador de la reserva relacionada
    private Long idTipoMesa; // Identificador del tipo de mesa reservada
    private Long idCliente; // Identificador del cliente que realizó la reserva
    private String nombreCliente; // Nombre del cliente que realizó la reserva

    /**
     * Constructor vacío para crear un objeto HistorialReservasDTO sin
     * parámetros iniciales. Se utiliza cuando los datos del historial de
     * reservas aún no están disponibles.
     */
    public HistorialReservasDTO() {
    }

    /**
     * Constructor con parámetros para crear un objeto HistorialReservasDTO. Se
     * utiliza cuando se tiene información del historial de reservas.
     *
     * @param idHistorial Identificador único del historial de reservas.
     * @param costo Costo asociado a la reserva.
     * @param ubicacion Ubicación de la mesa reservada.
     * @param fechaHoraReserva Fecha y hora en que se realizó la reserva.
     * @param multa Multa asociada a la reserva, si aplica.
     * @param idReserva Identificador de la reserva relacionada.
     * @param idTipoMesa Identificador del tipo de mesa reservada.
     */
    public HistorialReservasDTO(Long idHistorial, BigDecimal costo, String ubicacion,
            Date fechaHoraReserva, BigDecimal multa,
            Long idReserva, Long idTipoMesa) {
        this.idHistorial = idHistorial;
        this.costo = costo;
        this.ubicacion = ubicacion;
        this.fechaHoraReserva = fechaHoraReserva;
        this.multa = multa;
        this.idReserva = idReserva;
        this.idTipoMesa = idTipoMesa;
    }

    /**
     * Constructor con parámetros para crear un objeto HistorialReservasDTO. Se
     * utiliza cuando se tiene información del historial de reservas junto con
     * el cliente relacionado.
     *
     * @param costo Costo asociado a la reserva.
     * @param ubicacion Ubicación de la mesa reservada.
     * @param fechaHoraReserva Fecha y hora en que se realizó la reserva.
     * @param multa Multa asociada a la reserva, si aplica.
     * @param idReserva Identificador de la reserva relacionada.
     * @param idTipoMesa Identificador del tipo de mesa reservada.
     * @param idCliente Identificador del cliente que realizó la reserva.
     * @param nombreCliente Nombre del cliente que realizó la reserva.
     */
    public HistorialReservasDTO(BigDecimal costo, String ubicacion,
            Date fechaHoraReserva, BigDecimal multa,
            Long idReserva, Long idTipoMesa,
            Long idCliente, String nombreCliente) {
        this.costo = costo;
        this.ubicacion = ubicacion;
        this.fechaHoraReserva = fechaHoraReserva;
        this.multa = multa;
        this.idReserva = idReserva;
        this.idTipoMesa = idTipoMesa;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }

    // Getters y Setters
    /**
     * Obtiene el identificador único del historial de reservas.
     *
     * @return El id del historial de reservas.
     */
    public Long getIdHistorial() {
        return idHistorial;
    }

    /**
     * Establece el identificador único del historial de reservas.
     *
     * @param idHistorial El nuevo id del historial de reservas.
     */
    public void setIdHistorial(Long idHistorial) {
        this.idHistorial = idHistorial;
    }

    /**
     * Obtiene el costo asociado a la reserva.
     *
     * @return El costo de la reserva.
     */
    public BigDecimal getCosto() {
        return costo;
    }

    /**
     * Establece el costo asociado a la reserva.
     *
     * @param costo El nuevo costo de la reserva.
     */
    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la ubicación de la mesa reservada.
     *
     * @return La ubicación de la mesa.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa reservada.
     *
     * @param ubicacion La nueva ubicación de la mesa.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene la fecha y hora de la reserva.
     *
     * @return La fecha y hora de la reserva.
     */
    public Date getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    /**
     * Establece la fecha y hora de la reserva.
     *
     * @param fechaHoraReserva La nueva fecha y hora de la reserva.
     */
    public void setFechaHoraReserva(Date fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    /**
     * Obtiene la multa asociada a la reserva.
     *
     * @return La multa de la reserva.
     */
    public BigDecimal getMulta() {
        return multa;
    }

    /**
     * Establece la multa asociada a la reserva.
     *
     * @param multa La nueva multa de la reserva.
     */
    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    /**
     * Obtiene el identificador de la reserva relacionada.
     *
     * @return El id de la reserva.
     */
    public Long getIdReserva() {
        return idReserva;
    }

    /**
     * Establece el identificador de la reserva relacionada.
     *
     * @param idReserva El nuevo id de la reserva.
     */
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * Obtiene el identificador del tipo de mesa reservada.
     *
     * @return El id del tipo de mesa.
     */
    public Long getIdTipoMesa() {
        return idTipoMesa;
    }

    /**
     * Establece el identificador del tipo de mesa reservada.
     *
     * @param idTipoMesa El nuevo id del tipo de mesa.
     */
    public void setIdTipoMesa(Long idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    /**
     * Obtiene el identificador del cliente que realizó la reserva.
     *
     * @return El id del cliente.
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente que realizó la reserva.
     *
     * @param idCliente El nuevo id del cliente.
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el nombre del cliente que realizó la reserva.
     *
     * @return El nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Establece el nombre del cliente que realizó la reserva.
     *
     * @param nombreCliente El nuevo nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
