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

import br.com.spacecode.model.Diversos;
import br.com.spacecode.service.DiversosService;

@Path("/diversos")
@Tag(name = "diversos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DiversosResource {
	
	@Inject
	DiversosService service;
	
	@GET
	@Path("/search")
	@Transactional
	@Operation(description = "Busca Diversos cadastrada no sistema", summary = "Busca todos os Diversos")
	public List<Diversos> findAllBanca() {
		return service.findAll();
	}

	@GET
	@Path("/search/{id}")
	@Transactional
	@Operation(description = "Busca Diversos cadastrada no sistema pelo id", summary = "Busca Diversos pelo id")
	public Diversos findById(@PathParam("id") Long id) {
		return service.findById(id);
	}

	@POST
	@Path("/save")
	@Transactional
	@Operation(description = "Cadastra Diversos no sistema", summary = "Cadastra Diversos")
	public Diversos saveBanca(@Valid Diversos diversos) {
		service.save(diversos);
		return service.findById(diversos.getId());
	}

	@PUT
	@Path("/update/{id}")
	@Transactional
	@Operation(description = "Atualiza Diversos no sistema pelo id", summary = "Atualiza Diversos pelo id")
	public Response update(@PathParam("id") Long id, @Valid Diversos diversos) {

		Diversos diversosEntidade = service.update(id, diversos);

		return Response.ok(diversosEntidade).build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Transactional
	@Operation(description = "Deleta Diversos no sistema pelo id", summary = "Deleta Diversos pelo id")
	public Response deleteUser(@PathParam("id") Long id) {
		return service.delete(id);
	}
}