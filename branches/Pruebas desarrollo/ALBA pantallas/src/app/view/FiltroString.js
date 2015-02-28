Ext.define('AM.view.FiltroString', {
    	extend: 'Ext.panel.Panel',    
    	alias: 'widget.filtroString',
    	autoScroll: false,
    	layout: 'hbox',    	
    	 bodyPadding: 5,    	 
         items: [   
                    {
                        xtype: 'textfield',
                        fieldLabel: 'Texto a buscar'
                    },
                    {
						xtype: 'button',
						text: 'X',
						action: 'cerrar',
						scope: this
					}
                ]   
});