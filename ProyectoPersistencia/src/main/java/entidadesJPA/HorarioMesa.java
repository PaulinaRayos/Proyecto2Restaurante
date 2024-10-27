/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pauli
 */
@Entity
@Table(name = "horario_mesa")
public class HorarioMesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_horario_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
        @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_horario", nullable = true)
    private Horario horario;
    
            @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    public HorarioMesa() {
    }

    public HorarioMesa(Horario horario, Mesa mesa) {
        this.horario = horario;
        this.mesa = mesa;
    }

    public HorarioMesa(Long id, Horario horario, Mesa mesa) {
        this.id = id;
        this.horario = horario;
        this.mesa = mesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "HorarioMesa{" + "id=" + id + ", horario=" + horario + ", mesa=" + mesa + '}';
    }






    
}
