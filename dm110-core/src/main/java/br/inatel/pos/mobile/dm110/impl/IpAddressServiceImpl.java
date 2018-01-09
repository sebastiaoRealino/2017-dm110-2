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
		System.out.println("CAIU AQUIIIIII!"+ipAddress+" "+mask);
		ipAddressRemote.getIpAddress(ipAddress, mask);
		System.out.println("NAO PASSOU DAQUI!");
	}

	@Override
	public String[] getIpAddressStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
