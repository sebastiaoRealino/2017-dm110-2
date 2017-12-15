package br.inatel.pos.mobile.dm110.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.pos.mobile.dm110.api.InventoryService;
import br.inatel.pos.mobile.dm110.interfaces.InventoryRemote;

@RequestScoped
public class InventoryServiceImpl implements InventoryService {

	@EJB(lookup = "java:app/dm110-ejb-1.0.0-SNAPSHOT/InventoryBean!br.inatel.pos.mobile.dm110.interfaces.InventoryRemote")
	private InventoryRemote inventoryBean;

	@Override
	public void addNewClient(String clientName, String clientEmail) {
		// TODO Auto-generated method stub
		inventoryBean.addNewClient(clientName, clientEmail);
	}

	@Override
	public String[] listClientNames() {
		return inventoryBean.listClientNames();
	}
}
