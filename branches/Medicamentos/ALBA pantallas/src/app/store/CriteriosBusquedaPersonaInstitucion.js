Ext.define('AM.store.CriteriosBusquedaPersonaInstitucion', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"Persona", "valor":"P"},
	        {"descripcion":"Institucion", "valor":"I"},
		]
});