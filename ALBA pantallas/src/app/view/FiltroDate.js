Ext.define('AM.view.FiltroDate', {
    	extend: 'Ext.panel.Panel',    
    	alias: 'widget.filtroDate',
    	autoScroll: false,
    	layout: 'hbox',    	
    	 bodyPadding: 5,    	 
         items: [  
                 	
                 	{
                 		xtype: 'panel',
                 		layout: 'vbox',
                 		border: false,
                 		items:[
                 		    {
								xtype: 'label',
								name: 'Etiqueta'
							},
							{
								xtype: 'datefield',
								fieldLabel: 'Desde',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.' // custom error message text
							},
							{
								xtype: 'datefield',
								fieldLabel: 'Hasta',
								format: 'd/m/Y',
								msgTarget: 'under', // location of the error message
								invalidText: '"{0}" Incorrecto. "{1}" Formato correcto.' // custom error message text
							}                  		
                 		]                 		
                 	},
					{
						xtype: 'button',
						text: 'X',
						action: 'cerrar',
						scope: this
					}
                    
                ]   
});