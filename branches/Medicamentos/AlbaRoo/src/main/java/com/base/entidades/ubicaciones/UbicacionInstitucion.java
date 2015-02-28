package com.base.entidades.ubicaciones;

import java.util.List;

import com.base.entidades.instituciones.Institucion;
import com.base.interfaces.JsonObject;

import javax.persistence.ManyToOne;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class UbicacionInstitucion extends Ubicacion implements JsonObject{

    @ManyToOne(optional=true)
    private Institucion institucion;

    public static List<UbicacionInstitucion> findUbicacion(Institucion i, String identificador) {
    	TypedQuery<UbicacionInstitucion> q = entityManager().createQuery("SELECT o FROM UbicacionInstitucion o WHERE (o.identificador = :identificador) AND o.institucion.nombre = :nombreInstitucion", UbicacionInstitucion.class);
        q.setParameter("identificador", identificador);
        q.setParameter("nombreInstitucion", i.getNombre());
    	return q.getResultList();
    }
    

	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "ubicaciones";
	}


	@Override
	public String getNombreMostrar() {
		// TODO Auto-generated method stub
		return institucion.getNombre() + " " + getNombre();
	}
   
}
