package br.com.spacecode.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.spacecode.model.Banca;
import br.com.spacecode.model.Diversos;

@ApplicationScoped
public class DiversosService {
	
	public List<Diversos> findAll() {
		return Banca.findAll().list();
	}

	public Diversos findById(Long id) {
		return Diversos.findById(id);
	}

	public Response save(Diversos diversos) {
		diversos.persist();
		return Response.status(201).build();
	}

	public Diversos update(Long id, Diversos diversos) {
		Diversos diversosEntidade = Diversos.findById(id);

		if (diversosEntidade == null) {
			throw new WebApplicationException("Esse " + id + " não existe.", Response.Status.NOT_FOUND);
		}

		diversosEntidade.setTag(diversos.getTag());
		diversosEntidade.setTotalInvestido(diversos.getTotalInvestido());

		return diversosEntidade;
	}

	public Response delete(Long id) {
		Diversos diversos = Diversos.findById(id);
		diversos.delete();
		return Response.status(201).build();
	}
}