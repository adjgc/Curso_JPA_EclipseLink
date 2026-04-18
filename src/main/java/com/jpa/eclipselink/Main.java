package com.jpa.eclipselink;

import com.jpa.eclipselink.model.entities.Alumno;
import com.jpa.eclipselink.controller.dao.AlumnoDAO;
import com.jpa.eclipselink.controller.util.JPAUtil;
import com.jpa.eclipselink.model.entities.Expediente;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        try {
            Expediente expediente = new Expediente(LocalDate.now(), "Este alumno pertenece a la clase de ML");
            Alumno alumno = new Alumno("DeepSeek", "High-Flyer", "deep.seek@correo.com", expediente);
            System.out.println("1: Inserción del Alumno con su respectivo expediente");
            alumnoDAO.insert(alumno);
            System.out.println("2: Recuperación del alumno");
            Alumno recuperado = alumnoDAO.findById(alumno.getIdAlumno());
            System.out.println("---------------------------------------------");
            System.out.println("**********DATOS DEL ALUMNO**********");
            System.out.println("Nombre: " + recuperado.getNombre() + " Apellido: " + recuperado.getApellido());
            System.out.println("Expediente del alumno: " + recuperado.getExpediente().toString());
        } catch (Exception e) {
            System.err.println("Error en la ejecución del flujo de consultas.");
            e.printStackTrace();
        }finally {
            JPAUtil.close();
        }
    }
}