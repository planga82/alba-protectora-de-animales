Ext.define('AM.view.AsignarUbicacionAnimal', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.AsignarUbicacionAnimal',    											
		title: 'Asignar ubicacion de animal',
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
                        fieldLabel: 'Nombre',
                        readOnly: true
                    },
                    {   
						xtype: 'fieldcontainer',
						fieldLabel: 'Institucion/Persona destino',
						combineErrors: true,
						msgTarget : 'side',
						layout: 'hbox',
						defaults: {
							flex: 1,
							hideLabel: true
						},
						items: [
								{	              
								xtype: 'textfield',
								name : 'idInstitucionDestino',
								readOnly: true,
								margin: '0 5 0 0'                    
								},
								{	              
								xtype: 'button',
								text : 'Buscar',
								action: 'busquedaUbicacion'
								}
		         	
						]	                                 
						},{
						xtype: 'gridpanel',
						height: 200,
						width: 320,
						store: 'Ubicaciones',	
						columns: [
							{
								text: 'Selecciona la ubicacion',
								width: 300,		            
								dataIndex: 'idInterno'
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
							text: 'Asignar ubicacion',
						action: 'cambioUbicacion',
						margin: '0 10 0 0',
						formBind: true                			        	
						},
						{
						xtype: 'button',
						text: 'No asignar todavia',
						action: 'close',
						scope: this
						}		         	
	                ]	                                 
                    }                    
                ]       	   

});