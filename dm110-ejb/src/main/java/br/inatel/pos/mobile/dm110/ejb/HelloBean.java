package br.inatel.pos.mobile.dm110.ejb;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.pos.mobile.dm110.dao.ProductDAO;
import br.inatel.pos.mobile.dm110.entities.Product;
import br.inatel.pos.mobile.dm110.interfaces.HelloLocal;
import br.inatel.pos.mobile.dm110.interfaces.HelloRemote;

@Stateless
@Local(HelloLocal.class)
@Remote(HelloRemote.class)
public class HelloBean implements HelloLocal, HelloRemote {

	@EJB
	private ProductDAO dao;

	@Override
	public String sayHello(String name) {
		System.out.println("#### Inside session bean...");

		Product product = new Product();
		product.setName(name);
		product.setQuantity(0);
		dao.insert(product);

		return "Hello " + name + "!!!";
	}

}




