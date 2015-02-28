package com.base.entidades.animales;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.base.interfaces.JsonObject;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class HistoricoUbicaciones implements JsonObject{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long identificador;
    
	private Date fechaEntrada;

    private Date fechaSalida;

    private String textoIdentUbicacion;
    
    private String textoidentAnimal;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (identificador ^ (identificador >>> 32));
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
		HistoricoUbicaciones other = (HistoricoUbicaciones) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}

	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "historicoUbicaciones";
	}
    
    
}
