package br.com.spacecode.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
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
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.spacecode.model.Banca;
import br.com.spacecode.service.BancaService;

@Path("/banca")
@Tag(name = "banca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BancaResource {

	@Inject
	BancaService service;

	@GET
	@Path("/search")
	@Transactional
	@Operation(description = "Busca banca cadastrada no sistema", summary = "Busca todos as bancas")
	public List<Banca> findAllBanca() {
		return service.findAll();
	}

	@GET
	@Path("/search/{id}")
	@Transactional
	@Operation(description = "Busca banca cadastrada no sistema pelo id", summary = "Busca banca pelo id")
	public Banca findById(@PathParam("id") Long id) {
		return service.findById(id);
	}

	@POST
	@Path("/save")
	@Transactional
	@Operation(description = "Cadastra banca no sistema", summary = "Cadastra banca")
	public Response saveBanca(@Valid Banca banca) {
		return service.save(banca);
	}

	@PUT
	@Path("/update/{id}")
	@Transactional
	@Operation(description = "Atualiza banca no sistema pelo id", summary = "Atualiza banca pelo id")
	public Response update(@PathParam("id") Long id, @Valid Banca banca) {

		Banca bancaa = service.update(id, banca);

		return Response.ok(bancaa).build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Transactional
	@Operation(description = "Deleta banca no sistema pelo id", summary = "Deleta banca pelo id")
	public Response deleteUser(@PathParam("id") Long id) {
		return service.delete(id);
	}

}