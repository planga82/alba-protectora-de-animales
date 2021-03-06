// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.base.entidades.ubicaciones;

import com.base.entidades.ubicaciones.Ubicacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Ubicacion_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Ubicacion.entityManager;
    
    public static final List<String> Ubicacion.fieldNames4OrderClauseFilter = java.util.Arrays.asList("idInterno", "nombre", "animales");
    
    public static final EntityManager Ubicacion.entityManager() {
        EntityManager em = new Ubicacion() {
            public java.lang.String getNombreMostrar() {
                throw new UnsupportedOperationException();
            }
        }.entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Ubicacion.countUbicacions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Ubicacion o", Long.class).getSingleResult();
    }
    
    public static List<Ubicacion> Ubicacion.findAllUbicacions() {
        return entityManager().createQuery("SELECT o FROM Ubicacion o", Ubicacion.class).getResultList();
    }
    
    public static List<Ubicacion> Ubicacion.findAllUbicacions(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Ubicacion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Ubicacion.class).getResultList();
    }
    
    public static Ubicacion Ubicacion.findUbicacion(long idInterno) {
        return entityManager().find(Ubicacion.class, idInterno);
    }
    
    public static List<Ubicacion> Ubicacion.findUbicacionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Ubicacion o", Ubicacion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Ubicacion> Ubicacion.findUbicacionEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Ubicacion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Ubicacion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Ubicacion.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Ubicacion.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Ubicacion attached = Ubicacion.findUbicacion(this.idInterno);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Ubicacion.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Ubicacion.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Ubicacion Ubicacion.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Ubicacion merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
