package com.jpa.eclipselink.controller.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory entityManagerFactory = crearEntityManagerFactory();

    private static EntityManagerFactory crearEntityManagerFactory(){
        try {
            return Persistence.createEntityManagerFactory("CursoJPAPU");
        }catch (Throwable ex){
            System.err.println("No se pudo crear la fábirca: " + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void close(){
        if(entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }
}
