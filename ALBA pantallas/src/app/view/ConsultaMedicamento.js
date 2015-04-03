/**
 * Views. ConsultaMedicamento
 */
Ext.define('AM.view.ConsultaMedicamento', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.consultaMedicamento',
	title : 'Consulta de medicamento',

	items : [ {
		xtype : 'panel',

		bodyPadding : 20,
		width : 600,
		items : [ {
			xtype : 'form',
			bodyPadding : 10,

			items : [ {
				name : 'criterioBusqueda',
				xtype : 'combo',
				fieldLabel : 'Criterio Busqueda',
				store : 'CriteriosBusquedaMedicamento',
				queryMode : 'local',
				displayField : 'descripcion',
				valueField : 'valor',
				editable : false,
				cls : 'mostrar',
				value : 'TB'/*TB-texto búsqueda*/
			}, {
				name : 'descripcionUnidades',
				xtype : 'combo',
				fieldLabel : 'Descripción de Unidades',
				store : 'ComboDU',
				queryMode : 'local',
				displayField : 'descripcion',
				valueField : 'valor',
				editable : false,
				cls : 'CP',/*aquí a voleo, CP viene de comprimidos*/
				hidden : true
			}, {
				name : 'tipoDeAlarma',
				xtype : 'combo',
				fieldLabel : 'Tipo de alarma',
				store : 'ComboTA',
				queryMode : 'local',
				displayField : 'descripcion',
				valueField : 'valor',
				editable : false,
				cls : 'TA',/*TA - tipo de alarma*/
				hidden : true
			},

			{
				name : 'textoBusqueda',
				xtype : 'textfield',
				fieldLabel : 'Texto a buscar',
				width : 400,
				cls : 'TB',
				hidden : false
			},

			],
			buttons : [ {
				text : 'Buscar',
				action : 'buscar'
			} ]
		}

		]
	}, {
		xtype : 'gridpanel',
		height : 300,
		width : 600,
		store : 'ResultadoBusquedaMedicamentos',
		columns : [ {
			text : 'Nombre',
			width : 150,
			dataIndex : 'nombre'
		}, {
			text : 'Descripcion',
			width : 450,
			dataIndex : 'descripcionResultado'
		} ]

	}, {
		xtype : 'panel',
		bodyPadding : 0,
		width : 600,
		items : [ {
			xtype : 'fieldcontainer',

			items : [ {
				xtype : 'button',
				text : 'Detalle',
				margin : '5 5 5 5',
				action : 'detalle'
			},

			{
				xtype : 'button',
				text : 'Cambio ubicacion',
				margin : '5 5 5 5',
				action : 'cambioUbicacion'
			},

			]
		} ]
	} ]
});