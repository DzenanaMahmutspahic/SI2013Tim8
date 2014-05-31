package Hibernate;

import junit.framework.Assert;
import junit.framework.TestCase;
import Klase.Boravak;
import Klase.Gost;
import Klase.Osoba;
import Klase.Rezervacija;
import Klase.Soba;
import Klase.StraniGost;
import Klase.Racun;
import Klase.Predracun;
import Klase.Zaposlenik;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBManagerTest extends TestCase {
//testiranje metoda iz klase DBManager
	//komentar
	public void testProvjeriLogin() {
		fail("Not yet implemented"); // TODO
	}

	//Test da li ce se ispravno kreiran objekat naci u listi boravaka
	public void testDajBoravke() {
		Boravak boravak = new Boravak();
		Gost gost = new Gost();
		Rezervacija rezervacija = new Rezervacija();
		Osoba osoba = new Osoba();
		osoba.setImePrezime("Test Test");
		gost.setOsoba(osoba);
		rezervacija.setPotvrdjena(true);
		boravak.setRezervacija(rezervacija);
		boravak.setGost(gost);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(osoba);		
		session.save(gost);
		session.save(rezervacija);
		session.save(boravak);
		t.commit();
		
		List<Boravak> boravci = DBManager.dajBoravke();
		
		Transaction t1 = session.beginTransaction();
		session.delete(boravak);
		session.delete(rezervacija);
		session.delete(gost);
		session.delete(osoba);		
		t1.commit();
		
		assertTrue(boravci.contains(boravak));		
	}
	
	//Test da li ce se nepotvrdjena rezervacija naci u listi boravaka
	public void testDajNepotrvdjenaRezervacijaBoravke() {
		Boravak boravak = new Boravak();
		Gost gost = new Gost();
		Rezervacija rezervacija = new Rezervacija();
		Osoba osoba = new Osoba();
		osoba.setImePrezime("Test Test");
		gost.setOsoba(osoba);
		rezervacija.setPotvrdjena(false);
		boravak.setRezervacija(rezervacija);
		boravak.setGost(gost);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(osoba);		
		session.save(gost);
		session.save(rezervacija);
		session.save(boravak);
		t.commit();
		
		List<Boravak> boravci = DBManager.dajBoravke();
		
		Transaction t1 = session.beginTransaction();
		session.delete(boravak);
		session.delete(rezervacija);
		session.delete(gost);
		session.delete(osoba);		
		t1.commit();
		
		assertFalse(boravci.contains(boravak));		
	}
	
	//Test da li ce se boravak iz proslosti naci u listi
		public void testDajProsleBoravke() {
			Boravak boravak = new Boravak();
			Gost gost = new Gost();
			Rezervacija rezervacija = new Rezervacija();
			Osoba osoba = new Osoba();
			osoba.setImePrezime("Test Test");
			gost.setOsoba(osoba);
			rezervacija.setPotvrdjena(true);
			boravak.setRezervacija(rezervacija);
			boravak.setGost(gost);			
			Date danas = new Date();
			
			danas.setTime(danas.getTime()-( (24 * 60 * 60 * 1000)));
			
			boravak.setVrijemeOdlaska(danas); 
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			session.save(osoba);		
			session.save(gost);
			session.save(rezervacija);
			session.save(boravak);
			t.commit();
			
			List<Boravak> boravci = DBManager.dajBoravke();
			
			Transaction t1 = session.beginTransaction();
			session.delete(boravak);
			session.delete(rezervacija);
			session.delete(gost);
			session.delete(osoba);		
			t1.commit();
			
			assertFalse(boravci.contains(boravak));		
		}

	public void testDajBoravke2() {
		Boravak boravak = new Boravak();
		Gost gost = new Gost();
		Rezervacija rezervacija = new Rezervacija();
		Osoba osoba = new Osoba();
		osoba.setImePrezime("Test Test");
		gost.setOsoba(osoba);
		rezervacija.setPotvrdjena(true);
		boravak.setRezervacija(rezervacija);
		boravak.setGost(gost);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(osoba);		
		session.save(gost);
		session.save(rezervacija);
		session.save(boravak);
		t.commit();
		
		List<Boravak> boravci = DBManager.dajBoravke();
		
		Transaction t1 = session.beginTransaction();
		session.delete(boravak);
		session.delete(rezervacija);
		session.delete(gost);
		session.delete(osoba);		
		t1.commit();
		
		assertTrue(boravci.contains(boravak));		
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
	   
	   public void testSaveOsobu() {
		   Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); 
	   Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja);
	   o.setAdresa("Vitkovac 166");
	   DBManager.saveOsobu(o);
	   List<Osoba>osobe=DBManager.dajOsobe();
	   Assert.assertTrue(osobe.contains(o));
	   
	   }
	   
	   
	   
	  public void testSpasiZaposlenika() { 
		  	
		   Osoba o=new Osoba();
		   Zaposlenik z=new Zaposlenik();
	       o.setImePrezime("Dzenana Mahmutspahic");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			o.setDatumRodjenja(sdf.parse("1992-10-20"));
		} catch (java.text.ParseException p) {
			System.out.println(p.toString());
		}
	  
	   o.setAdresa("Vitkovac 166");
	
	   z.setOsoba(o);
	   DBManager.saveOsobu(o);
	   /*z.setDrzavljanstvo("BIH");
	   z.setJMB("0706992179147");
	   z.setMobitel("061827141");
	   z.setEmail("dzenana.ma@gmail.com");
	   z.setIsAdministrator(false);
	   z.setUsername("dzenana");
	   z.setPassword("dzenana");
	   z.setTitula("recepcioner");
	   z.setObrazovanje("skola");
	   z.setTelefon("032741723");
	  z.setUloga("recepcioner");*/
	  
	  Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(o);
		session.save(z);
		t.commit();
	  
	   DBManager.spasiZaposlenika(z);
	   
	 //  assertTrue(DBManager.dajZaposlenika(o).equals(z));
	  
	 /*  List<Zaposlenik> zaposlenici=DBManager.dajSveZaposlenike();
		 
		  Boolean tacno=false;
			for (Zaposlenik i : zaposlenici) {
				if(	i.getMobitel().equals(z.getMobitel()))
					tacno=true;
			}
		  assertTrue(tacno);*/
	   
		Transaction t1 = session.beginTransaction();
		session.delete(o);
		session.delete(z);	
		t1.commit();
	     
	   
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
	
	
	
	

	/*public void testDajPredracun() {
		//fail("Not yet implemented"); // TODO
		Predracun predracun=new Predracun();
		Predracun temp=new Predracun();
		Rezervacija r=new Rezervacija();
		Soba s=new Soba();
		Gost g=new Gost();
		Osoba o=new Osoba();
		Osoba o1=new Osoba();
		Zaposlenik z=new Zaposlenik();
		
		s.setBrojSobe(1);
		s.setBrojKreveta(1);
		s.setBalkon(true);
		s.setSprat(1);
		s.setZauzeta(false);
		DBManager.spasiSobu(s);
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				o.setDatumRodjenja(sdf.parse("1990-10-21"));
			} catch (java.text.ParseException p) {
				System.out.println(p.toString());
			}
			o.setAdresa("Vitkovac 166");
			g.setMjestoRodjenja("Beograd");
			DBManager.saveOsobu(o);
			g.setOsoba(o);
			
			try {
				o1.setDatumRodjenja(sdf.parse("1992-10-21"));
			} catch (java.text.ParseException p) {
				System.out.println(p.toString());
			}
			o1.setAdresa("Otoka");
			z.setDrzavljanstvo("BIH");
			z.setOsoba(o);
			DBManager.spasiZaposlenika(z);
			
			DBManager.saveOsobu(o1);
			DBManager.saveGosta(g);
			
			List<Gost> gosti=new ArrayList<Gost>();
			gosti.add(g);

		//	DBManager.saveOsobu(o);
			//DBManager.saveGosta(g);
			
			java.util.Date datumOD= new java.util.Date();
			java.util.Date datumDO= new java.util.Date();
			
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
		
				
		r.setBrojRezervacije(1);
		r.setPotvrdjena(true);
		DBManager.spasiRezervaciju(r);
		//DBManager.evidentirajBoravkeIRezervaciju(s,gosti,datumOD,datumDO,z);
		//DBManager.evidentirajBoravkeIRezervaciju(s,gosti,datumOD,datumDO,z);
		predracun.setRezervacija(r);
		predracun.setPopust(10);
		predracun.setUkupnaCijena(200);
		DBManager.unesiPredracun(predracun);
		temp=DBManager.dajPredracun(r);
		
		Boolean tacno=false;
        if(predracun.getUkupnaCijena()==temp.getUkupnaCijena() /*&& predracun.getPopust()==temp.getPopust())
        		tacno=true;
        
        assertTrue(tacno);
		
	}*/
	   
	   public void testDajPredracun(){
		 fail("Not yet implemented"); // TODO
		 /*  Rezervacija r=new Rezervacija();
		   Predracun p=new Predracun();
		   Predracun temp=new Predracun();
		   Soba soba=new Soba();
		   soba.setBrojKreveta(1);
		   soba.setBrojSobe(1);
		   soba.setBalkon(true);
		   soba.setZauzeta(true);
		   DBManager.spasiSobu(soba);
		   
		   r.setBrojRezervacije(1);
		   r.setSoba(soba);
		  r.setPotvrdjena(true);
		  DBManager.spasiRezervaciju(r);
		  p.setRezervacija(r);
		  p.setPopust(10);
		  p.setUkupnaCijena(200);
		  DBManager.unesiPredracun(p);
		  temp=DBManager.dajPredracun(r);
		  
		  Boolean tacno=false;
	        if(p.getUkupnaCijena()==temp.getUkupnaCijena() && p.getPopust()==temp.getPopust())
	        		tacno=true;
	        
	        assertTrue(tacno);*/
		  
	   }
	   
	   //Testira da li ova metoda zaista vraća sve rezervacije, ukljucujuci i one koje su tek dodane
	   public void testDajSveRezervacije(){
		   Rezervacija r=new Rezervacija();
		   Soba soba=new Soba();
		   soba.setBrojKreveta(1);
		   soba.setBrojSobe(1);
		   soba.setBalkon(true);
		   soba.setZauzeta(true);
		   DBManager.spasiSobu(soba);
		   
		   r.setBrojRezervacije(1);
		   r.setSoba(soba);
		  r.setPotvrdjena(true);
		 DBManager.spasiRezervaciju(r);
		 
		 List<Rezervacija> rezervacije=DBManager.dajSveRezervacije();
		 
		 Boolean tacno=false;
		 for(Rezervacija rez: rezervacije){
	        if(rez.getBrojRezervacije()==r.getBrojRezervacije())
	        		tacno=true;
		 }
	        assertTrue(tacno);
	   }
	   
	  /* public void testSpasiSobu(){
		   Soba s=new Soba();
		   s.setBrojSobe(10);
		   s.setBrojKreveta(2);
		  // s.setBalkon(true);
		  s.setSprat(2);
		  s.setCijena(50);
		  s.setZauzeta(false);
		  DBManager.spasiSobu(s);
		 		
		  
		  List<Soba> sobe=DBManager.dajSveSobe();
			 
			 Boolean tacno=false;
			 for(Soba i: sobe){
				 if(i==null) continue;
		        if(i.getBrojSobe()==s.getBrojSobe() && i.getSprat()==s.getSprat())
		        		tacno=true;
			 }
		        assertTrue(tacno);
	   }*/
	   
	   public void testObrisiZaposlenika() { 
		   Osoba o=new Osoba();
	   o.setImePrezime("Alen Kopic"); 
	   Date datumRodjenja=new Date(1992,10,21);
	   
	   o.setDatumRodjenja(datumRodjenja); 
	   o.setAdresa("Vitkovac 166");
	   Zaposlenik z=new Zaposlenik();
	   z.setDrzavljanstvo("BIH");
	   z.setOsoba(o);
	   DBManager.saveOsobu(o);
	   DBManager.spasiZaposlenika(z);
	   DBManager.obrisiZaposlenika(z);
	   List<Zaposlenik> zaposlenici=DBManager.dajSveZaposlenike();
	   Assert.assertFalse(zaposlenici.contains(z)); }
	   
	   
	   //testira da li ova metoda vraca gosta za datu rezervaciju
	   public void testGetGostRezervacija(){
		   Rezervacija r=new Rezervacija();
		   Boravak b=new Boravak();
		   Gost g=new Gost();
		   Gost novi=new Gost();
		   Osoba o=new Osoba();
		   Soba soba=new Soba();
		   
		   soba.setBrojKreveta(1);
		   soba.setBrojSobe(1);
		   soba.setBalkon(true);
		   soba.setZauzeta(true);
		   DBManager.spasiSobu(soba);
		   
		   r.setBrojRezervacije(1);
		   r.setSoba(soba);
		  r.setPotvrdjena(true);
		 DBManager.spasiRezervaciju(r);
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			o.setImePrezime("Dzenana Mahmutspahic");
			try {
				o.setDatumRodjenja(sdf.parse("1992-10-21"));
			} catch (java.text.ParseException p) {
				System.out.println(p.toString());
			}
			o.setAdresa("Vitkovac 166");
			g.setMjestoRodjenja("Beograd");
			g.setOsoba(o);

			DBManager.saveOsobu(o);
			DBManager.saveGosta(g);
			b.setGost(g);
			b.setRezervacija(r);
			DBManager.spasiBoravak(b);
			
			novi=DBManager.getGostRezervacija(r);
			List<Gost> gosti=new ArrayList<Gost>();
			gosti.add(novi);
			Boolean tacno=false;
			for(Gost i: gosti ){
			if(i.getMjestoRodjenja().equals(g.getMjestoRodjenja()))
				tacno=true;
			}
			
			assertTrue(tacno);	
		   
	   }

	public void testDajRacun() {
		//fail("Not yet implemented"); // TODO
				Racun r=new Racun();
				Racun racun=new Racun();
				Predracun predracun=new Predracun();
				predracun.setPopust(10);
				predracun.setUkupnaCijena(200);
				DBManager.unesiPredracun(predracun);
				r.setPredracun(predracun);
				r.setBrojRacuna(1);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
				
				try
				{
					 r.setVrijemeIzdavanja(sdf.parse("2014-05-31"));
			    }
				catch(java.text.ParseException p)
				{
			            System.out.println(p.toString());
			    }
				
				DBManager.unesiRacun(r);
				
		        racun=DBManager.dajRacun(predracun);
		        
		        Boolean temp=false;
		        if(racun.getBrojRacuna()==r.getBrojRacuna()) 
		        		temp=true;
		        
		        assertTrue(temp);

	}

	public void testUnesiPredracun() {
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setPotvrdjena(true);
		
		Predracun predracun = new Predracun();
		predracun.setPopust(10);
		predracun.setRezervacija(rezervacija);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(rezervacija);
		t.commit();
		
		DBManager.unesiPredracun(predracun);
		
		assertTrue(DBManager.dajPredracun(rezervacija).equals(predracun));
		
		
		Transaction t1 = session.beginTransaction();
		session.delete(rezervacija);
		session.delete(predracun);	
		t1.commit();		
	}

	public void testUpdatePredracun() {
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setPotvrdjena(true);
		
		Predracun predracun = new Predracun();
		predracun.setPopust(10);
		predracun.setRezervacija(rezervacija);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(rezervacija);
		t.commit();
		
		DBManager.unesiPredracun(predracun);
		predracun.setPopust(21);
		DBManager.updatePredracun(predracun);
		assertTrue(predracun.getPopust()==21);
		
		Transaction t1 = session.beginTransaction();
		session.delete(rezervacija);
		session.delete(predracun);	
		t1.commit();		
	}

	public void testUnesiRacun() {
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setPotvrdjena(true);		
		Predracun predracun = new Predracun();
		predracun.setPopust(10);
		predracun.setRezervacija(rezervacija);
		
		Racun racun = new Racun();
		racun.setPredracun(predracun);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(rezervacija);
		session.save(predracun);
		t.commit();
		
		DBManager.unesiRacun(racun);
		
		assertTrue(DBManager.dajRacun(predracun).equals(racun));
		
		
		Transaction t1 = session.beginTransaction();
		session.delete(rezervacija);
		session.delete(predracun);	
		session.delete(racun);
		t1.commit();	
	}

}
