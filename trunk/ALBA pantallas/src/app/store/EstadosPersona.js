Ext.define('AM.store.EstadosPersona', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"Alta", "valor":"ALTA"},
	        {"descripcion":"Baja", "valor":"BAJA"}
		]
});