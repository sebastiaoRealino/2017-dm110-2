package br.inatel.pos.mobile.dm110.entities;

import java.io.Serializable;



public class IpAddressTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1141686509725947372L;

	public String ip;
	public Boolean status;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
}
