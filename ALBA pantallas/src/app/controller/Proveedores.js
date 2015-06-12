Ext.define('AM.controller.Proveedores', {
    extend: 'Ext.app.Controller',
   
    views:  ['AltaProveedor'],
    stores: [],
    models: [],
    
    
    init: function() {
    	this.control({ 
            'altaProveedor button[action=save]': {
                click: this.salvarAlta
            },
            'altaProveedor button[action=close]': {
                click: this.cerrarPanelForm
            },
    	});
	      
	},
	
	cerrarPanelForm: function(button){
		vueltaPantalla();			    		
	},
	salvarAlta: function(button){
			var form = button.up('form').getForm();
			console.log( form.getValues());
			form.submit({
					waitMsg: 'En proceso...',
		            success: function(form1, action) {
		               Ext.Msg.alert('Alta realizada correctamente', action.result.msg);
		               vueltaPantallaRecarga('ResultadoBusquedaGeneral');
		            },
		            failure: function(form, action) {
		                Ext.Msg.alert('No se ha podido realizar el alta', action.result.msg);
		            }
		        });
	    		
		},
	    
	   
	
});