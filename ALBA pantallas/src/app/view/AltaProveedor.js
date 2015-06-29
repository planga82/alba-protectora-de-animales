Ext
		.define(
				'AM.view.AltaProveedor',
				{
					extend : 'Ext.form.Panel',
					alias : 'widget.altaProveedor',
					title : 'Alta de Proveedor',
					autoScroll : true,
					url : "/AlbaControlador/altaProveedor",
					layout : {
						type : 'vbox',
						padding : '5',
						align : 'left'
					},
					bodyPadding : 20,
					items : [
							{
								xtype : 'label',
								text : 'Datos del proveedor',
								style : 'font-weight:bold;font-size:12px',
								padding : 10
							},
							{
								xtype : 'textfield',
								name : 'nombreProveedor',
								fieldLabel : 'Nombre',
								allowBlank : false
							},
							{
								xtype : 'textfield',
								name : 'cifProveedor',
								fieldLabel : 'CIF'
							},
							{
								xtype : 'textfield',
								name : 'DomicilioProveedor',
								fieldLabel : 'Domicilio'
							},
							{
								xtype : 'textfield',
								name : 'LocalidadProveedor',
								fieldLabel : 'Localidad'
							},
							{
								xtype : 'textfield',
								name : 'ProvinciaProveedor',
								fieldLabel : 'Provincia'
							},
							{
								xtype : 'textfield',
								name : 'CodigoPostalProveedor',
								fieldLabel : 'Codigo Postal'
							},
							{
								xtype : 'textfield',
								name : 'PaisProveedor',
								fieldLabel : 'Pais'
							},
							{
								xtype : 'textfield',
								name : 'faxProveedor',
								fieldLabel : 'Fax'
							},
							{
								xtype : 'textfield',
								name : 'TelefonoProveedor',
								fieldLabel : 'Tel�fono'
							},
							{
								xtype : 'textfield',
								name : 'emailProveedor',
								fieldLabel : 'Email',
								regex : /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/,
								msgTarget : 'under',
								invalidText : 'Formato email no válido'
							},
							{
								xtype : 'label',
								text : 'Datos persona contacto',
								style : 'font-weight:bold;font-size:12px',
								padding : 10
							},
							{
								xtype : 'textfield',
								name : 'nombrePersonaContactoProveedor',
								fieldLabel : 'Nombre'
							},
							{
								xtype : 'textfield',
								name : 'dniPersonaContactoProveedor',
								fieldLabel : 'DNI'
							},
							{
								xtype : 'textfield',
								name : 'cargoPersonaContactoProveedor',
								fieldLabel : 'Cargo'
							},
							{
								xtype : 'label',
								text : 'Cuenta Bancaria',
								style : 'font-weight:bold;font-size:12px',
								padding : 10
							},
							{
								xtype : 'textfield',
								name : 'numCuentaProveedor',
								fieldLabel : 'Numero cuenta',
								width : 290,
								regex : /^([0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])$/,
								msgTarget : 'under',
								invalidText : 'Formato numero cuenta: 0123-0123-01-01234567890123456789'
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
				});