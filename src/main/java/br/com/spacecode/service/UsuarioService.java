package br.com.spacecode.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import br.com.spacecode.model.Usuario;

@ApplicationScoped
public class UsuarioService {

	public List<Usuario> findAll() {
		return Usuario.findAll().list();
	}

	public Usuario findByName(String nome) {
		return Usuario.find("nome", nome).firstResult();
	}

	public Response save(Usuario usuario) {
		usuario.persist();
		return Response.status(201).build();
	}


	public Response delete(String nome) {
		Usuario usuario = findByName(nome);
		usuario.delete();
		return Response.status(201).build();
	}
}