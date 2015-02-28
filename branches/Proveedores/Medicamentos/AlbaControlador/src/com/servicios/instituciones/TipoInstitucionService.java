package com.servicios.instituciones;

import java.util.List;
import org.apache.log4j.Logger;
import com.base.entidades.instituciones.TipoInstitucion;

public class TipoInstitucionService { 
	
	static Logger logger = Logger.getLogger(TipoInstitucionService.class);
	
	public TipoInstitucion alta(String nombre) throws Exception{
		try{			
			TipoInstitucion e = new TipoInstitucion();
			e.setNombreTipo(nombre);
			e.persist();
			return e;			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public List<TipoInstitucion> consulta() throws Exception{
		try{			
			return TipoInstitucion.findAllTipoInstitucions();			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	

}
