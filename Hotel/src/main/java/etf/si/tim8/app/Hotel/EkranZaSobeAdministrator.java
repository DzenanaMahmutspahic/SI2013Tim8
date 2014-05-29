package etf.si.tim8.app.Hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Klase.Soba;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class EkranZaSobeAdministrator extends JFrame {

	private JPanel contentPane;
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
	private JTextField textField_18;
	private JTextField textField_19;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EkranZaSobeAdministrator frame = new EkranZaSobeAdministrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EkranZaSobeAdministrator() {
		setResizable(false);
		setTitle("Sobe");
		setBounds(100, 100, 784, 547);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(34, 54, 401, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel();
		label.setText("Status");
		label.setBounds(80, 11, 64, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setText("Soba 1");
		label_1.setBounds(10, 33, 300, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setText("Soba 2");
		label_2.setBounds(10, 68, 300, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setText("Soba 3");
		label_3.setBounds(10, 103, 300, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel();
		label_4.setText("Soba 4");
		label_4.setBounds(10, 138, 300, 14);
		panel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		//textField_2.setBackground(Color.RED);
		textField_2.setBounds(70, 136, 74, 17);
		textField_2.setEnabled(false);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		//textField_3.setBackground(Color.RED);
		textField_3.setBounds(70, 101, 74, 17);
		textField_3.setEnabled(false);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		//textField_4.setBackground(Color.RED);
		textField_4.setBounds(70, 66, 74, 17);
		textField_4.setEnabled(false);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		//textField_5.setBackground(Color.RED);
		textField_5.setEnabled(false);
		textField_5.setBounds(70, 31, 74, 17);
		panel.add(textField_5);
		
		JLabel label_5 = new JLabel();
		label_5.setText("Soba 5");
		label_5.setBounds(259, 33, 51, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel();
		label_6.setText("Soba 6");
		label_6.setBounds(259, 68, 51, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel();
		label_7.setText("Soba 7");
		label_7.setBounds(259, 103, 51, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel();
		label_8.setText("Soba 8");
		label_8.setBounds(259, 138, 51, 14);
		panel.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		//textField_6.setBackground(Color.GREEN);
		textField_6.setBounds(310, 136, 74, 17);
		textField_6.setEnabled(false);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		//textField_7.setBackground(Color.GREEN);
		textField_7.setEnabled(false);
		textField_7.setBounds(310, 101, 74, 17);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		//textField_8.setBackground(Color.GREEN);
		textField_8.setEnabled(false);
		textField_8.setBounds(310, 66, 74, 17);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		//textField_9.setBackground(Color.GREEN);
		textField_9.setEnabled(false);
		textField_9.setBounds(310, 31, 74, 17);
		panel.add(textField_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(462, 54, 268, 184);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton prikaziSlobodneSobe = new JButton("Prika\u017Ei slobodne sobe");
		
		prikaziSlobodneSobe.setBounds(21, 117, 218, 23);
		panel_1.add(prikaziSlobodneSobe);
		
		JLabel label_9 = new JLabel();
		label_9.setText("Pregled dostupnosti jednokrevetnih soba:");
		label_9.setBounds(34, 22, 200, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel();
		label_10.setText("Pregled dostupnosti jednokrevetnih soba:");
		label_10.setBounds(34, 261, 200, 14);
		contentPane.add(label_10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(34, 293, 401, 190);
		contentPane.add(panel_2);
		
		JLabel label_11 = new JLabel();
		label_11.setText("Status");
		label_11.setBounds(80, 11, 64, 14);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel();
		label_12.setText("Soba 1");
		label_12.setBounds(10, 33, 300, 14);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel();
		label_13.setText("Soba 2");
		label_13.setBounds(10, 68, 300, 14);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel();
		label_14.setText("Soba 3");
		label_14.setBounds(10, 103, 300, 14);
		panel_2.add(label_14);
		
		JLabel label_15 = new JLabel();
		label_15.setText("Soba 4");
		label_15.setBounds(10, 138, 300, 14);
		panel_2.add(label_15);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		//textField_10.setBackground(Color.RED);
		textField_10.setBounds(70, 136, 74, 17);
		textField_10.setEnabled(false);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		//textField_11.setBackground(Color.RED);
		textField_11.setBounds(70, 101, 74, 17);
		textField_11.setEnabled(false);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		//textField_12.setBackground(Color.RED);
		textField_12.setBounds(70, 66, 74, 17);
		textField_12.setEnabled(false);
		panel_2.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		//textField_13.setBackground(Color.RED);
		textField_13.setEnabled(false);
		textField_13.setBounds(70, 31, 74, 17);
		panel_2.add(textField_13);
		
		JLabel label_16 = new JLabel();
		label_16.setText("Soba 5");
		label_16.setBounds(259, 33, 51, 14);
		panel_2.add(label_16);
		
		JLabel label_17 = new JLabel();
		label_17.setText("Soba 6");
		label_17.setBounds(259, 68, 51, 14);
		panel_2.add(label_17);
		
		JLabel label_18 = new JLabel();
		label_18.setText("Soba 7");
		label_18.setBounds(259, 103, 51, 14);
		panel_2.add(label_18);
		
		JLabel label_19 = new JLabel();
		label_19.setText("Soba 8");
		label_19.setBounds(259, 138, 51, 14);
		panel_2.add(label_19);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		//textField_14.setBackground(Color.GREEN);
		textField_14.setEnabled(false);
		textField_14.setBounds(310, 136, 74, 17);
		panel_2.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		//textField_15.setBackground(Color.GREEN);
		textField_15.setEnabled(false);
		textField_15.setBounds(310, 101, 74, 17);
		panel_2.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		//textField_16.setBackground(Color.GREEN);
		textField_16.setEnabled(false);
		textField_16.setBounds(310, 66, 74, 17);
		panel_2.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		//textField_17.setBackground(Color.GREEN);
		textField_17.setEnabled(false);
		textField_17.setBounds(310, 31, 74, 17);
		panel_2.add(textField_17);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBackground(SystemColor.inactiveCaptionBorder);
		panel_3.setBounds(462, 293, 268, 107);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_20 = new JLabel();
		label_20.setText("Slobodne sobe:");
		label_20.setBounds(45, 31, 100, 14);
		panel_3.add(label_20);
		
		JLabel label_21 = new JLabel();
		label_21.setText("Zauzete sobe:");
		label_21.setBounds(50, 66, 95, 14);
		panel_3.add(label_21);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBackground(Color.RED);
		textField_18.setBounds(135, 64, 74, 17);
		panel_3.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBackground(Color.GREEN);
		textField_19.setBounds(134, 29, 74, 17);
		panel_3.add(textField_19);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(462, 423, 123, 27);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton = new JButton("Ure\u0111ivanje soba");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EkranZaEditovanjeSobe().setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 0, 123, 27);
		panel_5.add(btnNewButton);
		
		JButton btnGalerija = new JButton("Galerija");
		btnGalerija.setBounds(607, 423, 123, 27);
		contentPane.add(btnGalerija);
		
		JButton btnDodavanjeSoba = new JButton("Dodavanje soba");
		btnDodavanjeSoba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EkranZaDodavanjeSobe().setVisible(true);
			}
		});
		btnDodavanjeSoba.setBounds(462, 456, 123, 27);
		contentPane.add(btnDodavanjeSoba);
		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBackground(SystemColor.inactiveCaptionBorder);
        datePicker.setLocation(130, 30);
        datePicker.setSize(120, 26);
        panel_1.add(datePicker);


        UtilDateModel model2 = new UtilDateModel();
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
        final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
        datePicker2.setBackground(SystemColor.inactiveCaptionBorder);
        datePicker2.setLocation(130, 70);
        datePicker2.setSize(120, 26);
        panel_1.add(datePicker2);
        
        JLabel lblDatumDolaska = new JLabel("Datum dolaska:");
        lblDatumDolaska.setBounds(33, 42, 87, 14);
        panel_1.add(lblDatumDolaska);
        
        JLabel label_22 = new JLabel("Datum dolaska:");
        label_22.setBounds(33, 82, 87, 14);
        panel_1.add(label_22);
		
		JButton btnPoetna = new JButton("Po\u010Detna");
		btnPoetna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage();
			}
		});
		btnPoetna.setBounds(607, 456, 123, 27);
		contentPane.add(btnPoetna);
		prikaziSlobodneSobe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
}
