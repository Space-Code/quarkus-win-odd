package br.com.spacecode.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "banca")
public class Banca extends PanacheEntityBase {
	
	private BigDecimal valorBanca;

	public Banca() {}

	public BigDecimal getValorBanca() {
		return valorBanca;
	}

	public void setValorBanca(BigDecimal valorBanca) {
		this.valorBanca = valorBanca;
	}
	
}