package com.servicios.animales.objetos;

import java.sql.Date;

public class FiltroAtributosDate extends FiltroAtributos{

	Date fecha_desde;
	Date fecha_hasta;
	
	public Date getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public Date getFecha_hasta() {
		return fecha_hasta;
	}
	public void setFecha_hasta(Date fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	
	
}
