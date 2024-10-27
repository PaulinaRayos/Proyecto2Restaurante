/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
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
 * Además, establece relaciones con las entidades Cliente y Mesa.
 * Contribuciones de Paulina Rodríguez Rodríguez Rayos.
 * 
 * @author Cristopher Alberto Elizalde Andrade - 240005
 */
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(name = "numero_personas")
    private int numPersonas;

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_cancelacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancelacion;

    @Column(name = "multa")
    private BigDecimal multa;

    @Column(name = "fecha_hora_creada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCreada;

    /**
     * Relación muchos a uno con la entidad Cliente.
     * Cada reserva está asociada a un cliente específico que la realiza.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    /**
     * Relación muchos a uno con la entidad Mesa.
     * Cada reserva está asociada a una mesa específica.
     */
    @ManyToOne(fetch = FetchType.LAZY)
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public Date getFechaHoraCreada() {
        return fechaHoraCreada;
    }

    public void setFechaHoraCreada(Date fechaHoraCreada) {
        this.fechaHoraCreada = fechaHoraCreada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
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
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechaHora=" + fechaHora + ", numPersonas=" + numPersonas + ", costo=" + costo + ", estado=" + estado + ", fechaCancelacion=" + fechaCancelacion + ", multa=" + multa + ", cliente=" + cliente + ", mesa=" + mesa + '}';
    }

}
