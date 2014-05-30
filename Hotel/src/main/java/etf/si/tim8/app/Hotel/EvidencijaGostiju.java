package etf.si.tim8.app.Hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Klase.Boravak;
import Klase.Gost;
import Klase.Osoba;
import Klase.Soba;
import Klase.StraniGost;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvidencijaGostiju extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_12;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvidencijaGostiju frame = new EvidencijaGostiju();
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
	public EvidencijaGostiju() {
		setResizable(false);
		setTitle("Hotel Ksenon Plaza-Evidencija gostiju");
		setBounds(100, 100, 903, 631);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (tabbedPane.getSelectedIndex() == 2) {

					Session session = HibernateUtil.getSessionFactory()
							.openSession();
					Transaction t = session.beginTransaction();
					Query query = session
							.createQuery("from Boravak boravak join boravak.gost as gost join boravak.rezervacija as rezervacija");

					List<Object[]> objekti = (List<Object[]>) query.list();
					List<Boravak> boravci = new ArrayList<Boravak>();
					int trenutni = 0;
					int prosli = 0;
					for (Object[] o : objekti) {
						for (Object o2 : o) {
							if (o2.getClass().equals(Boravak.class)) {
								boravci.add((Boravak) o2);

							}
						}

					}

					int brojtrenutnih = 0, brojstarih = 0;
					Date today = new Date();
					for (Boravak b : boravci) {
						if (today.after(b.getVrijemeDolaska())
								&& today.before(b.getVrijemeOdlaska()))
							brojtrenutnih++;
						if (today.before(b.getVrijemeOdlaska()))
							brojstarih++;
					}

					textField_27.setText(Integer.toString(brojtrenutnih));
					textField_25.setText(Integer.toString(brojstarih));

					// t.commit();

					Query query2 = session.createQuery("from Soba");

					List<Object[]> objekti2 = (List<Object[]>) query2.list();
					List<Soba> sobe = new ArrayList<Soba>();
					for (Object[] o : objekti2) {
						for (Object o2 : o) {
							// if (o2.getClass().equals(Soba.class)) {
							// sobe.add((Soba) o2);

							// }
							//Probaj ovako Kopicu-tajma
							//Query query = session.createQuery("from Soba");
							//try{
							//	List<Soba> sobe = (ArrayList<Soba>)query.list();
							//	for (Soba o : sobe) {
									
							//		comboBox_1.addItem(Integer.toString(o.getBrojSobe()));
							
							//	}
								
							//}
							
							//catch(Exception e)
							//{
								
							//}
						}

					}
					t.commit();

					textField_26.setText(Integer.toString(sobe.size()));

					session.close();

				}

			}
		});
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 11, 654, 566);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Unos gosta", null, panel, null);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(171, 49, 149, 26);
		panel.add(textField);

		JLabel label = new JLabel();
		label.setText("Ime:");
		label.setBounds(20, 54, 68, 17);
		panel.add(label);

		JLabel label_1 = new JLabel();
		label_1.setText("Prezime:");
		label_1.setBounds(20, 91, 87, 17);
		panel.add(label_1);

		JLabel lblAdresa = new JLabel();
		lblAdresa.setText("Adresa:");
		lblAdresa.setBounds(20, 129, 94, 14);
		panel.add(lblAdresa);

		JLabel lblDatumRoenja = new JLabel();
		lblDatumRoenja.setText("Datum ro\u0111enja:");
		lblDatumRoenja.setBounds(20, 166, 116, 14);
		panel.add(lblDatumRoenja);

		JLabel lblMjestoRoenja = new JLabel();
		lblMjestoRoenja.setText("Mjesto ro\u0111enja:");
		lblMjestoRoenja.setBounds(20, 203, 137, 14);
		panel.add(lblMjestoRoenja);

		JLabel label_5 = new JLabel();
		label_5.setText("Status:");
		label_5.setBounds(20, 21, 68, 14);
		panel.add(label_5);

		// JButton btnUnesiGosta = new JButton("Unesi gosta");

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Domaci", "Strani"}));
		comboBox.setBounds(171, 11, 149, 30);
		comboBox.addItem("Doma�i");
		comboBox.addItem("Strani");

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 1) {
					textField_5.setEditable(true);
					textField_6.setEditable(true);
					textField_7.setEditable(true);
					textField_8.setEditable(true);
					textField_9.setEditable(true);
					// textField_10.setEditable(true);
					// textField_11.setEditable(true);
				} else {
					textField_5.setEditable(false);
					textField_6.setEditable(false);
					textField_7.setEditable(false);
					textField_8.setEditable(false);
					textField_9.setEditable(false);
					// textField_10.setEditable(false);
					// textField_11.setEditable(false);
				}
			}
		});
		panel.add(comboBox);

		JLabel lblDravljanstvo = new JLabel("Dr\u017Eavljanstvo:");
		lblDravljanstvo.setBounds(20, 240, 106, 14);
		panel.add(lblDravljanstvo);

		JLabel lblVrstaPutneIsprave = new JLabel("Vrsta putne isprave:");
		lblVrstaPutneIsprave.setBounds(20, 278, 133, 14);
		panel.add(lblVrstaPutneIsprave);

		JLabel lblBrojPutneIsprave = new JLabel("Broj putne isprave:");
		lblBrojPutneIsprave.setBounds(20, 318, 106, 14);
		panel.add(lblBrojPutneIsprave);

		JLabel lblVrstaVize = new JLabel("Vrsta vize:");
		lblVrstaVize.setBounds(20, 355, 106, 14);
		panel.add(lblVrstaVize);

		JLabel lblBrojVize = new JLabel("Broj vize:");
		lblBrojVize.setBounds(20, 392, 106, 14);
		panel.add(lblBrojVize);

		JLabel lblDatumDozvoleBoravka = new JLabel("Datum dozvole boravka: ");
		lblDatumDozvoleBoravka.setBounds(20, 429, 192, 14);
		panel.add(lblDatumDozvoleBoravka);

		JLabel lblDatumUlaskaU = new JLabel("Datum ulaska u BIH:");
		lblDatumUlaskaU.setBounds(20, 466, 141, 14);
		panel.add(lblDatumUlaskaU);

		JButton btnUnesiGosta = new JButton("Unesi gosta");

		btnUnesiGosta.setBounds(457, 460, 153, 25);
		panel.add(btnUnesiGosta);

		textField_1 = new JTextField();
		textField_1.setBounds(171, 86, 149, 26);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(171, 123, 149, 26);
		panel.add(textField_2);

		textField_4 = new JTextField();
		textField_4.setBounds(171, 197, 149, 26);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBounds(171, 234, 149, 26);
		panel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBounds(171, 272, 149, 26);
		panel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBounds(171, 312, 149, 26);
		panel.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setBounds(171, 349, 149, 26);
		panel.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setBounds(171, 386, 149, 26);
		panel.add(textField_9);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Azuriranje gostiju", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel label_2 = new JLabel();
		label_2.setText("Unesi ime ili prezime gosta:");
		label_2.setBounds(10, 11, 200, 14);
		panel_1.add(label_2);

		textField_12 = new JTextField();
		textField_12.setBounds(10, 26, 200, 20);
		panel_1.add(textField_12);

		JButton button = new JButton();
		button.setText("Pretrazi");
		button.setBounds(225, 25, 99, 23);
		panel_1.add(button);

		final JList listG = new JList();
		listG.setBounds(10, 87, 314, 313);
		panel_1.add(listG);

		JLabel lblListaGostiju = new JLabel("Lista gostiju:");
		lblListaGostiju.setBounds(10, 62, 106, 14);
		panel_1.add(lblListaGostiju);

		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				Transaction t = session.beginTransaction();
				if (listG.getSelectedValue() instanceof Klase.Gost) {
					Klase.Gost g = (Klase.Gost) listG.getSelectedValue();
					Query query2 = session
							.createQuery("from StraniGost stranigost join stranigost.gost as gost join gost.osoba as osoba");

					List<Object[]> objekti2 = (List<Object[]>) query2.list();
					List<StraniGost> stranigosti = new ArrayList<StraniGost>();

					for (Object[] o : objekti2) {
						for (Object o2 : o) {
							if (o2.getClass().equals(StraniGost.class)) {
								stranigosti.add((StraniGost) o2);
						}

					}		}
					//
				//	t.commit();
				//	session.close();
					for (StraniGost sg : stranigosti) {
						if (sg.getGost().getId() == g.getId()) {
							
						session.delete(sg);
						
						}

					}
					
					
					// String hql = "DELETE FROM osoba " +
					// "WHERE ID = :osobaid";
					// Query query = session.createQuery(hql);
					// query.setParameter("osobaid", g.getOsoba().getId());

				//	session.delete(g.getOsoba());
					Osoba o=g.getOsoba();
					
			//		session.delete(g);
			//		session.delete(o);
					t.commit();
					
					

				}
				


				session.close();

			}
		});
		btnIzbrisi.setBounds(385, 503, 116, 23);
		panel_1.add(btnIzbrisi);

		

		textField_13 = new JTextField();
		textField_13.setBounds(484, 203, 149, 26);
		panel_1.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setBounds(484, 240, 149, 26);
		panel_1.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setBounds(484, 278, 149, 26);
		panel_1.add(textField_15);

		JLabel label_3 = new JLabel("Datum ulaska u BIH:");
		label_3.setBounds(333, 472, 141, 14);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Datum dozvole boravka: ");
		label_4.setBounds(333, 435, 192, 14);
		panel_1.add(label_4);

		JLabel label_6 = new JLabel("Broj vize:");
		label_6.setBounds(333, 398, 106, 14);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Vrsta vize:");
		label_7.setBounds(333, 361, 106, 14);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("Broj putne isprave:");
		label_8.setBounds(333, 324, 106, 14);
		panel_1.add(label_8);

		JLabel label_9 = new JLabel("Vrsta putne isprave:");
		label_9.setBounds(333, 284, 133, 14);
		panel_1.add(label_9);

		JLabel label_10 = new JLabel("Dr\u017Eavljanstvo:");
		label_10.setBounds(333, 246, 106, 14);
		panel_1.add(label_10);

		JLabel label_11 = new JLabel();
		label_11.setText("Mjesto ro\u0111enja:");
		label_11.setBounds(333, 209, 137, 14);
		panel_1.add(label_11);

		JLabel label_12 = new JLabel();
		label_12.setText("Datum ro\u0111enja:");
		label_12.setBounds(333, 172, 116, 14);
		panel_1.add(label_12);

		JLabel label_13 = new JLabel();
		label_13.setText("Adresa:");
		label_13.setBounds(333, 135, 94, 14);
		panel_1.add(label_13);

		JLabel label_14 = new JLabel();
		label_14.setText("Prezime:");
		label_14.setBounds(333, 97, 87, 17);
		panel_1.add(label_14);

		JLabel label_15 = new JLabel();
		label_15.setText("Ime:");
		label_15.setBounds(333, 60, 68, 17);
		panel_1.add(label_15);

		JLabel label_16 = new JLabel();
		label_16.setText("Status:");
		label_16.setBounds(333, 27, 68, 14);
		panel_1.add(label_16);

	    final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {				
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Domaci",
				"Strani" }));
		comboBox_1.setBounds(484, 17, 149, 30);
		panel_1.add(comboBox_1);

		textField_16 = new JTextField();
		textField_16.setBounds(484, 55, 149, 26);
		panel_1.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setBounds(484, 92, 149, 26);
		panel_1.add(textField_17);

		textField_18 = new JTextField();
		textField_18.setBounds(484, 129, 149, 26);
		panel_1.add(textField_18);

		textField_20 = new JTextField();
		textField_20.setBounds(484, 318, 149, 26);
		panel_1.add(textField_20);

		textField_21 = new JTextField();
		textField_21.setBounds(484, 355, 149, 26);
		panel_1.add(textField_21);

		textField_22 = new JTextField();
		textField_22.setBounds(484, 392, 149, 26);
		panel_1.add(textField_22);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Hotelske informacije", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel label_17 = new JLabel();
		label_17.setText("Hotelske informacije:");
		label_17.setBounds(44, 45, 204, 14);
		panel_2.add(label_17);

		JLabel label_18 = new JLabel();
		label_18.setText("Broj trenutnih gostiju u hotelu:");
		label_18.setBounds(46, 90, 202, 14);
		panel_2.add(label_18);

		JLabel label_19 = new JLabel();
		label_19.setText("Broj trenutno slobodnih soba u hotelu:");
		label_19.setBounds(46, 128, 216, 14);
		panel_2.add(label_19);

		JLabel label_20 = new JLabel();
		label_20.setText("Ukupan broj gostiju koji su bili u hotelu:");
		label_20.setBounds(46, 166, 216, 14);
		panel_2.add(label_20);

		textField_25 = new JTextField();
		textField_25.setBounds(291, 163, 69, 20);
		textField_25.setEnabled(false);
		panel_2.add(textField_25);

		textField_26 = new JTextField();
		textField_26.setBounds(291, 125, 69, 20);
		textField_26.setEnabled(false);
		panel_2.add(textField_26);

		textField_27 = new JTextField();
		textField_27.setBounds(291, 87, 69, 20);
		textField_27.setEnabled(false);
		panel_2.add(textField_27);

		JButton btnPoetnaStranica = new JButton("Po\u010Detna stranica");
		btnPoetnaStranica.setBounds(674, 527, 200, 50);
		contentPane.add(btnPoetnaStranica);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(674, 325, 200, 40);
		contentPane.add(panel_3);

		ImageIcon guy = new ImageIcon("C:\\Users\\X\\Desktop\\hotel.png");
		JLabel pn = new JLabel(guy);
		panel_3.add(pn);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker.setLocation(170, 160);
		datePicker.setSize(150, 26);
		panel.add(datePicker);

		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
		final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker2.setLocation(170, 420);
		datePicker2.setSize(150, 26);
		panel.add(datePicker2);

		UtilDateModel model3 = new UtilDateModel();
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3);
		final JDatePickerImpl datePicker3 = new JDatePickerImpl(datePanel3);
		datePicker3.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker3.setLocation(170, 460);
		datePicker3.setSize(150, 26);
		panel.add(datePicker3);

		// azuriranje gosta
		UtilDateModel model4 = new UtilDateModel();
		JDatePanelImpl datePanel4 = new JDatePanelImpl(model4);
		final JDatePickerImpl datePicker4 = new JDatePickerImpl(datePanel4);
		datePicker4.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker4.setLocation(485, 170);
		datePicker4.setSize(150, 26);
		panel_1.add(datePicker4);

		UtilDateModel model5 = new UtilDateModel();
		JDatePanelImpl datePanel5 = new JDatePanelImpl(model5);
		final JDatePickerImpl datePicker5 = new JDatePickerImpl(datePanel5);
		datePicker5.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker5.setLocation(485, 430);
		datePicker5.setSize(150, 26);
		panel_1.add(datePicker5);

		UtilDateModel model6 = new UtilDateModel();
		JDatePanelImpl datePanel6 = new JDatePanelImpl(model6);
		final JDatePickerImpl datePicker6 = new JDatePickerImpl(datePanel6);
		datePicker6.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker6.setLocation(485, 470);
		datePicker6.setSize(150, 26);
		panel_1.add(datePicker6);

	
		listG.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent ev) {
				// if (listG.getSelectedValue() instanceof Klase.Gost) {
				Klase.Gost g = (Klase.Gost) listG.getSelectedValue();
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				Transaction t = session.beginTransaction();
				Query query2 = session
						.createQuery("from StraniGost stranigost join stranigost.gost as gost join gost.osoba as osoba");

				List<Object[]> objekti2 = (List<Object[]>) query2.list();
				List<StraniGost> stranigosti = new ArrayList<StraniGost>();

				for (Object[] o : objekti2) {
					for (Object o2 : o) {
						if (o2.getClass().equals(StraniGost.class)) {
							stranigosti.add((StraniGost) o2);
						}
					}

				}
				t.commit();
				session.close();

				textField_16.setText(g.getOsoba().getImePrezime());
				textField_17.setText(g.getOsoba().getImePrezime());
				textField_18.setText(g.getOsoba().getAdresa());
				textField_13.setText(g.getMjestoRodjenja());
				// datePicker4.getJFormattedTextField().setText(g.getDatumRodjenja());

				StraniGost sg = null;
				for (StraniGost pom : stranigosti) {
					if (pom.getGost().getId() == g.getId())
						sg = pom;

				}
				if (sg != null) {
					// textField_17.setText(sg.getGost().getOsoba().getDatumRodjenja());

					textField_16.setText(sg.getGost().getMjestoRodjenja());
					textField_20.setText(sg.getBrojPutneIsprave());
					textField_22.setText(sg.getBrojVize());
					textField_21.setText(sg.getVrstaVize());
					textField_14.setText(sg.getDrzavljanstvo());
					textField_15.setText(sg.getVrstaPutneIsprave());
					// textField_16.setText(sg.getDatumDozvoleBoravka());
					// textField_16.setText(sg.getDatumUlaskaUBih());

				}

			}

		});

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				Transaction t = session.beginTransaction();

				Query query = session
						.createQuery("from Gost gost join gost.osoba as osoba");

				List<Object[]> objekti = (List<Object[]>) query.list();
				List<Gost> gosti = new ArrayList<Gost>();

				for (Object[] o : objekti) {
					for (Object o2 : o) {
						if (o2.getClass().equals(Gost.class)) {
							gosti.add((Gost) o2);
						}
					}

				}

				listG.setModel(new DefaultListModel());
				for (Gost g : gosti) {
					String imeprezime = g.getIme() + " " + g.getPrezime();
					if (imeprezime.contains(textField_12.getText())) {

						((DefaultListModel) listG.getModel()).addElement(g);
					}

				}
				t.commit();

				session.close();
			}

		});
		btnUnesiGosta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				Transaction t = session.beginTransaction();

				Osoba o = new Osoba();
				o.setAdresa(textField_2.getText());
				// o.setDatumRodjenja((Date) datePicker.getJFormattedTextField()
				// .getValue());
				o.setImePrezime(textField.getText() + " "
						+ textField_1.getText());

				Klase.Gost g = new Klase.Gost();
				g.setOsoba(o);
				session.save(o);
				System.out.println("snmimljena osoba!");
				g.setMjestoRodjenja(textField_4.getText());
				// g.setPrimjedba(textField_1.getText());
				// g.setRbrPrijave(textField_1.getText());
				session.save(g);
				System.out.println("Snimljen gost !");
				if (comboBox.getSelectedItem().toString() == "Strani") {
					Klase.StraniGost sg = new Klase.StraniGost();

					sg.setBrojPutneIsprave(textField_7.getText());
					sg.setBrojVize(textField_9.getText());
					// sg.setDatumDozvoleBoravka((Date) datePicker2
					// .getJFormattedTextField().getValue());
					// sg.setDatumUlaskaUBih((Date) datePicker3
					// .getJFormattedTextField().getValue());
					sg.setDrzavljanstvo(textField_6.getText());
					sg.setGost(g);
					sg.setVrstaPutneIsprave(textField_6.getText());
					sg.setVrstaVize(textField_8.getText());
					session.save(sg);
					System.out.println("Snimljen strani gost !");
				}

				t.commit();

				session.close();
				System.out.println("SVE JE OK !");
			}
		});
		JButton btnSpasiPromjene = new JButton("Spasi promjene");
		btnSpasiPromjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				Transaction t = session.beginTransaction();
				Klase.Gost g = (Klase.Gost) listG.getSelectedValue();
				if (isStraniGost()) {
					
					Long id= g.getId();
				
				//	Query query = session.createQuery("from StraniGost where gost = :gostid ");
				//	query.setParameter("gostid", id);
					
				String 	q = "FROM StraniGost qt WHERE qt.gost = :tag";
				Query	query = (Query) session.createQuery(q);
					query.setParameter("tag", g);
					List<StraniGost> stranigosti = query.list();
					
				//	List<Object[]> objekti2 = (List<Object[]>) query.list();
					
					//List<StraniGost> stranigosti = new ArrayList<StraniGost>();
					
				//	for (Object[] o : objekti2) {
				//		for (Object o2 : o) {
			//				if (o2.getClass().equals(StraniGost.class)) {
			//					stranigosti.add((StraniGost) o2);
			//			}
//
			//		}		}
					StraniGost sg=new StraniGost();
					sg=stranigosti.get(0);
					if (comboBox_1.getSelectedItem().toString() == "Strani") {
						JOptionPane.showMessageDialog(null, "Gost je domaci",
								"Info", JOptionPane.INFORMATION_MESSAGE);
						sg.getGost()
								.getOsoba()
								.setImePrezime(
										textField_16.getText() + " "
												+ textField_16.getText());
						// sg.getGost().getOsoba()
						// .setDatumRodjenja(textField_16.getText());
						sg.getGost().getOsoba()
								.setAdresa(textField_18.getText());
						sg.getGost().setMjestoRodjenja(textField_13.getText());
						sg.setBrojPutneIsprave(textField_20.getText());
						sg.setBrojVize(textField_22.getText());
						// sg.setDatumDozvoleBoravk(textField_12.getText());
						// sg.setDatumUlaskaUBih(textField_12.getText());
						sg.setDrzavljanstvo(textField_14.getText());
						sg.setVrstaPutneIsprave(textField_15.getText());

						sg.setVrstaVize(textField_21.getText());
						session.update(sg);

					} else if (comboBox_1.getSelectedItem().toString() == "Domaci") {
						JOptionPane.showMessageDialog(null, "Gost je domaci",
								"Info", JOptionPane.INFORMATION_MESSAGE);
						sg.getGost().getOsoba().setImePrezime(textField_16.getText() + " "+ textField_16.getText());
						// sg.getGost().getOsoba()
						// .setDatumRodjenja(textField_16.getText());
						sg.getGost().getOsoba()
								.setAdresa(textField_18.getText());
						sg.getGost().setMjestoRodjenja(textField_13.getText());
						sg.setBrojPutneIsprave(textField_20.getText());
						sg.setBrojVize(textField_22.getText());
						// sg.setDatumDozvoleBoravk(textField_12.getText());
						// sg.setDatumUlaskaUBih(textField_12.getText());
						sg.setDrzavljanstvo(textField_14.getText());
						sg.setVrstaPutneIsprave(textField_15.getText());

						sg.setVrstaVize(textField_21.getText());
						session.update(sg);
						Query query2 = session
								.createQuery("delete StraniGost where id = :idgosta");
						query2.setParameter("idgosta", sg);
						query2.executeUpdate();

					}
				} else {

					if (comboBox_1.getSelectedItem().toString() == "Strani") {
					
						StraniGost sg = new StraniGost();

						g.getOsoba().setImePrezime(
								textField_16.getText() + " "
										+ textField_16.getText());
						// g.getOsoba()
						// .setDatumRodjenja(textField_16.getText());
						g.getOsoba().setAdresa(textField_18.getText());
						g.setMjestoRodjenja(textField_13.getText());
						sg.setGost(g);
						sg.setBrojPutneIsprave(textField_20.getText());
						sg.setBrojVize(textField_22.getText());
						// sg.setDatumDozvoleBoravk(textField_12.getText());
						// sg.setDatumUlaskaUBih(textField_12.getText());
						sg.setDrzavljanstvo(textField_14.getText());
						sg.setVrstaPutneIsprave(textField_15.getText());

						sg.setVrstaVize(textField_21.getText());
						session.save(sg);

					} else if (comboBox_1.getSelectedItem().toString() == "Domaci") {
				

						g.getOsoba().setImePrezime(
								textField_16.getText() + " "
										+ textField_16.getText());
						// g.getOsoba()
						// .setDatumRodjenja(textField_16.getText());
						g.getOsoba().setAdresa(textField_18.getText());
						g.setMjestoRodjenja(textField_13.getText());
						session.update(g);

					}
					

				}

				t.commit();
				session.close();

			}

			public boolean isStraniGost() {
				Klase.Gost g = (Klase.Gost) listG.getSelectedValue();
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				Transaction t = session.beginTransaction();
				Query query2 = session
						.createQuery("from StraniGost stranigost join stranigost.gost as gost join gost.osoba as osoba");

				List<Object[]> objekti2 = (List<Object[]>) query2.list();
				List<StraniGost> stranigosti = new ArrayList<StraniGost>();

				for (Object[] o : objekti2) {
					for (Object o2 : o) {
						if (o2.getClass().equals(StraniGost.class)) {
							stranigosti.add((StraniGost) o2);
					}

				}		}
				
				t.commit();
				session.close();
				for (StraniGost sg : stranigosti) {
					if (sg.getGost().getId() == g.getId()) {

						JOptionPane.showMessageDialog(null, "Gost je strani",
								"Info", JOptionPane.INFORMATION_MESSAGE);
						return true;
					}

				}
				return false;

			}
		});
		btnSpasiPromjene.setBounds(511, 503, 122, 23);
		panel_1.add(btnSpasiPromjene);
		
		JButton btnRezervacija = new JButton("Rezervacija");
		btnRezervacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Rezervacija().setVisible(true);
			}
		});
		btnRezervacija.setBounds(674, 466, 200, 50);
		contentPane.add(btnRezervacija);

	}
}
