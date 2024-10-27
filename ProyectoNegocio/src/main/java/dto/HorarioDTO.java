/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author pauli
 */
public class HorarioDTO {

    private Long idHorario;
    private String diaSemana;
    private Date horaApertura;
    private Date horaCierre;
    private Long idRestaurante;


    public HorarioDTO() {
    }

    public HorarioDTO(String diaSemana, Date horaApertura, Date horaCierre, Long idRestaurante) {
        this.diaSemana = diaSemana;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.idRestaurante = idRestaurante;
        
    }

    public HorarioDTO(Long idHorario, String diaSemana, Date horaApertura, Date horaCierre, Long idRestaurante) {
        this.idHorario = idHorario;
        this.diaSemana = diaSemana;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.idRestaurante = idRestaurante;
        
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }



    @Override
    public String toString() {
        return "HorarioDTO{" + "idHorario=" + idHorario + ", diaSemana=" + diaSemana + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", idRestaurante=" + idRestaurante +  '}';
    }

    
    
    
}
