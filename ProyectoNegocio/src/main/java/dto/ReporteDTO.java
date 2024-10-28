/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 * Clase que representa un Data Transfer Object (DTO) para el reporte de mesas.
 * Se utiliza para transferir datos relacionados con los reportes entre la capa
 * de presentación y la capa de negocio.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
public class ReporteDTO {

    private Date fechaHora; // Fecha y hora del reporte
    private String cliente; // Nombre del cliente relacionado con el reporte
    private String codigoMesa; // Código de la mesa relacionada con el reporte
    private String tipoMesa; // Tipo de mesa (e.g., interior, exterior)
    private String ubicacion; // Ubicación de la mesa (e.g., terraza, ventana)
    private String costo; // Costo asociado al uso de la mesa
    private String multa; // Multa aplicada, si aplica

    /**
     * Constructor por defecto de la clase ReporteDTO.
     */
    public ReporteDTO() {
    }

    /**
     * Constructor de la clase ReporteDTO con todos los atributos en su
     * parámetro.
     *
     * @param fechaHora La fecha y hora del reporte.
     * @param cliente El cliente del reporte.
     * @param codigoMesa El código de mesa del reporte.
     * @param tipoMesa El tipo de mesa del reporte.
     * @param ubicacion La ubicación de la mesa del reporte.
     * @param costo El costo de la mesa del reporte.
     * @param multa La multa de reserva del reporte.
     */
    public ReporteDTO(Date fechaHora, String cliente, String codigoMesa, String tipoMesa, String ubicacion, String costo, String multa) {
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.codigoMesa = codigoMesa;
        this.tipoMesa = tipoMesa;
        this.ubicacion = ubicacion;
        this.costo = costo;
        this.multa = multa;
    }

    // Getters y Setters
    /**
     * Obtiene la fecha y hora del reporte.
     *
     * @return La fecha y hora del reporte.
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora del reporte.
     *
     * @param fechaHora La fecha y hora del reporte.
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el nombre del cliente relacionado con el reporte.
     *
     * @return El cliente del reporte.
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Establece el nombre del cliente relacionado con el reporte.
     *
     * @param cliente El cliente del reporte.
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el código de la mesa relacionada con el reporte.
     *
     * @return El código de mesa del reporte.
     */
    public String getCodigoMesa() {
        return codigoMesa;
    }

    /**
     * Establece el código de la mesa relacionada con el reporte.
     *
     * @param codigoMesa El código de mesa del reporte.
     */
    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    /**
     * Obtiene el tipo de mesa relacionada con el reporte.
     *
     * @return El tipo de mesa del reporte.
     */
    public String getTipoMesa() {
        return tipoMesa;
    }

    /**
     * Establece el tipo de mesa relacionada con el reporte.
     *
     * @param tipoMesa El tipo de mesa del reporte.
     */
    public void setTipoMesa(String tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    /**
     * Obtiene la ubicación de la mesa relacionada con el reporte.
     *
     * @return La ubicación de la mesa del reporte.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa relacionada con el reporte.
     *
     * @param ubicacion La ubicación de la mesa del reporte.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el costo asociado al uso de la mesa.
     *
     * @return El costo de la mesa del reporte.
     */
    public String getCosto() {
        return costo;
    }

    /**
     * Establece el costo asociado al uso de la mesa.
     *
     * @param costo El costo de la mesa del reporte.
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la multa aplicada en el reporte, si aplica.
     *
     * @return La multa de reserva del reporte.
     */
    public String getMulta() {
        return multa;
    }

    /**
     * Establece la multa aplicada en el reporte, si aplica.
     *
     * @param multa La multa de reserva del reporte.
     */
    public void setMulta(String multa) {
        this.multa = multa;
    }
}
