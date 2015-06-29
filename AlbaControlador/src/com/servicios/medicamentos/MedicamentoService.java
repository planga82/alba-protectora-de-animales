package com.servicios.medicamentos;

import org.apache.log4j.Logger;

import com.base.entidades.medicamentos.Medicamento;

public class MedicamentoService {

	static Logger logger = Logger.getLogger(MedicamentoService.class);

	public Medicamento alta(String nombre, String finalidadMedicamento,
			String componentes, String prospecto, String tipoDeAlarma,
			String ubicacion, String stockMinimo, Double precio,
			String unidadesEnStock, String descripcionUnidades,
			Double dosisRecomendadaKg, String extensionFichero)
			throws Exception {
		try {
			/*if ( Medicamento.findNombre(nombre).size() > 0) {
				throw new Exception(MensajesError.codNombreYaExistenteistema);
			}*/

			Medicamento m = new Medicamento();
			m.setNombre(nombre);
			m.setFinalidadMedicamento(finalidadMedicamento);
			m.setComponentes(componentes);
			m.setProspecto(prospecto);
			m.setTipoDeAlarma(tipoDeAlarma);
			m.setStockMinimo(stockMinimo);
			m.setUbicacion(ubicacion);
			m.setPrecio(precio);
			m.setUnidadesEnStock(unidadesEnStock);
			m.setDescripcionUnidades(descripcionUnidades);
			m.setDosisRecomendadaKg(dosisRecomendadaKg);

			return m;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
}