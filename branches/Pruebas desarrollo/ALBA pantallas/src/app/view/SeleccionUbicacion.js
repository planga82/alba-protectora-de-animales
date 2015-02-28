Ext.define('AM.view.SeleccionUbicacion', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.seleccionUbicacion',    											
	title: 'Selección Ubicación',
	autoScroll: false,
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,    	 
         items: [   
         	    {
                        xtype: 'textfield',
                        name : 'nombre',
                        fieldLabel: 'Institucion',
                        width: 300,
                        readOnly: true
                    },                 
	    	    {
	    		xtype: 'gridpanel',
	    		title: 'Ubicaciones',
	    		height: 200,
	    		width: 400,
	    		store: 'Ubicaciones',
	    		hideMode: 'visibility',
	    		dockedItems: [{
			        xtype: 'pagingtoolbar',
			        store: 'Ubicaciones',   // same store GridPanel is using
			        dock: 'bottom',
			        displayInfo: true
			    }],
	
	    		columns: [
			        {
			            text: 'Identficador',
			            width: 400,	            
			            dataIndex: 'id'
			        }
			    ]
	
	    	    },
                    {   
	                xtype: 'fieldcontainer',	                
	                combineErrors: true,
	                msgTarget : 'side',
	                layout: 'hbox',
	                margin: '25 0 10 0',
	                defaults: {
	                    flex: 1,
	                    hideLabel: true
	                },
	                items: [
	                	{
		                xtype: 'button',
		            	text : 'Alta Ubicación',
		            	margin: '0 10 0 0',
		            	cls: 'tipo4',
		            	action: 'altaUbicacion'
		        	},
	                	{
	                	xtype: 'button',
		                text: 'Selecciona Ubicación',
			        action: 'seleccion',
			        cls: 'tipo1',
			        margin: '0 10 0 0'                			        	
			        },
			        {
			        xtype: 'button',
			        text: 'Cancelar',
			        action: 'close',
			        scope: this
			        }		         	
	                ]	                                 
                    }
                    
                ]       	   

});