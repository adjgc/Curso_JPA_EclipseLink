package com.jpa.eclipselink;

import com.jpa.eclipselink.entities.Alumno;
import com.jpa.eclipselink.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            Alumno nuevoAlumno = new Alumno("Gemini", "Google", "0987654321", "gemini.google@correo.com");
            entityManager.getTransaction().begin();
            entityManager.persist(nuevoAlumno);
            entityManager.getTransaction().commit();
            System.out.println("¡Alumno guardado con éxito!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.err.println("Error en la persistencia: " + e.getMessage());
        } finally {
            entityManager.close();
            JPAUtil.close();
        }
    }
}