package resource;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@PUT
	@Path("/update/{minhaBanca}")
	public Response updateUser(@PathParam("minhaBanca") BigDecimal minhaBanca, @Valid Banca banca) {
		return service.update(minhaBanca, banca);
	}
	
	@GET
	@Path("/search")
	public List<Banca> findAllUser() {
		return service.findAll();
	}
}