package com.jpa.eclipselink.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "expedientes")
public class Expediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExpediente")
    private long idExpediente;
    @Column(name = "fechaInscripcion")
    private LocalDate fechaInscripcion;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToOne(mappedBy = "expediente")
    private Alumno alumno;

    public Expediente() {
    }

    public Expediente(LocalDate fechaInscripcion, String observaciones) {
        this.fechaInscripcion = fechaInscripcion;
        this.observaciones = observaciones;
    }

    public long getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(long idExpediente) {
        this.idExpediente = idExpediente;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
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
