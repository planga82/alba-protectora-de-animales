package com.base.entidades.proveedores;

import javax.persistence.Id;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;


@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Proveedor {
	
	@Id
    private String nombre;
	
	private String cif;
	
	private String domicilio;
	
	private String localidad;
	
	private String provincia;
	
	private String codigoPostal;
	
	private String pais;
	
	private String fax;
	
	private String telefono;
	
	private String email;
	
	private String nombreContacto;
	
	private String dniContacto;
	
	private String cargoContacto;
	
	private String numeroCuenta;
}
