Ext.define('AM.view.AsignarPatrocinadorAnimal', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.asignarPatrocinadorAnimal',    											
		title: 'Asignar patrocinador',		
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
				    xtype: 'textfield',
				    name : 'textoBusqueda',
					width: 500,
					enableKeyEvents: true
				}
		    ]
		},
		{
			header: true,
		    region: 'center',
		    xtype: 'gridpanel',
			name: 'ResBusquedaInstPersPatrocinador',
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
					text: 'Aceptar',
					action: 'aceptar',
					disabled: 'true'              			        	
					},
					{
					xtype: 'button',
					text: 'Cancelar',
					action: 'close',
					scope: this
					},
					{
					xtype: 'button',
					text: 'Sin patrocinador',
					action: 'sinPatrocinador',
					scope: this
					}
			]	                                 
         }                    
    ]       	   

});