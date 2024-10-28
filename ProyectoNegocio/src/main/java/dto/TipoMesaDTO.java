/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad TipoMesa.
 * Se utiliza para transferir datos de tipos de mesa entre la capa de
 * presentación y la capa de negocio.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class TipoMesaDTO {

    private Long idTipoMesa; // Identificador único del tipo de mesa
    private String nombreTipo; // Nombre del tipo de mesa
    private int capacidad; // Capacidad máxima de personas para este tipo de mesa
    private BigDecimal precioReserva; // Precio de reserva para este tipo de mesa
    private List<MesaDTO> mesas; // Lista de mesas asociadas a este tipo de mesa

    /**
     * Constructor vacío para crear un objeto TipoMesaDTO sin parámetros
     * iniciales. Inicializa la lista de mesas como una nueva ArrayList.
     */
    public TipoMesaDTO() {
        this.mesas = new ArrayList<>();
    }

    /**
     * Constructor con parámetros para crear un objeto TipoMesaDTO. Se utiliza
     * cuando se tiene la información completa del tipo de mesa.
     *
     * @param idTipoMesa Identificador único del tipo de mesa.
     * @param nombreTipo Nombre del tipo de mesa.
     * @param capacidad Capacidad máxima de personas para este tipo de mesa.
     * @param precioReserva Precio de reserva para este tipo de mesa.
     */
    public TipoMesaDTO(Long idTipoMesa, String nombreTipo, int capacidad, BigDecimal precioReserva) {
        this.idTipoMesa = idTipoMesa;
        this.nombreTipo = nombreTipo;
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
        this.mesas = new ArrayList<>();
    }

    // Getters y Setters
    /**
     * Obtiene el identificador único del tipo de mesa.
     *
     * @return El identificador del tipo de mesa.
     */
    public Long getIdTipoMesa() {
        return idTipoMesa;
    }

    /**
     * Establece el identificador único del tipo de mesa.
     *
     * @param idTipoMesa Identificador único del tipo de mesa.
     */
    public void setIdTipoMesa(Long idTipoMesa) {
        this.idTipoMesa = idTipoMesa;
    }

    /**
     * Obtiene el nombre del tipo de mesa.
     *
     * @return El nombre del tipo de mesa.
     */
    public String getNombreTipo() {
        return nombreTipo;
    }

    /**
     * Establece el nombre del tipo de mesa.
     *
     * @param nombreTipo Nombre del tipo de mesa.
     */
    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    /**
     * Obtiene la capacidad máxima de personas para este tipo de mesa.
     *
     * @return La capacidad del tipo de mesa.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad máxima de personas para este tipo de mesa.
     *
     * @param capacidad Capacidad del tipo de mesa.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el precio de reserva para este tipo de mesa.
     *
     * @return El precio de reserva del tipo de mesa.
     */
    public BigDecimal getPrecioReserva() {
        return precioReserva;
    }

    /**
     * Establece el precio de reserva para este tipo de mesa.
     *
     * @param precioReserva Precio de reserva del tipo de mesa.
     */
    public void setPrecioReserva(BigDecimal precioReserva) {
        this.precioReserva = precioReserva;
    }

    /**
     * Obtiene la lista de mesas asociadas a este tipo de mesa.
     *
     * @return Lista de mesas del tipo de mesa.
     */
    public List<MesaDTO> getMesas() {
        return mesas;
    }

    /**
     * Establece la lista de mesas asociadas a este tipo de mesa.
     *
     * @param mesas Lista de mesas asociadas al tipo de mesa.
     */
    public void setMesas(List<MesaDTO> mesas) {
        this.mesas = mesas;
    }
}
