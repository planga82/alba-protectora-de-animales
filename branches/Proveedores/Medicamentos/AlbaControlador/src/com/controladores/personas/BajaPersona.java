package com.controladores.personas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constants.Constantes;
import com.servicios.json.serviciosJson;
import com.servicios.personas.PersonaService;

/**
 * Servlet implementation class BajaPersona
 */
@WebServlet(name = "bajaPersona", urlPatterns = { "/cambioEstadoPersona" })
public class BajaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaPersona() {
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
				String estadoPersona = serviciosJson.cargaParametro(request, "estadoPersona");					
				Double id = serviciosJson.cargaParametroDouble(request, "idPersona");
				 
				if(estadoPersona.equalsIgnoreCase(Constantes.estadoBaja)){
					new PersonaService().baja(id.longValue(), "");
				}else{
					new PersonaService().ponerAlta(id.longValue());
				}
				
			    
			    out.println(serviciosJson.generaRetorno(true, "Cambio realizado correctamente"));	
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		} 
	}

}
