package br.com.spacecode.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.spacecode.model.Banca;

@ApplicationScoped
public class BancaService {

	public List<Banca> findAll() {
		return Banca.findAll().list();
	}

	public Banca findById(Long id) {
		return Banca.findById(id);
	}

	public Response save(Banca banca) {
		banca.persist();
		return Response.status(201).build();
	}

	public Banca update(Long id, Banca banca) {
		Banca bancaEntidade = Banca.findById(id);

		if (bancaEntidade == null) {
			throw new WebApplicationException("Esse " + id + " não existe.", Response.Status.NOT_FOUND);
		}

		bancaEntidade.setValorBanca(banca.getValorBanca());

		return bancaEntidade;
	}

	public Response delete(Long id) {
		Banca banca = Banca.findById(id);
		banca.delete();
		return Response.status(201).build();
	}
}