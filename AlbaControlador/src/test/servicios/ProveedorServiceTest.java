package test.servicios;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.base.entidades.proveedores.Proveedor;
import com.inicio.OperacionesIniciales;
import com.servicios.proveedores.ProveedorService;
import com.servicios.proveedores.contenedores.ContenedorAltaProveedor;



public class ProveedorServiceTest {

	ProveedorService ps = new ProveedorService();
	static ContenedorAltaProveedor texto;
	
	@BeforeClass
	public static void cargaContexto() throws Exception{
		OperacionesIniciales.inicializa();		
		
		 texto = new ContenedorAltaProveedor();
		 texto.setNombre("Proveedor4");
		 texto.setCif("cifdeprueba111");
		 texto.setDomicilio("Calle de prueba111");
		 texto.setLocalidad("Torremocha111");
		 texto.setProvincia("Cuenca111");
		 texto.setCodigoPostal("26895111");
		 texto.setPais("España111");
		 texto.setFax("54789652111");
		 texto.setTelefono("915874589111");
		 texto.setEmail("perico@prueba.es111");
		 texto.setNombreContacto("Juan Perez111");
		 texto.setDniContacto("5669854P111");
		 texto.setCargoContacto("Director111");
		 texto.setNumeroCuenta("5489-9874-89-78945612307894561111");
		 
		 new ProveedorService().alta(texto);
		
	}
	
	//Alta correcta proveedor con solo nombre relleno
	@Test
	public void testAlta() throws Exception {
		ContenedorAltaProveedor c = new ContenedorAltaProveedor();
		c.setNombre("Proveedor1");
		
		Proveedor p = ps.alta(c);
		
		assertEquals(c.getNombre(),p.getNombre());
		
	}
	
	//Alta correcta proveedor con todos los datos rellenos
	@Test
	public void testAltaTodosDatos() throws Exception {
		ContenedorAltaProveedor c = new ContenedorAltaProveedor();
		c.setNombre("Proveedor2");
		c.setCif("cifdeprueba");
		c.setDomicilio("Calle de prueba");
		c.setLocalidad("Torremocha");
		c.setProvincia("Cuenca");
		c.setCodigoPostal("26895");
		c.setPais("España");
		c.setFax("54789652");
		c.setTelefono("915874589");
		c.setEmail("perico@prueba.es");
		c.setNombreContacto("Juan Perez");
		c.setDniContacto("5669854P");
		c.setCargoContacto("Director");
		c.setNumeroCuenta("5489-9874-89-78945612307894561230");
		
		Proveedor p = ps.alta(c);
		
		comparaSalida(c, p);
		
	}
	//Fallo alta de proveedor sin nombre relleno
	@Test
	public void testAltaSinNombre() {
		ContenedorAltaProveedor c = new ContenedorAltaProveedor();		
		c.setCif("cifdeprueba");
		
		try{
			ps.alta(c);
		}catch(Exception e){
			assertTrue(true);
			return;
		}
		assertTrue(false);
		
		
	}
	//Fallo alta proveedor por nombre duplicado
	
	@Test
	public void testAltaDuplicado() throws Exception {
		ContenedorAltaProveedor c = new ContenedorAltaProveedor();
		c.setNombre("Proveedor3");		
		ps.alta(c);		
		try{
			ps.alta(c);
		}catch(Exception e){
			assertTrue(true);
			return;
		}
		assertTrue(false);
		
		
		
	}
	
	//Cosulta por texto
	@Test
	public void testConsultaTextoNombre() throws Exception {	
		
		Proveedor p = ps.consultaTexto(texto.getNombre(),true, 10).get(0);		
		comparaSalida(texto, p);
	}
	
	@Test
	public void testConsultaTextoCif() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getCif(),true, 10).get(0);		
		comparaSalida(texto, p);
	}
	
	@Test
	public void testConsultaTextoDomicilio() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getDomicilio(),true, 10).get(0);		
		comparaSalida(texto, p);
	}
	
	@Test
	public void testConsultaTextoLocalidad() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getLocalidad(),true, 10).get(0);		
		comparaSalida(texto, p);
	}
	
	@Test
	public void testConsultaTextoProvincia() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getProvincia(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoCodigoPostal() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getCodigoPostal(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoPais() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getPais(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoFax() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getFax(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoTelefono() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getTelefono(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoEmail() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getEmail(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoNombreContacto() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getNombreContacto(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoDniContacto() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getDniContacto(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoCargoContacto() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getCargoContacto(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoNumeroCuenta() throws Exception {
		
		Proveedor p = ps.consultaTexto(texto.getNumeroCuenta(),true, 10).get(0);		
		comparaSalida(texto, p);
		
	}
	
	@Test
	public void testConsultaTextoNoExiste() throws Exception {
		
		int n = ps.consultaTexto("texto_que_no_existe",true, 10).size();	
		assertTrue(n==0);
		
		
	}
	
	@Test
	public void testConsultaTextoVacio() throws Exception {
		
		int n = ps.consultaTexto("",true, 10).size();	
		assertTrue(n>0);
		
		
	}
	
	@Test
	public void testConsultaTextoLimite10() throws Exception {
		
		ContenedorAltaProveedor c = new ContenedorAltaProveedor();
		c.setNombre("P1");		
		ps.alta(c);
		c.setNombre("P2");		
		ps.alta(c);
		c.setNombre("P3");		
		ps.alta(c);
		c.setNombre("P4");		
		ps.alta(c);
		c.setNombre("P5");		
		ps.alta(c);
		c.setNombre("P6");		
		ps.alta(c);
		c.setNombre("P7");		
		ps.alta(c);
		c.setNombre("P8");		
		ps.alta(c);
		c.setNombre("P9");		
		ps.alta(c);
		c.setNombre("P10");		
		ps.alta(c);
		c.setNombre("P11");		
		ps.alta(c);
		c.setNombre("P12");		
		ps.alta(c);	
		
		
		int n = ps.consultaTexto("P",true, 10).size();	
		assertTrue(n==10);
		
		
	}
	
	
	private void comparaSalida(ContenedorAltaProveedor c, Proveedor p){
		assertEquals(c.getNombre()        ,p.getNombre()         );
		assertEquals(c.getCif()           ,p.getCif()            );
		assertEquals(c.getDomicilio()     ,p.getDomicilio()      );
		assertEquals(c.getLocalidad()     ,p.getLocalidad()      );
		assertEquals(c.getProvincia()     ,p.getProvincia()      );
		assertEquals(c.getCodigoPostal()  ,p.getCodigoPostal()   );
		assertEquals(c.getPais()          ,p.getPais()           );
		assertEquals(c.getFax()           ,p.getFax()            );
		assertEquals(c.getTelefono()      ,p.getTelefono()       );
		assertEquals(c.getEmail()         ,p.getEmail()          );
		assertEquals(c.getNombreContacto(),p.getNombreContacto() );
		assertEquals(c.getDniContacto()   ,p.getDniContacto()    );
		assertEquals(c.getCargoContacto() ,p.getCargoContacto()  );
		assertEquals(c.getNumeroCuenta()  ,p.getNumeroCuenta()   );
	}
}
