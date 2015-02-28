package com.controladores;

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
import com.base.interfaces.JsonObject;
import com.servicios.animales.AnimalService;
import com.servicios.animales.objetos.FiltroAtributos;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class Listado
 */
@WebServlet(name = "listado", urlPatterns = { "/listado" })
public class Listado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {	
			//Formato parametros entrada NombreAtributo_Tipo_Contador_Extras
			List<FiltroAtributos> atributos = new Vector<>();
			String AndOr = "";
			
			Iterator<Animal> en = new AnimalService().listadoFiltros(atributos, AndOr).iterator();
				List<JsonObject> objetos = new Vector<>();
				while (en.hasNext()) {								
					objetos.add(en.next());				
				}			
				String salida =serviciosJson.generaJson("BusquedaGeneral", objetos, "");
				out.println(salida);	
						
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
