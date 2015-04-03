/**
 * Alta Medicamento
 */
Ext.define('AM.view.AltaMedicamento', {
	extend: 'Ext.form.Panel',    
	alias: 'widget.altaMedicamento',    											
	title: 'Alta de medicamento',
	autoScroll: true,
	url: "http://localhost:8080/AlbaControlador/altaMedicamento",
	layout: {
		type:'hbox',
		padding:'5',
		align:'left'
	},    	
	bodyPadding: 20,

	items: [   {
		xtype: 'panel',
		bodyPadding: 20,
		border: false,
		items: [
		        {//no sé como se pone que sea único 
		        	xtype: 'textfield',
		        	name : 'nombre',
		        	fieldLabel: 'Nombre',
		        	margin: '10 0 5 0',

		        	/*Permite letras minúsculas,mayúsculas, dígitos, 
		        	 * la u con diéresis y el subrayado (excepto en la primera posición). 
		        	 * Con un mínimo de cinco caracteres (1+4), y un máximo de 100 (1+99).*/
		        	regex: /^[A-Z0-9ü][a-z0-9ü_]{4,99}$/,
		        	msgTarget: 'under',
		        	invalidText: 'Campo obligatorio'
		        },
		        {
		        	xtype: 'textareafield',
		        	name : 'finalidadMedicamento',
		        	fieldLabel: 'Finalidad medicamento',
		        	width: 400,
		        	regex: /^ [A-Za-z0-9_]{4,999}$/,
		        	msgTarget: 'under',
		        	invalidText: 'Caractéres: min 5, max 1000'
		        },
		        {
		        	xtype: 'textareafield',
		        	name : 'componentes',
		        	fieldLabel: 'Componentes',
		        	width: 400,
		        	regex: /^ [A-Za-z0-9_]{4,999}$/,
		        	msgTarget: 'under',
		        	invalidText: 'Caractéres: min 5, max 1000'
		        },
		        {
		        	xtype: 'textareafield',
		        	name : 'prospecto',
		        	fieldLabel: 'Prospecto',
		        	width: 400,
		        	regex: /^ [A-Za-z0-9_]{4,999}$/,
		        	msgTarget: 'under',
		        	invalidText: 'Caractéres: min 5, max 1000'
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
		        	        	text: 'Aceptar',
		        	        	formBind: true,
		        	        	action: 'aceptar',
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
		        	name: 'tipoDeAlarma',
		        	xtype: 'combo',
		        	fieldLabel: 'Tipo de alarma',
		        	store: 'ComboAM',
		        	queryMode: 'local',
		        	displayField: 'descripcion',
		        	valueField: 'valor',
		        	margin: '10 0 5 0',
		        	editable: false
		        },
		        {
		        	xtype: 'textfield',
		        	name : 'stockMinimo',
		        	fieldLabel: 'Stock mínimo',
		        	regex: /^([0-9])*$/,
		        	msgTarget: 'under',
		        	invalidText: 'Valor inválido'
		        },
		        {
		        	xtype: 'textfield',
		        	name : 'ubicacion',
		        	fieldLabel: 'Ubicación'
		        },
		        {
		        	xtype: 'textfield',
		        	name : 'precio',
		        	fieldLabel: 'Precio(Euros)',
		        	regex: /^([0-9]+)(((\.)[0-9]+)?)$/,
		        	msgTarget: 'under',
		        	invalidText: 'Valor inválido, ejemplo; 12.5'
		        },
		        {
		        	xtype: 'textfield',
		        	name : 'unidadesEnStock',
		        	fieldLabel: 'Unidades iniciales en stock',
		        	regex: /^([0-9])*$/,
		        	msgTarget: 'under',
		        	invalidText: 'Valor inválido'
		        },
		        {	              
		        	name: 'descripcionUnidades',
		        	xtype: 'combo',
		        	fieldLabel: 'Descripción Unidades',
		        	store: 'ComboDescripcionUnidades',
		        	queryMode: 'local',
		        	displayField: 'descripcion',
		        	valueField: 'valor',					
		        	editable: false                    
		        },
		        {
		        	xtype: 'textfield',
		        	name : 'dosisRecomendadaKg',
		        	fieldLabel: 'Dosis recomendada/kg'
		        },

		        ]
	}	                    

	]       	   
});

