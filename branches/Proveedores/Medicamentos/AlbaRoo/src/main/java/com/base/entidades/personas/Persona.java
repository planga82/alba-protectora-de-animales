package com.base.entidades.personas;


import com.base.entidades.animales.Animal;
import com.base.entidades.ubicaciones.UbicacionPersona;
import com.base.interfaces.JsonObject;
import com.base.interfaces.ResultadoBusquedaGeneral;
import com.base.utilidades.Utilidades;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Persona implements JsonObject,ResultadoBusquedaGeneral{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	private String nombre;

    private String apellidos;
    
    private String DNI;

    private String calle;
    
    private String numero;
    
    private String codPostal;
    
    private String poblacion;
    
    private String provincia;
    
    private String pais;

    private String telefono;

    private String email;

    private String estado;
    
    private String cuentaBancaria;
    
    private String telefono2;
    
    private String email2;

    private String motivoBaja;

    private Date fechaBaja;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<UbicacionPersona> ubicaciones = new HashSet<UbicacionPersona>();

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<RelacionesALBA> relacionesALBA = new HashSet<RelacionesALBA>();
    
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="personaPatrocinadora")
	private Set<Animal> animalesPatrocinados = new HashSet<Animal>();
    
	private String observaciones;
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	 
	
	public static List<Persona> findNombre(String nombre){
    	TypedQuery<Persona> q = entityManager().createQuery("SELECT a FROM Persona a WHERE a.nombre = :nombre", Persona.class);
        q.setParameter("nombre", nombre);
    	return q.getResultList();
    }
	
	public static List<Persona> findApellidos(String apellidos){
    	TypedQuery<Persona> q = entityManager().createQuery("SELECT a FROM Persona a WHERE a.apellidos = :apellidos", Persona.class);
        q.setParameter("apellidos", apellidos);
    	return q.getResultList();
    }
	
	public static List<Persona> findEstado(String estado){
    	TypedQuery<Persona> q = entityManager().createQuery("SELECT a FROM Persona a WHERE a.estado = :estado", Persona.class);
        q.setParameter("estado", estado);
    	return q.getResultList();
    }
	
	public static List<Persona> findTexto(String texto, int maxResult){
    	TypedQuery<Persona> q = entityManager().createQuery("SELECT a FROM Persona a WHERE " + Utilidades.clausulaWhere(Persona.class.getDeclaredFields()), Persona.class);
        q.setParameter("texto", "%" + texto + "%");
        q.setMaxResults(maxResult);
    	return q.getResultList();
    }
	
	public static List<Persona> findTextoSinBajas(String texto, int maxResult){
		TypedQuery<Persona> q = entityManager().createQuery("SELECT a FROM Persona a WHERE NOT(a.estado = 'BAJA') AND (" + Utilidades.clausulaWhere(Persona.class.getDeclaredFields()) + ")", Persona.class);
        q.setParameter("texto", "%" + texto + "%");
        q.setMaxResults(maxResult);
    	return q.getResultList();
    }
	
	

	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "resultadoBusquedaPersonas";
	}
    
    
}
