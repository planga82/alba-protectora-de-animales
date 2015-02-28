package com.controladores.personas;

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

import com.base.entidades.personas.Persona;
import com.base.interfaces.JsonObject;
import com.servicios.json.serviciosJson;
import com.servicios.personas.PersonaService;

/**
 * Servlet implementation class BusquedaPersonas
 */
@WebServlet(name = "busquedaPersonas", urlPatterns = { "/busquedaPersonas" })
public class BusquedaPersonas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaPersonas() {
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
			String baja = serviciosJson.cargaParametro(request,"baja"); 
			boolean incluirBajas= false;
			if(baja!=null){
				incluirBajas = true;
			}
			Iterator<Persona> en = new PersonaService().consultaTexto(texto,incluirBajas,Integer.MAX_VALUE).iterator();
				List<JsonObject> objetos = new Vector<>();
				while (en.hasNext()) {								
					objetos.add(en.next());				
				}			
				String salida =serviciosJson.generaJson(new Persona().getNombreListado(), objetos, texto);
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
