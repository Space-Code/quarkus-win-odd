package br.com.spacecode.resource;

import java.util.List;

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

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.spacecode.model.Usuario;

@Path("/usuario")
@Tag(name = "usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
	

	/*
	 * @GET
	 * 
	 * @Path("/search")
	 * 
	 * @Operation(description = "Busca usuário cadastrados no sistema", summary =
	 * "Busca todos os usuários") public List<Usuario> findAllUser() { return
	 * service.findAll(); }
	 * 
	 * @GET
	 * 
	 * @Path("/search/{name}")
	 * 
	 * @Operation(description = "Busca usuário cadastrados no sistema", summary =
	 * "Busca usuário por nome")
	 * 
	 * @APIResponse(responseCode = "404", description = "Caso o usuário não exista")
	 * 
	 * @APIResponse(responseCode = "200", description = "OK") public Usuario
	 * findUser(@PathParam("name") String name) { return service.findByName(name); }
	 * 
	 * @POST
	 * 
	 * @Path("/save")
	 * 
	 * @Operation(description = "Cadastra usuário no sistema", summary =
	 * "Cadastra usuário") public Response saveUser(@Valid Usuario user) { return
	 * service.save(user); }
	 * 
	 * @PUT
	 * 
	 * @Path("/update/{name}")
	 * 
	 * @Operation(description =
	 * "Busca um usuário no sistema e atualiza usuário por nome", summary =
	 * "Atualiza usuário por nome") public Response updateUser(@PathParam("name")
	 * String name, @Valid Usuario user) { return service.update(name, user); }
	 * 
	 * @DELETE
	 * 
	 * @Path("/delete/{name}")
	 * 
	 * @Operation(description = "Exclui usuário do sistema", summary =
	 * "Exclui usuário por nome") public Response deleteUser(@PathParam("name")
	 * String name) { return service.delete(name); }
	 */
}