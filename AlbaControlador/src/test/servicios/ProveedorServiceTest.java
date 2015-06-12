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
	
	@BeforeClass
	public static void cargaContexto() throws Exception{
		OperacionesIniciales.inicializa();		
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
}
