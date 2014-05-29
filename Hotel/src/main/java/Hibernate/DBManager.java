package Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Klase.Racun;
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
	
	
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		
		java.util.List tempListaSoba = new java.util.ArrayList();
		
		for(int i=1; i<=16;i++){	
			
			//ResultSet rs = st.executeQuery ("select * from rezervacija where SOBA="+i+"");
			Query q=session.createQuery("select * from rezervacija where SOBA="+i+"");
			sc.next();
			//java.util.Date rezervisanoOD=Rezervacija.class.getRezervisanoOd();
			java.util.Date rezervisanoDO= (java.util.Date) q.setParameter("rezervisanoDo", rezervisanoDO);
			java.util.Date rezervisanoOD= (java.util.Date) q.setParameter("rezervisanoOd", rezervisanoOD);
			Integer soba=getInt;
			
			
			if(datumDO.before(rezervisanoOD) || datumOD.after(rezervisanoDO) || (datumOD.after(rezervisanoDO) && datumDO.before(rezervisanoOD)))	        			        			
			{
				
				tempListaSoba.add(soba);
					
			}
			
			return tempListaSoba;*/
	public static List<Integer> dajSlobodneSobe(java.util.Date datumOD, java.util.Date datumDO){
		Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.createQuery("from " + Rezervacija.class.getName() + " rezervacija where rezervacija.soba is not null");
		
			
			List<Rezervacija> rezervacije = (List<Rezervacija>)q.list();
			List<Integer> ret = new ArrayList<Integer>();
			for(Rezervacija r: rezervacije){
				if(datumDO.before(r.getRezervisanoOd()) || datumOD.after(r.getRezervisanoDo()) || (datumOD.after(r.getRezervisanoDo()) && datumDO.before(r.getRezervisanoOd())))	        			        			
    			{
    				ret.add(r.getSoba().getBrojSobe());
    				
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
	}
	
	public static void updatePredracun(Predracun p){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(p);
		t.commit();
	}
	
	public static void unesiRacun(Racun racun){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(racun);
		t.commit();
	}

}
