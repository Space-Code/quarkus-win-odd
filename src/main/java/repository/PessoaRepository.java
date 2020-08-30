package repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Usuario;

@ApplicationScoped
public class PessoaRepository implements PanacheMongoRepository<Usuario> {

	public Usuario findByName(String nome) {
		return find("name", nome).firstResult();
	}

}