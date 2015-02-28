Ext.define('AM.view.DetalleAnimal', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.detalleAnimal',    											
		title: 'Detalle de animal',
		autoScroll: true,
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 5,
    	 
         items: [  {
			        	xtype: 'panel',
			        	header:false,
			        	width: 150,
			        	height: 150,
			        	layout: 'fit',
			        	margin:'0 0 0 0',
			        	items:[
			        	       {
			        	    	   xtype: 'image',
			        	    	   src : 'images/SinImagen.jpg',
			        	       }
			        	]
			        },
                    {
						xtype: 'panel',
						bodyPadding: 20,
						border: false,
						layout: {
							type:'hbox',
							padding:'5',
							align:'left'
						},
						items: [
					{
						xtype: 'panel',
						bodyPadding: 20,
						border: false,
						items: [
							{	
								xtype: 'hiddenfield',
								name: 'id'
							},
							{
							xtype: 'label',
							text: 'Datos básicos',	
							style: 'font-weight:bold;font-size:12px',		        
							},
							{
								xtype: 'textfield',
								name : 'nombre',
								fieldLabel: 'Nombre',
								margin: '10 0 5 0',
								readOnly: true
							},
							{
								xtype: 'textfield',
								name : 'chip',
								fieldLabel: 'Chip',
								readOnly: true
							},
							{
								xtype: 'textfield',
								name : 'segundoIdentificador',
								fieldLabel: 'Segundo Identificador',
								readOnly: true
							},
							{
								xtype: 'textareafield',
								name : 'descripcion',
								fieldLabel: 'Descripcion',
								width: 400,
								readOnly: true
							},
							{
								xtype: 'datefield',
								name : 'fechaNacimiento',
								fieldLabel: 'Fecha Nacimiento',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
								readOnly: true								// custom error message text
							},
							{   
								xtype: 'fieldcontainer',
								fieldLabel: 'Peso(Kg) / fecha',
								combineErrors: true,
								msgTarget : 'side',
								layout: 'hbox',
								margin: '10 0 5 0',
								defaults: {
									flex: 1,
									hideLabel: true
								},
								items: [
									{	              
											xtype: 'textfield',
											name : 'pesoActual',
											fieldLabel: 'Peso Actual(Kg)',
											readOnly: true,
											margin: '0 5 0 0'                   
									},
									{	              
											 xtype: 'datefield',
											name : 'fechaPesoActual',
											format: 'd/m/Y',
											msgTarget: 'under', // location of the error message
											invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
											readOnly: true,
											margin: '0 5 0 0'								
									},{
											xtype: 'button',
											text: 'Historico pesos',
											action: 'historicoPesos',
									}
									]	                                 
							},                    
							{
									xtype: 'gridpanel',
									name: 'tablaPesos',
									height: 120,
									width: 300,
									hidden: true,
									store: 'HistoricoPesos',
									margin: '10 0 5 0',		
									columns: [
									{
										text: 'Peso',
										width: 140,		            
										dataIndex: 'peso'
									},
									{
										text: 'Fecha',
										width: 140,
										dataIndex: 'fecha'		           
									}			        
									]
							},
							{
								xtype: 'textfield',
								name : 'alturaCruz',
								fieldLabel: 'Altura a la Cruz(cm)',
								regex: /^([0-9]*)$/,
								msgTarget: 'under',
								invalidText: 'Valor numérico',
								readOnly: true
							},
							{	              
										name: 'especie',
										xtype: 'combo',
										fieldLabel: 'Especie',
										store: 'Especies',
										queryMode: 'local',
										displayField: 'nombre',
										valueField: 'nombre',
															
										editable: false,
										readOnly: true								
							},							
							{
								xtype: 'textfield',
								name : 'raza',
								fieldLabel: 'Raza',
								readOnly: true
							},
							{	              
								name: 'sexo',
								xtype: 'combo',
								fieldLabel: 'Sexo',
								store: 'ComboHM',
								queryMode: 'local',
								displayField: 'descripcion',
								valueField: 'valor',					
								editable: false,
								readOnly: true
							},
							{	              
								name: 'esterilizado',
								xtype: 'combo',
								fieldLabel: 'Esterilizado',
								store: 'ComboSN',
								queryMode: 'local',
								displayField: 'descripcion',
								valueField: 'valor',					
								editable: false,
								readOnly: true
							},
							{
								xtype: 'textfield',
								name : 'color',
								fieldLabel: 'Color',
								readOnly: true
							},
							{	              
								name: 'tamano',
								xtype: 'combo',
								fieldLabel: 'Tamaño',
								store: 'ComboTM',
								queryMode: 'local',
								displayField: 'descripcion',
								valueField: 'valor',					
								editable: false,
								readOnly: true
							},
							{
		                        name: 'estado',
		                	    xtype: 'combo',
		                	    fieldLabel: 'Estado',
		                		store: 'EstadosAnimal',
		                		queryMode: 'local',
		                		displayField: 'descripcion',
		                		valueField: 'valor',
		                		editable: false,
		                		readOnly: true
		                    }
						]
					},
					{						
						xtype: 'panel',
						bodyPadding: 20,
						border: false,
						items: [
							{
								xtype: 'label',
								text: 'Datos Seguimiento',	
								style: 'font-weight:bold;font-size:12px'								
							},
							{
								xtype: 'datefield',
								name : 'fechaRegistro',
								fieldLabel: 'Fecha registro',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
								value: new Date(),
								margin: '10 0 5 0',
								readOnly: true
							},				
							{   
								xtype: 'fieldcontainer',
								fieldLabel: 'Ubicacion / fecha',
								combineErrors: true,
								msgTarget : 'side',
								layout: 'hbox',
								margin: '10 0 5 0',
								defaults: {
									flex: 1,
									hideLabel: true
								},
								items: [
									{	              
											xtype: 'textfield',
											name : 'nombreUbicacionActual',
											readOnly: true,
											margin: '0 5 0 0'                   
									},
									{	              
											 xtype: 'datefield',
											name : 'fechaUbicacionActual',
											format: 'd/m/Y',
											msgTarget: 'under', // location of the error message
											invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
											readOnly: true,
											margin: '0 5 0 0'								
									},{
											xtype: 'button',
											text: 'Historico Ubicaciones',
											action: 'historicoUbicaciones',
											hidden: false
									}
									]	                                 
							},
							{
								xtype: 'gridpanel',
								name: 'tablaUbicaciones',
								height: 120,
								width: 450,
								hidden: true,
								store: 'HistoricoUbicaciones',		
								columns: [
								{
									text: 'Ubicacion',
									width: 140,		            
									dataIndex: 'textoIdentUbicacion'
								},
								{
									text: 'Fecha Entrada',
									width: 140,
									dataIndex: 'fechaEntrada'		           
								},
								{
									text: 'Fecha Salida',
									width: 140,
									dataIndex: 'fechaSalida'		           
								}
							
								]
							},
							{
								xtype: 'textfield',
								name : 'lugarRecogida',
								fieldLabel: 'Lugar de recogida',
								readOnly: true
							},
							
							{
								xtype: 'textfield',
								name : 'propietario',
								fieldLabel: 'Propietario',
								readOnly: true
							},{
								xtype: 'panel',
								border: false,
								items: [
									{   
										xtype: 'fieldcontainer',	                
										combineErrors: true,
										msgTarget : 'side',
										layout: 'hbox',
										margin: '10 5 10 0',
										defaults: {
											flex: 1,
											hideLabel: false
										},
										items: [
											{
												xtype: 'textfield',
												name : 'textoPatrocinador',
												fieldLabel: 'Patrocinador',
												readOnly: true
											},
											{
												xtype: 'button',
												text: '+ Info',
												action: 'masInfo',
												scope: this
											}
										]	                                 
									},
									{
										xtype: 'textfield',
										name : 'txtMuestraMasInfo',
										width: 450,
										fieldLabel: 'Mas Información',
										hidden: true
									}
								]},
							{
								xtype: 'textfield',
								name : 'personaAvisa',
								fieldLabel: 'Persona que avisa',
								readOnly: true
							},
							{
								xtype: 'datefield',
								name : 'fechaAvisa',
								fieldLabel: 'Fecha aviso',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
								value: new Date(),
								margin: '10 0 5 0',
								readOnly: true
							},
							{
								xtype: 'textfield',
								name : 'personaRecoge',
								fieldLabel: 'Persona que recoge',
								readOnly: true
							},
							{
								xtype: 'datefield',
								name : 'fechaRecogido',
								fieldLabel: 'Fecha recogida',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
								value: new Date(),
								margin: '10 0 5 0',
								readOnly: true
							},
							{
								xtype: 'textfield',
								name : 'personaRecepciona',
								fieldLabel: 'Persona que recepciona',
								readOnly: true
							},
							{
								xtype: 'datefield',
								name : 'fechaRecepcion',
								fieldLabel: 'Fecha recepción',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
								value: new Date(),
								margin: '10 0 5 0',
								readOnly: true
							},
						]
					}
					]
					},
					                  
                    {   					
							xtype: 'button',
							text: 'Salir',
							action: 'close',
							scope: this,
							margin: '20 0 0 0'
                    }
                    
                ]       	   

});