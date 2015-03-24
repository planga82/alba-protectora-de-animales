Ext.define('AM.controller.Instituciones', {
    extend: 'Ext.app.Controller',
   
    views:  ['AltaInstitucion', 'ConsultaInstitucion','AltaTipoInstitucion','CambioEstadoInstitucion'],
    stores: ['Instituciones','TiposInstituciones'],
    models: ['Institucion','TipoInstitucion'],
    
    
    init: function() {
    		
	        this.control({
	            'altaInstitucion button[action=close]': {
	                click: this.cerrarPanelForm
	            },
	            'altaInstitucion button[action=save]': {
	                click: this.altaInstitucion
	            },
	            'altaInstitucion button[action=altaTipoInstitucion]': {
	                click: this.PantallaAltaTipoInstitucion
	            },
	            'altaTipoInstitucion button[action=close]': {
	                click: this.cerrarPanelForm
	            },
	            'altaTipoInstitucion button[action=save]': {
	                click: this.AltaTipoInstitucion
	            },
	            'consultaInstitucion button[action=buscar]': {
	                click: this.buscarInstitucion
	            },
	            
	            'consultaInstitucion button[action=cambioEstado]': {
	                click: this.PantallaCambioEstadoInstitucion
	            },
	            'consultaInstitucion button[action=detalle]': {
	                click: this.PantallaDetalleInstitucion
	            },
	            'consultaInstitucion button[action=ubicaciones]': {
	                click: this.PantallaGestionUbicacion
	            },	            
	            'consultaInstitucion button[action=modificar]': {
	                click: this.PantallaModificarInstitucion
	            },	            
	            'consultaInstitucion gridpanel': {
	                itemclick: this.seleccionFila
	            },
	            'cambioEstadoInstitucion button[action=close]': {
	                click: this.cerrarPanelForm
	            },
	            'cambioEstadoInstitucion button[action=cambioEstado]': {
	                click: this.cambioEstadoInstitucion
	            }
	            
	        });
	    },
    
    		
	cerrarPanelForm: function(button){
		vueltaPantalla();			    		
	},	
	
	
	buscarInstitucion: function(button){
		
		var form = button.up('form').getForm();
		
		Ext.StoreManager.lookup('ResultadoBusquedaInstituciones').load({
			params: form.getValues(),
			scope: this					
		});
	},
	
	AltaTipoInstitucion: function(button){
		var form = button.up('form').getForm();
		form.submit({
				waitMsg: 'En proceso...',
	            success: function(form, action) {
	               Ext.Msg.alert('Alta realizada correctamente', action.result.msg);
	                Ext.StoreManager.lookup('TiposInstituciones').load();
	               vueltaPantalla();
	            },
	            failure: function(form, action) {
	                Ext.Msg.alert('No se ha podido realizar el alta', action.result.msg);
	            }
	        });		
	},
	
	cambioEstadoInstitucion: function(button){
		var form = button.up('form').getForm();
		form.submit({
				waitMsg: 'En proceso...',
	            success: function(form, action) {
	               Ext.Msg.alert('Cambio realizado correctamente', action.result.msg);
	               vueltaPantallaRecarga('ResultadoBusquedaGeneral');
	            },
	            failure: function(form, action) {
	                Ext.Msg.alert('No se ha podido realizar el alta', action.result.msg);
	            }
	        });		
	},
	
	
	altaInstitucion: function(button){
		var form1 = button.up('form').getForm();
		form1.submit({
				waitMsg: 'En proceso...',
	            success: function(form, action) {
	               Ext.Msg.alert('Alta realizada correctamente', action.result.msg);
	                var view = Ext.widget('gestionUbicacion');
	               
	               items = view.query('textfield[cls="Tipo2"]');
					for (var i = 0, l = items.length; i < l; i++) {
						items[i].hide();
					}
	               
	               var values = form1.getValues();
	               view.loadRecord(new AM.model.Institucion(values));	                
	               
	               irPantallaSinGuardar('altaInstitucion',view);
	               
	               Ext.StoreManager.lookup('Ubicaciones').load({
					params: values,
					scope: this					
				});
	            },
	            failure: function(form, action) {
	                Ext.Msg.alert('No se ha podido realizar el alta', action.result.msg);  
	            }
	        });		
	},
	
	PantallaAltaTipoInstitucion: function(button){
		var view = Ext.widget('altaTipoInstitucion');	
		irPantalla('altaInstitucion',view);		
	},
	
	PantallaCambioEstadoInstitucion: function(button){
		var view = Ext.widget('cambioEstadoInstitucion');
		view.loadRecord(button.up('consultaInstitucion').query('gridpanel')[0].getSelectionModel().getLastSelected());		
		irPantalla('consultaInstitucion',view);	
	},
	
	PantallaDetalleInstitucion: function(button){
		var view = Ext.widget('altaInstitucion');
		
		view.title = 'Detalle Institución';
		
		//Configuramos la pantalla antes de abrirla
		var items = view.query('component[cls="tipo1"]');
		for (var i = 0, l = items.length; i < l; i++) {
		    items[i].readOnly = true;
		}
		
		items = view.query('button[cls="tipo1"]');
		for (var i = 0, l = items.length; i < l; i++) {
		    items[i].hide();
		}
		
		var estado = button.up('consultaInstitucion').query('gridpanel')[0].getSelectionModel().getLastSelected().getData().estado;
		if(estado == 'BAJA'){
			items = view.query('component[cls="tipo2"]');
			for (var i = 0, l = items.length; i < l; i++) {
				items[i].show();
			}
		}
		
		view.loadRecord(button.up('consultaInstitucion').query('gridpanel')[0].getSelectionModel().getLastSelected());		
		irPantalla('consultaInstitucion',view);	

	},
	
	PantallaModificarInstitucion: function(button){    					
		var view = Ext.widget('altaInstitucion');	
    	view.loadRecord(button.up('consultaInstitucion').query('gridpanel')[0].getSelectionModel().getLastSelected());
    	view.title = 'Modificar Institución';
    		    		
		var items = view.query('component[name="accion"]');
		items[0].setValue('modificacion');
		
		storeRecargar='ResultadoBusquedaInstituciones';
		    		
    	irPantalla('consultaInstitucion',view);	

	},
	
	PantallaAltaUbicacion: function(button){    					
		var view = Ext.widget('altaUbicacion');	
    		view.loadRecord(button.up('consultaInstitucion').query('gridpanel')[0].getSelectionModel().getLastSelected());
    		
    		var items = view.query('component[cls="detalle"]');
		for (var i = 0, l = items.length; i < l; i++) {
		    items[i].hide();
		}
		var items = view.query('gridpanel');
		for (var i = 0, l = items.length; i < l; i++) {
		    items[i].hide();
		}
    		
    		irPantalla('altaInstitucion',view);		
	},
	
	
	
	
	
	
	PantallaGestionUbicacion: function(button){    	
				
		var view = Ext.widget('gestionUbicacion');    		    		
    	view.loadRecord(button.up('consultaInstitucion').query('gridpanel')[0].getSelectionModel().getLastSelected());
    	items = view.query('textfield[cls="Tipo2"]');
		for (var i = 0, l = items.length; i < l; i++) {
			items[i].hide();
		}
		
		Ext.StoreManager.lookup('Ubicaciones').load({
				params: button.up('consultaInstitucion').query('gridpanel')[0].getSelectionModel().getLastSelected().data,
				scope: this					
		});
		
		items = view.query('gridpanel[name="AnimalesUbicacion"]');
		items[0].getStore().removeAll();
    		
    	irPantalla('consultaInstitucion',view);
    		
	},
		
	
	seleccionFila: function(grid, record){
			var panel = grid.up('consultaInstitucion');
			var estado = record.getData().estado;
			if(estado == 'BAJA'){
				panel.query('button[action="modificar"]')[0].setDisabled(true);
				panel.query('button[action="ubicaciones"]')[0].setDisabled(true);
			}else{
				panel.query('button[action="modificar"]')[0].setDisabled(false);
				panel.query('button[action="ubicaciones"]')[0].setDisabled(false);
			}
		
	},
	
	
});