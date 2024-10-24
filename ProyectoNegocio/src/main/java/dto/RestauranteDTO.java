/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pauli
 */
public class RestauranteDTO {

    private Long id;
    private Date fechaApertura;
    private Date horaApertura;
    private Date horaCierre;
    private List<MesaDTO> mesas;

    public RestauranteDTO() {
        this.mesas = new ArrayList();
    }

    public RestauranteDTO(Long id, Date horaApertura, Date horaCierre) {
        this.id = id;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.mesas = new ArrayList();
    }

    public RestauranteDTO(Date fechaApertura, Date horaApertura, Date horaCierre, List<MesaDTO> mesas) {
        this.fechaApertura = fechaApertura;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.mesas = mesas;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public List<MesaDTO> getMesas() {
        return mesas;
    }

    public void setMesas(List<MesaDTO> mesas) {
        this.mesas = mesas;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "RestauranteDTO{"
                + "id=" + id
                + ", horaApertura=" + horaApertura
                + ", horaCierre=" + horaCierre
                + ", mesas=" + mesas
                + '}';
    }
}
