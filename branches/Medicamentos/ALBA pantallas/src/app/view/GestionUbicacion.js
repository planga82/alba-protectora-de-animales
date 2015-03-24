Ext.define('AM.view.GestionUbicacion', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.gestionUbicacion',    											
		title: 'Gestión Ubicaciones',				
		layout: 'border',     	 
         items: [   
				{
				    region: 'north',     // position for region
				    xtype: 'form',
				    header:false,
				    height: 50,
				    layout: 'hbox',
				    url: "/AlbaControlador/gestionUbicacion",
				    bodyStyle:{"background-color":"#E6E6E6"},
				    defaults:{
				    	margin:'10 10 10 10'
				    },
				    items: [
						{
							xtype: 'hiddenfield',
							name: 'idPersona',
						},
						{
						    xtype: 'textfield',
						    name : 'nombreInstitucion',
						    fieldLabel: 'Institucion',
						    width: 300,
						    readOnly: true,
						    cls: 'Tipo1'
						},
						{
						    xtype: 'textfield',
						    name : 'nombrePersona',
						    fieldLabel: 'Persona',
						    width: 300,
						    readOnly: true,
						    cls: 'Tipo2'
						},
						{
							fieldLabel: 'Identificador Nueva Ubicacion',
			                xtype: 'textfield',
			                name : 'nombreNuevaUbicacion',
							 margin: '0 10 0 0',
							 allowBlank: false
						},
						{
			                xtype: 'button',
			            	text : 'Alta',
			            	margin: '5 10 0 0',
			            	cls: 'tipo4',
			            	action: 'altaUbicacion',
			            	formBind: true
						}
				    ]
				},
				{
					header: true,
				    region: 'west',
				    xtype: 'gridpanel',
					width: 450,
					split: true,
					store: 'Ubicaciones',
					title: 'Ubicaciones',	
					columns: [
						{
							hidden:true,            
							dataIndex: 'nombreInstitucion'
						},
						{
							hidden:true,            
							dataIndex: 'idPersona'
						},
						{
							hidden:true,            
							dataIndex: 'idInterno'
						},
						{
							text: 'Identficador',
							flex:1,	            
							dataIndex: 'nombre'
						},
						{
							 	xtype:'actioncolumn',
						        width:25,
						        items: [{
						        	icon: 'images/delete.png',
						            tooltip: 'Eliminar',
						            handler: function(grid, rowIndex, colIndex) {
						            	var data = grid.getStore().getAt(rowIndex).data;
						                Ext.Ajax.request({
						        			url: "/AlbaControlador/bajaUbicacion",
						        			params: data,
						        			success: function(form, action) {
						        				grid.getStore().removeAt(rowIndex);
						        			},
						        			failure: function(form, action) {
						        				Ext.Msg.alert('No se ha podido realizar la baja');
						        			}
						        		});
						            }
						        }]		                
						    
						}	        
					]
				},{
					header: true,
				    region: 'center',
					xtype: 'gridpanel',
					store: 'AnimalesEnUbicacion',
					title: 'Animales en la ubicacion seleccionada',
					name: 'AnimalesUbicacion',
					flex:1,
					columns: [
						{
									text: 'Nombre',
									width: 200,	            
									dataIndex: 'nombre'
								},
								{
									text: 'Especie',
									width: 100,	            
									dataIndex: 'especie'
								},
								{
									text: 'Raza',
									flex:1,	            
									dataIndex: 'raza'
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
								text: 'Salir',
								action: 'close',
								margin: '10 10 0 0'
						     }								         	
					]	                                 
		         }   
  				
               ]       	   

});