Ext.define('AM.store.CriteriosBusquedaPersonas', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
			{"descripcion":"Nombre", "valor":"NO"},
	        {"descripcion":"Apellidos", "valor":"AP"},
	        {"descripcion":"Estado de baja", "valor":"EB"}
	        
		]
});