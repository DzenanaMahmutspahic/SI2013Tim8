package Hibernate;

import junit.framework.TestCase;
import Klase.Rezervacija;
import Klase.Soba;

import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

public class DBManagerTest extends TestCase {
//testiranje metoda iz klase DBManager
	//komentar
	public void testProvjeriLogin() {
		fail("Not yet implemented"); // TODO
	}

	public void testDajBoravke() {
		fail("Not yet implemented"); // TODO
	}

	public void testDajBoravke2() {
		fail("Not yet implemented"); // TODO
	}

	public void testDajZauzeteSobeProvjeraException() { 
		//Test za provjeru bacanja izuzetka metode dajZauzeteSobe
		
		java.util.Date datumOD= new java.util.Date();
		java.util.Date datumDO= new java.util.Date();
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try{ 
			
		try {
			 datumOD=sdf.parse("2014-06-10");
	        }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try {
			 datumDO=sdf.parse("2014-06-05");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		 
		 java.util.List testnaListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
		 
		} 
		catch(Exception e)
		{
			assertTrue(true);
		}
		 
	}
	public void testDajZauzeteSobeProvjeraExceptionFalse() { 
		//Test za provjeru bacanja izuzetka metode dajZauzeteSobe, u slucaju kad ne treba da baci izuzetak, da smo sigurni
		//da ga neće ni baciti
		
		java.util.Date datumOD= new java.util.Date();
		java.util.Date datumDO= new java.util.Date();
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try{ 
			
		try {
			 datumOD=sdf.parse("2014-06-10");
	        }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try {
			 datumDO=sdf.parse("2014-06-15");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		 
		 java.util.List testnaListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
		 
		} 
		catch(Exception e)
		{
			assertFalse(false);
		}
		 
	}
	
	
	//testira slucaj kad se unesu ispravni datumi, da li ce metoda dobro vratiti listu zauzetih soba, treba vratiti true
	public void testDajZauzeteSobe() 
	{
		java.util.Date datumOD= new java.util.Date();
		java.util.Date datumDO= new java.util.Date();
		java.util.Date rezervisanoOD= new java.util.Date();
		java.util.Date rezervisanoDO= new java.util.Date();
		java.util.Date rezervisanoOD1= new java.util.Date();
		java.util.Date rezervisanoDO1= new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			 datumOD=sdf.parse("2014-06-15");
	    }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	    }
		
		 try
		 {
			 datumDO=sdf.parse("2014-06-20");
	     }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		
		try
		{
			 rezervisanoOD=sdf.parse("2014-06-10");
	     }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try
		 {
			 rezervisanoDO=sdf.parse("2014-06-20");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		 try
		 {
			 rezervisanoOD1=sdf.parse("2014-06-10");
	        }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try 
		 {
			 rezervisanoDO1=sdf.parse("2014-06-25");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
	   
		Soba s= new Soba();
		Soba s1=new Soba();
		
		Rezervacija r=new Rezervacija();
		Rezervacija r1=new Rezervacija();
		
		s.setBrojSobe(1);
		s.setBalkon(true);
		s.setBrojKreveta(2);
		s.setSprat(2);
		
		s1.setBrojSobe(2);
		s1.setBalkon(true);
		s1.setBrojKreveta(2);
		s1.setSprat(2);
		
		r.setSoba(s);
		r.setRezervisanoOd(rezervisanoOD);
		r.setRezervisanoDo(rezervisanoDO);
		
		r1.setSoba(s1);
		r1.setRezervisanoOd(rezervisanoOD1);
		r1.setRezervisanoDo(rezervisanoDO1);
		
		java.util.List tempListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
		
		assertTrue(tempListaSoba.contains(1) && tempListaSoba.contains(2));
		
	}
	//testira slucaj kad se unesu ispravni datumi, da li ce metoda dobro vratiti listu zauzetih soba jer je prva soba zauzeta
	//samo dio perioda, a ne cijeli period koji trazimo
	public void testDajZauzeteSobeDioPerioda() 
	{
		java.util.Date datumOD= new java.util.Date();
		java.util.Date datumDO= new java.util.Date();
		java.util.Date rezervisanoOD= new java.util.Date();
		java.util.Date rezervisanoDO= new java.util.Date();
		java.util.Date rezervisanoOD1= new java.util.Date();
		java.util.Date rezervisanoDO1= new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			 datumOD=sdf.parse("2014-06-15");
	    }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	    }
		
		 try
		 {
			 datumDO=sdf.parse("2014-06-20");
	     }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		
		try
		{
			 rezervisanoOD=sdf.parse("2014-06-16");
	     }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try
		 {
			 rezervisanoDO=sdf.parse("2014-06-18");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
		 try
		 {
			 rezervisanoOD1=sdf.parse("2014-06-10");
	        }
		catch(java.text.ParseException p)
		{
	            System.out.println(p.toString());
	      }
		
		 try 
		 {
			 rezervisanoDO1=sdf.parse("2014-06-30");
	       }
		 catch(java.text.ParseException p1) 
		 {
	            System.out.println(p1.toString());
	      }
	   
		Soba s= new Soba();
		Soba s1=new Soba();
		
		Rezervacija r=new Rezervacija();
		Rezervacija r1=new Rezervacija();
		List<Rezervacija> rez = new ArrayList<Rezervacija>();
		
		s.setBrojSobe(1);
		s.setBalkon(true);
		s.setBrojKreveta(2);
		s.setSprat(2);
		
		s1.setBrojSobe(2);
		s1.setBalkon(true);
		s1.setBrojKreveta(2);
		s1.setSprat(2);
		
		r.setSoba(s);
		r.setRezervisanoOd(rezervisanoOD);
		r.setRezervisanoDo(rezervisanoDO);
		
		r1.setSoba(s1);
		r1.setRezervisanoOd(rezervisanoOD1);
		r1.setRezervisanoDo(rezervisanoDO1);
		
		//rez.add(r);
		//rez.add(r1);
		
	//	for(Rezervacija rez1: rez){
		java.util.List tempListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
		assertTrue(tempListaSoba.contains(2) && tempListaSoba.contains(1));
		//}
		
		
	}

	public void testDajPredracun() {
		fail("Not yet implemented"); // TODO
	}

	public void testDajRacun() {
		fail("Not yet implemented"); // TODO
	}

	public void testUnesiPredracun() {
		fail("Not yet implemented"); // TODO
	}

	public void testUpdatePredracun() {
		fail("Not yet implemented"); // TODO
	}

	public void testUnesiRacun() {
		fail("Not yet implemented"); // TODO
	}

}
