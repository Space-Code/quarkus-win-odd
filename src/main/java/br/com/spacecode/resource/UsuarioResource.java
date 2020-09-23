package br.com.spacecode.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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

import br.com.spacecode.dto.AdicionarUsuarioDTO;
import br.com.spacecode.dto.AtualizarUsuarioDTO;
import br.com.spacecode.dto.UsuarioDTO;
import br.com.spacecode.mapper.UsuarioMapper;
import br.com.spacecode.model.Usuario;

@Path("/usuario")
@Tag(name = "usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

	UsuarioMapper usuarioMapper;

	@GET
	@Operation(description = "Busca usuário cadastrados no sistema", summary = "Busca todos os usuários")
	public List<UsuarioDTO> buscar() {
		Stream<Usuario> usuarios = Usuario.streamAll();
		return usuarios.map(u -> usuarioMapper.toUsuarioDTO(u)).collect(Collectors.toList());
	}

	@POST
	@Operation(description = "Cadastra usuário no sistema", summary = "Cadastra usuário")
	public Response adicionar(@Valid AdicionarUsuarioDTO dto) {
		Usuario usuario = usuarioMapper.toUsuario(dto);
		usuario.persist();

		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Path("{id}")
	@Operation(description = "Busca um usuário no sistema e atualiza usuário por nome", summary = "Atualiza usuário por nome")
	@Transactional
	public void atualizar(@PathParam("id") Long id, AtualizarUsuarioDTO dto) {
		Optional<Usuario> usuario = Usuario.findByIdOptional(id);

		if (usuario.isEmpty()) {
			throw new NotFoundException();
		}

		Usuario user = usuario.get();

		usuarioMapper.toUsuario(dto, user);

		user.persist();
	}

	@DELETE
	@Path("{id}")
	@Operation(description = "Exclui usuário do sistema", summary = "Exclui usuário por nome")
	public void delete(@PathParam("id") Long id) {
		Optional<Usuario> restauranteOp = Usuario.findByIdOptional(id);
		restauranteOp.ifPresentOrElse(Usuario::delete, () -> {
			throw new NotFoundException();
		});
	}
}