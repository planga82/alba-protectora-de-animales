Ext.define('AM.store.ComboTI', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"Persona", "valor":"P"},
	        {"descripcion":"Instituci�n", "valor":"I"},
		]
});