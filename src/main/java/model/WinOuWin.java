package model;

import java.math.BigDecimal;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "winouwin")
public class WinOuWin extends PanacheMongoEntity {
	
	private String corretoraA;
	private String corretoraB;
	private BigDecimal oddA;
	private BigDecimal oddB;
	private String tag;
	
	public WinOuWin() {}

	public String getCorretoraA() {
		return corretoraA;
	}

	public void setCorretoraA(String corretoraA) {
		this.corretoraA = corretoraA;
	}

	public String getCorretoraB() {
		return corretoraB;
	}

	public void setCorretoraB(String corretoraB) {
		this.corretoraB = corretoraB;
	}

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