package br.com.spacecode.resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	@Operation(description = "Busca banca cadastrada no sistema", summary = "Busca todos as bancas")
	public List<Banca> findAllBanca() {
		return service.findAll();
	}

	@POST
	@Path("/save")
	@Operation(description = "Cadastra banca no sistema", summary = "Cadastra banca")
	public Response saveBanca(@Valid Banca banca) {
		return service.save(banca);
	}

}