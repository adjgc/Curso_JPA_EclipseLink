package com.jpa.eclipselink.dao;

import com.jpa.eclipselink.entities.Alumno;
import com.jpa.eclipselink.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Objects;

public class AlumnoDAO {

    private EntityManager open(){
        return JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    private void close(EntityManager entityManager){
        entityManager.close();
    }

    public void insert(Alumno alumno){
        EntityManager entityManager = open();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(alumno);
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException(
                    String.format("Error al insertar el registro - %s - %s", alumno.toString(), ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public Alumno findById(Long idAlumno){
        EntityManager entityManager = open();
        try {
            return entityManager.find(Alumno.class, idAlumno);
        } catch (Exception ex) {
            throw new PersistenceException(
                    String.format("Error al obtener el registro con idAlumno - %s - %s", idAlumno, ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public List<Alumno> findAll(){
        EntityManager entityManager = open();
        try {
            return entityManager.createQuery("SELECT a FROM Alumno a",Alumno.class).getResultList();
        } catch (Exception ex) {
            throw new PersistenceException(
                    String.format("Error al obtener la lista completa de alumnos - %s", ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public List<Alumno> findAllPaged(int pageNumber, int pageSize){
        EntityManager entityManager = open();
        try {
            return entityManager.createQuery("SELECT a FROM Alumno a", Alumno.class)
                    .setFirstResult((pageNumber - 1) * pageSize)
                    .setMaxResults(pageNumber)
                    .getResultList();
        }catch (Exception ex){
            throw new PersistenceException(
                    String.format("Error en la paginación de alumnos - Página: %s - Tamaño: %s - %s",
                            pageNumber, pageNumber, ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public List<Alumno> finadAllCriteriaAPI(){
        EntityManager entityManager = open();
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Alumno> criteriaQuery = criteriaBuilder.createQuery(Alumno.class);
            Root<Alumno> root = criteriaQuery.from(Alumno.class);
            criteriaQuery.select(root);

            return entityManager.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            throw new PersistenceException(
                    String.format("Error en la consulta con CriteriaAPI - %s", ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public void update(Alumno alumno){
        EntityManager entityManager = open();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(alumno);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException(
                    String.format("Error al actualizar el registro - %s - %s", alumno.toString(), ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }

    public void deleteById(Long idAlumno){
        EntityManager entityManager = open();
        try {
            entityManager.getTransaction().begin();
            Alumno alumno = entityManager.find(Alumno.class, idAlumno);
            if(Objects.nonNull(alumno)){
                entityManager.remove(alumno);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException(
                    String.format("Error al eliminar el registro con idAlumno - %s - %s", idAlumno, ex.getMessage())
            );
        }finally {
            close(entityManager);
        }
    }
}
