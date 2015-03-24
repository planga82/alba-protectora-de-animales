Ext.define('AM.store.ComboANDOR', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"AND", "valor":"AND"},
	        {"descripcion":"OR", "valor":"OR"},
		]
});