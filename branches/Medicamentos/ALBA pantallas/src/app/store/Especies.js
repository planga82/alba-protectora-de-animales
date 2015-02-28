Ext.define('AM.store.Especies', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Especie',
    	proxy: {
            type: 'ajax',
            url : 'http://localhost:8080/AlbaControlador/listadoEspecies',
            reader: {
				type: 'json',
				root: 'especies'
			}			
        },
        autoLoad: true,
		listeners: {
			'load' : function(a, records, successful, operation, eOpts) {
				console.log(records);
				console.log(successful);
				console.log(operation);				
			}
		}
});