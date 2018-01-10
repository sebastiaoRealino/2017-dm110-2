package br.inatel.pos.mobile.dm110.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.pos.mobile.dm110.api.IpAddressService;

import br.inatel.pos.mobile.dm110.interfaces.IpAddressRemoteInterface;
@RequestScoped
public class IpAddressServiceImpl implements IpAddressService{

	@EJB(lookup = "java:app/dm110-ejb-1.0.0-SNAPSHOT/IpAddressBean!br.inatel.pos.mobile.dm110.interfaces.IpAddressRemoteInterface")
	//private IpAddressServiceImpl ipAddressRemote;
	private IpAddressRemoteInterface ipAddressRemote;
	
	@Override
	public void getIpAddress(String ipAddress, String mask) {
		ipAddressRemote.getIpAddress(ipAddress, mask);
	}

	@Override
	public String getIpAddressStatus(String ip) {
		// TODO Auto-generated method stub
		return ipAddressRemote.getIpAddressStatus(ip);
	}

}
