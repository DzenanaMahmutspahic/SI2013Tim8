/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etf.si.tim8.app.Hotel;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JRadioButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.DBManager;
import Hibernate.HibernateUtil;
import Klase.Gost;
import Klase.Osoba;
import Klase.Zaposlenik;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author adnan
 */
public class OsobljeN extends javax.swing.JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	private Zaposlenik z;
	private String trenutniUsername;
    /**
     * Creates new form HomePage
     */
    public OsobljeN() {
    	setTitle("Hotel Ksenon Plaza-Osoblje");
    	getContentPane().setBackground(Color.WHITE);
    	setResizable(false);
    	setSize(1124,598);
    	getContentPane().setBounds(0, 0, 917, 642);
    	
    	setAutoRequestFocus(false);
    	getContentPane().setSize(917, 642);
    	getContentPane().setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBackground(SystemColor.inactiveCaptionBorder);
    	panel.setBounds(10, 11, 374, 538);
    	getContentPane().add(panel);
    	panel.setLayout(null);
    	
    	final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    	tabbedPane.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane.setBounds(0, 0, 374, 538);
    	tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
    	panel.add(tabbedPane);
    	
    	JPanel panel_2 = new JPanel();
    	panel_2.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_2.setLayout(null);
    	tabbedPane.addTab("Pretraga osoblja", null, panel_2, null);
    	
    	textField = new JTextField();
    	textField.setColumns(10);
    	textField.setBounds(216, 10, 141, 37);
    	panel_2.add(textField);
    	
    	JLabel label = new JLabel("Unesite ime ili prezime \r\n\u010Dlana osoblja:");
    	label.setBounds(10, -4, 296, 64);
    	panel_2.add(label);
    	
    	JButton button = new JButton("Pretra\u017Ei");
    	button.setBounds(255, 56, 102, 28);
    	panel_2.add(button);
    	
    	JPanel panel_3 = new JPanel();
    	panel_3.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_3.setLayout(null);
    	panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_3.setBounds(10, 87, 347, 410);
    	panel_2.add(panel_3);
    	
    	JLabel label_1 = new JLabel("Rezultati pretrage:");
    	label_1.setBounds(61, 5, 158, 14);
    	panel_3.add(label_1);
    	
    	final JList list = new JList();
    	list.setBounds(10, 32, 327, 367);
    	panel_3.add(list);
    	
    	JPanel panel_4 = new JPanel();
    
    	panel_4.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane.addTab("Lista svih radnika", null, panel_4, null);
    	panel_4.setLayout(null);
    	
    	
    	final JList list_1 = new JList();
    	list_1.setBounds(10, 11, 347, 486);
    	panel_4.add(list_1);
    	 tabbedPane.addChangeListener(new ChangeListener() {
    	        public void stateChanged(ChangeEvent e) {
    	            if(tabbedPane.getSelectedIndex()==1){
    	            	try
    	    			{
    	    				List<Zaposlenik> zaposlenici = DBManager.dajZaposlenike("");
    	    				DefaultListModel model = new DefaultListModel();
    	    				for(Zaposlenik zaposlenik : zaposlenici)
    	    				{
    	    					model.addElement(zaposlenik);
    	    				}
    	    				
    	    				list_1.setModel(model);
    	    				
    	    			}
    	    			catch(Exception ex)
    	    			{
    	    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
    	            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    	    			}
    	            	
    	            	
    	            }
    	            
    	            else
    	            {
    	            	try
    	    			{
    	    				List<Zaposlenik> zaposlenici = DBManager.dajZaposlenike(textField.getText());
    	    				DefaultListModel m = (DefaultListModel)list.getModel();
    	    				m.removeAllElements();
    	    				for(Zaposlenik zaposlenik : zaposlenici)
    	    				{
    	    					m.addElement(zaposlenik);
    	    				}
    	    				
    	    				
    	    			}
    	    			catch(Exception ex)
    	    			{
    	    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
    	            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    	    			}
    	            }
    	            
    	            
    	            
    	            
    	        }
    	    });
    	JPanel panel_1 = new JPanel();
    	panel_1.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_1.setBounds(402, 11, 497, 538);
    	getContentPane().add(panel_1);
    	panel_1.setLayout(null);
    	
    	JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
    	tabbedPane_1.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane_1.setBounds(0, 0, 497, 538);
    	tabbedPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
    	panel_1.add(tabbedPane_1);
    	
    	JPanel panel_5 = new JPanel();
    	panel_5.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane_1.addTab("Informacije:", null, panel_5, null);
    	panel_5.setLayout(null);
    	
    	textField_1 = new JTextField();
    	textField_1.setColumns(10);
    	textField_1.setBounds(107, 7, 123, 32);
    	panel_5.add(textField_1);
    	
    	textField_2 = new JTextField();
    	textField_2.setColumns(10);
    	textField_2.setBounds(107, 45, 123, 32);
    	panel_5.add(textField_2);
    	
    	textField_4 = new JTextField();
    	textField_4.setColumns(10);
    	textField_4.setBounds(107, 121, 123, 32);
    	panel_5.add(textField_4);
    	
    	textField_5 = new JTextField();
    	textField_5.setColumns(10);
    	textField_5.setBounds(107, 159, 123, 32);
    	panel_5.add(textField_5);
    	
    	textField_6 = new JTextField();
    	textField_6.setColumns(10);
    	textField_6.setBounds(107, 197, 123, 32);
    	panel_5.add(textField_6);
    	
    	textField_7 = new JTextField();
    	textField_7.setColumns(10);
    	textField_7.setBounds(107, 236, 123, 32);
    	panel_5.add(textField_7);
    	
    	textField_8 = new JTextField();
    	textField_8.setColumns(10);
    	textField_8.setBounds(107, 275, 123, 32);
    	panel_5.add(textField_8);
    	
    	textField_9 = new JTextField();
    	textField_9.setColumns(10);
    	textField_9.setBounds(107, 312, 123, 32);
    	panel_5.add(textField_9);
    	
    	textField_10 = new JTextField();
    	textField_10.setColumns(10);
    	textField_10.setBounds(359, 7, 123, 32);
    	panel_5.add(textField_10);
    	
    	textField_11 = new JTextField();
    	textField_11.setColumns(10);
    	textField_11.setBounds(359, 45, 123, 32);
    	panel_5.add(textField_11);
    	
    	textField_12 = new JTextField();
    	textField_12.setColumns(10);
    	textField_12.setBounds(359, 83, 123, 32);
    	panel_5.add(textField_12);
    	
    	textField_13 = new JTextField();
    	textField_13.setColumns(10);
    	textField_13.setBounds(359, 121, 123, 32);
    	panel_5.add(textField_13);
    	
    	JLabel label_2 = new JLabel("Ime:");
    	label_2.setBounds(10, -2, 210, 50);
    	panel_5.add(label_2);
    	
    	JLabel label_3 = new JLabel("Prezime:");
    	label_3.setBounds(10, 37, 210, 50);
    	panel_5.add(label_3);
    	
    	JLabel label_4 = new JLabel("JMBG:");
    	label_4.setBounds(10, 112, 200, 50);
    	panel_5.add(label_4);
    	
    	JLabel label_5 = new JLabel("Datum ro\u0111enja:");
    	label_5.setBounds(10, 74, 200, 50);
    	panel_5.add(label_5);
    	
    	JLabel label_6 = new JLabel("Adresa:");
    	label_6.setBounds(10, 150, 200, 50);
    	panel_5.add(label_6);
    	
    	JLabel label_7 = new JLabel("Dr\u017Eavljanstvo:");
    	label_7.setBounds(10, 188, 200, 50);
    	panel_5.add(label_7);
    	
    	JLabel label_8 = new JLabel("Titula:");
    	label_8.setBounds(10, 227, 200, 50);
    	panel_5.add(label_8);
    	
    	JLabel label_9 = new JLabel("Obrazovanje:");
    	label_9.setBounds(10, 266, 200, 50);
    	panel_5.add(label_9);
    	
    	JLabel label_10 = new JLabel("Email:");
    	label_10.setBounds(10, 305, 200, 50);
    	panel_5.add(label_10);
    	
    	JLabel label_11 = new JLabel("Telefon:");
    	label_11.setBounds(247, -2, 200, 50);
    	panel_5.add(label_11);
    	
    	JLabel label_12 = new JLabel("Mobitel:");
    	label_12.setBounds(247, 37, 200, 50);
    	panel_5.add(label_12);
    	
    	JLabel label_13 = new JLabel("Korisni\u010Dko ime:");
    	label_13.setBounds(247, 77, 200, 50);
    	panel_5.add(label_13);
    	
    	JLabel label_14 = new JLabel("Korisni\u010Dka lozinka:");
    	label_14.setBounds(247, 115, 200, 50);
    	panel_5.add(label_14);
    	
    	JPanel panel_6 = new JPanel();
    	panel_6.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_6.setLayout(null);
    	panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_6.setBounds(247, 184, 123, 160);
    	panel_5.add(panel_6);
    	
    	final JRadioButton rb_recepcioner = new JRadioButton("Recepcioner");
    	rb_recepcioner.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_recepcioner.setBounds(6, 7, 109, 23);
    	panel_6.add(rb_recepcioner);
    	
    	final JRadioButton rb_cistacica = new JRadioButton("\u010Cista\u010Dica");
    	rb_cistacica.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_cistacica.setBounds(6, 30, 109, 23);
    	panel_6.add(rb_cistacica);
    	
    	final JRadioButton rb_ekonomista = new JRadioButton("Ekonomista");
    	rb_ekonomista.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_ekonomista.setBounds(6, 82, 109, 23);
    	panel_6.add(rb_ekonomista);
    	
    	final JRadioButton rb_kuhar = new JRadioButton("Kuhar");
    	rb_kuhar.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_kuhar.setBounds(6, 56, 109, 23);
    	panel_6.add(rb_kuhar);
    	
    	final JRadioButton rb_manager = new JRadioButton("Manager");
    	rb_manager.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_manager.setBounds(6, 108, 109, 23);
    	panel_6.add(rb_manager);
    	
    	final JRadioButton rb_administrator = new JRadioButton("Administrator");
    	rb_administrator.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_administrator.setBounds(6, 130, 109, 23);
    	panel_6.add(rb_administrator);
    	
    	final ButtonGroup bg = new ButtonGroup();
    	bg.add(rb_administrator);
    	bg.add(rb_manager);
    	bg.add(rb_kuhar);
    	bg.add(rb_ekonomista);
    	bg.add(rb_cistacica);
    	bg.add(rb_recepcioner);
    	
    	JLabel label_15 = new JLabel("Uloge:");
    	label_15.setBounds(247, 150, 200, 50);
    	panel_5.add(label_15);
    	
    	JPanel panel_7 = new JPanel();
    	panel_7.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_7.setLayout(null);
    	panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_7.setBounds(10, 366, 220, 131);
    	panel_5.add(panel_7);
    	
    	JButton button_1 = new JButton("Uredi osobu");
    	button_1.setBounds(10, 10, 200, 33);
    	panel_7.add(button_1);
    	
    	JButton button_2 = new JButton("Izbri\u0161i osobu");
    	button_2.setBounds(10, 49, 200, 33);
    	panel_7.add(button_2);
    	
    	JButton button_3 = new JButton("Dodaj novu osobu");
    	button_3.setBounds(10, 88, 200, 33);
    	panel_7.add(button_3);
    	
    	JButton btnNewButton = new JButton("Po\u010Detna stranica");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			new EkranZaAdministratora().setVisible(true);
    			setVisible(false);
    		}
    	});
    	btnNewButton.setBounds(909, 499, 200, 50);
    	getContentPane().add(btnNewButton);
    	
    	JPanel panel_8 = new JPanel();
    	panel_8.setBackground(Color.WHITE);
    	panel_8.setBounds(909, 280, 200, 201);
    	getContentPane().add(panel_8);
    	ImageIcon guy = new ImageIcon("C:\\Users\\X\\Desktop\\hotel.png");
 		JLabel pn = new JLabel(guy);
 		panel_8.add(pn);
 		
 		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBackground(SystemColor.inactiveCaptionBorder);
        datePicker.setLocation(110, 85);
        datePicker.setSize(120, 26);
        panel_5.add(datePicker);
        button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try
    			{
    				List<Zaposlenik> zaposlenici = DBManager.dajZaposlenike(textField.getText());
    				DefaultListModel model = new DefaultListModel();
    				for(Zaposlenik zaposlenik : zaposlenici)
    				{
    					model.addElement(zaposlenik);
    				}
    				
    				list.setModel(model);
    				
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
        
        button_3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try
    			{
    				String x = textField_12.getText();
    				if(textField_1.getText() == "" || textField_2.getText() == "" ||
    				   textField_4.getText() == "" || textField_5.getText() == "" ||
    				   textField_6.getText() == "" || textField_7.getText() == "" ||
    				   textField_8.getText() == "" || textField_9.getText() == "" ||
    				   textField_10.getText() == "" || textField_11.getText() == "" ||
    				   textField_12.getText().length() == 0 || textField_13.getText().length() == 0 ||
    				   datePicker.getModel().getValue() == null)
    				{
    					JOptionPane.showMessageDialog(null, "Greska! Niste unijeli sve podatke!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				else{
    				Osoba osoba = new Osoba();
    				Zaposlenik zaposlenik = new Zaposlenik();
    				osoba.setImePrezime(textField_1.getText() + " " + textField_2.getText());
    				
    				if(textField_1.getText().length()<3){
    					JOptionPane.showMessageDialog(null, "Ime ne može biti kraće od 3 slova!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				
    				if(textField_2.getText().length()<3){
    					JOptionPane.showMessageDialog(null, "Prezime ne može biti kraće od 3 slova!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				
    				zaposlenik.setJMB(textField_4.getText());
    				
    				/*if(textField_4.getText().length()!=13)
    				{
    					JOptionPane.showMessageDialog(null, "Niste unijeli validan JMBG!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}*/
    				 try{
    					 String jmbg = String.valueOf(textField_4.getText()).trim();
    			           // String jmbg = String.valueOf(tekst).trim();
    			            long br = Long.parseLong(jmbg);
    			            if (jmbg.trim().length()!=13){
    			                //throw new Exception("JMBG mora sadrzavati 13 cifara!");
    			            JOptionPane.showMessageDialog(null, "JMBG mora sadržavati 13 cifara!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;}
    			        }catch(NumberFormatException e1){
    			           // throw new NumberFormatException("JMBG mora sadrzavati samo cifre!");
    			            JOptionPane.showMessageDialog(null, "JMBG mora sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;
    			        }
    				 
    				osoba.setAdresa(textField_5.getText());
    				osoba.setDatumRodjenja((java.util.Date) datePicker.getModel().getValue());
    				//Date d = new Date(System.currentTimeMillis());
    				java.util.Date date = new java.util.Date();
    				java.util.Date datumRodjenja = new java.util.Date();
    				datumRodjenja=(java.util.Date) datePicker.getModel().getValue();
    				if(datumRodjenja.after(date)){
    					JOptionPane.showMessageDialog(null, "Datum rodjenja mora biti manji od trenutnog datuma!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    					
    				zaposlenik.setDrzavljanstvo(textField_6.getText());
    				zaposlenik.setTitula(textField_7.getText());
    				zaposlenik.setObrazovanje(textField_8.getText());
    				
    				
    					String email = String.valueOf(textField_9.getText()).trim();
    					boolean validmail = true;
    					if(!email.contains(".") && !email.contains("@")) validmail=false;
    					if(email.indexOf("@") > email.indexOf(".") || email.indexOf("@") ==0) validmail=false;
    					if(validmail) zaposlenik.setDrzavljanstvo(email);
    					else{ 
    						JOptionPane.showMessageDialog(null, "Nevalidan mail!", "Info", JOptionPane.ERROR_MESSAGE); 
    						return;
    					}
    					
    				
    				

    				//zaposlenik.setEmail(textField_9.getText());
    				zaposlenik.setTelefon(textField_10.getText());
    				
    				 try{
    					 String mob = String.valueOf(textField_10.getText()).trim();
    			    
    			            long br = Long.parseLong(mob);
    			            if (mob.trim().length()!=9){
    			            JOptionPane.showMessageDialog(null, "Broj telefona mora sadrzavati 9 cifara!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;}
    			        }catch(NumberFormatException e1){
    			            JOptionPane.showMessageDialog(null, "Broj može sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;
    			        }
    				
    				zaposlenik.setMobitel(textField_11.getText());
    				
    				 try{
    					 String mob = String.valueOf(textField_11.getText()).trim();
    			    
    			            long br = Long.parseLong(mob);
    			            if (mob.trim().length()!=9 && mob.trim().length()!=10 ){
    			            JOptionPane.showMessageDialog(null, "Broj mobitela mora sadrzavati 9 ili 10(hallo) cifara!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;}
    			        }catch(NumberFormatException e1){
    			            JOptionPane.showMessageDialog(null, "Broj može sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;
    			        }
    				
    				zaposlenik.setUsername(textField_12.getText());
    				if(DBManager.daLiPostojiUserName(zaposlenik.getUsername()))
    				{
    					JOptionPane.showMessageDialog(null, "Username vec postoji!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				
    				zaposlenik.setPassword(textField_13.getText());
    				zaposlenik.setIsAdministrator(false);
    				
    				boolean oznacenRB = false;
    				if(rb_recepcioner.isSelected())
    				{
    					zaposlenik.setUloga("Recepcioner");
    					oznacenRB=true;
    				}
    				else if(rb_cistacica.isSelected())
    				{
    					zaposlenik.setUloga("Cistacica");
    					oznacenRB=true;
    				}
    				else if(rb_ekonomista.isSelected())
    				{
    					zaposlenik.setUloga("Ekonomista");
    					oznacenRB=true;
    				}
    				else if(rb_kuhar.isSelected())
    				{
    					zaposlenik.setUloga("Kuhar");
    					oznacenRB=true;
    				}
    				else if(rb_manager.isSelected())
    				{
    					zaposlenik.setUloga("Manager");
    					oznacenRB=true;
    				}
    				else if(rb_administrator.isSelected())
    				{
    					zaposlenik.setUloga("Administrator");
    					zaposlenik.setIsAdministrator(true);
    					oznacenRB=true;
    				}
    				/*else
    				{
    					zaposlenik.setUloga("");
    				}*/
    				
    				
    				
    				if(oznacenRB==true){
    					zaposlenik.setOsoba(osoba);
	    				DBManager.spremiZaposlenika(zaposlenik);
	    				
	    				textField_1.setText("");
	    				textField_2.setText("");
	    				textField_4.setText("");
	    				textField_5.setText("");
	    				textField_6.setText("");
	    				textField_7.setText("");
	    				textField_8.setText("");
	    				textField_9.setText("");
	    				textField_10.setText("");
	    				textField_11.setText("");
	    				textField_12.setText("");
	    				textField_13.setText("");
	    				datePicker.getModel().setValue(null);
	    				
	    				JOptionPane.showMessageDialog(null, "Novi zaposlenik evidentiran", "Info", JOptionPane.INFORMATION_MESSAGE);
    				}
    				else if(oznacenRB==false) {
    					JOptionPane.showMessageDialog(null, "Nije označena uloga!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				}
    				
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
        
        list.addListSelectionListener(new ListSelectionListener() {

            
        	public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	try
                	{
                		Zaposlenik zaposlenik = (Zaposlenik)list.getSelectedValue();
                		if(zaposlenik != null)
                		{
                			trenutniUsername = zaposlenik.getUsername();
                			if(zaposlenik.getOsoba() != null)
                			{
                				textField_1.setText(zaposlenik.getOsoba().getIme());
                				textField_2.setText(zaposlenik.getOsoba().getPrezime());
                				//datePicker.getModel().setValue((DateModel)zaposlenik.getOsoba().getDatumRodjenja());
                				textField_5.setText(zaposlenik.getOsoba().getAdresa());
                				
                				datePicker.getModel().setDay(zaposlenik.getOsoba().getDatumRodjenja().getDate());
                				datePicker.getModel().setMonth(zaposlenik.getOsoba().getDatumRodjenja().getMonth());
                				datePicker.getModel().setYear(zaposlenik.getOsoba().getDatumRodjenja().getYear()+1900);
                				datePicker.getJFormattedTextField().setText(zaposlenik.getOsoba().getDatumRodjenja().getDate() + "." + Integer.toString(zaposlenik.getOsoba().getDatumRodjenja().getMonth() + 1) +"." + Integer.toString(zaposlenik.getOsoba().getDatumRodjenja().getYear()+1900)  );
                				//datePicker.getJFormattedTextField().setText(datePicker.getModel().);
                				
                			}
                			else
                			{
                				textField_1.setText("");
                				textField_2.setText("");
                				//datePicker.getModel().setValue((DateModel)zaposlenik.getOsoba().getDatumRodjenja());
                				datePicker.getJFormattedTextField().setText("");
                				textField_5.setText("");
                			}
                			textField_4.setText(zaposlenik.getJMB());
                			textField_6.setText(zaposlenik.getDrzavljanstvo());
                			textField_7.setText(zaposlenik.getTitula());
                			textField_8.setText(zaposlenik.getObrazovanje());
                			textField_9.setText(zaposlenik.getEmail());
                			textField_10.setText(zaposlenik.getTelefon());
                			textField_11.setText(zaposlenik.getMobitel());
                			textField_12.setText(zaposlenik.getUsername());
                			textField_13.setText(zaposlenik.getPassword());
                			if(zaposlenik.getUloga().equals("Recepcioner"))
                			{
                				rb_recepcioner.setSelected(true);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Cistacica") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(true);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Ekonomista") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(true);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Kuhar") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(true);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Manager") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(true);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Administrator") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(true);
                			}
                			else
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                				bg.clearSelection();
                				//dovoljan zadnji reed
                			}
                			
                		}
                	}
                	catch(Exception ex)
                	{
                		System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
                		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
        });
list_1.addListSelectionListener(new ListSelectionListener() {

            
        	public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	try
                	{
                		Zaposlenik zaposlenik = (Zaposlenik)list_1.getSelectedValue();
                		if(zaposlenik != null)
                		{
                			trenutniUsername = zaposlenik.getUsername();
                			if(zaposlenik.getOsoba() != null)
                			{
                				textField_1.setText(zaposlenik.getOsoba().getIme());
                				textField_2.setText(zaposlenik.getOsoba().getPrezime());
                				//datePicker.getModel().setValue((DateModel)zaposlenik.getOsoba().getDatumRodjenja());
                				textField_5.setText(zaposlenik.getOsoba().getAdresa());
                				
                				
                				datePicker.getModel().setDay(zaposlenik.getOsoba().getDatumRodjenja().getDate());
                				datePicker.getModel().setMonth(zaposlenik.getOsoba().getDatumRodjenja().getMonth());
                				datePicker.getModel().setYear(zaposlenik.getOsoba().getDatumRodjenja().getYear()+1900);
                				datePicker.getJFormattedTextField().setText(zaposlenik.getOsoba().getDatumRodjenja().getDate() + "." + Integer.toString(zaposlenik.getOsoba().getDatumRodjenja().getMonth() + 1) +"." + Integer.toString(zaposlenik.getOsoba().getDatumRodjenja().getYear()+1900)  );
                				//datePicker.getJFormattedTextField().setText(datePicker.getModel().getValue().toString());
                			}
                			else
                			{
                				textField_1.setText("");
                				textField_2.setText("");
                				datePicker.getJFormattedTextField().setText("");
                				textField_5.setText("");
                			}
                			textField_4.setText(zaposlenik.getJMB());
                			textField_6.setText(zaposlenik.getDrzavljanstvo());
                			textField_7.setText(zaposlenik.getTitula());
                			textField_8.setText(zaposlenik.getObrazovanje());
                			textField_9.setText(zaposlenik.getEmail());
                			textField_10.setText(zaposlenik.getTelefon());
                			textField_11.setText(zaposlenik.getMobitel());
                			textField_12.setText(zaposlenik.getUsername());
                			textField_13.setText(zaposlenik.getPassword());
                			
                			if(zaposlenik.getUloga().equals("Recepcioner"))
                			{
                				rb_recepcioner.setSelected(true);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Cistacica"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(true);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Ekonomista"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(true);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Kuhar"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(true);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Manager"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(true);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Administrator"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(true);
                			}
                			else
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                				bg.clearSelection();
                			}
                			
                		}
                	}
                	catch(Exception ex)
                	{
                		System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
                		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try
    			{
    				Zaposlenik zaposlenik;
    				if(tabbedPane.getSelectedIndex()==0)
    				
    				 zaposlenik = (Zaposlenik)list.getSelectedValue();
    				else
    				 zaposlenik = (Zaposlenik)list_1.getSelectedValue();
    				
    				if(zaposlenik == null || list.getSelectedValues().length > 1)
    				{
    					JOptionPane.showMessageDialog(null, "Morate odabrati jednog zaposlenika!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				int dialogButton = JOptionPane.YES_NO_OPTION;
        			int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?","Warning",dialogButton);
        			if(dialogResult == JOptionPane.YES_OPTION){
        				DBManager.obrisiZaposlenika(zaposlenik);
        				textField_4.setText("");
            			textField_6.setText("");
            			textField_7.setText("");
            			textField_8.setText("");
            			textField_9.setText("");
            			textField_10.setText("");
            			textField_11.setText("");
            			textField_12.setText("");
            			textField_13.setText("");
            			textField_5.setText("");
            			textField_1.setText("");
            			textField_2.setText("");
            			if(tabbedPane.getSelectedIndex() == 0)
            			{
            				DefaultListModel m = (DefaultListModel)list.getModel();
            				m.removeElementAt(list.getSelectedIndex());
            			}
            			else
            			{
            				DefaultListModel m = (DefaultListModel)list_1.getModel();
            				m.removeElementAt(list_1.getSelectedIndex());
            			}
        				JOptionPane.showMessageDialog(null, "Zaposlenik obrisan!", "Info", JOptionPane.INFORMATION_MESSAGE);
        			}
    					
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
        
        button_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try
    			{
    				Zaposlenik zaposlenik;
    				if(tabbedPane.getSelectedIndex()==0)
    				
    				 zaposlenik = (Zaposlenik)list.getSelectedValue();
    				else
    				 zaposlenik = (Zaposlenik)list_1.getSelectedValue();
    				
    				if(zaposlenik == null)
    				{
    					JOptionPane.showMessageDialog(null, "Greska! Niste odabrali zaposlenika!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				if(datePicker.getModel().getValue() == null)
    				{
    					JOptionPane.showMessageDialog(null, "Morate ponovo odabrati datum rodjenja!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				if(textField_1.getText() == "" || textField_2.getText() == "" ||
    	    				   textField_4.getText() == "" || textField_5.getText() == "" ||
    	    				   textField_6.getText() == "" || textField_7.getText() == "" ||
    	    				   textField_8.getText() == "" || textField_9.getText() == "" ||
    	    				   textField_10.getText() == "" || textField_11.getText() == "" ||
    	    				   textField_12.getText() == "" || textField_13.getText() == "" ||
    	    				   datePicker.getModel().getValue() == null)
    	    				{
    	    					JOptionPane.showMessageDialog(null, "Greska! Niste unijeli sve podatke!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    				if(zaposlenik.getOsoba() == null)
    	    				{
    	    					zaposlenik.setOsoba(new Osoba());
    	    				}
    	    				
    	    				zaposlenik.getOsoba().setImePrezime(textField_1.getText() + " " + textField_2.getText());
    	    				
    	    				if(textField_1.getText().length()<3){
    	    					JOptionPane.showMessageDialog(null, "Ime ne može biti kraće od 3 slova!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    				
    	    				if(textField_2.getText().length()<3){
    	    					JOptionPane.showMessageDialog(null, "Prezime ne može biti kraće od 3 slova!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    				
    	    				zaposlenik.setJMB(textField_4.getText());
    	    				
    	    				/*if(textField_4.getText().length()!=13)
    	    				{
    	    					JOptionPane.showMessageDialog(null, "Niste unijeli validan JMBG!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}*/
    	    				 try{
    	    					 String jmbg = String.valueOf(textField_4.getText()).trim();
    	    			           // String jmbg = String.valueOf(tekst).trim();
    	    			            long br = Long.parseLong(jmbg);
    	    			            if (jmbg.trim().length()!=13){
    	    			                //throw new Exception("JMBG mora sadrzavati 13 cifara!");
    	    			            JOptionPane.showMessageDialog(null, "JMBG mora sadržavati 13 cifara!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;}
    	    			        }catch(NumberFormatException e1){
    	    			           // throw new NumberFormatException("JMBG mora sadrzavati samo cifre!");
    	    			            JOptionPane.showMessageDialog(null, "JMBG mora sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;
    	    			        }
    	    				 
    	    				zaposlenik.getOsoba().setAdresa(textField_5.getText());
    	    				zaposlenik.getOsoba().setDatumRodjenja((java.util.Date) datePicker.getModel().getValue());
    	    				//Date d = new Date(System.currentTimeMillis());
    	    				java.util.Date date = new java.util.Date();
    	    				java.util.Date datumRodjenja = new java.util.Date();
    	    				datumRodjenja=(java.util.Date) datePicker.getModel().getValue();
    	    				if(datumRodjenja.after(date)){
    	    					JOptionPane.showMessageDialog(null, "Datum rodjenja mora biti manji od trenutnog datuma!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    					
    	    				zaposlenik.setDrzavljanstvo(textField_6.getText());
    	    				zaposlenik.setTitula(textField_7.getText());
    	    				zaposlenik.setObrazovanje(textField_8.getText());
    	    				
    	    				
    	    					String email = String.valueOf(textField_9.getText()).trim();
    	    					boolean validmail = true;
    	    					if(!email.contains(".") && !email.contains("@")) validmail=false;
    	    					if(email.indexOf("@") > email.indexOf(".") || email.indexOf("@") ==0) validmail=false;
    	    					if(validmail) zaposlenik.setDrzavljanstvo(email);
    	    					else{ 
    	    						JOptionPane.showMessageDialog(null, "Nevalidan mail!", "Info", JOptionPane.ERROR_MESSAGE); 
    	    						return;
    	    					}
    	    					
    	    				
    	    				

    	    				//zaposlenik.setEmail(textField_9.getText());
    	    				zaposlenik.setTelefon(textField_10.getText());
    	    				
    	    				 try{
    	    					 String mob = String.valueOf(textField_10.getText()).trim();
    	    			    
    	    			            long br = Long.parseLong(mob);
    	    			            if (mob.trim().length()!=9){
    	    			            JOptionPane.showMessageDialog(null, "Broj telefona mora sadrzavati 9 cifara!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;}
    	    			        }catch(NumberFormatException e1){
    	    			            JOptionPane.showMessageDialog(null, "Broj može sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;
    	    			        }
    	    				
    	    				zaposlenik.setMobitel(textField_11.getText());
    	    				
    	    				 try{
    	    					 String mob = String.valueOf(textField_11.getText()).trim();
    	    			    
    	    			            long br = Long.parseLong(mob);
    	    			            if (mob.trim().length()!=9 && mob.trim().length()!=10 ){
    	    			            JOptionPane.showMessageDialog(null, "Broj mobitela mora sadrzavati 9 ili 10(hallo) cifara!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;}
    	    			        }catch(NumberFormatException e1){
    	    			            JOptionPane.showMessageDialog(null, "Broj može sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;
    	    			        }
    	    				
    	    				zaposlenik.setUsername(textField_12.getText());
    	    				if(!zaposlenik.getUsername().equals(trenutniUsername) && DBManager.daLiPostojiUserName(zaposlenik.getUsername()))
    	    				{
    	    					JOptionPane.showMessageDialog(null, "Username vec postoji!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    				
    	    				zaposlenik.setPassword(textField_13.getText());
    	    				zaposlenik.setIsAdministrator(false);
    	    				
    	    				boolean oznacenRB = false;
    	    				if(rb_recepcioner.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Recepcioner");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_cistacica.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Cistacica");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_ekonomista.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Ekonomista");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_kuhar.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Kuhar");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_manager.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Manager");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_administrator.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Administrator");
    	    					zaposlenik.setIsAdministrator(true);
    	    					oznacenRB=true;
    	    				}
    	    				/*else
    	    				{
    	    					zaposlenik.setUloga("");
    	    				}*/
    	    				
    	    				DBManager.urediZaposlenika(zaposlenik);
    	    				
    	    				JOptionPane.showMessageDialog(null, "Izmjene spasene!", "Info", JOptionPane.INFORMATION_MESSAGE);
    					
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
        initComponents();
    }

    
    public OsobljeN(Zaposlenik zap) {
    	this.z = zap;
    	setTitle("Hotel Ksenon Plaza-Osoblje");
    	getContentPane().setBackground(Color.WHITE);
    	setResizable(false);
    	setSize(1124,598);
    	getContentPane().setBounds(0, 0, 917, 642);
    	
    	setAutoRequestFocus(false);
    	getContentPane().setSize(917, 642);
    	getContentPane().setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBackground(SystemColor.inactiveCaptionBorder);
    	panel.setBounds(10, 11, 374, 538);
    	getContentPane().add(panel);
    	panel.setLayout(null);
    	
    	final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    	tabbedPane.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane.setBounds(0, 0, 374, 538);
    	tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
    	panel.add(tabbedPane);
    	
    	JPanel panel_2 = new JPanel();
    	panel_2.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_2.setLayout(null);
    	tabbedPane.addTab("Pretraga osoblja", null, panel_2, null);
    	
    	textField = new JTextField();
    	textField.setColumns(10);
    	textField.setBounds(216, 10, 141, 37);
    	panel_2.add(textField);
    	
    	JLabel label = new JLabel("Unesite ime ili prezime \r\n\u010Dlana osoblja:");
    	label.setBounds(10, -4, 296, 64);
    	panel_2.add(label);
    	
    	JButton button = new JButton("Pretra\u017Ei");
    	button.setBounds(255, 56, 102, 28);
    	panel_2.add(button);
    	
    	JPanel panel_3 = new JPanel();
    	panel_3.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_3.setLayout(null);
    	panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_3.setBounds(10, 87, 347, 410);
    	panel_2.add(panel_3);
    	
    	JLabel label_1 = new JLabel("Rezultati pretrage:");
    	label_1.setBounds(61, 5, 158, 14);
    	panel_3.add(label_1);
    	
    	final JList list = new JList();
    	list.setBounds(10, 32, 327, 367);
    	panel_3.add(list);
    	
    	JPanel panel_4 = new JPanel();
    
    	panel_4.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane.addTab("Lista svih radnika", null, panel_4, null);
    	panel_4.setLayout(null);
    	
    	
    	final JList list_1 = new JList();
    	list_1.setBounds(10, 11, 347, 486);
    	panel_4.add(list_1);
    	 tabbedPane.addChangeListener(new ChangeListener() {
    	        public void stateChanged(ChangeEvent e) {
    	            if(tabbedPane.getSelectedIndex()==1){
    	            	try
    	    			{
    	    				List<Zaposlenik> zaposlenici = DBManager.dajZaposlenike("");
    	    				DefaultListModel model = new DefaultListModel();
    	    				for(Zaposlenik zaposlenik : zaposlenici)
    	    				{
    	    					model.addElement(zaposlenik);
    	    				}
    	    				
    	    				list_1.setModel(model);
    	    				
    	    			}
    	            	
    	    			catch(Exception ex)
    	    			{
    	    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
    	            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    	    			}
    	            }
    	            else
    	            {
    	            	try
    	    			{
    	    				List<Zaposlenik> zaposlenici = DBManager.dajZaposlenike(textField.getText());
    	    				DefaultListModel m = (DefaultListModel)list.getModel();
    	    				m.removeAllElements();
    	    				for(Zaposlenik zaposlenik : zaposlenici)
    	    				{
    	    					m.addElement(zaposlenik);
    	    				}
    	    				
    	    				
    	    			}
    	    			catch(Exception ex)
    	    			{
    	    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
    	            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    	    			}
    	            }
    	        }
    	    });
    	JPanel panel_1 = new JPanel();
    	panel_1.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_1.setBounds(402, 11, 497, 538);
    	getContentPane().add(panel_1);
    	panel_1.setLayout(null);
    	
    	JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
    	tabbedPane_1.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane_1.setBounds(0, 0, 497, 538);
    	tabbedPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
    	panel_1.add(tabbedPane_1);
    	
    	JPanel panel_5 = new JPanel();
    	panel_5.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane_1.addTab("Informacije:", null, panel_5, null);
    	panel_5.setLayout(null);
    	
    	textField_1 = new JTextField();
    	textField_1.setColumns(10);
    	textField_1.setBounds(107, 7, 123, 32);
    	panel_5.add(textField_1);
    	
    	textField_2 = new JTextField();
    	textField_2.setColumns(10);
    	textField_2.setBounds(107, 45, 123, 32);
    	panel_5.add(textField_2);
    	
    	textField_4 = new JTextField();
    	textField_4.setColumns(10);
    	textField_4.setBounds(107, 121, 123, 32);
    	panel_5.add(textField_4);
    	
    	textField_5 = new JTextField();
    	textField_5.setColumns(10);
    	textField_5.setBounds(107, 159, 123, 32);
    	panel_5.add(textField_5);
    	
    	textField_6 = new JTextField();
    	textField_6.setColumns(10);
    	textField_6.setBounds(107, 197, 123, 32);
    	panel_5.add(textField_6);
    	
    	textField_7 = new JTextField();
    	textField_7.setColumns(10);
    	textField_7.setBounds(107, 236, 123, 32);
    	panel_5.add(textField_7);
    	
    	textField_8 = new JTextField();
    	textField_8.setColumns(10);
    	textField_8.setBounds(107, 275, 123, 32);
    	panel_5.add(textField_8);
    	
    	textField_9 = new JTextField();
    	textField_9.setColumns(10);
    	textField_9.setBounds(107, 312, 123, 32);
    	panel_5.add(textField_9);
    	
    	textField_10 = new JTextField();
    	textField_10.setColumns(10);
    	textField_10.setBounds(359, 7, 123, 32);
    	panel_5.add(textField_10);
    	
    	textField_11 = new JTextField();
    	textField_11.setColumns(10);
    	textField_11.setBounds(359, 45, 123, 32);
    	panel_5.add(textField_11);
    	
    	textField_12 = new JTextField();
    	textField_12.setColumns(10);
    	textField_12.setBounds(359, 83, 123, 32);
    	panel_5.add(textField_12);
    	
    	textField_13 = new JTextField();
    	textField_13.setColumns(10);
    	textField_13.setBounds(359, 121, 123, 32);
    	panel_5.add(textField_13);
    	
    	JLabel label_2 = new JLabel("Ime:");
    	label_2.setBounds(10, -2, 210, 50);
    	panel_5.add(label_2);
    	
    	JLabel label_3 = new JLabel("Prezime:");
    	label_3.setBounds(10, 37, 210, 50);
    	panel_5.add(label_3);
    	
    	JLabel label_4 = new JLabel("JMBG:");
    	label_4.setBounds(10, 112, 200, 50);
    	panel_5.add(label_4);
    	
    	JLabel label_5 = new JLabel("Datum ro\u0111enja:");
    	label_5.setBounds(10, 74, 200, 50);
    	panel_5.add(label_5);
    	
    	JLabel label_6 = new JLabel("Adresa:");
    	label_6.setBounds(10, 150, 200, 50);
    	panel_5.add(label_6);
    	
    	JLabel label_7 = new JLabel("Dr\u017Eavljanstvo:");
    	label_7.setBounds(10, 188, 200, 50);
    	panel_5.add(label_7);
    	
    	JLabel label_8 = new JLabel("Titula:");
    	label_8.setBounds(10, 227, 200, 50);
    	panel_5.add(label_8);
    	
    	JLabel label_9 = new JLabel("Obrazovanje:");
    	label_9.setBounds(10, 266, 200, 50);
    	panel_5.add(label_9);
    	
    	JLabel label_10 = new JLabel("Email:");
    	label_10.setBounds(10, 305, 200, 50);
    	panel_5.add(label_10);
    	
    	JLabel label_11 = new JLabel("Telefon:");
    	label_11.setBounds(247, -2, 200, 50);
    	panel_5.add(label_11);
    	
    	JLabel label_12 = new JLabel("Mobitel:");
    	label_12.setBounds(247, 37, 200, 50);
    	panel_5.add(label_12);
    	
    	JLabel label_13 = new JLabel("Korisni\u010Dko ime:");
    	label_13.setBounds(247, 77, 200, 50);
    	panel_5.add(label_13);
    	
    	JLabel label_14 = new JLabel("Korisni\u010Dka lozinka:");
    	label_14.setBounds(247, 115, 200, 50);
    	panel_5.add(label_14);
    	
    	JPanel panel_6 = new JPanel();
    	panel_6.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_6.setLayout(null);
    	panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_6.setBounds(247, 184, 123, 160);
    	panel_5.add(panel_6);
    	
    	final JRadioButton rb_recepcioner = new JRadioButton("Recepcioner");
    	rb_recepcioner.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_recepcioner.setBounds(6, 7, 109, 23);
    	panel_6.add(rb_recepcioner);
    	
    	final JRadioButton rb_cistacica = new JRadioButton("\u010Cista\u010Dica");
    	rb_cistacica.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_cistacica.setBounds(6, 30, 109, 23);
    	panel_6.add(rb_cistacica);
    	
    	final JRadioButton rb_ekonomista = new JRadioButton("Ekonomista");
    	rb_ekonomista.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_ekonomista.setBounds(6, 82, 109, 23);
    	panel_6.add(rb_ekonomista);
    	
    	final JRadioButton rb_kuhar = new JRadioButton("Kuhar");
    	rb_kuhar.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_kuhar.setBounds(6, 56, 109, 23);
    	panel_6.add(rb_kuhar);
    	
    	final JRadioButton rb_manager = new JRadioButton("Manager");
    	rb_manager.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_manager.setBounds(6, 108, 109, 23);
    	panel_6.add(rb_manager);
    	
    	final JRadioButton rb_administrator = new JRadioButton("Administrator");
    	rb_administrator.setBackground(SystemColor.inactiveCaptionBorder);
    	rb_administrator.setBounds(6, 130, 109, 23);
    	panel_6.add(rb_administrator);
    	
    	final ButtonGroup bg = new ButtonGroup();
    	bg.add(rb_administrator);
    	bg.add(rb_manager);
    	bg.add(rb_kuhar);
    	bg.add(rb_ekonomista);
    	bg.add(rb_cistacica);
    	bg.add(rb_recepcioner);
    	
    	JLabel label_15 = new JLabel("Uloge:");
    	label_15.setBounds(247, 150, 200, 50);
    	panel_5.add(label_15);
    	
    	JPanel panel_7 = new JPanel();
    	panel_7.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_7.setLayout(null);
    	panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_7.setBounds(10, 366, 220, 131);
    	panel_5.add(panel_7);
    	
    	JButton button_1 = new JButton("Uredi osobu");
    	button_1.setBounds(10, 10, 200, 33);
    	panel_7.add(button_1);
    	
    	JButton button_2 = new JButton("Izbri\u0161i osobu");
    	button_2.setBounds(10, 49, 200, 33);
    	panel_7.add(button_2);
    	
    	JButton button_3 = new JButton("Dodaj novu osobu");
    	button_3.setBounds(10, 88, 200, 33);
    	panel_7.add(button_3);
    	
    	JButton btnNewButton = new JButton("Po\u010Detna stranica");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			new EkranZaAdministratora(z).setVisible(true);
    			setVisible(false);
    		}
    	});
    	btnNewButton.setBounds(909, 499, 200, 50);
    	getContentPane().add(btnNewButton);
    	
    	JPanel panel_8 = new JPanel();
    	panel_8.setBackground(Color.WHITE);
    	panel_8.setBounds(909, 280, 200, 201);
    	getContentPane().add(panel_8);
    	ImageIcon guy = new ImageIcon("C:\\Users\\X\\Desktop\\hotel.png");
 		JLabel pn = new JLabel(guy);
 		panel_8.add(pn);
 		
 		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBackground(SystemColor.inactiveCaptionBorder);
        datePicker.setLocation(110, 85);
        datePicker.setSize(120, 26);
        panel_5.add(datePicker);
        button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try
    			{
    				List<Zaposlenik> zaposlenici = DBManager.dajZaposlenike(textField.getText());
    				DefaultListModel model = new DefaultListModel();
    				for(Zaposlenik zaposlenik : zaposlenici)
    				{
    					model.addElement(zaposlenik);
    				}
    				
    				list.setModel(model);
    				
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
        
        button_3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try
    			{
    				if(textField_1.getText() == "" || textField_2.getText() == "" ||
    				   textField_4.getText() == "" || textField_5.getText() == "" ||
    				   textField_6.getText() == "" || textField_7.getText() == "" ||
    				   textField_8.getText() == "" || textField_9.getText() == "" ||
    				   textField_10.getText() == "" || textField_11.getText() == "" ||
    				   textField_12.getText().length() == 0 || textField_13.getText().length() == 0 ||
    				   datePicker.getModel().getValue() == null)
    				{
    					JOptionPane.showMessageDialog(null, "Greska! Niste unijeli sve podatke!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				else{
    				Osoba osoba = new Osoba();
    				Zaposlenik zaposlenik = new Zaposlenik();
    				osoba.setImePrezime(textField_1.getText() + " " + textField_2.getText());
    				
    				if(textField_1.getText().length()<3){
    					JOptionPane.showMessageDialog(null, "Ime ne može biti kraće od 3 slova!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				
    				if(textField_2.getText().length()<3){
    					JOptionPane.showMessageDialog(null, "Prezime ne može biti kraće od 3 slova!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				
    				zaposlenik.setJMB(textField_4.getText());
    				
    				/*if(textField_4.getText().length()!=13)
    				{
    					JOptionPane.showMessageDialog(null, "Niste unijeli validan JMBG!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}*/
    				 try{
    					 String jmbg = String.valueOf(textField_4.getText()).trim();
    			           // String jmbg = String.valueOf(tekst).trim();
    			            long br = Long.parseLong(jmbg);
    			            if (jmbg.trim().length()!=13){
    			                //throw new Exception("JMBG mora sadrzavati 13 cifara!");
    			            JOptionPane.showMessageDialog(null, "JMBG mora sadržavati 13 cifara!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;}
    			        }catch(NumberFormatException e1){
    			           // throw new NumberFormatException("JMBG mora sadrzavati samo cifre!");
    			            JOptionPane.showMessageDialog(null, "JMBG mora sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;
    			        }
    				 
    				osoba.setAdresa(textField_5.getText());
    				osoba.setDatumRodjenja((java.util.Date) datePicker.getModel().getValue());
    				zaposlenik.setDrzavljanstvo(textField_6.getText());
    				zaposlenik.setTitula(textField_7.getText());
    				zaposlenik.setObrazovanje(textField_8.getText());
    				zaposlenik.setEmail(textField_9.getText());
    				zaposlenik.setTelefon(textField_10.getText());
    				
    				 try{
    					 String mob = String.valueOf(textField_10.getText()).trim();
    			    
    			            long br = Long.parseLong(mob);
    			            if (mob.trim().length()!=9){
    			            JOptionPane.showMessageDialog(null, "Broj telefona mora sadrzavati 9 cifara!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;}
    			        }catch(NumberFormatException e1){
    			            JOptionPane.showMessageDialog(null, "Broj može sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;
    			        }
    				
    				zaposlenik.setMobitel(textField_11.getText());
    				
    				 try{
    					 String mob = String.valueOf(textField_11.getText()).trim();
    			    
    			            long br = Long.parseLong(mob);
    			            if (mob.trim().length()!=9 && mob.trim().length()!=10 ){
    			            JOptionPane.showMessageDialog(null, "Broj mobitela mora sadrzavati 9 ili 10(hallo) cifara!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;}
    			        }catch(NumberFormatException e1){
    			            JOptionPane.showMessageDialog(null, "Broj može sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
        					return;
    			        }
    				
    				zaposlenik.setUsername(textField_12.getText());
    				
    				if(DBManager.daLiPostojiUserName(zaposlenik.getUsername()))
    				{
    					JOptionPane.showMessageDialog(null, "Username vec postoji!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				
    				zaposlenik.setPassword(textField_13.getText());
    				zaposlenik.setIsAdministrator(false);
    				if(rb_recepcioner.isSelected())
    				{
    					zaposlenik.setUloga("Recepcioner");
    				}
    				else if(rb_cistacica.isSelected())
    				{
    					zaposlenik.setUloga("Cistacica");
    				}
    				else if(rb_ekonomista.isSelected())
    				{
    					zaposlenik.setUloga("Ekonomista");
    				}
    				else if(rb_kuhar.isSelected())
    				{
    					zaposlenik.setUloga("Kuhar");
    				}
    				else if(rb_manager.isSelected())
    				{
    					zaposlenik.setUloga("Manager");
    				}
    				else if(rb_administrator.isSelected())
    				{
    					zaposlenik.setUloga("Administrator");
    					zaposlenik.setIsAdministrator(true);
    				}
    				else
    				{
    					zaposlenik.setUloga("");
    				}
    				
    				
    				zaposlenik.setOsoba(osoba);
    				DBManager.spremiZaposlenika(zaposlenik);
    				
    				textField_1.setText("");
    				textField_2.setText("");
    				textField_4.setText("");
    				textField_5.setText("");
    				textField_6.setText("");
    				textField_7.setText("");
    				textField_8.setText("");
    				textField_9.setText("");
    				textField_10.setText("");
    				textField_11.setText("");
    				textField_12.setText("");
    				textField_13.setText("");
    				datePicker.getModel().setValue(null);
    				JOptionPane.showMessageDialog(null, "Novi zaposlenik evidentiran", "Info", JOptionPane.INFORMATION_MESSAGE);
    				}
    				
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
        
        list.addListSelectionListener(new ListSelectionListener() {

            
        	public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	try
                	{
                		Zaposlenik zaposlenik = (Zaposlenik)list.getSelectedValue();
                		if(zaposlenik != null)
                		{
                			trenutniUsername = zaposlenik.getUsername();
                			if(zaposlenik.getOsoba() != null)
                			{
                				textField_1.setText(zaposlenik.getOsoba().getIme());
                				textField_2.setText(zaposlenik.getOsoba().getPrezime());
                				//datePicker.getModel().setValue((DateModel)zaposlenik.getOsoba().getDatumRodjenja());
                				textField_5.setText(zaposlenik.getOsoba().getAdresa());
                				
                				datePicker.getModel().setDay(zaposlenik.getOsoba().getDatumRodjenja().getDate());
                				datePicker.getModel().setMonth(zaposlenik.getOsoba().getDatumRodjenja().getMonth());
                				datePicker.getModel().setYear(zaposlenik.getOsoba().getDatumRodjenja().getYear()+1900);
                				datePicker.getJFormattedTextField().setText(zaposlenik.getOsoba().getDatumRodjenja().getDate() + "." + Integer.toString(zaposlenik.getOsoba().getDatumRodjenja().getMonth() + 1) +"." + Integer.toString(zaposlenik.getOsoba().getDatumRodjenja().getYear()+1900)  );
                				//datePicker.getJFormattedTextField().setText(datePicker.getModel().);
                				
                			}
                			else
                			{
                				textField_1.setText("");
                				textField_2.setText("");
                				//datePicker.getModel().setValue((DateModel)zaposlenik.getOsoba().getDatumRodjenja());
                				datePicker.getJFormattedTextField().setText("");
                				textField_5.setText("");
                			}
                			textField_4.setText(zaposlenik.getJMB());
                			textField_6.setText(zaposlenik.getDrzavljanstvo());
                			textField_7.setText(zaposlenik.getTitula());
                			textField_8.setText(zaposlenik.getObrazovanje());
                			textField_9.setText(zaposlenik.getEmail());
                			textField_10.setText(zaposlenik.getTelefon());
                			textField_11.setText(zaposlenik.getMobitel());
                			textField_12.setText(zaposlenik.getUsername());
                			textField_13.setText(zaposlenik.getPassword());
                			if(zaposlenik.getUloga().equals("Recepcioner"))
                			{
                				rb_recepcioner.setSelected(true);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Cistacica") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(true);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Ekonomista") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(true);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Kuhar") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(true);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Manager") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(true);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Administrator") )
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(true);
                			}
                			else
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                				bg.clearSelection();
                				//dovoljan zadnji reed
                			}
                			
                		}
                	}
                	catch(Exception ex)
                	{
                		System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
                		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
        });
list_1.addListSelectionListener(new ListSelectionListener() {

            
        	public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	try
                	{
                		Zaposlenik zaposlenik = (Zaposlenik)list_1.getSelectedValue();
                		if(zaposlenik != null)
                		{
                			trenutniUsername = zaposlenik.getUsername();
                			if(zaposlenik.getOsoba() != null)
                			{
                				textField_1.setText(zaposlenik.getOsoba().getIme());
                				textField_2.setText(zaposlenik.getOsoba().getPrezime());
                				//datePicker.getModel().setValue((DateModel)zaposlenik.getOsoba().getDatumRodjenja());
                				textField_5.setText(zaposlenik.getOsoba().getAdresa());
                				
                				
                				datePicker.getModel().setDay(zaposlenik.getOsoba().getDatumRodjenja().getDate());
                				datePicker.getModel().setMonth(zaposlenik.getOsoba().getDatumRodjenja().getMonth());
                				datePicker.getModel().setYear(zaposlenik.getOsoba().getDatumRodjenja().getYear()+1900);
                				datePicker.getJFormattedTextField().setText(zaposlenik.getOsoba().getDatumRodjenja().getDate() + "." + Integer.toString(zaposlenik.getOsoba().getDatumRodjenja().getMonth() + 1) +"." + Integer.toString(zaposlenik.getOsoba().getDatumRodjenja().getYear()+1900)  );
                				//datePicker.getJFormattedTextField().setText(datePicker.getModel().getValue().toString());
                			}
                			else
                			{
                				textField_1.setText("");
                				textField_2.setText("");
                				datePicker.getJFormattedTextField().setText("");
                				textField_5.setText("");
                			}
                			textField_4.setText(zaposlenik.getJMB());
                			textField_6.setText(zaposlenik.getDrzavljanstvo());
                			textField_7.setText(zaposlenik.getTitula());
                			textField_8.setText(zaposlenik.getObrazovanje());
                			textField_9.setText(zaposlenik.getEmail());
                			textField_10.setText(zaposlenik.getTelefon());
                			textField_11.setText(zaposlenik.getMobitel());
                			textField_12.setText(zaposlenik.getUsername());
                			textField_13.setText(zaposlenik.getPassword());
                			
                			if(zaposlenik.getUloga().equals("Recepcioner"))
                			{
                				rb_recepcioner.setSelected(true);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Cistacica"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(true);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Ekonomista"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(true);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Kuhar"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(true);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Manager"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(true);
                				rb_administrator.setSelected(false);
                			}
                			else if(zaposlenik.getUloga().equals("Administrator"))
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(true);
                			}
                			else
                			{
                				rb_recepcioner.setSelected(false);
                				rb_cistacica.setSelected(false);
                				rb_ekonomista.setSelected(false);
                				rb_kuhar.setSelected(false);
                				rb_manager.setSelected(false);
                				rb_administrator.setSelected(false);
                				bg.clearSelection();
                			}
                			
                		}
                	}
                	catch(Exception ex)
                	{
                		System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
                		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try
    			{
    				Zaposlenik zaposlenik;
    				if(tabbedPane.getSelectedIndex()==0)
    				
    				 zaposlenik = (Zaposlenik)list.getSelectedValue();
    				else
    				 zaposlenik = (Zaposlenik)list_1.getSelectedValue();
    				
    				if(zaposlenik == null || list.getSelectedValues().length > 1)
    				{
    					JOptionPane.showMessageDialog(null, "Morate odabrati jednog zaposlenika!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				int dialogButton = JOptionPane.YES_NO_OPTION;
        			int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?","Warning",dialogButton);
        			if(dialogResult == JOptionPane.YES_OPTION){
        				DBManager.obrisiZaposlenika(zaposlenik);
        				textField_4.setText("");
            			textField_6.setText("");
            			textField_7.setText("");
            			textField_8.setText("");
            			textField_9.setText("");
            			textField_10.setText("");
            			textField_11.setText("");
            			textField_12.setText("");
            			textField_13.setText("");
            			textField_5.setText("");
            			textField_1.setText("");
            			textField_2.setText("");
            			if(tabbedPane.getSelectedIndex() == 0)
            			{
            				DefaultListModel m = (DefaultListModel)list.getModel();
            				m.removeElementAt(list.getSelectedIndex());
            			}
            			else
            			{
            				DefaultListModel m = (DefaultListModel)list_1.getModel();
            				m.removeElementAt(list_1.getSelectedIndex());
            			}
        				JOptionPane.showMessageDialog(null, "Zaposlenik obrisan!", "Info", JOptionPane.INFORMATION_MESSAGE);
        			}
    					
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
        
        button_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try
    			{
    				Zaposlenik zaposlenik;
    				if(tabbedPane.getSelectedIndex()==0)
    				
    				 zaposlenik = (Zaposlenik)list.getSelectedValue();
    				else
    				 zaposlenik = (Zaposlenik)list_1.getSelectedValue();
    				
    				if(zaposlenik == null)
    				{
    					JOptionPane.showMessageDialog(null, "Greska! Niste odabrali zaposlenika!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				if(datePicker.getModel().getValue() == null)
    				{
    					JOptionPane.showMessageDialog(null, "Morate ponovo odabrati datum rodjenja!", "Info", JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				if(textField_1.getText() == "" || textField_2.getText() == "" ||
    	    				   textField_4.getText() == "" || textField_5.getText() == "" ||
    	    				   textField_6.getText() == "" || textField_7.getText() == "" ||
    	    				   textField_8.getText() == "" || textField_9.getText() == "" ||
    	    				   textField_10.getText() == "" || textField_11.getText() == "" ||
    	    				   textField_12.getText() == "" || textField_13.getText() == "" ||
    	    				   datePicker.getModel().getValue() == null)
    	    				{
    	    					JOptionPane.showMessageDialog(null, "Greska! Niste unijeli sve podatke!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    				if(zaposlenik.getOsoba() == null)
    	    				{
    	    					zaposlenik.setOsoba(new Osoba());
    	    				}
    	    				
zaposlenik.getOsoba().setImePrezime(textField_1.getText() + " " + textField_2.getText());
    	    				
    	    				if(textField_1.getText().length()<3){
    	    					JOptionPane.showMessageDialog(null, "Ime ne može biti kraće od 3 slova!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    				
    	    				if(textField_2.getText().length()<3){
    	    					JOptionPane.showMessageDialog(null, "Prezime ne može biti kraće od 3 slova!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    				
    	    				zaposlenik.setJMB(textField_4.getText());
    	    				
    	    				/*if(textField_4.getText().length()!=13)
    	    				{
    	    					JOptionPane.showMessageDialog(null, "Niste unijeli validan JMBG!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}*/
    	    				 try{
    	    					 String jmbg = String.valueOf(textField_4.getText()).trim();
    	    			           // String jmbg = String.valueOf(tekst).trim();
    	    			            long br = Long.parseLong(jmbg);
    	    			            if (jmbg.trim().length()!=13){
    	    			                //throw new Exception("JMBG mora sadrzavati 13 cifara!");
    	    			            JOptionPane.showMessageDialog(null, "JMBG mora sadržavati 13 cifara!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;}
    	    			        }catch(NumberFormatException e1){
    	    			           // throw new NumberFormatException("JMBG mora sadrzavati samo cifre!");
    	    			            JOptionPane.showMessageDialog(null, "JMBG mora sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;
    	    			        }
    	    				 
    	    				zaposlenik.getOsoba().setAdresa(textField_5.getText());
    	    				zaposlenik.getOsoba().setDatumRodjenja((java.util.Date) datePicker.getModel().getValue());
    	    				//Date d = new Date(System.currentTimeMillis());
    	    				java.util.Date date = new java.util.Date();
    	    				java.util.Date datumRodjenja = new java.util.Date();
    	    				datumRodjenja=(java.util.Date) datePicker.getModel().getValue();
    	    				if(datumRodjenja.after(date)){
    	    					JOptionPane.showMessageDialog(null, "Datum rodjenja mora biti manji od trenutnog datuma!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    					
    	    				zaposlenik.setDrzavljanstvo(textField_6.getText());
    	    				zaposlenik.setTitula(textField_7.getText());
    	    				zaposlenik.setObrazovanje(textField_8.getText());
    	    				
    	    				
    	    					String email = String.valueOf(textField_9.getText()).trim();
    	    					boolean validmail = true;
    	    					if(!email.contains(".") && !email.contains("@")) validmail=false;
    	    					if(email.indexOf("@") > email.indexOf(".") || email.indexOf("@") ==0) validmail=false;
    	    					if(validmail) zaposlenik.setDrzavljanstvo(email);
    	    					else{ 
    	    						JOptionPane.showMessageDialog(null, "Nevalidan mail!", "Info", JOptionPane.ERROR_MESSAGE); 
    	    						return;
    	    					}
    	    					
    	    				
    	    				

    	    				//zaposlenik.setEmail(textField_9.getText());
    	    				zaposlenik.setTelefon(textField_10.getText());
    	    				
    	    				 try{
    	    					 String mob = String.valueOf(textField_10.getText()).trim();
    	    			    
    	    			            long br = Long.parseLong(mob);
    	    			            if (mob.trim().length()!=9){
    	    			            JOptionPane.showMessageDialog(null, "Broj telefona mora sadrzavati 9 cifara!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;}
    	    			        }catch(NumberFormatException e1){
    	    			            JOptionPane.showMessageDialog(null, "Broj može sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;
    	    			        }
    	    				
    	    				zaposlenik.setMobitel(textField_11.getText());
    	    				
    	    				 try{
    	    					 String mob = String.valueOf(textField_11.getText()).trim();
    	    			    
    	    			            long br = Long.parseLong(mob);
    	    			            if (mob.trim().length()!=9 && mob.trim().length()!=10 ){
    	    			            JOptionPane.showMessageDialog(null, "Broj mobitela mora sadrzavati 9 ili 10(hallo) cifara!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;}
    	    			        }catch(NumberFormatException e1){
    	    			            JOptionPane.showMessageDialog(null, "Broj može sadržavati samo cifre!", "Info", JOptionPane.ERROR_MESSAGE);
    	        					return;
    	    			        }
    	    				
    	    				zaposlenik.setUsername(textField_12.getText());
    	    				if(!zaposlenik.getUsername().equals(trenutniUsername) && DBManager.daLiPostojiUserName(zaposlenik.getUsername()))
    	    				{
    	    					JOptionPane.showMessageDialog(null, "Username vec postoji!", "Info", JOptionPane.ERROR_MESSAGE);
    	    					return;
    	    				}
    	    				
    	    				zaposlenik.setPassword(textField_13.getText());
    	    				zaposlenik.setIsAdministrator(false);
    	    				
    	    				boolean oznacenRB = false;
    	    				if(rb_recepcioner.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Recepcioner");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_cistacica.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Cistacica");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_ekonomista.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Ekonomista");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_kuhar.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Kuhar");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_manager.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Manager");
    	    					oznacenRB=true;
    	    				}
    	    				else if(rb_administrator.isSelected())
    	    				{
    	    					zaposlenik.setUloga("Administrator");
    	    					zaposlenik.setIsAdministrator(true);
    	    					oznacenRB=true;
    	    				}
    	    				/*else
    	    				{
    	    					zaposlenik.setUloga("");
    	    				}*/
    	    				
    	    				DBManager.urediZaposlenika(zaposlenik);
    	    				
    	    				JOptionPane.showMessageDialog(null, "Izmjene spasene!", "Info", JOptionPane.INFORMATION_MESSAGE);
    					
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Greska pri radu sa bazom: "+ex.getMessage());
            		JOptionPane.showMessageDialog(null, "Greška pri radu s bazom!", "Info", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	});
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OsobljeN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OsobljeN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OsobljeN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OsobljeN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OsobljeN().setVisible(true);
            }
        });
    }
}
