package com.jpa.eclipselink.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno")
    private Long idAlumno;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String matricula, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.email = email;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno= " + idAlumno +
                ", nombre= '" + nombre + '\'' +
                ", apellido= '" + apellido + '\'' +
                ", matricula= '" + matricula + '\'' +
                ", email= '" + email + '\'' +
                '}';
    }
}
