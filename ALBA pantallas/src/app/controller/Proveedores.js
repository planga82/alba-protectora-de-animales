Ext.define('AM.controller.Proveedores', {
    extend: 'Ext.app.Controller',
   
    views:  ['AltaProveedor'],
    stores: [],
    models: [],
    
    
    init: function() {
    	this.control({ 
            'altaProveedor button[action=save]': {
                click: this.cerrarPanelForm
            },
            'altaProveedor button[action=close]': {
                click: this.cerrarPanelForm
            },
    	});
	      
	},
	
	cerrarPanelForm: function(button){
		vueltaPantalla();			    		
	},
	    
	   
	
});