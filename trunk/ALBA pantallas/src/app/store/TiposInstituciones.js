Ext.define('AM.store.TiposInstituciones', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.TipoInstitucion',
	proxy: {
            type: 'ajax',
            url : 'http://localhost:8080/AlbaControlador/listadoTipoInstituciones',
            reader: {
				type: 'json',
				root: 'tipoInstituciones'
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
	
	/*data : [
	        {"nombreTipo":"Ayuntamiento"},
	        {"nombreTipo":"Clinica Veterinaria"},
	        {"nombreTipo":"Casa particular"}
	]*/
});