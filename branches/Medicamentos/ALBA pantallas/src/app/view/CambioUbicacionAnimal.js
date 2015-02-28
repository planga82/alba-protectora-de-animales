Ext.define('AM.view.CambioUbicacionAnimal', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.cambioUbicacionAnimal',    											
		title: 'Cambio de ubicacion de animal',		
		layout: 'border',
         items: [  
            {
		    region: 'north',     // position for region
		    xtype: 'form',
		    header:false,
		    height: 50,
		    layout: 'hbox',
		    bodyStyle:{"background-color":"#E6E6E6"},
		    defaults:{
		    	margin:'10 10 10 10'
		    },
		    items: [
				{
					xtype: 'hiddenfield',
					name: 'id'
				},
				{
				    xtype: 'textfield',
				    hideLabel: true,
				    name : 'nombre',
				    fieldLabel: 'Nombre',
				    readOnly: true
				},
				{   	                              
					xtype: 'textfield',
				    name : 'nombreUbicacionActual',
				    hideLabel: true,
				    fieldLabel: 'Ubicacion actual',
				    readOnly: true,                 
				},
				{
				    xtype: 'textfield',
				    name : 'textoBusqueda',
					width: 500,
					value: 'ALBA',
					enableKeyEvents: true
				},
				{
					xtype: 'button',
					text: 'Buscar',
					action: 'buscar',
					scope: this
				},
				{
				    xtype: 'textfield',
				    name : 'textoBusquedaUbicacion',
					width: 300,
					enableKeyEvents: true,
					emptyText: 'Filtrar ubicaciones'
				}
		    ]
		},
		{
			header: true,
		    region: 'west',
		    xtype: 'gridpanel',
			name: 'ResultadoBusquedaInstitucionPersona',
			width: 450,
			split: true,
			store: 'ResultadoBusquedaInstitucionPersona',
			title: 'Institucion/Persona',	
			columns: [
				{
				    text: 'Tipo',
				    width: 80,		            
				    dataIndex: 'tipoResultado'
				},
				{
				    text: 'Descripcion',
				    width: 180,		            
				    dataIndex: 'descripcionResultado'
				},
				{
				    text: 'Informacion',
				    dataIndex: 'info',
				    flex     : 1
				}		        
			]
		},
		{
			header: true,
		    region: 'center',
			xtype: 'gridpanel',
			store: 'Ubicaciones',
			title: 'Ubicacion',
			name: 'Ubicacion',
			flex:1,
			columns: [
				{
				text: 'Nombre',	            
				dataIndex: 'nombre',
				flex:1
				}			        
			]
		},
		{
			header: true,
		    region: 'east',
		    xtype: 'gridpanel',
		    collapsible: true,
			store: 'AnimalesEnUbicacion',
			width: 300,	
			split: true,
			title: 'Animales',
			columns: [
				{
				text: 'ID',
				flex:1,
				dataIndex: 'nombre'
				}			        
			]
		},			
		{   
			header: false,
		    region: 'south',
		    xtype: 'panel',
			layout: 'hbox',
			defaults:{
		    	margin:'10 10 10 10'
		    },
			items: [
					{
					xtype: 'button',
					text: 'Cambiar ubicacion',
					action: 'cambioUbicacion',
					disabled: 'true'              			        	
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