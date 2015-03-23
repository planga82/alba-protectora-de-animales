Ext.define('AM.view.AltaAnimal', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.altaAnimal',    											
		title: 'Alta de animal',
		autoScroll: true,
		url: "/AlbaControlador/altaAnimal",
    	layout: {
            type:'hbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,
    	 
         items: [   
					{
						xtype: 'panel',
						bodyPadding: 20,
						border: false,
						items: [
							{
								xtype: 'label',
								text: 'Datos básicos',	
								style: 'font-weight:bold;font-size:12px'								
							},
							{
								xtype: 'textfield',
								name : 'nombre',
								fieldLabel: 'Nombre',
								margin: '10 0 5 0'
							},
							{
								xtype: 'textfield',
								name : 'chip',
								fieldLabel: 'Chip',
								regex: /^(([0-9])|([0-9][0-9])|([0-9][0-9][0-9])|([0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])|([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]))$/,
								msgTarget: 'under',
								invalidText: 'Numero de 15 posiciones'
							},
							{
								xtype: 'textfield',
								name : 'segundoIdentificador',
								fieldLabel: 'Segundo Identificador'
							},
							{
								xtype: 'textareafield',
								name : 'descripcion',
								fieldLabel: 'Descripcion',
								width: 400
							},
							{
								xtype: 'datefield',
								name : 'fechaNacimiento',
								fieldLabel: 'Fecha Nacimiento',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.' // custom error message text
							},
							{
								xtype: 'textfield',
								name : 'pesoActual',
								fieldLabel: 'Peso Actual(Kg)',
								regex: /^([0-9]+)(((\.)[0-9]+)?)$/,
								msgTarget: 'under',
								invalidText: 'Valor invalido, ejemplo; 12.5'
							},
							{
								xtype: 'textfield',
								name : 'alturaCruz',
								fieldLabel: 'Altura a la Cruz(cm)',
								regex: /^([0-9]*)$/,
								msgTarget: 'under',
								invalidText: 'Valor numérico'
							},
							{   
								xtype: 'fieldcontainer',
								fieldLabel: 'Especie',
								combineErrors: true,
								msgTarget : 'side',
								layout: 'hbox',
								defaults: {
									flex: 1,
									hideLabel: true
								},
								items: [
									{	              
											name: 'especie',
											xtype: 'combo',
											fieldLabel: 'Especie',
											store: 'Especies',
											queryMode: 'local',
											displayField: 'nombre',
											valueField: 'nombre',
											margin: '0 5 0 0',					
											editable: false                    
									},
									{	              
											xtype: 'button',
										text : 'Alta especie',  
										action: 'altaEspecie'       
									}
									]	                                 
							},							
							{
								xtype: 'textfield',
								name : 'raza',
								fieldLabel: 'Raza'
							},
							{	              
								name: 'sexo',
								xtype: 'combo',
								fieldLabel: 'Sexo',
								store: 'ComboHM',
								queryMode: 'local',
								displayField: 'descripcion',
								valueField: 'valor',					
								editable: false                    
							},
							{	              
								name: 'esterilizado',
								xtype: 'combo',
								fieldLabel: 'Esterilizado',
								store: 'ComboSN',
								queryMode: 'local',
								displayField: 'descripcion',
								valueField: 'valor',					
								editable: false                    
							},
							{
								xtype: 'textfield',
								name : 'color',
								fieldLabel: 'Color'
							},
							{	              
								name: 'tamano',
								xtype: 'combo',
								fieldLabel: 'Tamaño',
								store: 'ComboTM',
								queryMode: 'local',
								displayField: 'descripcion',
								valueField: 'valor',					
								editable: false                    
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
		                		cls: 'mostrar',
		                		value: 'EN ALBA BLOQUEADO'
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
									text: 'Siguiente',
									formBind: true,
									action: 'siguiente',
									margin: '0 10 0 0'                			        	
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
								margin: '10 0 5 0'
							},
							
							
							{
								xtype: 'textfield',
								name : 'lugarRecogida',
								fieldLabel: 'Lugar de recogida'
							},
							
							{
								xtype: 'textfield',
								name : 'propietario',
								fieldLabel: 'Propietario'
							},{
							xtype: 'panel',
							border: false,
							items: [
								{
									xtype: 'hiddenfield',
									name : 'tipoPatrocinador'
								},
								{
									xtype: 'hiddenfield',
									name : 'idPatrocinador'
								},
								{   
									xtype: 'fieldcontainer',	                
									combineErrors: true,
									msgTarget : 'side',
									layout: 'hbox',
									margin: '25 5 10 0',
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
										},
										{
											xtype: 'button',
											text: 'Modificar',
											action: 'modPatrocinador',
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
								fieldLabel: 'Persona que avisa'
							},
							{
								xtype: 'datefield',
								name : 'fechaAvisa',
								fieldLabel: 'Fecha Aviso',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
								value: new Date(),
								margin: '10 0 5 0'
							},							
							{
								xtype: 'textfield',
								name : 'personaRecoge',
								fieldLabel: 'Persona que recoge'
							},
							{
								xtype: 'datefield',
								name : 'fechaRecogido',
								fieldLabel: 'Fecha recogida',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
								value: new Date(),
								margin: '10 0 5 0'
							},
							{
								xtype: 'textfield',
								name : 'personaRecepciona',
								fieldLabel: 'Persona que recepciona'
							},
							{
								xtype: 'datefield',
								name : 'fechaRecepcion',
								fieldLabel: 'Fecha recepción',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
								value: new Date(),
								margin: '10 0 5 0'
							},
							{
	                            xtype: 'filefield',
	                            width: 296,
	                            fieldLabel: 'Imagen',
	                            emptyText: 'Selecciona imagen...',
	                            name: 'imagen',
	                            labelWidth: 70
	                        }
							
						   
							

						]
					}
                    
                    
                ]       	   

});