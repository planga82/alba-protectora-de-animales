package com.controladores.animales;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entidades.animales.Animal;
import com.servicios.animales.AnimalService;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class ModificarAnimal
 */
@WebServlet(name = "modificarAnimal", urlPatterns = { "/modificarAnimal" })
public class ModificarAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarAnimal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalService as = new AnimalService();
		PrintWriter out = response.getWriter();
		try {
				Double idAnimal = serviciosJson.cargaParametroDouble(request, "id");
				String nombre= serviciosJson.cargaParametro(request, "nombre");	
				String chip = serviciosJson.cargaParametro(request, "chip");
				String segundoIdentificador = serviciosJson.cargaParametro(request, "segundoIdentificador");
				String raza = serviciosJson.cargaParametro(request, "raza");
				String sexo = serviciosJson.cargaParametro(request, "sexo");
				String color = serviciosJson.cargaParametro(request, "color");
				String tamano = serviciosJson.cargaParametro(request, "tamano");
				String propietario = serviciosJson.cargaParametro(request, "propietario");
				String descripcion = serviciosJson.cargaParametro(request, "descripcion");
				String lugarRecogida = serviciosJson.cargaParametro(request, "lugarRecogida");
				String personaAvisa = serviciosJson.cargaParametro(request, "personaAvisa");
				String personaRecoge = serviciosJson.cargaParametro(request, "personaRecoge");
				String personaRecepciona = serviciosJson.cargaParametro(request, "personaRecepciona");
				String nombreEspecie = serviciosJson.cargaParametro(request, "especie");
				String tipoPatrocinador=serviciosJson.cargaParametro(request, "tipoPatrocinador");;
				String idPatrocinador=serviciosJson.cargaParametro(request, "idPatrocinador");;
				String rutaFoto=null;
				
				Double alturaCruz = serviciosJson.cargaParametroDouble(request, "alturaCruz"); 
				 
				Boolean recogidoAyuntamiento = serviciosJson.cargaParametroBoolean(request, "recogidoAyuntamiento");
				Boolean esterilizado = serviciosJson.cargaParametroBoolean(request, "esterilizado");
	 	
				Date fechaNacimiento = serviciosJson.cargaParametroFecha(request, "fechaNacimiento");
				Date fechaAvisa = serviciosJson.cargaParametroFecha(request, "fechaAvisa");
				Date fechaRecogido = serviciosJson.cargaParametroFecha(request, "fechaRecogido");
				Date fechaRecepcion = serviciosJson.cargaParametroFecha(request, "fechaRecepcion");
				
				
						  
			    
			    Animal a = as.modificacion(idAnimal.longValue(), chip, segundoIdentificador, nombre, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaNacimiento, descripcion, rutaFoto, lugarRecogida, recogidoAyuntamiento, personaAvisa, fechaAvisa, personaRecoge, fechaRecogido, personaRecepciona, fechaRecepcion, alturaCruz);			
			    
			    if(nombreEspecie != null && !(a.getEspecie()!=null && a.getEspecie().getNombre().equalsIgnoreCase(nombreEspecie))){
			    	as.cambiarEspecie(idAnimal.longValue(), nombreEspecie);			    	
			    }
			    
			    if(tipoPatrocinador != null && idPatrocinador != null){
					if(tipoPatrocinador.equalsIgnoreCase("Persona")){
						as.asignarPatrocinadorPersona(a.getId(), Long.parseLong(idPatrocinador));
					}else{
						as.asignarPatrocinadorInstitucion(a.getId(), idPatrocinador);
					}				
				}else{
					as.desasignarPatrocinador(a.getId());
				}
			    out.println(serviciosJson.generaRetorno(true, "Modificacion reaizado correctamente " + a.getId()));	
			    
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}

}
