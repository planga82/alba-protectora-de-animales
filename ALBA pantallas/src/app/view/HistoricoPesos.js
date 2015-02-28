Ext.define('AM.view.HistoricoPesos', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.historicoPesos',    											
	title: 'Histórico pesos',
	autoScroll: false,
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,
    	 
         items: [                       
                    {
	    		xtype: 'gridpanel',
	    		height: 300,
	    		width: 300,
	    		store: 'HistoricoPesos',
	    		dockedItems: [{
			        xtype: 'pagingtoolbar',
			        store: 'HistoricoPesos',   // same store GridPanel is using
			        dock: 'bottom',
			        displayInfo: true
			    }],
	
	    		columns: [
			        {
			            text: 'Fecha',
			            width: 150,		            
			            dataIndex: 'fecha'
			        },
			        {
			            text: 'Peso',
			            width: 150,
			            dataIndex: 'peso'		           
			        },
			        
			    ]
	
	    	    },
                    {
			xtype: 'button',
			text: 'Salir',
			action: 'close',
			margin: '5 5 5 5',
			scope: this
		    }
                    
                ]       	   

});