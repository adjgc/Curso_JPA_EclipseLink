package com.jpa.eclipselink.controller.dao;

import com.jpa.eclipselink.controller.util.JPAUtil;
import com.jpa.eclipselink.model.entities.Expediente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.Objects;

public class ExpedienteDAO {

    private EntityManager open(){
        return JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    private void close(EntityManager entityManager){
        entityManager.close();
    }

    public void insert(Expediente expediente){
        EntityManager entityManager = open();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(expediente);
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException(
                    String.format("Error al guardar el registros - %s - %s", expediente.toString(), ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public Expediente findById(long idExpediente){
        EntityManager entityManager = open();
        try {
            return entityManager.find(Expediente.class, idExpediente);
        }catch (Exception ex){
            throw new PersistenceException(
                    String.format("Error al obtener el registro con idExpediente - %s - %s", idExpediente, ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public void update(Expediente expediente){
        EntityManager entityManager = open();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(expediente);
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException(
                    String.format("Error al actualizar el registro - %s - %s", expediente.toString(), ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public void delete(long idExpediente){
        EntityManager entityManager = open();
        try {
            entityManager.getTransaction().rollback();
            Expediente expediente = entityManager.find(Expediente.class, idExpediente);
            if(Objects.nonNull(expediente)){
                entityManager.remove(expediente);
            }
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException(
                    String.format("Error al eliminar el registro con idExpediente - %s - %s", idExpediente, ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

}
