package com.controladores.listados;

import com.base.interfaces.JsonObject;

public class Atributo implements JsonObject{

	String nombre;
	String tipo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "listadoAtributos";
	}
	
	
}
