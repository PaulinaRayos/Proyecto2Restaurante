/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 * Clase que representa un Data Transfer Object (DTO) para la entidad
 * Horario. Se utiliza para transferir datos de horarios entre la capa de
 * presentación y la capa de negocio.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class HorarioDTO {

    private Long idHorario; // Identificador único del horario
    private String diaSemana; // Día de la semana al que corresponde el horario
    private Date horaApertura; // Hora de apertura del restaurante
    private Date horaCierre; // Hora de cierre del restaurante
    private Long idRestaurante; // Identificador del restaurante al que pertenece este horario

    /**
     * Constructor vacío para crear un objeto HorarioDTO sin parámetros iniciales.
     * Se utiliza cuando no se tienen los datos del horario disponibles.
     */
    public HorarioDTO() {
    }

    /**
     * Constructor con parámetros para crear un objeto HorarioDTO. 
     * Se utiliza cuando se tiene la información del horario.
     *
     * @param diaSemana Día de la semana al que corresponde el horario.
     * @param horaApertura Hora de apertura del restaurante.
     * @param horaCierre Hora de cierre del restaurante.
     * @param idRestaurante Identificador del restaurante al que pertenece este horario.
     */
    public HorarioDTO(String diaSemana, Date horaApertura, Date horaCierre, Long idRestaurante) {
        this.diaSemana = diaSemana;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.idRestaurante = idRestaurante;
    }

    /**
     * Constructor con parámetros para crear un objeto HorarioDTO con un ID específico.
     *
     * @param idHorario Identificador único del horario.
     * @param diaSemana Día de la semana al que corresponde el horario.
     * @param horaApertura Hora de apertura del restaurante.
     * @param horaCierre Hora de cierre del restaurante.
     * @param idRestaurante Identificador del restaurante al que pertenece este horario.
     */
    public HorarioDTO(Long idHorario, String diaSemana, Date horaApertura, Date horaCierre, Long idRestaurante) {
        this.idHorario = idHorario;
        this.diaSemana = diaSemana;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.idRestaurante = idRestaurante;
    }

    // Getters y Setters

    /**
     * Obtiene el identificador único del horario.
     *
     * @return El identificador del horario.
     */
    public Long getIdHorario() {
        return idHorario;
    }

    /**
     * Establece el identificador único del horario.
     *
     * @param idHorario Identificador único del horario.
     */
    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    /**
     * Obtiene el día de la semana al que corresponde el horario.
     *
     * @return El día de la semana.
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * Establece el día de la semana al que corresponde el horario.
     *
     * @param diaSemana Día de la semana.
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * Obtiene la hora de apertura del restaurante.
     *
     * @return La hora de apertura.
     */
    public Date getHoraApertura() {
        return horaApertura;
    }

    /**
     * Establece la hora de apertura del restaurante.
     *
     * @param horaApertura Hora de apertura.
     */
    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Obtiene la hora de cierre del restaurante.
     *
     * @return La hora de cierre.
     */
    public Date getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre del restaurante.
     *
     * @param horaCierre Hora de cierre.
     */
    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    /**
     * Obtiene el identificador del restaurante al que pertenece este horario.
     *
     * @return El identificador del restaurante.
     */
    public Long getIdRestaurante() {
        return idRestaurante;
    }

    /**
     * Establece el identificador del restaurante al que pertenece este horario.
     *
     * @param idRestaurante Identificador del restaurante.
     */
    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    /**
     * Representa el objeto HorarioDTO como una cadena.
     *
     * @return Una cadena que representa los datos del horario.
     */
    @Override
    public String toString() {
        return "HorarioDTO{" +
                "idHorario=" + idHorario +
                ", diaSemana='" + diaSemana + '\'' +
                ", horaApertura=" + horaApertura +
                ", horaCierre=" + horaCierre +
                ", idRestaurante=" + idRestaurante +
                '}';
    }
}

