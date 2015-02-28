Ext.define('AM.store.ComboNumResultados', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"10 resultados", "valor":"10"},
	        {"descripcion":"30 resultados", "valor":"30"},
	        {"descripcion":"50 resultados", "valor":"50"}
		]
});