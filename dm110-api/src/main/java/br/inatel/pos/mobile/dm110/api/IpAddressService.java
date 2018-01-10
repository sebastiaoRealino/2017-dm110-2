package br.inatel.pos.mobile.dm110.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poller")
public interface IpAddressService {

	@GET
	@Path("/start/{ip}/{mask}")
	void getIpAddress(@PathParam("ip") String ipAddress, @PathParam ("mask")String mask);

	@GET
	@Path("/status/{ip}")
	@Produces(MediaType.APPLICATION_JSON)
	String getIpAddressStatus(@PathParam("ip") String ipAddress);

}
