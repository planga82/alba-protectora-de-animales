Ext.define('AM.view.AltaTipoInstitucion', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.altaTipoInstitucion',    											
	title: 'Alta de Tipo de Institución',
	url: "http://localhost:8080/AlbaControlador/altaTipoInstitucion",
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
                        name : 'tipo',
                        fieldLabel: 'Nuevo Tipo Institución'
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
			        formBind: true,
			        margin: '0 10 0 0'                			        	
			        },
			        {
			        xtype: 'button',
			        text: 'Cancelar',
			        action: 'close'
			        }		         	
	                ]	                                 
                    }
                    
                ]       	   

});