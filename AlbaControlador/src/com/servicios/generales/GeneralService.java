package com.servicios.generales;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.base.interfaces.ResultadoBusquedaGeneral;
import com.servicios.animales.AnimalService;
import com.servicios.instituciones.InstitucionService;
import com.servicios.personas.PersonaService;
import com.servicios.proveedores.ProveedorService;


public class GeneralService {

	static Logger logger = Logger.getLogger(GeneralService.class);
	
	public Set<ResultadoBusquedaGeneral> consultaTexto(String texto, boolean incluirTodosEstados, int maxResult){
		HashSet<ResultadoBusquedaGeneral> resultado = new HashSet<>();
		if(texto == null || texto.equals("")){
			return resultado;
		}else{
			String[] palabras = texto.split(" ");
			for (int i = 0; i < palabras.length; i++) {
				resultado.addAll(new AnimalService().consultaTexto(palabras[i].trim(), incluirTodosEstados, maxResult));
				resultado.addAll(new PersonaService().consultaTexto(palabras[i].trim(), incluirTodosEstados, maxResult));
				resultado.addAll(new InstitucionService().consultaTexto(palabras[i].trim(), incluirTodosEstados, maxResult));
				resultado.addAll(new ProveedorService().consultaTexto(palabras[i].trim(), incluirTodosEstados, maxResult));
			}
			if(resultado.size()>maxResult){
				HashSet<ResultadoBusquedaGeneral> resultado1 = new HashSet<>();
				Iterator<ResultadoBusquedaGeneral> it = resultado.iterator();
				int numResultados=0;
				while (it.hasNext() && numResultados < maxResult) {
					resultado1.add(it.next());	
					numResultados++;
				}
				return resultado1;
			}else{
				return resultado;
			}
			
		}	
		
				
	}
	
	public Set<ResultadoBusquedaGeneral> consultaTextoPersonaInstitucion(String texto){
		HashSet<ResultadoBusquedaGeneral> resultado = new HashSet<>();
		if(texto == null || texto.equals("")){
			return resultado;
		}else{
			String[] palabras = texto.split(" ");
			for (int i = 0; i < palabras.length; i++) {
				resultado.addAll(new PersonaService().consultaTexto(palabras[i].trim(), false, 10));
				resultado.addAll(new InstitucionService().consultaTexto(palabras[i].trim(), false, 10));
			}
			return resultado;
			
		}	
		
				
	}
}
