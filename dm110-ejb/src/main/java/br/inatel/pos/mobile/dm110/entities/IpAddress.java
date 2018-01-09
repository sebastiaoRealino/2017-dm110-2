package br.inatel.pos.mobile.dm110.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ipaddress")
public class IpAddress implements Serializable{
	
	private static final long serialVersionUID = -4887666010522559009L;
	@Id
	@Column(name = "ip")
	public String ip;
	@Column(name = "status")
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
