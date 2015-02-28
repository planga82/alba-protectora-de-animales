package com.base.entidades.instituciones;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.base.interfaces.JsonObject;


@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class TipoInstitucion implements JsonObject{

	@Id
    private String nombreTipo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Institucion> instituciones = new HashSet<Institucion>();

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombreTipo == null) ? 0 : nombreTipo.hashCode());
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
		TipoInstitucion other = (TipoInstitucion) obj;
		if (nombreTipo == null) {
			if (other.nombreTipo != null)
				return false;
		} else if (!nombreTipo.equalsIgnoreCase(other.nombreTipo))
			return false;
		return true;
	}

	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "tipoInstituciones";
	}
	
	
}
