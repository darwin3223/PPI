package com.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.CarreraEspecialidad;
import com.entities.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class CarreraEspecialidadBean {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CarreraEspecialidadBean() {
		// TODO Auto-generated constructor stub

	}

	public CarreraEspecialidad crear(CarreraEspecialidad caresp) throws ServiciosException {
		try {
			em.persist(caresp);
			em.flush();
			return caresp;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el CarreraEspecialidad");
		}

	}

	public void modificar(CarreraEspecialidad caresp) throws ServiciosException {
		try {
			em.merge(caresp);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el carespario");
		}

	}

	public void borrar(Long id){
		try {
			CarreraEspecialidad caresp = em.find(CarreraEspecialidad.class, id);
			em.remove(caresp);
			em.flush();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	public List<CarreraEspecialidad> obtenerTodos() {
		TypedQuery<CarreraEspecialidad> query = em.createQuery("SELECT u FROM CarreraEspecialidad u ORDER BY u.idCarreraEspecialidad ASC",
				CarreraEspecialidad.class);
		return query.getResultList();
	}

//	public Usuario buscarUsuario(Long id) {
//		Usuario empleadoEmpresa = em.find(Usuario.class, id);
//		return empleadoEmpresa;
//	}

//	public Usuario obtenerPorFiltro(Long id, String detalle, Date fecha, String hora) {
//
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//
//		CriteriaQuery<Usuario> configConsulta = cb.createQuery(Usuario.class);
//
//		Root<Usuario> raizAccCons = configConsulta.from(Usuario.class);
//
//		configConsulta.select(raizAccCons);
//
//		List<Predicate> predicates = new ArrayList<Predicate>();
//
//		if (id != null) {
//			predicates.add(cb.equal(raizAccCons.get("idUsuario"), id));
//		}
//		if (detalle != null) {
//			predicates.add(cb.equal(raizAccCons.get("detalle"), detalle));
//		}
//		if (fecha != null) {
//			predicates.add(cb.equal(raizAccCons.get("fecha"), fecha));
//		}
//		if (hora != null) {
//			predicates.add(cb.equal(raizAccCons.get("hora"), hora));
//		}
//
//		configConsulta.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
//
//		return em.createQuery(configConsulta).getSingleResult();
//	}

}
