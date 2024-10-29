/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa la entidad Reserva en la base de datos. Mapea la tabla
 * 'reservas' y define los atributos correspondientes, así como las relaciones
 * con otras entidades.
 *
 * Esta clase incluye información sobre la fecha y hora de la reserva, el número
 * de personas, el costo, el estado, y los posibles cargos por cancelación.
 * Además, establece relaciones con las entidades Cliente y Mesa. Contribuciones
 * de Paulina Rodríguez Rodríguez Rayos.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador único de la reserva.
     */
    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha y hora de la reserva.
     */
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    /**
     * Número de personas para la reserva.
     */
    @Column(name = "numero_personas")
    private int numPersonas;

    /**
     * Costo total de la reserva.
     */
    @Column(name = "costo")
    private BigDecimal costo;

    /**
     * Estado de la reserva (por ejemplo, confirmada, cancelada).
     */
    @Column(name = "estado")
    private String estado;

    /**
     * Fecha de cancelación de la reserva, si corresponde.
     */
    @Column(name = "fecha_cancelacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancelacion;

    /**
     * Multa aplicada en caso de cancelación, si corresponde.
     */
    @Column(name = "multa")
    private BigDecimal multa;

    /**
     * Fecha y hora en que se creó la reserva.
     */
    @Column(name = "fecha_hora_creada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCreada;

    /**
     * Relación muchos a uno con la entidad Cliente. Cada reserva está asociada
     * a un cliente específico que la realiza.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    /**
     * Relación muchos a uno con la entidad Mesa. Cada reserva está asociada a
     * una mesa específica.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    /**
     * Crea una nueva instancia de Reserva sin inicializar los atributos.
     */
    public Reserva() {
    }

    /**
     * Crea una nueva instancia de Reserva con un ID especificado.
     *
     * @param id el identificador único de la reserva
     */
    public Reserva(Long id) {
        this.id = id;
    }

    /**
     * Crea una nueva instancia de Reserva con todos los atributos necesarios,
     * excepto el ID.
     *
     * @param fechaHora la fecha y hora en que se realiza la reserva
     * @param numPersonas el número de personas para la reserva
     * @param costo el costo total de la reserva
     * @param estado el estado actual de la reserva
     * @param fechaCancelacion la fecha de cancelación de la reserva (si aplica)
     * @param multa el monto de la multa por cancelación (si aplica)
     * @param fechaHoraCreada la fecha y hora en que se creó la reserva
     * @param cliente el cliente asociado a la reserva
     * @param mesa la mesa asociada a la reserva
     */
    public Reserva(Date fechaHora, int numPersonas, BigDecimal costo, String estado, Date fechaCancelacion, BigDecimal multa, Date fechaHoraCreada, Cliente cliente, Mesa mesa) {
        this.fechaHora = fechaHora;
        this.numPersonas = numPersonas;
        this.costo = costo;
        this.estado = estado;
        this.fechaCancelacion = fechaCancelacion;
        this.multa = multa;
        this.fechaHoraCreada = fechaHoraCreada;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    /**
     * Crea una nueva instancia de Reserva con todos los atributos, incluyendo
     * el ID.
     *
     * @param id el identificador único de la reserva
     * @param fechaHora la fecha y hora en que se realiza la reserva
     * @param numPersonas el número de personas para la reserva
     * @param costo el costo total de la reserva
     * @param estado el estado actual de la reserva
     * @param fechaCancelacion la fecha de cancelación de la reserva (si aplica)
     * @param multa el monto de la multa por cancelación (si aplica)
     * @param fechaHoraCreada la fecha y hora en que se creó la reserva
     * @param cliente el cliente asociado a la reserva
     * @param mesa la mesa asociada a la reserva
     */
    public Reserva(Long id, Date fechaHora, int numPersonas, BigDecimal costo, String estado, Date fechaCancelacion, BigDecimal multa, Date fechaHoraCreada, Cliente cliente, Mesa mesa) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.numPersonas = numPersonas;
        this.costo = costo;
        this.estado = estado;
        this.fechaCancelacion = fechaCancelacion;
        this.multa = multa;
        this.fechaHoraCreada = fechaHoraCreada;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    //Getters & Setters
    /**
     * Obtiene el ID de la reserva.
     *
     * @return ID de la reserva.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la reserva.
     *
     * @param id Nuevo ID de la reserva.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de la reserva.
     *
     * @return Fecha y hora de la reserva.
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la reserva.
     *
     * @param fechaHora Nueva fecha y hora de la reserva.
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el número de personas de la reserva.
     *
     * @return Número de personas en la reserva.
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     * Establece el número de personas en la reserva.
     *
     * @param numPersonas Número de personas para la reserva.
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * Obtiene el costo de la reserva.
     *
     * @return Costo de la reserva.
     */
    public BigDecimal getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la reserva.
     *
     * @param costo Nuevo costo de la reserva.
     */
    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    /**
     * Obtiene el estado de la reserva.
     *
     * @return Estado de la reserva.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la reserva.
     *
     * @param estado Nuevo estado de la reserva.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de cancelación de la reserva.
     *
     * @return Fecha de cancelación de la reserva.
     */
    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    /**
     * Establece la fecha de cancelación de la reserva.
     *
     * @param fechaCancelacion Nueva fecha de cancelación de la reserva.
     */
    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    /**
     * Obtiene la multa por cancelación de la reserva.
     *
     * @return Multa por cancelación de la reserva.
     */
    public BigDecimal getMulta() {
        return multa;
    }

    /**
     * Establece la multa por cancelación de la reserva.
     *
     * @param multa Nueva multa de cancelación de la reserva.
     */
    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    /**
     * Obtiene la fecha y hora de creación de la reserva.
     *
     * @return Fecha y hora en que se creó la reserva.
     */
    public Date getFechaHoraCreada() {
        return fechaHoraCreada;
    }

    /**
     * Establece la fecha y hora de creación de la reserva.
     *
     * @param fechaHoraCreada Nueva fecha y hora de creación de la reserva.
     */
    public void setFechaHoraCreada(Date fechaHoraCreada) {
        this.fechaHoraCreada = fechaHoraCreada;
    }

    /**
     * Obtiene el cliente asociado con la reserva.
     *
     * @return Cliente de la reserva.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Asigna un cliente a la reserva.
     *
     * @param cliente Cliente asociado con la reserva.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la mesa asignada para la reserva.
     *
     * @return Mesa asignada para la reserva.
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Asigna una mesa a la reserva.
     *
     * @param mesa Mesa asignada para la reserva.
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * Calcula el código hash para la reserva.
     *
     * @return Código hash basado en el ID de la reserva.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta reserva con otro objeto para determinar si son iguales.
     *
     * @param object Objeto a comparar.
     * @return true si ambos objetos representan la misma reserva, false en caso
     * contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     * Genera una representación en cadena de texto de la reserva.
     *
     * @return Cadena de texto que representa la reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechaHora=" + fechaHora + ", numPersonas=" + numPersonas + ", costo=" + costo + ", estado=" + estado + ", fechaCancelacion=" + fechaCancelacion + ", multa=" + multa + ", cliente=" + cliente + ", mesa=" + mesa + '}';
    }

}
