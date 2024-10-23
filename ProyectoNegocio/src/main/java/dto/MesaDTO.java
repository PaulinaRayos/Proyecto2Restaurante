/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad Mesa. Se
 * utiliza para transferir datos de mesas entre la capa de presentación y la
 * capa de negocio.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class MesaDTO {

    private Long idMesa;
    private String codigoMesa;
    private String ubicacion;
    private int capacidad;
    private Long idTipoMesa;
    private Long idRestaurante;

    // Constructor
    public MesaDTO() {
    }

    public MesaDTO(Long idMesa, String codigoMesa, String ubicacion, int capacidad, Long idTipoMesa) {
        this.idMesa = idMesa;
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.idTipoMesa = idTipoMesa;
    }

    public MesaDTO(String codigoMesa, String ubicacion, int capacidad, Long idTipoMesa, Long idRestaurante) {
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.idTipoMesa = idTipoMesa;
        this.idRestaurante = idRestaurante;
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

    public Long getIdTipoMesa() {
        return idTipoMesa;
    }

    public void setIdTipoMesa(Long idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getHoraApertura(RestauranteDTO restaurante) {
        return restaurante != null ? restaurante.getHoraApertura().toString() : "N/A";
    }

    public String getHoraCierre(RestauranteDTO restaurante) {
        return restaurante != null ? restaurante.getHoraCierre().toString() : "N/A";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MesaDTO{");
        sb.append("idMesa=").append(idMesa);
        sb.append(", codigoMesa=").append(codigoMesa);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", capacidad=").append(capacidad);
        sb.append(", idTipoMesa=").append(idTipoMesa);
        sb.append(", idRestaurante=").append(idRestaurante);
        sb.append('}');
        return sb.toString();
    }

}
