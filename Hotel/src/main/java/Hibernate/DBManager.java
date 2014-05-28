package Hibernate;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

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

}
