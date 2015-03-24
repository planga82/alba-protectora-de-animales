Ext.define('AM.view.HistoricoUbicaciones', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.historicoUbicaciones',    											
	title: 'Histórico ubicaciones',
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
	    		width: 450,
	    		store: 'HistoricoUbicaciones',
	    		dockedItems: [{
			        xtype: 'pagingtoolbar',
			        store: 'HistoricoUbicaciones',   // same store GridPanel is using
			        dock: 'bottom',
			        displayInfo: true
			    }],
	
	    		columns: [
			        {
			            text: 'Ubicacion',
			            width: 150,		            
			            dataIndex: 'id'
			        },
			        {
			            text: 'Fecha entrada',
			            width: 150,
			            dataIndex: 'fechaEntrada'		           
			        },
			        {
			            text: 'Fecha salida',
			            width: 150,
			            dataIndex: 'fechaSalida'		           
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