package com.controladores.Ubicaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entidades.animales.Animal;
import com.base.entidades.ubicaciones.UbicacionInstitucion;
import com.base.entidades.ubicaciones.UbicacionPersona;
import com.base.interfaces.JsonObject;
import com.servicios.instituciones.InstitucionService;
import com.servicios.json.serviciosJson;
import com.servicios.personas.PersonaService;

/**
 * Servlet implementation class AnimalesEnUbicacion
 */
@WebServlet(name = "animalesEnUbicacion", urlPatterns = { "/animalesEnUbicacion" })
public class AnimalesEnUbicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalesEnUbicacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			
			String nombreInstitucion= serviciosJson.cargaParametro(request, "nombreInstitucion");
			Double idPersona= serviciosJson.cargaParametroDouble(request, "idPersona");
			
			Iterator<Animal> it = null;
			
			if(idPersona != null){			
				Double id = serviciosJson.cargaParametroDouble(request, "idInterno");
				Iterator<UbicacionPersona> en = new PersonaService().detalle(idPersona.longValue()).getUbicaciones().iterator();
				
				while (en.hasNext()) {	
					UbicacionPersona ui = en.next();
					if(ui.getIdInterno() == id.longValue()){
						it = ui.getAnimales().iterator();
					}
				}
						
			}else{
				Double id = serviciosJson.cargaParametroDouble(request, "idInterno"); 
				Iterator<UbicacionInstitucion> en = new InstitucionService().detalle(nombreInstitucion).getUbicaciones().iterator();
		
				while (en.hasNext()) {	
					UbicacionInstitucion ui = en.next();
					if(ui.getIdInterno() == id.longValue()){
						it = ui.getAnimales().iterator();
					}
				}		
				
			}
			
			List<JsonObject> objetos = new Vector<>();
			while (it.hasNext()) {								
				objetos.add(it.next());				
			}
			
			out.println(serviciosJson.generaJson(new Animal().getNombreListado(), objetos,""));
			
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
