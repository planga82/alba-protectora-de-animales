Ext.define('AM.store.ComboOpcionesListado', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"Animales", "valor":"ANIMAL"},
	        {"descripcion":"Personas", "valor":"PERSONA"},
	        {"descripcion":"Instituciones", "valor":"INSTITUCION"}
		]
});