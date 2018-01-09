package br.inatel.pos.mobile.dm110.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.pos.mobile.dm110.entities.IpAddress;
import br.inatel.pos.mobile.dm110.entities.IpAddressTO;

@Stateless
public class IpAddressDAO {

	@PersistenceContext(unitName = "postgres")
	private EntityManager em;

	public void insert(IpAddressTO ipAddressTO) {
		IpAddress address = new IpAddress();
		address.setIp(ipAddressTO.getIp());
		address.setStatus(ipAddressTO.getStatus());
		em.merge(address);
	}

	public String checkStatus(String ip) {
		String res;
		if ((em.createQuery("from IpAddress es where es.ip=:ip", IpAddress.class).setParameter("ip", ip)
				.getResultList()).size() == 0) {
			res = "Ip nao existe";
		} else {
			if (em.createQuery("from IpAddress es where es.ip=:ip", IpAddress.class).setParameter("ip", ip)
					.getResultList().get(0).getStatus()) {
				res = "IP ON";
			} else {
				res = "IP OFF";
			}
		}
		return res;
	}
}
