package test.servicios;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.base.entidades.instituciones.TipoInstitucion;
import com.inicio.OperacionesIniciales;
import com.servicios.instituciones.TipoInstitucionService;

public class TipoInstitucionServiceTest {

	@BeforeClass
	public static void cargaContexto(){
		OperacionesIniciales.inicializa();
	}
	@Test
	public void testAlta() {
		TipoInstitucionService es = new TipoInstitucionService();
		
		try {
			String n = "TI" + (TipoInstitucion.countTipoInstitucions()+1);
			TipoInstitucion e = es.alta(n);
			assertTrue(e.getNombreTipo().equalsIgnoreCase(n));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testAltaDuplicada() {
		TipoInstitucionService es = new TipoInstitucionService();
		
		try {
			String n = "TI" + (TipoInstitucion.countTipoInstitucions()+1);
			es.alta(n);
			es.alta(n);
			fail("No falla por duplicado");
		} catch (Exception e) {
			assertTrue(e.getMessage(), true);
		}
		
	}
	
	@Test
	public void testConsulta() {
		TipoInstitucionService es = new TipoInstitucionService();
		
		try {
			String n = "Especie" + (TipoInstitucion.countTipoInstitucions()+1);
			TipoInstitucion e = es.alta(n);
			Iterator<TipoInstitucion> it = es.consulta().iterator();
			while (it.hasNext()) { 
				TipoInstitucion especie = it.next();
				if(especie.getNombreTipo().equalsIgnoreCase(e.getNombreTipo())){
					assertTrue("", true);
					return;
				}
			}
			assertTrue("Elemento dado de alta no encontrado", false);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	

}
