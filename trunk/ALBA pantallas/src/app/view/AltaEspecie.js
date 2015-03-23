Ext.define('AM.view.AltaEspecie', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.altaEspecie',    											
    	title: 'Alta de especie',
    	autoScroll: false,
    	url: "/AlbaControlador/altaEspecie",
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
                        fieldLabel: 'Nueva especie',
						allowBlank: false
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