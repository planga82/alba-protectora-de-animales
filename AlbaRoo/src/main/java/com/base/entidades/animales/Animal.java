package com.base.entidades.animales;

import com.base.entidades.instituciones.Institucion;
import com.base.entidades.personas.Persona;
import com.base.entidades.ubicaciones.Ubicacion;
import com.base.interfaces.JsonObject;
import com.base.interfaces.ResultadoBusquedaGeneral;
import com.base.utilidades.Utilidades;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Animal implements JsonObject, ResultadoBusquedaGeneral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String estado;

	private Date fechaEstado;

	private String chip;

	private String segundoIdentificador;

	private String nombre;

	private String raza;

	private Date fechaNacimiento;

	private String sexo;

	private Boolean esterilizado;

	private String color;

	private String tamano;

	private String propietario;

	private Date fechaRegistro;

	private String descripcion;

	private Blob foto;

	private String lugarRecogida;

	private Boolean recogidoAyuntamiento;

	private String personaAvisa;

	private Date fechaAvisa;

	private String personaRecoge;

	private Date fechaRecoge;

	private String personaRecepciona;

	private Date fechaRecepciona;

	private Double pesoActual;

	private Double alturaCruz;

	private Date fechaPesoActual;

	private String extensionImagen;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<HistoricoPesos> historicoPesos = new HashSet<HistoricoPesos>();

	@ManyToOne(optional = true)
	private Especie especie;

	@ManyToOne(optional = true)
	private Institucion institucionPatrocinadora;

	@ManyToOne(optional = true)
	private Persona personaPatrocinadora;

	@ManyToOne(optional = true)
	private Ubicacion ubicacionActual;

	private Date fechaUbicacionActual;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<HistoricoUbicaciones> historicoUbicaciones = new HashSet<HistoricoUbicaciones>();

	public static List<Animal> findChip(String chip) {
		TypedQuery<Animal> q = entityManager().createQuery(
				"SELECT a FROM Animal a WHERE a.chip = :chip", Animal.class);
		q.setParameter("chip", chip);
		return q.getResultList();
	}

	public static List<Animal> findOtraIdent(String segundoIdentificador) {
		TypedQuery<Animal> q = entityManager()
				.createQuery(
						"SELECT a FROM Animal a WHERE a.segundoIdentificador = :segundoIdentificador",
						Animal.class);
		q.setParameter("segundoIdentificador", segundoIdentificador);
		return q.getResultList();
	}

	public static List<Animal> findNombre(String nombre) {
		TypedQuery<Animal> q = entityManager()
				.createQuery("SELECT a FROM Animal a WHERE a.nombre = :nombre",
						Animal.class);
		q.setParameter("nombre", nombre);
		return q.getResultList();
	}

	public static List<Animal> findRaza(String raza) {
		TypedQuery<Animal> q = entityManager().createQuery(
				"SELECT a FROM Animal a WHERE a.raza = :raza", Animal.class);
		q.setParameter("raza", raza);
		return q.getResultList();
	}

	public static List<Animal> findEsterilizadoFiltroEstados(
			boolean esterilizado) {
		TypedQuery<Animal> q = entityManager()
				.createQuery(
						"SELECT a FROM Animal a WHERE NOT(a.estado = 'BAJA') AND NOT(a.estado = 'ADOPTADO') AND (a.esterilizado = :esterilizado)",
						Animal.class);
		q.setParameter("esterilizado", esterilizado);
		return q.getResultList();
	}

	public static List<Animal> findEsterilizadoSinFiltro(boolean esterilizado) {
		TypedQuery<Animal> q = entityManager().createQuery(
				"SELECT a FROM Animal a WHERE a.esterilizado = :esterilizado",
				Animal.class);
		q.setParameter("esterilizado", esterilizado);
		return q.getResultList();
	}

	public static List<Animal> findrecogidoAyuntamientoSinFiltro(
			boolean recogidoAyuntamiento, Date fecheRegistroDesde,
			Date fecheRegistroHasta) {
		TypedQuery<Animal> q = entityManager()
				.createQuery(
						"SELECT a FROM Animal a WHERE a.recogidoAyuntamiento = :recogidoAyuntamiento AND a.fechaRegistro >= :fecheRegistroDesde AND a.fechaRegistro <= :fecheRegistroHasta",
						Animal.class);
		q.setParameter("recogidoAyuntamiento", recogidoAyuntamiento);
		q.setParameter("fecheRegistroDesde", fecheRegistroDesde);
		q.setParameter("fecheRegistroHasta", fecheRegistroHasta);
		return q.getResultList();
	}

	public static List<Animal> findrecogidoAyuntamientoFiltroEstados(
			boolean recogidoAyuntamiento, Date fecheRegistroDesde,
			Date fecheRegistroHasta) {
		TypedQuery<Animal> q = entityManager()
				.createQuery(
						"SELECT a FROM Animal a WHERE NOT(a.estado = 'BAJA') AND NOT(a.estado = 'ADOPTADO') AND (a.recogidoAyuntamiento = :recogidoAyuntamiento AND a.fechaRegistro >= :fecheRegistroDesde AND a.fechaRegistro <= :fecheRegistroHasta)",
						Animal.class);
		q.setParameter("recogidoAyuntamiento", recogidoAyuntamiento);
		q.setParameter("fecheRegistroDesde", fecheRegistroDesde);
		q.setParameter("fecheRegistroHasta", fecheRegistroHasta);
		return q.getResultList();
	}

	public static List<Animal> findTextoSinFiltro(String texto, int maxResult) {
		TypedQuery<Animal> q = entityManager().createQuery(
				"SELECT a FROM Animal a WHERE "
						+ Utilidades.clausulaWhere(Animal.class
								.getDeclaredFields()), Animal.class);
		q.setParameter("texto", "%" + texto + "%");
		q.setMaxResults(maxResult);
		return q.getResultList();
	}

	public static List<Animal> findTextoFiltroEstados(String texto,
			int maxResult) {
		TypedQuery<Animal> q = entityManager()
				.createQuery(
						"SELECT a FROM Animal a WHERE NOT(a.estado = 'BAJA') AND NOT(a.estado = 'ADOPTADO') AND ("
								+ Utilidades.clausulaWhere(Animal.class
										.getDeclaredFields()) + ")",
						Animal.class);
		q.setParameter("texto", "%" + texto + "%");
		q.setMaxResults(maxResult);
		return q.getResultList();
	}

	public static List<Animal> findSinFiltro() {
		TypedQuery<Animal> q = entityManager().createQuery(
				"SELECT a FROM Animal a ", Animal.class);
		return q.getResultList();
	}

	public static List<Animal> findFiltroEstados() {
		TypedQuery<Animal> q = entityManager()
				.createQuery(
						"SELECT a FROM Animal a WHERE NOT(a.estado = 'BAJA') AND NOT(a.estado = 'ADOPTADO')",
						Animal.class);
		return q.getResultList();
	}

	public static List<Animal> ejecutaQuery(String query,
			Map<String, Object> parametros) {

		TypedQuery<Animal> q = entityManager().createQuery(query, Animal.class);
		Iterator<String> it = parametros.keySet().iterator();
		while (it.hasNext()) {
			String param = (String) it.next();
			q.setParameter(param, parametros.get(param));
		}
		return q.getResultList();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Animal other = (Animal) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String getNombreListado() {
		// TODO Auto-generated method stub
		return "animales";
	}

}
