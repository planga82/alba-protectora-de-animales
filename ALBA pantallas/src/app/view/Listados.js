Ext.define('AM.view.Listados', {
    	extend: 'Ext.panel.Panel',    
    	alias: 'widget.panelListados',	
    	header:false,
		layout: 'border',
		items: [
				{
				    region: 'north',     // position for region
				    xtype: 'form',
				    header:false,
				    height: 130,
				    layout: 'hbox',
				    autoScroll: true,
				    bodyStyle:{"background-color":"#E6E6E6"},
				    defaults:{
				    	margin:'10 10 10 10'
				    },
				    items: [
				        {
				        	xtype: 'panel',
				        	header:false,
				        	width: 350,
				        	height: 100,
				        	border: false,
				        	layout: 'vbox',
				        	bodyStyle:{"background-color":"#E6E6E6"},
				        	items:[
							{
								xtype: 'label',
								text: 'LISTADOS',
								style: 'font: normal 20px courier',
							},
							{	              
								name: 'Entidad',
								xtype: 'combo',
								fieldLabel: 'Entidad',
								store: 'ComboOpcionesListado',
								queryMode: 'local',
								displayField: 'descripcion',
								valueField: 'valor',					
								editable: false
							},
							{
					        	xtype: 'panel',
					        	header:false,
					        	border: false,
					        	layout: 'hbox',
					        	bodyStyle:{"background-color":"#E6E6E6"},
					        	items:[
									{	              
										name: 'Atributos',
										fieldLabel: 'Atributo',
										xtype: 'combo',
										store: 'comboListadoAtributos',
										queryMode: 'local',
										displayField: 'nombre',
										valueField: 'nombre',					
										editable: false
									},{
										xtype: 'button',
										text: 'Añadir',
										action: 'add',
										scope: this
									}				        	
					        	]
					        },
							{
					        	xtype: 'panel',
					        	header:false,
					        	border: false,
					        	layout: 'hbox',
					        	bodyStyle:{"background-color":"#E6E6E6"},
					        	items:[

									{	              
										name: 'Enlace',
										xtype: 'combo',
										fieldLabel: 'Enlace',
										store: 'ComboANDOR',
										queryMode: 'local',
										displayField: 'descripcion',
										valueField: 'valor',					
										editable: false
									},									
									{
										xtype: 'button',
										text: 'Buscar',
										action: 'buscar',
										scope: this
									}					        	
					        	]
					        }
				        	]
				        }				        					
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
						
				    ]
				},{
					header: false,
				    region: 'center',     // center region is required, no width/height specified
				    xtype: 'gridpanel',
				    store: 'ResultadoListados',
				    name: 'ResultadoListado',
		    		columns: [
						{
				            text: 'Nombre',
				            width: 150,		            
				            dataIndex: 'nombre'
				        },
				        {
				            text: 'Chip',
				            width: 150,		            
				            dataIndex: 'chip'
				        },
				        {
				            text: 'Segundo Identificador',
				            width: 150,		            
				            dataIndex: 'segundoIdentificador'
				        },
				        {
				            text: 'Raza',
				            width: 150,		            
				            dataIndex: 'raza'
				        },
				        {
				            text: 'Fecha Nacimiento',
				            width: 150,		            
				            dataIndex: 'fechaNacimiento'
				        },
				        {
				            text: 'Sexo',
				            width: 150,		            
				            dataIndex: 'sexo'
				        },
				        {
				            text: 'Esterilizado',
				            width: 150,		            
				            dataIndex: 'esterilizado'
				        },
				        {
				            text: 'Color',
				            width: 150,		            
				            dataIndex: 'color'
				        },
				        {
				            text: 'Tamano',
				            width: 150,		            
				            dataIndex: 'tamano'
				        },
				        {
				            text: 'Propietario',
				            width: 150,		            
				            dataIndex: 'propietario'
				        },
				        {
				            text: 'Fecha Registro',
				            width: 150,		            
				            dataIndex: 'fechaRegistro'
				        },
				        {
				            text: 'Descripcion',
				            width: 150,		            
				            dataIndex: 'descripcion'
				        },
				        {
				            text: 'Lugar Recogida',
				            width: 150,		            
				            dataIndex: 'lugarRecogida'
				        },
				        {
				            text: 'Recogido Ayuntamiento',
				            width: 150,		            
				            dataIndex: 'recogidoAyuntamiento'
				        },
				        {
				            text: 'Persona Avisa',
				            width: 150,		            
				            dataIndex: 'personaAvisa'
				        },
				        {
				            text: 'Persona Recoge',
				            width: 150,		            
				            dataIndex: 'personaRecoge'
				        },
				        {
				            text: 'Persona Recepciona',
				            width: 150,		            
				            dataIndex: 'personaRecepciona'
				        },
				        {
				            text: 'Peso Actual',
				            width: 150,		            
				            dataIndex: 'pesoActual'
				        },
				        {
				            text: 'Fecha Peso Actual',
				            width: 150,		            
				            dataIndex: 'fechaPesoActual'
				        },
				        {
				            text: 'Fecha Ubicacion Actual',
				            width: 150,		            
				            dataIndex: 'fechaUbicacionActual'
				        },
				        {
				            text: 'Nombre Ubicacion Actual',
				            width: 150,		            
				            dataIndex: 'nombreUbicacionActual'
				        },
				        {
				            text: 'Especie',
				            width: 150,		            
				            dataIndex: 'especie'
				        },
				        {
				            text: 'Fecha Avisa',
				            width: 150,		            
				            dataIndex: 'fechaAvisa'
				        },
				        {
				            text: 'Fecha Recepcion',
				            width: 150,		            
				            dataIndex: 'fechaRecepcion'
				        },
				        {
				            text: 'Fecha Recogido',
				            width: 150,		            
				            dataIndex: 'fechaRecogido'
				        },
				        {
				            text: 'Altura Cruz',
				            width: 150,		            
				            dataIndex: 'alturaCruz'
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
							    xtype: 'button',
								text : 'Volver',
								action: 'close'
							}
						]
				}
		]    
});