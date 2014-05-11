package Hibernate;
import java.util.Scanner; 
 


import org.hibernate.Transaction; 
import org.hibernate.Session; 

import Klase.Soba;
 

public class Test { 
 private static Scanner sc = new Scanner(System.in); 
 
 public static void main(String[] args) {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
	Soba soba = new Soba();
	soba.setBrojKreveta(1);
	soba.setBrojSobe(1);
	soba.setCijena(100);
	soba.setSprat(4);
	soba.setZauzeta(false);
	session.save(soba);
 t.commit();
 
 session.close();
 System.out.println("SVE JE OK !");
 } 
 
 
} 
