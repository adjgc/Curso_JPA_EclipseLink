package com.jpa.eclipselink;

import com.jpa.eclipselink.model.entities.Alumno;
import com.jpa.eclipselink.controller.dao.AlumnoDAO;
import com.jpa.eclipselink.controller.util.JPAUtil;
import com.jpa.eclipselink.model.entities.Curso;
import com.jpa.eclipselink.model.entities.Expediente;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        try {
            System.out.println("---------------------------------------------");
            Alumno alu = new Alumno("Elon", "Musk", "elon.musk@correo.com", new Expediente(LocalDate.now(), "Este alumno pertenece a la clase de Algoritmos Genéticos"));
            Curso c1 = new Curso("Algoritmos Genéticos", "Coello");
            Curso c2 = new Curso("Space X", "Tesla");
            alu.addCurso(c1);
            alu.addCurso(c2);
            alumnoDAO.insert(alu);
        } catch (Exception e) {
            System.err.println("Error en la ejecución del flujo de consultas.");
            e.printStackTrace();
        }finally {
            JPAUtil.close();
        }
    }
}