package com.jpa.eclipselink.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "expedientes")
public class Expediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExpediente")
    private long idExpediente;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaInscripcion")
    private Date fechaInscripcion;
    @Column(name = "observaciones")
    private String observaciones;

    public Expediente() {
    }

    public Expediente(Date fechaInscripcion, String observaciones) {
        this.fechaInscripcion = fechaInscripcion;
        this.observaciones = observaciones;
    }

    public long getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(long idExpediente) {
        this.idExpediente = idExpediente;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Expediente{" +
                "idExpediente=" + idExpediente +
                ", fechaInscripcion=" + fechaInscripcion +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
