package test.servicios;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.base.interfaces.ResultadoBusquedaGeneral;
import com.inicio.OperacionesIniciales;
import com.servicios.animales.AnimalService;
import com.servicios.generales.GeneralService;
import com.servicios.instituciones.InstitucionService;
import com.servicios.personas.PersonaService;

public class GeneralServiceTest {

	GeneralService as = new GeneralService();
	
	AnimalService as1 = new AnimalService();
	PersonaService ps = new PersonaService();
	InstitucionService is = new InstitucionService();
	
	@BeforeClass
	public static void cargaContexto() throws Exception{
		OperacionesIniciales.inicializa();		
	}
	
	@Test
	public void testConsultaTexto() {
		try {
			
			String chip="ccccccccccccc";
		    String segundoIdentificador="sisisisisisisisisis";
		    String nombre="nnnn PTexto1";
		    String raza="rrrr";
		    Date fechaNacimiento=new Date(Calendar.getInstance().getTimeInMillis());
		    String sexo="m";
		    Boolean esterilizado=true;
		    String color="hhh";
		    String tamano="ddd";
		    String propietario="efhn";
		    Date fechaRegistro=new Date(Calendar.getInstance().getTimeInMillis());
		    String descripcion="wwww";
		    String lugarRecogida="rrrr PTexto1";
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
		    
		    as1.alta(chip, segundoIdentificador, nombre, null, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, "", pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAviso, personaRecoge, fechaRecoge, personaRecepciona, fechaRecepciona,estado, alturaCruz,"");
		    
		    String nombreP = "Pablo20";
			String apellidos = "Langa Blanco";
			String DNI = "56698564L";
			String telefono = "91 555 32 12 PTexto2";
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
			ps.alta(nombreP,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);			
			nombre = "Pablo21";			
			ps.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			nombre = "Pablo31";			
			ps.alta(nombre,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
			
			
			
			String nombreI="nombre10212"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321 PTexto3";
			String NombreDep1="dep1";
			String PersonaContactoDep1="personadep1";
			String emailDep1="skjdf1@gmail.com";
			String TelefonoDep1="34534534";
			String NombreDep2="dep2";
			String PersonaContactoDep2="epepe";
			String emailDep2="skjdf2@gmail.com";
			String TelefonoDep2="456456456";
			String NombreDep3="dep3";
			String PersonaContactoDep3="juan";
			String emailDep3="3skjdf@gmail.com";
			String TelefonoDep3="3343532";

			is.alta(nombreI, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, null, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			
			String texto1 = "PTexto1 PTexto2 PTexto3";
			
		    Set<ResultadoBusquedaGeneral> l1 = as.consultaTexto(texto1, true, Integer.MAX_VALUE);
		    Set<ResultadoBusquedaGeneral> l2 = as.consultaTexto(texto1, true, 3);
		    
		    //No recupera repetidos
			assertTrue(l1.size()==5 && l2.size()==3);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
