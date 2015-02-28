Ext.define('AM.store.Personas', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Persona',
	data : [
	        {"id":"1","nombrePersona":"Juan","apellidos":"Perez","DNI":"6998547P","direccion":"Calle Sinesio Delgado, 10 Madrid","telefono":"9895478596","email":"soyjuanito@hotmail.com", "estado":"Alta", "motivoBaja":"", "fechaBaja":""},
			{"id":"2","nombrePersona":"Juan1","apellidos":"Perez1","DNI":"6998547P","direccion":"Calle Sinesio Delgado, 10 Madrid","telefono":"9895478596","email":"soyjuanito@hotmail.com", "estado":"Alta", "motivoBaja":"", "fechaBaja":""},
			{"id":"3","nombrePersona":"Juan2","apellidos":"Perez2","DNI":"6998547P","direccion":"Calle Sinesio Delgado, 10 Madrid","telefono":"9895478596","email":"soyjuanito@hotmail.com", "estado":"Alta", "motivoBaja":"", "fechaBaja":""}
	   ]
});