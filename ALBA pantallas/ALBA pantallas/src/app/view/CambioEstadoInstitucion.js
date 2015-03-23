Ext.define('AM.view.CambioEstadoInstitucion', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.cambioEstadoInstitucion',    											
	title: 'Baja de Institución',
	autoScroll: false,
	url: "/AlbaControlador/cambioEstadoInstitucion",
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,
    	 
         items: [                    
                    {
                        xtype: 'textfield',
                        name : 'nombreInstitucion',
                        fieldLabel: 'Nombre',
                        readOnly: true
                    },  
                    {	              
						name: 'estadoInstitucion',
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
		                text: 'Cambiar Estado',
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