Ext.define('AM.store.ComboSN', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"Si", "valor":"true"},
	        {"descripcion":"No", "valor":"false"},
		]
});