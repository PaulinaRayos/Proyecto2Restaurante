/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 * Clase que representa un Data Transfer Object (DTO) para la relación entre
 * horarios y mesas. Se utiliza para transferir datos sobre qué mesas están
 * disponibles en determinados horarios.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HorarioMesaDTO {

    private Long idHorarioMesa; // Identificador único para la relación de horario y mesa
    private List<Long> horariosIds; // Lista de identificadores de horarios asociados
    private List<Long> mesasIds; // Lista de identificadores de mesas asociadas

    /**
     * Constructor vacío para crear un objeto HorarioMesaDTO sin parámetros
     * iniciales. Se utiliza cuando no se tienen los datos de horarios y mesas
     * disponibles.
     */
    public HorarioMesaDTO() {
    }

    /**
     * Constructor con parámetros para crear un objeto HorarioMesaDTO. Se
     * utiliza cuando se tiene la información de los horarios y mesas.
     *
     * @param horariosIds Lista de identificadores de horarios.
     * @param mesasIds Lista de identificadores de mesas.
     */
    public HorarioMesaDTO(List<Long> horariosIds, List<Long> mesasIds) {
        this.horariosIds = horariosIds;
        this.mesasIds = mesasIds;
    }

    /**
     * Constructor con parámetros para crear un objeto HorarioMesaDTO con un ID
     * específico.
     *
     * @param idHorarioMesa Identificador único de la relación de horario y
     * mesa.
     * @param horariosIds Lista de identificadores de horarios.
     * @param mesasIds Lista de identificadores de mesas.
     */
    public HorarioMesaDTO(Long idHorarioMesa, List<Long> horariosIds, List<Long> mesasIds) {
        this.idHorarioMesa = idHorarioMesa;
        this.horariosIds = horariosIds;
        this.mesasIds = mesasIds;
    }

    // Getters y Setters
    /**
     * Obtiene el identificador único de la relación de horario y mesa.
     *
     * @return El identificador de la relación de horario y mesa.
     */
    public Long getIdHorarioMesa() {
        return idHorarioMesa;
    }

    /**
     * Establece el identificador único de la relación de horario y mesa.
     *
     * @param idHorarioMesa Identificador único de la relación de horario y
     * mesa.
     */
    public void setIdHorarioMesa(Long idHorarioMesa) {
        this.idHorarioMesa = idHorarioMesa;
    }

    /**
     * Obtiene la lista de identificadores de horarios asociados.
     *
     * @return La lista de identificadores de horarios.
     */
    public List<Long> getHorariosIds() {
        return horariosIds;
    }

    /**
     * Establece la lista de identificadores de horarios asociados.
     *
     * @param horariosIds Lista de identificadores de horarios.
     */
    public void setHorariosIds(List<Long> horariosIds) {
        this.horariosIds = horariosIds;
    }

    /**
     * Obtiene la lista de identificadores de mesas asociadas.
     *
     * @return La lista de identificadores de mesas.
     */
    public List<Long> getMesasIds() {
        return mesasIds;
    }

    /**
     * Establece la lista de identificadores de mesas asociadas.
     *
     * @param mesasIds Lista de identificadores de mesas.
     */
    public void setMesasIds(List<Long> mesasIds) {
        this.mesasIds = mesasIds;
    }
}
