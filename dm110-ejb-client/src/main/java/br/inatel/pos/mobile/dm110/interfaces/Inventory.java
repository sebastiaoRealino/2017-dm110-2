package br.inatel.pos.mobile.dm110.interfaces;

public interface Inventory {

	void addNewClient(String name, String email);

	String[] listClientNames();

}
