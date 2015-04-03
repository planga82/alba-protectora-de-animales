Ext.application({
	requires : [ 'Ext.container.Viewport' ],
	name : 'AM',

	appFolder : 'app',

	controllers : [ 'Principal', 'Animales', 'Instituciones', 'Ubicaciones',
			'Personas', 'Listados', 'Medicamentos' ],

	launch : function() {
		Ext.create('Ext.container.Viewport', {
			id : 'principal',
			layout : 'fit',
		});

		var view = Ext.widget('panelPrincipal2');
		var c = Ext.ComponentQuery.query('#principal')[0];
		c.add(view);
		pantallaAnterior = [];
		pantallaAnterior.push(view);

		irPantalla = function(pAnterior, view) {
			var contenidos = Ext.ComponentQuery.query('#principal')[0];
			contenidos.child(pAnterior).hide();
			pantallaAnterior.push(view);
			contenidos.add(view);
		};

		irPantallaSinGuardar = function(pAnterior, view) {
			var contenidos = Ext.ComponentQuery.query('#principal')[0];
			contenidos.child(pAnterior).close();
			pantallaAnterior.pop();
			pantallaAnterior.push(view);
			contenidos.add(view);
		};

		vueltaPantalla = function() {
			var p = pantallaAnterior.pop();
			p.close();
			pantallaAnterior[pantallaAnterior.length - 1].show();
		};

		vueltaPantallaRecarga = function(store) {
			var p = pantallaAnterior.pop();
			p.close();
			var pa = pantallaAnterior[pantallaAnterior.length - 1];
			pa.show();
			var form = pa.down('form').getForm();
			Ext.StoreManager.lookup(store).load({
				params : form.getValues(),
				scope : this
			});
		};

		damePantallaAnterior = function() {
			return pantallaAnterior[pantallaAnterior.length - 2];
		};

		//variables globales de selección de filas en los grid

		seleccionUbicacion = null;
		storeRecargar = null;

		Ext.Ajax.request({
			url : "http://localhost:8080/AlbaControlador/Arranque",
			success : function(response, action) {
				console.log('Inicializacion correcta');
			},
			failure : function(response, action) {
				console.log('Fallo en la inicializacion');
				Ext.Msg.alert(
						'No se ha podido arrancar correctamente la aplicacion',
						action.result.msg);
			}
		});
	}
});
