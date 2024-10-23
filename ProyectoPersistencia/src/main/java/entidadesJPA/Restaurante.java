/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "restaurantes")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_restaurante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hora_apertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora_apartura;

    @Column(name = "hora_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora_cierre;

    @OneToMany(mappedBy = "restaurante")
    private List<Mesa> mesas;

    public Restaurante() {
        this.mesas = new ArrayList();
    }

    public Restaurante(Long id, Date hora_apartura, Date hora_cierre) {
        this.id = id;
        this.hora_apartura = hora_apartura;
        this.hora_cierre = hora_cierre;
        this.mesas = new ArrayList();
    }

    public Restaurante(Date hora_apartura, Date hora_cierre) {
        this.hora_apartura = hora_apartura;
        this.hora_cierre = hora_cierre;
        this.mesas = new ArrayList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHora_apartura() {
        return hora_apartura;
    }

    public void setHora_apartura(Date hora_apartura) {
        this.hora_apartura = hora_apartura;
    }

    public Date getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(Date hora_cierre) {
        this.hora_cierre = hora_cierre;
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
        return "Restaurante{" + "id=" + id + ", hora_apartura=" + hora_apartura + ", hora_cierre=" + hora_cierre + '}';
    }

}
