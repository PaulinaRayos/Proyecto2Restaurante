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
 * Clase que representa la entidad Restaurante en la base de datos. Mapea la
 * tabla 'restaurante' y define los atributos correspondientes, así como las
 * relaciones con otras entidades. Contribuciones de Paulina Rodríguez Rodríguez
 * Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador único del restaurante.
     */
    @Id
    @Column(name = "id_restaurante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Dirección del restaurante.
     */
    @Column(name = "direccion", length = 50, unique = true)
    private String direccion;

    /**
     * Ciudad donde se ubica el restaurante.
     */
    @Column(name = "ciudad", length = 50)
    private String ciudad;

    /**
     * Relación uno a muchos con la entidad Mesa. Cada restaurante puede tener
     * varias mesas asociadas.
     */
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Mesa> mesas;
    /**
     * Relación uno a muchos con la entidad Horario. Cada restaurante puede
     * tener varios horarios de operación.
     */
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Horario> horarios;

    /**
     * Constructor vacío que inicializa las listas de mesas y horarios.
     */
    public Restaurante() {
        this.mesas = new ArrayList();
        this.horarios = new ArrayList();
    }

    /**
     * Constructor que inicializa un restaurante con un ID, dirección y ciudad.
     *
     * @param id el identificador único del restaurante
     * @param dirrecion la dirección del restaurante
     * @param ciudad la ciudad donde se ubica el restaurante
     */
    public Restaurante(Long id, String dirrecion, String ciudad) {
        this.id = id;
        this.direccion = dirrecion;
        this.ciudad = ciudad;
        this.mesas = new ArrayList();
        this.horarios = new ArrayList();
    }

    /**
     * Constructor que inicializa un restaurante con dirección y ciudad.
     *
     * @param dirrecion la dirección del restaurante
     * @param ciudad la ciudad donde se ubica el restaurante
     */
    public Restaurante(String dirrecion, String ciudad) {
        this.direccion = dirrecion;
        this.ciudad = ciudad;
        this.mesas = new ArrayList();
        this.horarios = new ArrayList();
    }

    //Getters & Setters
    /**
     * Devuelve el ID del restaurante.
     *
     * @return ID del restaurante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del restaurante.
     *
     * @param id ID del restaurante.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve la lista de mesas del restaurante.
     *
     * @return Lista de mesas.
     */
    public List<Mesa> getMesas() {
        return mesas;
    }

    /**
     * Establece la lista de mesas del restaurante.
     *
     * @param mesas Lista de mesas.
     */
    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    /**
     * Devuelve la lista de horarios del restaurante.
     *
     * @return Lista de horarios.
     */
    public List<Horario> getHorarios() {
        return horarios;
    }

    /**
     * Establece la lista de horarios del restaurante.
     *
     * @param horarios Lista de horarios.
     */
    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    /**
     * Devuelve la dirección del restaurante.
     *
     * @return Dirección del restaurante.
     */
    public String getDirrecion() {
        return direccion;
    }

    /**
     * Establece la dirección del restaurante.
     *
     * @param dirrecion Dirección del restaurante.
     */
    public void setDirrecion(String dirrecion) {
        this.direccion = dirrecion;
    }

    /**
     * Devuelve la ciudad del restaurante.
     *
     * @return Ciudad del restaurante.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del restaurante.
     *
     * @param ciudad Ciudad del restaurante.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // Métodos de sobreescritura de Object
    /**
     * Calcula y devuelve el código hash para el restaurante, basado en su ID.
     *
     * @return Código hash del restaurante.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara este restaurante con otro objeto para verificar igualdad,
     * basándose en el campo ID.
     *
     * @param object Objeto a comparar.
     * @return Verdadero si los objetos son iguales, falso en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Restaurante)) {
            return false;
        }
        Restaurante other = (Restaurante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena de la clase `Restaurante`.
     *
     * @return Cadena de texto con los detalles del restaurante.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Restaurante{");
        sb.append("id=").append(id);
        sb.append(", direccion=").append(direccion);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", mesas=").append(mesas);
        sb.append(", horarios=").append(horarios);
        sb.append('}');
        return sb.toString();
    }

}
