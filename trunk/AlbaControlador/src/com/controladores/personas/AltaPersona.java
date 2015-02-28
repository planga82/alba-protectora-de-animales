package com.controladores.personas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entidades.personas.Persona;
import com.servicios.json.serviciosJson;
import com.servicios.personas.PersonaService;

/**
 * Servlet implementation class AltaPersona
 */
@WebServlet(name = "altaPersona", urlPatterns = { "/altaPersona" })
public class AltaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPersona() {
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
		PersonaService as = new PersonaService();
		PrintWriter out = response.getWriter();
		try {
				String nombrePersona= serviciosJson.cargaParametro(request, "nombrePersona");	
				String apellidos = serviciosJson.cargaParametro(request, "apellidos");
				String telefono = serviciosJson.cargaParametro(request, "telefono");
				String email = serviciosJson.cargaParametro(request, "email");
				String DNI = serviciosJson.cargaParametro(request, "DNI");
				String accion = serviciosJson.cargaParametro(request, "accion");			
				Double id = serviciosJson.cargaParametroDouble(request, "idPersona");
				String calle= serviciosJson.cargaParametro(request, "calle");
				String numero= serviciosJson.cargaParametro(request, "numero");
				String codPostal= serviciosJson.cargaParametro(request, "codPostal");
				String poblacion= serviciosJson.cargaParametro(request, "poblacion");
				String provincia= serviciosJson.cargaParametro(request, "provincia");
				String pais= serviciosJson.cargaParametro(request, "pais");
				String cuentaBancaria= serviciosJson.cargaParametro(request, "cuentaBancaria");
				String telefono2= serviciosJson.cargaParametro(request, "telefono2");
				String email2= serviciosJson.cargaParametro(request, "email2");
				String observaciones= serviciosJson.cargaParametro(request, "observaciones");
				
				
				String ADOPTANTE = serviciosJson.cargaParametro(request,"ADOPTANTE");
				String VOLUNTARIO = serviciosJson.cargaParametro(request,"VOLUNTARIO");
				String SOCIO = serviciosJson.cargaParametro(request,"SOCIO");
				String COLABORADOR = serviciosJson.cargaParametro(request,"COLABORADOR");
				String TRABAJADOR = serviciosJson.cargaParametro(request,"TRABAJADOR");
				String VETERINARIO = serviciosJson.cargaParametro(request,"VETERINARIO");
				String PROPIETARIO = serviciosJson.cargaParametro(request,"PROPIETARIO");
				String ACOGEDOR = serviciosJson.cargaParametro(request,"ACOGEDOR");
				String OTROS = serviciosJson.cargaParametro(request,"OTROS");
				HashSet<String> relacionesALBA = new HashSet<>();
				if(ADOPTANTE != null){
					relacionesALBA.add(ADOPTANTE);
				}
				if(VOLUNTARIO != null){
					relacionesALBA.add(VOLUNTARIO);
				}
				if(SOCIO != null){
					relacionesALBA.add(SOCIO);
				}
				if(COLABORADOR != null){
					relacionesALBA.add(COLABORADOR);
				}
				if(TRABAJADOR != null){
					relacionesALBA.add(TRABAJADOR);
				}
				if(VETERINARIO != null){
					relacionesALBA.add(VETERINARIO);
				}
				if(PROPIETARIO != null){
					relacionesALBA.add(PROPIETARIO);
				}
				if(ACOGEDOR != null){
					relacionesALBA.add(ACOGEDOR);
				}
				if(VETERINARIO != null){
					relacionesALBA.add(VETERINARIO);
				}
				if(OTROS != null){
					relacionesALBA.add(OTROS);
				}
				
				Persona p = null;
				String mensaje="";
				if(accion.equalsIgnoreCase("alta")){
					p = as.alta(nombrePersona,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
					if((ADOPTANTE != null || ACOGEDOR !=null) && calle!=null){
						as.altaUbicacion(p.getId(), calle);
					}
					mensaje = "Alta realizada correctamente";
				}else{
					p = as.modificacion(id.longValue(), nombrePersona,apellidos,DNI,telefono,email,calle,numero,codPostal,poblacion,provincia,pais,cuentaBancaria,telefono2,email2,observaciones,relacionesALBA);
					mensaje = "Modificacion realizada correctamente";
				}
				HashMap<String, String> valores = new HashMap<>();
				valores.put("idPersona", String.valueOf(p.getId()));
			    	
			    out.println(serviciosJson.generaRetorno(true, mensaje,valores));	
			    
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}

}
