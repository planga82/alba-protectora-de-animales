/**
 * Store . Combo DU
 */
Ext.define('AM.store.ComboDU', {
	extend : 'Ext.data.Store',
	model : 'AM.model.Combo',
	data : [ {
		"descripcion" : "Comprimidos",
		"valor" : "C"
	}, {
		"descripcion" : "Cajas",
		"valor" : "CJ"
	}, ]
});
/*se me acaba la imaginación, habrá que poner otras, supongo*/