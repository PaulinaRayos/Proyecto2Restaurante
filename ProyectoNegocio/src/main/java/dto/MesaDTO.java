/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad Mesa.
 * Se utiliza para transferir datos de mesas entre la capa de presentación y la capa de negocio.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class MesaDTO {

    private Long idMesa;
    private String codigoMesa;
    private String ubicacion;
    private int capacidad;
    private boolean ocupado;
    private Long idTipoMesa;

    // Constructor
    public MesaDTO() {
    }

    public MesaDTO(Long idMesa, String codigoMesa, String ubicacion, int capacidad, boolean ocupado, Long idTipoMesa) {
        this.idMesa = idMesa;
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.ocupado = ocupado;
        this.idTipoMesa = idTipoMesa;
    }

    // Getters y Setters
    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Long getIdTipoMesa() {
        return idTipoMesa;
    }

    public void setIdTipoMesa(Long idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }
}