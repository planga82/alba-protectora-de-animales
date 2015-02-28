package com.servicios.personas;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.base.entidades.personas.Persona;
import com.base.entidades.personas.RelacionesALBA;
import com.base.entidades.ubicaciones.Ubicacion;
import com.base.entidades.ubicaciones.UbicacionPersona;
import com.constants.Constantes;
import com.constants.MensajesError;

public class PersonaService {

	static Logger logger = Logger.getLogger(PersonaService.class);
	
	public Persona alta(String nombre,
						String apellidos,
						String DNI,
						String telefono,
						String email,
						String calle,
						String numero,
						String codPostal,
						String poblacion,
						String provincia,
						String pais,
						String cuentaBancaria,
						String telefono2,
						String email2,
						String observaciones,
						Set<String> relacionesALBA){
		try{
			Persona p = new Persona();
			p.setNombre(nombre);
			p.setApellidos(apellidos);
			p.setDNI(DNI);
			p.setCalle(calle);
			p.setNumero(numero);
			p.setCodPostal(codPostal);
			p.setPoblacion(poblacion);
			p.setProvincia(provincia);
			p.setPais(pais);
			p.setTelefono(telefono);
			p.setTelefono2(telefono2);
			p.setEmail(email);
			p.setEmail2(email2);
			p.setCuentaBancaria(cuentaBancaria);
			p.setEstado(Constantes.estadoAlta);
			p.setMotivoBaja("");
			p.setObservaciones(observaciones);
			HashSet<RelacionesALBA> ra = new HashSet<RelacionesALBA>();
			Iterator<String> it = relacionesALBA.iterator();
			while (it.hasNext()) {
				String n = (String) it.next();
				RelacionesALBA r = new RelacionesALBA();
				r.setRelacion(n);
				ra.add(r);
			}
			p.setRelacionesALBA(ra);
			p.persist();
			return p;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}				
	}
	
	public Persona baja(long idPersona, String motivo) throws Exception{
		try{
			Persona p = Persona.findPersona(idPersona);
			if(p == null){
				throw new Exception(MensajesError.codPersonaNoExiste);
			}
			
			if(p.getEstado().equalsIgnoreCase(Constantes.estadoBaja)){
				throw new Exception(MensajesError.codPersonaYaDadaDeBaja);
			}
			
			Iterator<UbicacionPersona> it = p.getUbicaciones().iterator();
			while (it.hasNext()) {
				if(it.next().getAnimales().size() > 0){
					throw new Exception(MensajesError.codBajaUbicacionConAnimales);
				}				
			}
			
			p.setEstado(Constantes.estadoBaja);
			p.setMotivoBaja(motivo);
			p.setFechaBaja(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

			p.merge();
			
			return p;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Persona ponerAlta(long idPersona) throws Exception{
		try{
			Persona p = Persona.findPersona(idPersona);
			p.setEstado(Constantes.estadoAlta);
			p.setMotivoBaja(null);
			p.setFechaBaja(null);
			p.merge();
			
			return p;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Persona modificacion(long idPersona,
								String nombre,
								String apellidos,
								String DNI,
								String telefono,
								String email,
								String calle,
								String numero,
								String codPostal,
								String poblacion,
								String provincia,
								String pais,
								String cuentaBancaria,
								String telefono2,
								String email2,
								String observaciones,
								Set<String> relacionesALBA) throws Exception{
		try{
			Persona p = Persona.findPersona(idPersona);			
			if(p == null){
				throw new Exception(MensajesError.codPersonaNoExiste);
			}
			
			if(p.getEstado().equalsIgnoreCase(Constantes.estadoBaja)){
				throw new Exception(MensajesError.codPersonaYaDadaDeBaja);
			}
			
			p.setNombre(nombre);
			p.setApellidos(apellidos);
			p.setDNI(DNI);
			p.setCalle(calle);
			p.setNumero(numero);
			p.setCodPostal(codPostal);
			p.setPoblacion(poblacion);
			p.setProvincia(provincia);
			p.setPais(pais);
			p.setTelefono(telefono);
			p.setTelefono2(telefono2);
			p.setEmail(email);
			p.setEmail2(email2);
			p.setEstado(Constantes.estadoAlta);
			p.setCuentaBancaria(cuentaBancaria);
			p.setMotivoBaja("");
			p.setObservaciones(observaciones);
			HashSet<RelacionesALBA> ra = new HashSet<RelacionesALBA>();
			Iterator<String> it = relacionesALBA.iterator();
			while (it.hasNext()) {
				String n = (String) it.next();
				RelacionesALBA r = new RelacionesALBA();
				r.setRelacion(n);
				ra.add(r);
			}
			p.setRelacionesALBA(ra);
			p.merge();
			return p;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}				
	}
	
	public Ubicacion altaUbicacion(long idPersona, String nombreUbicacion) throws Exception{
		try{
			Persona p = Persona.findPersona(idPersona);			
			if(p == null){
				throw new Exception(MensajesError.codPersonaNoExiste);
			}
			
			Iterator<UbicacionPersona> it = p.getUbicaciones().iterator();
			while (it.hasNext()) {
				UbicacionPersona ubicacionPersona = (UbicacionPersona) it
						.next();
				if(ubicacionPersona.getNombre().equalsIgnoreCase(nombreUbicacion)){
					throw new Exception(MensajesError.codUbicacionYaExste);
				}
			}
			
			UbicacionPersona u = new UbicacionPersona();
			u.setNombre(nombreUbicacion);
			u.setPersona(p);
			u.persist();
			
			p.getUbicaciones().add(u);
			p.merge();
			
			return u;	
			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public void bajaUbicacion(long idUbicacion) throws Exception{
		
		try{
			UbicacionPersona u = UbicacionPersona.findUbicacionPersona(idUbicacion);
			if(u == null){
				throw new Exception(MensajesError.codUbicacionNoExste);
			}
			if(u.getAnimales().size() > 0){
				throw new Exception(MensajesError.codBajaUbicacionConAnimales);
			}
			Persona p = u.getPersona();
			p.getUbicaciones().remove(u);
			p.merge();
			u.remove();
				
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Persona detalle(long idPersona) throws Exception{
		
		try{
			Persona p = Persona.findPersona(idPersona);			
			if(p == null){
				throw new Exception(MensajesError.codPersonaNoExiste);
			}
			return p;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public List<Persona> consultaApellidos(String apellidos){		
		return Persona.findApellidos(apellidos);
	}
	

	public List<Persona> consultaNombre(String nombre){	
		return Persona.findNombre(nombre);
	}
	
	public List<Persona> consultaEstadoBaja(){
		return Persona.findEstado(Constantes.estadoBaja);
	}
	
	public List<Persona> consultaTexto(String texto, boolean incluirBajas, int maxResult){	
		if(texto==null) texto = "";
		if(incluirBajas){
			return Persona.findTexto(texto,maxResult);
		}else{
			return Persona.findTextoSinBajas(texto, maxResult);
		}
	}


}
