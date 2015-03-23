Ext.define('AM.view.BajaUbicacion', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.bajaUbicacion',    											
	title: 'Baja de Ubicacion',
	autoScroll: false,
	url: "/AlbaControlador/bajaUbicacion",
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,
    	 
         items: [  
         		{
			xtype: 'hiddenfield',
			name: 'idInterno'
			},
         	    {
         	    	fieldLabel: 'Institución',
	              	xtype: 'textfield',
                       	name : 'institucion',   
                       	width: 400,
			readOnly: true                    
		    },
		    {
                        xtype: 'textfield',
                        name : 'nombre',
                        fieldLabel: 'Identificador',
                        cls: 'disable',
                        width: 400,
                        readOnly: true
                    },
                    {
                        xtype: 'textarea',
                        name : 'motivoBaja',
                        width: 400,
                        hight: 150,
                        fieldLabel: 'Motivo de la baja'
                    },
                    {
                        xtype: 'datefield',
                        name : 'fechaBajaUbicacion',
                        fieldLabel: 'Fecha de baja',
                        format: 'd/m/Y',
                        value: new Date(),
                        msgTarget: 'under', // location of the error message
    			invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.' // custom error message text

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
		                text: 'Dar de baja',
			        action: 'baja',
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