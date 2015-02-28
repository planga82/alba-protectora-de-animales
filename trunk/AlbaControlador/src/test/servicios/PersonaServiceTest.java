package test.servicios;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.base.entidades.animales.Animal;
import com.base.entidades.personas.Persona;
import com.base.entidades.ubicaciones.Ubicacion;
import com.constants.Constantes;
import com.inicio.OperacionesIniciales;
import com.servicios.animales.AnimalService;
import com.servicios.personas.PersonaService;

public class PersonaServiceTest {
	PersonaService es = new PersonaService();
	
	@BeforeClass
	public static void cargaContexto(){
		OperacionesIniciales.inicializa();
		
	}
	
	@Test
	public void testAlta() {
		
		
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");			
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			Persona p = Persona.findPersona(p1.getId());
			assertTrue(p.getNombre().equalsIgnoreCase(nombre) &&
						p.getApellidos().equalsIgnoreCase(apellidos) &&
						p.getDNI().equalsIgnoreCase(DNI) &&
						p.getTelefono().equalsIgnoreCase(telefono)&&
						p.getEmail().equalsIgnoreCase(email)&&
						p.getEstado().equalsIgnoreCase(Constantes.estadoAlta) &&
						p.getUbicaciones().size() == 0 &&
						p.getCalle().equalsIgnoreCase(calle) &&
						p.getNumero().equalsIgnoreCase(numero) &&
						p.getCodPostal().equalsIgnoreCase(codPostal) &&
						p.getPoblacion().equalsIgnoreCase(poblacion) &&
						p.getProvincia().equalsIgnoreCase(provincia) &&
						p.getPais().equalsIgnoreCase(pais) &&
						p.getCuentaBancaria().equalsIgnoreCase(cuentaBancaria) &&
						p.getTelefono2().equalsIgnoreCase(telefono2) &&
						p.getEmail2().equalsIgnoreCase(email2) &&
						p.getObservaciones().equalsIgnoreCase(observaciones) &&
						p.getRelacionesALBA().size() == relacionesALBA.size());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testAltaVacios() {
			
		try {
			String nombre = null;
			String apellidos = null;
			String DNI = null;
			String telefono = null;
			String email = null;
			String calle = null;
			String numero = null;
			String codPostal = null;
			String poblacion = null;
			String provincia = null;
			String pais = null;
			String cuentaBancaria = null;
			String telefono2 = null;
			String email2 = null;
			String observaciones = null;
			HashSet<String> relaciones = new HashSet<>();			
			Set<String> relacionesALBA = relaciones;
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			Persona p = Persona.findPersona(p1.getId());
			assertTrue(p.getNombre() == null &&
						p.getApellidos()== null &&
						p.getDNI()== null &&
						p.getTelefono()== null&&
						p.getEmail()== null&&
						p.getEstado().equalsIgnoreCase(Constantes.estadoAlta) &&
						p.getUbicaciones().size() == 0&&
						p.getCalle()== null &&
						p.getNumero()== null &&
						p.getCodPostal()== null &&
						p.getPoblacion()== null &&
						p.getProvincia()== null &&
						p.getPais()== null &&
						p.getCuentaBancaria()== null &&
						p.getTelefono2()== null &&
						p.getEmail2()== null &&
						p.getObservaciones()== null &&
						p.getRelacionesALBA().size() == 0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	
	}
	
	@Test
	public void testModificacion() {
		
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			
			
			nombre = "Pablo1";
			apellidos = "Langa1";
			DNI = "56698564L1";
			telefono = "91 555 32 121";
			email = "soyjuan@hotmail.com1";
			calle = "Calle 12";
			numero = "1232";
			codPostal = "232456";
			poblacion = "San Fernando2";
			provincia = "Madrid2";
			pais = "España2";
			cuentaBancaria = "1223 1245 87 34566432425";
			telefono2 = "45642345562";
			email2 = "xxxx@gmail.com2";
			observaciones = "Esto es una observacion2";
			relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 2");
			relacionesALBA.add("relacion 22");
			es.modificacion(p1.getId(), nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			
			Persona p = Persona.findPersona(p1.getId());
			assertTrue(p.getNombre().equalsIgnoreCase(nombre) &&
								p.getApellidos().equalsIgnoreCase(apellidos) &&
								p.getDNI().equalsIgnoreCase(DNI) &&
								p.getTelefono().equalsIgnoreCase(telefono)&&
								p.getEmail().equalsIgnoreCase(email)&&
								p.getEstado().equalsIgnoreCase(Constantes.estadoAlta) &&
								p.getUbicaciones().size() == 0 &&
								p.getCalle().equalsIgnoreCase(calle) &&
								p.getNumero().equalsIgnoreCase(numero) &&
								p.getCodPostal().equalsIgnoreCase(codPostal) &&
								p.getPoblacion().equalsIgnoreCase(poblacion) &&
								p.getProvincia().equalsIgnoreCase(provincia) &&
								p.getPais().equalsIgnoreCase(pais) &&
								p.getCuentaBancaria().equalsIgnoreCase(cuentaBancaria) &&
								p.getTelefono2().equalsIgnoreCase(telefono2) &&
								p.getEmail2().equalsIgnoreCase(email2) &&
								p.getObservaciones().equalsIgnoreCase(observaciones) &&
								p.getRelacionesALBA().size() == relacionesALBA.size());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testModificacionEnEstadoBaja() {
		
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.baja(p1.getId(), "motivo");
			
			nombre = "Pablo1";
			apellidos = "Langa1";
			DNI = "56698564L1";
			telefono = "91 555 32 121";
			email = "soyjuan@hotmail.com1";
			es.modificacion(p1.getId(), nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			
			fail("Permite modificar una persona dada de baja");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testModificacionIdNoExistente() {
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			es.modificacion(999L, nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
						
			fail("Modificacion permitida");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAltaTrasBaja() {
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String motivo = "Motivo";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.baja(p1.getId(), motivo);
			Persona p = Persona.findPersona(p1.getId());
			es.ponerAlta(p.getId());
			p = Persona.findPersona(p1.getId());
			assertTrue(	p.getEstado().equalsIgnoreCase(Constantes.estadoAlta));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBajaSinUbicaciones() {
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String motivo = "Motivo";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.baja(p1.getId(), motivo);
			Persona p = Persona.findPersona(p1.getId());
			assertTrue(p.getNombre().equalsIgnoreCase(nombre) &&
						p.getApellidos().equalsIgnoreCase(apellidos) &&
						p.getDNI().equalsIgnoreCase(DNI) &&
						p.getTelefono().equalsIgnoreCase(telefono)&&
						p.getEmail().equalsIgnoreCase(email)&&
						p.getEstado().equalsIgnoreCase(Constantes.estadoBaja) &&
						p.getMotivoBaja().equalsIgnoreCase(motivo) &&
						p.getUbicaciones().size() == 0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBajaConUbicacionesDadasBaja() {
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String motivo = "Motivo";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			Ubicacion UB1 = es.altaUbicacion(p1.getId(), "UB1");
			es.bajaUbicacion(UB1.getIdInterno());			
			es.baja(p1.getId(), motivo);			
			Persona p = Persona.findPersona(p1.getId());			
			
			assertTrue(p.getNombre().equalsIgnoreCase(nombre) &&
						p.getApellidos().equalsIgnoreCase(apellidos) &&
						p.getDNI().equalsIgnoreCase(DNI) &&
						p.getTelefono().equalsIgnoreCase(telefono)&&
						p.getEmail().equalsIgnoreCase(email)&&
						p.getEstado().equalsIgnoreCase(Constantes.estadoBaja) &&
						p.getMotivoBaja().equalsIgnoreCase(motivo) &&
						p.getUbicaciones().size() == 0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBajaConUbicacionesNoDadasBaja() {
		String nombre = "Pablo";
		String apellidos = "Langa";
		String DNI = "56698564L";
		String telefono = "91 555 32 12";
		String email = "soyjuan@hotmail.com";
		String motivo = "Motivo";
		String calle = "Calle 1";
		String numero = "123";
		String codPostal = "23456";
		String poblacion = "San Fernando";
		String provincia = "Madrid";
		String pais = "España";
		String cuentaBancaria = "1223 1245 87 3456643245";
		String telefono2 = "4564234556";
		String email2 = "xxxx@gmail.com";
		String observaciones = "Esto es una observacion";
		HashSet<String> relacionesALBA = new HashSet<>();
		relacionesALBA.add("relacion 1");
		relacionesALBA.add("relacion 2");
		Persona p1 = null;
		Ubicacion u = null;
		try {			
			p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			u = es.altaUbicacion(p1.getId(), "UB1");
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			es.baja(p1.getId(), motivo);	
			
			Persona p = Persona.findPersona(p1.getId());
			u = Ubicacion.findUbicacion(u.getIdInterno());
			assertTrue(p.getEstado().equalsIgnoreCase(Constantes.estadoBaja) &&
					p.getMotivoBaja().equalsIgnoreCase(motivo));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBajaConUbicacionesNoDadasBajaYAnimales() {
		try{
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String motivo = "Motivo";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = null;
			Ubicacion ub=null;
			try {			
				p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
				ub = es.altaUbicacion(p1.getId(), "UB1");			
			
				String chip=null;
			    String segundoIdentificador=null;
			    String nombrea="nnnn";
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
			    
			    AnimalService as = new AnimalService();
			    Animal a = as.alta(chip, segundoIdentificador, nombrea, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona, estado, alturaCruz,"");
			    as.cambiarUbicacion(a.getId(), ub.getIdInterno());
			
			} catch (Exception e) {
				fail(e.getMessage());
			}
			es.baja(p1.getId(), motivo);
			
			fail("Baja permitida");			
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaIdNoExistente() {
		try {
			es.baja(999L, "");			
			fail("Baja permitida");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaPersonaYaDeBaja() {
		String nombre = "Pablo";
		String apellidos = "Langa";
		String DNI = "56698564L";
		String telefono = "91 555 32 12";
		String email = "soyjuan@hotmail.com";
		String motivo = "Motivo";
		String calle = "Calle 1";
		String numero = "123";
		String codPostal = "23456";
		String poblacion = "San Fernando";
		String provincia = "Madrid";
		String pais = "España";
		String cuentaBancaria = "1223 1245 87 3456643245";
		String telefono2 = "4564234556";
		String email2 = "xxxx@gmail.com";
		String observaciones = "Esto es una observacion";
		HashSet<String> relacionesALBA = new HashSet<>();
		relacionesALBA.add("relacion 1");
		relacionesALBA.add("relacion 2");
		Persona p1 = null;
		try {			
			p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.baja(p1.getId(), motivo);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			es.baja(p1.getId(), motivo);			
			fail("Baja permitida");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaMotivoVacio() {
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String motivo = null;
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.baja(p1.getId(), motivo);
			Persona p = Persona.findPersona(p1.getId());
			assertTrue(p.getNombre().equalsIgnoreCase(nombre) &&
						p.getApellidos().equalsIgnoreCase(apellidos) &&
						p.getDNI().equalsIgnoreCase(DNI) &&
						p.getTelefono().equalsIgnoreCase(telefono)&&
						p.getEmail().equalsIgnoreCase(email)&&
						p.getEstado().equalsIgnoreCase(Constantes.estadoBaja) &&
						p.getMotivoBaja() == null &&
						p.getUbicaciones().size() == 0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	@Test
	public void testAltaUbicacion() {
		String nombre = "Pablo";
		String apellidos = "Langa";
		String DNI = "56698564L";
		String telefono = "91 555 32 12";
		String email = "soyjuan@hotmail.com";
		String calle = "Calle 1";
		String numero = "123";
		String codPostal = "23456";
		String poblacion = "San Fernando";
		String provincia = "Madrid";
		String pais = "España";
		String cuentaBancaria = "1223 1245 87 3456643245";
		String telefono2 = "4564234556";
		String email2 = "xxxx@gmail.com";
		String observaciones = "Esto es una observacion";
		HashSet<String> relacionesALBA = new HashSet<>();
		relacionesALBA.add("relacion 1");
		relacionesALBA.add("relacion 2");
		Persona p1 = null;
		String ubicacion = "UB1";
		try {			
			p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.altaUbicacion(p1.getId(), ubicacion);
			p1 = Persona.findPersona(p1.getId());
			Ubicacion ub = p1.getUbicaciones().iterator().next();
			assertTrue(ub.getNombre().equalsIgnoreCase(ubicacion));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAltaUbicacionIdPersonaNoExistente() {
		String nombre = "Pablo";
		String apellidos = "Langa";
		String DNI = "56698564L";
		String telefono = "91 555 32 12";
		String email = "soyjuan@hotmail.com";
		String ubicacion = "UB1";
		String calle = "Calle 1";
		String numero = "123";
		String codPostal = "23456";
		String poblacion = "San Fernando";
		String provincia = "Madrid";
		String pais = "España";
		String cuentaBancaria = "1223 1245 87 3456643245";
		String telefono2 = "4564234556";
		String email2 = "xxxx@gmail.com";
		String observaciones = "Esto es una observacion";
		HashSet<String> relacionesALBA = new HashSet<>();
		relacionesALBA.add("relacion 1");
		relacionesALBA.add("relacion 2");
		try {			
			es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.altaUbicacion(999L, ubicacion);
			fail("Alta permitida");
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAltaUbicacionNombreUbExistInstitucion() {
		String nombre = "Pablo";
		String apellidos = "Langa";
		String DNI = "56698564L";
		String telefono = "91 555 32 12";
		String email = "soyjuan@hotmail.com";
		String ubicacion = "UB1";
		Persona p1=null;
		String calle = "Calle 1";
		String numero = "123";
		String codPostal = "23456";
		String poblacion = "San Fernando";
		String provincia = "Madrid";
		String pais = "España";
		String cuentaBancaria = "1223 1245 87 3456643245";
		String telefono2 = "4564234556";
		String email2 = "xxxx@gmail.com";
		String observaciones = "Esto es una observacion";
		HashSet<String> relacionesALBA = new HashSet<>();
		relacionesALBA.add("relacion 1");
		relacionesALBA.add("relacion 2");
		try{
			p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.altaUbicacion(p1.getId(), ubicacion);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {			
			es.altaUbicacion(p1.getId(), ubicacion);
			fail("Alta permitida");
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaUbicacionIdPersonaNoExistente() {
		try {			
			es.bajaUbicacion(999L);
			fail("baja permitida");
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaUbicacionIdUbicacionNoExistente() {
		String nombre = "Pablo";
		String apellidos = "Langa";
		String DNI = "56698564L";
		String telefono = "91 555 32 12";
		String email = "soyjuan@hotmail.com";
		String ubicacion = "UB1";
		Persona p1=null;
		String calle = "Calle 1";
		String numero = "123";
		String codPostal = "23456";
		String poblacion = "San Fernando";
		String provincia = "Madrid";
		String pais = "España";
		String cuentaBancaria = "1223 1245 87 3456643245";
		String telefono2 = "4564234556";
		String email2 = "xxxx@gmail.com";
		String observaciones = "Esto es una observacion";
		HashSet<String> relacionesALBA = new HashSet<>();
		relacionesALBA.add("relacion 1");
		relacionesALBA.add("relacion 2");
		try{
			p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.altaUbicacion(p1.getId(), ubicacion);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {			
			es.bajaUbicacion(999L);
			fail("Alta permitida");
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	
	
	@Test
	public void testBajaUbicacionConAnimalesAsociados() {
		String nombre = "Pablo";
		String apellidos = "Langa";
		String DNI = "56698564L";
		String telefono = "91 555 32 12";
		String email = "soyjuan@hotmail.com";
		String ubicacion = "UB1";
		Persona p1=null;
		Ubicacion ub1 = null;
		String calle = "Calle 1";
		String numero = "123";
		String codPostal = "23456";
		String poblacion = "San Fernando";
		String provincia = "Madrid";
		String pais = "España";
		String cuentaBancaria = "1223 1245 87 3456643245";
		String telefono2 = "4564234556";
		String email2 = "xxxx@gmail.com";
		String observaciones = "Esto es una observacion";
		HashSet<String> relacionesALBA = new HashSet<>();
		relacionesALBA.add("relacion 1");
		relacionesALBA.add("relacion 2");
		try{
			p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			ub1 = es.altaUbicacion(p1.getId(), ubicacion);
			
			String chip=null;
		    String segundoIdentificador=null;
		    String nombre1="nnnn";
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
		    
		    AnimalService as = new AnimalService();
		    Animal a = as.alta(chip, segundoIdentificador, nombre1, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona, estado, alturaCruz,"");
		    
		    as.cambiarUbicacion(a.getId(), ub1.getIdInterno());
		} catch (Exception e) {
			fail(e.getMessage());
		}   
		try{	
			es.bajaUbicacion(ub1.getIdInterno());
			fail("Baja permitida");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaUbicacionSinAnimalesAsociados() {
		String nombre = "Pablo";
		String apellidos = "Langa";
		String DNI = "56698564L";
		String telefono = "91 555 32 12";
		String email = "soyjuan@hotmail.com";
		String ubicacion = "UB1";
		Persona p1=null;
		Ubicacion ub = null;
		String calle = "Calle 1";
		String numero = "123";
		String codPostal = "23456";
		String poblacion = "San Fernando";
		String provincia = "Madrid";
		String pais = "España";
		String cuentaBancaria = "1223 1245 87 3456643245";
		String telefono2 = "4564234556";
		String email2 = "xxxx@gmail.com";
		String observaciones = "Esto es una observacion";
		HashSet<String> relacionesALBA = new HashSet<>();
		relacionesALBA.add("relacion 1");
		relacionesALBA.add("relacion 2");
		try{
			p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			ub = es.altaUbicacion(p1.getId(), ubicacion);
			int n = Persona.findPersona(p1.getId()).getUbicaciones().size();
			es.bajaUbicacion(ub.getIdInterno());
			int n2 = Persona.findPersona(p1.getId()).getUbicaciones().size();
			assertTrue(n>n2);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testDetalle() {
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			Persona p = es.detalle(p1.getId());
			assertTrue(p.getNombre().equalsIgnoreCase(nombre) &&
						p.getApellidos().equalsIgnoreCase(apellidos) &&
						p.getDNI().equalsIgnoreCase(DNI) &&
						p.getTelefono().equalsIgnoreCase(telefono)&&
						p.getEmail().equalsIgnoreCase(email)&&
						p.getEstado().equalsIgnoreCase(Constantes.estadoAlta) &&
						p.getUbicaciones().size() == 0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testDetalleIdNoExiste() {
		try{
			es.detalle(999L);
			fail("Detalle sin fallo");
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testConsultaApellidos() {
		try {
			String nombre = "Pablo";
			String apellidos = "Langa Blanco";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			List<Persona> l = es.consultaApellidos(apellidos);
			assertTrue(l.size()>0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaApellidosNoExistente() {
		try{
			List<Persona> l = es.consultaApellidos("Apellido no existente");
			assertTrue(l.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaNombre() {
		try {
			String nombre = "Pablo 2";
			String apellidos = "Langa Blanco";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			List<Persona> l = es.consultaNombre(nombre);
			assertTrue(l.size()>0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaNombreNoExistente() {
		try{
			List<Persona> l = es.consultaNombre("nombre no existente");
			assertTrue(l.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaEstadoBaja() {
		try {
			String nombre = "Pablo";
			String apellidos = "Langa";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String motivo = "Motivo";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p1 = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			es.baja(p1.getId(), motivo);
			List<Persona> l = es.consultaEstadoBaja();
			assertTrue(l.size()>0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaTextoNombre() {
		try {
			
			String texto1 = "ablo";
			String texto2 = "anga Blanco";
			String texto3 = "6698564L";
			String texto4 = "1 555 32 12";
			String texto5 = "oyjuan@hotmail.com";
			String texto6 = "alle 1";
			String texto7 = "23";
			String texto8 = "3456";
			String texto9 = "an Fernando";
			String texto10 = "adrid";
			String texto11 = "spaña";
			String texto12 = "223 1245 87 3456643245";
			String texto13 = "564234556";
			String texto14 = "xxx@gmail.com";
			String texto15 = "sto es una observacion";
			String texto16 = "Texto no va a encontrar";
			
			String nombre = "Pablo";
			String apellidos = "Langa Blanco";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);

			List<Persona> l1 = es.consultaTexto(texto1,true, Integer.MAX_VALUE);
			List<Persona> l2 = es.consultaTexto(texto2,true, Integer.MAX_VALUE);
			List<Persona> l3 = es.consultaTexto(texto3,true, Integer.MAX_VALUE);
			List<Persona> l4 = es.consultaTexto(texto4,true, Integer.MAX_VALUE);
			List<Persona> l5 = es.consultaTexto(texto5,true, Integer.MAX_VALUE);
			List<Persona> l6 = es.consultaTexto(texto6,true, Integer.MAX_VALUE);
			List<Persona> l7 = es.consultaTexto(texto7,true, Integer.MAX_VALUE);
			List<Persona> l8 = es.consultaTexto(texto8,true, Integer.MAX_VALUE);
			List<Persona> l9 = es.consultaTexto(texto9,true, Integer.MAX_VALUE);
			List<Persona> l10 = es.consultaTexto(texto10,true, Integer.MAX_VALUE);
			List<Persona> l11 = es.consultaTexto(texto11,true, Integer.MAX_VALUE);
			List<Persona> l12 = es.consultaTexto(texto12,true, Integer.MAX_VALUE);
			List<Persona> l13 = es.consultaTexto(texto13,true, Integer.MAX_VALUE);
			List<Persona> l14 = es.consultaTexto(texto14,true, Integer.MAX_VALUE);
			List<Persona> l15 = es.consultaTexto(texto15,true, Integer.MAX_VALUE);
			List<Persona> l16 = es.consultaTexto(texto16,true, Integer.MAX_VALUE);
			List<Persona> l17 = es.consultaTexto("",true, Integer.MAX_VALUE);
			List<Persona> l18 = es.consultaTexto(null,true, Integer.MAX_VALUE);
			assertTrue(
					l1.size()>0 &&
					l2.size()>0 &&
					l3.size()>0 &&
					l4.size()>0 &&
					l5.size()>0 &&
					l6.size()>0 &&
					l7.size()>0 &&
					l8.size()>0 &&
					l9.size()>0 &&
					l10.size()>0 &&
					l11.size()>0 &&
					l12.size()>0 &&
					l13.size()>0 &&
					l14.size()>0 &&
					l15.size()>0 &&
					l16.size() == 0 &&
					l17.size()>0 &&
					l18.size()>0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		
	}
	
	@Test
	public void testConsultaTextoMaxResultados() {
		try {
			
			String texto1 = "ablo";	
			String nombre = "Pablo";
			String apellidos = "Langa Blanco";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);			
			nombre = "Pablo2";			
			es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			nombre = "Pablo3";			
			es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			
			
			List<Persona> l1 = es.consultaTexto(texto1,true, 3);
			List<Persona> l1a = es.consultaTexto(texto1,true, 2);
			
			assertTrue(l1.size()>l1a.size());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		
	}
	
	@Test
	public void testConsultaTextoNombreSinBajas() {
		try {
			String texto = "Pablo";
			String nombre = "Pablo";
			String apellidos = "Langa Blanco";
			String DNI = "56698564L";
			String telefono = "91 555 32 12";
			String email = "soyjuan@hotmail.com";
			String calle = "Calle 1";
			String numero = "123";
			String codPostal = "23456";
			String poblacion = "San Fernando";
			String provincia = "Madrid";
			String pais = "España";
			String cuentaBancaria = "1223 1245 87 3456643245";
			String telefono2 = "4564234556";
			String email2 = "xxxx@gmail.com";
			String observaciones = "Esto es una observacion";
			HashSet<String> relacionesALBA = new HashSet<>();
			relacionesALBA.add("relacion 1");
			relacionesALBA.add("relacion 2");
			Persona p = es.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			
			List<Persona> l = es.consultaTexto(texto,true, Integer.MAX_VALUE);
			List<Persona> l2 = es.consultaTexto(texto,false, Integer.MAX_VALUE);
			
			es.baja(p.getId(), "");
			
			List<Persona> ld = es.consultaTexto(texto,true, Integer.MAX_VALUE);
			List<Persona> l2d = es.consultaTexto(texto,false, Integer.MAX_VALUE);
			
			assertTrue(l.size() == ld.size() &&
						l2.size() > l2d.size());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	

}
