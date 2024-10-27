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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad HorarioMesa en la base de datos. Mapea la
 * tabla 'horario_mesa' y define los atributos correspondientes, así como las
 * relaciones con otras entidades como Horario y Mesa.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "horario_mesa")
public class HorarioMesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_horario_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Relación muchos a uno con la entidad Horario.
     * Un horario de mesa está asociado a un único horario.
     */ 
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_horario", nullable = true)
    private Horario horario;

    /**
     * Relación muchos a uno con la entidad Mesa.
     * Un horario de mesa está asociado a una única mesa.
     */ 
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    /**
     * Constructor vacío para crear una instancia de HorarioMesa.
     */
    public HorarioMesa() {
    }

    /**
     * Constructor que inicializa una HorarioMesa con los atributos
     * proporcionados.
     *
     * @param horario Horario asociado a esta mesa.
     * @param mesa Mesa asociada a este horario.
     */
    public HorarioMesa(Horario horario, Mesa mesa) {
        this.horario = horario;
        this.mesa = mesa;
    }

    /**
     * Constructor completo para inicializar una HorarioMesa con todos los
     * atributos.
     *
     * @param id ID de la HorarioMesa.
     * @param horario Horario asociado a esta mesa.
     * @param mesa Mesa asociada a este horario.
     */
    public HorarioMesa(Long id, Horario horario, Mesa mesa) {
        this.id = id;
        this.horario = horario;
        this.mesa = mesa;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "HorarioMesa{" + "id=" + id + ", horario=" + horario + ", mesa=" + mesa + '}';
    }

}
