Ext.define('AM.store.Ubicaciones', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Ubicacion',
		proxy: {
            type: 'ajax',
            url : 'http://localhost:8080/AlbaControlador/listadoUbicaciones',
            reader: {
				type: 'json',
				root: 'ubicaciones'
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