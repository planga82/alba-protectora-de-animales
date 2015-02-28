package com.base.entidades.ubicaciones;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.base.entidades.animales.Animal;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public abstract class Ubicacion {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long idInterno;
		
		private String nombre;
		

	    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	    private Set<Animal> animales = new HashSet<Animal>();
	    
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (idInterno ^ (idInterno >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Ubicacion other = (Ubicacion) obj;
			if (idInterno != other.idInterno)
				return false;
			return true;
		}
		
		public abstract String getNombreMostrar();
	    
	    
	    
}
