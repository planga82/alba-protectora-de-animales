package com.servicios.instituciones;

import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.base.entidades.instituciones.Institucion;
import com.base.entidades.instituciones.TipoInstitucion;
import com.base.entidades.ubicaciones.Ubicacion;
import com.base.entidades.ubicaciones.UbicacionInstitucion;
import com.constants.Constantes;
import com.constants.MensajesError;

public class InstitucionService { 
	
	static Logger logger = Logger.getLogger(InstitucionService.class);
	
	public Institucion alta(String nombre, 
							String NIF, 
							String Dirección, 
							String PersonaContacto, 
							String TelefonoContacto, 
							String Email,
							String tipoInstitucion,
							String PaginaWeb,
							String CuentaCargo,
							String NombreDep1,
							String PersonaContactoDep1,
							String emailDep1,
							String TelefonoDep1,
							String NombreDep2,
							String PersonaContactoDep2,
							String emailDep2,
							String TelefonoDep2,
							String NombreDep3,
							String PersonaContactoDep3,
							String emailDep3,
							String TelefonoDep3) throws Exception{
		try{	
			Institucion i = Institucion.findInstitucion(nombre);
			if(i!=null){
				throw new Exception(MensajesError.codNombreInstitucionYaExiste);
			}
			i = new Institucion();
			i.setNombre(nombre);
			i.setNIF(NIF);
			i.setDireccion(Dirección);
			i.setPersonaContacto(PersonaContacto);
			i.setTelefonoContacto(TelefonoContacto);
			i.setEmailContacto(Email);
			i.setPaginaWeb(PaginaWeb);
			i.setCuentaCargo(CuentaCargo);
			i.setNombreDepartamento1(NombreDep1);
			i.setNombreDepartamento2(NombreDep2);
			i.setNombreDepartamento3(NombreDep3);
			i.setPersonaContactoDepartamento1(PersonaContactoDep1);
			i.setPersonaContactoDepartamento2(PersonaContactoDep2);
			i.setPersonaContactoDepartamento3(PersonaContactoDep3);
			i.setEmailDepartamento1(emailDep1);
			i.setEmailDepartamento2(emailDep2);
			i.setEmailDepartamento3(emailDep3);
			i.setTelefonoDepartamento1(TelefonoDep1);
			i.setTelefonoDepartamento2(TelefonoDep2);
			i.setTelefonoDepartamento3(TelefonoDep3);
			i.setEstado(Constantes.estadoAlta);
			
			TipoInstitucion ti=null;
			if(tipoInstitucion !=null){
				ti = TipoInstitucion.findTipoInstitucion(tipoInstitucion);
				if(ti == null){
					throw new Exception(MensajesError.codTipoInstitucionNoExiste);
				}
				ti.getInstituciones().add(i);				
			}
			i.setTipo(ti);
			
			i.persist();
			if(ti!=null)
				ti.merge();
			
			return i;					
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Institucion modificacion(String nombre, 
			String NIF, 
			String Dirección, 
			String PersonaContacto, 
			String TelefonoContacto, 
			String Email,
			String PaginaWeb,
			String CuentaCargo,
			String NombreDep1,
			String PersonaContactoDep1,
			String emailDep1,
			String TelefonoDep1,
			String NombreDep2,
			String PersonaContactoDep2,
			String emailDep2,
			String TelefonoDep2,
			String NombreDep3,
			String PersonaContactoDep3,
			String emailDep3,
			String TelefonoDep3) throws Exception{
		try{	
			try{	
				Institucion i = Institucion.findInstitucion(nombre);
				if(i==null){
					throw new Exception(MensajesError.codNombreInstitucionNoExiste);
				}
				if(i.getEstado().equalsIgnoreCase(Constantes.estadoBaja)){
					throw new Exception(MensajesError.codModificandoInstitucionEstBaja);
				}
				i.setNombre(nombre);
				i.setNIF(NIF);
				i.setDireccion(Dirección);
				i.setPersonaContacto(PersonaContacto);
				i.setTelefonoContacto(TelefonoContacto);
				i.setEmailContacto(Email);
				i.setPaginaWeb(PaginaWeb);
				i.setCuentaCargo(CuentaCargo);
				i.setNombreDepartamento1(NombreDep1);
				i.setNombreDepartamento2(NombreDep2);
				i.setNombreDepartamento3(NombreDep3);
				i.setPersonaContactoDepartamento1(PersonaContactoDep1);
				i.setPersonaContactoDepartamento2(PersonaContactoDep2);
				i.setPersonaContactoDepartamento3(PersonaContactoDep3);
				i.setEmailDepartamento1(emailDep1);
				i.setEmailDepartamento2(emailDep2);
				i.setEmailDepartamento3(emailDep3);
				i.setTelefonoDepartamento1(TelefonoDep1);
				i.setTelefonoDepartamento2(TelefonoDep2);
				i.setTelefonoDepartamento3(TelefonoDep3);
				
				i.merge();
				
				return i;					
			}catch(Exception e){
				logger.error(e.getMessage());
				throw e;
			}
			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Institucion cambiarTipo(String nombre,String nuevoTipo) throws Exception{
		try{	
			Institucion institucion = Institucion.findInstitucion(nombre);
			if(institucion == null){
				throw new Exception(MensajesError.codNombreInstitucionNoExiste);
			}
			
			TipoInstitucion nuevoTipoInstitucion = TipoInstitucion.findTipoInstitucion(nuevoTipo);
			if(nuevoTipoInstitucion == null){
				throw new Exception(MensajesError.codTipoInstitucionNoExiste);
			}
			
			TipoInstitucion antiguoTipoInstitucion = institucion.getTipo();
			
			if(antiguoTipoInstitucion != null){
					antiguoTipoInstitucion.getInstituciones().remove(institucion);
			}
			nuevoTipoInstitucion.getInstituciones().add(institucion);
			institucion.setTipo(nuevoTipoInstitucion);
			
			if(antiguoTipoInstitucion != null){
				antiguoTipoInstitucion.merge();
			}
			nuevoTipoInstitucion.merge();
			
			return institucion;
			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Institucion baja(String nombreInstitucion, String motivoBaja) throws Exception{
		
		try{
			Institucion institucion = Institucion.findInstitucion(nombreInstitucion);
			if(institucion == null){
				throw new Exception(MensajesError.codNombreInstitucionNoExiste);
			}			
			if(institucion.getEstado().equalsIgnoreCase(Constantes.estadoBaja)){
				throw new Exception(MensajesError.codInstitucionYaDadaDeBaja);
			}
			
			Iterator<UbicacionInstitucion> it = institucion.getUbicaciones().iterator();
			while (it.hasNext()) {
				if(it.next().getAnimales().size() > 0){
					throw new Exception(MensajesError.codBajaUbicacionConAnimales);
				}				
			}
			
			institucion.setEstado(Constantes.estadoBaja);
			institucion.setMotivoBaja(motivoBaja);
			institucion.setFechaBaja(new Date(Calendar.getInstance()
						.getTimeInMillis()));
			
			
			institucion.merge();
			
			return institucion;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Institucion ponerAlta(String nombreInstitucion) throws Exception{
		
		try{
			Institucion institucion = Institucion.findInstitucion(nombreInstitucion);
					
			institucion.setEstado(Constantes.estadoAlta);
			institucion.setMotivoBaja(null);
			institucion.setFechaBaja(null);
			institucion.merge();
			
			return institucion;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public UbicacionInstitucion altaUbicacion(String nombreInstitucion, String nombreUbicacion) throws Exception{
		
		try{
			if(nombreInstitucion == null){
				throw new Exception(MensajesError.codNombreInstitucionNulo);
			}
			if(nombreUbicacion == null){
				throw new Exception(MensajesError.codNombreUbicacionNulo);
			}
			
			Institucion i = Institucion.findInstitucion(nombreInstitucion);
			if(i == null){
				throw new Exception(MensajesError.codNombreInstitucionNoExiste);
			}
			
			Iterator<UbicacionInstitucion> it = i.getUbicaciones().iterator();
			while (it.hasNext()) {
				UbicacionInstitucion ubicacionInstitucion = (UbicacionInstitucion) it
						.next();
				if(ubicacionInstitucion.getNombre().equalsIgnoreCase(nombreUbicacion)){
					throw new Exception(MensajesError.codUbicacionYaExste);
				}
			}
			
			UbicacionInstitucion u = new UbicacionInstitucion();
			u.setNombre(nombreUbicacion);
			u.setInstitucion(i);
			u.persist();
			
			i.getUbicaciones().add(u);
			i.merge();
			
			return u;			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Ubicacion bajaUbicacion(long idUbicacion) throws Exception{
		
		try{			
			
			UbicacionInstitucion u = UbicacionInstitucion.findUbicacionInstitucion(idUbicacion);
			if(u == null){
				throw new Exception(MensajesError.codUbicacionNoExste);
			}
			
			if(u.getAnimales().size() > 0){
				throw new Exception(MensajesError.codBajaUbicacionConAnimales);
			}
			Institucion i = u.getInstitucion();
			i.getUbicaciones().remove(u);
			i.merge();
			u.remove();
			
			return u;			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Institucion detalle(String nombreInstitucion) throws Exception{
		try{
			Institucion i = Institucion.findInstitucion(nombreInstitucion);
			if(i==null){
				throw new Exception(MensajesError.codNombreInstitucionNoExiste);
			}
			return i;
				
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public List<Institucion> constultaNIF(String NIF){
		
		return Institucion.findNIF(NIF);
	}
	
	public List<Institucion> constultaPersonaContacto(String personaContacto){
		
		return Institucion.findpersonaContacto(personaContacto);
	}
	
	public Set<Institucion> constultaTipo(String tipoInstitucion) throws Exception{
		try{
			TipoInstitucion i = TipoInstitucion.findTipoInstitucion(tipoInstitucion);
			if(i==null){
				throw new Exception(MensajesError.codTipoInstitucionNoExiste);
			}
			return i.getInstituciones();
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public List<Institucion> constultaEstadoBaja(){		
		return Institucion.findEstado(Constantes.estadoBaja);
	}
	
	public List<Institucion> consultaTexto(String texto, boolean incluirBajas, int maxResult){
		if(texto==null) texto = "";
		if(incluirBajas){
			return Institucion.findTexto(texto,maxResult);
		}else{
			return Institucion.findTextoSinBajas(texto,maxResult);
		}
	}

}
