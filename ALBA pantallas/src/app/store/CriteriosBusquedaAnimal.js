Ext.define('AM.store.CriteriosBusquedaAnimal', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[	    
    	    {"descripcion":"Texto Busqueda", "valor":"TB"},
	        {"descripcion":"Esterilizado", "valor":"ES"},
	        {"descripcion":"Recogido Ayuntamiento", "valor":"RA"},
	        //{"descripcion":"Especie", "valor":"EP"},
	        
		]
});