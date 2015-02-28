Ext.define('AM.view.ConsultaAnimal', {
    	extend: 'Ext.panel.Panel',    
    	alias: 'widget.consultaAnimal',										
	title: 'Consulta de animal',
    	
    	items: [
    		{
    		xtype: 'panel',
			
    		bodyPadding: 20, 
    		width: 600,   		
    		items: [   			
    			{
					xtype: 'form',
                	bodyPadding: 10, 
										
                	items: [
                		{
                		name: 'criterioBusqueda',
	                        xtype: 'combo',
	                        fieldLabel: 'Criterio Busqueda',
							store: 'CriteriosBusquedaAnimal',
							queryMode: 'local',
							displayField: 'descripcion',
							valueField: 'valor',
							editable: false,
							cls: 'mostrar',
							value: 'TB'
                		},                		
                    		{	              
		                name: 'esterilizado',
		                xtype: 'combo',
		                fieldLabel: 'Esterilizado',
						store: 'ComboSN',
						queryMode: 'local',
						displayField: 'descripcion',
						valueField: 'valor',					
						editable: false ,
						cls: 'ES',
                		hidden: true                   
		    		},
                    		{	              
		                name: 'recogidoAyuntamiento',
		                xtype: 'combo',
		                fieldLabel: 'Recogido Ayuntamiento',
						store: 'ComboSN',
						queryMode: 'local',
						displayField: 'descripcion',
						valueField: 'valor',					
						editable: false,
						cls: 'RA',
                		hidden: true                    
		    		},{
						xtype: 'datefield',
						name : 'fechaRegistroDesde',
						fieldLabel: 'Fecha registro desde',
						format: 'd/m/Y',
						msgTarget: 'under', // location of the error message
						invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
						cls: 'RA',
                		hidden: true
					},{
						xtype: 'datefield',
						name : 'fechaRegistroHasta',
						fieldLabel: 'Fecha registro hasta',
						format: 'd/m/Y',
						msgTarget: 'under', // location of the error message
						invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
						cls: 'RA',
                		hidden: true
					},
                		/*{
							name: 'especie',
	                        xtype: 'combo',
	                        fieldLabel: 'Especie',
							store: 'Especies',
							queryMode: 'local',
							displayField: 'nombre',
							valueField: 'nombre',
							editable: false,
							cls: 'EP',
							hidden: true
                		} ,*/
                		{
							name: 'textoBusqueda',
							xtype: 'textfield',
							fieldLabel: 'Texto a buscar',
							width: 400,
							cls: 'TB',
							hidden: false
		                },
						{
							xtype: 'fieldcontainer',
							defaultType: 'checkboxfield',
							items: [
							{
								boxLabel  : 'Incluir animales en estado de baja y adoptados',
								name      : 'checkBaja',
								inputValue: '1',
							}
							]
						}						
                		],
                	buttons: [
                		{
                		text: 'Buscar',
		                action: 'buscar'
                		}
                		]
    			}
    			
    		]
    		},
    		{
    		xtype: 'gridpanel',
    		height: 300,
    		width: 600,
    		store: 'ResultadoBusquedaAnimales',
    		columns: [
		        {
		            text: 'Nombre',
		            width: 150,		            
		            dataIndex: 'nombre'
		        },
		        {
		            text: 'Descripcion',
		            width: 450,
		            dataIndex: 'descripcionResultado'		           
		        }
		    ]

    		},{   
    		xtype:'panel',
    		bodyPadding: 0,
    		width: 600,    		   		
    		items: [{     		
		      xtype: 'fieldcontainer',		      
		      
		      items: [
		      		{
		              	xtype: 'button',
		            	text : 'Detalle',
		            	margin: '5 5 5 5',
		            	action: 'detalle'	
		        	},     
		        	{
		                xtype: 'button',
		            	text : 'Modificacion',
		            	margin: '5 5 5 5',
		            	action: 'modificar'
		        	},     
		        	{
		                xtype: 'button',
		            	text : 'Cambio ubicacion',
		            	margin: '5 5 5 5',
		            	action: 'cambioUbicacion'
		        	},     
		        	{
		                xtype: 'button',
		            	text : 'Actualizar peso',
		            	margin: '5 5 5 5',
		            	action: 'modificarPeso'
		        	},     
		        	{
		                xtype: 'button',
		            	text : 'Cambio estado',
		            	margin: '5 5 5 5',
		            	action: 'cambioEstado'
		        	}
		        ]
		}]	                                 
	        }
    	]
    	

  
});