package Klase;

import java.io.Serializable;

public class Gost implements Serializable{
	private long Id;
	private int rbrPrijave;
	private String mjestoRodjenja;
	private String primjedba;
	private Osoba osoba;
	
	public Gost() {}
	
	
	public Osoba getOsoba() {
		return osoba;
	}


	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	/* */
	public String getIme(){
		return osoba.getIme();
	}
	
	public String getPrezime(){
		return osoba.getPrezime();
	}
	/* */

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public int getRbrPrijave() {
		return rbrPrijave;
	}
	public void setRbrPrijave(int rbrPrijave) {
		this.rbrPrijave = rbrPrijave;
	}
	public String getMjestoRodjenja() {
		return mjestoRodjenja;
	}
	public void setMjestoRodjenja(String mjestoRodjenja) {
		this.mjestoRodjenja = mjestoRodjenja;
	}
	public String getPrimjedba() {
		return primjedba;
	}
	public void setPrimjedba(String primjedba) {
		this.primjedba = primjedba;
	}
	
	public String toString(){
		if(this.osoba!=null)
			return this.osoba.getImePrezime();
		return "aaa";
	}
	
	
}
