package Klase;

import java.io.Serializable;
import java.util.Date;

public class Rezervacija implements Serializable {
	private long Id;
	private Soba soba;
	private Date rezervisanoOd;
	private Date rezervisanoDo;
	private int brojRezervacije;
	private Boolean potvrdjena;
	private Zaposlenik kreiraoZaposlenik;
	
	public Rezervacija() {}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Soba getSoba() {
		return soba;
	}
	public void setSoba(Soba soba) {
		soba = soba;
	}
	public Date getRezervisanoOd() {
		return rezervisanoOd;
	}
	public void setRezervisanoOd(Date rezervisanoOd) {
		this.rezervisanoOd = rezervisanoOd;
	}
	public Date getRezervisanoDo() {
		return rezervisanoDo;
	}
	public void setRezervisanoDo(Date rezervisanoDo) {
		this.rezervisanoDo = rezervisanoDo;
	}
	public int getBrojRezervacije() {
		return brojRezervacije;
	}
	public void setBrojRezervacije(int brojRezervacije) {
		this.brojRezervacije = brojRezervacije;
	}
	public Boolean getPotvrdjena() {
		return potvrdjena;
	}
	public void setPotvrdjena(Boolean potvrdjena) {
		this.potvrdjena = potvrdjena;
	}
	public Zaposlenik getKreiraoZaposlenik() {
		return kreiraoZaposlenik;
	}
	public void setKreiraoZaposlenik(Zaposlenik kreiraoZaposlenik) {
		this.kreiraoZaposlenik = kreiraoZaposlenik;
	}
	
	
}
