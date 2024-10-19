/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad HistorialReserva.
 * Se utiliza para transferir datos del historial de reservas entre la capa de presentación y la capa de negocio.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HistorialReservasDTO {

    private int idHistorial;
    private double costo;
    private String ubicacion;
    private Date fechaHoraReserva;
    private double multa;
    private int idReserva;
    private int idTipoMesa;

    // Constructor
    public HistorialReservasDTO() {
    }

    public HistorialReservasDTO(int idHistorial, double costo, String ubicacion, Date fechaHoraReserva, double multa, int idReserva, int idTipoMesa) {
        this.idHistorial = idHistorial;
        this.costo = costo;
        this.ubicacion = ubicacion;
        this.fechaHoraReserva = fechaHoraReserva;
        this.multa = multa;
        this.idReserva = idReserva;
        this.idTipoMesa = idTipoMesa;
    }

    // Getters y Setters
    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
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

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdTipoMesa() {
        return idTipoMesa;
    }

    public void setIdTipoMesa(int idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }
}
