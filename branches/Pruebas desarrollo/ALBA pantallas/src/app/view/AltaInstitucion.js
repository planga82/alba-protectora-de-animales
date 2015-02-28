Ext.define('AM.view.AltaInstitucion', {
    	extend: 'Ext.form.Panel',    
    	alias: 'widget.altaInstitucion',    											
	title: 'Alta de Institución',
	autoScroll: false,
	url: "http://localhost:8080/AlbaControlador/altaInstitucion",
    	layout: {
            type:'vbox',
            padding:'5',
            align:'left'
        },    	
    	 bodyPadding: 20,    	 
         items: [ 
          	{
          	xtype: 'panel',
          	layout: {
	            type:'hbox',
	            padding:'5',
	            align:'left'
	        },
	        border: false,
          	items:[
	          	{
	         	xtype: 'panel',
	         	bodyPadding: 20,
	         	border: false,
	         	items: [
						{
							xtype: 'hiddenfield',
							name: 'accion',
							value: 'alta'
						},
						{
							xtype: 'label',
							text: 'Datos básicos',	
							style: 'font-weight:bold;font-size:12px',		        
						},
						{
	                        xtype: 'textfield',
	                        name : 'nombreInstitucion',
	                        fieldLabel: 'Nombre',
	                        margin: '10 0 5 0',
	                        allowBlank: false,
							cls: 'tipo1'
	                    },
	                    {
	                        xtype: 'textfield',
	                        name : 'NIF',
	                        fieldLabel: 'NIF',
							cls: 'tipo1'
	                    },
	                    {
	                        xtype: 'textarea',
	                        name : 'direccion',
	                        fieldLabel: 'Dirección',
							cls: 'tipo1'
	                    },              
	                    {   
		                xtype: 'fieldcontainer',
		                fieldLabel: 'Tipo',
		                combineErrors: true,
		                msgTarget : 'side',
		                layout: 'hbox',
		                defaults: {
		                    flex: 1,
		                    hideLabel: true
		                },
		                items: [
		                	{	              
		                    	name: 'tipo',
		                        xtype: 'combo',
		                        fieldLabel: 'Tipo de Institución',
								store: 'TiposInstituciones',
								queryMode: 'local',
								displayField: 'nombreTipo',
								valueField: 'nombreTipo',
								margin: '0 5 0 0',
								editable: false ,
								cls: 'tipo1'                   
							},
							{	              
		                    	xtype: 'button',
								text : 'Alta Tipo',  
								action: 'altaTipoInstitucion',
								cls: 'tipo1'
							}
		                ]	                                 
	                    },
	                    {
	                        xtype: 'textfield',
	                        name : 'cuentaCargo',
	                        fieldLabel: 'Cuenta cargo',
	                        margin: '5 0 20 0',
							cls: 'tipo1'
	                    },{
							xtype: 'label',
							text: 'Datos Contacto',	
							style: 'font-weight:bold;font-size:12px',		        
						},
	                    {
	                        xtype: 'textfield',
	                        name : 'personaContacto',
	                        fieldLabel: 'Persona de Contacto',
	                         margin: '10 0 5 0',
							cls: 'tipo1'
	                    },
	                    {
	                        xtype: 'textfield',
	                        name : 'telefonoContacto',
	                        fieldLabel: 'Teléfono',
							cls: 'tipo1'
	                    },
	                    {
	                        xtype: 'textfield',
	                        name : 'emailContacto',
	                        fieldLabel: 'Email',
							cls: 'tipo1'
	                    },
	                    {
	                        xtype: 'textfield',
	                        name : 'paginaWeb',
	                        fieldLabel: 'Pagina Web',
							cls: 'tipo1'
	                    },
						{
							xtype: 'label',
							text: 'Datos baja',	
							style: 'font-weight:bold;font-size:12px',
							hidden: true,
							cls: 'tipo2'						
						},
						{
							xtype: 'textarea',
							name : 'motivoBaja',
							width: 400,
							hight: 150,
							fieldLabel: 'Motivo de la baja', 
							hidden: true,
							cls: 'tipo2',
							readOnly: true,
							margin: '10 0 5 0',
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
	         	]
	         	},
	         	,{
	         	xtype: 'panel',
	         	bodyPadding: 20,
	         	 border: false,	         	 

	         	items: [
	         		{
	         		xtype: 'label',
			        text: 'Departamento 1',	
			        style: 'font-weight:bold;font-size:12px',		        
	         		},
	         		{
	                        xtype: 'textfield',
	                        name : 'nombreDepartamento1',
	                        fieldLabel: 'Nombre',
	                        margin: '10 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'personaContactoDepartamento1',
	                        fieldLabel: 'Persona Contacto',
	                        margin: '5 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'emailDepartamento1',
	                        fieldLabel: 'Email',
	                        margin: '5 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'telefonoDepartamento1',
	                        fieldLabel: 'Telefono',
	                        margin: '5 0 20 20',
							cls: 'tipo1'
	                    	},
	                    	{
	         		xtype: 'label',
			        text: 'Departamento 2',	
			        style: 'font-weight:bold;font-size:12px'			        		        
	         		},
	         		{
	                        xtype: 'textfield',
	                        name : 'nombreDepartamento2',
	                        fieldLabel: 'Nombre',
	                        margin: '10 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'personaContactoDepartamento2',
	                        fieldLabel: 'Persona Contacto',
	                        margin: '5 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'emailDepartamento2',
	                        fieldLabel: 'Email',
	                        margin: '5 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'telefonoDepartamento2',
	                        fieldLabel: 'Telefono',
	                        margin: '5 0 20 20',
							cls: 'tipo1'
	                    	},
	                    	{
	         		xtype: 'label',
			        text: 'Departamento 3',	
			        style: 'font-weight:bold;font-size:12px',		        
	         		},
	         		{
	                        xtype: 'textfield',
	                        name : 'nombreDepartamento3',
	                        fieldLabel: 'Nombre',
	                        margin: '10 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'personaContactoDepartamento3',
	                        fieldLabel: 'Persona Contacto',
	                        margin: '5 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'emailDepartamento3',
	                        fieldLabel: 'Email',
	                        margin: '5 0 0 20',
							cls: 'tipo1'
	                    	},
	                    	{
	                        xtype: 'textfield',
	                        name : 'telefonoDepartamento3',
	                        fieldLabel: 'Telefono',
	                        margin: '5 0 0 20',
							cls: 'tipo1'
	                    	}
	         	]
	         	}
          	    ]
          	    },{   
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
						action: 'save',
						margin: '0 10 0 0',
						cls: 'tipo1'                			        	
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