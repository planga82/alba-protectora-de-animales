Ext.define('AM.store.ComboTM', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"Grande", "valor":"G"},
	        {"descripcion":"Mediano", "valor":"M"},
	        {"descripcion":"Peque�o", "valor":"P"}
		]
});