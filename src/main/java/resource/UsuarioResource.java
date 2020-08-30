package resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Usuario;
import service.UsuarioService;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
	
	@Inject
	UsuarioService service;
	
	@GET
	@Path("/search")
	public List<Usuario> findAllUser() {
		return service.findAll();
	}

	@GET
	@Path("/search/{name}")
	public Usuario findUser(@PathParam("name") String name) {
		return service.findByName(name);
	}

	@POST
	@Path("/save")
	public Response saveUser(@Valid Usuario user) {
		return service.save(user);
	}

	@PUT
	@Path("/update/{name}")
	public Response updateUser(@PathParam("name") String name, @Valid Usuario user) {
		return service.update(name, user);
	}

	@DELETE
	@Path("/delete/{name}")
	public Response deleteUser(@PathParam("name") String name) {
		return service.delete(name);
	}
}