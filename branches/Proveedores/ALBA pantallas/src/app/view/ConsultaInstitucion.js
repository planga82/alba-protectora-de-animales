Ext.define('AM.view.ConsultaInstitucion', {
    	extend: 'Ext.panel.Panel',    
    	alias: 'widget.consultaInstitucion',										
	title: 'Consulta de Institución',
    	
    	items: [
    		{
    		xtype: 'form',
    		width: 600, 
		layout: {
	            type:'vbox',
	            padding:'10',
	            align:'left'
	        },								
                items: [{       
                	xtype: 'fieldcontainer',
			layout: 'hbox',			
			items: [			         		
		        	{
		        	name: 'textoBusqueda',
		        	xtype: 'textfield',
		                fieldLabel: 'Texto a buscar',
		                width: 400
		                },
		                {
		                xtype: 'button',
			        text : 'Buscar',
			        action: 'buscar',
			        margin: '0 0 0 5'
		                }
	                	]
	                },
	                {
						xtype: 'fieldcontainer',
						defaultType: 'checkboxfield',
						items: [
		                {
		                    boxLabel  : 'Incluir elementos en estado de baja',
		                    name      : 'baja',
		                    inputValue: '1',
		                }
						]
	                }            		               		
                ]  		          	    		
    		},
    		{
    		xtype: 'gridpanel',
    		height: 300,
    		width: 600,
    		store: 'ResultadoBusquedaInstituciones',
    		columns: [
		        {
		            text: 'Nombre Institucion',
		            width: 150,		            
		            dataIndex: 'nombreInstitucion'
		        },
		        {
		            text: 'Descripcion',
		            width: 450,
		            dataIndex: 'descripcionResultado'		           
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
		            	text : 'Detalle',
		            	margin: '5 5 5 5',
		            	action: 'detalle',
		            	cls: 'consulta'	
		        	},     
		        	{
		                xtype: 'button',
		            	text : 'Modificacion',
		            	margin: '5 5 5 5',
		            	action: 'modificar',
		            	cls: 'consulta'
		        	},     
		        	{
		                xtype: 'button',
		            	text : 'Cambio Estado',
		            	margin: '5 5 5 5',
		            	action: 'cambioEstado',
		            	cls: 'consulta'
		        	},     
		        	{
		                xtype: 'button',
		            	text : 'Gestión Ubicaciones',
		            	margin: '5 5 5 5',
		            	action: 'ubicaciones',
		            	cls: 'consulta'
		        	}
		        ]
		}]	                                 
	        }
    	]
    	

  
});