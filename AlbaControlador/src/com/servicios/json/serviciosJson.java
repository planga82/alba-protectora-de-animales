package com.servicios.json;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.base.entidades.animales.Animal;
import com.base.entidades.animales.Especie;
import com.base.entidades.animales.HistoricoPesos;
import com.base.entidades.animales.HistoricoUbicaciones;
import com.base.entidades.instituciones.Institucion;
import com.base.entidades.instituciones.TipoInstitucion;
import com.base.entidades.personas.Persona;
import com.base.entidades.personas.RelacionesALBA;
import com.base.entidades.proveedores.Proveedor;
import com.base.entidades.ubicaciones.UbicacionInstitucion;
import com.base.entidades.ubicaciones.UbicacionPersona;
import com.base.interfaces.JsonObject;
import com.controladores.listados.Atributo;

public class serviciosJson {

	static Logger logger = Logger.getLogger(serviciosJson.class);
	
	@SuppressWarnings("unchecked")
	public static String generaRetorno(boolean success, String mensaje) throws IOException{
		 try {
			 
			 JSONObject obj=new JSONObject();
			 obj.put("success",success);
			 obj.put("msg",mensaje);			  
			 StringWriter out1 = new StringWriter();
			 obj.writeJSONString(out1);
			 return out1.toString();
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
		  
		
	}
	
	@SuppressWarnings("unchecked")
	public static String generaRetorno(boolean success, String mensaje, Map<String,String> valores) throws IOException{
		 try {
			 
			 JSONObject obj=new JSONObject();
			 obj.put("success",success);
			 obj.put("msg",mensaje);
			 Iterator<String> it = valores.keySet().iterator();
			 while (it.hasNext()) {
				String key = (String) it.next();
				obj.put(key,valores.get(key));
			}			 
			 StringWriter out1 = new StringWriter();
			 obj.writeJSONString(out1);
			 return out1.toString();
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
		  
		
	}
	
	/*
	 * {"nombre":"pepito" , "apellidos":perez"}
	 */
	private static String generaRecord(Map<String,String> valores){
		StringBuffer salida = new StringBuffer();
		salida.append("{");		
		Iterator<String> it = valores.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String value = valores.get(key);			
			salida.append("\"" + key + "\"");
			salida.append(":");		
			salida.append("\""+ value +"\"");
			if(it.hasNext()) salida.append(",");
		}
		
		salida.append("}");
		
		return salida.toString();
	}
	
	
	
	
	/* Genera un formato de este estilo
	 * {
		    "identificador": [
		       {
		           "id": 1,
		           "name": "Ed Spencer",
		           "email": "ed@sencha.com"
		       },
		       {
		           "id": 2,
		           "name": "Abe Elias",
		           "email": "abe@sencha.com"
		       }
		    ]
		}
	 */
	private static String generaListado(String identificador,List<Map<String,String>> valores){
		Iterator<Map<String,String>> en = valores.iterator();
		StringBuffer salida = new StringBuffer();
		salida.append("{");
		salida.append("\"" + identificador +"\": [");
		while (en.hasNext()) {				
			Map<String,String> next = en.next();				
			salida.append(serviciosJson.generaRecord(next));
			if(en.hasNext()) salida.append(",");				
		}
		salida.append("]");
		salida.append("}");
		
		return salida.toString();
	}
	
	
	public static String generaJson(String identificadorListado, List<JsonObject> objetos, String textoBuscado){

		List<Map<String, String>> listado = new Vector<>();
		Iterator<JsonObject> it = objetos.iterator();
		while (it.hasNext()) {
			listado.add(generaJSonObjeto((JsonObject) it.next(),textoBuscado));
		}
		
		return serviciosJson.generaListado(identificadorListado, listado);
	}
	
	
	
	private static Map<String, String> generaJSonObjeto(JsonObject e, String textoBuscado){
		
		if(e instanceof Especie)
			return generaJSonObjeto((Especie)e);
		if(e instanceof Animal)
			return generaJSonObjeto((Animal)e,textoBuscado);
		if(e instanceof TipoInstitucion)
			return generaJSonObjeto((TipoInstitucion)e);
		if(e instanceof Persona)
			return generaJSonObjeto((Persona)e,textoBuscado);
		if(e instanceof Institucion)
			return generaJSonObjeto((Institucion)e,textoBuscado);
		if(e instanceof UbicacionPersona)
			return generaJSonObjeto((UbicacionPersona)e);
		if(e instanceof UbicacionInstitucion)
			return generaJSonObjeto((UbicacionInstitucion)e);
		if(e instanceof HistoricoPesos)
			return generaJSonObjeto((HistoricoPesos)e);
		if(e instanceof HistoricoUbicaciones)
			return generaJSonObjeto((HistoricoUbicaciones)e);
		if(e instanceof Atributo)
			return generaJSonObjeto((Atributo)e);
		if(e instanceof Proveedor)
			return generaJSonObjeto((Proveedor)e,textoBuscado);
		
		return null;
	}
	
	private static Map<String, String> generaJSonObjeto(Especie e){
		Map<String, String> valores = new HashMap<>();
		valores.put("nombre", ((Especie)e).getNombre());
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(Atributo e){
		Map<String, String> valores = new HashMap<>();
		valores.put("nombre", ((Atributo)e).getNombre());
		valores.put("tipo", ((Atributo)e).getTipo());
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(TipoInstitucion e){
		Map<String, String> valores = new HashMap<>();
		valores.put("nombreTipo", ((TipoInstitucion)e).getNombreTipo());
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(Animal e, String textoBuscado){
		
		Map<String, String> valores = new HashMap<>();
		String descripcionResultado = "";
		String info="";
		valores.put("tipoResultado", "Animal");
		
		valores.put("id", String.valueOf(e.getId()));
		if(e.getNombre() !=null){
			valores.put("nombre", e.getNombre());
			info += " nombre:" + e.getNombre();
			if(e.getNombre().contains(textoBuscado)){
				descripcionResultado += " | Nombre:" + e.getNombre();
			}
		}
		if((e.getChip() !=null)){
			valores.put("chip", e.getChip());
			info += " chip:" + e.getChip();
			if(e.getChip().contains(textoBuscado)){
				descripcionResultado += " | chip:" + e.getChip();
			}
		}
		if(e.getSegundoIdentificador() !=null){
			valores.put("segundoIdentificador", e.getSegundoIdentificador());
			info += " segundoIdentificador:" + e.getSegundoIdentificador();
			if(e.getSegundoIdentificador().contains(textoBuscado)){
				descripcionResultado += " | SegundoIdentificador:" + e.getSegundoIdentificador();
			}
		}	
		if(e.getRaza() !=null){
			valores.put("raza", e.getRaza());
			info += " raza:" + e.getRaza();
			if(e.getRaza().contains(textoBuscado)){
				descripcionResultado += " | Raza:" + e.getRaza();
			}
		}
		if(e.getFechaNacimiento() !=null){
			info += " fechaNacimiento:" + e.getFechaNacimiento().toString();
			valores.put("fechaNacimiento",e.getFechaNacimiento().toString());
		}
		if(e.getSexo() !=null){			
			valores.put("sexo", e.getSexo());
		}
		if(e.getEsterilizado() !=null){
			valores.put("esterilizado", e.getEsterilizado().toString());
		}
		if(e.getColor() !=null){
			valores.put("color", e.getColor());
			info += " color:" + e.getColor();
			if(e.getColor().contains(textoBuscado)){
				descripcionResultado += " | Color:" + e.getColor();
			}
		}
		if(e.getTamano() !=null){
			info += " tamano:" + e.getTamano();
			valores.put("tamano", e.getTamano());
		}
		if(e.getPropietario() !=null){
			valores.put("propietario", e.getPropietario());
			info += " propietario:" + e.getPropietario();
			if(e.getPropietario().contains(textoBuscado)){
				descripcionResultado += " | Propietario:" + e.getPropietario();
			}
		}
		if(e.getFechaRegistro() !=null){
			info += " fechaRegistro:" + e.getFechaRegistro().toString();
			valores.put("fechaRegistro", e.getFechaRegistro().toString());
		}
		if(e.getDescripcion() !=null){
			valores.put("descripcion", e.getDescripcion());
			info += " descripcion:" + e.getDescripcion();
			if(e.getDescripcion().contains(textoBuscado)){
				descripcionResultado += " | Descripcion:" + e.getDescripcion();
			}
		}
		if(e.getLugarRecogida() !=null){
			info += " lugarRecogida:" + e.getLugarRecogida();
			valores.put("lugarRecogida", e.getLugarRecogida());
			if(e.getLugarRecogida().contains(textoBuscado)){
				descripcionResultado += " | LugarRecogida:" + e.getLugarRecogida();
			}
		}
		if(e.getPersonaPatrocinadora() !=null){
			valores.put("textoPatrocinador", e.getPersonaPatrocinadora().getNombre() + " " + e.getPersonaPatrocinadora().getApellidos());
			valores.put("txtMuestraMasInfo", generaJSonObjeto(e.getPersonaPatrocinadora(), "").get("info"));
		}
		if(e.getInstitucionPatrocinadora() != null){
			valores.put("textoPatrocinador", e.getInstitucionPatrocinadora().getNombre());
			valores.put("txtMuestraMasInfo", generaJSonObjeto(e.getInstitucionPatrocinadora(), "").get("info"));
		}
		if(e.getPersonaAvisa() !=null){
			info += " personaAvisa:" + e.getPersonaAvisa();
			valores.put("personaAvisa", e.getPersonaAvisa());
			if(e.getPersonaAvisa().contains(textoBuscado)){
				descripcionResultado += " | PersonaAvisa:" + e.getPersonaAvisa();
			}
		}
		if(e.getPersonaRecoge() !=null){
			info += " personaRecoge:" + e.getPersonaRecoge();
			valores.put("personaRecoge", e.getPersonaRecoge());
			if(e.getPersonaRecoge().contains(textoBuscado)){
				descripcionResultado += " | PersonaRecoge:" + e.getPersonaRecoge();
			}
		}
		if(e.getPersonaRecepciona() !=null){
			info += " personaRecepciona:" + e.getPersonaRecepciona();
			valores.put("personaRecepciona", e.getPersonaRecepciona());
			if(e.getPersonaRecepciona().contains(textoBuscado)){
				descripcionResultado += " | PersonaRecepciona:" + e.getPersonaRecepciona();
			}
		}
		if(e.getPesoActual() !=null){
			info += " pesoActual:" + e.getPesoActual().toString();
			valores.put("pesoActual", e.getPesoActual().toString());
		}
		if(e.getFechaPesoActual() !=null){
			valores.put("fechaPesoActual", e.getFechaPesoActual().toString());
		}
		if(e.getFechaUbicacionActual() !=null){
			valores.put("fechaUbicacionActual", e.getFechaUbicacionActual().toString());
		}
		if(e.getUbicacionActual() !=null){
			info += " nombreUbicacionActual:" + e.getUbicacionActual().getNombreMostrar();
			valores.put("idUbicacionActual", String.valueOf(e.getUbicacionActual().getIdInterno()));
			valores.put("nombreUbicacionActual", e.getUbicacionActual().getNombreMostrar());
		}
		if(e.getEspecie() !=null){
			info += " especie:" + e.getEspecie().getNombre();
			valores.put("especie", e.getEspecie().getNombre());
			if(e.getEspecie().getNombre().contains(textoBuscado)){
				descripcionResultado += " | Especie:" + e.getEspecie().getNombre();
			}
		}
		if(e.getEstado() !=null){
			valores.put("estado", e.getEstado());
			if(e.getEstado().contains(textoBuscado)){
				descripcionResultado += " | Estado:" + e.getEstado();
			}
		}
		
		if(e.getFechaRecoge() !=null){
			valores.put("fechaRecogido", e.getFechaRecoge().toString());
		}
		if(e.getFechaAvisa() !=null){
			valores.put("fechaAvisa", e.getFechaAvisa().toString());
		}
		if(e.getFechaRecepciona() !=null){
			valores.put("fechaRecepcion", e.getFechaRecepciona().toString());
		}
		if(e.getAlturaCruz() !=null){
			info += " alturaCruz:" + e.getAlturaCruz();
			valores.put("alturaCruz", Integer.toString(e.getAlturaCruz().intValue()));
		}
		String extensionImagen = e.getExtensionImagen();
		if(extensionImagen !=null && !extensionImagen.equals("")){
			valores.put("imagen", String.valueOf(Long.valueOf(e.getId()).intValue()) + "." + e.getExtensionImagen());
		}else{
			valores.put("imagen","SinImagen.jpg");
		}
		
		valores.put("descripcionResultado", descripcionResultado);
		valores.put("info", info);
		
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(UbicacionPersona e){
		Map<String, String> valores = new HashMap<>();
		valores.put("idInterno", String.valueOf(e.getIdInterno()));
		if(e.getPersona() !=null)
			if(e.getPersona().getNombre() !=null)
				valores.put("idPersona", String.valueOf(e.getPersona().getId()));
		if(e.getNombre() !=null)
			valores.put("nombre", e.getNombre());
		
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(UbicacionInstitucion e){
		Map<String, String> valores = new HashMap<>();
		valores.put("idInterno", String.valueOf((e).getIdInterno()));
		if(e.getInstitucion() !=null){
			if(e.getInstitucion().getNombre() !=null)
				valores.put("nombreInstitucion", ((UbicacionInstitucion)e).getInstitucion().getNombre());
		}
		if(e.getNombre() !=null)
			valores.put("nombre", ((UbicacionInstitucion)e).getNombre());
		
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(HistoricoPesos e){
		Map<String, String> valores = new HashMap<>();
		
		valores.put("identificador", String.valueOf(e.getIdentificador()));
		if(e.getPeso() !=null)
			valores.put("peso", String.valueOf(e.getPeso()));
		if(e.getFecha() !=null)
			valores.put("fecha", e.getFecha().toString());
		
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(HistoricoUbicaciones e){
		Map<String, String> valores = new HashMap<>();
		
		if(e.getTextoIdentUbicacion() !=null)
			valores.put("textoIdentUbicacion", String.valueOf(e.getTextoIdentUbicacion()));
		if(e.getFechaEntrada() !=null)
			valores.put("fechaEntrada", String.valueOf(e.getFechaEntrada().toString()));
		if(e.getFechaSalida() !=null)
			valores.put("fechaSalida", e.getFechaSalida().toString());
		
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(Persona e, String textoBuscado){
		Map<String, String> valores = new HashMap<>();
		valores.put("idPersona", String.valueOf(((Persona)e).getId()));
		valores.put("tipoResultado", "Persona");
		String info="";
		valores.put("tipoResultado", "Persona");
		
		String nombre =((Persona)e).getNombre();
		String apellidos = ((Persona)e).getApellidos();
		String DNI = ((Persona)e).getDNI();
		String telefono = ((Persona)e).getTelefono();
		String email = ((Persona)e).getEmail();
		String estado = ((Persona)e).getEstado();
		Date fechaBaja = ((Persona)e).getFechaBaja();
		String motivoBaja = ((Persona)e).getMotivoBaja();
		String calle = ((Persona)e).getCalle();
		String numero = ((Persona)e).getNumero();
		String codPostal = ((Persona)e).getCodPostal();
		String poblacion = ((Persona)e).getPoblacion();
		String provincia = ((Persona)e).getProvincia();
		String pais = ((Persona)e).getPais();
		String cuentaBancaria = ((Persona)e).getCuentaBancaria();
		String telefono2 = ((Persona)e).getTelefono2();
		String email2 = ((Persona)e).getEmail2();
		String observaciones = ((Persona)e).getObservaciones();			
		Set<RelacionesALBA> relacionesALBA = ((Persona)e).getRelacionesALBA();
		Iterator<RelacionesALBA> it = relacionesALBA.iterator();
		while (it.hasNext()) {
			String relacion = it.next().getRelacion();
			valores.put(relacion, relacion);
		}
		String descripcionResultado = "";
		
		
		String nombreApelidos="";
		if(nombre !=null){
			info += " nombre:" + nombre;
			valores.put("nombrePersona", nombre);
			nombreApelidos += nombre;
			if(nombre.contains(textoBuscado)){
				descripcionResultado += " | Nombre:" + nombre;
			}
		}
		if(apellidos !=null){
			valores.put("apellidos", apellidos);
			info += " apellidos:" + apellidos;
			nombreApelidos += " " + apellidos;
			if(apellidos.contains(textoBuscado)){
				descripcionResultado += " | Apellidos:" + apellidos;
			}
		}
		valores.put("nombreApellidos", nombreApelidos);
		
		
		if(DNI !=null){
			info += " DNI:" + DNI;
			valores.put("DNI", DNI);
			if(DNI.contains(textoBuscado)){
				descripcionResultado += " | DNI:" + DNI;
			}
		}
		if(telefono !=null){
			info += " telefono:" + telefono;
			valores.put("telefono", telefono);
			if(telefono.contains(textoBuscado)){
				descripcionResultado += " | Telefono:" + telefono;
			}
		}
		if(email !=null){
			info += " email:" + email;
			valores.put("email", email);
			if(email.contains(textoBuscado)){
				descripcionResultado += " | email:" + email;
			}
		}
		
		if(estado !=null){
			valores.put("estado", estado);
		}
		
		if(fechaBaja !=null){
			valores.put("fechaBaja", fechaBaja.toString());
		}
		
		if(motivoBaja !=null){
			valores.put("motivoBaja", motivoBaja);
		}
		if(calle !=null){
			info += " calle:" + calle;
			valores.put("calle", calle);
			if(calle.contains(textoBuscado)){
				descripcionResultado += " | Calle:" + calle;
			}
		}
		if(numero !=null){
			info += " numero:" + numero;
			valores.put("numero", numero);
			if(numero.contains(textoBuscado)){
				descripcionResultado += " | Numero:" + numero;
			}
		}
		if(codPostal !=null){
			info += " codPostal:" + codPostal;
			valores.put("codPostal", codPostal);
			if(codPostal.contains(textoBuscado)){
				descripcionResultado += " | Cod. Postal:" + codPostal;
			}
		}
		if(poblacion !=null){
			info += " poblacion:" + poblacion;
			valores.put("poblacion", poblacion);
			if(poblacion.contains(textoBuscado)){
				descripcionResultado += " | Poblacion:" + poblacion;
			}
		}
		if(provincia !=null){
			info += " provincia:" + provincia;
			valores.put("provincia", provincia);
			if(provincia.contains(textoBuscado)){
				descripcionResultado += " | Provincia:" + provincia;
			}
		}
		if(pais !=null){
			info += " pais:" + pais;
			valores.put("pais", pais);
			if(pais.contains(textoBuscado)){
				descripcionResultado += " | Pais:" + pais;
			}
		}
		if(cuentaBancaria !=null){
			info += " cuentaBancaria:" + cuentaBancaria;
			valores.put("cuentaBancaria", cuentaBancaria);
			if(cuentaBancaria.contains(textoBuscado)){
				descripcionResultado += " | Cuenta Bancaria:" + cuentaBancaria;
			}
		}
		if(telefono2 !=null){
			info += " telefono2:" + telefono2;
			valores.put("telefono2", telefono2);
			if(telefono2.contains(textoBuscado)){
				descripcionResultado += " | Telefono 2:" + telefono2;
			}
		}
		if(email2 !=null){
			info += " email2:" + email2;
			valores.put("email2", email2);
			if(email2.contains(textoBuscado)){
				descripcionResultado += " | Email 2:" + email2;
			}
		}
		if(observaciones !=null){
			info += " observaciones:" + observaciones;
			valores.put("observaciones", observaciones);
			if(observaciones.contains(textoBuscado)){
				descripcionResultado += " | Observaciones:" + observaciones;
			}
		}
		
		valores.put("info", info);
		valores.put("descripcionResultado", descripcionResultado);
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(Institucion e, String textoBuscado){
		Map<String, String> valores = new HashMap<>();
		
		String info="";
		valores.put("tipoResultado", "Institucion");
		
		String nombre =e.getNombre();
		String NIF =e.getNIF();
		String direccion =e.getDireccion();
		String personaContacto =e.getPersonaContacto();
		String telefonoContacto =e.getTelefonoContacto();
		String emailContacto =e.getEmailContacto();
		String estado =e.getEstado();
		String motivoBaja =e.getMotivoBaja();
		Date fechaBaja =e.getFechaBaja();
		String paginaWeb =e.getPaginaWeb();
		String cuentaCargo =e.getCuentaCargo();
		String nombreDepartamento1 =e.getNombreDepartamento1();
		String personaContactoDepartamento1 =e.getPersonaContactoDepartamento1();
		String emailDepartamento1 =e.getEmailDepartamento1();
		String telefonoDepartamento1 =e.getTelefonoDepartamento1();
		String nombreDepartamento2 =e.getNombreDepartamento2();
		String personaContactoDepartamento2 =e.getPersonaContactoDepartamento2();
		String emailDepartamento2 =e.getEmailDepartamento2();
		String telefonoDepartamento2 =e.getTelefonoDepartamento2();
		String nombreDepartamento3 =e.getNombreDepartamento3();
		String personaContactoDepartamento3 =e.getPersonaContactoDepartamento3();
		String emailDepartamento3 =e.getEmailDepartamento3();
		String telefonoDepartamento3 =e.getTelefonoDepartamento3();
		String descripcionResultado = "";
		
		valores.put("tipoResultado", "Institucion");
		
		String tipo = null;
		if(e.getTipo()!= null){
			
			tipo = e.getTipo().getNombreTipo();
			info += " Tipo Institucion:" + tipo;
			if(tipo.contains(textoBuscado)){
				descripcionResultado += " | Tipo Institucion:" + tipo;
			}
		}

		if(nombre !=null){
			valores.put("nombreInstitucion", nombre);
			info += " Nombre:" + nombre;
			if(nombre.contains(textoBuscado)){
				descripcionResultado += " | Nombre:" + nombre;
			}
		}
		
		if(NIF !=null){
			valores.put("NIF", NIF);
			info += " NIF:" + NIF;
			if(NIF.contains(textoBuscado)){
				descripcionResultado += " | NIF:" + NIF;
			}
		}
		
		if(direccion !=null){
			info += " direccion:" + direccion;
			valores.put("direccion", direccion);
			if(direccion.contains(textoBuscado)){
				descripcionResultado += " | direccion:" + direccion;
			}
		}
		
		if(personaContacto !=null){
			info += " personaContacto:" + personaContacto;
			valores.put("personaContacto", personaContacto);
			if(personaContacto.contains(textoBuscado)){
				descripcionResultado += " | personaContacto:" + personaContacto;
			}
		}
		
		if(telefonoContacto !=null){
			info += " telefonoContacto:" + telefonoContacto;
			valores.put("telefonoContacto", telefonoContacto);
			if(telefonoContacto.contains(textoBuscado)){
				descripcionResultado += " | telefonoContacto:" + telefonoContacto;
			}
		}
		
		if(emailContacto !=null){
			info += " emailContacto:" + emailContacto;
			valores.put("emailContacto", emailContacto);
			if(emailContacto.contains(textoBuscado)){
				descripcionResultado += " | emailContacto:" + emailContacto;
			}
		}
		
		if(paginaWeb !=null){
			info += " paginaWeb:" + paginaWeb;
			valores.put("paginaWeb", paginaWeb);
			if(paginaWeb.contains(textoBuscado)){
				descripcionResultado += " | paginaWeb:" + paginaWeb;
			}
		}
		
		if(cuentaCargo !=null){
			info += " cuentaCargo:" + cuentaCargo;
			valores.put("cuentaCargo", cuentaCargo);
			if(cuentaCargo.contains(textoBuscado)){
				descripcionResultado += " | cuentaCargo:" + cuentaCargo;
			}
		}
		
		if(nombreDepartamento1 !=null){
			valores.put("nombreDepartamento1", nombreDepartamento1);
			if(nombreDepartamento1.contains(textoBuscado)){
				descripcionResultado += " | nombreDepartamento1:" + nombreDepartamento1;
			}
		}
		
		if(personaContactoDepartamento1 !=null){
			valores.put("personaContactoDepartamento1", personaContactoDepartamento1);
			if(personaContactoDepartamento1.contains(textoBuscado)){
				descripcionResultado += " | personaContactoDepartamento1:" + personaContactoDepartamento1;
			}
		}
		
		if(emailDepartamento1 !=null){
			valores.put("emailDepartamento1", emailDepartamento1);
			if(emailDepartamento1.contains(textoBuscado)){
				descripcionResultado += " | emailDepartamento1:" + emailDepartamento1;
			}
		}
		
		if(telefonoDepartamento1 !=null){
			valores.put("telefonoDepartamento1", telefonoDepartamento1);
			if(telefonoDepartamento1.contains(textoBuscado)){
				descripcionResultado += " | telefonoDepartamento1:" + telefonoDepartamento1;
			}
		}
		
		if(nombreDepartamento2 !=null){
			valores.put("nombreDepartamento2", nombreDepartamento2);
			if(nombreDepartamento2.contains(textoBuscado)){
				descripcionResultado += " | nombreDepartamento2:" + nombreDepartamento2;
			}
		}
		
		if(personaContactoDepartamento2 !=null){
			valores.put("personaContactoDepartamento2", personaContactoDepartamento2);
			if(personaContactoDepartamento2.contains(textoBuscado)){
				descripcionResultado += " | personaContactoDepartamento2:" + personaContactoDepartamento2;
			}
		}
		
		if(emailDepartamento2 !=null){
			valores.put("emailDepartamento2", emailDepartamento2);
			if(emailDepartamento2.contains(textoBuscado)){
				descripcionResultado += " | emailDepartamento2:" + emailDepartamento2;
			}
		}
		
		if(telefonoDepartamento2 !=null){
			valores.put("telefonoDepartamento2", telefonoDepartamento2);
			if(telefonoDepartamento2.contains(textoBuscado)){
				descripcionResultado += " | telefonoDepartamento2:" + telefonoDepartamento2;
			}
		}
		
		if(nombreDepartamento3 !=null){
			valores.put("nombreDepartamento3", nombreDepartamento3);
			if(nombreDepartamento3.contains(textoBuscado)){
				descripcionResultado += " | nombreDepartamento3:" + nombreDepartamento3;
			}
		}
		
		if(personaContactoDepartamento3 !=null){
			valores.put("personaContactoDepartamento3", personaContactoDepartamento3);
			if(personaContactoDepartamento3.contains(textoBuscado)){
				descripcionResultado += " | personaContactoDepartamento3:" + personaContactoDepartamento3;
			}
		}
		
		if(emailDepartamento3 !=null){
			valores.put("emailDepartamento3", emailDepartamento3);
			if(emailDepartamento3.contains(textoBuscado)){
				descripcionResultado += " | emailDepartamento3:" + emailDepartamento3;
			}
		}
		
		if(telefonoDepartamento3 !=null){
			valores.put("telefonoDepartamento3", telefonoDepartamento3);
			if(telefonoDepartamento3.contains(textoBuscado)){
				descripcionResultado += " | telefonoDepartamento3:" + telefonoDepartamento3;
			}
		}
		
		if(estado !=null){
			valores.put("estado", estado);
		}
		
		if(fechaBaja !=null){
			valores.put("fechaBaja", fechaBaja.toString());
		}
		
		if(motivoBaja !=null){
			valores.put("motivoBaja", motivoBaja);
		}
		
		if(tipo !=null){
			valores.put("tipo", tipo);
		}
		
		valores.put("info", info);
		valores.put("descripcionResultado", descripcionResultado);
		return valores;
	}
	
	private static Map<String, String> generaJSonObjeto(Proveedor e, String textoBuscado){
		Map<String, String> valores = new HashMap<>();
		
		String info="";
		valores.put("tipoResultado", "Proveedor");
		
		String Nombre         = e.getNombre()        ;
		String Cif            = e.getCif()           ;
		String Domicilio      = e.getDomicilio()     ;
		String Localidad      = e.getLocalidad()     ;
		String Provincia      = e.getProvincia()     ;
		String CodigoPostal   = e.getCodigoPostal()  ;
		String Pais           = e.getPais()          ;
		String Fax            = e.getFax()           ;
		String Telefono       = e.getTelefono()      ;
		String Email          = e.getEmail()         ;
		String NombreContacto = e.getNombreContacto();
		String DniContacto    = e.getDniContacto()   ;
		String CargoContacto  = e.getCargoContacto() ;
		String NumeroCuenta   = e.getNumeroCuenta()  ;
		
		String descripcionResultado = "";
		
		
		if(Nombre         !=null){ valores.put("nombreProveedor					", Nombre         ); info += " Nombre         :" +Nombre        ; if(Nombre        .contains(textoBuscado)){descripcionResultado += " | Nombre        :" + Nombre        ;	}}
		if(Cif            !=null){ valores.put("cifProveedor					", Cif            ); info += " Cif            :" +Cif           ; if(Cif           .contains(textoBuscado)){descripcionResultado += " | Cif           :" + Cif           ;	}}
		if(Domicilio      !=null){ valores.put("DomicilioProveedor				", Domicilio      ); /*info += " Domicilio      :" +Domicilio     ;*/ if(Domicilio     .contains(textoBuscado)){descripcionResultado += " | Domicilio     :" + Domicilio     ;	}}
		if(Localidad      !=null){ valores.put("LocalidadProveedor				", Localidad      ); info += " Localidad      :" +Localidad     ; if(Localidad     .contains(textoBuscado)){descripcionResultado += " | Localidad     :" + Localidad     ;	}}
		if(Provincia      !=null){ valores.put("ProvinciaProveedor				", Provincia      ); info += " Provincia      :" +Provincia     ; if(Provincia     .contains(textoBuscado)){descripcionResultado += " | Provincia     :" + Provincia     ;	}}
		if(CodigoPostal   !=null){ valores.put("CodigoPostalProveedor			", CodigoPostal   ); /*info += " CodigoPostal   :" +CodigoPostal  ;*/ if(CodigoPostal  .contains(textoBuscado)){descripcionResultado += " | CodigoPostal  :" + CodigoPostal  ;	}}
		if(Pais           !=null){ valores.put("PaisProveedor					", Pais           ); /*info += " Pais           :" +Pais          ;*/ if(Pais          .contains(textoBuscado)){descripcionResultado += " | Pais          :" + Pais          ;	}}
		if(Fax            !=null){ valores.put("faxProveedor					", Fax            ); /*info += " Fax            :" +Fax           ;*/ if(Fax           .contains(textoBuscado)){descripcionResultado += " | Fax           :" + Fax           ;	}}
		if(Telefono       !=null){ valores.put("TelefonoProveedor				", Telefono       ); /*info += " Telefono       :" +Telefono      ;*/ if(Telefono      .contains(textoBuscado)){descripcionResultado += " | Telefono      :" + Telefono      ;	}}
		if(Email          !=null){ valores.put("emailProveedor					", Email          ); /*info += " Email          :" +Email         ;*/ if(Email         .contains(textoBuscado)){descripcionResultado += " | Email         :" + Email         ;	}}
		if(NombreContacto !=null){ valores.put("nombrePersonaContactoProveedor	", NombreContacto ); /*info += " NombreContacto :" +NombreContacto;*/ if(NombreContacto.contains(textoBuscado)){descripcionResultado += " | NombreContacto:" + NombreContacto;	}}
		if(DniContacto    !=null){ valores.put("dniPersonaContactoProveedor		", DniContacto    ); /*info += " DniContacto    :" +DniContacto   ;*/ if(DniContacto   .contains(textoBuscado)){descripcionResultado += " | DniContacto   :" + DniContacto   ;	}}
		if(CargoContacto  !=null){ valores.put("cargoPersonaContactoProveedor	", CargoContacto  ); /*info += " CargoContacto  :" +CargoContacto ;*/ if(CargoContacto .contains(textoBuscado)){descripcionResultado += " | CargoContacto :" + CargoContacto ;	}}
		if(NumeroCuenta   !=null){ valores.put("numCuentaProveedor				", NumeroCuenta   ); /*info += " NumeroCuenta   :" +NumeroCuenta  ;*/ if(NumeroCuenta  .contains(textoBuscado)){descripcionResultado += " | NumeroCuenta  :" + NumeroCuenta  ;	}}

		valores.put("info", info);
		valores.put("descripcionResultado", descripcionResultado);
		return valores;
		
		
	}
	
	public static String cargaParametro(HttpServletRequest request, String parametro) {
		String aux = request.getParameter(parametro);
		if(aux == null ||  aux.equalsIgnoreCase("")){
			return null;
		}else{
			return aux.toUpperCase();
		}
	}
	
	public static Double cargaParametroDouble(HttpServletRequest request, String parametro) {
		String aux = request.getParameter(parametro);
		Double salida= null;
	    if(aux !=null && !aux.equals("")){
	    	salida= Double.parseDouble(aux);
	    }
	    return salida;
	}
	
	public static Boolean cargaParametroBoolean(HttpServletRequest request, String parametro) {
		String aux = request.getParameter(parametro);
		Boolean salida= null;
	    if(aux != null && !aux.equals("")){
	    	salida= Boolean.parseBoolean(aux);
	    }
	    return salida;
	}
	
	public static Date cargaParametroFecha(HttpServletRequest request, String parametro) throws ParseException{
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		String aux = request.getParameter(parametro);
	    Date salida=null;
	    if(aux != null && !aux.equals("")){
	    	salida = new Date(formatoDeFecha.parse(aux).getTime());
	    }
	    return salida;
	}
	
	public static String cargaParametro(InputStream in) throws IOException {
		
        String aux = streamToString(in);
		if(aux == null ||  aux.equalsIgnoreCase("")){
			return null;
		}else{
			return aux.toUpperCase();
		}
	}
	
	public static Double cargaParametroDouble(InputStream in) throws IOException {
		String aux = streamToString(in);
		Double salida= null;
	    if(aux !=null && !aux.equals("")){
	    	salida= Double.parseDouble(aux);
	    }
	    return salida;
	}
	
	public static Boolean cargaParametroBoolean(InputStream in) throws IOException {
		String aux = streamToString(in);
		Boolean salida= null;
	    if(aux != null && !aux.equals("")){
	    	salida= Boolean.parseBoolean(aux);
	    }
	    return salida;
	}
	
	public static Date cargaParametroFecha(InputStream in) throws ParseException, IOException{
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		String aux = streamToString(in);
	    Date salida=null;
	    if(aux != null && !aux.equals("")){
	    	salida = new Date(formatoDeFecha.parse(aux).getTime());
	    }
	    return salida;
	}
	
	private static String streamToString(InputStream in) throws IOException{
		OutputStream outf= new ByteArrayOutputStream();
        byte[] buffer= new byte[256];
        while (true) {
          int n= in.read(buffer);
          if (n < 0)
            break;
          outf.write(buffer, 0, n);
        }
        in.close();
        String salida = outf.toString();
        outf.close();
        return salida;
	}
	
}
