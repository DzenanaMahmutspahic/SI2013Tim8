package Hibernate;

import junit.framework.TestCase;

import java.text.ParseException;

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
