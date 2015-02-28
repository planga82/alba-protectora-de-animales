Ext.define('AM.view.AltaUbicacion', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.altaUbicacion',    											
	title: 'Alta de Ubicación',
	autoScroll: false,
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,
    	 
         items: [   
         	    {
         	    	fieldLabel: 'Institución',
	              	xtype: 'textfield',
                       	name : 'nombre',   
                       	width: 400,
			readOnly: true                    
		    },{
                        xtype: 'textfield',
                        name : 'id',
                        fieldLabel: 'Identificador',
                        cls: 'disable',
                        width: 400,
                    },
	    	    {
	    		xtype: 'gridpanel',
	    		title: 'Animales',
	    		height: 300,
	    		width: 450,
	    		store: 'Animales',
	    		cls: 'detalle',
	    		dockedItems: [{
			        xtype: 'pagingtoolbar',
			        store: 'Animales',   // same store GridPanel is using
			        dock: 'bottom',
			        displayInfo: true
			    }],
	
	    		columns: [
			        {
			            text: 'Nombre',
			            width: 150,		            
			            dataIndex: 'nombre'
			        },
			        {
			            text: 'Chip',
			            width: 150,
			            dataIndex: 'chip'		           
			        },
			        {
			            text: 'Especie',
			            width: 150,
			            dataIndex: 'especie'
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
		                text: 'Guardar',
			        action: 'save',
			        cls: 'hide',
			        margin: '0 10 0 0',
			        cls: 'alta',
			        formBind: true                			        	
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