/**
 * Views. Detalle Medicamento
 */
Ext.define('AM.view.DetalleMedicamento', {
	extend : 'Ext.form.Panel',
	alias : 'widget.detalleMedicamento',
	title : 'Detalle de medicamento',
	autoScroll : true,
	layout : {
		type : 'vbox',
		padding : '5',
		align : 'left'
	},
	bodyPadding : 5,

	items : [ {
		xtype : 'panel',
		header : false,
		width : 150,
		height : 150,
		layout : 'fit',
		margin : '0 0 0 0',

	}, {
		xtype : 'panel',
		bodyPadding : 20,
		border : false,
		layout : {
			type : 'hbox',
			padding : '5',
			align : 'left'
		},
		items : [ {
			xtype : 'panel',
			bodyPadding : 20,
			border : false,
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			},

			{
				xtype : 'textfield',
				name : 'nombre',
				fieldLabel : 'Nombre',
				margin : '10 0 5 0',
				readOnly : true
			}, {
				xtype : 'textareafield',
				name : 'finalidadMedicamento',
				fieldLabel : 'Finalidad Medicamento',
				readOnly : true
			}, {
				xtype : 'textareafield',
				name : 'componentes',
				fieldLabel : 'Componentes',
				readOnly : true
			}, {
				xtype : 'textareafield',
				name : 'prospecto',
				fieldLabel : 'Prospecto',
				width : 400,
				readOnly : true
			},

			]
		}, {
			name : 'tipoDeAlarma',
			xtype : 'combo',
			fieldLabel : 'Tipo de alarma',
			store : 'ComboTA',
			queryMode : 'local',
			displayField : 'descripcion',
			valueField : 'valor',
			editable : false,
			readOnly : true
		}, {
			xtype : 'textfield',
			name : 'stockMinimo',
			fieldLabel : 'Stock Minimo',
			margin : '10 0 5 0',
			readOnly : true
		}, {
			xtype : 'textfield',
			name : 'ubicacion',
			fieldLabel : 'Ubicación',
			margin : '10 0 5 0',
			readOnly : true
		}, {
			xtype : 'textfield',
			name : 'precio',
			fieldLabel : 'Precio',
			margin : '10 0 5 0',
			readOnly : true
		}, {
			xtype : 'textfield',
			name : 'unidadesEnStock',
			fieldLabel : 'Unidades en stock',
			margin : '10 0 5 0',
			readOnly : true
		}, {
			xtype : 'textfield',
			name : 'dosisRecomendadaKg',
			fieldLabel : 'Dosis recomendada Kg',
			margin : '10 0 5 0',
			readOnly : true
		}, {
			name : 'descripcionUnidades',
			xtype : 'combo',
			fieldLabel : 'Descripcion unidades',
			store : 'ComboDU',
			queryMode : 'local',
			displayField : 'descripcion',
			valueField : 'valor',
			editable : false,
			readOnly : true
		},

		]
	},

	{
		xtype : 'button',
		text : 'Salir',
		action : 'close',
		scope : this,
		margin : '20 0 0 0'
	}

	]

});