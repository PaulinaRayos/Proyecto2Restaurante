/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad TipoMesa en la base de datos.
 * Mapea la tabla 'tipos_mesa' y define los atributos correspondientes,
 * así como las relaciones con otras entidades.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
@Entity
@Table(name = "tipos_mesa")
public class TipoMesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_tipo_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_tipo")
    private String nombreTipo;

    @Column (name = "capacidad")
    private int capacidad;

    @Column(name = "precio_reserva")
    private BigDecimal precioReserva;

    // Relación OneToMany con Mesa
    @OneToMany(mappedBy = "tipoMesa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mesa> mesas;

    //Constructor vacío
    public TipoMesa() {
    }

    //Constructor con Id
    public TipoMesa(Long id) {
        this.id = id;
    }

    //Constructor sin Id
    public TipoMesa(String nombreTipo, int capacidad, BigDecimal precioReserva) {
        this.nombreTipo = nombreTipo;
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
    }

    //Constructor completo
    public TipoMesa(Long id, String nombreTipo, int capacidad, BigDecimal precioReserva) {
        this.id = id;
        this.nombreTipo = nombreTipo;
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public BigDecimal getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(BigDecimal precioReserva) {
        this.precioReserva = precioReserva;
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
        if (!(object instanceof TipoMesa)) {
            return false;
        }
        TipoMesa other = (TipoMesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoMesa{" + "id=" + id + ", nombreTipo=" + nombreTipo + ", capacidad=" + capacidad + ", precioReserva=" + precioReserva + '}';
    }

}
