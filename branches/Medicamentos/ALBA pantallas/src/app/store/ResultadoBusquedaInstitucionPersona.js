Ext.define('AM.store.ResultadoBusquedaInstitucionPersona', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.ResultadoBusquedaGeneral',
		proxy: {
            type: 'ajax',
            url : '/AlbaControlador/busquedaInstitucionesPersona',
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