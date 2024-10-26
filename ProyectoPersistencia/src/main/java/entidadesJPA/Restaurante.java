/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_restaurante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @OneToMany(mappedBy = "restaurante")
    private List<Mesa> mesas;

    @OneToMany(mappedBy = "restaurante")
    private List<Horario> horarios;

    public Restaurante() {
        this.mesas = new ArrayList();
        this.horarios = new ArrayList();
    }

    public Restaurante(Long id, String dirrecion, String ciudad) {
        this.id = id;
        this.direccion = dirrecion;
        this.ciudad = ciudad;
        this.mesas = new ArrayList();
        this.horarios = new ArrayList();
    }

    public Restaurante(String dirrecion, String ciudad) {
        this.direccion = dirrecion;
        this.ciudad = ciudad;
        this.mesas = new ArrayList();
        this.horarios = new ArrayList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public String getDirrecion() {
        return direccion;
    }

    public void setDirrecion(String dirrecion) {
        this.direccion = dirrecion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
        if (!(object instanceof Restaurante)) {
            return false;
        }
        Restaurante other = (Restaurante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Restaurante{");
        sb.append("id=").append(id);
        sb.append(", dirrecion=").append(direccion);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", mesas=").append(mesas);
        sb.append(", horarios=").append(horarios);
        sb.append('}');
        return sb.toString();
    }

}
