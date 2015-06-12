package com.constants;

public class MensajesError {
	
	
	//Personas
	public static String codPersonaYaDadaDeBaja 			= "MSGERR001-Persona dada de baja";
	public static String codPersonaNoExiste		 			= "MSGERR002-Persona no existe";
	
	
	
	//Animales
	public static String codChipYaExistenteistema 			= "MSGERR101-Chip ya dado de alta en el sistema";
	public static String codSegundaIdYaExistenteistema 		= "MSGERR102-Segunda identificación ya dada de alta en el sistema";
	public static String codNombreEspecieNoExiste		 	= "MSGERR103-Especie no existe";
	public static String codPesoNegativo				 	= "MSGERR104-El peso no puede tener un valor negativa";
	public static String codAnimalNoExiste				 	= "MSGERR105-Animal no existe";
	public static String codCambioUbicacionAUbBaja		 	= "MSGERR106-Ubicacion destino en estado de baja";
	
	
	//Instituciones
	public static String codTipoInstitucionNoExiste			= "MSGERR201-Tipo de institución no existe";
	public static String codNombreInstitucionNoExiste		= "MSGERR202-Nombre Institución no existe";
	public static String codModificandoInstitucionEstBaja	= "MSGERR203-Institución dada de baja";
	public static String codInstitucionYaDadaDeBaja 		= "MSGERR204-Institución dada de baja";
	public static String codBajaUbicacionConAnimales 		= "MSGERR205-No se puede dar de baja una ubicación con animales";
	public static String codNombreInstitucionNulo	 		= "MSGERR206-Nombre institucion no puede ser vacio";
	public static String codNombreUbicacionNulo	 			= "MSGERR207-Nombre ubicación vacio";
	public static String codUbicacionYaExste	 			= "MSGERR208-Ubicación ya existe";
	public static String codUbicacionNoExste	 			= "MSGERR209-Ubicación no existe";
	public static String codUbicacionYaDadaDeBaja 			= "MSGERR210-Ubicación ya dada de baja";
	public static String codNombreInstitucionYaExiste		= "MSGERR211-Nombre institución ya existe";

	//Proveedores
	public static String codProveedorVacioNoPermitido		= "MSGERR301-El nombre del proveedor debe ser informado";
	public static String codProveedorDuplicado				= "MSGERR302-El proveedor ya esta dado de alta";
	
}
