/**
 * Store. Medicamentos
 */
Ext.define('AM.store.Medicamentos', {
	extend : 'Ext.data.Store',
	model : 'AM.model.Medicamento',
	proxy : {
		type : 'ajax',
		url : 'http://localhost:8080/AlbaControlador/busquedaMedicamento',
		reader : {
			type : 'json',
			root : 'medicamentos'
		}
	},
	autoLoad : false,
	listeners : {
		'load' : function(a, records, successful, operation, eOpts) {
			console.log(records);
			console.log(successful);
			console.log(operation);
		}
	}
});