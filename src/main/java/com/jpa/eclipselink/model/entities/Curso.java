package com.jpa.eclipselink.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @Column(name = "profesor")
    private String profesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_alumno")
    private Alumno alumno;

    public Curso() {
    }

    public Curso(String nombreCurso, String profesor) {
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
