Ext.define('AM.store.Instituciones', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Institucion',
	data : [
	        {"nombreInstitucion":"Algete", "NIF":"588963254", "direccion":"Plaza del ayuntamiento nº5 26890 Algete Madrid", "personaContacto":"Oscar Gomez", "telefonoContacto":"689214589", "tipo":"Ayuntamiento", "estado":"Alta", "motivoBaja":"", "fechaBaja":""},
	        {"nombreInstitucion":"San Sebastian de los Reyes", "NIF":"588456254", "direccion":"Plaza del armen nº12 26990", "personaContacto":"Oscar Martinez", "telefonoContacto":"689214589", "tipo":"Ayuntamiento", "estado":"Alta", "motivoBaja":"", "fechaBaja":""},
	        {"nombreInstitucion":"ALBA", "NIF":"588456254", "direccion":"Plaza del armen nº12 26990", "personaContacto":"Oscar Martinez", "telefonoContacto":"689214589", "tipo":"Ayuntamiento", "estado":"Alta", "motivoBaja":"", "fechaBaja":""}
	]
});