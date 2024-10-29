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
 * Clase que representa la entidad TipoMesa en la base de datos. Mapea la tabla
 * 'tipos_mesa' y define los atributos correspondientes, así como las relaciones
 * con otras entidades. Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "tipo_mesa")
public class TipoMesa implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador único del tipo de mesa.
     */
    @Id
    @Column(name = "id_tipo_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del tipo de mesa (por ejemplo, "Mesa para dos", "Mesa familiar").
     */
    @Column(name = "nombre_tipo", length = 50, nullable = false)
    private String nombreTipo;

    /**
     * Precio de reserva del tipo de mesa.
     */
    @Column(name = "precio_reserva", nullable = false)
    private BigDecimal precioReserva;

    /**
     * Relación uno a muchos con la entidad Mesa. Cada tipo de mesa puede estar
     * asociado a múltiples mesas.
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
     * Constructor que inicializa un tipo de mesa con nombre y precio de
     * reserva.
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
    /**
     * Devuelve el ID del tipo de mesa.
     *
     * @return ID del tipo de mesa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del tipo de mesa.
     *
     * @param id ID del tipo de mesa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del tipo de mesa.
     *
     * @return Nombre del tipo de mesa.
     */
    public String getNombreTipo() {
        return nombreTipo;
    }

    /**
     * Establece el nombre del tipo de mesa.
     *
     * @param nombreTipo Nombre del tipo de mesa.
     */
    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    /**
     * Devuelve el precio de reserva del tipo de mesa.
     *
     * @return Precio de reserva del tipo de mesa.
     */
    public BigDecimal getPrecioReserva() {
        return precioReserva;
    }

    /**
     * Establece el precio de reserva del tipo de mesa.
     *
     * @param precioReserva Precio de reserva del tipo de mesa.
     */
    public void setPrecioReserva(BigDecimal precioReserva) {
        this.precioReserva = precioReserva;
    }

    /**
     * Devuelve la lista de mesas asociadas a este tipo.
     *
     * @return Lista de mesas.
     */
    public List<Mesa> getMesas() {
        return mesas;
    }

    /**
     * Establece la lista de mesas asociadas a este tipo.
     *
     * @param mesas Lista de mesas.
     */
    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    // Métodos de sobreescritura de Object
    /**
     * Calcula y devuelve el código hash para el tipo de mesa, basado en su ID.
     *
     * @return Código hash del tipo de mesa.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara este tipo de mesa con otro objeto para verificar igualdad,
     * basándose en el campo ID.
     *
     * @param object Objeto a comparar.
     * @return Verdadero si los objetos son iguales, falso en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoMesa)) {
            return false;
        }
        TipoMesa other = (TipoMesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena de la clase `TipoMesa`.
     *
     * @return Cadena de texto con los detalles del tipo de mesa.
     */
    @Override
    public String toString() {
        return "TipoMesa{" + "id=" + id + ", nombreTipo=" + nombreTipo + ", precioReserva=" + precioReserva + '}';
    }

}
