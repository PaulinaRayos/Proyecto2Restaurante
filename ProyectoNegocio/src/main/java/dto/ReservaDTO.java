/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad Reserva.
 * Se utiliza para transferir datos de reservas entre la capa de presentación y la capa de negocio.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ReservaDTO {

    private Long idReserva;
    private Date fechaHora;
    private int numeroPersonas;
    private BigDecimal costo;
    private String estado;
    private Date fechaCancelacion;
    private BigDecimal multa;
    private Long idCliente;
    private Long idMesa;

    // Constructor
    public ReservaDTO() {
    }

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

    // Getters y Setters
    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }
}
