Ext.define('AM.view.AltaPersona', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.altaPersona',    											
	title: 'Alta de Persona',
	autoScroll: false,
	url: "/AlbaControlador/altaPersona",
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,    	 
         items: [ 
						{
							xtype: 'hiddenfield',
							name: 'accion',
							value: 'alta'
						},
						{
							xtype: 'hiddenfield',
							name: 'idPersona'
						},
						{
							xtype: 'label',
							text: 'Datos básicos',	
							style: 'font-weight:bold;font-size:12px',
							padding:10
						},{   
			                xtype: 'fieldcontainer',
			                combineErrors: true,
			                msgTarget : 'side',
			                layout: 'hbox',	
			                width: 550,
			                items: [
									{   
									    xtype: 'fieldcontainer',
									    combineErrors: true,
									    msgTarget : 'side',
									    layout: 'vbox',
									    defaults: {
						                    flex: 1,
						                    hideLabel: false,
						                    padding:5
						                },
									    items: [
												{
							                        xtype: 'textfield',
							                        name : 'nombrePersona',
							                        fieldLabel: 'Nombre',
													cls: 'tipo1'
							                    },
							                    {
							                        xtype: 'textfield',
							                        name : 'apellidos',
							                        fieldLabel: 'Apellidos',
													cls: 'tipo1'
							                    },
												{
							                        xtype: 'textfield',
							                        name : 'DNI',
							                        fieldLabel: 'DNI',
													cls: 'tipo1',
							                    },
												{
													xtype: 'textareafield',
													name : 'observaciones',
													fieldLabel: 'Observaciones',
													width: 300,
													cls: 'tipo1'
												}
							                    ]
									},
									{
									    xtype: 'fieldcontainer',
									    fieldLabel: 'Relación ALBA',
							            defaultType: 'checkboxfield',
							            cls: 'tipo1',
									    items: [
									        { boxLabel: 'Adoptante', name: 'ADOPTANTE', inputValue: 'ADOPTANTE' },
									        { boxLabel: 'Voluntario', name: 'VOLUNTARIO', inputValue: 'VOLUNTARIO'},
									        { boxLabel: 'Socio', name: 'SOCIO', inputValue: 'SOCIO' },
									        { boxLabel: 'Colaborador', name: 'COLABORADOR', inputValue: 'COLABORADOR' },
									        { boxLabel: 'Trabajador', name: 'TRABAJADOR', inputValue: 'TRABAJADOR' },
									        { boxLabel: 'Veterinario', name: 'VETERINARIO', inputValue: 'VETERINARIO' },
									        { boxLabel: 'Propietario', name: 'PROPIETARIO', inputValue: 'PROPIETARIO' },
									        { boxLabel: 'Acogedor', name: 'ACOGEDOR', inputValue: 'ACOGEDOR' },
									        { boxLabel: 'Otros', name: 'OTROS', inputValue: 'OTROS', checked: true }
									    ]
									}
		                    ]
						},
						{
							xtype: 'label',
							text: 'Datos contacto',	
							style: 'font-weight:bold;font-size:12px',
							padding:10
						},
	                    {   
			                xtype: 'fieldcontainer',
			                combineErrors: true,
			                msgTarget : 'side',
			                layout: 'hbox',
			                defaults: {
			                    flex: 1,
			                    hideLabel: false,
			                    padding:5
			                },
			                items: [
			                        {
			                        	xtype: 'textfield',
				                        name : 'telefono',
				                        fieldLabel: 'Telefono',
										cls: 'tipo1'
				                    },
				                    {
				                        xtype: 'textfield',
				                        name : 'telefono2',
				                        fieldLabel: 'Telefono 2',
										cls: 'tipo1'
				                    }
				            ]
	                    },
	                    {   
			                xtype: 'fieldcontainer',
			                combineErrors: true,
			                msgTarget : 'side',
			                layout: 'hbox',
			                defaults: {
			                    flex: 1,
			                    hideLabel: false,
			                    padding:5
			                },
			                items: [
							        {
				                        xtype: 'textfield',
				                        name : 'email',
				                        fieldLabel: 'Email',
										cls: 'tipo1'
				                    },
				                    {
				                        xtype: 'textfield',
				                        name : 'email2',
				                        fieldLabel: 'Email 2',
										cls: 'tipo1'
				                    }
				             ]
	                    },
	                    {   
			                xtype: 'fieldcontainer',
			                combineErrors: true,
			                msgTarget : 'side',
			                layout: 'hbox',
			                defaults: {
			                    flex: 1,
			                    hideLabel: false,
			                    padding:5
			                },
			                items: [
							        {
				                        xtype: 'textfield',
				                        name : 'calle',
				                        fieldLabel: 'Calle',
										cls: 'tipo1'
				                    },
				                    {
				                        xtype: 'textfield',
				                        name : 'numero',
				                        fieldLabel: 'Nº',
										cls: 'tipo1'
				                    },
				                    {
				                        xtype: 'textfield',
				                        name : 'codPostal',
				                        fieldLabel: 'Codigo postal',
										cls: 'tipo1'
				                    }
				             ]
	                    },
	                    {   
			                xtype: 'fieldcontainer',
			                combineErrors: true,
			                msgTarget : 'side',
			                layout: 'hbox',
			                defaults: {
			                    flex: 1,
			                    hideLabel: false,
			                    padding:5
			                },
			                items: [
							        {
				                        xtype: 'textfield',
				                        name : 'poblacion',
				                        fieldLabel: 'Población',
										cls: 'tipo1'
				                    },
				                    {
				                        xtype: 'textfield',
				                        name : 'provincia',
				                        fieldLabel: 'Provincia',
										cls: 'tipo1',
										value:'Madrid'
				                    },
				                    {
				                        xtype: 'textfield',
				                        name : 'pais',
				                        fieldLabel: 'Pais',
										cls: 'tipo1',
										value:'España'
				                    }
				             ]
	                    },	                    
						{
							xtype: 'textarea',
							name : 'motivoBaja',
							width: 400,
							hight: 150,
							fieldLabel: 'Motivo de la baja', 
							hidden: true,
							cls: 'tipo2',
							readOnly: true
						},{
							xtype: 'datefield',
							name : 'fechaBaja',
							fieldLabel: 'Fecha Baja',
							format: 'd/m/Y',
							msgTarget: 'under', // location of the error message
							invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.',
							hidden: true,
							cls: 'tipo2',
							readOnly: true
						}					
					
	         ,{   
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
						margin: '0 10 0 0',
						cls: 'tipo1',
						formBind: true                			        	
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