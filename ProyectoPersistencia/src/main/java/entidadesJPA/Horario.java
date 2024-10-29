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
 * con otras entidades, como Restaurante y HorarioMesa. Contribuciones de
 * Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "horario")
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador único del horario.
     */
    @Id
    @Column(name = "id_horario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Día de la semana para el horario (por ejemplo, Lunes, Martes, etc.).
     */
    @Column(name = "dia_semana", length = 30)
    private String diaSemana;

    /**
     * Hora de apertura del establecimiento.
     */
    @Column(name = "hora_apertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaApertura;

    /**
     * Hora de cierre del establecimiento.
     */
    @Column(name = "hora_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaCierre;

    /**
     * Relación muchos a uno con la entidad Restaurante. Un horario está
     * asociado a un único restaurante.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    /**
     * Relación uno a muchos con la entidad HorarioMesa. Un horario puede tener
     * múltiples asignaciones de mesas.
     */
    @OneToMany(mappedBy = "horario", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
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
    /**
     * Obtiene el ID del horario.
     *
     * @return ID del horario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del horario.
     *
     * @param id Nuevo ID del horario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el día de la semana asociado a este horario.
     *
     * @return Día de la semana.
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * Establece el día de la semana para este horario.
     *
     * @param diaSemana Nuevo día de la semana.
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * Obtiene la hora de apertura del horario.
     *
     * @return Hora de apertura.
     */
    public Date getHoraApertura() {
        return horaApertura;
    }

    /**
     * Establece la hora de apertura del horario.
     *
     * @param horaApertura Nueva hora de apertura.
     */
    public void setHoraApartura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Obtiene la hora de cierre del horario.
     *
     * @return Hora de cierre.
     */
    public Date getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre del horario.
     *
     * @param horaCierre Nueva hora de cierre.
     */
    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    /**
     * Obtiene el restaurante asociado a este horario.
     *
     * @return Restaurante asociado.
     */
    public Restaurante getRestaurante() {
        return restaurante;
    }

    /**
     * Establece el restaurante asociado a este horario.
     *
     * @param restaurante Nuevo restaurante asociado.
     */
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * Obtiene la lista de horarios de mesas asociadas a este horario.
     *
     * @return Lista de horarios de mesas.
     */
    public List<HorarioMesa> getHorarioMesaList() {
        return horarioMesaList;
    }

    /**
     * Establece la lista de horarios de mesas asociadas a este horario.
     *
     * @param horarioMesaList Nueva lista de horarios de mesas.
     */
    public void setHorarioMesaList(List<HorarioMesa> horarioMesaList) {
        this.horarioMesaList = horarioMesaList;
    }

    /**
     * Genera un código hash para el objeto Horario basado en su ID.
     *
     * @return Código hash del horario.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si dos objetos Horario son iguales, basándose en el ID.
     *
     * @param object Objeto a comparar.
     * @return {@code true} si los objetos son iguales, {@code false} en caso
     * contrario.
     */
    @Override
    public boolean equals(Object object) {
        // Advertencia: Este método no funciona si los campos de ID no están establecidos.
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Genera una representación en cadena de texto del objeto Horario.
     *
     * @return Cadena de texto que representa al horario.
     */
    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", diaSemana=" + diaSemana + ", horaApertura=" + horaApertura
                + ", horaCierre=" + horaCierre + ", restaurante=" + restaurante + ", horarioMesaList=" + horarioMesaList + '}';
    }

}
