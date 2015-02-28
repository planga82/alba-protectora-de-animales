package com.controladores.instituciones;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constants.Constantes;
import com.servicios.instituciones.InstitucionService;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class BajaInstitucion
 */
@WebServlet(name = "bajaInstitucion", urlPatterns = { "/cambioEstadoInstitucion" })
public class BajaInstitucion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaInstitucion() {
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
				String nombreInstitucion = serviciosJson.cargaParametro(request, "nombreInstitucion");
				String estadoInstitucion = serviciosJson.cargaParametro(request, "estadoInstitucion");
				
				if(estadoInstitucion.equalsIgnoreCase(Constantes.estadoBaja)){
					new InstitucionService().baja(nombreInstitucion, "");
				}else{
					new InstitucionService().ponerAlta(nombreInstitucion);
				}
			    			
			    
			    out.println(serviciosJson.generaRetorno(true, "Cambio realizado correctamente"));	
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		} 
	}

}
