package Klase;

import java.io.Serializable;

public class Predracun implements Serializable {
	private long Id;
	private Double popust;
	private Rezervacija rezervacija;
	private Double ukupnaCijena;

	public Predracun() {}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Double getPopust() {
		return popust;
	}

	public void setPopust(double popust) {
		this.popust = popust;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
	
	public Double getUkupnaCijena() {
		return ukupnaCijena;
	}

	public void setUkupnaCijena(double ukupnaCijena) {
		this.ukupnaCijena = ukupnaCijena;
	}
	
	@Override
	public boolean equals(Object o){
		if(!o.getClass().equals(Predracun.class)) return false;
		if(!(this.getId() == ((Predracun)o).getId())) return false;
		return true;
	}
}
