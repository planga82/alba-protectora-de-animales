Ext.define('AM.controller.Personas', {
	extend : 'Ext.app.Controller',

	views : [ 'AltaPersona', 'ConsultaPersona', 'CambioEstadoPersona' ],
	stores : [ 'Personas', 'EstadosPersona' ],
	models : [ 'Persona' ],

	init : function() {

		this.control({
			'altaPersona button[action=close]' : {
				click : this.cerrarPanelForm
			},
			'altaPersona button[action=save]' : {
				click : this.altaPersona
			},
			'cambioEstadoPersona button[action=close]' : {
				click : this.cerrarPanelForm
			},
			'cambioEstadoPersona button[action=cambioEstado]' : {
				click : this.cambioEstadoPersona
			},
			'consultaPersona button[action=buscar]' : {
				click : this.buscarPersona
			},

			'consultaPersona button[action=detalle]' : {
				click : this.PantallaDetallePersona
			},
			'consultaPersona gridpanel' : {
				itemclick : this.seleccionFila1
			},
			'consultaPersona button[action=modificar]' : {
				click : this.PantallaModificarPersona
			},
			'consultaPersona button[action=cambioEstado]' : {
				click : this.PantallaCambioEstadoPersona
			},
			'consultaPersona button[action=ubicaciones]' : {
				click : this.PantallaGestionUbicacion1
			}

		});
	},

	altaPersona : function(button) {
		var form1 = button.up('form').getForm();
		form1.submit({
			waitMsg : 'En proceso...',
			success : function(form, action) {
				Ext.Msg
						.alert('Alta realizada correctamente',
								action.result.msg);
				vueltaPantallaRecarga('ResultadoBusquedaGeneral');
			},
			failure : function(form, action) {
				Ext.Msg.alert('No se ha podido realizar el alta',
						action.result.msg);
			}
		});
	},

	cambioEstadoPersona : function(button) {
		var form = button.up('form').getForm();
		form.submit({
			waitMsg : 'En proceso...',
			success : function(form, action) {
				Ext.Msg.alert('Cambio realizado correctamente',
						action.result.msg);
				vueltaPantallaRecarga('ResultadoBusquedaGeneral');
			},
			failure : function(form, action) {
				Ext.Msg.alert('No se ha podido realizar el alta',
						action.result.msg);
			}
		});
	},

	buscarPersona : function(button) {
		var form = button.up('form').getForm();
		console.log(form.getValues());

		Ext.StoreManager.lookup('ResultadoBusquedaPersonas').load({
			params : form.getValues(),
			scope : this
		});
	},

	PantallaGestionUbicacion1 : function(button) {

		var view = Ext.widget('gestionUbicacion');

		var items = view.query('textfield[cls="Tipo1"]');
		for (var i = 0, l = items.length; i < l; i++) {
			items[i].hide();
		}

		Ext.StoreManager.lookup('Ubicaciones').load(
				{
					params : button.up('consultaPersona').query('gridpanel')[0]
							.getSelectionModel().getLastSelected().data,
					scope : this
				});

		items = view.query('gridpanel[name="AnimalesUbicacion"]');
		items[0].getStore().removeAll();

		view.loadRecord(button.up('consultaPersona').query('gridpanel')[0]
				.getSelectionModel().getLastSelected());

		irPantalla('consultaPersona', view);

	},
	PantallaCambioEstadoPersona : function(button) {
		var view = Ext.widget('cambioEstadoPersona');
		view.loadRecord(button.up('consultaPersona').query('gridpanel')[0]
				.getSelectionModel().getLastSelected());
		irPantalla('consultaPersona', view);
	},
	PantallaDetallePersona : function(button) {
		var view = Ext.widget('altaPersona');

		view.title = 'Detalle Persona';

		// Configuramos la pantalla antes de abrirla
		var items = view.query('component[cls="tipo1"]');
		for (var i = 0, l = items.length; i < l; i++) {
			items[i].readOnly = true;
		}

		items = view.query('button[cls="tipo1"]');
		for (var i = 0, l = items.length; i < l; i++) {
			items[i].hide();
		}

		var estado = button.up('consultaPersona').query('gridpanel')[0]
				.getSelectionModel().getLastSelected().getData().estado;
		if (estado == 'BAJA') {
			items = view.query('component[cls="tipo2"]');
			for (var i = 0, l = items.length; i < l; i++) {
				items[i].show();
			}
		}
		view.loadRecord(button.up('consultaPersona').query('gridpanel')[0]
				.getSelectionModel().getLastSelected());
		irPantalla('consultaPersona', view);

	},
	PantallaModificarPersona : function(button) {
		var view = Ext.widget('altaPersona');
		var items = view.query('component[name="accion"]');
		items[0].setValue('modificacion');
		view.loadRecord(button.up('consultaPersona').query('gridpanel')[0]
				.getSelectionModel().getLastSelected());
		view.title = 'Modificar Persona';

		storeRecargar = 'ResultadoBusquedaPersonas';
		irPantalla('consultaPersona', view);
	},

	seleccionFila1 : function(grid, record) {
		var panel = grid.up('consultaPersona');
		var estado = record.getData().estado;
		if (estado == 'BAJA') {
			panel.query('button[action="modificar"]')[0].setDisabled(true);
			panel.query('button[action="ubicaciones"]')[0].setDisabled(true);
		} else {
			panel.query('button[action="modificar"]')[0].setDisabled(false);
			panel.query('button[action="ubicaciones"]')[0].setDisabled(false);
		}
	},

	cerrarPanelForm : function(button) {
		vueltaPantalla();
	}

});