package com.jpa.eclipselink;

import com.jpa.eclipselink.entities.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CursoJPAPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Alumno nuevoAlumno = new Alumno("Alexa", "Amazon", "1234567890", "alexa.amazon@correo.com");
            entityManager.getTransaction().begin();
            entityManager.persist(nuevoAlumno);
            entityManager.getTransaction().commit();
            System.out.println("¡Alumno guardado con éxito!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.err.println("Error en la persistencia: " + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}