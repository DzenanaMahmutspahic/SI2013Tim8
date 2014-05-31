package Hibernate;

import junit.framework.Assert;
import junit.framework.TestCase;
import Klase.Gost;
import Klase.Osoba;
import Klase.Rezervacija;
import Klase.Soba;
import Klase.StraniGost;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DBManagerTest extends TestCase {
//testiranje metoda iz klase DBManager
	//komentar
	public void testProvjeriLogin() {
		fail("Not yet implemented"); // TODO
	}

	public void testDajBoravke() {
		fail("Not yet implemented"); // TODO
	}

	public void testDajBoravke2() {
		fail("Not yet implemented"); // TODO
	}

	public void testDajZauzeteSobeProvjeraException() { 
		//Test za provjeru bacanja izuzetka metode dajZauzeteSobe
		
		java.util.Date datumOD= new java.util.Date();
		java.util.Date datumDO= new java.util.Date();
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try{ 
			
		try {
			 datumOD=sdf.parse("2014-06-10");
	        }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try {
			 datumDO=sdf.parse("2014-06-05");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		 
		 java.util.List testnaListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
		 
		} 
		catch(Exception e)
		{
			assertTrue(true);
		}
		 
	}
	public void testDajZauzeteSobeProvjeraExceptionFalse() { 
		//Test za provjeru bacanja izuzetka metode dajZauzeteSobe, u slucaju kad ne treba da baci izuzetak, da smo sigurni
		//da ga neće ni baciti
		
		java.util.Date datumOD= new java.util.Date();
		java.util.Date datumDO= new java.util.Date();
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try{ 
			
		try {
			 datumOD=sdf.parse("2014-06-10");
	        }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try {
			 datumDO=sdf.parse("2014-06-15");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		 
		 java.util.List testnaListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
		 
		} 
		catch(Exception e)
		{
			assertFalse(false);
		}
		 
	}
	
	
	//testira slucaj kad se unesu ispravni datumi, da li ce metoda dobro vratiti listu zauzetih soba, treba vratiti true
	public void testDajZauzeteSobe() 
	{
		java.util.Date datumOD= new java.util.Date();
		java.util.Date datumDO= new java.util.Date();
		java.util.Date rezervisanoOD= new java.util.Date();
		java.util.Date rezervisanoDO= new java.util.Date();
		java.util.Date rezervisanoOD1= new java.util.Date();
		java.util.Date rezervisanoDO1= new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			 datumOD=sdf.parse("2014-06-15");
	    }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	    }
		
		 try
		 {
			 datumDO=sdf.parse("2014-06-20");
	     }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		
		try
		{
			 rezervisanoOD=sdf.parse("2014-06-10");
	     }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try
		 {
			 rezervisanoDO=sdf.parse("2014-06-20");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		 try
		 {
			 rezervisanoOD1=sdf.parse("2014-06-10");
	        }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try 
		 {
			 rezervisanoDO1=sdf.parse("2014-06-25");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
	   
		Soba s= new Soba();
		Soba s1=new Soba();
		
		Rezervacija r=new Rezervacija();
		Rezervacija r1=new Rezervacija();
		
		s.setBrojSobe(1);
		s.setBalkon(true);
		s.setBrojKreveta(2);
		s.setSprat(2);
		
		s1.setBrojSobe(2);
		s1.setBalkon(true);
		s1.setBrojKreveta(2);
		s1.setSprat(2);
		
		r.setSoba(s);
		r.setRezervisanoOd(rezervisanoOD);
		r.setRezervisanoDo(rezervisanoDO);
		
		r1.setSoba(s1);
		r1.setRezervisanoOd(rezervisanoOD1);
		r1.setRezervisanoDo(rezervisanoDO1);
		
		java.util.List tempListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
		
		assertTrue(tempListaSoba.contains(1) && tempListaSoba.contains(2));
		
	}
	//testira slucaj kad se unesu ispravni datumi, da li ce metoda dobro vratiti listu zauzetih soba jer je prva soba zauzeta
	//samo dio perioda, a ne cijeli period koji trazimo
	public void testDajZauzeteSobeDioPerioda() 
	{
		java.util.Date datumOD= new java.util.Date();
		java.util.Date datumDO= new java.util.Date();
		java.util.Date rezervisanoOD= new java.util.Date();
		java.util.Date rezervisanoDO= new java.util.Date();
		java.util.Date rezervisanoOD1= new java.util.Date();
		java.util.Date rezervisanoDO1= new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			 datumOD=sdf.parse("2014-06-15");
	    }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	    }
		
		 try
		 {
			 datumDO=sdf.parse("2014-06-20");
	     }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		
		try
		{
			 rezervisanoOD=sdf.parse("2014-06-16");
	     }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try
		 {
			 rezervisanoDO=sdf.parse("2014-06-18");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		 try
		 {
			 rezervisanoOD1=sdf.parse("2014-06-10");
	        }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try 
		 {
			 rezervisanoDO1=sdf.parse("2014-06-30");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
	   
		Soba s= new Soba();
		Soba s1=new Soba();
		
		Rezervacija r=new Rezervacija();
		Rezervacija r1=new Rezervacija();
		List<Rezervacija> rez = new ArrayList<Rezervacija>();
		
		s.setBrojSobe(1);
		s.setBalkon(true);
		s.setBrojKreveta(2);
		s.setSprat(2);
		
		s1.setBrojSobe(2);
		s1.setBalkon(true);
		s1.setBrojKreveta(2);
		s1.setSprat(2);
		
		r.setSoba(s);
		r.setRezervisanoOd(rezervisanoOD);
		r.setRezervisanoDo(rezervisanoDO);
		
		r1.setSoba(s1);
		r1.setRezervisanoOd(rezervisanoOD1);
		r1.setRezervisanoDo(rezervisanoDO1);
		
		//rez.add(r);
		//rez.add(r1);
		
	//	for(Rezervacija rez1: rez){
		java.util.List tempListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
		assertTrue(tempListaSoba.contains(2) && tempListaSoba.contains(1));
		//}
		
		
	}
	
	
	
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

		DBManager.saveOsobu(o);
		DBManager.saveGosta(g);
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
		DBManager.saveStranogGosta(sg);
		List<StraniGost> stranigosti = DBManager.dajStraneGoste();
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

		DBManager.saveOsobu(o);
		DBManager.saveGosta(g);
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
	   
	   DBManager.saveStranogGosta(sg);
	   List<StraniGost>
	   stranigosti=DBManager.dajStraneGoste();
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

				DBManager.saveOsobu(o);
				DBManager.saveGosta(g);
			
	  
	   List<Gost> gosti=DBManager.dajGoste();
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
	   DBManager.saveOsobu(o); DBManager.saveGosta(g);
	   DBManager.obrisiGosta(g); List<Gost>
	   gosti=DBManager.dajGoste();
	   Assert.assertFalse(gosti.contains(g)); }
	   
	   public void testObrisiStranogGosta() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166"); Gost
	   g=new Gost(); g.setMjestoRodjenja("Beograd"); g.setOsoba(o);
	   DBManager.saveOsobu(o); DBManager.saveGosta(g);
	   StraniGost sg=new StraniGost(); sg.setBrojPutneIsprave("A000000");
	   sg.setBrojVize("A000000"); Date datumDozvole=new Date(2013,10,21); Date
	   datumUlaska=new Date(2013,10,21);
	   sg.setDatumDozvoleBoravka(datumDozvole);
	   sg.setDatumUlaskaUBih(datumUlaska); sg.setDrzavljanstvo("BIH");
	   sg.setGost(g); sg.setVrstaPutneIsprave("Neka"); sg.setVrstaVize("Neka");
	   
	   DBManager.saveStranogGosta(sg);
	   DBManager.obrisiStranogGosta(sg); List<StraniGost>
	   stranigosti=DBManager.dajStraneGoste();
	   Assert.assertFalse(stranigosti.contains(sg)); }
	   
	   public void testObrisiOsobu() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166");
	   DBManager.saveOsobu(o); DBManager.obrisiOsobu(o);
	   List<Osoba> osobe=DBManager.dajOsobe();
	   Assert.assertFalse(osobe.contains(o)); }
	   
	   public void testDajStranogZaGosta() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166"); Gost
	   g=new Gost(); g.setMjestoRodjenja("Beograd"); g.setOsoba(o);
	   DBManager.saveOsobu(o); DBManager.saveGosta(g);
	   StraniGost sg=new StraniGost(); sg.setBrojPutneIsprave("A000000");
	   sg.setBrojVize("A000000"); Date datumDozvole=new Date(2013,10,21); Date
	   datumUlaska=new Date(2013,10,21);
	   sg.setDatumDozvoleBoravka(datumDozvole);
	   sg.setDatumUlaskaUBih(datumUlaska); sg.setDrzavljanstvo("BIH");
	   sg.setGost(g); sg.setVrstaPutneIsprave("Neka"); sg.setVrstaVize("Neka");
	   
	   DBManager.saveStranogGosta(sg); StraniGost
	   newsg=DBManager.dajStranogZaGosta(g); List<StraniGost>
	   stranigosti=DBManager.dajStraneGoste();
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

			DBManager.saveOsobu(o);
			DBManager.saveGosta(g);
		

	   
			 List<Gost> gosti=DBManager.dajGoste();
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
	   DBManager.saveOsobu(o); List<Osoba>
	   osobe=DBManager.dajOsobe();
	   Assert.assertTrue(osobe.contains(o));
	   
	   }
	   
	   public void testObrisiStranogZaGosta() { Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); o.setAdresa("Vitkovac 166"); Gost
	   g=new Gost(); g.setMjestoRodjenja("Beograd"); g.setOsoba(o);
	   DBManager.saveOsobu(o); DBManager.saveGosta(g);
	   StraniGost sg=new StraniGost(); sg.setBrojPutneIsprave("A000000");
	   sg.setBrojVize("A000000"); Date datumDozvole=new Date(2013,10,21); Date
	   datumUlaska=new Date(2013,10,21);
	   sg.setDatumDozvoleBoravka(datumDozvole);
	   sg.setDatumUlaskaUBih(datumUlaska); sg.setDrzavljanstvo("BIH");
	   sg.setGost(g); sg.setVrstaPutneIsprave("Neka"); sg.setVrstaVize("Neka");
	   
	   DBManager.saveStranogGosta(sg);
	   DBManager.obrisiStranogZaGosta(sg); List<StraniGost>
	   stranigosti=DBManager.dajStraneGoste();
	   Assert.assertFalse(stranigosti.contains(sg)); }
	
	
	
	

	public void testDajPredracun() {
		fail("Not yet implemented"); // TODO
	}

	public void testDajRacun() {
		fail("Not yet implemented"); // TODO
	}

	public void testUnesiPredracun() {
		fail("Not yet implemented"); // TODO
	}

	public void testUpdatePredracun() {
		fail("Not yet implemented"); // TODO
	}

	public void testUnesiRacun() {
		fail("Not yet implemented"); // TODO
	}

}
