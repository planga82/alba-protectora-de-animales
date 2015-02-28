Ext.define('AM.store.ComboHM', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"Hembra", "valor":"H"},
	        {"descripcion":"Macho", "valor":"M"},
		]
});