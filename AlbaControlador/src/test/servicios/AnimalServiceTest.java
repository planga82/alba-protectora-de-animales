package test.servicios;

import static org.junit.Assert.*;


import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.junit.BeforeClass;
import org.junit.Test;
import com.base.entidades.animales.Animal;
import com.base.entidades.animales.Especie;
import com.base.entidades.animales.HistoricoPesos;
import com.base.entidades.instituciones.Institucion;
import com.base.entidades.personas.Persona;
import com.base.entidades.ubicaciones.Ubicacion;
import com.constants.Constantes;
import com.inicio.OperacionesIniciales;
import com.servicios.animales.AnimalService;
import com.servicios.animales.EspecieService;
import com.servicios.animales.objetos.FiltroAtributos;
import com.servicios.animales.objetos.FiltroAtributosBoolean;
import com.servicios.animales.objetos.FiltroAtributosDate;
import com.servicios.animales.objetos.FiltroAtributosString;
import com.servicios.instituciones.InstitucionService;
import com.servicios.personas.PersonaService;


public class AnimalServiceTest {

	static String especie = "perro";
	static String especie1 = "gato";
	static String especie2 = "raton";
	static String institucion = "Ayuntamiento1";
	static String institucion1 = "Ayuntamiento11";
	static String ubicacion1 = "ubicacion1";
	static String ubicacion2 = "ubicacion2";
	static String ubicacion3 = "ubicacionBaja";
	static String persona1 = "persona1";
	static Long idpersona1;
	static Long idpersona2;
	static Long idubicacion1;
	static Long idubicacion2;
	static Long idubicacion3;
	
	
	AnimalService as = new AnimalService();
	
	@BeforeClass
	public static void cargaContexto() throws Exception{
		OperacionesIniciales.inicializa();
		EspecieService s = new EspecieService();
		s.alta(especie);
		s.alta(especie1);
		s.alta(especie2);
		
		InstitucionService is = new InstitucionService();
		PersonaService ps = new PersonaService();
	    is.alta(institucion, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	    is.alta(institucion1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	    Persona p = ps.alta("persona1", "", "", "", "","","","","","","","","","","",new HashSet<String>());
	    idpersona1 = p.getId();
	    Persona p2 = ps.alta("persona2", "", "", "", "","","","","","","","","","","",new HashSet<String>());
	    idpersona2 = p2.getId();
	    idubicacion1 = is.altaUbicacion(institucion, ubicacion1).getIdInterno();
	    idubicacion2 = ps.altaUbicacion(p.getId(), ubicacion2).getIdInterno();
	    idubicacion3 = is.altaUbicacion(institucion, ubicacion3).getIdInterno();
	    is.bajaUbicacion(idubicacion3);
	    
	    
	}
	
	@Test
	public void testAlta() {
		try {			
		    String chip="aaaa";
		    String segundoIdentificador="bbbb";
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";
		    Double pesoActual=new Double(10);
		    String estado = "disponible";
		    long f = Calendar.getInstance().getTimeInMillis();
		    Date fechaAviso=new Date(f);
		    Date fechaRecoge=new Date(f);
		    Date fechaRecepciona=new Date(f);
		    String fechaEstado = new Date(f).toString();
		    Double alturaCruz = new Double(5);
		    String extension = ".jpg";
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona,  fechaRecepciona, estado, alturaCruz,extension);
		    Animal b = Animal.findAnimal(a.getId());
		    
			assertTrue(b.getChip().equalsIgnoreCase(chip) &&
						b.getSegundoIdentificador().equalsIgnoreCase(segundoIdentificador) &&
						b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual)&&
						b.getEstado().equals(estado)&&
						b.getAlturaCruz().equals(alturaCruz)&&
						b.getExtensionImagen().equalsIgnoreCase(extension) &&
						b.getFechaEstado().toString().equals(fechaEstado));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAltaVacios() {
		
		try {
			String chip=null;
		    String segundoIdentificador=null;
		    String nombre=null;
		    String raza=null;
		    Date fechaNacimiento=null;
		    String sexo=null;
		    Boolean esterilizado=null;
		    String color=null;
		    String tamano=null;
		    String propietario=null;
		    Date fechaRegistro=null;
		    String descripcion=null;
		    String lugarRecogida=null;
		    Boolean recogidoAyuntamiento=null;
		    String personaAvisa=null;
		    String personaRecoge=null;
		    String personaRecepciona=null;		    
		    Double pesoActual=null;	
		    String estado = null;
		    Date fechaAviso=null;
		    Date fechaRecoge=null;
		    Date fechaRecepciona=null;
		    Double alturaCruz = null;
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona, estado, alturaCruz,"");
		    Animal b = Animal.findAnimal(a.getId());
			assertTrue(b.getChip()== null &&
						b.getSegundoIdentificador()== null &&
						b.getNombre()== null &&
						b.getRaza()== null &&
						b.getSexo()== null &&
						b.getEsterilizado() == null &&
						b.getColor()== null &&
						b.getTamano()== null &&
						b.getPropietario()== null &&
						b.getDescripcion()== null &&
						b.getLugarRecogida()== null &&
						b.getRecogidoAyuntamiento()==null &&
						b.getPersonaAvisa()== null &&
						b.getPersonaRecoge()== null &&
						b.getPersonaRecepciona()== null &&
						b.getPesoActual()== null &&
						b.getEstado()==null); 
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAltaChipExistente() {
		try {			
		    String chip="fffffffff";
		    String segundoIdentificador="";
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona, estado, alturaCruz,"");
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    fail("Dado de alta con el chip duplicado");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAltaOIExistente() {
		try {
			String chip=null;
		    String segundoIdentificador="aaaaaaa";
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    fail("Dado de alta con el SI duplicado");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testModificacion() {
		try {
		    String chip="gggg";
		    String segundoIdentificador="ggggg";
		    String nombre="gggg";
		    String raza="ggggg";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="gggg";
		    Boolean esterilizado=true;
		    String color="gggg";
		    String tamano="gggg";
		    String propietario="ggggg";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="gggg";
		    String lugarRecogida="ggggg";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ggggg";
		    String personaRecoge="gggg";
		    String personaRecepciona="ggggg";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    chip="gggg";
		    segundoIdentificador="ggggg";
		    nombre="ggggd";
		    raza="ggggg";
		    fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    sexo="gggg";
		    esterilizado=true;
		    color="gggg";
		    tamano="gggg";
		    propietario="ggggg";
		    fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    descripcion="gggg";
		    lugarRecogida="ggggg";
		    recogidoAyuntamiento=false;
		    personaAvisa="ggggg";
		    personaRecoge="gggg";
		    personaRecepciona="ggggg";
		    
		    
		    as.modificacion(new Long(a.getId()),chip, segundoIdentificador, nombre, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona,fechaRecepciona, alturaCruz);
		    
		    chip=null;
		    segundoIdentificador=null;
		    nombre=null;
		    raza=null;
		    fechaNacimiento=null;
		    sexo=null;
		    esterilizado=null;
		    color=null;
		    tamano=null;
		    propietario=null;
		    fechaRegistro=null;
		    descripcion=null;
		    lugarRecogida=null;
		    recogidoAyuntamiento=null;
		    personaAvisa=null;
		    personaRecoge=null;
		    personaRecepciona=null;		    	
		    
		    as.modificacion(new Long(a.getId()),chip, segundoIdentificador, nombre, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona,fechaRecepciona, alturaCruz);
		    
		  
		    chip="hhhhhh";
		    segundoIdentificador="hhhh";
		    nombre="hhhhh";
		    raza="hhhh";
		    fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    sexo="hhh";
		    esterilizado=false;
		    color="hhh";
		    tamano="hhhh";
		    propietario="hhhh";
		    fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    descripcion="hhh";
		    lugarRecogida="hhh";
		    recogidoAyuntamiento=true;
		    personaAvisa="hhh";
		    personaRecoge="hhhh";
		    personaRecepciona="hhhh";		    
		    pesoActual=new Double(12);	
		    alturaCruz = new Double(6);
		    
		    as.modificacion(new Long(a.getId()),chip, segundoIdentificador, nombre, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona, alturaCruz);
		    
		    Animal b = Animal.findAnimal(a.getId());
			assertTrue(b.getChip().equalsIgnoreCase(chip) &&
						b.getSegundoIdentificador().equalsIgnoreCase(segundoIdentificador) &&
						b.getEspecie().getNombre().equalsIgnoreCase(especie) &&
						b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getAlturaCruz().equals(alturaCruz));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testModificacionExtensionImagen() {
		try {
		    String chip="ggggdededee";
		    String segundoIdentificador="gggggdededeed";
		    String nombre="gggg";
		    String raza="ggggg";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="gggg";
		    Boolean esterilizado=true;
		    String color="gggg";
		    String tamano="gggg";
		    String propietario="ggggg";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="gggg";
		    String lugarRecogida="ggggg";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ggggg";
		    String personaRecoge="gggg";
		    String personaRecepciona="ggggg";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    String extensionImagen=".jpg";
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,extensionImagen);
		    
		    extensionImagen=".png";
		    
		    as.modificacionExtensionImagen(a.getId(), extensionImagen);
		    
		    Animal b = Animal.findAnimal(a.getId());
			assertTrue(b.getExtensionImagen().equalsIgnoreCase(extensionImagen));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testModificacionChipDuplicado() {
		try {
			String chip="yyyyyyy";
		    String segundoIdentificador="yyyyyyy";
		    String nombre="gggg";
		    String raza="ggggg";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="gggg";
		    Boolean esterilizado=true;
		    String color="gggg";
		    String tamano="gggg";
		    String propietario="ggggg";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="gggg";
		    String lugarRecogida="ggggg";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ggggg";
		    String personaRecoge="gggg";
		    String personaRecepciona="ggggg";		    
		    Double pesoActual=new Double(10);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    chip="x";
		    
		    as.alta(chip, null, nombre,especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    chip="x";
		    segundoIdentificador="uuuuuu";
		    nombre="hhhhh";
		    raza="hhhh";
		    fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    sexo="hhh";
		    esterilizado=false;
		    color="hhh";
		    tamano="hhhh";
		    propietario="hhhh";
		    fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    descripcion="hhh";
		    lugarRecogida="hhh";
		    recogidoAyuntamiento=true;
		    personaAvisa="hhh";
		    personaRecoge="hhhh";
		    personaRecepciona="hhhh";		    
		    pesoActual=new Double(12);	
		    as.modificacion(new Long(a.getId()),chip, segundoIdentificador, nombre, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona,fechaRecepciona, alturaCruz);
		    fail("Dado de alta con el SI duplicado");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	
	
	@Test
	public void testModificacionOIDuplicado() {
		try {			
		    String chip="ppppppp";
		    String segundoIdentificador="pppppp";
		    String nombre="gggg";
		    String raza="ggggg";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="gggg";
		    Boolean esterilizado=true;
		    String color="gggg";
		    String tamano="gggg";
		    String propietario="ggggg";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="gggg";
		    String lugarRecogida="ggggg";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ggggg";
		    String personaRecoge="gggg";
		    String personaRecepciona="ggggg";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre,especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    

		    segundoIdentificador="x";
		    
		    as.alta(null, segundoIdentificador, nombre,especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    chip="ppppppp";
		    segundoIdentificador="x";
		    nombre="hhhhh";
		    raza="hhhh";
		    fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    sexo="hhh";
		    esterilizado=false;
		    color="hhh";
		    tamano="hhhh";
		    propietario="hhhh";
		    fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    descripcion="hhh";
		    lugarRecogida="hhh";
		    recogidoAyuntamiento=true;
		    personaAvisa="hhh";
		    personaRecoge="hhhh";
		    personaRecepciona="hhhh";		    
		    pesoActual=new Double(12);	
		    as.modificacion(new Long(a.getId()),chip, segundoIdentificador, nombre, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona, alturaCruz);
		    fail("Dado de alta con el SI duplicado");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCambioPesoInicial() {
		
		try {
		    String chip="chipcambiopeso";
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=null;		    
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    Double pesonuevo = new Double(11.5);
		    a = as.cambioPeso(a.getId(), pesonuevo);
		    
		    Animal b = Animal.findAnimal(a.getId());
		    Calendar c1 = Calendar.getInstance();
		    
		    Iterator<HistoricoPesos> it = b.getHistoricoPesos().iterator();
		    HistoricoPesos hp = null;
		    boolean encontrado = false;
		    while (it.hasNext() && !encontrado) {
				hp = (HistoricoPesos) it.next();
				encontrado = hp.getPeso().equals(pesonuevo);				
			}
			assertTrue(b.getPesoActual().equals(pesonuevo) &&
						b.getFechaPesoActual().getMonth() == c1.get(Calendar.MONTH) &&
						b.getFechaPesoActual().getDate() == c1.get(Calendar.DATE));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCambioPeso() {
		
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(2);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    Double pesonuevo = new Double(11);
		    a = as.cambioPeso(a.getId(), pesonuevo);
		    
		    Animal b = Animal.findAnimal(a.getId());
		    Calendar c1 = Calendar.getInstance();
		    
		    Iterator<HistoricoPesos> it = b.getHistoricoPesos().iterator();
		    HistoricoPesos hp = null;
		    boolean encontrado = false;
		    while (it.hasNext() && !encontrado) {
				hp = (HistoricoPesos) it.next();
				encontrado = hp.getPeso().equals(pesonuevo);				
			}
			assertTrue(b.getPesoActual().equals(pesonuevo) &&
						b.getFechaPesoActual().getMonth() == c1.get(Calendar.MONTH) &&
						b.getFechaPesoActual().getDate() == c1.get(Calendar.DATE) &&
						hp.getAnimal().equals(b) &&
						hp.getPeso().equals(pesoActual) &&
						hp.getFecha().getMonth() == c1.get(Calendar.MONTH) &&
						hp.getFecha().getDate() == c1.get(Calendar.DATE));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCambioEstado() {
		
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(2);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    estado = "No disponible";
		    a = as.cambiarEstado(a.getId(), estado);
		    
		    Animal b = Animal.findAnimal(a.getId());
		  
			assertTrue(b.getEstado().equals(estado) &&
					b.getFechaEstado().toString().equals(new Date(Calendar.getInstance().getTimeInMillis()).toString()));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAsignarPatrocinadorPersona() {
		/*
		 * Animal contiene a persona patrocinadora
		 * Persona patrocinadora patrocina al animal
		 * No tiene institución patrocinadora a la vez 
		 * 
		 * Animal sin patrocinadores
		 * Animal con patrocinador persona
		 * Animal con patrocinador institucion
		 */
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(2);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    as.asignarPatrocinadorPersona(a.getId(), idpersona1);
		    
		    Animal b = Animal.findAnimal(a.getId());
		    Persona p = Persona.findPersona(idpersona1);
		    boolean cond1 = b.getPersonaPatrocinadora().getId() == p.getId();
		    boolean cond2 = p.getAnimalesPatrocinados().contains(b);
		    boolean cond3 = b.getInstitucionPatrocinadora() == null;
		    
		    as.asignarPatrocinadorPersona(a.getId(), idpersona2);
		    
		    b = Animal.findAnimal(a.getId());
		    p = Persona.findPersona(idpersona2);
		    boolean cond4 = b.getPersonaPatrocinadora().getId() == p.getId();
		    boolean cond5 = p.getAnimalesPatrocinados().contains(b);
		    boolean cond6 = b.getInstitucionPatrocinadora() == null;
		    
		    as.asignarPatrocinadorInstitucion(a.getId(), institucion);
		    as.asignarPatrocinadorPersona(a.getId(), idpersona2);
		    
		    b = Animal.findAnimal(a.getId());
		    p = Persona.findPersona(idpersona2);
		    boolean cond7 = b.getPersonaPatrocinadora().getId() == p.getId();
		    boolean cond8 = p.getAnimalesPatrocinados().contains(b);
		    boolean cond9 = b.getInstitucionPatrocinadora() == null;
		    
		    as.desasignarPatrocinador(a.getId());
		    b = Animal.findAnimal(a.getId());
		    
		    boolean cond10 = b.getPersonaPatrocinadora() == null;
		    
		  
			assertTrue(cond1 && cond2 && cond3 && cond4 && cond5 && cond6 && cond7 && cond8 && cond9 && cond10);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAsignarPatrocinadorInstitucion() {
		/*
		 * Animal contiene a persona patrocinadora
		 * Persona patrocinadora patrocina al animal
		 * No tiene institución patrocinadora a la vez 
		 * 
		 * Animal sin patrocinadores
		 * Animal con patrocinador persona
		 * Animal con patrocinador institucion
		 */
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(2);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    as.asignarPatrocinadorInstitucion(a.getId(), institucion);
		    
		    Animal b = Animal.findAnimal(a.getId());
		    Institucion i = Institucion.findInstitucion(institucion);
		    boolean cond1 = b.getInstitucionPatrocinadora().getNombre().equals(i.getNombre());
		    boolean cond2 = i.getAnimalesPatrocinados().contains(b);
		    boolean cond3 = b.getPersonaPatrocinadora() == null;
		    
		    as.asignarPatrocinadorInstitucion(a.getId(), institucion1);
		    
		    b = Animal.findAnimal(a.getId());
		    i = Institucion.findInstitucion(institucion1);
		    boolean cond4 = b.getInstitucionPatrocinadora().getNombre().equals(i.getNombre());
		    boolean cond5 = i.getAnimalesPatrocinados().contains(b);
		    boolean cond6 = b.getPersonaPatrocinadora() == null;
		    
		    as.asignarPatrocinadorPersona(a.getId(), idpersona2);
		    as.asignarPatrocinadorInstitucion(a.getId(), institucion);   
		    b = Animal.findAnimal(a.getId());
		    i = Institucion.findInstitucion(institucion);
		    boolean cond7 = b.getInstitucionPatrocinadora().getNombre().equals(i.getNombre());
		    boolean cond8 = i.getAnimalesPatrocinados().contains(b);
		    boolean cond9 = b.getPersonaPatrocinadora() == null;
		    		  
			assertTrue(cond1 && cond2 && cond3 && cond4 && cond5 && cond6 && cond7 && cond8 && cond9);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCambioPesoValorNegativo() {		
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    Double pesonuevo = new Double(-11);
		    as.cambioPeso(a.getId(), pesonuevo);
		    fail("Cambio de peso permitido");
		   
		} catch (Exception e) {
			assertTrue(true);
		}		
	}
	
	@Test
	public void testCambioUbicacionInicial() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    Ubicacion ub = Ubicacion.findUbicacion(idubicacion1);
		    int l = ub.getAnimales().size();
		    as.cambiarUbicacion(a.getId(), idubicacion1);

		    a = Animal.findAnimal(a.getId());
		    Ubicacion u = a.getUbicacionActual();		    
		    
		    ub = Ubicacion.findUbicacion(idubicacion1);
		    int l1 = ub.getAnimales().size();
		    assertTrue(l1>l && u.getIdInterno() == idubicacion1);
		   
		} catch (Exception e) {
			fail(e.getMessage());
		}		
	}
	
	@Test
	public void testCambioUbicacionrestante() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    as.cambiarUbicacion(a.getId(), idubicacion2);
		    
		    Ubicacion ub = Ubicacion.findUbicacion(idubicacion1);
		    int l1 = ub.getAnimales().size();
		    ub = Ubicacion.findUbicacion(idubicacion2);
		    int l2 = ub.getAnimales().size();
		    int lhua = a.getHistoricoUbicaciones().size();
		    
		    as.cambiarUbicacion(a.getId(), idubicacion1);
		    
		    ub = Ubicacion.findUbicacion(idubicacion1);
		    int l1d = ub.getAnimales().size();
		    ub = Ubicacion.findUbicacion(idubicacion2);
		    int l2d = ub.getAnimales().size();
		    

		    a = Animal.findAnimal(a.getId());
		    int lhud = a.getHistoricoUbicaciones().size();
		    Ubicacion u = a.getUbicacionActual();
		   
		    assertTrue(lhua < lhud &&
		    		u.getIdInterno() == idubicacion1 &&
		    		l1<l1d && l2>l2d);
		     
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCambioUbicacionrestante2() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    as.cambiarUbicacion(a.getId(), idubicacion2);
		    as.cambiarUbicacion(a.getId(), idubicacion1);
		    
		   
		    as.cambiarUbicacion(a.getId(), idubicacion2);
		    
		   

		    a = Animal.findAnimal(a.getId());
		    Ubicacion u = a.getUbicacionActual();
		    
		    assertTrue(u.getIdInterno() == idubicacion2);
		     
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCambioUbicacionAUbcacionNoExistente() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    as.cambiarUbicacion(a.getId(), 999999L);
		    fail("Cambio de ubicacion permitida");
		   
		} catch (Exception e) {
			assertTrue(true);
		}		
	}
	
	@Test
	public void testCambioUbicacionAUbcacionBaja() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    as.cambiarUbicacion(a.getId(), idubicacion3);
		    fail("Cambio de ubicacion permitida");
		   
		} catch (Exception e) {
			assertTrue(true);
		}			
	}
	
	@Test
	public void testCambioEspecie() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    int Nespecie = Especie.findEspecie(especie).getAnimales().size();
		    int Nespecie1 = Especie.findEspecie(especie1).getAnimales().size();
		    as.cambiarEspecie(a.getId(), especie1);
		    int Nespecied = Especie.findEspecie(especie).getAnimales().size();
		    int Nespecie1d = Especie.findEspecie(especie1).getAnimales().size();

		    a = Animal.findAnimal(a.getId());		    
		    
		    assertTrue(a.getEspecie().getNombre().equalsIgnoreCase(especie1) &&
		    			Nespecie > Nespecied &&
		    			Nespecie1 < Nespecie1d);
		   
		} catch (Exception e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testCambioEspecieInicial() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    int Nespecie1 = Especie.findEspecie(especie1).getAnimales().size();
		    as.cambiarEspecie(a.getId(), especie1);
		    int Nespecie1d = Especie.findEspecie(especie1).getAnimales().size();

		    a = Animal.findAnimal(a.getId());		    
		    
		    assertTrue(a.getEspecie().getNombre().equalsIgnoreCase(especie1) &&
		    			Nespecie1 < Nespecie1d);
		   
		} catch (Exception e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testCambioEspecieNoExistente() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    as.cambiarEspecie(a.getId(), "Especie no existente");
		    fail("Cambio de especie permitida");
		   
		} catch (Exception e) {
			assertTrue(true);
		}	
	}
	
	
	@Test
	public void testDetalle() {
		try {
			String chip="lllllllllll";
		    String segundoIdentificador="llllllllllll";
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    Animal b = as.detalle(a.getId());
			assertTrue(b.getChip().equalsIgnoreCase(chip) &&
						b.getSegundoIdentificador().equalsIgnoreCase(segundoIdentificador) &&
						b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testDetalleIdNoExistente() {
		try{
			as.detalle(99999999L);
			fail("Detalle de un id inexistente");
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testConsultaChip() {
		try {
			String chip="c de prueba";
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    List<Animal> lb = as.consultaChip(chip);
		    Animal b = lb.get(0);
			assertTrue(b.getChip().equalsIgnoreCase(chip) &&
						b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaChipNoExiste() {
		AnimalService es = new AnimalService();
		try {
			
		    String chip="chip de prueba2";
		    List<Animal> lb = es.consultaChip(chip);		    
			assertTrue(lb.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaOtraIdentificacion() {
		
		try {
		    String chip=null;
		    String segundoIdentificador="chip de prueba";
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    List<Animal> lb = as.consultaOtraIdent(segundoIdentificador);
		    Animal b = lb.get(0);
			assertTrue(b.getSegundoIdentificador().equalsIgnoreCase(segundoIdentificador) &&
						b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaSegundoIdentificadorNoExiste() {		
		try {			
		    String segundoIdentificador="chip de prueba2";
		    List<Animal> lb = as.consultaOtraIdent(segundoIdentificador);		    
			assertTrue(lb.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaNombre() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="Nombre para prueba";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    List<Animal> lb = as.consultaNombre(nombre);
		    Animal b = lb.get(0);
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaNombreNoExistente() {
		try {			
		    String nombre="Nombre prueba no existente";
		    List<Animal> lb = as.consultaNombre(nombre);		    
			assertTrue(lb.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaRaza() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="raza para prueba";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    List<Animal> lb = as.consultaRaza(raza);
		    Animal b = lb.get(0);
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaRazaNoExistente() {
		try {			
		    String raza="raza no existente";
		    List<Animal> lb = as.consultaRaza(raza);		    
			assertTrue(lb.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaEsterilizado() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    List<Animal> lb = as.consultaEsterilizado(true,true);		   
			assertTrue(lb.size()>0);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaEsterilizadoSinBajas() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);
		    String estado = "BAJA";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    List<Animal> lb = as.consultaEsterilizado(true,true);
		    List<Animal> lb1 = as.consultaEsterilizado(true,false);
			assertTrue(lb.size()>lb1.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaEsterilizadoSinAdoptados() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);
		    String estado = "ADOPTADO";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    List<Animal> lb = as.consultaEsterilizado(true,true);
		    List<Animal> lb1 = as.consultaEsterilizado(true,false);
			assertTrue(lb.size()>lb1.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testConsultaRecogidoAyuntamiento() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    Date fechaRegistroDesde = new Date(fechaRegistro.getTime()-100000000);
		    Date fechaRegistroDesde2 = new Date(fechaRegistro.getTime()+100000000);
		    Date fechaRegistroHasta = new Date(fechaRegistro.getTime()+200000000);
		    
		    List<Animal> lb = as.consultarecogidoAyuntamiento(true,fechaRegistroDesde, fechaRegistroHasta,true);	
		    List<Animal> lb2 = as.consultarecogidoAyuntamiento(true,fechaRegistroDesde2, fechaRegistroHasta,true);	
			assertTrue(lb.size()>0 &&
						lb.size() > lb2.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaRecogidoAyuntamientoSinBajas() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "BAJA";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    Date fechaRegistroDesde = new Date(fechaRegistro.getTime()-100000000);
		    Date fechaRegistroHasta = new Date(fechaRegistro.getTime()+200000000);
		    
		    List<Animal> lb = as.consultarecogidoAyuntamiento(true,fechaRegistroDesde, fechaRegistroHasta,true);	
		    List<Animal> lb2 = as.consultarecogidoAyuntamiento(true,fechaRegistroDesde, fechaRegistroHasta,false);
		    
			assertTrue(lb.size()>lb2.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaRecogidoAyuntamientoSinAdoptados() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "ADOPTADO";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    Date fechaRegistroDesde = new Date(fechaRegistro.getTime()-100000000);
		    Date fechaRegistroHasta = new Date(fechaRegistro.getTime()+200000000);
		    
		    List<Animal> lb = as.consultarecogidoAyuntamiento(true,fechaRegistroDesde, fechaRegistroHasta,true);	
		    List<Animal> lb2 = as.consultarecogidoAyuntamiento(true,fechaRegistroDesde, fechaRegistroHasta,false);
		    
			assertTrue(lb.size()>lb2.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	@Test
	public void testConsultaEspecie() {
		try {
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);	
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie2, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    Set<Animal> lb = as.consultaEspecie(especie2);
		    Animal b = lb.iterator().next();
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaEspecieNoExistente() {
		try {			
		    String especie="especie no existente";
		    Set<Animal> lb = as.consultaEspecie(especie);		    
			assertTrue(lb.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaInstitucion() {
		try {
			String institucion2 = "Ayuntamiento2";
			String ubicacion12 = "ubicacion12";
			Long idubicacion12;
			InstitucionService is = new InstitucionService();
			is.alta(institucion2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		    idubicacion12 = is.altaUbicacion(institucion2, ubicacion12).getIdInterno();
			
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);		    
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    as.cambiarUbicacion(a.getId(), idubicacion12);
		    Set<Animal> lb = as.consultaInstitucion(institucion2);
		    Animal b = lb.iterator().next();
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaInstitucionNoExistente() {
		try {			
		    String institucion="Institucion no existente";
		    Set<Animal> lb = as.consultaInstitucion(institucion);		    
			assertTrue(lb.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaPersona() {
		try {
			String persona = "Juan";
			String ubicacion123 = "ubicacion123";
			long idubicacion123;
			PersonaService is = new PersonaService();
			Persona p = is.alta(persona, "", "", "", "","","","","","","","","","","",new HashSet<String>());
		    idubicacion123 = is.altaUbicacion(p.getId(), ubicacion123).getIdInterno();
			 
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=false;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);		    
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    Animal a = as.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    as.cambiarUbicacion(a.getId(), idubicacion123);
		    Set<Animal> lb = as.consultaPersona(p.getId());
		    Animal b = lb.iterator().next();
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getRaza().equalsIgnoreCase(raza) &&
						b.getSexo().equalsIgnoreCase(sexo) &&
						b.getEsterilizado().equals(esterilizado) &&
						b.getColor().equalsIgnoreCase(color) &&
						b.getTamano().equalsIgnoreCase(tamano) &&
						b.getPropietario().equalsIgnoreCase(propietario) &&
						b.getDescripcion().equalsIgnoreCase(descripcion) &&
						b.getLugarRecogida().equalsIgnoreCase(lugarRecogida) &&
						b.getRecogidoAyuntamiento().equals(recogidoAyuntamiento) &&
						b.getPersonaAvisa().equalsIgnoreCase(personaAvisa) &&
						b.getPersonaRecoge().equalsIgnoreCase(personaRecoge) &&
						b.getPersonaRecepciona().equalsIgnoreCase(personaRecepciona) &&
						b.getPesoActual().equals(pesoActual));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaPersonaNoExistente() {
		try {
		    Set<Animal> lb = as.consultaPersona(9999999L);		    
			assertTrue(lb.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaTexto() {
		try {
			
			String texto1="cccccc";
		    String texto2="sisisisis";
		    String texto3="nnn";
		    String texto4="rrr";
		    String texto5="hh";
		    String texto7="efh";
		    String texto8="www";
		    String texto9="rrrr";
		    String texto10="tttt";
		    String texto11="yyy";
		    String texto12="uuuu";	
		    String texto13="Algo que no debe encontrar";
		    String texto15="disponibl";
		    
			
		    String chip="cccccccc";
		    String segundoIdentificador="sisisisisis";
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);		    
		    String estado = "disponible";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    	    
		    List<Animal> l1 = as.consultaTexto(texto1, true, Integer.MAX_VALUE);
		    List<Animal> l2 = as.consultaTexto(texto2,true, Integer.MAX_VALUE);
		    List<Animal> l3 = as.consultaTexto(texto3,true, Integer.MAX_VALUE);
		    List<Animal> l4 = as.consultaTexto(texto4,true, Integer.MAX_VALUE);
		    List<Animal> l5 = as.consultaTexto(texto5,true, Integer.MAX_VALUE);
		    List<Animal> l7= as.consultaTexto(texto7,true, Integer.MAX_VALUE);
		    List<Animal> l8 = as.consultaTexto(texto8,true, Integer.MAX_VALUE);
		    List<Animal> l9 = as.consultaTexto(texto9,true, Integer.MAX_VALUE);
		    List<Animal> l10 = as.consultaTexto(texto10,true, Integer.MAX_VALUE);
		    List<Animal> l11 = as.consultaTexto(texto11,true, Integer.MAX_VALUE);
		    List<Animal> l12 = as.consultaTexto(texto12,true, Integer.MAX_VALUE);
		    List<Animal> l13 = as.consultaTexto(texto13,true, Integer.MAX_VALUE);
		    List<Animal> l14 = as.consultaTexto("",true, Integer.MAX_VALUE);
		    List<Animal> l15 = as.consultaTexto(null,true, Integer.MAX_VALUE);
		    List<Animal> l17 = as.consultaTexto(texto15,true, Integer.MAX_VALUE);
	
			assertTrue(l1.size()>0 &&
					l2.size()>0 &&
					l3.size()>0 &&
					l4.size()>0 &&
					l5.size()>0 &&
					l7.size()>0 &&
					l8.size()>0 &&
					l9.size()>0 &&
					l10.size()>0 &&
					l11.size()>0 &&
					l12.size()>0 &&
					l13.size()==0 &&
					l14.size()>0 &&
					l15.size()>0 &&
					l17.size()>0);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaTextoSinBajas() {
		try {
			
		    String texto3="nnn";
		    String texto4="rrr";
		    String texto5="hh";
		    String texto7="efh";
		    String texto8="www";
		    String texto9="rrrr";
		    String texto10="tttt";
		    String texto11="yyy";
		    String texto12="uuuu";	

		    
			
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);		    
		    String estado = Constantes.estadoBaja;
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    	    
		   
		    List<Animal> l3 = as.consultaTexto(texto3,true, Integer.MAX_VALUE);
		    List<Animal> l4 = as.consultaTexto(texto4,true, Integer.MAX_VALUE);
		    List<Animal> l5 = as.consultaTexto(texto5,true, Integer.MAX_VALUE);
		    List<Animal> l7= as.consultaTexto(texto7,true, Integer.MAX_VALUE);
		    List<Animal> l8 = as.consultaTexto(texto8,true, Integer.MAX_VALUE);
		    List<Animal> l9 = as.consultaTexto(texto9,true, Integer.MAX_VALUE);
		    List<Animal> l10 = as.consultaTexto(texto10,true, Integer.MAX_VALUE);
		    List<Animal> l11 = as.consultaTexto(texto11,true, Integer.MAX_VALUE);
		    List<Animal> l12 = as.consultaTexto(texto12,true, Integer.MAX_VALUE);
		    List<Animal> l14 = as.consultaTexto("",true, Integer.MAX_VALUE);
		    List<Animal> l15 = as.consultaTexto(null,true, Integer.MAX_VALUE);
		    
		    List<Animal> l3a = as.consultaTexto(texto3,false, Integer.MAX_VALUE);
		    List<Animal> l4a = as.consultaTexto(texto4,false, Integer.MAX_VALUE);
		    List<Animal> l5a = as.consultaTexto(texto5,false, Integer.MAX_VALUE);
		    List<Animal> l7a= as.consultaTexto(texto7,false, Integer.MAX_VALUE);
		    List<Animal> l8a = as.consultaTexto(texto8,false, Integer.MAX_VALUE);
		    List<Animal> l9a = as.consultaTexto(texto9,false, Integer.MAX_VALUE);
		    List<Animal> l10a = as.consultaTexto(texto10,false, Integer.MAX_VALUE);
		    List<Animal> l11a = as.consultaTexto(texto11,false, Integer.MAX_VALUE);
		    List<Animal> l12a = as.consultaTexto(texto12,false, Integer.MAX_VALUE);
		    List<Animal> l14a = as.consultaTexto("",false, Integer.MAX_VALUE);
		    List<Animal> l15a = as.consultaTexto(null,false, Integer.MAX_VALUE);
	
			assertTrue(l3.size()>l3a.size() &&
					l4.size()>l4a.size() &&
					l5.size()>l5a.size() &&
					l7.size()>l7a.size() &&
					l8.size()>l8a.size() &&
					l9.size()>l9a.size() &&
					l10.size()>l10a.size() &&
					l11.size()>l11a.size() &&
					l12.size()>l12a.size() &&
					l14.size()>l14a.size() &&
					l15.size()>l15a.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaTextoSinAdoptados() {
		try {
			
		    String texto3="nnn";
		    String texto4="rrr";
		    String texto5="hh";
		    String texto7="efh";
		    String texto8="www";
		    String texto9="rrrr";
		    String texto10="tttt";
		    String texto11="yyy";
		    String texto12="uuuu";	
		    
			
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);		    
		    String estado = "ADOPTADO";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    	    
		   
		    List<Animal> l3 = as.consultaTexto(texto3,true, Integer.MAX_VALUE);
		    List<Animal> l4 = as.consultaTexto(texto4,true, Integer.MAX_VALUE);
		    List<Animal> l5 = as.consultaTexto(texto5,true, Integer.MAX_VALUE);
		    List<Animal> l7= as.consultaTexto(texto7,true, Integer.MAX_VALUE);
		    List<Animal> l8 = as.consultaTexto(texto8,true, Integer.MAX_VALUE);
		    List<Animal> l9 = as.consultaTexto(texto9,true, Integer.MAX_VALUE);
		    List<Animal> l10 = as.consultaTexto(texto10,true, Integer.MAX_VALUE);
		    List<Animal> l11 = as.consultaTexto(texto11,true, Integer.MAX_VALUE);
		    List<Animal> l12 = as.consultaTexto(texto12,true, Integer.MAX_VALUE);
		    List<Animal> l14 = as.consultaTexto("",true, Integer.MAX_VALUE);
		    List<Animal> l15 = as.consultaTexto(null,true, Integer.MAX_VALUE);
		    
		    List<Animal> l3a = as.consultaTexto(texto3,false, Integer.MAX_VALUE);
		    List<Animal> l4a = as.consultaTexto(texto4,false, Integer.MAX_VALUE);
		    List<Animal> l5a = as.consultaTexto(texto5,false, Integer.MAX_VALUE);
		    List<Animal> l7a= as.consultaTexto(texto7,false, Integer.MAX_VALUE);
		    List<Animal> l8a = as.consultaTexto(texto8,false, Integer.MAX_VALUE);
		    List<Animal> l9a = as.consultaTexto(texto9,false, Integer.MAX_VALUE);
		    List<Animal> l10a = as.consultaTexto(texto10,false, Integer.MAX_VALUE);
		    List<Animal> l11a = as.consultaTexto(texto11,false, Integer.MAX_VALUE);
		    List<Animal> l12a = as.consultaTexto(texto12,false, Integer.MAX_VALUE);
		    List<Animal> l14a = as.consultaTexto("",false, Integer.MAX_VALUE);
		    List<Animal> l15a = as.consultaTexto(null,false, Integer.MAX_VALUE);
	
			assertTrue(l3.size()>l3a.size() &&
					l4.size()>l4a.size() &&
					l5.size()>l5a.size() &&
					l7.size()>l7a.size() &&
					l8.size()>l8a.size() &&
					l9.size()>l9a.size() &&
					l10.size()>l10a.size() &&
					l11.size()>l11a.size() &&
					l12.size()>l12a.size() &&
					l14.size()>l14a.size() &&
					l15.size()>l15a.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	@Test
	public void testConsultaSinBajas() {
		try {			
			
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);		    
		    String estado = "BAJA";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    	    
		   
		    List<Animal> l3 = as.consulta(true);
		    List<Animal> l4 = as.consulta(true);
		    List<Animal> l5 = as.consulta(true);
		    List<Animal> l7= as.consulta(true);
		    List<Animal> l8 = as.consulta(true);
		    List<Animal> l9 = as.consulta(true);
		    List<Animal> l10 = as.consulta(true);
		    List<Animal> l11 = as.consulta(true);
		    List<Animal> l12 = as.consulta(true);
		    List<Animal> l14 = as.consulta(true);
		    List<Animal> l15 = as.consulta(true);
		    List<Animal> l16 = as.consulta(true);
		    
		    List<Animal> l3a = as.consulta(false);
		    List<Animal> l4a = as.consulta(false);
		    List<Animal> l5a = as.consulta(false);
		    List<Animal> l7a= as.consulta(false);
		    List<Animal> l8a = as.consulta(false);
		    List<Animal> l9a = as.consulta(false);
		    List<Animal> l10a = as.consulta(false);
		    List<Animal> l11a = as.consulta(false);
		    List<Animal> l12a = as.consulta(false);
		    List<Animal> l14a = as.consulta(false);
		    List<Animal> l15a = as.consulta(false);
		    List<Animal> l16a = as.consulta(false);
	
			assertTrue(l3.size()>l3a.size() &&
					l4.size()>l4a.size() &&
					l5.size()>l5a.size() &&
					l7.size()>l7a.size() &&
					l8.size()>l8a.size() &&
					l9.size()>l9a.size() &&
					l10.size()>l10a.size() &&
					l11.size()>l11a.size() &&
					l12.size()>l12a.size() &&
					l14.size()>l14a.size() &&
					l15.size()>l15a.size() &&
					l16.size()>l16a.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaSinAdoptados() {
		try {			
		 		
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="nnnn";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);		    
		    String estado = "ADOPTADO";
		    Date fechaAviso=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    	    
		   
		    List<Animal> l3 = as.consulta(true);
		    List<Animal> l4 = as.consulta(true);
		    List<Animal> l5 = as.consulta(true);
		    List<Animal> l7= as.consulta(true);
		    List<Animal> l8 = as.consulta(true);
		    List<Animal> l9 = as.consulta(true);
		    List<Animal> l10 = as.consulta(true);
		    List<Animal> l11 = as.consulta(true);
		    List<Animal> l12 = as.consulta(true);
		    List<Animal> l14 = as.consulta(true);
		    List<Animal> l15 = as.consulta(true);
		    List<Animal> l16 = as.consulta(true);
		    
		    List<Animal> l3a = as.consulta(false);
		    List<Animal> l4a = as.consulta(false);
		    List<Animal> l5a = as.consulta(false);
		    List<Animal> l7a= as.consulta(false);
		    List<Animal> l8a = as.consulta(false);
		    List<Animal> l9a = as.consulta(false);
		    List<Animal> l10a = as.consulta(false);
		    List<Animal> l11a = as.consulta(false);
		    List<Animal> l12a = as.consulta(false);
		    List<Animal> l14a = as.consulta(false);
		    List<Animal> l15a = as.consulta(false);
		    List<Animal> l16a = as.consulta(false);
	
			assertTrue(l3.size()>l3a.size() &&
					l4.size()>l4a.size() &&
					l5.size()>l5a.size() &&
					l7.size()>l7a.size() &&
					l8.size()>l8a.size() &&
					l9.size()>l9a.size() &&
					l10.size()>l10a.size() &&
					l11.size()>l11a.size() &&
					l12.size()>l12a.size() &&
					l14.size()>l14a.size() &&
					l15.size()>l15a.size() &&
					l16.size()>l16a.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testListados() {
		try {			
		 		
		    String chip=null;
		    String segundoIdentificador=null;
		    String nombre="NombreListado";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(100);
		    String descripcion="wwww";
		    String lugarRecogida="rrrr";
		    Boolean recogidoAyuntamiento=true;
		    String personaAvisa="ttttt";
		    String personaRecoge="yyyy";
		    String personaRecepciona="uuuuu";		    
		    Double pesoActual=new Double(10);		    
		    String estado = "ADOPTADO";
		    Date fechaAviso=new Date(100);
		    Date fechaRecoge=new Date(Calendar.getInstance().getTimeInMillis());
		    Date fechaRecepciona=new Date(Calendar.getInstance().getTimeInMillis());
		    Double alturaCruz = new Double(5);
		    
		    as.alta(chip, segundoIdentificador, nombre, especie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    	    
		    FiltroAtributosBoolean fb = new FiltroAtributosBoolean();
		    fb.setNombreAtributo("esterilizado");
		    fb.setValor(true);
		    FiltroAtributosBoolean fb2 = new FiltroAtributosBoolean();
		    
		    FiltroAtributosString fs = new FiltroAtributosString();
		    fs.setNombreAtributo("nombre");
		    fs.setValor("NombreLis");
		    FiltroAtributosString fs2 = new FiltroAtributosString();
		    fs2.setNombreAtributo("nombre");
		    fs2.setValor("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		    FiltroAtributosString fs3 = new FiltroAtributosString();
		    
		    FiltroAtributosDate fd = new FiltroAtributosDate();
		    fd.setNombreAtributo("fechaAvisa");
		    fd.setFecha_hasta(new Date(110));
		    
		    FiltroAtributosDate fd2 = new FiltroAtributosDate();
		    fd2.setNombreAtributo("fechaAvisa");
		    fd2.setFecha_desde(new Date(100000000000000000L));
		    fd2.setFecha_hasta(new Date(100000000000000000L));
		    
		    Vector<FiltroAtributos> lf1 = new Vector<>();
		    lf1.add(fb);
		    List<Animal> salida1 = as.listadoFiltros(lf1,"AND");
		    lf1.add(fs);
		    List<Animal> salida2 = as.listadoFiltros(lf1,"AND");
		    lf1.add(fd);
		    List<Animal> salida3 = as.listadoFiltros(lf1,"AND");
		    lf1.add(fs2);
		    List<Animal> salida6 = as.listadoFiltros(lf1,"AND");
		    
		    Vector<FiltroAtributos> lf2 = new Vector<>();
		    lf2.add(fd2);
		    List<Animal> salida4 = as.listadoFiltros(lf2,"OR");
		    lf2.add(fd);
		    List<Animal> salida5 = as.listadoFiltros(lf2,"OR");
		    lf2.add(fb2);
		    as.listadoFiltros(lf2,"OR");
		    lf2.add(fs3);
		    as.listadoFiltros(lf2,"OR");
		    
		    Vector<FiltroAtributos> lf3 = new Vector<>();
		    lf3.add(fs3);
		    List<Animal> salida7 = as.listadoFiltros(lf3,"OR");
		    
		   
			assertTrue(salida1.size() >0 && 
					salida2.size()>0 && 
					salida3.size()>0 && 
					salida4.size()==0 &&
					salida5.size()>0 &&
					salida7.size()>0 &&
					salida6.size()==0);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
