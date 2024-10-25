/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author pauli
 */
public class HorarioMesaDTO {
    
    
    private Long idHorarioMesa;
    private List<Long> horariosIds;
    private List<Long> mesasIds;

    public HorarioMesaDTO() {
    }

    public HorarioMesaDTO(List<Long> horariosIds, List<Long> mesasIds) {
        this.horariosIds = horariosIds;
        this.mesasIds = mesasIds;
    }

    public HorarioMesaDTO(Long idHorarioMesa, List<Long> horariosIds, List<Long> mesasIds) {
        this.idHorarioMesa = idHorarioMesa;
        this.horariosIds = horariosIds;
        this.mesasIds = mesasIds;
    }

    public Long getIdHorarioMesa() {
        return idHorarioMesa;
    }

    public void setIdHorarioMesa(Long idHorarioMesa) {
        this.idHorarioMesa = idHorarioMesa;
    }

    public List<Long> getHorariosIds() {
        return horariosIds;
    }

    public void setHorariosIds(List<Long> horariosIds) {
        this.horariosIds = horariosIds;
    }

    public List<Long> getMesasIds() {
        return mesasIds;
    }

    public void setMesasIds(List<Long> mesasIds) {
        this.mesasIds = mesasIds;
    }
    
    
    
}
