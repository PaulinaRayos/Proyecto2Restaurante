/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa la entidad Horario en la base de datos. Mapea la tabla
 * 'horario' y define los atributos correspondientes, así como las relaciones
 * con otras entidades, como Restaurante y HorarioMesa.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "horario")
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_horario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_semana")
    private String diaSemana;

    @Column(name = "hora_apertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaApertura;

    @Column(name = "hora_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaCierre;

    /**
     * Relación muchos a uno con la entidad Restaurante.
     * Un horario está asociado a un único restaurante.
     */
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    /**
     * Relación uno a muchos con la entidad HorarioMesa.
     * Un horario puede tener múltiples asignaciones de mesas.
     */ 
    @OneToMany(mappedBy = "horario", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<HorarioMesa> horarioMesaList;

    /**
     * Constructor vacío para crear una instancia de Horario.
     */
    public Horario() {
    }

    /**
     * Constructor que inicializa el Horario con un ID.
     *
     * @param id ID del horario.
     */
    public Horario(Long id) {
        this.id = id;
    }

    /**
     * Constructor que inicializa un Horario con los atributos proporcionados.
     *
     * @param diaSemana Día de la semana.
     * @param horaApertura Hora de apertura.
     * @param horaCierre Hora de cierre.
     * @param restaurante Restaurante asociado a este horario.
     * @param horarioMesaList Lista de horarios de mesa asociados.
     */
    public Horario(String diaSemana, Date horaApertura, Date horaCierre, Restaurante restaurante, List<HorarioMesa> horarioMesaList) {
        this.diaSemana = diaSemana;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.restaurante = restaurante;
        this.horarioMesaList = horarioMesaList;
    }

    /**
     * Constructor completo para inicializar un Horario con todos los atributos.
     *
     * @param id ID del horario.
     * @param diaSemana Día de la semana.
     * @param horaApertura Hora de apertura.
     * @param horaCierre Hora de cierre.
     * @param restaurante Restaurante asociado a este horario.
     * @param horarioMesaList Lista de horarios de mesa asociados.
     */
    public Horario(Long id, String diaSemana, Date horaApertura, Date horaCierre, Restaurante restaurante, List<HorarioMesa> horarioMesaList) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.restaurante = restaurante;
        this.horarioMesaList = horarioMesaList;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApartura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<HorarioMesa> getHorarioMesaList() {
        return horarioMesaList;
    }

    public void setHorarioMesaList(List<HorarioMesa> horarioMesaList) {
        this.horarioMesaList = horarioMesaList;
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
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", diaSemana=" + diaSemana + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", restaurante=" + restaurante + ", horarioMesaList=" + horarioMesaList + '}';
    }

}
