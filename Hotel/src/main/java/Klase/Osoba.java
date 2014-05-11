package Klase;

import java.io.Serializable;
import java.util.Date;

public class Osoba implements Serializable {
	private long Id;
	private String imePrezime;
	private Date datumRodjenja;
	private String adresa;
	
	public Osoba() {}
	

	public long getId() {
		return Id;
	}



	public void setId(long id) {
		Id = id;
	}



	public String getImePrezime() {
		return imePrezime;
	}
	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

}
