package com.controladores.Ubicaciones;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servicios.instituciones.InstitucionService;
import com.servicios.json.serviciosJson;
import com.servicios.personas.PersonaService;

/**
 * Servlet implementation class GestionUbicacion
 */
@WebServlet(name = "gestionUbicacion", urlPatterns = { "/gestionUbicacion" })
public class GestionUbicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUbicacion() {
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
		PrintWriter out = response.getWriter();
		try {
				String nombreNuevaUbicacion= serviciosJson.cargaParametro(request, "nombreNuevaUbicacion");	
				String nombreInstitucion= serviciosJson.cargaParametro(request, "nombreInstitucion");
				Double id = serviciosJson.cargaParametroDouble(request, "idPersona");
				if(id != null){ 
					new PersonaService().altaUbicacion(id.longValue(), nombreNuevaUbicacion);
				}else{
					new InstitucionService().altaUbicacion(nombreInstitucion, nombreNuevaUbicacion);
				}
			    
			    out.println(serviciosJson.generaRetorno(true, "Alta correcta"));	
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		} 
	}

}
