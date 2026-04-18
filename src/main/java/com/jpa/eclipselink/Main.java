package com.jpa.eclipselink;

import com.jpa.eclipselink.controller.dao.ExpedienteDAO;
import com.jpa.eclipselink.model.entities.Alumno;
import com.jpa.eclipselink.controller.dao.AlumnoDAO;
import com.jpa.eclipselink.controller.util.JPAUtil;
import com.jpa.eclipselink.model.entities.Expediente;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ExpedienteDAO expedienteDAO = new ExpedienteDAO();
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        try {
            System.out.println("1: Inserción de Expediente");
            Expediente expediente = new Expediente(new Date(), "Alumno de la carrera de IA");
            expedienteDAO.insert(expediente);
            System.out.println("2: Inserción de Alumno");
            Alumno alumno = new Alumno("Claude", "Code", "claude.code@correo.com", expediente);
            alumnoDAO.insert(alumno);

            Alumno recuperado = alumnoDAO.findById(1L);
            System.out.println("---------------------------------------------");
            System.out.println("**********DATOS DEL ALUMNO**********");
            System.out.println("Nombre: " + recuperado.getNombre() + " Apellido: " + recuperado.getApellido());
            System.out.println("El alumno está asociado al expediente: " + recuperado.getExpediente().toString());
        } catch (Exception e) {
            System.err.println("Error en la ejecución del flujo de consultas.");
            e.printStackTrace();
        }finally {
            JPAUtil.close();
        }
    }
}