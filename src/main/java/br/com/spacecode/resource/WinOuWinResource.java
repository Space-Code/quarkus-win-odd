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

import br.com.spacecode.model.WinOuWin;
import br.com.spacecode.service.WinOuWinService;

@Path("/win")
@Tag(name = "win ou win")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WinOuWinResource {
	
	@Inject
	WinOuWinService service;
	
	@GET
	@Path("/search")
	@Transactional
	@Operation(description = "Busca Win ou Win cadastrada no sistema", summary = "Busca todos as winwin")
	public List<WinOuWin> findAllBanca() {
		return service.findAll();
	}

	@GET
	@Path("/search/{id}")
	@Transactional
	@Operation(description = "Busca Win ou Win cadastrada no sistema pelo id", summary = "Busca Win ou Win pelo id")
	public WinOuWin findById(@PathParam("id") Long id) {
		return service.findById(id);
	}

	@POST
	@Path("/save")
	@Transactional
	@Operation(description = "Cadastra Win ou Win no sistema", summary = "Cadastra Win ou Win")
	public WinOuWin saveBanca(@Valid WinOuWin win) {
		service.save(win);
		return service.findById(win.getId());
	}

	@PUT
	@Path("/update/{id}")
	@Transactional
	@Operation(description = "Atualiza Win ou Win no sistema pelo id", summary = "Atualiza Win ou Win pelo id")
	public Response update(@PathParam("id") Long id, @Valid WinOuWin win) {

		WinOuWin bancaa = service.update(id, win);

		return Response.ok(bancaa).build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Transactional
	@Operation(description = "Deleta Win ou Win no sistema pelo id", summary = "Deleta Win ou Win pelo id")
	public Response deleteUser(@PathParam("id") Long id) {
		return service.delete(id);
	}
}