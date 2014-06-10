package Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.JDBCConnectionException;

import Klase.Gost;
import Klase.Osoba;
import Klase.Racun;
import Klase.Rezervacija;
import Klase.Boravak;
import Klase.Predracun;
import Klase.Soba;
import Klase.StraniGost;
import Klase.Zaposlenik;

public class DBManager {//komentar
	
	private static Scanner sc = new Scanner(System.in);
	
	public static Zaposlenik provjeriLogin(String username, String password)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query q = session.createQuery("from " + Zaposlenik.class.getName() + " where username = :username and password = :password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		
		return (Zaposlenik)q.uniqueResult();
	}
	
	
	/*Za Ekran za placanje */ //a
	public static List<Boravak> dajBoravke() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Boravak boravak where boravak.rezervacija.potvrdjena=true and (boravak.vrijemeOdlaska is null or boravak.vrijemeOdlaska>=:danas or boravak.rezervacija.rezervisanoDo >=:danas)");
		q.setParameter("danas", new Date());
		
		List<Boravak> boravci = q.list();
		session.close();
		return boravci;
	}
	
	
	public static List<Boravak> dajBoravke2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query q = session.createQuery("from Boravak boravak");
		List<Boravak> boravci = q.list();
		//List<Boravak> ret = new ArrayList<Boravak>();
		
		//for(Boravak b: boravci){ //System.out.println("ajd");
		//	if(b.getVrijemeOdlaska() != null ) {
		//		if(b.getRezervacija().getPotvrdjena() == true && ( b.getVrijemeOdlaska().after(new Date()) ))
		//			ret.add(b);
		//	}
		//}
	//	session.close();
		return boravci; 
		//return ret;
	}
	
	
		
	public static List<Integer> dajZauzeteSobe(java.util.Date datumOD, java.util.Date datumDO){
		
		try{
			
			if (datumOD.after(datumDO)) throw new Exception("Datum odlaska mora biti veći od datuma dolaska!");
			
		}
		catch(Exception e)
		{
			System.out.print("IZUZETAK: "+e.getMessage());
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Rezervacija.class.getName() + " rezervacija where rezervacija.soba is not null");
			
			
			List<Rezervacija> rezervacije = (List<Rezervacija>)q.list();
			List<Integer> ret = new ArrayList<Integer>();
			
			for(Rezervacija r: rezervacije){
				//if(datumDO.before(r.getRezervisanoOd()) || datumOD.after(r.getRezervisanoDo()) || (datumOD.after(r.getRezervisanoDo()) && datumDO.before(r.getRezervisanoOd())))	        			        			
    			
				if((datumOD.before(r.getRezervisanoDo())&&datumOD.after(r.getRezervisanoOd()))
    					|| (datumDO.before(r.getRezervisanoDo()) && datumDO.after(r.getRezervisanoOd())) 
    					||(datumOD.before(r.getRezervisanoOd())&& datumDO.after(r.getRezervisanoDo()))
    					|| (datumOD.after(r.getRezervisanoOd()) && datumDO.before(r.getRezervisanoDo())) )
				{
    				ret.add(r.getSoba().getBrojSobe());
    				System.out.println(r.getSoba().getBrojSobe());
    				
    			}
			}
			//session.close();
			return ret;
		

	}
	
	
	public static Predracun dajPredracun(Rezervacija rezervacija) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction t = session.beginTransaction();

		Query q = session.createQuery("from Predracun predracun where rezervacija=:rezervacija");//or vrijemeOdlaska isnull
		q.setParameter("rezervacija", rezervacija);
		
		Predracun predracun=null;
		if(!q.list().isEmpty())
			predracun = (Predracun) q.list().get(0);
		else predracun=null;
	    
		session.close();
		return predracun;
	}
	
	public static Racun dajRacun(Predracun predracun) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction t = session.beginTransaction();

		Query q = session.createQuery("from Racun racun where predracun=:predracun");//or vrijemeOdlaska isnull
		q.setParameter("predracun", predracun);
		
		Racun racun;
		if(!q.list().isEmpty())
			racun = (Racun) q.list().get(0);
		else racun=null;
	    
		session.close();
		return racun;
	}
	
	public static Zaposlenik dajZaposlenika(Osoba osoba) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction t = session.beginTransaction();

		Query q = session.createQuery("from Zaposlenik zaposlenik where osoba=:osoba");//or vrijemeOdlaska isnull
		q.setParameter("osoba", osoba);
		Zaposlenik zaposlenik;
		
		if(!q.list().isEmpty())
			zaposlenik = (Zaposlenik) q.list().get(0);
		else zaposlenik=null;
	    
		session.close();
		return zaposlenik;
	}
	
	/*Za Ekran za placanje */
	public static void unesiPredracun(Predracun predracun){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(predracun);
		t.commit();
		session.close();
	}
	
	public static void updatePredracun(Predracun p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(p);
		t.commit();
		session.close();
	}
	
	public static void unesiRacun(Racun racun){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(racun);
		t.commit();
		session.close();
	}
	
	/* Ekran  za rezevacije */
	public static List<Soba> dajSlobodneSobe(java.util.Date datumOD, java.util.Date datumDO, int klasa){
		Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.createQuery("from " + Rezervacija.class.getName() + " rezervacija where rezervacija.soba is not null");
		
			
			List<Rezervacija> rezervacije = (List<Rezervacija>)q.list();
			List<Long> ret = new ArrayList<Long>();//lista zauzetih soba
			for(Rezervacija r: rezervacije){
				//if(datumDO.before(r.getRezervisanoOd()) || datumOD.after(r.getRezervisanoDo()) || (datumOD.after(r.getRezervisanoDo()) && datumDO.before(r.getRezervisanoOd())))	        			        			
    			if((datumOD.before(r.getRezervisanoDo())&&datumOD.after(r.getRezervisanoOd()))
    					|| (datumDO.before(r.getRezervisanoDo()) && datumDO.after(r.getRezervisanoOd())) 
    					||(datumOD.before(r.getRezervisanoOd())&& datumDO.after(r.getRezervisanoDo()))
    					|| (datumOD.after(r.getRezervisanoOd()) && datumDO.before(r.getRezervisanoDo())) )
				{
    				ret.add(r.getSoba().getId());	
    			}
			}
    			
    			Query q2 = session.createQuery("from " + Soba.class.getName());
    			List<Soba> sveSobe = (List<Soba>)q2.list();
    			
    			List<Soba> dostupneSobe = new ArrayList<Soba>();
    			for(Soba soba : sveSobe)
    			{
    				if(!ret.contains(soba.getId()))
    				{
    					if(klasa == 1 || klasa == 2)
    					{
    						if(soba.getBrojKreveta() == klasa)
    						{
    							dostupneSobe.add(soba);
    						}
    					}
    					else
    					{
    						dostupneSobe.add(soba);
    					}
    					
    				}
    			}
    				
    			return dostupneSobe;	
			}
	
	public static List<Gost> dajSveGoste()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Gost.class.getName());
	
		return (List<Gost>)q.list();
		
		
	}
	
	public static void evidentirajBoravkeIRezervaciju(Soba soba, List<Gost> gosti, Date datumOD, Date datumDo, Zaposlenik zaposlenik)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setBrojRezervacije(1);
		rezervacija.setKreiraoZaposlenik(zaposlenik);
		rezervacija.setPotvrdjena(true);
		rezervacija.setRezervisanoDo(datumDo);
		rezervacija.setRezervisanoOd(datumOD);
		rezervacija.setSoba(soba);
		session.save(rezervacija);
		for(Gost gost : gosti)
		{
			Boravak boravak = new Boravak();
			boravak.setGost(gost);
			boravak.setRezervacija(rezervacija);
			boravak.setVrijemeDolaska(datumOD);
			boravak.setVrijemeOdlaska(datumDo);
			session.save(boravak);		
		}
		t.commit();
		
	}
	
	public static List<Rezervacija> dajSveRezervacije(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Rezervacija.class.getName());
		return (List<Rezervacija>)q.list();
	}
	
	public static Gost getGostRezervacija(Rezervacija rezervacija){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Boravak.class.getName() + " boravak where boravak.rezervacija.id = :rezervacijaid");
		q.setParameter("rezervacijaid", rezervacija.getId());
		List<Boravak> boravci = (List<Boravak>)q.list();
		if(boravci.size() == 0)
		{
			return null;
		}
		return boravci.get(0).getGost();
		
	}
	
	public static void otkaziRezervaciju(Rezervacija rezervacija){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from " + Boravak.class.getName() + " boravak where boravak.rezervacija.id = :rezervacijaid");
		q.setParameter("rezervacijaid", rezervacija.getId());
		List<Boravak> boravci = (List<Boravak>)q.list();
		for(int i=0; i<boravci.size(); i++)
		{
			session.delete(boravci.get(i));
		}
		Query q2 = session.createQuery("from " + Rezervacija.class.getName() + " where id = :rezervacijaid");
		q2.setParameter("rezervacijaid", rezervacija.getId());
		Rezervacija rez = (Rezervacija)q2.uniqueResult();
		session.delete(rez);
		t.commit();
		
	}
	
	public static List<Soba> dajRezervisaneSobe(Date datumOD, Date datumDO, int klasa)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Soba.class.getName());
		List<Soba> slobodneSobe = DBManager.dajSlobodneSobe(datumOD, datumDO, klasa);
		List<Long> slobodneSobeIds = new ArrayList();
		List<Soba> zauzeteSobe = new ArrayList();
		for(Soba soba : slobodneSobe)
		{
			slobodneSobeIds.add(soba.getId());
		}
		
		List<Soba> sveSobe = (List<Soba>)q.list();
		for(Soba soba  : sveSobe)
		{
			if(!slobodneSobeIds.contains(soba.getId()))
			{
				if(klasa == 1 || klasa == 2)
				{
					if(soba.getBrojKreveta() == klasa)
					{
						zauzeteSobe.add(soba);
					}
				}
				else
				{
					zauzeteSobe.add(soba);
				}
			}
		}
		
		return zauzeteSobe;
	}
	
	public static Rezervacija dajRezervacijuZaSobu(Soba soba, Date datumOD, Date datumDO, int redniBroj)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Rezervacija.class.getName() + 
				" rezervacija where rezervacija.soba is not null and rezervacija.soba.id = :sobaid");
		q.setParameter("sobaid", soba.getId());
		
		List<Rezervacija> sveRezervacijeZaSobu = (List<Rezervacija>)q.list();
		List<Rezervacija> rezervacijeUDatomPeriodu = new ArrayList();
		for(Rezervacija r : sveRezervacijeZaSobu)
		{
			if(
					(r.getRezervisanoOd().before(datumOD) && r.getRezervisanoDo().before(datumOD)) ||
					(r.getRezervisanoOd().after(datumDO) && r.getRezervisanoDo().after(datumDO)))

			{
				continue;
			}
			else
			{
				rezervacijeUDatomPeriodu.add(r);
			}
		}
		
		if(rezervacijeUDatomPeriodu.size() >= redniBroj + 1)
		{
			return rezervacijeUDatomPeriodu.get(redniBroj);
		}
		return null;
		
	}
	
	public static Boolean daLiJePlaceno(Rezervacija rezervacija)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Predracun.class.getName() + " predracun where predracun.rezervacija.id = :rezId");
		q.setParameter("rezId", rezervacija.getId());
		Predracun predracun = (Predracun)q.uniqueResult();
		
		if(predracun == null)
		{
			return false;
		}
		
		Query q1 = session.createQuery("from " + Racun.class.getName() + " racun where racun.predracun.id = :predId");
		q1.setParameter("predId", predracun.getId());
		Racun racun = (Racun)q1.uniqueResult();
		
		return racun != null;
		
	}
	
	/*public static List<StraniGost> dajStraneGoste() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query2 = session
				.createQuery("from StraniGost stranigost join stranigost.gost as gost join gost.osoba as osoba");

		List<Object[]> objekti2 = (List<Object[]>) query2.list();
		List<StraniGost> stranigosti = new ArrayList<StraniGost>();

		for (Object[] o : objekti2) {
			for (Object o2 : o) {
				if (o2.getClass().equals(StraniGost.class)) {
					stranigosti.add((StraniGost) o2);
				}
			}
		}
		session.close();
		t.commit();
		return stranigosti;
	}*/

	/*public static List<Gost> dajGoste() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		Query query = session
				.createQuery("from Gost gost join gost.osoba as osoba");

		List<Object[]> objekti = (List<Object[]>) query.list();
		List<Gost> gosti = new ArrayList<Gost>();

		for (Object[] o : objekti) {
			for (Object o2 : o) {
				if (o2.getClass().equals(Gost.class)) {
					gosti.add((Gost) o2);
				}
			}

		}
		t.commit();

		session.close();
		return gosti;
	}

	
	/*public static List<Osoba> dajOsobe() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		Query query = session
				.createQuery("from Osoba");

		List<Object[]> objekti = (List<Object[]>) query.list();
		List<Osoba> osobe = new ArrayList<Osoba>();

		for (Object[] o : objekti) {
			for (Object o2 : o) {
				if (o2.getClass().equals(Osoba.class)) {
					osobe.add((Osoba) o2);
				}
			}

		}
		t.commit();

		session.close();
		return osobe;
	}*/
	
	public static List<Osoba> dajOsobe(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Osoba.class.getName());
		List<Osoba> lista=q.list();
		session.close();
		return lista;
	
	}
	

	public static List<StraniGost> dajStraneGoste(){
		Session session = HibernateUtil.getSessionFactory().openSession();
	//	Query q = session.createQuery("from " + StraniGost.class.getName());
		Query q = session.createQuery("from StraniGost");
		List<StraniGost> lista=q.list();
		session.close();
		return lista;
	}
	public static List<Gost> dajGoste(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Gost.class.getName());
		List<Gost> lista=q.list();
		session.close();
		return lista;
		
	}

	
	
	
	
	
	public static void obrisiGosta(Gost g) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(g);
		session.close();
		t.commit();
	}

	public static void obrisiStranogGosta(StraniGost sg) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(sg);
		t.commit();
		session.close();
	}

	public static void obrisiOsobu(Osoba o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(o);
		t.commit();
		session.close();
	}
	
	public static StraniGost dajStranogZaGosta(Gost g)
	{Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
		
		String q = "FROM StraniGost qt WHERE qt.gost = :tag";
		Query query = (Query) session.createQuery(q);
		query.setParameter("tag", g);
		List<StraniGost> stranigosti = query.list();
	//	StraniGost sg = new StraniGost();
	
		
		t.commit();

		session.close();
		if(stranigosti==null) return null;
		return stranigosti.get(0);

	}
	
	public static void updateStranogGosta(StraniGost sg){
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	session.update(sg);
	t.commit();
	session.close();
	}
	
	public static void updateGosta(Gost g){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(g);
		t.commit();
		session.close();
		}
	public static void updateOsobu(Osoba o){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(o);
		t.commit();
		session.close();
		}
	
	public static void saveStranogGosta(StraniGost sg){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(sg);
		t.commit();
		session.close();
		}
	
	public static void saveGosta(Gost g){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(g);
		t.commit();
		session.close();
		}
	
	public static void saveOsobu(Osoba o){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(o);
		t.commit();
		session.close();
		}
	public static void spasiRezervaciju(Rezervacija rezervacija){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(rezervacija);
		t.commit();
		session.close();
		}
	
	public static List<Soba> dajSveSobe(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		final Query query = session.createQuery("from Soba");
		List<Soba> sobe=new ArrayList<Soba>();
		sobe = (ArrayList<Soba>)query.list();
		t.commit();
		return sobe;
	
	}
	
	public static List<Zaposlenik> dajSveZaposlenike(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		final Query query = session.createQuery("from Zaposlenik");
		List<Zaposlenik> zaposlenici=new ArrayList<Zaposlenik>();
		zaposlenici = (ArrayList<Zaposlenik>)query.list();
		t.commit();
		session.close();
		return zaposlenici;
	
	}
public static void spasiSobu(Soba soba){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(soba);
		t.commit();
		session.close();
		
	}

public static void spasiZaposlenika(Zaposlenik zaposlenik){
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	session.save(zaposlenik);
	t.commit();
	session.close();
	
}

public static void spasiBoravak(Boravak boravak){
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	session.save(boravak);
	t.commit();
	session.close();
	
}


	
	public static void obrisiStranogZaGosta(StraniGost sg)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query2 = session
				.createQuery("delete StraniGost where id = :idgosta");
		query2.setParameter("idgosta", sg);
		query2.executeUpdate();
		t.commit();
		session.close();
		
		
		
	}
	
	/*forma za osoblje*/
	public static List<Zaposlenik> dajZaposlenike(String pretraga)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from " + Zaposlenik.class.getName());
		List<Zaposlenik> sviZaposlenici = (List<Zaposlenik>)q.list();
		List<Zaposlenik> zaposlenici = new ArrayList<Zaposlenik>();
		pretraga = pretraga.toLowerCase();
		
		for(Zaposlenik zaposlenik : sviZaposlenici)
		{
			if(zaposlenik.getOsoba() != null && zaposlenik.getOsoba().getImePrezime().toLowerCase().contains(pretraga))
			{
				zaposlenici.add(zaposlenik);
			}
		}
		
		return zaposlenici;
		
	}
	
	public static void spremiZaposlenika(Zaposlenik zaposlenik)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(zaposlenik.getOsoba());
		session.save(zaposlenik);
		t.commit();
	}
	
	public static void obrisiZaposlenika(Zaposlenik zaposlenik)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from " + Zaposlenik.class.getName() + " zaposlenik where id = :zaposlenikid");
		q.setParameter("zaposlenikid", zaposlenik.getId());
		Zaposlenik zap = (Zaposlenik)q.uniqueResult();
		session.delete(zap.getOsoba());
		session.delete(zap);
		t.commit();
		
	}
	
	public static void urediZaposlenika(Zaposlenik zaposlenik)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(zaposlenik);
		t.commit();
		session.close();
	}
	
	//gosti
		public static int dajUkupanBrojRazlicitihGostiju()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.createQuery("from " + Boravak.class.getName());
			List<Boravak> sviBoravci = (List<Boravak>)q.list();
			session.close();
			List<Long> gostIds = new ArrayList();
			for(Boravak boravak : sviBoravci)
			{
				if(boravak.getGost() != null)
				{
					if(!gostIds.contains(boravak.getGost().getId()))
					{
						gostIds.add(boravak.getGost().getId());
					}
				}
			}
			
			return gostIds.size();
		}
		
		public static int dajTrenutniBrojGostiju()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.createQuery("from " + Boravak.class.getName());
			List<Boravak> sviBoravci = (List<Boravak>)q.list();
			session.close();
			Date today = new Date();
			int trBroj = 0;
			for(Boravak boravak : sviBoravci)
			{
				if(today.after(boravak.getVrijemeDolaska()) && today.before(boravak.getVrijemeOdlaska()))
				{
					trBroj++;
				}
			}
			
			return trBroj;
			
		}
		
		public static boolean daLiPostojiUserName(String username)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.createQuery("from " + Zaposlenik.class.getName() + " zaposlenik"
					+ " where zaposlenik.username = :username");
			q.setParameter("username", username);
			Zaposlenik z = (Zaposlenik)q.uniqueResult();
			
			return z != null;
		}
	
}
