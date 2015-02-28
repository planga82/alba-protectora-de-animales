package com.controladores.animales;

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

import com.base.entidades.animales.HistoricoUbicaciones;
import com.base.interfaces.JsonObject;
import com.servicios.animales.AnimalService;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class ChistoricoUbicaciones
 */
@WebServlet(name = "historicoUbicaciones", urlPatterns = { "/historicoUbicaciones" })
public class ChistoricoUbicaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChistoricoUbicaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Double idAnimal = serviciosJson.cargaParametroDouble(request, "id");
		try{
			Iterator<HistoricoUbicaciones> en = new AnimalService().detalle(idAnimal.longValue()).getHistoricoUbicaciones().iterator();
			List<JsonObject> objetos = new Vector<>();
			while (en.hasNext()) {								
				objetos.add(en.next());				
			}			
			out.println(serviciosJson.generaJson(new HistoricoUbicaciones().getNombreListado(), objetos,""));
			
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
