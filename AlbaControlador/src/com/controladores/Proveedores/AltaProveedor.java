package com.controladores.Proveedores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entidades.proveedores.Proveedor;
import com.servicios.json.serviciosJson;
import com.servicios.proveedores.ProveedorService;
import com.servicios.proveedores.contenedores.ContenedorAltaProveedor;

/**
 * Servlet implementation class AltaProveedor
 */
@WebServlet(name = "altaProveedor", urlPatterns = { "/altaProveedor" })
public class AltaProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaProveedor() {
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
		ProveedorService ps = new ProveedorService();
		try{
			ContenedorAltaProveedor cont = new ContenedorAltaProveedor();
			cont.setNombre(			serviciosJson.cargaParametro(request, "nombreProveedor"				));       
			cont.setCif(			serviciosJson.cargaParametro(request, "cifProveedor"					));          
			cont.setDomicilio(		serviciosJson.cargaParametro(request, "DomicilioProveedor"			));   
			cont.setLocalidad(		serviciosJson.cargaParametro(request, "LocalidadProveedor"			));     
			cont.setProvincia(		serviciosJson.cargaParametro(request, "ProvinciaProveedor"			));     
			cont.setCodigoPostal(	serviciosJson.cargaParametro(request, "CodigoPostalProveedor"			));  
			cont.setPais(			serviciosJson.cargaParametro(request, "PaisProveedor"					));          
			cont.setFax(			serviciosJson.cargaParametro(request, "faxProveedor"					));           
			cont.setTelefono(		serviciosJson.cargaParametro(request, "TelefonoProveedor"				));      
			cont.setEmail(			serviciosJson.cargaParametro(request, "emailProveedor"				));         
			cont.setNombreContacto(	serviciosJson.cargaParametro(request, "nombrePersonaContactoProveedor"));
			cont.setDniContacto(	serviciosJson.cargaParametro(request, "dniPersonaContactoProveedor"	));   
			cont.setCargoContacto(	serviciosJson.cargaParametro(request, "cargoPersonaContactoProveedor"	)); 
			cont.setNumeroCuenta(	serviciosJson.cargaParametro(request, "numCuentaProveedor"));
			
			Proveedor p = ps.alta(cont);
			String mensaje = "Alta realizada correctamente";
			HashMap<String, String> valores = new HashMap<>();
			valores.put("nombreProveedor",p.getNombre());
			 out.println(serviciosJson.generaRetorno(true, mensaje,valores));
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}

}
