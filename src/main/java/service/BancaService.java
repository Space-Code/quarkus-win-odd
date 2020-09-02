package service;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import model.Banca;

@ApplicationScoped
public class BancaService {
	
	public Response save(Banca banca) {
		banca.persist();
		return Response.status(201).build();
	}
	
	public Response update(Banca banca) {
		banca.update();
        return Response.status(201).build();
    }
}
