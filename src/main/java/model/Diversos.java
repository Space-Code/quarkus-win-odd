package model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "diversos")
public class Diversos extends PanacheMongoEntity {
	
	private Banca bancaDiversos;
	private String odd;
	
	public Diversos() {}

	public Banca getBancaDiversos() {
		return bancaDiversos;
	}
	
	public void setBancaDiversos(Banca bancaDiversos) {
		this.bancaDiversos = bancaDiversos;
	}
	
	public String getOdd() {
		return odd;
	}
	
	public void setOdd(String odd) {
		this.odd = odd;
	}
}