Ext.define('AM.store.HistoricoPesos', {
    extend: 'Ext.data.Store',
    	model: 'AM.model.HistoricoPeso',
	
		proxy: {
            	type: 'ajax',
            	url : '/AlbaControlador/historicoPesos',
            	reader: {
				type: 'json',
				root: 'historicoPesos'
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
	
	
	/*data : [
	        {"peso":"12.5", "fecha":"01/01/2013"},
	        {"peso":"13.0", "fecha":"02/01/2013"},
	        {"peso":"13.1", "fecha":"03/01/2013"},
		{"peso":"12.5", "fecha":"01/01/2013"},
	        {"peso":"13.0", "fecha":"02/01/2013"},
	        {"peso":"13.1", "fecha":"03/01/2013"},
		{"peso":"12.5", "fecha":"01/01/2013"},
	        {"peso":"13.0", "fecha":"02/01/2013"},
	        {"peso":"13.1", "fecha":"03/01/2013"}
	]*/
});