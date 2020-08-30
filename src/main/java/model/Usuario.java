package model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "usuario")
public class Usuario extends PanacheMongoEntity {

    private String nome;
    private String email;
    private String senha;

    public Usuario() {}
    
    public static Usuario findByName(String nome) {
        return find("nome", nome).firstResult();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
