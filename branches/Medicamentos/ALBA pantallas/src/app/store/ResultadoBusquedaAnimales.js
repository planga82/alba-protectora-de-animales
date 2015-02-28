Ext.define('AM.store.ResultadoBusquedaAnimales', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.ResultadoBusquedaAnimales',
		proxy: {
            type: 'ajax',
            url : 'http://localhost:8080/AlbaControlador/busquedaAnimal',
            reader: {
				type: 'json',
				root: 'animales'
			}
        },
        autoLoad: false,
		listeners: {
			'load' : function(a, records, successful, operation, eOpts) {
				console.log(records);
				console.log(successful);
				console.log(operation);				
			}
		}
});