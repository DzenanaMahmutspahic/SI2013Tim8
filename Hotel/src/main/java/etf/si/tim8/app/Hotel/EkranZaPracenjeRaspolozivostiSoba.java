/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etf.si.tim8.app.Hotel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import antlr.collections.List;

import com.mysql.fabric.xmlrpc.base.Array;
import java.util.*;
import java.sql.*;
import java.awt.*;
import Hibernate.DBManager;

/**
 *
 * @author adnan , tajma
 */
public class EkranZaPracenjeRaspolozivostiSoba extends javax.swing.JFrame {

    /**
     * Creates new form EkranZaPracenjeRaspolozivostiSoba
     */
    public EkranZaPracenjeRaspolozivostiSoba() {
    	setResizable(false);
    	getContentPane().setBackground(Color.WHITE);
    	setTitle("Sobe");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel4.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new HomePage().setVisible(true);
        	}
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Soba 1");

        jLabel3.setText("Soba 2");

        jLabel4.setText("Soba 3");

        jLabel5.setText("Soba 4");

        jLabel6.setText("Status");

        jLabel7.setText("Status");

        jLabel8.setText("Soba 5");

        jLabel9.setText("Soba 6");

        jLabel10.setText("Soba 7");

        jLabel11.setText("Soba 8");
        
        textField = new JTextField();
       // textField.setBackground(Color.RED);
        textField.setColumns(10);
        textField.setEditable(false);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
       // textField_1.setBackground(Color.RED);
        textField_1.setEditable(false);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        //textField_2.setBackground(Color.RED);
        textField_2.setEditable(false);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        //textField_3.setBackground(Color.RED);
        textField_3.setEditable(false);
        
        textField_13 = new JTextField();
        textField_13.setColumns(10);
       // textField_13.setBackground(Color.GREEN);
        textField_13.setEditable(false);
        
        textField_14 = new JTextField();
        textField_14.setColumns(10);
        //textField_14.setBackground(Color.GREEN);
        textField_14.setEditable(false);
        
        textField_15 = new JTextField();
        textField_15.setColumns(10);
       // textField_15.setBackground(Color.GREEN);
        textField_15.setEditable(false);
        
        textField_16 = new JTextField();
        textField_16.setColumns(10);
      //  textField_16.setBackground(Color.GREEN);
        textField_16.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3)
        				.addComponent(jLabel4))
        			.addGap(27)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel11)
        					.addGap(18)
        					.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel8)
        					.addGap(18)
        					.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel9)
        					.addGap(18)
        					.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel10)
        					.addGap(18)
        					.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
        			.addGap(12))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(80)
        			.addComponent(jLabel6)
        			.addPreferredGap(ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
        			.addComponent(jLabel7)
        			.addGap(27))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(jLabel7))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel3)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel4)
        						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel5)
        						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel8)
        						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel9)
        						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel10)
        						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel11)
        						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setText("Pregled dostupnosti jednokrevetnih soba:");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Soba 1");

        jLabel13.setText("Soba 2");

        jLabel14.setText("Soba 3");

        jLabel15.setText("Soba 4");

        jLabel16.setText("Status");

        jLabel17.setText("Status");

        jLabel18.setText("Soba 5");

        jLabel19.setText("Soba 6");

        jLabel20.setText("Soba 7");

        jLabel21.setText("Soba 8");
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        //textField_4.setBackground(Color.RED);
        textField_4.setEditable(false);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
       // textField_5.setBackground(Color.RED);
        textField_5.setEditable(false);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
      //  textField_6.setBackground(Color.RED);
        textField_6.setEditable(false);
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
      //  textField_7.setBackground(Color.RED);
        textField_7.setEditable(false);
        
        textField_8 = new JTextField();
        textField_8.setColumns(10);
        //textField_8.setBackground(Color.GREEN);
        textField_8.setEditable(false);
        
        textField_9 = new JTextField();
        textField_9.setColumns(10);
        //textField_9.setBackground(Color.GREEN);
        textField_9.setEditable(false);
        
        textField_10 = new JTextField();
        textField_10.setColumns(10);
       // textField_10.setBackground(Color.GREEN);
        textField_10.setEditable(false);
        
        textField_11 = new JTextField();
        textField_11.setColumns(10);
      //  textField_11.setBackground(Color.GREEN);
        textField_11.setEditable(false);
        
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBackground(SystemColor.inactiveCaptionBorder);
        datePicker.setLocation(140, 30);
        datePicker.setSize(120, 26);
        jPanel4.add(datePicker);


        UtilDateModel model2 = new UtilDateModel();
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
        final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
        datePicker2.setBackground(SystemColor.inactiveCaptionBorder);
        datePicker2.setLocation(140, 70);
        datePicker2.setSize(120, 26);
        jPanel4.add(datePicker2);
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel15)
        				.addComponent(jLabel12)
        				.addComponent(jLabel13)
        				.addComponent(jLabel14))
        			.addGap(26)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(jLabel21)
        					.addGap(18)
        					.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(jLabel18)
        					.addGap(18)
        					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(jLabel19)
        					.addGap(18)
        					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(jLabel20)
        					.addGap(18)
        					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGap(80)
        			.addComponent(jLabel16)
        			.addPreferredGap(ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
        			.addComponent(jLabel17)
        			.addGap(27))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel16)
        				.addComponent(jLabel17))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel12)
        						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel13)
        						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel14)
        						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel15)
        						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel3Layout.createSequentialGroup()
        							.addComponent(jLabel18)
        							.addGap(18)
        							.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel19)
        								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel20)
        						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel21)
        						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        jLabel22.setText("Pregled dvokrevetnih soba:");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        JButton btnPrikaziSlobodneSobe = new JButton("Prika\u017Ei slobodne sobe");
        btnPrikaziSlobodneSobe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		/*Class.forName("com.mysql.jdbc.Driver");
        		Connection c = DriverManager.getConnection(url, "dzenana", "dzenana");*/
        		try {
        		/*Statement st = c.createStatement();
        		//String datumOD=datePicker.getModel().getValue().toString();
        		//String datumDO=datePicker2.getModel().getValue().toString();
        		//komenatar
*/
        		java.util.Date datumOD = (java.util.Date) datePicker.getModel().getValue();
        		java.util.Date datumDO = (java.util.Date) datePicker2.getModel().getValue();
        	
        	//	java.util.List tempListaSoba = new java.util.ArrayList();
        		
	        		/*for(int i=1; i<=16;i++){
	        			
	        			
	        			ResultSet rs = st.executeQuery ("select * from rezervacija where SOBA="+i+"");
	        			
	        			rs.next();
	        			
	        			java.util.Date rezervisanoOD=rs.getDate(3);
	        			java.util.Date rezervisanoDO=rs.getDate(4);
	        			Integer soba=rs.getInt(2);
	        			
	        			
	        			if(datumDO.before(rezervisanoOD) || datumOD.after(rezervisanoDO) || (datumOD.after(rezervisanoDO) && datumDO.before(rezervisanoOD)))	        			        			
	        			{
	        				
	        				tempListaSoba.add(soba);
	        		
	        				
	        			}
	
	        		}*/
        		java.util.List tempListaSoba =DBManager.dajZauzeteSobe(datumOD, datumDO);
        		
	        		
	        			if(tempListaSoba.contains(1))
	        			{
	        				textField.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField.setBackground(Color.GREEN);        				
	        			}
	        			if(tempListaSoba.contains(2))
	        			{
	        				textField_1.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_1.setBackground(Color.GREEN);        				
	        			}
	        			if(tempListaSoba.contains(3))
	        			{
	        				textField_2.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_2.setBackground(Color.GREEN);        				
	        			}
	        			if(tempListaSoba.contains(4))
	        			{
	        				textField_3.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_3.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(13))
	        			{
	        				textField_4.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_4.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(14))
	        			{
	        				textField_5.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_5.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(15))
	        			{
	        				textField_6.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_6.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(16))
	        			{
	        				textField_7.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_7.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(9))
	        			{
	        				textField_8.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_8.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(10))
	        			{
	        				textField_9.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_9.setBackground(Color.GREEN);        				
	        			}
	        			if(tempListaSoba.contains(11))
	        			{
	        				textField_10.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_10.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(12))
	        			{
	        				textField_11.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_11.setBackground(Color.GREEN);        				
	        			}
	        			if(tempListaSoba.contains(5))
	        			{
	        				textField_13.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_13.setBackground(Color.GREEN);        				
	        			}
	        			if(tempListaSoba.contains(6))
	        			{
	        				textField_14.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_14.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(7))
	        			{
	        				textField_15.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_15.setBackground(Color.GREEN);        				
	        			}
	        			
	        			if(tempListaSoba.contains(8))
	        			{
	        				textField_16.setBackground(Color.RED);
	        			}
	        			else
	        			{
	        				textField_16.setBackground(Color.GREEN);        				
	        			}
        		
        		
        		//if(datumOD>rezervisanoDO) || datumDO<rezervisanoOD || (datumOD>rezervisanoDO && datumDO<rezervisanoOD) )
        		} catch (Exception ex1) 
        		{
        			System.out.println("Greska pri radu sa bazom 1: "+ex1.getMessage());
            		JOptionPane.showMessageDialog(null, "MOrate unijeti datum za prikaz soba!", "Info", JOptionPane.INFORMATION_MESSAGE);

        		} 
        		
        			} catch (Exception ex2) {
        			System.out.println("Greska pri radu sa bazom 2: "+ex2.getMessage());
        			}
        		
        		//JOptionPane.showMessageDialog(null, "Nije implementiran prikaz slobodnih soba u zavisnosti od rezervacija!", "Info", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        
        JLabel lblDatumDolaska = new JLabel("Datum dolaska:\r\n");
        
        JLabel lblDatumOdlaska = new JLabel("Datum odlaska:\r\n");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4Layout.setHorizontalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup()
        			.addGap(35)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnPrikaziSlobodneSobe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        				.addGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING)
        					.addComponent(lblDatumDolaska, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblDatumOdlaska, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addGap(32)
        			.addComponent(lblDatumDolaska)
        			.addGap(27)
        			.addComponent(lblDatumOdlaska)
        			.addGap(29)
        			.addComponent(btnPrikaziSlobodneSobe)
        			.addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4.setLayout(jPanel4Layout);

        jLabel23.setText("Odaberite vremenski period:");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setText("Slobodne sobe:");

        jLabel26.setText("Zauzete sobe:");
        
        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBackground(Color.GREEN);
        
        textField_17 = new JTextField();
        textField_17.setColumns(10);
        textField_17.setBackground(Color.RED);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(56)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel25)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel26)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(19)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel25)
        					.addGap(18)
        					.addComponent(jLabel26)))
        			.addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jLabel24.setText("Oznake:");

        jButton1.setText("Po\u010Detna");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel1))
        					.addGap(18))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel22, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        					.addGap(188)))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jLabel23)
        					.addComponent(jLabel24)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        			.addGap(57))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel23)
        				.addComponent(jLabel1))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel22)
        				.addComponent(jLabel24))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(45)
        					.addComponent(jButton1)))
        			.addGap(16))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EkranZaPracenjeRaspolozivostiSoba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EkranZaPracenjeRaspolozivostiSoba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EkranZaPracenjeRaspolozivostiSoba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EkranZaPracenjeRaspolozivostiSoba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EkranZaPracenjeRaspolozivostiSoba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
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
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
}
