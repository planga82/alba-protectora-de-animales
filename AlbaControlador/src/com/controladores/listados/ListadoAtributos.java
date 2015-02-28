package com.controladores.listados;

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

import com.base.interfaces.JsonObject;
import com.servicios.json.serviciosJson;
import com.servicios.listados.ServiciosListados;

/**
 * Servlet implementation class ListadoAtributos
 */
@WebServlet(name = "listadoAtributos", urlPatterns = { "/listadoAtributos" })
public class ListadoAtributos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoAtributos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		try{
			List<Atributo> atributos= ServiciosListados.atributosEntidad(serviciosJson.cargaParametro(request, "Entidad"));			
			Iterator<Atributo> en = atributos.iterator();
			List<JsonObject> objetos = new Vector<>();
			while (en.hasNext()) {								
				objetos.add(en.next());				
			}
						
			out.println(serviciosJson.generaJson(new Atributo().getNombreListado(), objetos, ""));
			
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
