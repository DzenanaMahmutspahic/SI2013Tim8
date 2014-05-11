package Klase;
import java.io.Serializable;
import java.util.Date;

import Klase.Gost;


public class StraniGost implements Serializable {
	private long Id;
	private String drzavljanstvo;
	private String vrstaPutneIsprave;
	private String brojPutneIsprave;
	private String vrstaVize;
	private String brojVize;
	private Date datumDozvoleBoravka;
	private Date datumUlaskaUBih;
	private Gost gost;
	
	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public StraniGost() {}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getDrzavljanstvo() {
		return drzavljanstvo;
	}
	public void setDrzavljanstvo(String drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}
	public String getVrstaPutneIsprave() {
		return vrstaPutneIsprave;
	}
	public void setVrstaPutneIsprave(String vrstaPutneIsprave) {
		this.vrstaPutneIsprave = vrstaPutneIsprave;
	}
	public String getBrojPutneIsprave() {
		return brojPutneIsprave;
	}
	public void setBrojPutneIsprave(String brojPutneIsprave) {
		this.brojPutneIsprave = brojPutneIsprave;
	}
	public String getVrstaVize() {
		return vrstaVize;
	}
	public void setVrstaVize(String vrstaVize) {
		this.vrstaVize = vrstaVize;
	}
	public String getBrojVize() {
		return brojVize;
	}
	public void setBrojVize(String brojVize) {
		this.brojVize = brojVize;
	}
	public Date getDatumDozvoleBoravka() {
		return datumDozvoleBoravka;
	}
	public void setDatumDozvoleBoravka(Date datumDozvoleBoravka) {
		this.datumDozvoleBoravka = datumDozvoleBoravka;
	}
	public Date getDatumUlaskaUBih() {
		return datumUlaskaUBih;
	}
	public void setDatumUlaskaUBih(Date datumUlaskaUBih) {
		this.datumUlaskaUBih = datumUlaskaUBih;
	}
	
}
