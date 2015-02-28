package com.controladores.instituciones;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entidades.instituciones.Institucion;
import com.base.entidades.instituciones.TipoInstitucion;
import com.servicios.instituciones.InstitucionService;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class AltaInstitucion
 */
@WebServlet(name = "altaInstitucion", urlPatterns = { "/altaInstitucion" })
public class AltaInstitucion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaInstitucion() {
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
		InstitucionService as = new InstitucionService();
		PrintWriter out = response.getWriter();
		try {
				String nombreInstitucion= serviciosJson.cargaParametro(request, "nombreInstitucion");	
				String NIF = serviciosJson.cargaParametro(request, "NIF");
				String direccion = serviciosJson.cargaParametro(request, "direccion");
				String tipo = serviciosJson.cargaParametro(request, "tipo");
				String cuentaCargo = serviciosJson.cargaParametro(request, "cuentaCargo");
				String personaContacto = serviciosJson.cargaParametro(request, "personaContacto");
				String telefonoContacto = serviciosJson.cargaParametro(request, "telefonoContacto");
				String emailContacto = serviciosJson.cargaParametro(request, "emailContacto");
				String paginaWeb = serviciosJson.cargaParametro(request, "paginaWeb");
				String nombreDepartamento1 = serviciosJson.cargaParametro(request, "nombreDepartamento1");
				String personaContactoDepartamento1 = serviciosJson.cargaParametro(request, "personaContactoDepartamento1");
				String emailDepartamento1 = serviciosJson.cargaParametro(request, "emailDepartamento1");
				String telefonoDepartamento1 = serviciosJson.cargaParametro(request, "telefonoDepartamento1");
				String nombreDepartamento2 = serviciosJson.cargaParametro(request, "nombreDepartamento2");
				String personaContactoDepartamento2 = serviciosJson.cargaParametro(request, "personaContactoDepartamento2");
				String emailDepartamento2 = serviciosJson.cargaParametro(request, "emailDepartamento2");
				String telefonoDepartamento2 = serviciosJson.cargaParametro(request, "telefonoDepartamento2");
				String nombreDepartamento3 = serviciosJson.cargaParametro(request, "nombreDepartamento3");
				String personaContactoDepartamento3 = serviciosJson.cargaParametro(request, "personaContactoDepartamento3");
				String emailDepartamento3 = serviciosJson.cargaParametro(request, "emailDepartamento3");
				String telefonoDepartamento3 = serviciosJson.cargaParametro(request, "telefonoDepartamento3");				
			
				String accion = serviciosJson.cargaParametro(request, "accion");
				if(accion.equalsIgnoreCase("alta")){
					as.alta(nombreInstitucion, NIF, direccion, personaContacto, telefonoContacto, emailContacto, tipo, paginaWeb, cuentaCargo, nombreDepartamento1, personaContactoDepartamento1, emailDepartamento1, telefonoDepartamento1, nombreDepartamento2, personaContactoDepartamento2, emailDepartamento2, telefonoDepartamento2, nombreDepartamento3, personaContactoDepartamento3, emailDepartamento3, telefonoDepartamento3);		  
				}else{
					Institucion i = as.modificacion(nombreInstitucion, NIF, direccion, personaContacto, telefonoContacto, emailContacto, paginaWeb, cuentaCargo, nombreDepartamento1, personaContactoDepartamento1, emailDepartamento1, telefonoDepartamento1, nombreDepartamento2, personaContactoDepartamento2, emailDepartamento2, telefonoDepartamento2, nombreDepartamento3, personaContactoDepartamento3, emailDepartamento3, telefonoDepartamento3);
					
					TipoInstitucion t = i.getTipo();
					if((t == null && tipo != null) || (t != null && !t.getNombreTipo().equalsIgnoreCase(tipo))){ 
						as.cambiarTipo(nombreInstitucion, tipo);
					}
				}
			    out.println(serviciosJson.generaRetorno(true, "Alta generada correctamente"));	
			    
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}

}
