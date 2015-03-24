Ext.define('AM.store.Animales', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Animal',
	/*	proxy: {
            type: 'ajax',
            url : '/AlbaControlador/busquedaAnimal',
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
		}*/
	data: 	[
	        {"id":"1", "nombre":"Perrito"}
		]

});