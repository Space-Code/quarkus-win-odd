package br.com.spacecode.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import br.com.spacecode.model.Banca;

@ApplicationScoped
public class BancaService {

	public List<Banca> findAll() {
		return Banca.findAll().list();
	}

	public Response save(Banca banca) {
		banca.persist();
		return Response.status(201).build();
	}

}