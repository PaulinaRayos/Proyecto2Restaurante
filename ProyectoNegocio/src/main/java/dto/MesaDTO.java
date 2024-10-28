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

    private Long idMesa; // Identificador único de la mesa
    private String codigoMesa; // Código que identifica a la mesa
    private String ubicacion; // Ubicación de la mesa (e.g., terraza, ventana)
    private int capacidad; // Capacidad máxima de la mesa
    private Long idTipoMesa; // Identificador del tipo de mesa
    private Long idRestaurante; // Identificador del restaurante al que pertenece la mesa

    // Constructor vacío
    public MesaDTO() {
    }

    /**
     * Constructor con parámetros para crear un objeto MesaDTO.
     *
     * @param idMesa Identificador único de la mesa.
     * @param codigoMesa Código que identifica a la mesa.
     * @param ubicacion Ubicación de la mesa.
     * @param capacidad Capacidad máxima de la mesa.
     * @param idTipoMesa Identificador del tipo de mesa.
     */
    public MesaDTO(Long idMesa, String codigoMesa, String ubicacion, int capacidad, Long idTipoMesa) {
        this.idMesa = idMesa;
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    /**
     * Constructor con parámetros para crear un objeto MesaDTO sin el ID de la
     * mesa.
     *
     * @param codigoMesa Código que identifica a la mesa.
     * @param ubicacion Ubicación de la mesa.
     * @param capacidad Capacidad máxima de la mesa.
     * @param idTipoMesa Identificador del tipo de mesa.
     * @param idRestaurante Identificador del restaurante al que pertenece la
     * mesa.
     */
    public MesaDTO(String codigoMesa, String ubicacion, int capacidad, Long idTipoMesa, Long idRestaurante) {
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.idTipoMesa = idTipoMesa;
        this.idRestaurante = idRestaurante;
    }

    // Getters y Setters
    /**
     * Obtiene el identificador único de la mesa.
     *
     * @return El identificador de la mesa.
     */
    public Long getIdMesa() {
        return idMesa;
    }

    /**
     * Establece el identificador único de la mesa.
     *
     * @param idMesa Identificador único de la mesa.
     */
    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    /**
     * Obtiene el código que identifica a la mesa.
     *
     * @return El código de la mesa.
     */
    public String getCodigoMesa() {
        return codigoMesa;
    }

    /**
     * Establece el código que identifica a la mesa.
     *
     * @param codigoMesa Código que identifica a la mesa.
     */
    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    /**
     * Obtiene la ubicación de la mesa.
     *
     * @return La ubicación de la mesa.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa.
     *
     * @param ubicacion Ubicación de la mesa.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene la capacidad máxima de la mesa.
     *
     * @return La capacidad de la mesa.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad máxima de la mesa.
     *
     * @param capacidad Capacidad máxima de la mesa.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el identificador del restaurante al que pertenece la mesa.
     *
     * @return El identificador del restaurante.
     */
    public Long getIdRestaurante() {
        return idRestaurante;
    }

    /**
     * Establece el identificador del restaurante al que pertenece la mesa.
     *
     * @param idRestaurante Identificador del restaurante.
     */
    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    /**
     * Obtiene el identificador del tipo de mesa.
     *
     * @return El identificador del tipo de mesa.
     */
    public Long getIdTipoMesa() {
        return idTipoMesa;
    }

    /**
     * Establece el identificador del tipo de mesa.
     *
     * @param idTipoMesa Identificador del tipo de mesa.
     */
    public void setIdTipoMesa(Long idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    /**
     * Representación en cadena del objeto MesaDTO.
     *
     * @return Cadena que representa el objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MesaDTO{");
        sb.append("idMesa=").append(idMesa);
        sb.append(", codigoMesa=").append(codigoMesa);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", capacidad=").append(capacidad);
        sb.append(", idRestaurante=").append(idRestaurante);
        sb.append('}');
        return sb.toString();
    }
}
