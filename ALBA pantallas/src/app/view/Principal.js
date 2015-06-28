Ext.define('AM.view.Principal', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.panelPrincipal',
	autoScroll : true,
	items : [ {
		xtype : 'panel',
		items : [ {
			xtype : 'toolbar',
			items : [ {
				text : 'Animales',
				menu : {
					items : [ {
						text : 'Alta',
						id : 'altaAnimal'
					}, {
						text : 'Consulta',
						id : 'consultaAnimal'
					} ]
				}
			}, {
				text : 'Instituciones',
				menu : {
					items : [ {
						text : 'Alta',
						id : 'altaInstituciones'
					}, {
						text : 'Consulta',
						id : 'consultaInstituciones'
					} ]
				}
			}, {
				text : 'Personas',
				menu : {
					items : [ {
						text : 'Alta',
						id : 'altaPersonas'
					}, {
						text : 'Consulta',
						id : 'consultaPersonas'
					} ]
				}
			
			/*medicamentos*/
			
			}, {
				text : 'Medicamentos',
				menu : {
					items : [ {
						text : 'Alta',
						id : 'altaMedicamentos'
					}, {
						text : 'Consulta',
						id : 'consultaMedicamentos'
					} ]
				}
			
			/* fin medicamentos*/
			
			} ]
		}, {
			xtype : 'panel',
			id : 'panelContenidos'
		} ]
	} ]
});