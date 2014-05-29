package Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Klase.Rezervacija;
import Klase.Boravak;
import Klase.Predracun;
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
		//Transaction t = session.beginTransaction();

		Query q = session.createQuery("from Boravak boravak join boravak.gost as gost join gost.osoba as osoba join boravak.rezervacija as rezervacija join rezervacija.soba as soba where rezervacija.potvrdjena =true and (boravak.vrijemeOdlaska is null or boravak.vrijemeOdlaska >= :danas)");//or vrijemeOdlaska isnull
		q.setParameter("danas", new Date());
		
	    List<Object[]> objekti = (List<Object[]>) q.list();
	    List<Boravak> boravci = new ArrayList<Boravak>();//Da nesto dodam
	    
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
	
	/*Za Ekran za placanje */
	public static void unesiPredracun(Predracun p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(p);
		t.commit();
	}
	
	public static void updatePredracun(Predracun p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(p);
		t.commit();
	}

}
