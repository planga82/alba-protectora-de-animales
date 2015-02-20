package com.servicios.listados;


import java.lang.reflect.Field;
import java.sql.Date;
import java.util.List;
import java.util.Vector;


import org.apache.log4j.Logger;

import com.base.entidades.animales.Animal;
import com.base.entidades.instituciones.Institucion;
import com.base.entidades.personas.Persona;
import com.controladores.listados.Atributo;


public class ServiciosListados {

	static Logger logger = Logger.getLogger(ServiciosListados.class);
	
	public static List<Atributo> atributosEntidad(String entidad){
		try{
			Vector<Atributo> salida = new Vector<>();
			
			if(entidad == null || entidad.equals("")){
				return salida;
			}
			
			Vector<String> tiposIncluidos = new Vector<>();
			tiposIncluidos.add(Boolean.class.getSimpleName());
			tiposIncluidos.add(Date.class.getSimpleName());
			tiposIncluidos.add(String.class.getSimpleName());
			
			Vector<String> atributosExcluidos = new Vector<>();
						
			Field[] f = null;
			if(entidad.equalsIgnoreCase("ANIMAL")){
				f = Animal.class.getDeclaredFields();
			}
			if(entidad.equalsIgnoreCase("PERSONA")){
				f = Persona.class.getDeclaredFields();
			}
			if(entidad.equalsIgnoreCase("INSTITUCION")){
				f = Institucion.class.getDeclaredFields();
			}
			
			for (int i = 0; i < f.length; i++) {
				if(tiposIncluidos.contains(f[i].getType().getSimpleName()) &&
						!atributosExcluidos.contains(f[i].getName())){
					Atributo atr = new Atributo();
					atr.setNombre(f[i].getName());
					atr.setTipo(f[i].getType().getSimpleName());
					salida.add(atr);
				}
			}
			
			
			return salida;			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}		
	}
	
	
}
