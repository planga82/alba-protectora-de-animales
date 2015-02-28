Ext.define('AM.store.ResultadoListados', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.ResultadoBusquedaGeneral',
		proxy: {
            type: 'ajax',
            url : 'http://localhost:8080/AlbaControlador/listado',
            reader: {
				type: 'json',
				root: 'BusquedaGeneral'
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