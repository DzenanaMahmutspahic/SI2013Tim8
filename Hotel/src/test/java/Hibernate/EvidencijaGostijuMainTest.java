package Hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Klase.Gost;
import Klase.Osoba;
import Klase.StraniGost;
import junit.framework.Assert;
import junit.framework.TestCase;

public class EvidencijaGostijuMainTest extends TestCase {

	public void testSaveStranogGosta() {
		Osoba o = new Osoba();
		o.setImePrezime("Alen Kopic");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			o.setDatumRodjenja(sdf.parse("1992-10-21"));
		} catch (java.text.ParseException p) {
			System.out.println(p.toString());
		}

		o.setAdresa("Vitkovac 166");
		Gost g = new Gost();
		g.setMjestoRodjenja("Beograd");
		g.setOsoba(o);

		EvidencijaGostijuMain.saveOsobu(o);
		EvidencijaGostijuMain.saveGosta(g);
		StraniGost sg = new StraniGost();
		sg.setBrojPutneIsprave("A000000");
		sg.setBrojVize("A000000");

		try {
			sg.setDatumDozvoleBoravka(sdf.parse("2014-06-10"));
		} catch (java.text.ParseException p) {
			System.out.println(p.toString());
		}
		try {
			sg.setDatumUlaskaUBih(sdf.parse("2014-06-10"));
		} catch (java.text.ParseException p) {
			System.out.println(p.toString());
		}

		

		sg.setDrzavljanstvo("BIH");
		sg.setGost(g);
		sg.setVrstaPutneIsprave("Neka");
		sg.setVrstaVize("Neka");
		EvidencijaGostijuMain.saveStranogGosta(sg);
		List<StraniGost> stranigosti = EvidencijaGostijuMain.dajStraneGoste();
		Boolean tacno=false;
		for (StraniGost i : stranigosti) {
			if(	i.getBrojPutneIsprave().equals(sg.getBrojPutneIsprave()))
				tacno=true;
		}
		Assert.assertTrue(tacno);
	}

	
	   
	  public void testDajStraneGoste() {
	 
	 Osoba o=new Osoba(); o.setImePrezime("Alen Kopic"); 
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			o.setDatumRodjenja(sdf.parse("1992-10-21"));
		} catch (java.text.ParseException p) {
			System.out.println(p.toString());
		}
		o.setAdresa("Vitkovac 166");
		Gost g = new Gost();
		g.setMjestoRodjenja("Beograd");
		g.setOsoba(o);

		EvidencijaGostijuMain.saveOsobu(o);
		EvidencijaGostijuMain.saveGosta(g);
		StraniGost sg = new StraniGost();
		sg.setBrojPutneIsprave("A000000");
		sg.setBrojVize("A000000");

		try {
			sg.setDatumDozvoleBoravka(sdf.parse("2014-06-10"));
		} catch (java.text.ParseException p) {
			System.out.println(p.toString());
		}
		try {
			sg.setDatumUlaskaUBih(sdf.parse("2014-06-10"));
		} catch (java.text.ParseException p) {
			System.out.println(p.toString());
		}

		

		sg.setDrzavljanstvo("BIH");
		sg.setGost(g);
		sg.setVrstaPutneIsprave("Neka");
		sg.setVrstaVize("Neka");
	   
	   EvidencijaGostijuMain.saveStranogGosta(sg);
	   List<StraniGost>
	   stranigosti=EvidencijaGostijuMain.dajStraneGoste();
	   Boolean tacno=false;
		for (StraniGost i : stranigosti) {
			if(	i.getBrojPutneIsprave().equals(sg.getBrojPutneIsprave()))
				tacno=true;
		}
	   Assert.assertTrue(tacno); }
	   
	   
	   
	   public void testDajGoste() { 
		   Osoba o=new Osoba(); o.setImePrezime("Alen Kopic"); 
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					o.setDatumRodjenja(sdf.parse("1992-10-21"));
				} catch (java.text.ParseException p) {
					System.out.println(p.toString());
				}
				o.setAdresa("Vitkovac 166");
				Gost g = new Gost();
				g.setMjestoRodjenja("Beograd");
				g.setOsoba(o);

				EvidencijaGostijuMain.saveOsobu(o);
				EvidencijaGostijuMain.saveGosta(g);
			
	  
	   List<Gost> gosti=EvidencijaGostijuMain.dajGoste();
	   Boolean tacno=false;
	 		for (Gost i : gosti) {
	 			if(	i.getIme().equals(g.getIme())&&	i.getPrezime().equals(g.getPrezime()))
	 				tacno=true;
	 		}
	 	   Assert.assertTrue(tacno); 
	 	   
	   }
	   
	   
	  
	   
	   public void testObrisiGosta() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166"); Gost
	   g=new Gost(); g.setMjestoRodjenja("Beograd"); g.setOsoba(o);
	   EvidencijaGostijuMain.saveOsobu(o); EvidencijaGostijuMain.saveGosta(g);
	   EvidencijaGostijuMain.obrisiGosta(g); List<Gost>
	   gosti=EvidencijaGostijuMain.dajGoste();
	   Assert.assertFalse(gosti.contains(g)); }
	   
	   public void testObrisiStranogGosta() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166"); Gost
	   g=new Gost(); g.setMjestoRodjenja("Beograd"); g.setOsoba(o);
	   EvidencijaGostijuMain.saveOsobu(o); EvidencijaGostijuMain.saveGosta(g);
	   StraniGost sg=new StraniGost(); sg.setBrojPutneIsprave("A000000");
	   sg.setBrojVize("A000000"); Date datumDozvole=new Date(2013,10,21); Date
	   datumUlaska=new Date(2013,10,21);
	   sg.setDatumDozvoleBoravka(datumDozvole);
	   sg.setDatumUlaskaUBih(datumUlaska); sg.setDrzavljanstvo("BIH");
	   sg.setGost(g); sg.setVrstaPutneIsprave("Neka"); sg.setVrstaVize("Neka");
	   
	   EvidencijaGostijuMain.saveStranogGosta(sg);
	   EvidencijaGostijuMain.obrisiStranogGosta(sg); List<StraniGost>
	   stranigosti=EvidencijaGostijuMain.dajStraneGoste();
	   Assert.assertFalse(stranigosti.contains(sg)); }
	   
	   public void testObrisiOsobu() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166");
	   EvidencijaGostijuMain.saveOsobu(o); EvidencijaGostijuMain.obrisiOsobu(o);
	   List<Osoba> osobe=EvidencijaGostijuMain.dajOsobe();
	   Assert.assertFalse(osobe.contains(o)); }
	   
	   public void testDajStranogZaGosta() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166"); Gost
	   g=new Gost(); g.setMjestoRodjenja("Beograd"); g.setOsoba(o);
	   EvidencijaGostijuMain.saveOsobu(o); EvidencijaGostijuMain.saveGosta(g);
	   StraniGost sg=new StraniGost(); sg.setBrojPutneIsprave("A000000");
	   sg.setBrojVize("A000000"); Date datumDozvole=new Date(2013,10,21); Date
	   datumUlaska=new Date(2013,10,21);
	   sg.setDatumDozvoleBoravka(datumDozvole);
	   sg.setDatumUlaskaUBih(datumUlaska); sg.setDrzavljanstvo("BIH");
	   sg.setGost(g); sg.setVrstaPutneIsprave("Neka"); sg.setVrstaVize("Neka");
	   
	   EvidencijaGostijuMain.saveStranogGosta(sg); StraniGost
	   newsg=EvidencijaGostijuMain.dajStranogZaGosta(g); List<StraniGost>
	   stranigosti=EvidencijaGostijuMain.dajStraneGoste();
	   Assert.assertFalse(sg==newsg); }
	   
	   public void testUpdateStranogGosta() { fail("Not yet implemented"); 
	   //	   TODO }
	   }
	   
	   public void testUpdateGosta() { fail("Not yet implemented");
	   // TODO }
	   }
	   
	   public void testUpdateOsobu() { fail("Not yet implemented");
	   // TODO }
	   }
	   
	   
	   public void testSaveGosta() { Osoba o=new Osoba(); o.setImePrezime("Alen Kopic"); 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				o.setDatumRodjenja(sdf.parse("1992-10-21"));
			} catch (java.text.ParseException p) {
				System.out.println(p.toString());
			}
			o.setAdresa("Vitkovac 166");
			Gost g = new Gost();
			g.setMjestoRodjenja("Beograd");
			g.setOsoba(o);

			EvidencijaGostijuMain.saveOsobu(o);
			EvidencijaGostijuMain.saveGosta(g);
		

	   
			 List<Gost> gosti=EvidencijaGostijuMain.dajGoste();
			   Boolean tacno=false;
			 		for (Gost i : gosti) {
			 			if(	i.getIme().equals(g.getIme())&&	i.getPrezime().equals(g.getPrezime()))
			 				tacno=true;
			 		}
			 	   Assert.assertTrue(tacno); 
			 	   
			   }
	   
	   public void testSaveOsobu() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166");
	   EvidencijaGostijuMain.saveOsobu(o); List<Osoba>
	   osobe=EvidencijaGostijuMain.dajOsobe();
	   Assert.assertTrue(osobe.contains(o));
	   
	   }
	   
	   public void testObrisiStranogZaGosta() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166"); Gost
	   g=new Gost(); g.setMjestoRodjenja("Beograd"); g.setOsoba(o);
	   EvidencijaGostijuMain.saveOsobu(o); EvidencijaGostijuMain.saveGosta(g);
	   StraniGost sg=new StraniGost(); sg.setBrojPutneIsprave("A000000");
	   sg.setBrojVize("A000000"); Date datumDozvole=new Date(2013,10,21); Date
	   datumUlaska=new Date(2013,10,21);
	   sg.setDatumDozvoleBoravka(datumDozvole);
	   sg.setDatumUlaskaUBih(datumUlaska); sg.setDrzavljanstvo("BIH");
	   sg.setGost(g); sg.setVrstaPutneIsprave("Neka"); sg.setVrstaVize("Neka");
	   
	   EvidencijaGostijuMain.saveStranogGosta(sg);
	   EvidencijaGostijuMain.obrisiStranogZaGosta(sg); List<StraniGost>
	   stranigosti=EvidencijaGostijuMain.dajStraneGoste();
	   Assert.assertFalse(stranigosti.contains(sg)); }
	 

}
