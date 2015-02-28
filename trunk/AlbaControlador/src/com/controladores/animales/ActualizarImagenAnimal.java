package com.controladores.animales;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.constants.Constantes;
import com.servicios.animales.AnimalService;
import com.servicios.json.serviciosJson;

/**
 * Servlet implementation class ActualizarImagenAnimal
 */
@WebServlet(name = "actualizarImagenAnimal", urlPatterns = { "/actualizarImagenAnimal" })
public class ActualizarImagenAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarImagenAnimal() {
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
			Double id=null;
			
			ByteArrayOutputStream fichero= null;
			String extensionFichero = "";
			ServletFileUpload upload = new ServletFileUpload();
						
			FileItemIterator iter = upload.getItemIterator(request);
			while (iter.hasNext()) {
			    FileItemStream item = iter.next();
			    String name = item.getFieldName();
			    InputStream stream = item.openStream();
			    if (item.isFormField()) {
			    	
			    	if(name.equalsIgnoreCase("id")){
			    		id= serviciosJson.cargaParametroDouble(stream);
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
			
			
			if(extensionFichero!=null && !extensionFichero.equals("")){
				as.modificacionExtensionImagen(id.longValue(), extensionFichero);
				String ruta1 = Constantes.rutaTrabajoImagenesAnimales + id.intValue() + "." +  extensionFichero;
				String ruta2 = Constantes.backupImagenesAnimales + id.intValue() + "." +  extensionFichero;
				new File(ruta1).delete();
				new File(ruta2).delete();
				OutputStream outputStream = new FileOutputStream (ruta1);	
				OutputStream outputStream1 = new FileOutputStream (ruta2);
				fichero.writeTo(outputStream);	
				outputStream.close();
				fichero.writeTo(outputStream1);	
				outputStream1.close();
				fichero.close();
			}
			HashMap<String, String> valores = new HashMap<>();
			valores.put("id", String.valueOf(id));
			out.println(serviciosJson.generaRetorno(true, "Modificacion correcta ", valores));	
			    
		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}

}
