package com.base.utilidades;

import java.lang.reflect.Field;


public class Utilidades {

	 public static String clausulaWhere(Field[] atributos){
	    	
		 String where = "";	    	
		 int contador = 0;
	    	for (int i = 0; i<atributos.length; i++) {
	    		String nombre = atributos[i].getName();
	    		String tipo = atributos[i].getType().getName();
	    		if(tipo.equalsIgnoreCase("java.lang.String")){
	    			if(contador != 0){
	    				where += " OR ";
	    				contador++;
	    			}
	    			where += "(a." + nombre + " LIKE :texto)";
	    			contador++;
	    		}
			}
	    	return where;
	    }
}
