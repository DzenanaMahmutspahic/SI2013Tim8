package Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Klase.Gost;
import Klase.Osoba;

public class PlacanjeMain {
	private static Scanner sc = new Scanner(System.in);
	
	public static List<Gost> dajGoste() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction t = session.beginTransaction();

		Query q = session.createQuery("from Gost gost join gost.osoba");
		//Query q1 = session.createQuery("from Osoba osoba, Gost gost where osoba.id=gost.osoba");

	    List<Object[]> objekti = (List<Object[]>) q.list();
	    List<Gost> gosti = new ArrayList<Gost>();
	    
	    for(Object[] o : objekti){
	    	for(Object o2: o){
	    		if(o2.getClass().equals(Gost.class)){
	    			gosti.add((Gost)o2);
	    		}
	    	}
	    	
	    }
	    
	    //List<Osoba> osoba = (List<Osoba>) q1.list();
	    //t.commit();
		session.close();
		return gosti;
		}

}
