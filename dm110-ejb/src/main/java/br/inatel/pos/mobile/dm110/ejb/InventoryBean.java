package br.inatel.pos.mobile.dm110.ejb;

import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.pos.mobile.dm110.dao.ProductDAO;
import br.inatel.pos.mobile.dm110.entities.Product;
import br.inatel.pos.mobile.dm110.interfaces.InventoryLocal;
import br.inatel.pos.mobile.dm110.interfaces.InventoryRemote;

@Stateless
@Local(InventoryLocal.class)
@Remote(InventoryRemote.class)
public class InventoryBean implements InventoryLocal, InventoryRemote {

	@EJB
	private ProductDAO dao;

	@Override
	public void addNewProduct(String productName) {
		Product product = new Product();
		product.setName(productName);
		product.setQuantity(0);
		dao.insert(product);
	}

	@Override
	public String[] listProductNames() {
		return dao.findAll()
				.stream()
				.map(Product::getName)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

}
