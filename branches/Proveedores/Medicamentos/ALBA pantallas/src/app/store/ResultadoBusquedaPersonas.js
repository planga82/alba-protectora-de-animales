Ext.define('AM.store.ResultadoBusquedaPersonas', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.ResultadoBusquedaPersonas',
		proxy: {
            type: 'ajax',
            url : 'http://localhost:8080/AlbaControlador/busquedaPersonas',
            reader: {
				type: 'json',
				root: 'resultadoBusquedaPersonas'
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
	/*data: 	[
	        {"id":"1", "nombreApellidos":"Perrito", "descripcionResultado":"Persona que recoje: Juan Perez Gomez","nombrePersona":"Juan","apellidos":"Perez","DNI":"6998547P","direccion":"Calle Sinesio Delgado, 10 Madrid","telefono":"9895478596","email":"soyjuanito@hotmail.com", "estado":"Alta", "motivoBaja":"", "fechaBaja":""},
	        {"id":"2", "nombreApellidos":"Perrito2", "descripcionResultado":"Persona que recoje: Juan Perez Gomez","nombrePersona":"Juan","apellidos":"Perez","DNI":"6998547P","direccion":"Calle Sinesio Delgado, 10 Madrid","telefono":"9895478596","email":"soyjuanito@hotmail.com", "estado":"Alta", "motivoBaja":"", "fechaBaja":""},
	        {"id":"3", "nombreApellidos":"Perrito3", "descripcionResultado":"Persona que recoje: Juan Perez Gomez","nombrePersona":"Juan","apellidos":"Perez","DNI":"6998547P","direccion":"Calle Sinesio Delgado, 10 Madrid","telefono":"9895478596","email":"soyjuanito@hotmail.com", "estado":"Alta", "motivoBaja":"", "fechaBaja":""}
		]*/

});