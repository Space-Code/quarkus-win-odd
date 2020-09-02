package service;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import model.Banca;

@ApplicationScoped
public class BancaService {

	public Response save(Banca banca) {
		banca.persist();
		return Response.status(201).build();
	}

	public Response update(BigDecimal minhaBanca, Banca banca) {
		banca.update();
		return Response.status(201).build();
	}
	
	public List<Banca> findAll() {
        return Banca.findAll().list();
    }
}