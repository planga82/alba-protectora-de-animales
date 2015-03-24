Ext.define('AM.view.AltaPesoAnimal', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.altaPesoAnimal',    											
		title: 'Modificar peso animal',
		autoScroll: false,
		url: "/AlbaControlador/ModificarPesoAnimal",
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
                        xtype: 'textfield',
                        name : 'pesoActual',
                        fieldLabel: 'Peso Actual(Kg)',
						regex: /^([0-9]+)(((\.)[0-9]+)?)$/,
						msgTarget: 'under',
						invalidText: 'Valor invalido, ejemplo; 12.5',
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
		                text: 'Cambiar Peso',
						action: 'modificar',
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