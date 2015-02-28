package com.controladores.animales;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entidades.animales.Animal;
import com.servicios.animales.AnimalService;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class CambioUbicacionAnimal
 */
@WebServlet(name = "cambioUbicacionAnimal", urlPatterns = { "/cambioUbicacionAnimal" })
public class CambioUbicacionAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambioUbicacionAnimal() {
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
				Double idAnimal= serviciosJson.cargaParametroDouble(request, "id");	
				Double idNuevaUbicacion= serviciosJson.cargaParametroDouble(request, "idInterno");	
				
			    Animal a = as.cambiarUbicacion(idAnimal.longValue(), idNuevaUbicacion.longValue());			
			    
			    out.println(serviciosJson.generaRetorno(true, "Alta generada correctamente " + a.getId()));	
			    
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}

}
