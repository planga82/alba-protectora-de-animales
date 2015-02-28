Ext.define('AM.store.EstadosAnimal', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"En ALBA bloqueado", "valor":"EN ALBA BLOQUEADO"},
	        {"descripcion":"En ALBA disponible", "valor":"En ALBA DISPONIBLE"},
	        {"descripcion":"Adoptado", "valor":"ADOPTADO"},
	        {"descripcion":"Baja", "valor":"BAJA"},
		]
});