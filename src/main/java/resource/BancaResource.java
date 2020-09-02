package resource;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Banca;
import service.BancaService;

@Path("/banca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BancaResource {
	
	@Inject
	BancaService service;
	
	@POST
	@Path("/save")
	public Response saveUser(@Valid Banca banca) {
		return service.save(banca);
	}
}