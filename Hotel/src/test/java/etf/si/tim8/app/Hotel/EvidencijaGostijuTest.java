package etf.si.tim8.app.Hotel;


import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;
import etf.si.tim8.app.Hotel.EvidencijaGostiju;

public class EvidencijaGostijuTest extends TestCase {
 
	public void testValidateFirstName()
	{
		String ime="Alen";
		Boolean rezultat=EvidencijaGostiju.validateFirstName(ime);
		Assert.assertTrue(rezultat);		
	}

    public void testValidateFirstName2()
	{
		String ime="alen";
		Boolean rezultat=EvidencijaGostiju.validateFirstName(ime);
		Assert.assertFalse(rezultat);		
	}

	public void testValidateLasttName()
	{
		String ime="Kopic";
		Boolean rezultat=EvidencijaGostiju.validateLastName(ime);
		Assert.assertTrue(rezultat);		
	}
    public void testValidateLastName2()
	{
		String ime="kopic";
		Boolean rezultat=EvidencijaGostiju.validateLastName(ime);
		Assert.assertFalse(rezultat);		
	}
    
    public void testValidateCity()
 	{
 		String grad="Banja Luka";
 		Boolean rezultat=EvidencijaGostiju.validateCity(grad);
 		Assert.assertTrue(rezultat);		
 	}
    
    public void testValidateCity2()
 	{
 		String grad="Banja luka";
 		Boolean rezultat=EvidencijaGostiju.validateCity(grad);
 		Assert.assertFalse(rezultat);		
 	}
    
    public void testValidateNationality()
   	{
   		String nacionalnost="BIH";
   		Boolean rezultat=EvidencijaGostiju.validateNationality(nacionalnost);
   		Assert.assertTrue(rezultat);		
   	}
    
    public void testValidateNationality2()
   	{
   		String nacionalnost="bih";
   		Boolean rezultat=EvidencijaGostiju.validateNationality(nacionalnost);
   		Assert.assertFalse(rezultat);		
   	}
    
    
    public void testValidateBrojPutneIspave()
   	{
   		String brojIsprave="A000000";
   		Boolean rezultat=EvidencijaGostiju.validateBrojPutneIspave(brojIsprave);
   		Assert.assertTrue(rezultat);		
   	}
    
    public void testValidateBrojPutneIspave2()
   	{
    	String brojIsprave="0123456";
   		Boolean rezultat=EvidencijaGostiju.validateBrojPutneIspave(brojIsprave);
   		Assert.assertFalse(rezultat);			
   	}
     
    
    public void testValidateDatumRodjenja()
   	{
    	Date datumRodjenja=new Date();
   	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				datumRodjenja=sdf.parse("2992-10-21");
			} catch (java.text.ParseException p) {
				System.out.println(p.toString());
			}
   		Boolean rezultat=EvidencijaGostiju.validateDatumRodjenja(datumRodjenja);
   		Assert.assertFalse(rezultat);		
   	}
    
    public void testValidateDatumRodjenja2()
   	{
    	Date datumRodjenja=new Date();
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				datumRodjenja=sdf.parse("1992-10-21");
			} catch (java.text.ParseException p) {
				System.out.println(p.toString());
			}
   		Boolean rezultat=EvidencijaGostiju.validateDatumRodjenja(datumRodjenja);
   		Assert.assertTrue(rezultat);			
   	}
     
    
}