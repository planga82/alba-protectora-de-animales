package com.base.entidades.ubicaciones;


import com.base.entidades.personas.Persona;
import com.base.interfaces.JsonObject;

import javax.persistence.ManyToOne;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class UbicacionPersona extends Ubicacion implements JsonObject{

    @ManyToOne(optional=true)
    private Persona persona;

	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "ubicaciones";
	}

	@Override
	public String getNombreMostrar() {
		// TODO Auto-generated method stub
		String nombre="";
		String apellidos="";
		if(persona.getNombre()!=null){
			nombre = persona.getNombre();
		}
		if(persona.getApellidos()!=null){
			apellidos = persona.getApellidos();
		}
		return nombre + " " + apellidos + " " + getNombre();
	}

   
}
