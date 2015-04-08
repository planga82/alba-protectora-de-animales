/**
 * Medicamentos. Controller
 */
Ext
		.define(
				'AM.controller.Medicamentos',
				{
					extend : 'Ext.app.Controller',

					views : [ 'AltaMedicamento', 'ConsultaMedicamento',
							'CambioUbicacionMedicamento', 'DetalleMedicamento' ],
					stores : [ 'Medicamentos', 'ComboTA', 'ComboDU',
							'MedicamentosEnUbicacion' ],
					models : [ 'Medicamento', 'Combo', 'UbicacionMedicamento' ],

					/* He incluido Combo por el valor del name = descripción */
					init : function() {

						/* botones de aceptar y cancelar */

						this
								.control({
									'altaMedicamento button[action=aceptar]' : {
										click : this.salvarAlta
									},
									'altaMedicamento button[action=close]' : {
										click : this.cerrarPanelForm
									},

									'consultaMedicamento button[action=buscar]' : {
										click : this.buscarMedicamento
									},
									'consultaMedicamento button[action=detalle]' : {
										click : this.detalleMedicamento
									},
									'consultaMedicamento button[action=modificar]' : {
										click : this.modificarMedicamento
									},
									'consultaMedicamento button[action=cambioUbicacion]' : {
										click : this.PantallaCambioUbicacionMedicamento
									},

									/*
									 * Ubicación del medicamento. Pensando que
									 * puede estar en distintos almacenes
									 */

									'cambioUbicacionUbicacionMedicamento button[action=buscar]' : {
										click : this.buscarInstitucionUbicacion
									},
									'cambioUbicacionUbicacionMedicamento textfield[name=textoBusqueda]' : {
										change : this.buscarInstitucionUbicacion
									},
									'cambioUbicacionUbicacionMedicamento textfield[name=textoBusquedaUbicacion]' : {
										change : this.filtrarUbicacion
									},
									'cambioUbicacionUbicacionMedicamento gridpanel[name=ResultadoBusquedaInstitucion]' : {
										itemclick : this.seleccionFilaBusqueda
									},
									'cambioUbicacionUbicacionMedicamento gridpanel[name=Ubicacion]' : {
										itemclick : this.seleccionFilaUbicaciones
									},
									'cambioUbicacionUbicacionMedicamento button[action=cambioUbicacion]' : {
										click : this.cambioUbicacionUbicacionMedicamento
									},
									'cambioUbicacionUbicacionMedicamento button[action=close]' : {
										click : this.cerrarPanelForm
									},

									'detalleMedicamento button[action=historicoPrecios]' : {
										click : this.mostrarHistoricoPrecios
									},
									'detalleMedicamento button[action=historicoUbicaciones]' : {
										click : this.mostrarHistoricoUbicaciones
									},
									'detalleMedicamento button[action=historicoUnidadesStock]' : {
										click : this.mostrarHistoricoUnidadesStock
									},
									'detalleMedicamento button[action=historicoDosisRecomendadas]' : {
										click : this.mostrarHistoricoDosisRecomendadas
									},
									'detalleMedicamento button[action=close]' : {
										click : this.cerrarPanelForm
									},

									'altaMedicamento button[action=busquedaUbicacion]' : {
										click : this.pantallaBusquedaUbicacion
									},

									/* campos de texto */

									'altaMedicamento textfield[name=nombre]' : {
										change : this.altaMedicamento
									},
									'altaMedicamento textfield[name=finalidadMedicamento]' : {
										change : this.altaMedicamento
									},
									'altaMedicamento textfield[name=componentes]' : {
										change : this.altaMedicamento
									},
									'altaMedicamento textfield[name=prospecto]' : {
										change : this.altaMedicamento
									},
									'altaMedicamento textfield[name=stockMinimo]' : {
										change : this.altaMedicamento
									},
									'altaMedicamento textfield[name=ubicacion]' : {
										change : this.altaMedicamento
									},
									'altaMedicamento textfield[name=precio]' : {
										change : this.altaMedicamento
									},
									'altaMedicamento textfield[name=unidadesEnStock]' : {
										change : this.altaMedicamento
									},
									'altaMedicamento textfield[name=dosisRecomendadaKg]' : {
										change : this.altaMedicamento
									},

									'cambioTipoDeAlarma button[action=cambiarTipoDeAlarma]' : {
										click : this.cambiarTipoDeAlarma
									},
									'cambioTipoDeAlarma button[action=close]' : {
										click : this.cerrarPanelForm
									},
									'cambioDescripcionUnidades button[action=cambiarDescripcionUnidades]' : {
										click : this.cambiarDescripcionUnidades
									},
									'cambioDescripcionUnidades button[action=close]' : {
										click : this.cerrarPanelForm
									},

									salvarAlta : function(button) {
										var form = button.up('form').getForm();
										console.log(form.getValues());
										form
												.submit({
													waitMsg : 'En proceso...',
													success : function(form1,
															action) {
														Ext.Msg
																.alert(
																		'Alta realizada correctamente',
																		action.result.msg);
														var view = Ext
																.widget('cambioEstadoMedicamento');
														var values = form
																.getValues();
														var id = action.result.id;
														Ext.StoreManager
																.lookup(
																		'ResultadoBusquedaUbicacionMedicamento')
																.load(
																		{
																			params : {
																				textoBusqueda : "ALBA"
																			},
																			scope : this
																		});
														Ext.StoreManager
																.lookup(
																		'Ubicaciones')
																.load(
																		{
																			params : {
																				nombreInstitucion : "ALBA"
																			},
																			scope : this
																		});
														Ext.StoreManager
																.lookup(
																		'MedicamentosEnUbicacion')
																.removeAll();
														values['id'] = id;
														view
																.loadRecord(new AM.model.Medicamento(
																		values));
														irPantallaSinGuardar(
																'altaMedicamento',
																view);
													},
													failure : function(form,
															action) {
														Ext.Msg
																.alert(
																		'No se ha podido realizar el alta',
																		action.result.msg);
													}
												});

									},
									cambiarTipoDeAlarma : function(button) {
										var form = button.up('form').getForm();
										console.log(form.getValues());
										form
												.submit({
													waitMsg : 'En proceso...',
													success : function(form,
															action) {
														Ext.Msg
																.alert(
																		'Cambio tipo de alarma realizado correctamente',
																		action.result.msg);
														vueltaPantallaRecarga('ResultadoBusquedaGeneral');
													},
													failure : function(form,
															action) {
														Ext.Msg
																.alert(
																		'No se ha podido realizar el cambio',
																		action.result.msg);
													}
												});

									},
									cambiarDescripcionUnidades : function(
											button) {
										var form = button.up('form').getForm();
										console.log(form.getValues());
										form
												.submit({
													waitMsg : 'En proceso...',
													success : function(form,
															action) {
														Ext.Msg
																.alert(
																		'Cambio descripción de unidades realizado correctamente',
																		action.result.msg);
														vueltaPantallaRecarga('ResultadoBusquedaGeneral');
													},
													failure : function(form,
															action) {
														Ext.Msg
																.alert(
																		'No se ha podido realizar el cambio',
																		action.result.msg);
													}
												});
									},

									PantallaCambioTipoDeAlarma : function(
											button) {
										var view = Ext
												.widget('cambioTipoDeAlarma');
										view.loadRecord(button.up(
												'consultaMedicamento').query(
												'gridpanel')[0]
												.getSelectionModel()
												.getLastSelected());
										irPantalla('consultaMedicamento', view);
									},

									PantallaDescripcionUnidades : function(
											button) {
										var view = Ext
												.widget('cambioDescripcionUnidades');
										view.loadRecord(button.up(
												'consultaMedicamento').query(
												'gridpanel')[0]
												.getSelectionModel()
												.getLastSelected());
										irPantalla('consultaMedicamento', view);
									},

									buscarMedicamento : function(button) {
										var form = button.up('form').getForm();
										console.log(form.getValues());

										Ext.StoreManager
												.lookup(
														'ResultadoBusquedaMedicamentos')
												.load({
													params : form.getValues(),
													scope : this
												});

									},

									detalleMedicamento : function(button) {
										var view = Ext
												.widget('detalleMedicamento');
										view.loadRecord(button.up(
												'consultaMedicamento').query(
												'gridpanel')[0]
												.getSelectionModel()
												.getLastSelected());
										irPantalla('consultaMedicamento', view);

									},

									modificarMedicamento : function(button) {
										var view = Ext
												.widget('modificarAMedicamento');
										view.loadRecord(button.up(
												'consultaMedicamento').query(
												'gridpanel')[0]
												.getSelectionModel()
												.getLastSelected());
										irPantalla('consultaMedicamento', view);
									},

									seleccionFilaBusqueda : function(grid,
											record) {
										grid
												.up(
														'cambioUbicacionMedicamento')
												.query(
														'textfield[name="textoBusquedaUbicacion"]')[0]
												.setValue('');
										Ext.StoreManager.lookup('Ubicaciones')
												.load({
													params : record.data,
													scope : this
												});

										grid
												.up(
														'cambioUbicacionMedicamento')
												.query(
														'button[action="cambioUbicacion"]')[0]
												.disable();

									},

									seleccionFilaUbicaciones : function(grid,
											record) {
										console.log(record);
										Ext.StoreManager.lookup(
												'MedicamentosEnUbicacion')
												.load({
													params : record.data,
													scope : this
												});
										grid
												.up('form')
												.query(
														'button[action="cambioUbicacion"]')[0]
												.enable();

									},

									cerrarPanelForm : function(button) {
										vueltaPantalla();
									},

									cambioUbicacionMedicamento : function(
											button) {
										var idMedicamento = button
												.up(
														'cambioUbicacionMedicamento')
												.query('hiddenfield[name="id"]')[0]
												.getValue();
										var data = button
												.up(
														'cambioUbicacionMedicamento')
												.query(
														'gridpanel[name=Ubicacion]')[0]
												.getSelectionModel()
												.getLastSelected().data;

										data.id = idMedicamento;
										Ext.Ajax
												.request({
													url : "http://localhost:8080/AlbaControlador/cambioUbicacionMedicamento",
													params : data,
													success : function(form,
															action) {
														Ext.Msg
																.alert('Cambio Ubicacion realizado correctamente');
														vueltaPantallaRecarga('ResultadoBusquedaGeneral');
													},
													failure : function(form,
															action) {
														Ext.Msg
																.alert('No se ha podido realizar el cambio');
													}
												});
									},
									altaEspecie : function(button) {
										var view = Ext
												.widget('altaMedicamento');
										irPantalla('altaMedicamento', view);
									},

									pantallaBusquedaUbicacion : function(button) {

										var view = Ext
												.widget('consultaInstitucion');

										var items = view
												.query('button[cls="consulta"]');
										for (var i = 0, l = items.length; i < l; i++) {
											items[i].hide();
										}

										irPantalla('altaMedicamento', view);

									},

									buscarInstitucionUbicacion : function(
											button) {
										var form = button.up('form');
										Ext.StoreManager.lookup(
												'ResultadoBusquedaInstitucion')
												.load({
													params : form.getValues(),
													scope : this
												});

										button
												.up(
														'cambioUbicacionMedicamento')
												.query(
														'textfield[name="textoBusquedaUbicacion"]')[0]
												.setValue('');
										Ext.StoreManager.lookup('Ubicaciones')
												.removeAll();
										Ext.StoreManager.lookup(
												'MedicametosEnUbicacion')
												.removeAll();
										button
												.up(
														'cambioUbicacionMedicamento')
												.query(
														'button[action="cambioUbicacion"]')[0]
												.disable();

									},

									filtrarUbicacion : function(textfield) {
										var selection = textfield
												.up(
														'cambioUbicacionMedicamento')
												.query(
														'gridpanel[name="ResultadoBusquedaInstitucion"]')[0]
												.getSelectionModel();
										if (!selection.hasSelection()) {
											selection.select(0, false, true);
										}
										var record = textfield
												.up(
														'cambioUbicacionMedicamento')
												.query(
														'gridpanel[name="ResultadoBusquedaInstitucion"]')[0]
												.getSelectionModel()
												.getLastSelected().data;
										record['textoBusquedaUbicacion'] = textfield
												.getValue();
										Ext.StoreManager.lookup('Ubicaciones')
												.load({
													params : record,
													scope : this
												});
										record['textoBusquedaUbicacion'] = '';
										Ext.StoreManager.lookup(
												'MedicamentosEnUbicacion')
												.removeAll();
										button
												.up(
														'cambioUbicacionMedicamento')
												.query(
														'button[action="cambioUbicacion"]')[0]
												.disable();

									},

									CambioCriterioSeleccion : function(
											newValue, oldValue) {

										var valor = newValue.getValue();
										var items = newValue.up('form').query(
												'textfield,combo');
										for (var i = 0, l = items.length; i < l; i++) {
											var cls = items[i].cls;
											if (cls == "mostrar"
													|| cls == valor) {
												items[i].show();
											} else {
												items[i].hide();
											}
										}
									},

									CambioCriterioSeleccionPI : function(
											newValue, oldValue) {
										var form = newValue.up('form');
										form
												.query('fieldcontainer[name=BuscarIP]')[0]/*¿Qué es IP?*/
										.show();
										form
												.query('fieldcontainer[name=instituciones]')[0]
												.hide();
										form
												.query('button[action="cambioUbicacion"]')[0]
												.disable();
									}

								});
					},
				});