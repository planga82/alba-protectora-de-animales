package com.servicios.proveedores;

import org.apache.log4j.Logger;

import com.base.entidades.proveedores.Proveedor;
import com.constants.MensajesError;
import com.servicios.proveedores.contenedores.ContenedorAltaProveedor;


public class ProveedorService {

	static Logger logger = Logger.getLogger(ProveedorService.class);
	
	public Proveedor alta(ContenedorAltaProveedor c) throws Exception{
		
		if(c.getNombre()==null || c.getNombre().equals("")){
			throw new Exception(MensajesError.codProveedorVacioNoPermitido);
		}
		if(Proveedor.findProveedor(c.getNombre())!= null){
			throw new Exception(MensajesError.codProveedorDuplicado);
		}
		
		Proveedor p = new Proveedor();
		p.setNombre(		c.getNombre()        ) ;       
		p.setCif(			c.getCif()           ) ;          
		p.setDomicilio(		c.getDomicilio()     );   
		p.setLocalidad(		c.getLocalidad()     );     
		p.setProvincia(		c.getProvincia()     );     
		p.setCodigoPostal(	c.getCodigoPostal()  );  
		p.setPais(			c.getPais()          );          
		p.setFax(			c.getFax()           );           
		p.setTelefono(		c.getTelefono()      );      
		p.setEmail(			c.getEmail()         );         
		p.setNombreContacto(c.getNombreContacto());
		p.setDniContacto(	c.getDniContacto()   );   
		p.setCargoContacto(	c.getCargoContacto() ); 
		p.setNumeroCuenta(	c.getNumeroCuenta()  );
		p.persist();
		
		return p;
	}
}
