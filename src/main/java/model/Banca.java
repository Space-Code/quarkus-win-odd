package model;

import java.math.BigDecimal;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "banca")
public class Banca extends PanacheMongoEntity {
	
	private BigDecimal minhaBanca;

	public Banca() {}

	public BigDecimal getMinhaBanca() {
		return minhaBanca;
	}

	public void setMinhaBanca(BigDecimal minhaBanca) {
		this.minhaBanca = minhaBanca;
	}
}