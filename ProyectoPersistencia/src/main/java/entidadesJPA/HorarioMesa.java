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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @OneToMany(mappedBy = "horarioMesa")
    private List<Horario> horarios;
    
    @OneToMany(mappedBy = "horarioMesa")
    private List<Mesa> mesas;

    public HorarioMesa() {
        this.horarios = new ArrayList();
        this.mesas = new ArrayList();
    }

    public HorarioMesa(Long id) {
        this.id = id;
    }

    public HorarioMesa(List<Horario> horarios, List<Mesa> mesas) {
        this.horarios = horarios;
        this.mesas = mesas;
    }

    public HorarioMesa(Long id, List<Horario> horarios, List<Mesa> mesas) {
        this.id = id;
        this.horarios = horarios;
        this.mesas = mesas;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioMesa)) {
            return false;
        }
        HorarioMesa other = (HorarioMesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HorarioMesa{" + "id=" + id + ", horarios=" + horarios + ", mesas=" + mesas + '}';
    }


}
