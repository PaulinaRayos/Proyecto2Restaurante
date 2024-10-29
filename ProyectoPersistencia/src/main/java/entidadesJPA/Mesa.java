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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Mesa en la base de datos. Mapea la tabla
 * 'mesa' y define los atributos correspondientes, así como las relaciones con
 * otras entidades como TipoMesa y Restaurante. Contribuciones de Paulina
 * Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "mesa")
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador único de la mesa.
     */
    @Id
    @Column(name = "id_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Código identificador de la mesa.
     */
    @Column(name = "codigo_mesa", length = 30)
    private String codigoMesa;

    /**
     * Ubicación de la mesa en el restaurante (por ejemplo, terraza, ventana).
     */
    @Column(name = "ubicacion", length = 50)
    private String ubicacion;

    /**
     * Capacidad máxima de la mesa, es decir, cuántas personas puede acomodar.
     */
    @Column(name = "capacidad")
    private int capacidad;

    /**
     * Relación muchos a uno con la entidad TipoMesa. Cada mesa está asociada a
     * un tipo específico de mesa.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_mesa", nullable = false)
    private TipoMesa tipoMesa;

    /**
     * Relación muchos a uno con la entidad Restaurante. Cada mesa está asociada
     * a un restaurante específico.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;
    /**
     * Relación uno a muchos con la entidad HorarioMesa. Una mesa puede estar
     * asociada a múltiples horarios de mesa.
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
     * @param HorarioMesaList Lista de los horarioMesa
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
     * @param Id Id de la mesa.
     * @param codigoMesa Código de la mesa.
     * @param ubicacion Ubicación de la mesa.
     * @param capacidad Capacidad de la mesa.
     * @param tipoMesa Tipo de la mesa.
     * @param restaurante Restaurante al que pertenece la mesa.
     * @param HorarioMesaList Lista de los horarioMesa
     */
    public Mesa(Long Id, String codigoMesa, String ubicacion, int capacidad, TipoMesa tipoMesa, Restaurante restaurante, List<HorarioMesa> HorarioMesaList) {
        this.id = Id;
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
     * Obtiene el ID de la mesa.
     *
     * @return ID de la mesa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la mesa.
     *
     * @param id Nuevo ID de la mesa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el código de la mesa.
     *
     * @return código único de la mesa.
     */
    public String getCodigoMesa() {
        return codigoMesa;
    }

    /**
     * Establece el código de la mesa.
     *
     * @param codigoMesa Nuevo código para la mesa.
     */
    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    /**
     * Obtiene la ubicación de la mesa.
     *
     * @return Ubicación de la mesa.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa.
     *
     * @param ubicacion Nueva ubicación de la mesa.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene la capacidad de la mesa.
     *
     * @return Capacidad de personas de la mesa.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad de la mesa.
     *
     * @param capacidad Nueva capacidad de la mesa.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el tipo de mesa.
     *
     * @return Tipo de mesa.
     */
    public TipoMesa getTipoMesa() {
        return tipoMesa;
    }

    /**
     * Establece el tipo de mesa.
     *
     * @param tipoMesa Nuevo tipo de mesa.
     */
    public void setTipoMesa(TipoMesa tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    /**
     * Obtiene el restaurante al que pertenece la mesa.
     *
     * @return Restaurante asociado a la mesa.
     */
    public Restaurante getRestaurante() {
        return restaurante;
    }

    /**
     * Asigna el restaurante al que pertenece la mesa.
     *
     * @param restaurante Restaurante asociado a la mesa.
     */
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * Calcula el hash code de la mesa usando su ID.
     *
     * @return Hash code de la mesa.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si esta mesa es igual a otro objeto.
     *
     * @param object Objeto a comparar.
     * @return true si ambos objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     * Genera una representación en cadena de texto de la mesa.
     *
     * @return Cadena de texto que representa la mesa.
     */
    @Override
    public String toString() {
        return "Mesa{" + "id=" + id
                + ", codigoMesa=" + codigoMesa
                + ", ubicacion=" + ubicacion
                + ", capacidad=" + capacidad
                + ", tipoMesa=" + tipoMesa
                + ", restaurante=" + restaurante
                + ", HorarioMesaList=" + HorarioMesaList
                + '}';
    }

}
