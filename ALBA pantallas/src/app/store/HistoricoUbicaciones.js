Ext.define('AM.store.HistoricoUbicaciones', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.HistoricoUbicacion',
	
	proxy: {
            	type: 'ajax',
            	url : 'http://localhost:8080/AlbaControlador/historicoUbicaciones',
            	reader: {
				type: 'json',
				root: 'historicoUbicaciones'
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