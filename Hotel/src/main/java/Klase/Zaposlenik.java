package Klase;

import java.io.Serializable;

public class Zaposlenik implements Serializable {
	private long Id;
	private String username;
	private String password;
	private String JMB;
	private String drzavljanstvo;
	private String titula;
	private String obrazovanje;
	private String email;
	private String telefon;
	private String mobitel;
	private String uloga;
	private boolean isAdministrator;
	private Osoba osoba;
	
	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public Zaposlenik() {}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getJMB() {
		return JMB;
	}
	public void setJMB(String jMB) {
		JMB = jMB;
	}
	public String getDrzavljanstvo() {
		return drzavljanstvo;
	}
	public void setDrzavljanstvo(String drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getObrazovanje() {
		return obrazovanje;
	}
	public void setObrazovanje(String obrazovanje) {
		this.obrazovanje = obrazovanje;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getMobitel() {
		return mobitel;
	}
	public void setMobitel(String mobitel) {
		this.mobitel = mobitel;
	}
	public String getUloga() {
		return uloga;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	public boolean getIsAdministrator() {
		return isAdministrator;
	}
	public void setIsAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
	
	@Override public String toString() {
		if(this.osoba != null)
		{
			return this.osoba.getImePrezime();
		}
		
		return "";
	}
	
	
}
