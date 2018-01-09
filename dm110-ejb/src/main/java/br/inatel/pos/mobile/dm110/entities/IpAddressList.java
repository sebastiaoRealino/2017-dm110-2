package br.inatel.pos.mobile.dm110.entities;

import java.io.Serializable;

public class IpAddressList implements Serializable {

	private static final long serialVersionUID = 2688492439294962221L;
	private String[] lista = new String[10];


	public String[] getList() {
		return lista;
	}


	public void setList(String[] lista) {
		this.lista = lista;
	}


}