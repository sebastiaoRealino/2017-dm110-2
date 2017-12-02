package br.inatel.pos.mobile.dm110.interfaces;

public interface Inventory {

	void addNewProduct(String productName);

	String[] listProductNames();

}
