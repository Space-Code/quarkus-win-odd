package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "diversos")
public class Diversos extends PanacheEntityBase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	
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