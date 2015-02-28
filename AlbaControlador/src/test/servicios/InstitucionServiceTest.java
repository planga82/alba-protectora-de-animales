package test.servicios;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.base.entidades.animales.Animal;
import com.base.entidades.instituciones.Institucion;
import com.base.entidades.instituciones.TipoInstitucion;
import com.base.entidades.ubicaciones.Ubicacion;
import com.constants.Constantes;
import com.inicio.OperacionesIniciales;
import com.servicios.animales.AnimalService;
import com.servicios.instituciones.InstitucionService;
import com.servicios.instituciones.TipoInstitucionService;


public class InstitucionServiceTest {

	static InstitucionService is = new InstitucionService();
	static String tipoInstitucion= "Protectora animales";
	static String tipoInstitucion2= "Protectora animales2";
	
	static String nombre1="nombre0"; 
	static String NIF1="45534563O0"; 
	static String Dirección1="direccion0"; 
	static String PersonaContacto1="persona 10"; 
	static String TelefonoContacto1="2345566780"; 
	static String Email1="skjdf@gmail.com0";
	static String PaginaWeb1="www.pepito.com0";
	static String CuentaCargo1="444-4577-06-76543210";
	static String NombreDep11="dep10";
	static String PersonaContactoDep11="personadep10";
	static String emailDep11="skjdf1@gmail.com0";
	static String TelefonoDep11="345345340";
	static String NombreDep21="dep20";
	static String PersonaContactoDep21="epepe0";
	static String emailDep21="skjdf2@gmail.com0";
	static String TelefonoDep21="4564564560";
	static String NombreDep31="dep30";
	static String PersonaContactoDep31="juan0";
	static String emailDep31="3skjdf@gmail.com0";
	static String TelefonoDep31="33435320";
	
	@BeforeClass
	public static void cargaContexto() throws Exception{
		OperacionesIniciales.inicializa();
		TipoInstitucionService ti = new TipoInstitucionService();
		ti.alta(tipoInstitucion);
		ti.alta(tipoInstitucion2);
		is.alta(nombre1, NIF1, Dirección1, PersonaContacto1, TelefonoContacto1, Email1, tipoInstitucion, PaginaWeb1, CuentaCargo1, NombreDep11, PersonaContactoDep11, emailDep11, TelefonoDep11, NombreDep21, PersonaContactoDep21, emailDep21, TelefonoDep21, NombreDep31, PersonaContactoDep31, emailDep31, TelefonoDep31);
	}

	@Test
	public void testAlta() {
		try{
			String nombre="nombre"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			int n = TipoInstitucion.findTipoInstitucion(tipoInstitucion).getInstituciones().size();
			Institucion i = is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			Institucion b = Institucion.findInstitucion(i.getNombre());
			int nd = TipoInstitucion.findTipoInstitucion(tipoInstitucion).getInstituciones().size();
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getNIF().equalsIgnoreCase(NIF) &&
						b.getDireccion().equalsIgnoreCase(Dirección) &&
						b.getPersonaContacto().equalsIgnoreCase(PersonaContacto) &&
						b.getTelefonoContacto().equalsIgnoreCase(TelefonoContacto) &&
						b.getEmailContacto().equalsIgnoreCase(Email) &&
						b.getPaginaWeb().equalsIgnoreCase(PaginaWeb) &&
						b.getCuentaCargo().equalsIgnoreCase(CuentaCargo) &&
						b.getNombreDepartamento1().equalsIgnoreCase(NombreDep1) &&
						b.getPersonaContactoDepartamento1().equalsIgnoreCase(PersonaContactoDep1) &&
						b.getEmailDepartamento1().equalsIgnoreCase(emailDep1) &&
						b.getTelefonoDepartamento1().equalsIgnoreCase(TelefonoDep1) &&
						b.getNombreDepartamento2().equalsIgnoreCase(NombreDep2) &&
						b.getPersonaContactoDepartamento2().equalsIgnoreCase(PersonaContactoDep2) &&
						b.getEmailDepartamento2().equalsIgnoreCase(emailDep2) &&
						b.getTelefonoDepartamento2().equalsIgnoreCase(TelefonoDep2) &&
						b.getNombreDepartamento3().equalsIgnoreCase(NombreDep3) &&
						b.getPersonaContactoDepartamento3().equalsIgnoreCase(PersonaContactoDep3) &&
						b.getEmailDepartamento3().equalsIgnoreCase(emailDep3) &&
						b.getTelefonoDepartamento3().equalsIgnoreCase(TelefonoDep3) &&
						b.getEstado().equalsIgnoreCase(Constantes.estadoAlta) &&
						b.getUbicaciones().size() == 0 &&
						b.getTipo().getNombreTipo().equalsIgnoreCase(tipoInstitucion) &&
						nd > n); 
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAltaNombreExistente() {
		try{
			String nombre="nombre1"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			fail("Alta incorrecta");
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAltaCamposVacios() {
		try{
			String nombre="nombre2"; 
			String NIF=null; 
			String Dirección=null; 
			String PersonaContacto=null; 
			String TelefonoContacto=null; 
			String Email=null;
			String PaginaWeb=null;
			String CuentaCargo=null;
			String NombreDep1=null;
			String PersonaContactoDep1=null;
			String emailDep1=null;
			String TelefonoDep1=null;
			String NombreDep2=null;
			String PersonaContactoDep2=null;
			String emailDep2=null;
			String TelefonoDep2=null;
			String NombreDep3=null;
			String PersonaContactoDep3=null;
			String emailDep3=null;
			String TelefonoDep3=null;
			
			Institucion i = is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, null, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			Institucion b = Institucion.findInstitucion(i.getNombre());
			
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getNIF()==null &&
						b.getDireccion()==null &&
						b.getPersonaContacto()==null &&
						b.getTelefonoContacto()==null &&
						b.getEmailContacto()==null &&
						b.getPaginaWeb()==null &&
						b.getCuentaCargo()==null &&
						b.getNombreDepartamento1()==null &&
						b.getPersonaContactoDepartamento1()==null &&
						b.getEmailDepartamento1()==null &&
						b.getTelefonoDepartamento1()==null &&
						b.getNombreDepartamento2()==null &&
						b.getPersonaContactoDepartamento2()==null &&
						b.getEmailDepartamento2()==null &&
						b.getTelefonoDepartamento2()==null &&
						b.getNombreDepartamento3()==null &&
						b.getPersonaContactoDepartamento3()==null &&
						b.getEmailDepartamento3()==null &&
						b.getTelefonoDepartamento3()==null &&
						b.getEstado().equalsIgnoreCase(Constantes.estadoAlta) &&
						b.getUbicaciones().size() == 0 &&
						b.getTipo() == null);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testModificacion() {
		try{
			String nombre="nombre3"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			
			Institucion i = is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			
			NIF="45534563O1"; 
			Dirección="direccion1"; 
			PersonaContacto="persona 11"; 
			TelefonoContacto="2345566781"; 
			Email="skjdf@gmail.com1";
			PaginaWeb="www.pepito.com1";
			CuentaCargo="444-4577-06-76543211";
			NombreDep1="dep11";
			PersonaContactoDep1="personadep11";
			emailDep1="skjdf1@gmail.com1";
			TelefonoDep1="345345341";
			NombreDep2="dep21";
			PersonaContactoDep2="epepe1";
			emailDep2="skjdf2@gmail.com1";
			TelefonoDep2="4564564561";
			NombreDep3="dep31";
			PersonaContactoDep3="juan1";
			emailDep3="3skjdf@gmail.com1";
			TelefonoDep3="33435321";
			
			i = is.modificacion(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			Institucion b = Institucion.findInstitucion(i.getNombre());
			
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getNIF().equalsIgnoreCase(NIF) &&
						b.getDireccion().equalsIgnoreCase(Dirección) &&
						b.getPersonaContacto().equalsIgnoreCase(PersonaContacto) &&
						b.getTelefonoContacto().equalsIgnoreCase(TelefonoContacto) &&
						b.getEmailContacto().equalsIgnoreCase(Email) &&
						b.getPaginaWeb().equalsIgnoreCase(PaginaWeb) &&
						b.getCuentaCargo().equalsIgnoreCase(CuentaCargo) &&
						b.getNombreDepartamento1().equalsIgnoreCase(NombreDep1) &&
						b.getPersonaContactoDepartamento1().equalsIgnoreCase(PersonaContactoDep1) &&
						b.getEmailDepartamento1().equalsIgnoreCase(emailDep1) &&
						b.getTelefonoDepartamento1().equalsIgnoreCase(TelefonoDep1) &&
						b.getNombreDepartamento2().equalsIgnoreCase(NombreDep2) &&
						b.getPersonaContactoDepartamento2().equalsIgnoreCase(PersonaContactoDep2) &&
						b.getEmailDepartamento2().equalsIgnoreCase(emailDep2) &&
						b.getTelefonoDepartamento2().equalsIgnoreCase(TelefonoDep2) &&
						b.getNombreDepartamento3().equalsIgnoreCase(NombreDep3) &&
						b.getPersonaContactoDepartamento3().equalsIgnoreCase(PersonaContactoDep3) &&
						b.getEmailDepartamento3().equalsIgnoreCase(emailDep3) &&
						b.getTelefonoDepartamento3().equalsIgnoreCase(TelefonoDep3) &&
						b.getEstado().equalsIgnoreCase(Constantes.estadoAlta) &&
						b.getUbicaciones().size() == 0 &&
						b.getTipo().getNombreTipo().equalsIgnoreCase(tipoInstitucion));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testModificacionNombreNoExistente() {
		try{
			is.modificacion("Nombre no exitente", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
			fail("Baja permitida");
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testModificacionInstitucionDadaBaja() {
		try{
			String nombre="nombre4"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			is.baja(nombre, "baja");
			is.modificacion(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			fail("modificacion en estado de baja");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaSinUbicaciones() {
		try{
			String nombre="nombre5"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String motivo = "baja";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			is.baja(nombre, motivo);
			
			Institucion i = Institucion.findInstitucion(nombre);
			
			assertTrue(i.getEstado().equalsIgnoreCase(Constantes.estadoBaja) &&
					i.getMotivoBaja().equalsIgnoreCase(motivo));
			
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBajaConUbicacionesDadasBaja() {
		try{
			String nombre="nombre6"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String motivo = "baja";
			String ubicacion1 = "UB1";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			Ubicacion u = is.altaUbicacion(nombre, ubicacion1);
			is.bajaUbicacion(u.getIdInterno());
			
			is.baja(nombre, motivo);
			
			Institucion i = Institucion.findInstitucion(nombre);
			
			assertTrue(i.getEstado().equalsIgnoreCase(Constantes.estadoBaja) &&
					i.getMotivoBaja().equalsIgnoreCase(motivo));
			
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBajaConUbicacionesNoDadasBaja() {
		try{
			String nombre="nombre100"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String motivo = "baja";
			String ubicacion1 = "UB1"; 
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			Ubicacion u = is.altaUbicacion(nombre, ubicacion1);			
			is.baja(nombre, motivo);
			
			Institucion i = Institucion.findInstitucion(nombre);
			u = Ubicacion.findUbicacion(u.getIdInterno());
			assertTrue(i.getEstado().equalsIgnoreCase(Constantes.estadoBaja) &&
					i.getMotivoBaja().equalsIgnoreCase(motivo));			
			
		} catch (Exception e) {
			fail(e.getMessage()); 
		}
	}
	
	@Test
	public void testBajaConUbicacionesNoDadasBajaYAnimales() {
		try{
			String nombre="nombre7"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String motivo = "baja";
			String ubicacion1 = "UB1";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			Ubicacion ub = is.altaUbicacion(nombre, ubicacion1);
			
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
			
			is.baja(nombre, motivo);
			
			fail("Baja permitida");			
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaNombreNoExistente() {
		try{
			is.baja("Nombre no existente", "");
			fail("Baja permitida");
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaInstitucionYaDeBaja() {
		try{
			String nombre="nombre8"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String motivo = "baja";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);			
			is.baja(nombre, motivo);
			is.baja(nombre, motivo);
			fail("baja peritida");			
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaMotivoVacio() {
		try{
			String nombre="nombre9"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String motivo = ""; 
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			is.baja(nombre, motivo);
			
			Institucion i = Institucion.findInstitucion(nombre);
			
			assertTrue(i.getEstado().equalsIgnoreCase(Constantes.estadoBaja) &&
					i.getMotivoBaja().equalsIgnoreCase(motivo));
			
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAltaUbicacion() {
		try{
			String nombre="nombre10"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String ubicacion1 = "UB1";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			Ubicacion ub1 = is.altaUbicacion(nombre, ubicacion1);			
			Institucion i = Institucion.findInstitucion(nombre);
			Ubicacion ub2  = i.getUbicaciones().iterator().next();
			assertTrue(ub1.equals(ub2) &&
					ub1.getNombre().equalsIgnoreCase(ub2.getNombre()));
						
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAltaUbicacionInstitucionNoExistente() {
		try{
			is.altaUbicacion("Institucion no existente", "Ubiccacion");
			fail("Alta permitida");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAltaUbicacionNombreUbExistInstitucion() {
		try{
			String nombre="nombre11"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String ubicacion1 = "UB1";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			is.altaUbicacion(nombre, ubicacion1);
			is.altaUbicacion(nombre, ubicacion1);
			fail("Alta permitida");						
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	
	
	@Test
	public void testBajaUbicacionIdNoExistente() {
		try{
			String nombre="nombre12"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			is.bajaUbicacion(99L);
			fail("Alta permitida");						
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaUbicacionYaDadaDeBaja() {
		
		Ubicacion ub1=null;
		String nombre="nombre13";
		try{
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String ubicacion1 = "UB1";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			ub1 = is.altaUbicacion(nombre, ubicacion1);
			is.bajaUbicacion(ub1.getIdInterno());			
			
									
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try{
			is.bajaUbicacion(ub1.getIdInterno());
			fail("Baja permitida");
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaUbicacionConAnimalesAsociados() {
		Ubicacion ub1 = null;
		String nombre="nombre14"; 
		try{
			
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String ubicacion1 = "UB1";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			ub1 = is.altaUbicacion(nombre, ubicacion1);
			
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
			is.bajaUbicacion(ub1.getIdInterno());
			fail("baja permitida");	
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testBajaUbicacionSinAnimalesAsociados() {
		Ubicacion ub1=null;
		String nombre="nombre15";
		try{
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String ubicacion1 = "UB1";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			ub1 = is.altaUbicacion(nombre, ubicacion1);
			int n1 = Institucion.findInstitucion(nombre).getUbicaciones().size();
			is.bajaUbicacion(ub1.getIdInterno());			
			int n2 = Institucion.findInstitucion(nombre).getUbicaciones().size();
			assertTrue(n1>n2)	;					
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testAltaTrasBaja() {

		String nombre="nombre10000";
		try{
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			is.baja(nombre, "");
			is.ponerAlta(nombre);
			Institucion i = Institucion.findInstitucion(nombre);
			
			assertTrue(i.getEstado().equalsIgnoreCase(Constantes.estadoAlta));					
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testDetalle() {
		try{
			String nombre="nombre16"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			Institucion b = is.detalle(nombre);
			
			assertTrue(b.getNombre().equalsIgnoreCase(nombre) &&
						b.getNIF().equalsIgnoreCase(NIF) &&
						b.getDireccion().equalsIgnoreCase(Dirección) &&
						b.getPersonaContacto().equalsIgnoreCase(PersonaContacto) &&
						b.getTelefonoContacto().equalsIgnoreCase(TelefonoContacto) &&
						b.getEmailContacto().equalsIgnoreCase(Email) &&
						b.getPaginaWeb().equalsIgnoreCase(PaginaWeb) &&
						b.getCuentaCargo().equalsIgnoreCase(CuentaCargo) &&
						b.getNombreDepartamento1().equalsIgnoreCase(NombreDep1) &&
						b.getPersonaContactoDepartamento1().equalsIgnoreCase(PersonaContactoDep1) &&
						b.getEmailDepartamento1().equalsIgnoreCase(emailDep1) &&
						b.getTelefonoDepartamento1().equalsIgnoreCase(TelefonoDep1) &&
						b.getNombreDepartamento2().equalsIgnoreCase(NombreDep2) &&
						b.getPersonaContactoDepartamento2().equalsIgnoreCase(PersonaContactoDep2) &&
						b.getEmailDepartamento2().equalsIgnoreCase(emailDep2) &&
						b.getTelefonoDepartamento2().equalsIgnoreCase(TelefonoDep2) &&
						b.getNombreDepartamento3().equalsIgnoreCase(NombreDep3) &&
						b.getPersonaContactoDepartamento3().equalsIgnoreCase(PersonaContactoDep3) &&
						b.getEmailDepartamento3().equalsIgnoreCase(emailDep3) &&
						b.getTelefonoDepartamento3().equalsIgnoreCase(TelefonoDep3) &&
						b.getEstado().equalsIgnoreCase(Constantes.estadoAlta) &&
						b.getUbicaciones().size() == 0 &&
						b.getTipo().getNombreTipo().equalsIgnoreCase(tipoInstitucion));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testDetalleNombreNoExiste() {
		try{
			is.detalle("Nombre no existente");
			fail("Detalle sin fallo");
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testCambioTipo() {
		try{
			String nombre="nombre17"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			int n = TipoInstitucion.findTipoInstitucion(tipoInstitucion).getInstituciones().size();
			int n2 = TipoInstitucion.findTipoInstitucion(tipoInstitucion2).getInstituciones().size();
			is.cambiarTipo(nombre, tipoInstitucion2);
			int nd = TipoInstitucion.findTipoInstitucion(tipoInstitucion).getInstituciones().size();
			int n2d = TipoInstitucion.findTipoInstitucion(tipoInstitucion2).getInstituciones().size();
			
			Institucion b = Institucion.findInstitucion(nombre);
			
			assertTrue(b.getTipo().getNombreTipo().equalsIgnoreCase(tipoInstitucion2) &&
					n > nd &&
					n2 < n2d);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCambioTipoNoExistente() {
		String nombre="nombre18";
		try{
			 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
						
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try{
			is.cambiarTipo(nombre, "Tipo inexistente");
			fail("Cambio permitido");
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testConsultaNIF() {
		try{
			List<Institucion> l = is.constultaNIF(NIF1);
			assertTrue(l.size()>0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaNIFNoExistente() {
		try{
			List<Institucion> l = is.constultaNIF("Nif no existente");
			assertTrue(l.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaPersonaContacto() {
		try{
			List<Institucion> l = is.constultaPersonaContacto(PersonaContacto1);
			assertTrue(l.size()>0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaPersonaContactoNoExistente() {
		try{
			List<Institucion> l = is.constultaPersonaContacto("Persona no existente");
			assertTrue(l.size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaTipo() {
		try{
			Set<Institucion> l = is.constultaTipo(tipoInstitucion);
			assertTrue(l.size()>0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaTipoNoExistente() {
		try{
			is.constultaTipo("Tipo no existente");
			fail("Consulta con exito");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testConsultaEstadoBaja() {
		try{
			String nombre="nombre101"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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
			String motivo = "baja";
			
			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			is.baja(nombre, motivo);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try{
			List<Institucion> l = is.constultaEstadoBaja();
			assertTrue(l.size()>0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaTexto() {
		try{
			String t1="nombre"; 
			String t2="5534563O"; 
			String t3="direcci"; 
			String t4="persona 1"; 
			String t5="234556678"; 
			String t6="skjdf@gmail.com";
			String t7="www.pepito.com";
			String t8="444-4577-06-7654321";
			String t9="dep1";
			String t10="personadep1";
			String t11="skjdf1@gmail.com";
			String t12="34534534";
			String t13="dep2";
			String t14="epepe";
			String t15="skjdf2@gmail.com";
			String t16="456456456";
			String t17="dep3";
			String t18="juan";
			String t19="3skjdf@gmail.com";
			String t20="3343532";
			String t21="Texto para no encontrar";
			
			String nombre="nombre102"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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

			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			
			List<Institucion> l1 = is.consultaTexto(t1, false, Integer.MAX_VALUE);
			List<Institucion> l2 = is.consultaTexto(t2, false, Integer.MAX_VALUE);
			List<Institucion> l3 = is.consultaTexto(t3, false, Integer.MAX_VALUE);
			List<Institucion> l4 = is.consultaTexto(t4, false, Integer.MAX_VALUE);
			List<Institucion> l5 = is.consultaTexto(t5, false, Integer.MAX_VALUE);
			List<Institucion> l6 = is.consultaTexto(t6, false, Integer.MAX_VALUE);
			List<Institucion> l7 = is.consultaTexto(t7, false, Integer.MAX_VALUE);
			List<Institucion> l8 = is.consultaTexto(t8, false, Integer.MAX_VALUE);
			List<Institucion> l9 = is.consultaTexto(t9, false, Integer.MAX_VALUE);
			List<Institucion> l10 = is.consultaTexto(t10, false, Integer.MAX_VALUE);
			List<Institucion> l11 = is.consultaTexto(t11, false, Integer.MAX_VALUE);
			List<Institucion> l12 = is.consultaTexto(t12, false, Integer.MAX_VALUE);
			List<Institucion> l13 = is.consultaTexto(t13, false, Integer.MAX_VALUE);
			List<Institucion> l14 = is.consultaTexto(t14, false, Integer.MAX_VALUE);
			List<Institucion> l15 = is.consultaTexto(t15, false, Integer.MAX_VALUE);
			List<Institucion> l16 = is.consultaTexto(t16, false, Integer.MAX_VALUE);
			List<Institucion> l17 = is.consultaTexto(t17, false, Integer.MAX_VALUE);
			List<Institucion> l18 = is.consultaTexto(t18, false, Integer.MAX_VALUE);
			List<Institucion> l19 = is.consultaTexto(t19, false, Integer.MAX_VALUE);
			List<Institucion> l20 = is.consultaTexto(t20, false, Integer.MAX_VALUE);
			List<Institucion> l21 = is.consultaTexto(t21, false, Integer.MAX_VALUE);
			List<Institucion> l22 = is.consultaTexto("", false, Integer.MAX_VALUE);
			List<Institucion> l23 = is.consultaTexto(null, false, Integer.MAX_VALUE);
			assertTrue(l1.size()>0 &&
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
					l16.size()>0 &&
					l17.size()>0 &&
					l18.size()>0 &&
					l19.size()>0 &&
					l20.size()>0 &&
					l22.size()>0 &&
					l23.size()>0 &&
					l21.size()==0); 
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConsultaTextoBajas() {
		try{
			String t1="nombre"; 		
			
			String nombre="nombre103"; 
			String NIF="45534563O"; 
			String Dirección="direccion"; 
			String PersonaContacto="persona 1"; 
			String TelefonoContacto="234556678"; 
			String Email="skjdf@gmail.com";
			String PaginaWeb="www.pepito.com";
			String CuentaCargo="444-4577-06-7654321";
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

			is.alta(nombre, NIF, Dirección, PersonaContacto, TelefonoContacto, Email, tipoInstitucion, PaginaWeb, CuentaCargo, NombreDep1, PersonaContactoDep1, emailDep1, TelefonoDep1, NombreDep2, PersonaContactoDep2, emailDep2, TelefonoDep2, NombreDep3, PersonaContactoDep3, emailDep3, TelefonoDep3);
			
			List<Institucion> l1 = is.consultaTexto(t1, true, Integer.MAX_VALUE);
			List<Institucion> l2 = is.consultaTexto(t1, false, Integer.MAX_VALUE);
			
			is.baja(nombre, "");
			
			List<Institucion> l1d = is.consultaTexto(t1, true, Integer.MAX_VALUE);
			List<Institucion> l2d = is.consultaTexto(t1, false, Integer.MAX_VALUE);
			
			assertTrue(l1.size() == l1d.size() &&
					l2.size() > l2d.size()); 
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	

}
