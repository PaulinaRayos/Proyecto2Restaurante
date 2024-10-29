/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 * Clase que representa un Data Transfer Object (DTO) para agregar filtros a los
 * reportes. Se utiliza para transferir los datos filtrados para los resportes
 * en pdf.
 *
 * @author Chris
 */
public class FiltrosReportesDTO {

    private Date fechaInicio;
    private Date fechaFin;
    private String tipoMesa;
    private String ubicacion;

    /**
     * Constructor por defecto sin parametros
     */
    public FiltrosReportesDTO() {
    }

    /**
     * Constructor con atributos en sus parametros
     *
     * @param fechaInicio La fecha de inicio utilizada como filtro.
     * @param fechaFin La fecha de fin utilizada como filtro.
     * @param tipoMesa El tipo de mesa utilizada como filtro.
     * @param ubicacion La ubicacion de la mesa utilizada como filtro.
     */
    public FiltrosReportesDTO(Date fechaInicio, Date fechaFin, String tipoMesa, String ubicacion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoMesa = tipoMesa;
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene la fecha de inicio utilizada como filtro.
     *
     * @return La fecha de inicio utilizada como filtro.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio utilizada como filtro.
     *
     * @param fechaInicio La fecha de inicio utilizada como filtro.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin utilizada como filtro.
     *
     * @return La fecha de fin utilizada como filtro.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin utilizada como filtro.
     *
     * @param fechaFin La fecha de fin utilizada como filtro.
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el tipo de mesa utilizado como filtro.
     *
     * @return El tipo de trámite utilizado como filtro.
     */
    public String getTipoMesa() {
        return tipoMesa;
    }

    /**
     * Establece el tipo de mesa utilizado como filtro.
     *
     * @param tipoMesa El tipo de mesa utilizado como filtro.
     */
    public void setTipoMesa(String tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    /**
     * Obtiene la ubicación para el filtro.
     *
     * @return Ubicación del filtro.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación para el filtro.
     *
     * @param ubicacion Nueva ubicación a establecer.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
