Ext.define('AM.view.AltaMedicamento', {
	extend : 'Ext.form.Panel',
	alias : 'widget.altaMedicamento',
	title : 'Alta de Medicamento',
	autoScroll : true,
	url : "/AlbaControlador/altaMedicamento",
	layout : {
		type : 'vbox',
		padding : '5',
		align : 'left'
	},
	bodyPadding : 20,
	items : [ {
		xtype : 'label',
		text : 'Datos del medicamento',
		style : 'font-weight:bold;font-size:12px',
		padding : 10
	}, {
		xtype : 'textfield',
		name : 'nombreProveedor',
		fieldLabel : 'Nombre',
		allowBlank : false,
		regex : /^[A-Z0-9ü][a-z0-9ü_]{4,99}$/,
		msgTarget : 'under',
		invalidText : 'Campo obligatorio'
	}, {
		xtype : 'textareafield',
		name : 'finalidadMedicamento',
		fieldLabel : 'Finalidad medicamento',
		width : 400,
		regex : /^ [A-Za-z0-9_]{4,999}$/,
		msgTarget : 'under',
		invalidText : 'Caractéres: min 5, max 1000'
	}, {
		xtype : 'textareafield',
		name : 'componentes',
		fieldLabel : 'Componentes',
		width : 400,
		regex : /^ [A-Za-z0-9_]{4,999}$/,
		msgTarget : 'under',
		invalidText : 'Caractéres: min 5, max 1000'
	}, {
		xtype : 'textareafield',
		name : 'prospecto',
		fieldLabel : 'Prospecto',
		width : 400,
		regex : /^ [A-Za-z0-9_]{4,999}$/,
		msgTarget : 'under',
		invalidText : 'Caractéres: min 5, max 1000'
	}, {
		xtype : 'panel',
		bodyPadding : 20,
		border : false,
		items : [ {
			name : 'tipoDeAlarma',
			xtype : 'combo',
			fieldLabel : 'Tipo de alarma',
			store : 'ComboAM',
			queryMode : 'local',
			displayField : 'descripcion',
			valueField : 'valor',
			margin : '10 0 5 0',
			editable : false
		}, {
			xtype : 'textfield',
			name : 'stockMinimo',
			fieldLabel : 'Stock mínimo',
			regex : /^([0-9])*$/,
			msgTarget : 'under',
			invalidText : 'Valor inválido'
		}, {
			xtype : 'textfield',
			name : 'ubicacion',
			fieldLabel : 'Ubicación'
		}, {
			xtype : 'textfield',
			name : 'precio',
			fieldLabel : 'Precio(Euros)',
			regex : /^([0-9]+)(((\.)[0-9]+)?)$/,
			msgTarget : 'under',
			invalidText : 'Valor inválido, ejemplo; 12.5'
		}, {
			xtype : 'textfield',
			name : 'unidadesEnStock',
			fieldLabel : 'Unidades iniciales en stock',
			regex : /^([0-9])*$/,
			msgTarget : 'under',
			invalidText : 'Valor inválido'
		}, {
			name : 'descripcionUnidades',
			xtype : 'combo',
			fieldLabel : 'Descripción Unidades',
			store : 'ComboDescripcionUnidades',
			queryMode : 'local',
			displayField : 'descripcion',
			valueField : 'valor',
			editable : false
		}, {
			xtype : 'textfield',
			name : 'dosisRecomendadaKg',
			fieldLabel : 'Dosis recomendada/kg'
		}, {
			xtype : 'fieldcontainer',
			combineErrors : true,
			msgTarget : 'side',
			layout : 'hbox',
			margin : '25 0 10 0',
			defaults : {
				flex : 1,
				hideLabel : true
			},
			items : [ {
				xtype : 'button',
				text : 'Guardar',
				action : 'save',
				margin : '0 10 0 0',
				formBind : true
			}, {
				xtype : 'button',
				text : 'Cancelar',
				action : 'close',
				scope : this
			} ]
		} ]
	} ]
});