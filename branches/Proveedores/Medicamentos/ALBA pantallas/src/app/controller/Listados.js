Ext.define('AM.controller.Listados', {
    extend: 'Ext.app.Controller',
   
    views:  ['Listados','FiltroString','FiltroDate','FiltroBoolean'],
    stores: ['comboListadoAtributos','ComboOpcionesListado','ResultadoListados','ComboANDOR'],
    models: ['Atributos'],
    
    
    init: function() {
    		
	        this.control({
	            'panelListados button[action=close]': {
	            	click: this.cerrarPanelForm
	            },
	            'panelListados button[action=add]': {
	            	click: this.anadirAtributo
	            },
	            'panelListados button[action=buscar]': {
	            	click: this.busquedaListado
	            },
	            'panelListados combo[name=Entidad]': {
	            	change: this.eleccionEntidad
	            },
	            'filtroString button[action=cerrar]': {
	            	click: this.cerrarPanelS
	            },
	            'filtroDate button[action=cerrar]': {
	            	click: this.cerrarPanelD
	            },
	            'filtroBoolean button[action=cerrar]': {
	            	click: this.cerrarPanelB
	            }
	            
	        });
	    },
	    
	    cerrarPanelS: function(button){
			button.up('form').remove(button.up('filtroString'));
		},
		cerrarPanelD: function(button){
			button.up('form').remove(button.up('filtroDate'));
		},
		cerrarPanelB: function(button){
			button.up('form').remove(button.up('filtroBoolean'));
		},
	    
		anadirAtributo: function(button){
	    	var combo = button.up('form').down('combo[name=Atributos]');
	    	var tipo = combo.findRecordByValue(combo.getValue()).get('tipo');
			if(tipo == 'String'){
		    	var panel = Ext.widget('filtroString');
		    	panel.down('textfield').setFieldLabel(combo.getValue());
		    	combo.up('form').add(panel);
	    	}
			if(tipo == 'Date'){
		    	var panel = Ext.widget('filtroDate');
		    	panel.down('label[name="Etiqueta"]').setText(combo.getValue());
		    	combo.up('form').add(panel);
	    	}
			if(tipo == 'Boolean'){
		    	var panel = Ext.widget('filtroBoolean');
		    	panel.down('combo').setFieldLabel(combo.getValue());
		    	combo.up('form').add(panel);
	    	}
			
		},
	    eleccionEntidad: function(combo, newValue, oldValue, eOpts){
			combo.setDisabled(true);			
			Ext.StoreManager.lookup('comboListadoAtributos').load({
				params: {Entidad: newValue},
				scope: this					
			});
		},
	    busquedaListado: function(button){
			var filtro = new Object();
	    	var form = button.up('form');
			filtro['Entidad'] = form.down('combo[name=Entidad]').getValue();
			filtro['Enlace'] = form.down('combo[name=Enlace]').getValue();
			var contador = 0;
			
			var filtros = form.query('filtroString');
			for(var i=0;i<filtros.length;i++){
				var txt = filtros[i].down('textfield');
				filtro[txt.getFieldLabel() + "_String_" + contador++] = txt.getValue();
			}
			filtros = form.query('filtroBoolean');
			for(var i=0;i<filtros.length;i++){
				var txt = filtros[i].down('combo');
				filtro[txt.getFieldLabel( ) + "_Boolean_" + contador++] = txt.getValue();
			}
			filtros = form.query('filtroDate');
			for(var i=0;i<filtros.length;i++){
				var fld = filtros[i].down('datefield[fieldLabel="Desde"]');
				var flh = filtros[i].down('datefield[fieldLabel="Hasta"]');
				var lab = filtros[i].down('label');
				filtro[lab.text + "_Date_" + contador + "_Desde"] = fld.getRawValue();
				filtro[lab.text + "_Date_" + contador++ + "_Hasta"] = flh.getRawValue();
			}
			
			Ext.StoreManager.lookup('ResultadoListados').load({
				params: filtro,
				scope: this					
			});
		},		
		cerrarPanelForm: function(button){
			vueltaPantalla();			    		
		}
	
});