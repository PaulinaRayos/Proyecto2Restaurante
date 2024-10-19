/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Mesa en la base de datos.
 * Mapea la tabla 'mesas' y define los atributos correspondientes,
 * así como las relaciones con otras entidades.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_mesa")
    private String codigoMesa;
    
    private String ubicacion;
    private int capacidad;
    private boolean ocupado;
    
    // Relación ManyToOne con TipoMesa
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_mesa", nullable = false)
    private TipoMesa tipoMesa;

    //Contructor vacío
    public Mesa() {
    }
    //Constructor con Id
    public Mesa(Long id) {
        this.id = id;
    }
    //Contructor sin Id
        public Mesa(String codigoMesa, String ubicacion, int capacidad, boolean ocupado, TipoMesa tipoMesa) {
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.ocupado = ocupado;
        this.tipoMesa = tipoMesa;
    }
    //Constructor completo

    public Mesa(Long id, String codigoMesa, String ubicacion, int capacidad, boolean ocupado, TipoMesa tipoMesa) {
        this.id = id;
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.ocupado = ocupado;
        this.tipoMesa = tipoMesa;
    }

    //Getters & Setters
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public TipoMesa getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(TipoMesa tipoMesa) {
        this.tipoMesa = tipoMesa;
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
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", codigoMesa=" + codigoMesa + ", ubicacion=" + ubicacion + ", capacidad=" + capacidad + ", ocupado=" + ocupado + ", tipoMesa=" + tipoMesa + '}';
    }

    

    
    
}
