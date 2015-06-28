Ext.define('AM.controller.Ubicaciones', {
	extend : 'Ext.app.Controller',

	views : [ 'BajaUbicacion', 'GestionUbicacion' ],
	stores : [ 'AnimalesEnUbicacion', 'Ubicaciones' ],
	models : [ 'Ubicacion' ],

	init : function() {

		this.control({
			'altaUbicacion button[action=close]' : {
				click : this.cerrarPanelForm
			},
			'bajaUbicacion button[action=close]' : {
				click : this.cerrarPanelForm
			},
			'bajaUbicacion button[action=baja]' : {
				click : this.bajaUbicacion
			},
			'gestionUbicacion button[action=close]' : {
				click : this.salirGestionUbicaciones
			},
			'gestionUbicacion gridpanel[title=Ubicaciones]' : {
				itemclick : this.seleccionFila
			},
			'gestionUbicacion button[action=altaUbicacion]' : {
				click : this.AltaUbicacion
			},
			'gestionUbicacion button[action=bajaUbicacion]' : {
				click : this.PantallaBajaUbicacion
			}

		});
	},

	PantallaBajaUbicacion : function(button) {
		var view = Ext.widget('bajaUbicacion');
		console.log(seleccionUbicacion);
		view.loadRecord(seleccionUbicacion);
		irPantalla('gestionUbicacion', view);
	},
	cerrarPanelForm : function(button) {
		vueltaPantalla();
	},

	salirGestionUbicaciones : function(button) {
		vueltaPantallaRecarga(storeRecargar);
	},

	cerrarPanelSU : function(button) {
		var p = pantallaAnterior.pop();
		p.close();
		vueltaPantalla();
	},

	bajaUbicacion : function(button) {

		var form = button.up('form').getForm();
		var values = form.getValues();
		form.submit({
			waitMsg : 'En proceso...',
			success : function(form1, action) {
				Ext.Msg
						.alert('Alta realizada correctamente',
								action.result.msg);
				vueltaPantalla();
			},
			failure : function(form1, action) {
				Ext.Msg.alert('No se ha podido realizar el alta',
						action.result.msg);
			}
		});
	},

	AltaUbicacion : function(button) {

		var form = button.up('form').getForm();
		var values = form.getValues();
		form.submit({
			params : {
				accion : 'AltaUbicacion'
			},
			waitMsg : 'En proceso...',
			success : function(form1, action) {
				Ext.Msg
						.alert('Alta realizada correctamente',
								action.result.msg);
				Ext.StoreManager.lookup('Ubicaciones').load({
					params : values,
					scope : this
				});
				button.up('form').query(
						'textfield[name="nombreNuevaUbicacion"]')[0].reset();
			},
			failure : function(form1, action) {
				Ext.Msg.alert('No se ha podido realizar el alta',
						action.result.msg);
			}
		});
	},

	seleccionFila : function(grid, record) {
		console.log('Fila seleccionada');
		seleccionUbicacion = record;
		console.log(seleccionUbicacion.data);
		Ext.StoreManager.lookup('AnimalesEnUbicacion').load({
			params : seleccionUbicacion.data,
			scope : this
		});

	}

});