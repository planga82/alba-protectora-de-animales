/**
 * Combo TA. Tipo de alarma. En la BBDD se guarda A/M
 */
Ext.define('AM.store.ComboTA', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Combo',
    	data : 	[
	        {"descripcion":"Automatica", "valor":"A"},
	        {"descripcion":"Manual", "valor":"M"},
		]
});