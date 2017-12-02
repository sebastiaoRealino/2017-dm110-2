package br.inatel.pos.mobile.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.pos.mobile.dm110.entities.Product;

@Stateless
public class ProductDAO {

	@PersistenceContext(unitName = "inventory")
	private EntityManager em;

	public void insert(Product product) {
		em.persist(product);
	}

	public List<Product> findAll() {
		return em.createQuery("from Product p", Product.class).getResultList();
	}

}
