package br.inatel.pos.mobile.dm110.interfaces;

public interface IpAddressLocalInterface extends IpAddressInterface{
	public void getIpAddress(String ipAddress, String mask);

	
	public String getIpAddressStatus(String ip);
}
