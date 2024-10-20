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
 * Clase que representa la entidad HistorialReservas en la base de datos. Mapea
 * la tabla 'historial_reservas' y define los atributos correspondientes, así
 * como las relaciones con otras entidades.
 *
 * @author Cristopher Alberto Elizalde Andrade - 240005
 * @author Paulina Rodríguez Rodríguez Rayos - 117262
 */
@Entity
@Table(name = "historial_reservas")
public class HistorialReservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_historial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "fecha_hora_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraReserva;

    @Column(name = "multa")
    private BigDecimal multa;

    //Relación ManyToOne con Reserva
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    // Relación ManyToOne con TipoMesa
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_mesa", nullable = false)
    private TipoMesa tipoMesa;

    //Constructor vacío
    public HistorialReservas() {
    }

    //Constructor con Id
    public HistorialReservas(Long id) {
        this.id = id;
    }

    //Contructor sin Id
    public HistorialReservas(BigDecimal costo, String ubicacion, Date fechaHoraReserva, BigDecimal multa, Reserva reserva, TipoMesa tipoMesa) {
        this.costo = costo;
        this.ubicacion = ubicacion;
        this.fechaHoraReserva = fechaHoraReserva;
        this.multa = multa;
        this.reserva = reserva;
        this.tipoMesa = tipoMesa;
    }

    //Constructor completo
    public HistorialReservas(Long id, BigDecimal costo, String ubicacion, Date fechaHoraReserva, BigDecimal multa, Reserva reserva, TipoMesa tipoMesa) {
        this.id = id;
        this.costo = costo;
        this.ubicacion = ubicacion;
        this.fechaHoraReserva = fechaHoraReserva;
        this.multa = multa;
        this.reserva = reserva;
        this.tipoMesa = tipoMesa;
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Date fecha) {
        this.fechaHoraReserva = fecha;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public TipoMesa getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(TipoMesa tipoMesa) {
        this.tipoMesa = tipoMesa;
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
        if (!(object instanceof HistorialReservas)) {
            return false;
        }
        HistorialReservas other = (HistorialReservas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistorialReservas{" + "id=" + id + ", costo=" + costo + ", ubicacion=" + ubicacion + ", fechaHoraReserva=" + fechaHoraReserva + ", multa=" + multa + ", reserva=" + reserva + ", tipoMesa=" + tipoMesa + '}';
    }

}
