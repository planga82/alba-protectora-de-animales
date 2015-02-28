package com.controladores.animales;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.base.entidades.animales.Animal;
import com.constants.Constantes;
import com.servicios.animales.AnimalService;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class AltaAnimal
 */
@WebServlet("/altaAnimal")
public class AltaAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaAnimal() {
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
		try {			
			String nombre=null;
			String chip=null;
			String segundoIdentificador=null;
			String raza=null;
			String sexo=null;
			String color=null;
			String tamano=null;
			String propietario=null;
			String descripcion=null;
			String lugarRecogida=null;
			String personaAvisa=null;
			String personaRecoge=null;
			String personaRecepciona=null;
			String nombreEspecie=null;
			String estado=null;
			Double pesoActual=null;
			Double alturaCruz=null;
			
			Boolean recogidoAyuntamiento=null;
			Boolean esterilizado=null;
 	
			Date fechaRegistro=null;
			Date fechaNacimiento=null;
			Date fechaAvisa=null;
			Date fechaRecogido=null;
			Date fechaRecepcion =null;
		
			ByteArrayOutputStream fichero= null;
			String extensionFichero = "";
			
			String tipoPatrocinador=null;
			String idPatrocinador=null;
			
			ServletFileUpload upload = new ServletFileUpload();
						
			FileItemIterator iter = upload.getItemIterator(request);
			while (iter.hasNext()) {
			    FileItemStream item = iter.next();
			    String name = item.getFieldName();
			    InputStream stream = item.openStream();
			    if (item.isFormField()) {
			    	
			    	if(name.equalsIgnoreCase("nombre")){
			    		nombre= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("chip")){
			    		chip= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("segundoIdentificador")){
			    		segundoIdentificador= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("raza")){
			    		raza= serviciosJson.cargaParametro(stream);
			    	}	    	
			    	if(name.equalsIgnoreCase("sexo")){
			    		sexo= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("color")){
			    		color= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("tamano")){
			    		tamano= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("propietario")){
			    		propietario= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("descripcion")){
			    		descripcion= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("lugarRecogida")){
			    		lugarRecogida= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("personaAvisa")){
			    		personaAvisa= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("personaRecoge")){
			    		personaRecoge= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("personaRecepciona")){
			    		personaRecepciona= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("nombreEspecie")){
			    		nombreEspecie= serviciosJson.cargaParametro(stream);
			    	}		    	
			    	if(name.equalsIgnoreCase("estado")){
			    		estado= serviciosJson.cargaParametro(stream);
			    	}
			    	
			    	if(name.equalsIgnoreCase("pesoActual")){
			    		pesoActual = serviciosJson.cargaParametroDouble(stream);
			    	}
			    	if(name.equalsIgnoreCase("alturaCruz")){
			    		alturaCruz = serviciosJson.cargaParametroDouble(stream); 
			    	}
					
					if(name.equalsIgnoreCase("recogidoAyuntamiento")){
						recogidoAyuntamiento = serviciosJson.cargaParametroBoolean(stream);
					}
					if(name.equalsIgnoreCase("esterilizado")){
						esterilizado = serviciosJson.cargaParametroBoolean(stream);
					}
		 	
					if(name.equalsIgnoreCase("fechaRegistro")){
						fechaRegistro = serviciosJson.cargaParametroFecha(stream);
					}
					if(name.equalsIgnoreCase("fechaNacimiento")){
						fechaNacimiento = serviciosJson.cargaParametroFecha(stream);
					}
					if(name.equalsIgnoreCase("fechaAvisa")){
						fechaAvisa = serviciosJson.cargaParametroFecha(stream);
					}
					if(name.equalsIgnoreCase("fechaRecogido")){
						fechaRecogido = serviciosJson.cargaParametroFecha(stream);
					}
					if(name.equalsIgnoreCase("fechaRecepcion")){
						fechaRecepcion = serviciosJson.cargaParametroFecha(stream);
					}
					if(name.equalsIgnoreCase("tipoPatrocinador")){
						tipoPatrocinador = serviciosJson.cargaParametro(stream);
					}
					if(name.equalsIgnoreCase("idPatrocinador")){
						idPatrocinador = serviciosJson.cargaParametro(stream);
					}
					
			    } else {
			       			    	
			    	fichero = new ByteArrayOutputStream();
			        InputStream in = item.openStream();	
			        
			        String[] AuxExt = item.getName().split("\\.");
			        extensionFichero = AuxExt[AuxExt.length-1];
			        
			        byte[] buffer= new byte[256];
			        while (true) {
			          int n= in.read(buffer);
			          if (n < 0)
			            break;
			          fichero.write(buffer, 0, n);
			        }
			        in.close();
			        fichero.close();
			    }
			}
		
			AnimalService as = new AnimalService();
			
			String rutaFoto=null;
				
			Animal a = as.alta(chip, segundoIdentificador, nombre, nombreEspecie, raza, fechaNacimiento, sexo, esterilizado, color, tamano, propietario, fechaRegistro, descripcion, rutaFoto, pesoActual, lugarRecogida, recogidoAyuntamiento, personaAvisa,fechaAvisa, personaRecoge, fechaRecogido, personaRecepciona, fechaRecepcion, estado, alturaCruz,extensionFichero);			
			
			if(tipoPatrocinador != null && idPatrocinador != null){
				if(tipoPatrocinador.equalsIgnoreCase("Persona")){
					as.asignarPatrocinadorPersona(a.getId(), Long.parseLong(idPatrocinador));
				}else{
					as.asignarPatrocinadorInstitucion(a.getId(), idPatrocinador);
				}				
			}
			
			if(extensionFichero!=null && !extensionFichero.equals("")){
				OutputStream outputStream = new FileOutputStream (Constantes.rutaTrabajoImagenesAnimales + new Long(a.getId()).intValue() + "." +  extensionFichero);	
				OutputStream outputStream1 = new FileOutputStream (Constantes.backupImagenesAnimales + new Long(a.getId()).intValue() + "." +  extensionFichero);
				fichero.writeTo(outputStream);	
				outputStream.close();
				fichero.writeTo(outputStream1);	
				outputStream1.close();
				fichero.close();
			}
			HashMap<String, String> valores = new HashMap<>();
			valores.put("id", String.valueOf(a.getId()));
			out.println(serviciosJson.generaRetorno(true, "Alta generada correctamente " + a.getId(), valores));	
			    
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}
	
	

}
