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
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HistorialReservasDTO {

    private Long idHistorial;
    private BigDecimal costo;
    private String ubicacion;
    private Date fechaHoraReserva;
    private BigDecimal multa;
    private Long idReserva;
    private Long idTipoMesa;
    private Long idCliente;
    private String nombreCliente;

    // Constructor
    public HistorialReservasDTO() {
    }

    public HistorialReservasDTO(Long idHistorial, BigDecimal costo, String ubicacion, Date fechaHoraReserva, BigDecimal multa, Long idReserva, Long idTipoMesa) {
        this.idHistorial = idHistorial;
        this.costo = costo;
        this.ubicacion = ubicacion;
        this.fechaHoraReserva = fechaHoraReserva;
        this.multa = multa;
        this.idReserva = idReserva;
        this.idTipoMesa = idTipoMesa;
    }

    public HistorialReservasDTO(BigDecimal costo, String ubicacion, Date fechaHoraReserva, BigDecimal multa, Long idReserva, Long idTipoMesa, Long idCliente, String nombreCliente) {
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
    public Long getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Long idHistorial) {
        this.idHistorial = idHistorial;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Date fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdTipoMesa() {
        return idTipoMesa;
    }

    public void setIdTipoMesa(Long idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    
}
