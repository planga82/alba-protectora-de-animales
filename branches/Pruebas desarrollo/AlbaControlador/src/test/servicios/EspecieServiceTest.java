package test.servicios;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.base.entidades.animales.Especie;
import com.inicio.OperacionesIniciales;
import com.servicios.animales.EspecieService;

public class EspecieServiceTest {

	@BeforeClass
	public static void cargaContexto(){
		OperacionesIniciales.inicializa();
	}
	@Test
	public void testAlta() {
		EspecieService es = new EspecieService();
		
		try {
			String n = "Especie" + (Especie.countEspecies()+1);
			Especie e = es.alta(n);
			assertTrue(e.getNombre().equalsIgnoreCase(n));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testAltaDuplicada() {
		EspecieService es = new EspecieService();
		
		try {
			String n = "Especie" + (Especie.countEspecies()+1);
			es.alta(n);
			es.alta(n);
			fail("No falla por duplicado");
		} catch (Exception e) {
			assertTrue(e.getMessage(), true);
		}
		
	}
	
	@Test
	public void testConsulta() {
		EspecieService es = new EspecieService();
		
		try {
			String n = "Especie" + (Especie.countEspecies()+1);
			Especie e = es.alta(n);
			Iterator<Especie> it = es.consulta().iterator();
			while (it.hasNext()) { 
				Especie especie = (Especie) it.next();
				if(especie.getNombre().equalsIgnoreCase(e.getNombre())){
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
