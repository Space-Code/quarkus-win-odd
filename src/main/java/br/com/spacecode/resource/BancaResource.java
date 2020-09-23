package br.com.spacecode.resource;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.spacecode.dto.AdicionarBancaDTO;
import br.com.spacecode.dto.AtualizarBancaDTO;
import br.com.spacecode.mapper.BancaMapper;
import br.com.spacecode.model.Banca;
import br.com.spacecode.model.Usuario;

@Path("/banca")
@Tag(name = "banca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BancaResource {
	
	BancaMapper bancaMapper;
	
	@POST
	@Operation(description = "Cadastra banca no sistema", summary = "Cadastra banca")
	public Response adicionar(@Valid AdicionarBancaDTO dto) {
		Banca banca = bancaMapper.toBanca(dto);
		banca.persist();

		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Path("{id}")
	@Operation(description = "Busca a banca no sistema e atualiza banca por id", summary = "Atualiza banca por id")
	@Transactional
	public void atualizar(@PathParam("id") Long id, AtualizarBancaDTO dto) {
		Optional<Banca> banca = Usuario.findByIdOptional(id);

		if (banca.isEmpty()) {
			throw new NotFoundException();
		}

		Banca valorBanca = banca.get();

		bancaMapper.toBanca(dto, valorBanca);

		valorBanca.persist();
	}

}