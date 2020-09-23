package br.com.spacecode.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "banca")
public class Banca extends PanacheEntityBase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	
	private BigDecimal valorBanca;

	public Banca() {}

	public BigDecimal getMinhaBanca() {
		return valorBanca;
	}

	public void setMinhaBanca(BigDecimal minhaBanca) {
		this.valorBanca = minhaBanca;
	}
}