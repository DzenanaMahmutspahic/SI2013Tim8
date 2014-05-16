package Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Klase.Boravak;
import Klase.Gost;
import Klase.Osoba;
import Klase.Predracun;

public class PlacanjeMain {//zasto je datumrodjenja u gost, da li se brojdana uzima iz boravka ili unosi, dal se prikazuju samo gosti koji su trenutno tu, predracun treba biti vezan za boravak, ukupna cijena pred(racun)
	private static Scanner sc = new Scanner(System.in);
	
	public static List<Boravak> dajBoravke() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction t = session.beginTransaction();

		Query q = session.createQuery("from Boravak boravak join boravak.gost as gost join gost.osoba as osoba join boravak.rezervacija as rezervacija join rezervacija.soba as soba where boravak.vrijemeOdlaska >= :danas");//or vrijemeOdlaska isnull
		q.setParameter("danas", new Date());
		Query q1 = session.createQuery("from Rezervacija rezervacija join rezervacija.soba");
		 List<Object[]> objekti1 = (List<Object[]>) q1.list();
		
	    List<Object[]> objekti = (List<Object[]>) q.list();
	    List<Boravak> boravci = new ArrayList<Boravak>();
	    
	    for(Object[] o : objekti){
	    	for(Object o2: o){
	    		if(o2.getClass().equals(Boravak.class)){
	    			boravci.add((Boravak)o2);
	    		}
	    	}
	    	
	    }
	    
	    //List<Osoba> osoba = (List<Osoba>) q1.list();
	    //t.commit();
		session.close();
		return boravci;
		}
	
	public static void unesiPredracun(Predracun p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(p);
		t.commit();
	}

}
