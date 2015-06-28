Ext
.define(
		'AM.controller.Animales',
		{
			extend : 'Ext.app.Controller',

			views : [ 'AltaAnimal', 'ConsultaAnimal',
			          'CambioUbicacionAnimal', 'AltaEspecie',
			          'AltaPesoAnimal', 'DetalleAnimal',
			          'ModificarAnimal', 'CambioEstado',
			          'ActualizarImagenAnimal',
			          'AsignarPatrocinadorAnimal' ],
			          stores : [ 'Especies', 'Animales', 'HistoricoPesos',
			                     'HistoricoUbicaciones', 'ComboSN', 'ComboHM',
			                     'ComboTM', 'CriteriosBusquedaAnimal', 'ComboTI',
			                     'ResultadoBusquedaAnimales',
			                     'ResultadoBusquedaInstitucionPersona',
			                     'CriteriosBusquedaPersonaInstitucion',
			                     'EstadosAnimal' ],
			                     models : [ 'Especie', 'Animal', 'Ubicacion',
			                                'HistoricoPeso', 'HistoricoUbicacion', 'Combo',
			                                'ResultadoBusquedaAnimales' ],

			                                init : function() {
			                                	this
			                                	.control({
			                                		'altaAnimal button[action=siguiente]' : {
			                                			click : this.salvarAlta
			                                		},
			                                		'altaAnimal button[action=altaEspecie]' : {
			                                			click : this.altaEspecie
			                                		},
			                                		'altaAnimal combo[name=especie]' : {
			                                			change : this.cambioComboEspecie
			                                		},
			                                		'altaAnimal button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'altaAnimal button[action=masInfo]' : {
			                                			click : this.masInfoAltaAnimal
			                                		},
			                                		'altaAnimal button[action=modPatrocinador]' : {
			                                			click : this.modificarPatrocinador
			                                		},
			                                		'historicoUbicaciones button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'altaPesoAnimal button[action=modificar]' : {
			                                			click : this.cambiarPesoAnimal
			                                		},
			                                		'altaPesoAnimal button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'cambioEstado button[action=cambiarEstado]' : {
			                                			click : this.cambiarEstadoAnimal
			                                		},
			                                		'cambioEstado button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'detalleAnimal button[action=historicoPesos]' : {
			                                			click : this.mostrarHistoricoPesos
			                                		},
			                                		'detalleAnimal button[action=historicoUbicaciones]' : {
			                                			click : this.mostrarHistoricoUbicaciones
			                                		},
			                                		'detalleAnimal button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'detalleAnimal button[action=masInfo]' : {
			                                			click : this.masInfoDetalleAnimal
			                                		},
			                                		'altaAnimal button[action=busquedaUbicacion]' : {
			                                			click : this.pantallaBusquedaUbicacion
			                                		},
			                                		'consultaAnimal button[action=buscar]' : {
			                                			click : this.buscarAnimal
			                                		},
			                                		'consultaAnimal button[action=detalle]' : {
			                                			click : this.detalleAnimal
			                                		},
			                                		'consultaAnimal button[action=modificar]' : {
			                                			click : this.modificarAnimal
			                                		},
			                                		'consultaAnimal button[action=cambioUbicacion]' : {
			                                			click : this.PantallaCambioUbicacionAnimal
			                                		},
			                                		'consultaAnimal button[action=modificarPeso]' : {
			                                			click : this.PantallaCambioPesoAnimal
			                                		},
			                                		'consultaAnimal button[action=cambioEstado]' : {
			                                			click : this.PantallaCambioEstadoAnimal
			                                		},
			                                		'consultaAnimal combo[name=criterioBusqueda]' : {
			                                			change : this.CambioCriterioSeleccion
			                                		},
			                                		'modificarAnimal button[action=guardar]' : {
			                                			click : this.salvarModificacion
			                                		},
			                                		'modificarAnimal button[action=PantallaActualizacionImagen]' : {
			                                			click : this.PantallaActualizacionImagen
			                                		},
			                                		'modificarAnimal button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'modificarAnimal button[action=altaEspecie]' : {
			                                			click : this.altaEspecieModificacion
			                                		},
			                                		'modificarAnimal button[action=masInfo]' : {
			                                			click : this.masInfoModificacionAnimal
			                                		},
			                                		'modificarAnimal button[action=modPatrocinador]' : {
			                                			click : this.modificarModPatrocinador
			                                		},
			                                		'cambioUbicacionAnimal button[action=buscar]' : {
			                                			click : this.buscarInstitucionUbicacion
			                                		},
			                                		'cambioUbicacionAnimal textfield[name=textoBusqueda]' : {
			                                			change : this.buscarInstitucionUbicacion
			                                		},
			                                		'cambioUbicacionAnimal textfield[name=textoBusquedaUbicacion]' : {
			                                			change : this.filtrarUbicacion
			                                		},
			                                		'cambioUbicacionAnimal gridpanel[name=ResultadoBusquedaInstitucionPersona]' : {
			                                			itemclick : this.seleccionFilaBusqueda
			                                		},
			                                		'cambioUbicacionAnimal gridpanel[name=Ubicacion]' : {
			                                			itemclick : this.seleccionFilaUbicaciones
			                                		},
			                                		'cambioUbicacionAnimal button[action=cambioUbicacion]' : {
			                                			click : this.cambioUbicacionAnimal
			                                		},
			                                		'cambioUbicacionAnimal button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'altaEspecie button[action=save]' : {
			                                			click : this.salvarEspecie
			                                		},
			                                		'altaEspecie button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'actualizarImagenAnimal button[action=actualizarImagen]' : {
			                                			click : this.actualizarImagen
			                                		},
			                                		'actualizarImagenAnimal button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'asignarPatrocinadorAnimal button[action=close]' : {
			                                			click : this.cerrarPanelForm
			                                		},
			                                		'asignarPatrocinadorAnimal button[action=aceptar]' : {
			                                			click : this.aceptarAsignarpatrocinador
			                                		},
			                                		'asignarPatrocinadorAnimal button[action=sinPatrocinador]' : {
			                                			click : this.cerrarSinPatrocinador
			                                		},
			                                		'asignarPatrocinadorAnimal gridpanel[name=ResBusquedaInstPersPatrocinador]' : {
			                                			itemclick : this.seleccionFilaPatrocinadores
			                                		},
			                                		'asignarPatrocinadorAnimal textfield[name=textoBusqueda]' : {
			                                			change : this.buscarPatrocinador
			                                		},

			                                	});
			                                },

			                                aceptarAsignarpatrocinador : function(button) {
			                                	var seleccion = button
			                                	.up('asignarPatrocinadorAnimal')
			                                	.query(
			                                	'gridpanel[name="ResBusquedaInstPersPatrocinador"]')[0]
			                                	.getSelectionModel().getLastSelected();
			                                	if (seleccion.get('tipoResultado') == "Persona") {
			                                		damePantallaAnterior().query(
			                                		'textfield[name="textoPatrocinador"]')[0]
			                                		.setValue(seleccion.get('nombrePersona')
			                                				+ " " + seleccion.get('apellidos'));
			                                		damePantallaAnterior().query(
			                                		'hiddenfield[name="idPatrocinador"]')[0]
			                                		.setValue(seleccion.get('idPersona'));
			                                	} else {
			                                		damePantallaAnterior().query(
			                                		'textfield[name="textoPatrocinador"]')[0]
			                                		.setValue(seleccion
			                                				.get('nombreInstitucion'));
			                                		damePantallaAnterior().query(
			                                		'hiddenfield[name="idPatrocinador"]')[0]
			                                		.setValue(seleccion
			                                				.get('nombreInstitucion'));
			                                	}
			                                	damePantallaAnterior().query(
			                                	'textfield[name="txtMuestraMasInfo"]')[0]
			                                	.setValue(seleccion.get('info'));
			                                	damePantallaAnterior().query(
			                                	'hiddenfield[name="tipoPatrocinador"]')[0]
			                                	.setValue(seleccion.get('tipoResultado'));
			                                	vueltaPantalla();
			                                },
			                                cerrarSinPatrocinador : function(button) {
			                                	damePantallaAnterior().query(
			                                	'textfield[name="textoPatrocinador"]')[0]
			                                	.setValue('');
			                                	damePantallaAnterior().query(
			                                	'textfield[name="txtMuestraMasInfo"]')[0]
			                                	.setValue('');
			                                	damePantallaAnterior().query(
			                                	'hiddenfield[name="tipoPatrocinador"]')[0]
			                                	.setValue('');
			                                	damePantallaAnterior().query(
			                                	'hiddenfield[name="idPatrocinador"]')[0]
			                                	.setValue('');

			                                	vueltaPantalla();
			                                },
			                                seleccionFilaPatrocinadores : function(grid, record) {
			                                	grid.up('asignarPatrocinadorAnimal').query(
			                                	'button[action="aceptar"]')[0].enable();
			                                },
			                                buscarPatrocinador : function(txt) {
			                                	var form = txt.up('form');
			                                	Ext.StoreManager.lookup(
			                                	'ResultadoBusquedaInstitucionPersona').load({
			                                		params : form.getValues(),
			                                		scope : this
			                                	});
			                                	txt.up('asignarPatrocinadorAnimal').query(
			                                	'button[action="aceptar"]')[0].disable();

			                                },
			                                modificarPatrocinador : function(button) {
			                                	var view = Ext.widget('asignarPatrocinadorAnimal');
			                                	irPantalla('altaAnimal', view);
			                                },
			                                modificarModPatrocinador : function(button) {
			                                	var view = Ext.widget('asignarPatrocinadorAnimal');
			                                	irPantalla('modificarAnimal', view);
			                                },
			                                cambioComboEspecie : function(combo, records, eOpts) {
			                                	var valor = combo.getValue();
			                                	var txtRaza = combo.up('form').down(
			                                	'textfield[name=raza]');
			                                	if (txtRaza.getValue() != "") {
			                                		if (valor == "GATO") {
			                                			txtRaza.setValue('COMUN EUROPEO');
			                                		} else {
			                                			if (valor == "PERRO") {
			                                				txtRaza.setValue('MESTIZO');
			                                			}
			                                		}
			                                	}
			                                },
			                                masInfoAltaAnimal : function(button) {
			                                	var txtMasInfo = button.up('form').query(
			                                	'textfield[name=txtMuestraMasInfo]')[0];
			                                	if (txtMasInfo.isVisible()) {
			                                		txtMasInfo.setVisible(false);
			                                	} else {
			                                		txtMasInfo.setVisible(true);
			                                	}
			                                },
			                                masInfoModificacionAnimal : function(button) {
			                                	var txtMasInfo = button.up('form').query(
			                                	'textfield[name=txtMuestraMasInfo]')[0];
			                                	if (txtMasInfo.isVisible()) {
			                                		txtMasInfo.setVisible(false);
			                                	} else {
			                                		txtMasInfo.setVisible(true);
			                                	}
			                                },
			                                masInfoDetalleAnimal : function(button) {
			                                	var txtMasInfo = button.up('form').query(
			                                	'textfield[name=txtMuestraMasInfo]')[0];
			                                	if (txtMasInfo.isVisible()) {
			                                		txtMasInfo.setVisible(false);
			                                	} else {
			                                		txtMasInfo.setVisible(true);
			                                	}
			                                },
			                                actualizarImagen : function(button) {

			                                	var form = button.up('form').getForm();
			                                	form.submit({
			                                		waitMsg : 'En proceso...',
			                                		success : function(form, action) {
			                                			Ext.Msg.alert(
			                                					'Modificaci�n realizada correctamente',
			                                					action.result.msg);
			                                			vueltaPantalla();
			                                		},
			                                		failure : function(form, action) {
			                                			Ext.Msg.alert('Error en la modificaci�n',
			                                					action.result.msg);
			                                		}
			                                	});

			                                },

			                                salvarAlta : function(button) {
			                                	var form = button.up('form').getForm();
			                                	console.log(form.getValues());
			                                	form.submit({
			                                		waitMsg : 'En proceso...',
			                                		success : function(form1, action) {
			                                			Ext.Msg.alert('Alta realizada correctamente',
			                                					action.result.msg);
			                                			var view = Ext.widget('cambioUbicacionAnimal');
			                                			var values = form.getValues();
			                                			var id = action.result.id;
			                                			Ext.StoreManager.lookup(
			                                			'ResultadoBusquedaInstitucionPersona')
			                                			.load({
			                                				params : {
			                                					textoBusqueda : "ALBA"
			                                				},
			                                				scope : this
			                                			});
			                                			Ext.StoreManager.lookup('Ubicaciones').load({
			                                				params : {
			                                					nombreInstitucion : "ALBA"
			                                				},
			                                				scope : this
			                                			});
			                                			Ext.StoreManager.lookup('AnimalesEnUbicacion')
			                                			.removeAll();
			                                			values['id'] = id;
			                                			view.loadRecord(new AM.model.Animal(values));
			                                			irPantallaSinGuardar('altaAnimal', view);
			                                		},
			                                		failure : function(form, action) {
			                                			Ext.Msg.alert(
			                                					'No se ha podido realizar el alta',
			                                					action.result.msg);
			                                		}
			                                	});

			                                },

			                                salvarModificacion : function(button) {
			                                	var form = button.up('form').getForm();
			                                	console.log(form.getValues());
			                                	form
			                                	.submit({
			                                		waitMsg : 'En proceso...',
			                                		success : function(form, action) {
			                                			Ext.Msg
			                                			.alert(
			                                					'Modificaci�n realizada correctamente',
			                                					action.result.msg);
			                                			vueltaPantallaRecarga('ResultadoBusquedaGeneral');
			                                		},
			                                		failure : function(form, action) {
			                                			Ext.Msg
			                                			.alert(
			                                					'No se ha podido realizar el alta',
			                                					action.result.msg);
			                                		}
			                                	});

			                                },

			                                cambiarPesoAnimal : function(button) {
			                                	var form = button.up('form').getForm();
			                                	console.log(form.getValues());
			                                	form
			                                	.submit({
			                                		waitMsg : 'En proceso...',
			                                		success : function(form, action) {
			                                			Ext.Msg
			                                			.alert(
			                                					'Cambio peso realizado correctamente',
			                                					action.result.msg);
			                                			vueltaPantallaRecarga('ResultadoBusquedaGeneral');
			                                		},
			                                		failure : function(form, action) {
			                                			Ext.Msg
			                                			.alert(
			                                					'No se ha podido realizar el cambio',
			                                					action.result.msg);
			                                		}
			                                	});

			                                },

			                                cambiarEstadoAnimal : function(button) {
			                                	var form = button.up('form').getForm();
			                                	console.log(form.getValues());
			                                	form
			                                	.submit({
			                                		waitMsg : 'En proceso...',
			                                		success : function(form, action) {
			                                			Ext.Msg
			                                			.alert(
			                                					'Cambio peso realizado correctamente',
			                                					action.result.msg);
			                                			vueltaPantallaRecarga('ResultadoBusquedaGeneral');
			                                		},
			                                		failure : function(form, action) {
			                                			Ext.Msg
			                                			.alert(
			                                					'No se ha podido realizar el cambio',
			                                					action.result.msg);
			                                		}
			                                	});

			                                },

			                                buscarAnimal : function(button) {
			                                	var form = button.up('form').getForm();
			                                	console.log(form.getValues());

			                                	Ext.StoreManager.lookup('ResultadoBusquedaAnimales')
			                                	.load({
			                                		params : form.getValues(),
			                                		scope : this
			                                	});

			                                },

			                                detalleAnimal : function(button) {
			                                	var view = Ext.widget('detalleAnimal');
			                                	view.loadRecord(button.up('consultaAnimal').query(
			                                	'gridpanel')[0].getSelectionModel()
			                                	.getLastSelected());
			                                	irPantalla('consultaAnimal', view);

			                                },

			                                modificarAnimal : function(button) {
			                                	var view = Ext.widget('modificarAnimal');
			                                	view.loadRecord(button.up('consultaAnimal').query(
			                                	'gridpanel')[0].getSelectionModel()
			                                	.getLastSelected());
			                                	irPantalla('consultaAnimal', view);
			                                },

			                                PantallaActualizacionImagen : function(button) {
			                                	var view = Ext.widget('actualizarImagenAnimal');
			                                	view.loadRecord(button.up('form').getRecord());
			                                	irPantalla('modificarAnimal', view);
			                                },

			                                PantallaCambioUbicacionAnimal : function(button) {
			                                	var view = Ext.widget('cambioUbicacionAnimal');
			                                	view.loadRecord(button.up('consultaAnimal').query(
			                                	'gridpanel')[0].getSelectionModel()
			                                	.getLastSelected());
			                                	irPantalla('consultaAnimal', view);
			                                },

			                                PantallaCambioPesoAnimal : function(button) {
			                                	var view = Ext.widget('altaPesoAnimal');
			                                	view.loadRecord(button.up('consultaAnimal').query(
			                                	'gridpanel')[0].getSelectionModel()
			                                	.getLastSelected());
			                                	irPantalla('consultaAnimal', view);
			                                },

			                                PantallaCambioEstadoAnimal : function(button) {
			                                	var view = Ext.widget('cambioEstado');
			                                	view.loadRecord(button.up('consultaAnimal').query(
			                                	'gridpanel')[0].getSelectionModel()
			                                	.getLastSelected());
			                                	irPantalla('consultaAnimal', view);
			                                },

			                                seleccionFilaBusqueda : function(grid, record) {
			                                	grid.up('cambioUbicacionAnimal').query(
			                                	'textfield[name="textoBusquedaUbicacion"]')[0]
			                                	.setValue('');
			                                	Ext.StoreManager.lookup('Ubicaciones').load({
			                                		params : record.data,
			                                		scope : this
			                                	});

			                                	grid.up('cambioUbicacionAnimal').query(
			                                	'button[action="cambioUbicacion"]')[0]
			                                	.disable();

			                                },

			                                seleccionFilaUbicaciones : function(grid, record) {
			                                	console.log(record);
			                                	Ext.StoreManager.lookup('AnimalesEnUbicacion').load({
			                                		params : record.data,
			                                		scope : this
			                                	});
			                                	grid.up('form').query(
			                                	'button[action="cambioUbicacion"]')[0].enable();

			                                },

			                                cerrarPanelForm : function(button) {
			                                	vueltaPantalla();
			                                },

			                                cambioUbicacionAnimal : function(button) {
			                                	var idAnimal = button.up('cambioUbicacionAnimal')
			                                	.query('hiddenfield[name="id"]')[0].getValue();
			                                	var data = button.up('cambioUbicacionAnimal').query(
			                                	'gridpanel[name=Ubicacion]')[0]
			                                	.getSelectionModel().getLastSelected().data;

			                                	data.id = idAnimal;
			                                	Ext.Ajax
			                                	.request({
			                                		url : "http://localhost:8080/AlbaControlador/cambioUbicacionAnimal",
			                                		params : data,
			                                		success : function(form, action) {
			                                			Ext.Msg
			                                			.alert('Cambio Ubicacion realizado correctamente');
			                                			vueltaPantallaRecarga('ResultadoBusquedaGeneral');
			                                		},
			                                		failure : function(form, action) {
			                                			Ext.Msg
			                                			.alert('No se ha podido realizar el cambio');
			                                		}
			                                	});
			                                },

			                                salvarEspecie : function(button) {

			                                	var form = button.up('form').getForm();
			                                	form.submit({
			                                		waitMsg : 'En proceso...',
			                                		success : function(form, action) {
			                                			Ext.Msg.alert('Alta realizada correctamente',
			                                					action.result.msg);
			                                			Ext.StoreManager.lookup('Especies').load();
			                                			vueltaPantalla();
			                                		},
			                                		failure : function(form, action) {
			                                			Ext.Msg.alert(
			                                					'No se ha podido realizar el alta',
			                                					action.result.msg);
			                                		}
			                                	});

			                                },

			                                altaEspecie : function(button) {
			                                	var view = Ext.widget('altaEspecie');
			                                	irPantalla('altaAnimal', view);
			                                },

			                                altaEspecieModificacion : function(button) {
			                                	var view = Ext.widget('altaEspecie');
			                                	irPantalla('modificarAnimal', view);
			                                },

			                                mostrarHistoricoPesos : function(button) {
			                                	var items = button.up('form').query(
			                                	'gridpanel[name="tablaPesos"]');
			                                	for (var i = 0, l = items.length; i < l; i++) {
			                                		var componente = items[i];
			                                		if (componente.hidden == true) {
			                                			componente.show();
			                                			var form = button.up('form').getForm();
			                                			console.log(form.getValues());
			                                			Ext.StoreManager.lookup('HistoricoPesos').load(
			                                					{
			                                						params : form.getValues(),
			                                						scope : this
			                                					});
			                                		} else {
			                                			componente.hide();
			                                		}
			                                	}

			                                },

			                                mostrarHistoricoUbicaciones : function(button) {
			                                	var items = button.up('form').query(
			                                	'gridpanel[name="tablaUbicaciones"]');
			                                	for (var i = 0, l = items.length; i < l; i++) {
			                                		var componente = items[i];
			                                		if (componente.hidden == true) {
			                                			componente.show();
			                                			var form = button.up('form').getForm();
			                                			console.log(form.getValues());
			                                			Ext.StoreManager.lookup('HistoricoUbicaciones')
			                                			.load({
			                                				params : form.getValues(),
			                                				scope : this
			                                			});
			                                		} else {
			                                			componente.hide();
			                                		}
			                                	}
			                                },

			                                pantallaBusquedaUbicacion : function(button) {

			                                	var view = Ext.widget('consultaInstitucion');

			                                	var items = view.query('button[cls="consulta"]');
			                                	for (var i = 0, l = items.length; i < l; i++) {
			                                		items[i].hide();
			                                	}

			                                	irPantalla('altaAnimal', view);

			                                },

			                                buscarInstitucionUbicacion : function(button) {
			                                	var form = button.up('form');
			                                	Ext.StoreManager.lookup(
			                                	'ResultadoBusquedaInstitucionPersona').load({
			                                		params : form.getValues(),
			                                		scope : this
			                                	});

			                                	button.up('cambioUbicacionAnimal').query(
			                                	'textfield[name="textoBusquedaUbicacion"]')[0]
			                                	.setValue('');
			                                	Ext.StoreManager.lookup('Ubicaciones').removeAll();
			                                	Ext.StoreManager.lookup('AnimalesEnUbicacion')
			                                	.removeAll();
			                                	button.up('cambioUbicacionAnimal').query(
			                                	'button[action="cambioUbicacion"]')[0]
			                                	.disable();

			                                },

			                                filtrarUbicacion : function(textfield) {
			                                	var selection = textfield
			                                	.up('cambioUbicacionAnimal')
			                                	.query(
			                                	'gridpanel[name="ResultadoBusquedaInstitucionPersona"]')[0]
			                                	.getSelectionModel();
			                                	if (!selection.hasSelection()) {
			                                		selection.select(0, false, true);
			                                	}
			                                	var record = textfield
			                                	.up('cambioUbicacionAnimal')
			                                	.query(
			                                	'gridpanel[name="ResultadoBusquedaInstitucionPersona"]')[0]
			                                	.getSelectionModel().getLastSelected().data;
			                                	record['textoBusquedaUbicacion'] = textfield.getValue();
			                                	Ext.StoreManager.lookup('Ubicaciones').load({
			                                		params : record,
			                                		scope : this
			                                	});
			                                	record['textoBusquedaUbicacion'] = '';
			                                	Ext.StoreManager.lookup('AnimalesEnUbicacion')
			                                	.removeAll();
			                                	button.up('cambioUbicacionAnimal').query(
			                                	'button[action="cambioUbicacion"]')[0]
			                                	.disable();

			                                },

			                                CambioCriterioSeleccion : function(newValue, oldValue) {

			                                	var valor = newValue.getValue();
			                                	var items = newValue.up('form')
			                                	.query('textfield,combo');
			                                	for (var i = 0, l = items.length; i < l; i++) {
			                                		var cls = items[i].cls;
			                                		if (cls == "mostrar" || cls == valor) {
			                                			items[i].show();
			                                		} else {
			                                			items[i].hide();
			                                		}
			                                	}
			                                },

			                                CambioCriterioSeleccionPI : function(newValue, oldValue) {
			                                	var form = newValue.up('form');
			                                	form.query('fieldcontainer[name=BuscarIP]')[0].show();
			                                	form.query('fieldcontainer[name=instituciones]')[0]
			                                	.hide();
			                                	form.query('fieldcontainer[name=personas]')[0].hide();
			                                	form.query('button[action="cambioUbicacion"]')[0]
			                                	.disable();
			                                }

		});