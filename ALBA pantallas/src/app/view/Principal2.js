Ext.define('AM.view.Principal2', {
    	extend: 'Ext.panel.Panel',    
    	alias: 'widget.panelPrincipal2',	
    	header:false,
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
				        	xtype: 'panel',
				        	header:false,
				        	width: 100,
				        	height: 50,
				        	layout: 'fit',
				        	margin:'0 0 0 0',
				        	items:[
				        	       {
				        	    	   xtype: 'image',
				        	    	   src : 'images/LogoAlba.png',
				        	       }
				        	]
				        },
						{
						    xtype: 'textfield',
						    name : 'textoBusqueda',
							width: 500,
							enableKeyEvents: true,
							emptyText: 'Buscar'
						},
						{
							xtype: 'fieldcontainer',
							defaultType: 'checkboxfield',
							items: [
							{
								boxLabel  : 'Incluir todos elementos',
								name      : 'todosEstados',
								inputValue: '1',
							}
							]
						},
						{	              
							name: 'maxNumResultados',
							xtype: 'combo',
							store: 'ComboNumResultados',
							queryMode: 'local',
							displayField: 'descripcion',
							valueField: 'valor',					
							editable: false,
							value: '10',
						},
				    ]
				},{
				    // xtype: 'panel' implied by default
				    title: 'Operaciones',
				    region:'east',
				    xtype: 'panel',
				    width: 200,
				    collapsible: true,   // make collapsible
				    layout: 'vbox',
				    bodyStyle:{"background-color":"#E6E6E6"},
				    defaults:{
				    	padding:10,
				    	width:200,
				    	height:50
				    },
				    items:[
						{
							xtype: 'button',
							text: 'Alta animal',
							action: 'altaAnimal',
							scope: this
						},{
							xtype: 'button',
							text: 'Alta persona',
							action: 'altaPersona',
							scope: this
						},{
							xtype: 'button',
							text: 'Alta institución',
							action: 'altaInstitucion',
							scope: this
						}
				    ]
				},{
					header: false,
				    region: 'center',     // center region is required, no width/height specified
				    xtype: 'gridpanel',
				    store: 'ResultadoBusquedaGeneral',
				    name: 'ResultadoBusquedaGeneral',
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
				},{
				    region: 'south',     // position for region
				    xtype: 'panel',
				    header:false,
				    height: 35,
				    layout: 'hbox',
				    bodyStyle:{"background-color":"#E6E6E6"},
				    items: [
						{   
							xtype:'panel',
							layout:'hbox',
							header:false,
							name:'operacionesAnimal',
							hidden: true,
							bodyStyle:{"background-color":"#E6E6E6"},
							border: 0,
							defaults:{
								margin: '5 5 5 5'
							},
							items: [     		
						       		{
						              	xtype: 'button',
						            	text : 'Detalle',
						            	action: 'detalleAnimal'	
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Modificacion',
						            	action: 'modificarAnimal'
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Cambio ubicacion',
						            	action: 'cambioUbicacionAnimal'
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Actualizar peso',
						            	action: 'modificarPesoAnimal'
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Cambio estado',
						            	action: 'cambioEstadoAnimal'
						        	}
						        ]
						},
						{   
							xtype:'panel',
							layout:'hbox',
							header:false,
							name:'operacionesInstitucion',
							bodyStyle:{"background-color":"#E6E6E6"},
							border: 0,
							hidden: true,
							defaults:{
								margin: '5 5 5 5'
							},
							items: [     		
						       		{
						              	xtype: 'button',
						            	text : 'Detalle',
						            	margin: '5 5 5 5',
						            	action: 'detalleInstitucion',
						            	cls: 'consulta'	
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Modificacion',
						            	margin: '5 5 5 5',
						            	action: 'modificarInstitucion',
						            	cls: 'consulta'
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Cambio Estado',
						            	margin: '5 5 5 5',
						            	action: 'cambioEstadoInstitucion',
						            	cls: 'consulta'
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Gestión Ubicaciones',
						            	margin: '5 5 5 5',
						            	action: 'ubicacionesInstitucion',
						            	cls: 'consulta'
						        	}
						        ]
						},
						{   
							xtype:'panel',
							layout:'hbox',
							header:false,
							hidden: true,
							name:'operacionesPersona',
							bodyStyle:{"background-color":"#E6E6E6"},
							border: 0,
							defaults:{
								margin: '5 5 5 5'
							},
							items: [     		
						       		{
						              	xtype: 'button',
						            	text : 'Detalle',
						            	margin: '5 5 5 5',
						            	action: 'detallePersona',
						            	cls: 'consulta'	
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Modificacion',
						            	margin: '5 5 5 5',
						            	action: 'modificarPersona',
						            	cls: 'consulta'
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Cambio estado',
						            	margin: '5 5 5 5',
						            	action: 'cambioEstadoPersona',
						            	cls: 'consulta'
						        	},     
						        	{
						                xtype: 'button',
						            	text : 'Gestión ubicaciones',
						            	margin: '5 5 5 5',
						            	action: 'ubicacionesPersona',
						            	cls: 'consulta'
						        	}
						        ]
						}]
				}
		]    
});