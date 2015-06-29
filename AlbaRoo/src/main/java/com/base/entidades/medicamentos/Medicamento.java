package com.base.entidades.medicamentos;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.base.interfaces.JsonObject;
import com.base.interfaces.ResultadoBusquedaGeneral;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Medicamento implements JsonObject, ResultadoBusquedaGeneral{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String nombre;
	private String finalidadMedicamento;
	private String componentes;
	private String prospecto;
	private String tipoDeAlarma;
	private String stockMinimo;
	private String ubicacion;
	private Double precio;
	private String unidadesEnStock;
	private String descripcionUnidades;
	private Double dosisRecomendadaKg;
	@Override
	public String getNombreListado() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
	public static Object findNombre(String nombre2) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

}
