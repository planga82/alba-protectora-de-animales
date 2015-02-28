package com.servicios.animales;

import java.util.List;

import org.apache.log4j.Logger;

import com.base.entidades.animales.Especie;

public class EspecieService { 
	
	static Logger logger = Logger.getLogger(EspecieService.class);
	
	public Especie alta(String nombre) throws Exception{
		try{			
			Especie e = new Especie();
			e.setNombre(nombre);
			e.persist();
			return e;			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public List<Especie> consulta() throws Exception{
		try{			
			return Especie.findAllEspecies();			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	

}
