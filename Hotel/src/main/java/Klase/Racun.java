package Klase;

import java.io.Serializable;
import java.util.Date;

public class Racun implements Serializable {
	private long Id;
	private int brojRacuna;
	private Date vrijemeIzdavanja;
	private double boravisnaTaksa;
	private Predracun predracun;
	
	public Racun() {}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getVrijemeIzdavanja() {
		return vrijemeIzdavanja;
	}

	public void setVrijemeIzdavanja(Date vrijemeIzdavanja) {
		this.vrijemeIzdavanja = vrijemeIzdavanja;
	}

	public double getBoravisnaTaksa() {
		return boravisnaTaksa;
	}

	public void setBoravisnaTaksa(double boravisnaTaksa) {
		this.boravisnaTaksa = boravisnaTaksa;
	}

	public Predracun getPredracun() {
		return predracun;
	}

	public void setPredracun(Predracun predracun) {
		this.predracun = predracun;
	}
	
	@Override
	public boolean equals(Object o){
		if(!o.getClass().equals(Racun.class)) return false;
		if(!(this.getId() == ((Racun)o).getId())) return false;
		return true;
	}

}
