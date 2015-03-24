Ext.define('AM.view.SeleccionInstitucion', {
    	extend: 'Ext.panel.Panel',    
    	alias: 'widget.seleccionInstitucion',										
	title: 'Consulta de Institución',
    	
    	items: [
    		{
    		xtype: 'panel',    		
    		bodyPadding: 20, 
    		width: 600,   		
    		items: [   			
    			{
    			xtype: 'form',
                	bodyPadding: 10,                	
                	items: [
                		{
                		name: 'nombre',
                		xtype: 'textfield',
                		fieldLabel: 'Nombre'
                		},
                		{
                		name: 'NIF',
                		xtype: 'textfield',
                		fieldLabel: 'NIF'
                		},
		                {
		                xtype: 'textfield',
		                name : 'personaContacto',
		                fieldLabel: 'Persona de Contacto',		                
		                },
		                ,
	                    	{
	                    	xtype: 'checkbox',
	                    	boxLabel: 'Incluir instituciones en estado de baja en el resultado de la búsqueda',
	                    	name:'incluirEstadoBaja'	                    	                 		                    	
	                    	}               		               		
                		],
                	buttons: [
                		{
                		text: 'Buscar',
		                action: 'buscar'
                		}
                		]
    			}
    			
    		]
    		},
    		{
    		xtype: 'gridpanel',
    		title: 'Resultados',
    		height: 300,
    		width: 600,
    		store: 'Instituciones',
    		dockedItems: [{
		        xtype: 'pagingtoolbar',
		        store: 'Instituciones',   // same store GridPanel is using
		        dock: 'bottom',
		        displayInfo: true
		    }],

    		columns: [
		        {
		            text: 'Nombre',
		            width: 200,		            
		            dataIndex: 'nombre'
		        },
		        {
		            text: 'Tipo',
		            width: 200,
		            dataIndex: 'tipo'
		        },
		        {
		            text: 'Persona de Contacto',
		            width: 200,
		            dataIndex: 'personaContacto'
		        }
		    ]

    		},{   
    		xtype:'panel',
    		bodyPadding: 0,
    		width: 600,    		   		
    		items: [{     		
		      xtype: 'fieldcontainer',		      
		      
		      items: [
		      		{
		              	xtype: 'button',
		            	text : 'Seleccionar',
		            	margin: '5 5 5 5',
		            	action: 'seleccion',
		            	cls: 'consulta'	
		        	}
		        ]
		}]	                                 
	        }
    	]
    	

  
});