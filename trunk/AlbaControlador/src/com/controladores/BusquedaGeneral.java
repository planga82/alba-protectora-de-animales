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

import com.base.interfaces.JsonObject;
import com.base.interfaces.ResultadoBusquedaGeneral;
import com.servicios.generales.GeneralService;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class BusquedaGeneral
 */
@WebServlet(name = "busquedaGeneral", urlPatterns = { "/busquedaGeneral" })
public class BusquedaGeneral extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaGeneral() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {			
			String texto = serviciosJson.cargaParametro(request,"textoBusqueda");
			int maxNumResultados = serviciosJson.cargaParametroDouble(request,"maxNumResultados").intValue();
			String todosEstados = serviciosJson.cargaParametro(request,"todosEstados"); 
			boolean incluirTodosEstados= false;
			if(todosEstados!=null){
				incluirTodosEstados = true;
			}
			Iterator<ResultadoBusquedaGeneral> en = new GeneralService().consultaTexto(texto,incluirTodosEstados,maxNumResultados).iterator();
				List<JsonObject> objetos = new Vector<>();
				while (en.hasNext()) {								
					objetos.add(en.next());				
				}			
				String salida =serviciosJson.generaJson("BusquedaGeneral", objetos, texto);
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
		
	}

}
