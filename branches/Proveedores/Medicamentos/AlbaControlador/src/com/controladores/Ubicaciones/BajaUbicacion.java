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
 * Servlet implementation class BajaUbicaciónPersona
 */
@WebServlet(name = "bajaUbicaciónPersona", urlPatterns = { "/bajaUbicacion" })
public class BajaUbicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaUbicacion() {
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
				Double idUbicacion = serviciosJson.cargaParametroDouble(request, "idInterno");
				String nombreInstitucion = serviciosJson.cargaParametro(request, "nombreInstitucion");
				Double idPersona = serviciosJson.cargaParametroDouble(request, "idPersona");
				if(nombreInstitucion!=null && !nombreInstitucion.equalsIgnoreCase("")){
					new InstitucionService().bajaUbicacion(idUbicacion.intValue());
					out.println(serviciosJson.generaRetorno(true, "Baja realizada correctamente"));
				}else{
					if(idPersona!=null){
						new PersonaService().bajaUbicacion(idUbicacion.intValue());
						out.println(serviciosJson.generaRetorno(true, "Baja realizada correctamente"));
					}else{
						out.println(serviciosJson.generaRetorno(false, "Parametros incorrectos"));
					}
				}
			    	
		} catch (Exception e) {
			
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		} 
	}

}
