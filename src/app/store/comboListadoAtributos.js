Ext.define('AM.store.comboListadoAtributos', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.Atributos',
    	proxy: {
            type: 'ajax',
            url : 'http://localhost:8080/AlbaControlador/listadoAtributos',
            reader: {
				type: 'json',
				root: 'listadoAtributos'
			}			
        },
        autoLoad: false,
});