package etf.si.tim8.app.Hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Klase.Boravak;
import Klase.Soba;

import java.awt.event.ActionEvent;

public class EkranZaEditovanjeSobe {
//neki koemntar
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
					EkranZaEditovanjeSobe window = new EkranZaEditovanjeSobe();
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
	public EkranZaEditovanjeSobe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 253, 301);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 225, 243);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSoba = new JLabel("Soba:");
		lblSoba.setBackground(SystemColor.inactiveCaptionBorder);
		lblSoba.setBounds(21, 11, 74, 29);
		panel.add(lblSoba);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 44, 204, 174);
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
		cb1.setBounds(10, 112, 102, 18);
		panel_1.add(cb1);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(79, 11, 115, 20);
		panel_1.add(spinner);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(79, 39, 115, 20);
		panel_1.add(spinner_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jednokrevetna", "Dvokrevetna"}));
		comboBox.setBounds(79, 64, 115, 20);
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(79, 89, 115, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnEditujSobu = new JButton("Spasi promjene");
		btnEditujSobu.setBounds(78, 140, 116, 23);
		panel_1.add(btnEditujSobu);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(59, 15, 155, 20);
		panel.add(comboBox_1);
		//comboBox_1.addItem("tajma");
		//final Scanner sc = new Scanner(System.in); 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		final Query query = session.createQuery("from Soba");
		List<Soba> sobe=new ArrayList<Soba>();
		try{
            sobe = (ArrayList<Soba>)query.list();
			for (Soba o : sobe) {
				
				comboBox_1.addItem(Integer.toString(o.getBrojSobe()));
				
			}
			
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Došlo je do greške u bazi!", "Greska", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		t.commit();
		session.close();
		
		comboBox_1.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				final Query query = session.createQuery("from Soba");
				List<Soba> sobe=new ArrayList<Soba>();
				sobe = (ArrayList<Soba>)query.list();
				
				int brojSobe=Integer.parseInt(comboBox_1.getSelectedItem().toString());//uzememo selektovani broj sobe
				
				 Soba s=new Soba();
					for (Soba o : sobe) {
						//JOptionPane.showMessageDialog(null, "Sve je OK!"+Integer.toString(o.getBrojSobe()), "OK", JOptionPane.INFORMATION_MESSAGE);

						if(o.getBrojSobe()==brojSobe)//postavimo parametre
						{
							//JOptionPane.showMessageDialog(null, "Sve je OK!"+Integer.toString(brojSobe), "OK", JOptionPane.INFORMATION_MESSAGE);

							s=o;
							spinner.setValue(s.getSprat());
							spinner_1.setValue(s.getBrojSobe());
							if(s.getBrojKreveta()==1)
								comboBox.setSelectedIndex(0);
							else
								comboBox.setSelectedIndex(1);
							textField.setText(Double.toString(s.getCijena()));
							if(s.getBalkon())cb1.setSelected(true);
							
							break;
							
					}

					
					}//od for petlje
					t.commit();
					session.close();
		    }
		});
		//spasavanje promjena klikom na dugme
		btnEditujSobu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				final Query query = session.createQuery("from Soba where brojsobe="+comboBox_1.getSelectedItem().toString());
			    //query.setParameter("tag", comboBox_1.getSelectedItem().toString());
				List<Soba> sobe=new ArrayList<Soba>();
				sobe = (ArrayList<Soba>)query.list();
				Soba s=sobe.get(0);
				s.setBalkon(cb1.isSelected());
				
				if(comboBox.getSelectedIndex()==0)
					s.setBrojKreveta(1);
				else
					s.setBrojKreveta(2);
				s.setSprat(Integer.parseInt(spinner.getValue().toString()));
				s.setBrojSobe(Integer.parseInt(spinner_1.getValue().toString()));
				s.setCijena(Double.parseDouble(textField.getText()));
				
				session.update(s);
				t.commit();
				session.close();
				JOptionPane.showMessageDialog(null, "sve ok ", "OK", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
