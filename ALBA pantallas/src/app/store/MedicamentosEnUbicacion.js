/**
 * Store. MedicamentosEnUbicacion
 */
Ext.define('AM.store.MedicamentosEnUbicacion', {
	extend : 'Ext.data.Store',
	model : 'AM.model.Medicamento',
	proxy : {
		type : 'ajax',
		url : 'http://localhost:8080/AlbaControlador/medicamentosEnUbicacion',
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