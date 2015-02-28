Ext.define('AM.view.FiltroBoolean', {
    	extend: 'Ext.panel.Panel',    
    	alias: 'widget.filtroBoolean',
    	autoScroll: false,
    	layout: 'hbox',    	
    	 bodyPadding: 5,    	 
         items: [   
                    {	              
						xtype: 'combo',
						store: 'ComboSN',
						queryMode: 'local',
						displayField: 'descripcion',
						valueField: 'valor',					
						editable: false                    
					},
                    {
						xtype: 'button',
						text: 'X',
						action: 'cerrar',
						scope: this
					}
                ]   
});