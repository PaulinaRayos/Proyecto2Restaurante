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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Cliente en la base de datos. Mapea la tabla
 * 'cliente' y define los atributos correspondientes, así como las relaciones
 * con otras entidades, en particular la relación con reservas.
 *
 * Esta clase implementa Serializable para permitir la serialización de objetos
 * Cliente. Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L; // Versión de la clase para serialización

    /**
     * Identificador único del cliente. Se genera automáticamente mediante
     * estrategia de identidad.
     */
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombres del cliente.
     */
    @Column(name = "nombres", length = 50)
    private String nombre;

    /**
     * Apellido paterno del cliente. Este campo no puede ser nulo.
     */
    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidoPaterno;

    /**
     * Apellido materno del cliente.
     */
    @Column(name = "apellido_materno", length = 50)
    private String apellidoMaterno;

    /**
     * Número telefónico del cliente. Este campo debe ser único en la base de
     * datos.
     */
    @Column(name = "telefono", unique = true, length = 255)
    private String telefono;

    /**
     * Relación uno a muchos con la entidad Reserva. Un cliente puede tener
     * múltiples reservas.
     */
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Reserva> reservas;

    /**
     * Constructor vacío que inicializa la lista de reservas.
     */
    public Cliente() {
        this.reservas = new ArrayList();
    }

    /**
     * Constructor que inicializa el cliente con un ID.
     *
     * @param id El ID del cliente.
     */
    public Cliente(Long id) {
        this.id = id;
        this.reservas = new ArrayList();
    }

    /**
     * Constructor que inicializa el cliente con los atributos dados.
     *
     * @param nombre El nombre del cliente.
     * @param apellidoPaterno El apellido paterno del cliente.
     * @param apellidoMaterno El apellido materno del cliente.
     * @param telefono El número de teléfono del cliente.
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.reservas = new ArrayList();
    }

    /**
     * Constructor que inicializa todos los atributos del cliente.
     *
     * @param id El ID del cliente.
     * @param nombre El nombre del cliente.
     * @param apellidoPaterno El apellido paterno del cliente.
     * @param apellidoMaterno El apellido materno del cliente.
     * @param telefono El número de teléfono del cliente.
     */
    public Cliente(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.reservas = new ArrayList();
    }

    /**
     * Obtiene el ID del cliente.
     *
     * @return ID del cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     *
     * @param id Nuevo ID del cliente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     *
     * @return Apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     *
     * @param apellidoPaterno Nuevo apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     *
     * @return Apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     *
     * @param apellidoMaterno Nuevo apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     *
     * @param telefono Nuevo número de teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Genera un código hash para el objeto Cliente, basado en el ID.
     *
     * @return Código hash del cliente.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si dos objetos Cliente son iguales, basándose en el ID.
     *
     * @param object Objeto a comparar.
     * @return {@code true} si los objetos son iguales, {@code false} en caso
     * contrario.
     */
    @Override
    public boolean equals(Object object) {
        // Advertencia: Este método no funciona si los campos de ID no están establecidos.
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Genera una representación en cadena de texto del objeto Cliente.
     *
     * @return Cadena de texto que representa al cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
                + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + '}';
    }

}
