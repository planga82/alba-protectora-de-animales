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

import com.base.entidades.ubicaciones.UbicacionInstitucion;
import com.base.entidades.ubicaciones.UbicacionPersona;
import com.base.interfaces.JsonObject;
import com.servicios.instituciones.InstitucionService;
import com.servicios.json.serviciosJson;
import com.servicios.personas.PersonaService;

/**
 * Servlet implementation class ListadoUbicaciones
 */
@WebServlet(name = "listadoUbicaciones", urlPatterns = { "/listadoUbicaciones" })
public class ListadoUbicaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoUbicaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			Double id = serviciosJson.cargaParametroDouble(request, "idPersona");
			String nombreInstitucion= serviciosJson.cargaParametro(request, "nombreInstitucion");
			String filtroUbicacion = serviciosJson.cargaParametro(request, "textoBusquedaUbicacion");
			
			if(id!=null){			
				Iterator<UbicacionPersona> en = new PersonaService().detalle(id.longValue()).getUbicaciones().iterator();
				List<JsonObject> objetos = new Vector<>();
				while (en.hasNext()) {	
					UbicacionPersona up = en.next();
					if(filtroUbicacion == null || filtroUbicacion.equals("") || up.getNombreMostrar().toUpperCase().contains(filtroUbicacion)){
						objetos.add(up);				
					}
				}			
				out.println(serviciosJson.generaJson(new UbicacionPersona().getNombreListado(), objetos,""));
			}else{
				Iterator<UbicacionInstitucion> en = new InstitucionService().detalle(nombreInstitucion).getUbicaciones().iterator();
				List<JsonObject> objetos = new Vector<>();
				while (en.hasNext()) {								
					UbicacionInstitucion up = en.next();
					if(filtroUbicacion == null || filtroUbicacion.equals("") || up.getNombreMostrar().toUpperCase().contains(filtroUbicacion)){
						objetos.add(up);				
					}				
				}			
				out.println(serviciosJson.generaJson(new UbicacionInstitucion().getNombreListado(), objetos,""));
			}
			
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
