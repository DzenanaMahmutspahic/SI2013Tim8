package etf.si.tim8.app.Hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Klase.Soba;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EkranZaDodavanjeSobe {
//tajma komentar
	
	private JFrame frame;
	private JTextField textField;

	public void setVisible(boolean t){frame.setVisible(t);}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EkranZaDodavanjeSobe window = new EkranZaDodavanjeSobe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EkranZaDodavanjeSobe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 469, 372);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 443, 325);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSoba = new JLabel("Soba:");
		lblSoba.setBackground(SystemColor.inactiveCaptionBorder);
		lblSoba.setBounds(24, 11, 74, 29);
		panel.add(lblSoba);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 44, 423, 270);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSprat = new JLabel("Sprat:");
		lblSprat.setBounds(10, 11, 66, 14);
		panel_1.add(lblSprat);
		
		JLabel lblBrojSobe = new JLabel("Broj sobe:");
		lblBrojSobe.setBounds(10, 36, 66, 14);
		panel_1.add(lblBrojSobe);
		
		JLabel lblTipSobe = new JLabel("Tip sobe:");
		lblTipSobe.setBounds(10, 61, 66, 14);
		panel_1.add(lblTipSobe);
		
		JLabel lblCijena = new JLabel("Cijena:\r\n");
		lblCijena.setBounds(10, 86, 66, 14);
		panel_1.add(lblCijena);
		
		final JCheckBox cb1 = new JCheckBox("Balkon");
		cb1.setBackground(Color.WHITE);
		cb1.setBounds(10, 129, 102, 18);
		panel_1.add(cb1);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(65, 8, 86, 20);
		panel_1.add(spinner);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(65, 36, 86, 20);
		panel_1.add(spinner_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jednokrevetna", "Dvokrevetna"}));
		comboBox.setBounds(65, 61, 86, 20);
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(65, 86, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblInventarUSobi = new JLabel("Inventar u sobi");
		lblInventarUSobi.setBounds(188, 11, 119, 14);
		panel_1.add(lblInventarUSobi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(188, 36, 208, 189);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnTelevizor = new JRadioButton("Televizor");
		rdbtnTelevizor.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnTelevizor.setBounds(6, 7, 109, 23);
		panel_2.add(rdbtnTelevizor);
		
		JRadioButton rdbtnInternet = new JRadioButton("Internet");
		rdbtnInternet.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnInternet.setBounds(6, 33, 109, 23);
		panel_2.add(rdbtnInternet);
		
		JRadioButton rdbtnTelefon = new JRadioButton("Telefon");
		rdbtnTelefon.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnTelefon.setBounds(6, 59, 109, 23);
		panel_2.add(rdbtnTelefon);
		
		JRadioButton rdbtnBraniKrevet = new JRadioButton("Bračni krevet");
		rdbtnBraniKrevet.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnBraniKrevet.setBounds(6, 85, 109, 23);
		panel_2.add(rdbtnBraniKrevet);
		
		JRadioButton rdbtnKreveti = new JRadioButton("Odvojeni kreveti");
		rdbtnKreveti.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnKreveti.setBounds(6, 111, 109, 23);
		panel_2.add(rdbtnKreveti);
		
		JRadioButton rdbtnMiniBar = new JRadioButton("Mini bar");
		rdbtnMiniBar.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnMiniBar.setBounds(6, 137, 109, 23);
		panel_2.add(rdbtnMiniBar);
		
		JRadioButton rdbtnTrezor = new JRadioButton("Trezor");
		rdbtnTrezor.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnTrezor.setBounds(6, 163, 109, 23);
		panel_2.add(rdbtnTrezor);
		
		JButton btnDodajSobu = new JButton("Dodaj sobu");
		
	
		btnDodajSobu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//private long id;
				//private int brojSobe;
				//private int sprat;
				//private Boolean balkon;
				//private int brojKreveta;
				//private double cijena;
				//private Boolean zauzeta;
				Soba soba = new Soba();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				soba.setBrojSobe(Integer.parseInt(spinner_1.getValue().toString()));
				soba.setSprat(Integer.parseInt(spinner.getValue().toString()));
				if(cb1.isSelected())soba.setBalkon(true);
				else soba.setBalkon(false);
				if(comboBox.getSelectedIndex()==0)
					soba.setBrojKreveta(1);
				else
					soba.setBrojKreveta(2);
				try{
					soba.setCijena(Double.parseDouble(textField.getText()));
					}
				catch(Exception e){
						JOptionPane.showMessageDialog(null, "Morate unijeti broj!", "Greska", JOptionPane.INFORMATION_MESSAGE);
					} 
					
				soba.setZauzeta(false);
				session.save(soba);
				t.commit();
			}
		});
		
		btnDodajSobu.setBounds(294, 236, 102, 23);
		panel_1.add(btnDodajSobu);
		
	}

}
