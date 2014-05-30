package Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import Klase.StraniGost;
import Klase.Gost;
import Klase.Osoba;

public class EvidencijaGostijuMain {

	private static Scanner sc = new Scanner(System.in);

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
