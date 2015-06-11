Ext.define('AM.controller.Principal', {
    	extend: 'Ext.app.Controller',

	views: ['Principal','Principal2'],
	stores: ['ComboNumResultados','ResultadoBusquedaGeneral'],
	models: ['ResultadoBusquedaGeneral'],
	
	init: function() {
	        this.control({
	            '#altaAnimal': {
	                click: this.altaAClick
	            },
	            '#consultaAnimal': {
	                click: this.consultaAClick
	            },
	            '#altaInstituciones': {
	                click: this.altaInstitucionesClick
	            },
	            '#consultaInstituciones': {
	                click: this.consultaInstitucionesClick
	            },
	            '#altaPersonas': {
	                click: this.altaPersonasClick
	            },
	            '#consultaPersonas': {
	                click: this.consultaPersonasClick
	            },
	            'panelPrincipal2 button[action=altaAnimal]': {
	                click: this.altaAnimalPantalla
	            },
	            'panelPrincipal2 button[action=altaPersona]': {
	                click: this.altaPersonaPantalla
	            },
	            'panelPrincipal2 button[action=altaInstitucion]': {
	                click: this.altaInstitucionPantalla
	            },
	            'panelPrincipal2 button[action=altaProveedor]': {
	                click: this.altaProveedorPantalla
	            },
	            'panelPrincipal2 button[action=listados]': {
	                click: this.pantallaListados
	            },
	            'panelPrincipal2 button[action=buscar]': {
	                click: this.busquedaGeneral
	            },
	            'panelPrincipal2 textfield[name=textoBusqueda]': {
	            	change: this.busquedaGeneral
	            },
	            'panelPrincipal2 gridpanel[name=ResultadoBusquedaGeneral]': {
	                itemclick: this.seleccionFilaBusquedaGeneral
	            },
	            'panelPrincipal2 button[action=detallePersona]': {
	            	click: this.detallePersonaclick
	            },
	            'panelPrincipal2 button[action=modificarPersona]': {
	            	click: this.modificarPersonaclick
	            },
	            'panelPrincipal2 button[action=cambioEstadoPersona]': {
	            	click: this.cambioEstadoPersonaclick
	            },
	            'panelPrincipal2 button[action=ubicacionesPersona]': {
	            	click: this.ubicacionesPersonaclick
	            },
	            'panelPrincipal2 button[action=detalleInstitucion]': {
	            	click: this.detalleInstitucionclick
	            },
	            'panelPrincipal2 button[action=modificarInstitucion]': {
	            	click: this.modificarInstitucionclick
	            },
	            'panelPrincipal2 button[action=cambioEstadoInstitucion]': {
	            	click: this.cambioEstadoInstitucionclick
	            },
	            'panelPrincipal2 button[action=ubicacionesInstitucion]': {
	            	click: this.ubicacionesInstitucionclick
	            },
	            'panelPrincipal2 button[action=detalleAnimal]': {
	            	click: this.detalleAnimalclick
	            },
	            'panelPrincipal2 button[action=modificarAnimal]': {
	            	click: this.modificarAnimalclick
	            },
	            'panelPrincipal2 button[action=cambioUbicacionAnimal]': {
	            	click: this.cambioUbicacionAnimalclick
	            },
	            'panelPrincipal2 button[action=modificarPesoAnimal]': {
	            	click: this.modificarPesoAnimalclick
	            },
	            'panelPrincipal2 button[action=cambioEstadoAnimal]': {
	            	click: this.cambioEstadoAnimalclick
	            }
	            
	        });
	    },
	    
	    
	    
	    cerrarPanelForm: function(button){
			vueltaPantalla();			    		
		},
	    
	    pantallaListados: function(button){  
			var view = Ext.widget('panelListados');
			irPantalla('panelPrincipal2',view);

		},
		
	    detalleAnimalclick: function(button){  
			var view = Ext.widget('detalleAnimal');
			var record = button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected();
			view.loadRecord(record);
			var imagen = record.get('imagen');
			if(imagen != null){
				view.query('image')[0].setSrc('images/imagenesTrabajo/' + imagen);
			}
	    	irPantalla('panelPrincipal2',view);

		},
		
		modificarAnimalclick: function(button){    					
			var view = Ext.widget('modificarAnimal');	
	   		view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());
	   		irPantalla('panelPrincipal2',view);	
		},
		
		
		
		cambioUbicacionAnimalclick: function(button){
			var view = Ext.widget('cambioUbicacionAnimal');	
			Ext.StoreManager.lookup('ResultadoBusquedaInstitucionPersona').load({
				params: {textoBusqueda: "ALBA"},
				scope: this					
			});	
			Ext.StoreManager.lookup('Ubicaciones').load({
				params: {nombreInstitucion: "ALBA"},
				scope: this					
			});	
			Ext.StoreManager.lookup('AnimalesEnUbicacion').removeAll();
			view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());
			irPantalla('panelPrincipal2',view);
			
		},
		
		modificarPesoAnimalclick: function(button){
	    	var view = Ext.widget('altaPesoAnimal');	
	    	view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());
	    	irPantalla('panelPrincipal2',view);	
		},
		
		cambioEstadoAnimalclick: function(button){
	    	var view = Ext.widget('cambioEstado');	
	    	view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());
	    	irPantalla('panelPrincipal2',view);	
		},
	    
	    ubicacionesInstitucionclick: function(button){    	
			
			var view = Ext.widget('gestionUbicacion');    		    		
	    	view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());
	    	items = view.query('textfield[cls="Tipo2"]');
			for (var i = 0, l = items.length; i < l; i++) {
				items[i].hide();
			}
			
			Ext.StoreManager.lookup('Ubicaciones').load({
					params: button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected().data,
					scope: this					
			});
			
			items = view.query('gridpanel[name="AnimalesUbicacion"]');
			items[0].getStore().removeAll();
	    		
	    	irPantalla('panelPrincipal2',view);
	    		
		},
	    
	    cambioEstadoInstitucionclick: function(button){
			var view = Ext.widget('cambioEstadoInstitucion');
			view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());		
			irPantalla('panelPrincipal2',view);	
		},
	    
	    modificarInstitucionclick: function(button){    					
			var view = Ext.widget('altaInstitucion');	
	    	view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());
	    	view.title = 'Modificar Institución';
	    		    		
			var items = view.query('component[name="accion"]');
			items[0].setValue('modificacion');
			
			storeRecargar='ResultadoBusquedaGeneral';
			    		
	    	irPantalla('panelPrincipal2',view);	

		},
	    
	    detalleInstitucionclick: function(button){
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
			
			var estado = button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected().getData().estado;
			if(estado == 'BAJA'){
				items = view.query('component[cls="tipo2"]');
				for (var i = 0, l = items.length; i < l; i++) {
					items[i].show();
				}
			}
			
			view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());		
			irPantalla('panelPrincipal2',view);	

		},
	
	    detallePersonaclick: function(button){
			var view = Ext.widget('altaPersona');
			
			view.title = 'Detalle Persona';
			
			//Configuramos la pantalla antes de abrirla
			var items = view.query('component[cls="tipo1"]');
			for (var i = 0, l = items.length; i < l; i++) {
			    items[i].readOnly = true;
			}
			
			items = view.query('button[cls="tipo1"]');
			for (var i = 0, l = items.length; i < l; i++) {
			    items[i].hide();
			}
			
			
			
			var estado = button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected().getData().estado;
			if(estado == 'BAJA'){
				items = view.query('component[cls="tipo2"]');
				for (var i = 0, l = items.length; i < l; i++) {
					items[i].show();
				}
			}	
			view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());		
			irPantalla('panelPrincipal2',view);	

		},
		
		modificarPersonaclick: function(button){    					
			var view = Ext.widget('altaPersona');
			var items = view.query('component[name="accion"]');
			items[0].setValue('modificacion');
    		view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());
    		view.title = 'Modificar Persona';
    	 		
			storeRecargar='ResultadoBusquedaGeneral';
    		irPantalla('panelPrincipal2',view);	
		},
		
		cambioEstadoPersonaclick: function(button){
			var view = Ext.widget('cambioEstadoPersona');
			view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());		
			irPantalla('panelPrincipal2',view);	
		},
		
		ubicacionesPersonaclick: function(button){    	
			
			var view = Ext.widget('gestionUbicacion');   
			
			var items = view.query('textfield[cls="Tipo1"]');
			for (var i = 0, l = items.length; i < l; i++) {
				items[i].hide();
			}
			 
			Ext.StoreManager.lookup('Ubicaciones').load({
					params: button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected().data,
					scope: this					
			});
			
			items = view.query('gridpanel[name="AnimalesUbicacion"]');
			items[0].getStore().removeAll();
			
				
	    	view.loadRecord(button.up('panelPrincipal2').query('gridpanel')[0].getSelectionModel().getLastSelected());
	    		
	    	irPantalla('panelPrincipal2',view);

	    		
		},
		
	    seleccionFilaBusquedaGeneral: function(grid, record){
	    	var resultado = record.get('tipoResultado');
	    	
	    	if(resultado == 'Persona'){
	    		grid.up('panelPrincipal2').query('panel[name="operacionesPersona"]')[0].show();
	    		grid.up('panelPrincipal2').query('panel[name="operacionesInstitucion"]')[0].hide();
	    		grid.up('panelPrincipal2').query('panel[name="operacionesAnimal"]')[0].hide();
	    		var panel = grid.up('panelPrincipal2');
				var estado = record.getData().estado;
	    		if(estado == 'BAJA'){
					panel.query('button[action="modificarPersona"]')[0].setDisabled(true);
					panel.query('button[action="ubicacionesPersona"]')[0].setDisabled(true);
				}else{
					panel.query('button[action="modificarPersona"]')[0].setDisabled(false);
					panel.query('button[action="ubicacionesPersona"]')[0].setDisabled(false);
				}
	    	}
			if(resultado == 'Institucion'){
				grid.up('panelPrincipal2').query('panel[name="operacionesPersona"]')[0].hide();
	    		grid.up('panelPrincipal2').query('panel[name="operacionesInstitucion"]')[0].show();
	    		grid.up('panelPrincipal2').query('panel[name="operacionesAnimal"]')[0].hide();
	    		var panel = grid.up('panelPrincipal2');
				var estado = record.getData().estado;
	    		if(estado == 'BAJA'){
					panel.query('button[action="modificarInstitucion"]')[0].setDisabled(true);
					panel.query('button[action="ubicacionesInstitucion"]')[0].setDisabled(true);
				}else{
					panel.query('button[action="modificarInstitucion"]')[0].setDisabled(false);
					panel.query('button[action="ubicacionesInstitucion"]')[0].setDisabled(false);
				}
			}
			if(resultado == 'Animal'){
				grid.up('panelPrincipal2').query('panel[name="operacionesPersona"]')[0].hide();
	    		grid.up('panelPrincipal2').query('panel[name="operacionesInstitucion"]')[0].hide();
	    		grid.up('panelPrincipal2').query('panel[name="operacionesAnimal"]')[0].show();
	    		var panel = grid.up('panelPrincipal2');
				var estado = record.getData().estado;
	    		if(estado == 'BAJA'){
					panel.query('button[action="modificarAnimal"]')[0].setDisabled(true);
					panel.query('button[action="cambioUbicacionAnimal"]')[0].setDisabled(true);
					panel.query('button[action="modificarPesoAnimal"]')[0].setDisabled(true);
				}else{
					panel.query('button[action="modificarAnimal"]')[0].setDisabled(false);
					panel.query('button[action="cambioUbicacionAnimal"]')[0].setDisabled(false);
					panel.query('button[action="modificarPesoAnimal"]')[0].setDisabled(false);
				}
			}
			
			
			
		},
		
	    altaAnimalPantalla: function(button){
	    	var view = Ext.widget('altaAnimal');
			irPantalla('panelPrincipal2',view);		 		
			var items = view.query('component[cls="detalle"]');
			for (var i = 0, l = items.length; i < l; i++) {
			    items[i].hide();
			}			    	
		},
		
		busquedaGeneral: function(button){
			var form = button.up('form').getForm();
			console.log( form.getValues());
			
			button.up('panelPrincipal2').query('panel[name="operacionesPersona"]')[0].hide();
			button.up('panelPrincipal2').query('panel[name="operacionesInstitucion"]')[0].hide();
			button.up('panelPrincipal2').query('panel[name="operacionesAnimal"]')[0].hide();
			
			Ext.StoreManager.lookup('ResultadoBusquedaGeneral').load({
				params: form.getValues(),
				scope: this					
			});
		},
		
		altaPersonaPantalla: function(button){
	    	var view = Ext.widget('altaPersona');
			irPantalla('panelPrincipal2',view);		 				    	
		},
		
		altaInstitucionPantalla: function(button){
	    	var view = Ext.widget('altaInstitucion');
			irPantalla('panelPrincipal2',view);				    	
		},
		altaProveedorPantalla: function(button){
	    	var view = Ext.widget('altaProveedor');
			irPantalla('panelPrincipal2',view);				    	
		},
		
	altaAClick: function(button){
		var panel = button.up('#principal');
		var contenidos = panel.down('#panelContenidos');
		contenidos.removeAll();
		var view = Ext.widget('altaAnimal');
		contenidos.add(view);		 		
		var items = view.query('component[cls="detalle"]');
		for (var i = 0, l = items.length; i < l; i++) {
		    items[i].hide();
		}
		
		pantallaAnterior = []; 
		pantallaAnterior.push(view); 
		    	
	},
	consultaAClick: function(button){		
		var panel = button.up('#principal');
		var contenidos = panel.down('#panelContenidos');
		contenidos.removeAll();
		var view = Ext.widget('consultaAnimal');
		Ext.StoreManager.lookup('ResultadoBusquedaAnimales').load({
			scope: this					
		});
		contenidos.add(view);
		pantallaAnterior = [];
		pantallaAnterior.push(view);
	},
	altaInstitucionesClick: function(button){
		var panel = button.up('#principal');
		var contenidos = panel.down('#panelContenidos');
		contenidos.removeAll();
		var view = Ext.widget('altaInstitucion');
		contenidos.add(view); 		
		pantallaAnterior = [];
		pantallaAnterior.push(view);
		       	
	},
	altaPersonasClick: function(button){
		var panel = button.up('#principal');
		var contenidos = panel.down('#panelContenidos');
		contenidos.removeAll();
		var view = Ext.widget('altaPersona');
		contenidos.add(view); 		
		pantallaAnterior = [];
		pantallaAnterior.push(view);
		       	
	},
	consultaInstitucionesClick: function(button){
		var panel = button.up('#principal');
		var contenidos = panel.down('#panelContenidos');
		contenidos.removeAll();		
		
		var view = Ext.widget('consultaInstitucion');
		Ext.StoreManager.lookup('ResultadoBusquedaInstituciones').load({
			scope: this					
		});
		
		contenidos.add(view); 
		pantallaAnterior = [];	
		pantallaAnterior.push(view);
				
		
	},
	consultaPersonasClick: function(button){
		var panel = button.up('#principal');
		var contenidos = panel.down('#panelContenidos');
		contenidos.removeAll();		
		
		var view = Ext.widget('consultaPersona');
		Ext.StoreManager.lookup('ResultadoBusquedaPersonas').load({
			scope: this					
		});
			
		contenidos.add(view); 
		pantallaAnterior = [];	
		pantallaAnterior.push(view);
		
				
	}
	
    
});