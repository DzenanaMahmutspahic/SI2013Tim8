package Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Klase.Gost;
import Klase.Racun;
import Klase.Rezervacija;
import Klase.Boravak;
import Klase.Predracun;
import Klase.Soba;
import Klase.Zaposlenik;

public class DBManager {
	
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

		Query q = session.createQuery("from Boravak boravak join boravak.gost as gost join gost.osoba as osoba join boravak.rezervacija as rezervacija join rezervacija.soba as soba where rezervacija.potvrdjena =true and (boravak.vrijemeOdlaska is null or boravak.vrijemeOdlaska >= :danas)");//or vrijemeOdlaska isnull
		q.setParameter("danas", new Date());
		
	    List<Object[]> objekti = (List<Object[]>) q.list();
	    List<Boravak> boravci = new ArrayList<Boravak>();//D
	    
	    for(Object[] o : objekti){
	    	for(Object o2: o){
	    		if(o2.getClass().equals(Boravak.class)){
	    			boravci.add((Boravak)o2);
	    		}
	    	}
	    	
	    }
	    //List<Osoba> osoba = (List<Osoba>) q1.list();//t.commit();
		session.close();
		return boravci;
	}
	
	public static List<Boravak> dajBoravke2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query q = session.createQuery("from Boravak boravak");
		List<Boravak> boravci = q.list();
		List<Boravak> ret = new ArrayList<Boravak>();
		
		for(Boravak b: boravci){ //System.out.println("ajd");
			if(b.getVrijemeOdlaska() != null ) {
				if(b.getRezervacija().getPotvrdjena() == true && ( b.getVrijemeOdlaska().after(new Date()) ))
					ret.add(b);
			}
		}
		session.close();
		return boravci;
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
			return ret;
		

	}
	
	
	public static Predracun dajPredracun(Rezervacija rezervacija) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction t = session.beginTransaction();

		Query q = session.createQuery("from Predracun predracun where rezervacija=:rezervacija");//or vrijemeOdlaska isnull
		q.setParameter("rezervacija", rezervacija);
		
		Predracun predracun;
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
	public static void unesiPredracun(Predracun p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(p);
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
	
}
