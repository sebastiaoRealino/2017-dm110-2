package br.inatel.pos.mobile.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.pos.mobile.dm110.entities.Client;

@Stateless
public class ClientDAO {

	@PersistenceContext(unitName = "clientbase")
	private EntityManager em;

	public void insert(Client product) {
		em.persist(product);
	}

	public List<Client> findAll() {
		return em.createQuery("from Client c", Client.class).getResultList();
	}

}
