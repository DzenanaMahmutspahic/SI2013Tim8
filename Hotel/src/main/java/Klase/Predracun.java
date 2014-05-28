package Klase;

import java.io.Serializable;

public class Predracun implements Serializable {
	private long Id;
	private double popust;
	private Rezervacija rezervacija;
	private double ukupnaCijena;

	public Predracun() {}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public double getPopust() {
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
	
	public double getUkupnaCijena() {
		return ukupnaCijena;
	}

	public void setUkupnaCijena(double ukupnaCijena) {
		this.ukupnaCijena = ukupnaCijena;
	}
	
	
}
