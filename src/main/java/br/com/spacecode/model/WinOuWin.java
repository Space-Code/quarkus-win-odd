package br.com.spacecode.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "winouwin")
public class WinOuWin extends PanacheEntityBase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	
	private BigDecimal oddA;
	private BigDecimal oddB;
	private String tag;
	
	public WinOuWin() {}

	public BigDecimal getOddA() {
		return oddA;
	}

	public void setOddA(BigDecimal oddA) {
		this.oddA = oddA;
	}

	public BigDecimal getOddB() {
		return oddB;
	}

	public void setOddB(BigDecimal oddB) {
		this.oddB = oddB;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}	
}