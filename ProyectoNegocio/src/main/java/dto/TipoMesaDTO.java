/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad TipoMesa.
 * Se utiliza para transferir datos de tipos de mesa entre la capa de presentación y la capa de negocio.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class TipoMesaDTO {

    private int idTipoMesa;
    private String nombreTipo;
    private int capacidad;
    private double precioReserva;

    // Constructor
    public TipoMesaDTO() {
    }

    public TipoMesaDTO(int idTipoMesa, String nombreTipo, int capacidad, double precioReserva) {
        this.idTipoMesa = idTipoMesa;
        this.nombreTipo = nombreTipo;
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
    }

    // Getters y Setters
    public int getIdTipoMesa() {
        return idTipoMesa;
    }

    public void setIdTipoMesa(int idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(double precioReserva) {
        this.precioReserva = precioReserva;
    }
}
