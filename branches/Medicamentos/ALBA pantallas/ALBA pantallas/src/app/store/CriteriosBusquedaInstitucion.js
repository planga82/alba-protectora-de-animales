Ext.define('AM.store.CriteriosBusquedaInstitucion', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
			{"descripcion":"Nombre", "valor":"NO"},
	        {"descripcion":"NIF", "valor":"NI"},
	        {"descripcion":"Persona Contacto", "valor":"PC"},
	        {"descripcion":"Tipo", "valor":"TI"},
	        {"descripcion":"Estado de baja", "valor":"EB"}
	        
		]
});