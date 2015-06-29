package com.controladores.medicamentos;

import java.io.ByteArrayOutputStream;
/*import java.io.FileOutputStream;*/
import java.io.IOException;
import java.io.InputStream;
/*import java.io.OutputStream;*/
import java.io.PrintWriter;
/*import java.sql.Date;*/
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.base.entidades.medicamentos.Medicamento;
/*import com.constants.Constantes;*/
import com.servicios.json.serviciosJson;
import com.servicios.medicamentos.MedicamentoService;

/**
 * Servlet implementation class AltaMedicamento
 */
@WebServlet("/altaMedicamento")
public class AltaMedicamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaMedicamento() {
		super();
	}

	/*
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/*
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			String nombre = null;
			String finalidadMedicamento = null;
			String componentes = null;
			String prospecto = null;
			String tipoDeAlarma = null;
			String stockMinimo = null;
			String ubicacion = null;
			Double precio = null;
			String unidadesEnStock = null;
			String descripcionUnidades = null;
			Double dosisRecomendadaKg = null;

			ByteArrayOutputStream fichero = null;
			String extensionFichero = "";
			ServletFileUpload upload = new ServletFileUpload();

			FileItemIterator iter = upload.getItemIterator(request);
			while (iter.hasNext()) {
				FileItemStream item = iter.next();
				String name = item.getFieldName();
				InputStream stream = item.openStream();
				if (item.isFormField()) {

					if (name.equalsIgnoreCase("nombre")) {
						nombre = serviciosJson.cargaParametro(stream);
					}
					if (name.equalsIgnoreCase("finalidadMedicamento")) {
						finalidadMedicamento = serviciosJson
								.cargaParametro(stream);
					}
					if (name.equalsIgnoreCase("componentes")) {
						componentes = serviciosJson.cargaParametro(stream);
					}
					if (name.equalsIgnoreCase("prospecto")) {
						prospecto = serviciosJson.cargaParametro(stream);
					}
					if (name.equalsIgnoreCase("tipoDeAlarma")) {
						tipoDeAlarma = serviciosJson.cargaParametro(stream);
					}
					if (name.equalsIgnoreCase("stockMinimo")) {
						stockMinimo = serviciosJson.cargaParametro(stream);
					}
					if (name.equalsIgnoreCase("ubicacion")) {
						ubicacion = serviciosJson.cargaParametro(stream);
					}

					if (name.equalsIgnoreCase("unidadesEnStock")) {
						unidadesEnStock = serviciosJson.cargaParametro(stream);
					}
					if (name.equalsIgnoreCase("descripcionUnidades")) {
						descripcionUnidades = serviciosJson
								.cargaParametro(stream);
					}

					if (name.equalsIgnoreCase("precio")) {
						precio = serviciosJson.cargaParametroDouble(stream);
					}
					if (name.equalsIgnoreCase("dosisRecomendadaKg")) {
						dosisRecomendadaKg = serviciosJson
								.cargaParametroDouble(stream);
					}
				} else {

					fichero = new ByteArrayOutputStream();
					InputStream in = item.openStream();

					String[] AuxExt = item.getName().split("\\.");
					extensionFichero = AuxExt[AuxExt.length - 1];

					byte[] buffer = new byte[256];
					while (true) {
						int n = in.read(buffer);
						if (n < 0)
							break;
						fichero.write(buffer, 0, n);
					}
					in.close();
					fichero.close();
				}
			}

			MedicamentoService as = new MedicamentoService();

			Medicamento m = as.alta(nombre, finalidadMedicamento, componentes,
					prospecto, tipoDeAlarma, stockMinimo, ubicacion, precio,
					unidadesEnStock, descripcionUnidades, dosisRecomendadaKg,
					extensionFichero);

			HashMap<String, String> valores = new HashMap<>();
			valores.put("id", String.valueOf(m.getId()));
			out.println(serviciosJson.generaRetorno(true,
					"Alta generada correctamente " + m.getId(), valores));

		} catch (Exception e) {
			out.println(serviciosJson.generaRetorno(false, e.getMessage()));
			response.sendError(500, e.getMessage());
		}
	}
}