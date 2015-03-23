Ext.define('AM.view.CambioEstadoPersona', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.cambioEstadoPersona',    											
	title: 'Cambio estado de persona',
	autoScroll: false,
	url: "/AlbaControlador/cambioEstadoPersona",
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,
    	 
         items: [ 
					{
						xtype: 'hiddenfield',
						name: 'idPersona'
					},
                    {
                        xtype: 'textfield',
                        name : 'nombrePersona',
                        fieldLabel: 'Nombre',
                        readOnly: true
                    },  
                    {	              
						name: 'estadoPersona',
						xtype: 'combo',
						fieldLabel: 'Estado',
						store: 'EstadosPersona',
						queryMode: 'local',
						displayField: 'descripcion',
						valueField: 'valor',
						value: 'BAJA',
						editable: false                    
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
		                text: 'Cambiar estado',
				        action: 'cambioEstado',
				        margin: '0 10 0 0',
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