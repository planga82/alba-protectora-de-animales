Ext.define('AM.view.CambioEstado', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.cambioEstado',    											
		title: 'Cambio animal',
		autoScroll: false,
		url: "http://localhost:8080/AlbaControlador/cambioEstadoAnimal",
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,
    	 
         items: [   
					{
						xtype: 'hiddenfield',
						name: 'id'
					},{
                        xtype: 'textfield',
                        name : 'nombre',
                        fieldLabel: 'Nombre',
                        readOnly: true
                    },                 
                    {
                        name: 'estado',
                	    xtype: 'combo',
                	    fieldLabel: 'Estado',
                		store: 'EstadosAnimal',
                		queryMode: 'local',
                		displayField: 'descripcion',
                		valueField: 'valor',
                		editable: false,
                		cls: 'mostrar'
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
						action: 'cambiarEstado',
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