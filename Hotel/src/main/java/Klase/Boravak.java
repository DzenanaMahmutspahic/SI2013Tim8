package Klase;

import java.io.Serializable;
import java.util.Date;

public class Boravak implements Serializable {
	private long Id;
	private Gost gost;
	private Rezervacija rezervacija;
	private Date vrijemeDolaska;
	private Date vrijemeOdlaska;
	
	public Boravak() {}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

	public Date getVrijemeDolaska() {
		return vrijemeDolaska;
	}

	public void setVrijemeDolaska(Date vrijemeDolaska) {
		this.vrijemeDolaska = vrijemeDolaska;
	}

	public Date getVrijemeOdlaska() {
		return vrijemeOdlaska;
	}

	public void setVrijemeOdlaska(Date vrijemeOdlaska) {
		this.vrijemeOdlaska = vrijemeOdlaska;
	}
	
	@Override
	public boolean equals(Object o){
		if(!o.getClass().equals(Boravak.class)) return false;
		if(!(this.getId() == ((Boravak)o).getId())) return false;
		return true;
	}
}
