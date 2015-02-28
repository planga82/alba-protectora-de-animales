package com.servicios.animales;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.base.entidades.animales.Animal;
import com.base.entidades.animales.Especie;
import com.base.entidades.animales.HistoricoPesos;
import com.base.entidades.animales.HistoricoUbicaciones;
//import com.base.entidades.animales.HistoricoUbicaciones;
import com.base.entidades.instituciones.Institucion;
import com.base.entidades.personas.Persona;
import com.base.entidades.ubicaciones.Ubicacion;
import com.base.entidades.ubicaciones.UbicacionInstitucion;
import com.base.entidades.ubicaciones.UbicacionPersona;
import com.constants.MensajesError;
import com.servicios.animales.objetos.FiltroAtributos;
import com.servicios.animales.objetos.FiltroAtributosBoolean;
import com.servicios.animales.objetos.FiltroAtributosDate;
import com.servicios.animales.objetos.FiltroAtributosString;

public class AnimalService {

	static Logger logger = Logger.getLogger(AnimalService.class);

	public Animal alta(String chip, String otraIdent, String nombre,
			String nombreEspecie, String raza, Date fechaNac, String sexo,
			Boolean esterilizado, String color, String tam, String propietario,
			Date fechRegistro, String descripcion, String rutaFoto,
			Double pesoActual, String lugarRecogida,
			Boolean recogidoAyuntamiento, String personaAvisa, Date fechaAvisa,
			String personaRecogido,  Date fechaRecogido, 
			String PersonaRecepcion,  Date fechaRecepcion, String estado, 
			Double alturaCruz, String extensionImagen) throws Exception {
		try {
			if (Animal.findChip(chip).size() > 0) {
				throw new Exception(MensajesError.codChipYaExistenteistema);
			}
			if (Animal.findOtraIdent(otraIdent).size() > 0) {
				throw new Exception(MensajesError.codSegundaIdYaExistenteistema);
			}

			Animal a = new Animal();
			a.setChip(chip);
			a.setEstado(estado);
			a.setFechaEstado(new Date(Calendar.getInstance().getTimeInMillis()));
			a.setSegundoIdentificador(otraIdent);
			a.setNombre(nombre);
			Especie e = null;
			if(nombreEspecie!=null){
				e = Especie.findEspecie(nombreEspecie);
				e.getAnimales().add(a);
			}			
			a.setEspecie(e);
			a.setRaza(raza);
			a.setFechaNacimiento(fechaNac);
			a.setSexo(sexo);
			a.setEsterilizado(esterilizado);
			a.setColor(color);
			a.setTamano(tam);
			a.setPropietario(propietario);
			a.setFechaRegistro(fechRegistro);
			a.setDescripcion(descripcion);
			a.setPesoActual(pesoActual);
			a.setFechaPesoActual(new Date(Calendar.getInstance()
					.getTimeInMillis()));
			a.setLugarRecogida(lugarRecogida);
			a.setRecogidoAyuntamiento(recogidoAyuntamiento);
			a.setPersonaAvisa(personaAvisa);
			a.setFechaAvisa(fechaAvisa);
			a.setPersonaRecoge(personaRecogido);
			a.setFechaRecoge(fechaRecogido);
			a.setPersonaRecepciona(PersonaRecepcion);
			a.setFechaRecepciona(fechaRecepcion);
			a.setAlturaCruz(alturaCruz);
			a.setExtensionImagen(extensionImagen);
			
			a.persist();
			if(nombreEspecie!=null){
				e.merge();
			}
			

			return a;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	public Animal modificacion(Long idAnimal, String chip, String otraIdent, String nombre,
			String raza, Date fechaNac, String sexo,
			Boolean esterilizado, String color, String tam, String propietario,
			Date fechNacimiento, String descripcion, String rutaFoto, String lugarRecogida,
			Boolean recogidoAyuntamiento, String personaAvisa, Date fechaAvisa,
			String personaRecogido, Date fechaRecogido, 
			String PersonaRecepcion, Date fechaRecepcion, Double alturaCruz) throws Exception {
		try {
			Animal a = Animal.findAnimal(idAnimal);
			if (a.getChip()!=null &&
					!a.getChip().equalsIgnoreCase(chip) && 
					Animal.findChip(chip).size() > 0) {
				throw new Exception(MensajesError.codChipYaExistenteistema);
			}
			if (a.getSegundoIdentificador()!=null && 
					!a.getSegundoIdentificador().equalsIgnoreCase(otraIdent) && 
					Animal.findOtraIdent(otraIdent).size() > 0) {
				throw new Exception(MensajesError.codSegundaIdYaExistenteistema);
			}
			
						
			a.setChip(chip);
			a.setSegundoIdentificador(otraIdent);
			a.setNombre(nombre);		
			a.setRaza(raza);
			a.setFechaNacimiento(fechaNac);
			a.setSexo(sexo);
			a.setEsterilizado(esterilizado);
			a.setColor(color);
			a.setTamano(tam);
			a.setPropietario(propietario);
			a.setFechaNacimiento(fechNacimiento);
			a.setDescripcion(descripcion);
			a.setLugarRecogida(lugarRecogida);
			a.setRecogidoAyuntamiento(recogidoAyuntamiento);
			a.setPersonaAvisa(personaAvisa);
			a.setFechaAvisa(fechaAvisa);
			a.setPersonaRecoge(personaRecogido);
			a.setFechaRecoge(fechaRecogido);
			a.setPersonaRecepciona(PersonaRecepcion);
			a.setFechaRecepciona(fechaRecepcion);
			a.setAlturaCruz(alturaCruz);
			
			a.merge();

			return a;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Animal modificacionExtensionImagen(Long idAnimal,String extensionImagen) throws Exception {
		try {
			Animal a = Animal.findAnimal(idAnimal);
			
			if(extensionImagen!= null && !extensionImagen.equals("")){
				a.setExtensionImagen(extensionImagen);
			}
			a.merge();

			return a;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Animal asignarPatrocinadorPersona(Long idAnimal, Long idPersona){
		try {	
			Animal a = Animal.findAnimal(idAnimal);			
			Persona nuevoPatrocinador = Persona.findPersona(idPersona);
			Persona patrocinadorActual = a.getPersonaPatrocinadora();
			Institucion patrocinadorIActual = a.getInstitucionPatrocinadora();
			
			nuevoPatrocinador.getAnimalesPatrocinados().add(a);
			if(patrocinadorActual!=null){
				patrocinadorActual.getAnimalesPatrocinados().remove(a);
				patrocinadorActual.merge();
			}
			if(patrocinadorIActual!=null){
				patrocinadorIActual.getAnimalesPatrocinados().remove(a);
				patrocinadorIActual.merge();
			}
			
			a.setPersonaPatrocinadora(nuevoPatrocinador);	
			a.setInstitucionPatrocinadora(null);
			nuevoPatrocinador.merge();	
			return a;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Animal asignarPatrocinadorInstitucion(Long idAnimal, String idInstitucion){
		try {	
			Animal a = Animal.findAnimal(idAnimal);			
			Institucion nuevoPatrocinador = Institucion.findInstitucion(idInstitucion);
			Institucion patrocinadorActual = a.getInstitucionPatrocinadora();
			Persona patrocinadorPActual = a.getPersonaPatrocinadora();
			
			nuevoPatrocinador.getAnimalesPatrocinados().add(a);
			if(patrocinadorActual!=null){
				patrocinadorActual.getAnimalesPatrocinados().remove(a);
				patrocinadorActual.merge();
			}
			if(patrocinadorPActual!=null){
				patrocinadorPActual.getAnimalesPatrocinados().remove(a);
				patrocinadorPActual.merge();
			}
			
			a.setInstitucionPatrocinadora(nuevoPatrocinador);	
			a.setPersonaPatrocinadora(null);
			nuevoPatrocinador.merge();	
			return a;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Animal desasignarPatrocinador(Long idAnimal){
		try {	
			Animal a = Animal.findAnimal(idAnimal);			
			Institucion patrocinadorActual = a.getInstitucionPatrocinadora();
			Persona patrocinadorPActual = a.getPersonaPatrocinadora();

			if(patrocinadorActual!=null){
				patrocinadorActual.getAnimalesPatrocinados().remove(a);
				patrocinadorActual.merge();
			}
			if(patrocinadorPActual!=null){
				patrocinadorPActual.getAnimalesPatrocinados().remove(a);
				patrocinadorPActual.merge();
			}
			
			a.setInstitucionPatrocinadora(null);	
			a.setPersonaPatrocinadora(null);
			a.merge();
			return a;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Animal cambioPeso(Long idAnimal, Double pesoActual) throws Exception{
		try {
			
			if(pesoActual < 0){
				throw new Exception(MensajesError.codPesoNegativo);
			}
			
			Animal a = Animal.findAnimal(idAnimal);			
			if(a.getPesoActual()!=null){
				HistoricoPesos hp = new HistoricoPesos();
				hp.setAnimal(a);
				hp.setFecha(a.getFechaPesoActual());
				hp.setPeso(a.getPesoActual());
			
				a.getHistoricoPesos().add(hp);
				hp.persist();
			}
			a.setPesoActual(pesoActual);
			a.setFechaPesoActual(new Date(Calendar.getInstance()
					.getTimeInMillis()));
			
			a.merge();

			return a;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Animal cambiarUbicacion(Long idAnimal, Long idNuevaUbicacion) throws Exception{
		
		try {	
			Animal a = Animal.findAnimal(idAnimal);			
			
			Ubicacion nuevaUbicacion = Ubicacion.findUbicacion(idNuevaUbicacion);
			
			Ubicacion ubActual = a.getUbicacionActual();
			//Lo asociamos a la nueva ubicacion
			nuevaUbicacion.getAnimales().add(a);
			
			
			if(ubActual!=null){
				//Desasociamos el animal de la actual ubicación
				ubActual.getAnimales().remove(a);
				//Pasamos la ubicación actual al historico
				HistoricoUbicaciones hu = new HistoricoUbicaciones();
				hu.setTextoidentAnimal("id: " + a.getId() + " Nombre: " + a.getNombre());
				hu.setFechaEntrada(a.getFechaUbicacionActual());
				hu.setFechaSalida(new Date(Calendar.getInstance()
						.getTimeInMillis()));
				hu.setTextoIdentUbicacion(ubActual.getNombreMostrar());			
				a.getHistoricoUbicaciones().add(hu);
				
				hu.persist();
				ubActual.merge();
			}
			//	Le asignamos la nueva ubicación y la fecha
			a.setUbicacionActual(nuevaUbicacion);
			a.setFechaUbicacionActual(new Date(Calendar.getInstance()
					.getTimeInMillis()));
			
			//Persistimos todo			
			nuevaUbicacion.merge();				
			//a.merge();

			return a;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
public Animal cambiarEstado(Long idAnimal, String nuevoEstado) throws Exception{
		
		try {	
			Animal a = Animal.findAnimal(idAnimal);
			a.setEstado(nuevoEstado);
			a.setFechaEstado(new Date(Calendar.getInstance().getTimeInMillis()));
			a.merge();			
			return a;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
public Animal cambiarEspecie(Long idAnimal, String nombreEspecie) throws Exception{
		
		try {	
			Animal a = Animal.findAnimal(idAnimal);
			Especie AntiguaEspecie = a.getEspecie();
			if(AntiguaEspecie != null){
				AntiguaEspecie.getAnimales().remove(a);
			}
			Especie NuevaEspecie = Especie.findEspecie(nombreEspecie);
			if(NuevaEspecie == null){
				throw new Exception(MensajesError.codNombreEspecieNoExiste);
			}
			NuevaEspecie.getAnimales().add(a);
			a.setEspecie(NuevaEspecie);
			if(AntiguaEspecie != null)
				AntiguaEspecie.merge();
			NuevaEspecie.merge();
			return a;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public Animal detalle(long idAnimal) throws Exception{
		try{
			Animal a = Animal.findAnimal(idAnimal);
			if(a==null){
				throw new Exception(MensajesError.codAnimalNoExiste);
			}
			return a;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}		
	}
	
	public List<Animal> consulta(boolean incluirTodosEstados){
    	
		if(incluirTodosEstados)
    		return Animal.findSinFiltro();
    	else
    		return Animal.findFiltroEstados();
    }
	
	 public List<Animal> consultaChip(String chip){
	    	
	    	return Animal.findChip(chip);
	    }
	    
	    public List<Animal> consultaOtraIdent(String otraIdentificacion){
	    	
	    	return Animal.findOtraIdent(otraIdentificacion);
	    }
	    
	    public List<Animal> consultaNombre(String nombre){
	    	
	    	return Animal.findNombre(nombre);
	    }
	    
	    public List<Animal> consultaRaza(String raza){
	    	
	    	return Animal.findRaza(raza);
	    }
	    
	    public List<Animal> consultaEsterilizado(Boolean esterilizado,  boolean incluirTodosEstados){
	    	if(incluirTodosEstados)
	    		return Animal.findEsterilizadoSinFiltro(esterilizado);
	    	else
	    		return Animal.findEsterilizadoFiltroEstados(esterilizado);
	    }
	    
	    public List<Animal> consultarecogidoAyuntamiento(Boolean recogidoAyuntamiento, Date fecheRegistroDesde, Date fecheRegistroHasta,  boolean incluirTodosEstados){
	    	if(incluirTodosEstados)
	    		return Animal.findrecogidoAyuntamientoSinFiltro(recogidoAyuntamiento,fecheRegistroDesde, fecheRegistroHasta);
	    	else
	    		return Animal.findrecogidoAyuntamientoFiltroEstados(recogidoAyuntamiento,fecheRegistroDesde, fecheRegistroHasta);
	    }
	    
	    public Set<Animal> consultaEspecie(String nombreEspecie){
	    	
	    	Set<Animal> r = new HashSet<Animal>();
	    	Especie e = Especie.findEspecie(nombreEspecie);
	    	if(e!=null){
	    		r = e.getAnimales();
	    	}
	    	return r;
	    } 
	    
	    public Set<Animal> consultaInstitucion(String nombreInstitucion){
	    	Set<Animal> r = new HashSet<Animal>();
	    	Institucion i = Institucion.findInstitucion(nombreInstitucion);
	    	if(i!=null){
	    		Iterator<UbicacionInstitucion> lu = i.getUbicaciones().iterator();
	    		while (lu.hasNext()) {
	    			UbicacionInstitucion ubicacionInstitucion = (UbicacionInstitucion) lu.next();
	    			r.addAll(ubicacionInstitucion.getAnimales());
	    		}
	    	}
	    	return r;
	    }
	    
	    public Set<Animal> consultaPersona(Long idPersona){
	    	
	    	HashSet<Animal> r = new HashSet<Animal>();
	    	Persona p = Persona.findPersona(idPersona);
	    	if(p!=null){
	    		Iterator<UbicacionPersona> lu = p.getUbicaciones().iterator();
	    		while (lu.hasNext()) {
	    			UbicacionPersona ubicacionPersona = (UbicacionPersona) lu.next();
	    			r.addAll(ubicacionPersona.getAnimales());
	    		}
	    	}
	    	return r;
	    }
	
	    public List<Animal> consultaTexto(String texto, boolean incluirTodosEstados, int maxResult){
	    	if(texto==null) texto = "";
	    	if(incluirTodosEstados){
	    		return Animal.findTextoSinFiltro(texto,maxResult);
	    	}else{
	    		return Animal.findTextoFiltroEstados(texto,maxResult);
	    	}
	    }
	    
	    public List<Animal> listadoFiltros(List<FiltroAtributos> atributos,String AndOr){
	    	StringBuffer query = new StringBuffer("SELECT a FROM Animal a ");
	    	if(clausulaWhere(atributos)){
	    		query.append("WHERE ");
	    	}
	    	
	    	Iterator<FiltroAtributos> it = atributos.iterator();
	    	Map<String,Object> parametros = new HashMap<>();
	    	Integer[] contB=new Integer[1],contS=new Integer[1],contD=new Integer[1];
	    	int i=0; contB[0]=0;contD[0]=0;contS[0]=0;
	    	
	    	while (it.hasNext()) {
	    		
				FiltroAtributos filtro = it.next();
				if(i!=0 && filtroNoNulo(filtro)){
					query.append(AndOr + " ");
				}
				
				if(filtro instanceof FiltroAtributosDate){
					query.append(condicionWhere((FiltroAtributosDate)filtro,parametros,contD));
				}
				if(filtro instanceof FiltroAtributosBoolean){
					query.append(condicionWhere((FiltroAtributosBoolean)filtro,parametros,contB));
				}
				if(filtro instanceof FiltroAtributosString){
					query.append(condicionWhere((FiltroAtributosString)filtro,parametros,contS));
				}
				i++;
				
			}
	 	    	
	    	return Animal.ejecutaQuery(query.toString(), parametros);
	    }
	    
	    private boolean clausulaWhere(List<FiltroAtributos> atributos){
	    	Iterator<FiltroAtributos> it = atributos.iterator();	    	
	    	while (it.hasNext()) {
				FiltroAtributos filtro = it.next();
				if(filtroNoNulo(filtro)){
					return true;
				}
			}
	    	return false;
	    }
	    
	    private String condicionWhere(FiltroAtributosString filtro, Map<String,Object> parametros, Integer[] contS){
	    	String salida = "";
	    	if(filtro.getValor() != null){
				salida =  "a." + filtro.getNombreAtributo() + " LIKE :" + filtro.getNombreAtributo() + contS[0] + " ";
				parametros.put(filtro.getNombreAtributo() + contS[0], "%" + ((FiltroAtributosString)filtro).getValor() + "%");
				contS[0]++;
			}
	    	return salida;
	    }
	    
	    private String condicionWhere(FiltroAtributosBoolean filtro, Map<String,Object> parametros, Integer[] contB){
	    	String salida = "";
	    	if(filtro.getValor() != null){
				salida =  "a." + filtro.getNombreAtributo() + " = :" + filtro.getNombreAtributo() + contB[0] + " ";
				parametros.put(filtro.getNombreAtributo() + contB[0], ((FiltroAtributosBoolean)filtro).getValor());
				contB[0]++;
			}
	    	return salida;
	    }
	    
	    private String condicionWhere(FiltroAtributosDate filtro, Map<String,Object> parametros, Integer[] contD){
	    	String salida = "";
	    	if(filtro.getFecha_desde() != null){
				salida+= "a." + filtro.getNombreAtributo() + " >= :" + filtro.getNombreAtributo() + "desde" + contD[0] + " ";
				parametros.put(filtro.getNombreAtributo() + "desde" + contD[0], ((FiltroAtributosDate)filtro).getFecha_desde());
				if(((FiltroAtributosDate)filtro).getFecha_hasta() != null)salida += "AND ";
			}
			if(((FiltroAtributosDate)filtro).getFecha_hasta() != null){
				salida+="a." + filtro.getNombreAtributo() + " <= :" + filtro.getNombreAtributo() + "hasta" + contD[0] + " ";
				parametros.put(filtro.getNombreAtributo() + "hasta" + contD[0], ((FiltroAtributosDate)filtro).getFecha_hasta());
			}
			contD[0]++;
	    	return salida;
	    }
	    
	    private boolean filtroNoNulo(FiltroAtributos filtro){
	    	if(filtro instanceof FiltroAtributosDate){
				if(((FiltroAtributosDate)filtro).getFecha_desde() != null){						
					return true;						
				}
				if(((FiltroAtributosDate)filtro).getFecha_hasta() != null){
					return true;
				}
			}
			if(filtro instanceof FiltroAtributosBoolean){
				if(((FiltroAtributosBoolean)filtro).getValor() != null){
					return true;
				}
			}
			if(filtro instanceof FiltroAtributosString){
				if(((FiltroAtributosString)filtro).getValor() != null){
					return true;
				}
			}
			return false;
	    }
}
