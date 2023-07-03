package com.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Itr;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class ItrBean {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ItrBean() {
		// TODO Auto-generated constructor stub

	}

	public Itr crear(Itr i) throws ServiciosException {
		try {
			em.persist(i);
			em.flush();
			return i;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el Itr");
		}

	}

	public void modificar(Itr i) throws ServiciosException {
		try {
			em.merge(i);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el itr");
		}

	}

	public void borrar(Long id){
		try {
			Itr itr = em.find(Itr.class, id);
			em.remove(itr);
			em.flush();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	public List<Itr> obtenerTodos() {
		TypedQuery<Itr> query = em.createQuery("SELECT u FROM Itr u ORDER BY u.idItr ASC",
				Itr.class);
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
