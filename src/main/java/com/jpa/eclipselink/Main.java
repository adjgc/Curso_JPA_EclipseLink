package com.jpa.eclipselink;

import com.jpa.eclipselink.model.entities.Alumno;
import com.jpa.eclipselink.controller.dao.AlumnoDAO;
import com.jpa.eclipselink.controller.util.JPAUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            AlumnoDAO alumnoDAO = new AlumnoDAO();
            System.out.println("1: Inserción de Alumnos");
            Alumno alumno1 = new Alumno("Claude", "Code", "01928378465", "claude.code@correo.com");
            Alumno alumno2 = new Alumno("Copilot", "Microsoft", "6574839201", "copilot.microsoft@correo.com");

            alumnoDAO.insert(alumno1);
            alumnoDAO.insert(alumno2);

            System.out.println("\n2: Búsqueda por ID");
            Alumno buscado = alumnoDAO.findById(alumno1.getIdAlumno());
            System.out.println("Alumno recuperado: " + buscado);

            System.out.println("\n3: Actualización de alumno");
            buscado.setApellido("Anthropic");
            alumnoDAO.update(buscado);
            System.out.println("Actualización exitosa: " + alumnoDAO.findById(buscado.getIdAlumno()));

            System.out.println("\n4: Lista de todos los alumnos guardados");
            List<Alumno> lista = alumnoDAO.findAll();
            lista.forEach(System.out::println);

            System.out.println("\nEliminación de alumno");
            alumnoDAO.deleteById(alumno2.getIdAlumno());
        } catch (Exception e) {
            System.err.println("Error en la ejecución del flujo de consultas.");
            e.printStackTrace();
        }finally {
            JPAUtil.close();
        }
    }
}