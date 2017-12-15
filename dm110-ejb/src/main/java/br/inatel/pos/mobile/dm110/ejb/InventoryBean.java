package br.inatel.pos.mobile.dm110.ejb;

import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.pos.mobile.dm110.dao.ClientDAO;
import br.inatel.pos.mobile.dm110.entities.Client;
import br.inatel.pos.mobile.dm110.interfaces.InventoryLocal;
import br.inatel.pos.mobile.dm110.interfaces.InventoryRemote;

@Stateless
@Local(InventoryLocal.class)
@Remote(InventoryRemote.class)
public class InventoryBean implements InventoryLocal, InventoryRemote {

	@EJB
	private ClientDAO dao;

	@Override
	public void addNewClient(String name, String email) {
		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		dao.insert(client);
		
	}

	@Override
	public String[] listClientNames() {
		return dao.findAll()
				.stream()
				.map(Client::identeValues)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

}
