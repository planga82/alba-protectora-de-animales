/**
 * Model. Medicamento
 */
Ext.define('AM.model.Medicamento', {
	extend : 'Ext.data.Model',
	fields : [ 'nombre', 
	           'id',
	           'finalidadMedicamento', 
	           'componentes', 
	           'prospecto',
	           'tipoDeAlarma', 
	           'stockMinimo', 
	           'ubicacion', 
	           'precio',
	           'unidadesEnStock', 
	           'descripcionUnidades', 
	           'dosisRecomendadaKg' ]
});