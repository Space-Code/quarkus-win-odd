package br.com.spacecode.dto;

import javax.validation.constraints.NotNull;

public class AdicionarUsuario {
	
	@NotNull
	public String nome;
	
	@NotNull
	public String email;

}
