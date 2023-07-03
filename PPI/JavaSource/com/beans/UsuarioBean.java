package com.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class UsuarioBean {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public UsuarioBean() {
		// TODO Auto-generated constructor stub

	}

	public Usuario crear(Usuario usu) throws ServiciosException {
		try {
			em.persist(usu);
			em.flush();
			return usu;
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el Usuario");
		}

	}

	public void modificar(Usuario usu) throws ServiciosException {
		try {
			em.merge(usu);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el usuario");
		}

	}

	public void borrar(Long id){
		try {
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.flush();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> obtenerTodos() {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u ORDER BY u.idUsuario ASC",
				Usuario.class);
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
