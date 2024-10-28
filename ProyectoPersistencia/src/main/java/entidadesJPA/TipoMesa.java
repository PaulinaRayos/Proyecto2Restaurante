/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "tipo_mesa")
public class TipoMesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_tipo_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_tipo")
    private String nombreTipo;

    @Column(name = "precio_reserva")
    private BigDecimal precioReserva;

    /**
     * Relación uno a muchos con la entidad Mesa.
     * Cada tipo de mesa puede estar asociado a múltiples mesas.
     */
    @OneToMany(mappedBy = "tipoMesa", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Mesa> mesas;

    /**
     * Constructor vacío que inicializa la lista de mesas.
     */
    public TipoMesa() {
        this.mesas = new ArrayList();
    }

    /**
     * Constructor que inicializa un tipo de mesa con un ID.
     *
     * @param id el identificador único del tipo de mesa
     */
    public TipoMesa(Long id) {
        this.id = id;
        this.mesas = new ArrayList();
    }

    /**
     * Constructor que inicializa un tipo de mesa con nombre y precio de reserva.
     *
     * @param nombreTipo el nombre del tipo de mesa
     * @param precioReserva el precio de reserva del tipo de mesa
     */
    public TipoMesa(String nombreTipo, BigDecimal precioReserva) {
        this.nombreTipo = nombreTipo;
        this.precioReserva = precioReserva;
        this.mesas = new ArrayList();
    }

    /**
     * Constructor completo que inicializa todos los atributos.
     *
     * @param id el identificador único del tipo de mesa
     * @param nombreTipo el nombre del tipo de mesa
     * @param precioReserva el precio de reserva del tipo de mesa
     */
    public TipoMesa(Long id, String nombreTipo, BigDecimal precioReserva) {
        this.id = id;
        this.nombreTipo = nombreTipo;
        this.precioReserva = precioReserva;
        this.mesas = new ArrayList();
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
        return "TipoMesa{" + "id=" + id + ", nombreTipo=" + nombreTipo + ", precioReserva=" + precioReserva + '}';
    }

}
