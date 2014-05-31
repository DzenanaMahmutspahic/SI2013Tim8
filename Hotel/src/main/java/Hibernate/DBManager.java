package Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	
	
	/*Za Ekran za placanje */
	public static List<Boravak> dajBoravke() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Boravak boravak where boravak.rezervacija.potvrdjena=true and (boravak.vrijemeOdlaska is null or boravak.vrijemeOdlaska>=:danas)");
		q.setParameter("danas", new Date());
		
		List<Boravak> boravci = q.list();
		session.close();
		return boravci; 
		//return ret;
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
		session.close();
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
			session.close();
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
	
	/*Za Ekran za placanje */
	public static void unesiPredracun(Predracun predracun){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(predracun);
		t.commit();
	}
	
	public static void updatePredracun(Predracun p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(p);
		t.commit();
		//session.close();
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
	
	public static List<StraniGost> dajStraneGoste() {
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
	}

	public static List<Gost> dajGoste() {
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

	
	public static List<Osoba> dajOsobe() {
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
	}
	
	
	
	
	
	
	
	public static void obrisiGosta(Gost g) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(g);
		t.commit();
	}

	public static void obrisiStranogGosta(StraniGost sg) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(sg);
		t.commit();
	}

	public static void obrisiOsobu(Osoba o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(o);
		t.commit();
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
	}
	
	public static void updateGosta(Gost g){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(g);
		t.commit();
		}
	public static void updateOsobu(Osoba o){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(o);
		t.commit();
		}
	
	public static void saveStranogGosta(StraniGost sg){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(sg);
		t.commit();
		}
	
	public static void saveGosta(Gost g){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(g);
		t.commit();
		}
	
	public static void saveOsobu(Osoba o){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(o);
		t.commit();
		}
	public static void spasiRezervaciju(Rezervacija rezervacija){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(rezervacija);
		t.commit();
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
public static void spasiSobu(Soba soba){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(soba);
		t.commit();
		
	}

public static void spasiZaposlenika(Zaposlenik zaposlenik){
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	session.save(zaposlenik);
	t.commit();
	
}

public static void spasiBoravak(Boravak boravak){
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	session.save(boravak);
	t.commit();
	
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
	
}
