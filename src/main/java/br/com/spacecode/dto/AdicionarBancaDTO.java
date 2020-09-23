package br.com.spacecode.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class AdicionarBancaDTO {
	
	@NotNull
	public BigDecimal valorBanca;

}
