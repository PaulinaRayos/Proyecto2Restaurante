/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Mesa en la base de datos. Mapea la tabla
 * 'mesa' y define los atributos correspondientes, así como las relaciones con
 * otras entidades como TipoMesa y Restaurante.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "mesa")
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_mesa")
    private String codigoMesa;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "capacidad")
    private int capacidad;

    /**
     * Relación muchos a uno con la entidad TipoMesa.
     * Cada mesa está asociada a un tipo específico de mesa.
     */     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_mesa", nullable = false)
    private TipoMesa tipoMesa;

    /**
     * Relación muchos a uno con la entidad Restaurante.
     * Cada mesa está asociada a un restaurante específico.
     */ 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;
    /**
     * Relación uno a muchos con la entidad HorarioMesa.
     * Una mesa puede estar asociada a múltiples horarios de mesa.
     */ 
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<HorarioMesa> HorarioMesaList;

    /**
     * Constructor vacío para crear una instancia de Mesa.
     */
    public Mesa() {
    }

    /**
     * Constructor que inicializa una Mesa con el ID proporcionado.
     *
     * @param id ID de la mesa.
     */
    public Mesa(Long id) {
        this.id = id;
    }

    /**
     * Constructor que inicializa una Mesa con sus atributos.
     *
     * @param codigoMesa Código de la mesa.
     * @param ubicacion Ubicación de la mesa.
     * @param capacidad Capacidad de la mesa.
     * @param tipoMesa Tipo de la mesa.
     * @param restaurante Restaurante al que pertenece la mesa.
     * @param HorarioMesaList
     */
    public Mesa(String codigoMesa, String ubicacion, int capacidad, TipoMesa tipoMesa, Restaurante restaurante, List<HorarioMesa> HorarioMesaList) {
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipoMesa = tipoMesa;
        this.restaurante = restaurante;
        this.HorarioMesaList = HorarioMesaList;
    }

    /**
     * Constructor completo para inicializar una Mesa con todos los atributos.
     *
     * @param Id
     * @param codigoMesa Código de la mesa.
     * @param ubicacion Ubicación de la mesa.
     * @param capacidad Capacidad de la mesa.
     * @param tipoMesa Tipo de la mesa.
     * @param restaurante Restaurante al que pertenece la mesa.
     * @param HorarioMesaList
     */
    public Mesa(Long Id, String codigoMesa, String ubicacion, int capacidad, TipoMesa tipoMesa, Restaurante restaurante, List<HorarioMesa> HorarioMesaList) {
        this.id = id;
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipoMesa = tipoMesa;
        this.restaurante = restaurante;
        this.HorarioMesaList = HorarioMesaList;
    }

    /**
     * Constructor que inicializa una Mesa con los atributos básicos.
     *
     * @param codigoMesa Código de la mesa.
     * @param ubicacion Ubicación de la mesa.
     * @param capacidad Capacidad de la mesa.
     */
    public Mesa(String codigoMesa, String ubicacion, int capacidad) {
        this.codigoMesa = codigoMesa;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    //Getters & Setters

    /**
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return codigoMesa
     */
    public String getCodigoMesa() {
        return codigoMesa;
    }

    /**
     *
     * @param codigoMesa
     */
    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    /**
     *
     * @return ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     *
     * @param ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     *
     * @return capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     *
     * @param capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     *
     * @return
     */
    public TipoMesa getTipoMesa() {
        return tipoMesa;
    }

    /**
     *
     * @param tipoMesa tipoMesa
     */
    public void setTipoMesa(TipoMesa tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    /**
     *
     * @return restaurante
     */
    public Restaurante getRestaurante() {
        return restaurante;
    }

    /**
     *
     * @param restaurante
     */
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    /**
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return boolean
     */
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

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Mesa{" + "id=" + id +
                ", codigoMesa=" + codigoMesa +
                ", ubicacion=" + ubicacion +
                ", capacidad=" + capacidad +
                ", tipoMesa=" + tipoMesa +
                ", restaurante=" + restaurante +
                ", HorarioMesaList=" + HorarioMesaList +
                '}';
    }

}
