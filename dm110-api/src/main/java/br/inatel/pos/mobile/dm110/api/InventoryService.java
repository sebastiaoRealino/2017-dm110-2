package br.inatel.pos.mobile.dm110.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
public interface InventoryService {

	@POST
	@Path("/client/{clientName}/{clientEmail}")
	void addNewClient(@PathParam("clientName") String productName, @PathParam ("clientName")String clientEmail);

	@GET
	@Path("/client/all")
	@Produces(MediaType.APPLICATION_JSON)
	String[] listClientNames();

}
