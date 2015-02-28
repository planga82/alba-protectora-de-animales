package com.base.entidades.instituciones;


import com.base.entidades.animales.Animal;
import com.base.entidades.ubicaciones.UbicacionInstitucion;
import com.base.interfaces.JsonObject;
import com.base.interfaces.ResultadoBusquedaGeneral;
import com.base.utilidades.Utilidades;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Institucion implements JsonObject,ResultadoBusquedaGeneral{

	@Id
    private String nombre;

    private String NIF; 

    private String direccion;

    private String personaContacto;

    private String telefonoContacto;

    private String emailContacto;

    private String estado;

    private String motivoBaja;

    private Date fechaBaja;

   @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
   private Set<UbicacionInstitucion> ubicaciones = new HashSet<UbicacionInstitucion>();

   	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="institucionPatrocinadora")
	private Set<Animal> animalesPatrocinados = new HashSet<Animal>();
   
    private String paginaWeb;

    private String cuentaCargo;

    private String nombreDepartamento1;

    private String personaContactoDepartamento1;

    private String emailDepartamento1;

    private String telefonoDepartamento1;

    private String nombreDepartamento2;

    private String personaContactoDepartamento2;

    private String emailDepartamento2;

    private String telefonoDepartamento2;

    private String nombreDepartamento3;

    private String personaContactoDepartamento3;

    private String emailDepartamento3;

    private String telefonoDepartamento3;

    @ManyToOne(optional=true)
    private TipoInstitucion tipo;
    
    public static List<Institucion> findNIF(String NIF){
    	TypedQuery<Institucion> q = entityManager().createQuery("SELECT a FROM Institucion a WHERE a.NIF = :NIF", Institucion.class);
        q.setParameter("NIF", NIF);
    	return q.getResultList();
    }
    
    public static List<Institucion> findpersonaContacto(String personaContacto){
    	TypedQuery<Institucion> q = entityManager().createQuery("SELECT a FROM Institucion a WHERE a.personaContacto = :personaContacto", Institucion.class);
        q.setParameter("personaContacto", personaContacto);
    	return q.getResultList();
    }
    
    public static List<Institucion> findEstado(String estado){
    	TypedQuery<Institucion> q = entityManager().createQuery("SELECT a FROM Institucion a WHERE a.estado = :estado", Institucion.class);
        q.setParameter("estado", estado);
    	return q.getResultList();
    }
    
   
    
    public static List<Institucion> findTexto(String texto, int maxResult){
    	
    	//TypedQuery<Institucion> q = entityManager().createQuery("SELECT a FROM Institucion a WHERE (a.nombre LIKE :texto) OR (a.NIF LIKE :texto) OR (a.direccion LIKE :texto) OR(a.personaContacto LIKE :texto) OR (a.telefonoContacto LIKE :texto) OR (a.emailContacto LIKE :texto) OR (a.paginaWeb LIKE :texto) OR (a.cuentaCargo LIKE :texto) OR (a.nombreDepartamento1 LIKE :texto) OR (a.personaContactoDepartamento1 LIKE :texto) OR (a.emailDepartamento1 LIKE :texto) OR (a.telefonoDepartamento1 LIKE :texto) OR (a.nombreDepartamento2 LIKE :texto) OR (a.personaContactoDepartamento2 LIKE :texto) OR (a.emailDepartamento2 LIKE :texto) OR (a.telefonoDepartamento2 LIKE :texto) OR (a.nombreDepartamento3 LIKE :texto) OR (a.personaContactoDepartamento3 LIKE :texto) OR (a.emailDepartamento3 LIKE :texto) OR (a.telefonoDepartamento3 LIKE :texto) OR (a.tipo.nombreTipo IN (SELECT b.nombreTipo FROM TipoInstitucion b WHERE (b.nombreTipo LIKE :texto)))", Institucion.class);
    	
    	TypedQuery<Institucion> q = entityManager().createQuery("SELECT a FROM Institucion a WHERE " + Utilidades.clausulaWhere(Institucion.class.getDeclaredFields()), Institucion.class);
    	q.setParameter("texto", "%" + texto + "%");
    	q.setMaxResults(maxResult);
    	return q.getResultList();
    }
    
    public static List<Institucion> findTextoSinBajas(String texto, int maxResult){
    	TypedQuery<Institucion> q = entityManager().createQuery("SELECT a FROM Institucion a WHERE NOT(a.estado = 'BAJA') AND (" + Utilidades.clausulaWhere(Institucion.class.getDeclaredFields()) + ")", Institucion.class);
    	q.setParameter("texto", "%" + texto + "%");
    	q.setMaxResults(maxResult);
    	return q.getResultList();
    }
    
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Institucion other = (Institucion) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}

	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "resultadoBusquedaInstituciones";
	}
    
    
}
