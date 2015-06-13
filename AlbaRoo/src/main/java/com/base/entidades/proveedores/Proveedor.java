package com.base.entidades.proveedores;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.base.interfaces.JsonObject;
import com.base.interfaces.ResultadoBusquedaGeneral;
import com.base.utilidades.Utilidades;


@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Proveedor implements JsonObject, ResultadoBusquedaGeneral{
	
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
	
	public static List<Proveedor> findTextoSinFiltro(String texto, int maxResult){
    	TypedQuery<Proveedor> q = entityManager().createQuery("SELECT a FROM Proveedor a WHERE " + Utilidades.clausulaWhere(Proveedor.class.getDeclaredFields()), Proveedor.class);
    	q.setParameter("texto", "%" + texto + "%");
    	q.setMaxResults(maxResult);
    	return q.getResultList();
    }

	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "proveedores";
	}
}
