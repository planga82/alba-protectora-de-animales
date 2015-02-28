package com.controladores.animales;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class busquedaAnimal
 */
@WebServlet("/busquedaAnimal")
public class busquedaAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public busquedaAnimal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {		
			String textoBusqueda="";
			String criterioBusqueda = serviciosJson.cargaParametro(request,"criterioBusqueda");
			String checkBaja = serviciosJson.cargaParametro(request,"checkBaja");
			Boolean check= true;
			if(checkBaja == null || !checkBaja.equals("1")){
				check = false;
			}
			//out.println("{\"animales\": [{\"raza\":\"\",\"nombre\":\"aaa\",\"id\":\"1\",\"lugarRecogida\":\"\",\"personaRecoge\":\"\",\"color\":\"\",\"fechaPesoActual\":\"2013-08-14\",\"descripcion\":\"aaaaa\",\"personaAvisa\":\"\",\"propietario\":\"\",\"fechaRegistro\":\"2013-08-14\",\"personaRecepciona\":\"\"}]}");
			if(criterioBusqueda == null){
				Iterator<Animal> en = new AnimalService().consulta(check).iterator();
				List<JsonObject> objetos = new Vector<>();
				while (en.hasNext()) {								
					objetos.add(en.next());				
				}			
				String salida =serviciosJson.generaJson(new Animal().getNombreListado(), objetos,"");
				out.println(salida);
				
			}else{
		
				Iterator<Animal> en=null;
				
				
				if(criterioBusqueda.equalsIgnoreCase("ES")){
					String param = request.getParameter("esterilizado");					
					if(param==null || param.equalsIgnoreCase("")){
						en = new AnimalService().consulta(check).iterator();
					}else{
						en = new AnimalService().consultaEsterilizado(Boolean.parseBoolean(param),check).iterator();
					}							
				}
				
				if(criterioBusqueda.equalsIgnoreCase("RA")){
					String ra = request.getParameter("recogidoAyuntamiento");
					String fd = request.getParameter("fechaRegistroDesde");
					String fh = request.getParameter("fechaRegistroHasta");
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
					if(ra==null || ra.equalsIgnoreCase("") || fd==null || fd.equalsIgnoreCase("") || fh==null || fh.equalsIgnoreCase("")){
						en = new AnimalService().consulta(check).iterator();
					}else{
						en = new AnimalService().consultarecogidoAyuntamiento(Boolean.parseBoolean(ra),new Date(sdf1.parse(fd).getTime()),new Date(sdf1.parse(fh).getTime()),check).iterator();
					}							
				}
				
				if(criterioBusqueda.equalsIgnoreCase("EP")){
					String param = serviciosJson.cargaParametro(request,"especie");					
					if(param==null || param.equalsIgnoreCase("")){
						en = new AnimalService().consulta(check).iterator();
					}else{
						en = new AnimalService().consultaEspecie(param).iterator();
					}							
				}
				
				if(criterioBusqueda.equalsIgnoreCase("TB")){
					String param = serviciosJson.cargaParametro(request,"textoBusqueda");					
					if(param==null || param.equalsIgnoreCase("")){
						en = new AnimalService().consulta(check).iterator();
					}else{
						textoBusqueda = param;
						en = new AnimalService().consultaTexto(param,check,Integer.MAX_VALUE).iterator();
					}							
				}
				
				
				
				List<JsonObject> objetos = new Vector<>();
				while (en.hasNext()) {								
					objetos.add(en.next());				
				}			
				out.println(serviciosJson.generaJson(new Animal().getNombreListado(), objetos,textoBusqueda));
				
				
			}
						
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
