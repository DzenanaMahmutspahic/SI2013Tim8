package Klase;

import java.io.Serializable;

public class Soba implements Serializable {
	private long id;
	private int brojSobe;
	private int sprat;
	private Boolean balkon;
	private int brojKreveta;
	private double cijena;
	private Boolean zauzeta;
	
	public Soba() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBrojSobe() {
		return brojSobe;
	}
	public void setBrojSobe(int brojSobe) {
		this.brojSobe = brojSobe;
	}
	public int getSprat() {
		return sprat;
	}
	public void setSprat(int sprat) {
		this.sprat = sprat;
	}
	public boolean getBalkon() {
		return balkon;
	}
	public void setBalkon(Boolean balkon) {
		this.balkon = balkon;
	}
	public int getBrojKreveta() {
		return brojKreveta;
	}
	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public boolean getZauzeta() {
		return zauzeta;
	}
	public void setZauzeta(Boolean zauzeta) {
		this.zauzeta = zauzeta;
	}
	
	
}
