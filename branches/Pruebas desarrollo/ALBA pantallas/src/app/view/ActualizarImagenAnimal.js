Ext.define('AM.view.ActualizarImagenAnimal', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.actualizarImagenAnimal',    											
		title: 'Actualizar Imagen',
		autoScroll: false,
		url: "http://localhost:8080/AlbaControlador/actualizarImagenAnimal",
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
					},
					{
                        xtype: 'filefield',
                        width: 296,
                        fieldLabel: 'Imagen',
                        emptyText: 'Selecciona imagen...',
                        name: 'imagen',
                        labelWidth: 70
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
		                text: 'Actualizar imagen',
						action: 'actualizarImagen',
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