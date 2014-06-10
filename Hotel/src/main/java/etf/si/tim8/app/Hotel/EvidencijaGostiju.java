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

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.DBManager;
import Hibernate.HibernateUtil;
import Klase.Boravak;
import Klase.Gost;
import Klase.Osoba;
import Klase.Soba;
import Klase.StraniGost;
import Klase.Zaposlenik;
import Hibernate.DBManager;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvidencijaGostiju extends JFrame {
	
	final private Zaposlenik zaposlenik;

	private JPanel contentPane;
	private JTextField textField;
	// private JComboBox comboBox_1;
	// private JComboBox comboBox;
	private JTextField textField_12;
	private JTextField textField_25;
	private JTabbedPane 	tabbedPane;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
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
	private JTextField textField_3;
	private JDatePickerImpl datePicker;
	private JComboBox comboBox;
	private JDatePickerImpl datePicker2;
	private JDatePickerImpl datePicker3;
	private JDatePickerImpl datePicker6;
	private JDatePickerImpl datePicker4;
	private JDatePickerImpl datePicker5;
	private JList listG;
	private JComboBox 	comboBox_3;
	private JComboBox 	comboBox_2;
	private UtilDateModel 	model2; 
	private UtilDateModel 	model; 
	private UtilDateModel 	model3; 
	private UtilDateModel 	model4; 
	private UtilDateModel 	model5; 
	private UtilDateModel 	model6; 

	// private JDatePickerImpl datePicker;

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
		zaposlenik = null;
		setResizable(false);
		setTitle("Hotel Ksenon Plaza-Evidencija gostiju");
		setBounds(100, 100, 903, 631);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//final JTabbedPane 
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
statistika();
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

		comboBox_2 = new JComboBox();

		comboBox_2.addItem("Pasoš");
		comboBox_2.addItem("Diplomatski pasoš");
		comboBox_2.addItem("Službeni pasoš");
		comboBox_2.addItem("Zajednički pasoš");
		comboBox_2.addItem("Putni list");
		comboBox_2.addItem("Brodarska knjižica");
		comboBox_2.addItem("Međunarodni ugovor");
		comboBox_2.setSelectedItem("Pasoš");

		comboBox_2.setBounds(171, 275, 149, 26);
		panel.add(comboBox_2);

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

		// final JComboBox
		comboBox = new JComboBox();
		comboBox.setBounds(171, 11, 149, 30);
		comboBox.addItem("Domaci");
		comboBox.addItem("Strani");
		comboBox.addItem("");
		comboBox.setSelectedIndex(2);
		//comboBox.setSelectedItem("Domaci");
	

		//final JComboBox 
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(171, 352, 240, 23);
		comboBox_3.addItem("Aerodromska tranzitna viza");
		comboBox_3.addItem("Tranzitna viza");
		comboBox_3.addItem("Ulazna viza za kratkoročni boravak");
		comboBox_3.addItem("Ulazna viza za dugoročni boravak");
		comboBox_3.addItem("Nacionalna viza");
		comboBox_3.setSelectedItem("Ulazna viza za kratkoročni boravak");

		panel.add(comboBox_3);
		comboBox_3.setEditable(false);
		comboBox_2.setEditable(false);
		comboBox.setEditable(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 2)
				{
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					
					textField_4.setEditable(false);
					textField_5.setEditable(false);
			
					comboBox_2.setEnabled(false);
					textField_7.setEditable(false);
				
					comboBox_3.setEnabled(false);
					textField_9.setEditable(false);
				
					datePicker2.setEnabled(false);
					datePicker3.setEnabled(false);
					datePicker2.getJFormattedTextField().setEnabled(false);
					datePicker3.getJFormattedTextField().setEnabled(false);
				}
				else
				{
				
				
				if (comboBox.getSelectedIndex() == 1) {
					textField.setEditable(true);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
		
					textField_4.setEditable(true);
					textField_5.setEditable(true);
					
					comboBox_2.setEnabled(true);
					textField_7.setEditable(true);
				
					comboBox_3.setEnabled(true);
					textField_9.setEditable(true);
				
					datePicker2.setEnabled(true);
					datePicker3.setEnabled(true);
					datePicker2.getJFormattedTextField().setEnabled(true);
					datePicker3.getJFormattedTextField().setEnabled(true);

				}
				else {
					textField.setEditable(true);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
			
					textField_4.setEditable(true);
					textField_5.setEditable(false);
				
					comboBox_2.setEnabled(false);
					textField_7.setEditable(false);
				
					comboBox_3.setEnabled(false);
					textField_9.setEditable(false);
		
					datePicker2.setEnabled(false);
					datePicker3.setEnabled(false);
					datePicker2.getJFormattedTextField().setEnabled(false);
					datePicker3.getJFormattedTextField().setEnabled(false);

				}
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

		textField_7 = new JTextField();
		textField_7.setBounds(171, 312, 149, 26);
		panel.add(textField_7);

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

		// final JList
		listG = new JList();
		listG.setBounds(10, 87, 314, 313);
		panel_1.add(listG);

		JLabel lblListaGostiju = new JLabel("Lista gostiju:");
		lblListaGostiju.setBounds(10, 62, 106, 14);
		panel_1.add(lblListaGostiju);

		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try{
				if (listG.getSelectedValue() instanceof Klase.Gost) {
					Klase.Gost g = (Klase.Gost) listG.getSelectedValue();
					izbrisiGosta(g);
					DefaultListModel model = (DefaultListModel) listG
							.getModel();
					int selectedIndex = listG.getSelectedIndex();
					if (selectedIndex != -1) {
						model.remove(selectedIndex);
					}

				}}
catch(Exception ec){
	JOptionPane.showMessageDialog(null,"Ne možete izbrisati gosta koji ima evidentiranu rezervaciju!", "Info",
			JOptionPane.INFORMATION_MESSAGE);
}

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
		btnPoetnaStranica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new HomePage().setVisible(true);

			}

		});
		contentPane.add(btnPoetnaStranica);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(674, 325, 200, 191);
		contentPane.add(panel_3);

		ImageIcon guy = new ImageIcon("C:\\Users\\X\\Desktop\\hotel.png");
		JLabel pn = new JLabel(guy);
		panel_3.add(pn);

		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		// final JDatePickerImpl
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker.setLocation(170, 160);
		datePicker.setSize(150, 26);
		panel.add(datePicker);

	
		model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
		// final JDatePickerImpl
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker2.setLocation(170, 420);
		datePicker2.setSize(150, 26);
		panel.add(datePicker2);

	
		model3 = new UtilDateModel();
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3);

		datePicker3 = new JDatePickerImpl(datePanel3);
		datePicker3.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker3.setLocation(170, 460);
		datePicker3.setSize(150, 26);
		panel.add(datePicker3);

		// azuriranje gosta

		model4 = new UtilDateModel();
		JDatePanelImpl datePanel4 = new JDatePanelImpl(model4);
		datePicker4 = new JDatePickerImpl(datePanel4);
		datePicker4.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker4.setLocation(485, 170);
		datePicker4.setSize(150, 26);
		panel_1.add(datePicker4);

	
		model5 = new UtilDateModel();
		JDatePanelImpl datePanel5 = new JDatePanelImpl(model5);
		datePicker5 = new JDatePickerImpl(datePanel5);
		datePicker5.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker5.setLocation(485, 430);
		datePicker5.setSize(150, 26);
		panel_1.add(datePicker5);

	
		model6 = new UtilDateModel();
		JDatePanelImpl datePanel6 = new JDatePanelImpl(model6);

		datePicker6 = new JDatePickerImpl(datePanel6);
		datePicker6.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker6.setLocation(485, 470);
		datePicker6.setSize(150, 26);
		panel_1.add(datePicker6);

		listG.addListSelectionListener(new ListSelectionListener() {
			
			@SuppressWarnings("deprecation")
			public void valueChanged(ListSelectionEvent ev) {
				ucitajPodatke();
			}
		});

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				List<Gost> gosti = new ArrayList<Gost>();
				gosti = DBManager.dajGoste();
				listG.setModel(new DefaultListModel());
				for (Gost g : gosti) {
					String imeprezime = g.getIme() + " " + g.getPrezime();
					if (imeprezime.contains(textField_12.getText())) {

						((DefaultListModel) listG.getModel()).addElement(g);
					}

				}

			}

		});
		btnUnesiGosta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				unesiGosta();
	
			}
		});
		JButton btnSpasiPromjene = new JButton("Spasi promjene");
		btnSpasiPromjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spasiPromjene();

			}

		});
		btnSpasiPromjene.setBounds(511, 503, 122, 23);
		panel_1.add(btnSpasiPromjene);

		textField_3 = new JTextField();
		textField_3.setBounds(484, 26, 149, 20);
		textField_3.setEditable(false);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);

		textField_4.setEditable(false);
		textField_5.setEditable(false);

		comboBox_2.setEnabled(false);
		textField_7.setEditable(false);
	
		comboBox_3.setEnabled(false);
		textField_9.setEditable(false);

	
		datePicker2.setEnabled(false);
		datePicker3.setEnabled(false);
		datePicker2.getJFormattedTextField().setEnabled(false);
		datePicker3.getJFormattedTextField().setEnabled(false);


	}
	
	
	public EvidencijaGostiju(Zaposlenik zap) {
		this.zaposlenik = zap;
		setResizable(false);
		setTitle("Hotel Ksenon Plaza-Evidencija gostiju");
		setBounds(100, 100, 903, 631);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//final JTabbedPane 
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
statistika();
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

		comboBox_2 = new JComboBox();

		comboBox_2.addItem("Pasoš");
		comboBox_2.addItem("Diplomatski pasoš");
		comboBox_2.addItem("Službeni pasoš");
		comboBox_2.addItem("Zajednički pasoš");
		comboBox_2.addItem("Putni list");
		comboBox_2.addItem("Brodarska knjižica");
		comboBox_2.addItem("Međunarodni ugovor");
		comboBox_2.setSelectedItem("Pasoš");

		comboBox_2.setBounds(171, 275, 149, 26);
		panel.add(comboBox_2);

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

		// final JComboBox
		comboBox = new JComboBox();
		comboBox.setBounds(171, 11, 149, 30);
		comboBox.addItem("Domaci");
		comboBox.addItem("Strani");
		comboBox.addItem("");
		comboBox.setSelectedIndex(2);
		//comboBox.setSelectedItem("Domaci");
	

		//final JComboBox 
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(171, 352, 240, 23);
		comboBox_3.addItem("Aerodromska tranzitna viza");
		comboBox_3.addItem("Tranzitna viza");
		comboBox_3.addItem("Ulazna viza za kratkoročni boravak");
		comboBox_3.addItem("Ulazna viza za dugoročni boravak");
		comboBox_3.addItem("Nacionalna viza");
		comboBox_3.setSelectedItem("Ulazna viza za kratkoročni boravak");

		panel.add(comboBox_3);
		comboBox_3.setEditable(false);
		comboBox_2.setEditable(false);
		comboBox.setEditable(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 2)
				{
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					
					textField_4.setEditable(false);
					textField_5.setEditable(false);
			
					comboBox_2.setEnabled(false);
					textField_7.setEditable(false);
				
					comboBox_3.setEnabled(false);
					textField_9.setEditable(false);
				
					datePicker2.setEnabled(false);
					datePicker3.setEnabled(false);
					datePicker2.getJFormattedTextField().setEnabled(false);
					datePicker3.getJFormattedTextField().setEnabled(false);
				}
				else
				{
				
				
				if (comboBox.getSelectedIndex() == 1) {
					textField.setEditable(true);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
		
					textField_4.setEditable(true);
					textField_5.setEditable(true);
					
					comboBox_2.setEnabled(true);
					textField_7.setEditable(true);
				
					comboBox_3.setEnabled(true);
					textField_9.setEditable(true);
				
					datePicker2.setEnabled(true);
					datePicker3.setEnabled(true);
					datePicker2.getJFormattedTextField().setEnabled(true);
					datePicker3.getJFormattedTextField().setEnabled(true);

				}
				else {
					textField.setEditable(true);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
			
					textField_4.setEditable(true);
					textField_5.setEditable(false);
				
					comboBox_2.setEnabled(false);
					textField_7.setEditable(false);
				
					comboBox_3.setEnabled(false);
					textField_9.setEditable(false);
		
					datePicker2.setEnabled(false);
					datePicker3.setEnabled(false);
					datePicker2.getJFormattedTextField().setEnabled(false);
					datePicker3.getJFormattedTextField().setEnabled(false);

				}
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

		textField_7 = new JTextField();
		textField_7.setBounds(171, 312, 149, 26);
		panel.add(textField_7);

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

		// final JList
		listG = new JList();
		listG.setBounds(10, 87, 314, 313);
		panel_1.add(listG);

		JLabel lblListaGostiju = new JLabel("Lista gostiju:");
		lblListaGostiju.setBounds(10, 62, 106, 14);
		panel_1.add(lblListaGostiju);

		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try{
				if (listG.getSelectedValue() instanceof Klase.Gost) {
					Klase.Gost g = (Klase.Gost) listG.getSelectedValue();
					izbrisiGosta(g);
					DefaultListModel model = (DefaultListModel) listG
							.getModel();
					int selectedIndex = listG.getSelectedIndex();
					if (selectedIndex != -1) {
						model.remove(selectedIndex);
					}

				}}
catch(Exception ec){
	JOptionPane.showMessageDialog(null,"Ne možete izbrisati gosta koji ima evidentiranu rezervaciju!", "Info",
			JOptionPane.INFORMATION_MESSAGE);
}

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
		btnPoetnaStranica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new HomePage().setVisible(true);

			}

		});
		contentPane.add(btnPoetnaStranica);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(674, 325, 200, 191);
		contentPane.add(panel_3);

		ImageIcon guy = new ImageIcon("C:\\Users\\X\\Desktop\\hotel.png");
		JLabel pn = new JLabel(guy);
		panel_3.add(pn);

		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		// final JDatePickerImpl
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker.setLocation(170, 160);
		datePicker.setSize(150, 26);
		panel.add(datePicker);

	
		model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
		// final JDatePickerImpl
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker2.setLocation(170, 420);
		datePicker2.setSize(150, 26);
		panel.add(datePicker2);

	
		model3 = new UtilDateModel();
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3);

		datePicker3 = new JDatePickerImpl(datePanel3);
		datePicker3.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker3.setLocation(170, 460);
		datePicker3.setSize(150, 26);
		panel.add(datePicker3);

		// azuriranje gosta

		model4 = new UtilDateModel();
		JDatePanelImpl datePanel4 = new JDatePanelImpl(model4);
		datePicker4 = new JDatePickerImpl(datePanel4);
		datePicker4.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker4.setLocation(485, 170);
		datePicker4.setSize(150, 26);
		panel_1.add(datePicker4);

	
		model5 = new UtilDateModel();
		JDatePanelImpl datePanel5 = new JDatePanelImpl(model5);
		datePicker5 = new JDatePickerImpl(datePanel5);
		datePicker5.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker5.setLocation(485, 430);
		datePicker5.setSize(150, 26);
		panel_1.add(datePicker5);

	
		model6 = new UtilDateModel();
		JDatePanelImpl datePanel6 = new JDatePanelImpl(model6);

		datePicker6 = new JDatePickerImpl(datePanel6);
		datePicker6.setBackground(SystemColor.inactiveCaptionBorder);
		datePicker6.setLocation(485, 470);
		datePicker6.setSize(150, 26);
		panel_1.add(datePicker6);

		listG.addListSelectionListener(new ListSelectionListener() {
			
			@SuppressWarnings("deprecation")
			public void valueChanged(ListSelectionEvent ev) {
				ucitajPodatke();
			}
		});

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				List<Gost> gosti = new ArrayList<Gost>();
				gosti = DBManager.dajGoste();
				listG.setModel(new DefaultListModel());
				for (Gost g : gosti) {
					String imeprezime = g.getIme() + " " + g.getPrezime();
					if (imeprezime.contains(textField_12.getText())) {

						((DefaultListModel) listG.getModel()).addElement(g);
					}

				}

			}

		});
		btnUnesiGosta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				unesiGosta();
	
			}
		});
		JButton btnSpasiPromjene = new JButton("Spasi promjene");
		btnSpasiPromjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spasiPromjene();

			}

		});
		btnSpasiPromjene.setBounds(511, 503, 122, 23);
		panel_1.add(btnSpasiPromjene);

		textField_3 = new JTextField();
		textField_3.setBounds(484, 26, 149, 20);
		textField_3.setEditable(false);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);

		textField_4.setEditable(false);
		textField_5.setEditable(false);

		comboBox_2.setEnabled(false);
		textField_7.setEditable(false);
	
		comboBox_3.setEnabled(false);
		textField_9.setEditable(false);

	
		datePicker2.setEnabled(false);
		datePicker3.setEnabled(false);
		datePicker2.getJFormattedTextField().setEnabled(false);
		datePicker3.getJFormattedTextField().setEnabled(false);


	}
	
	
	
	
	public void statistika()
	{
		

		if (tabbedPane.getSelectedIndex() == 2) {

			Date today = new Date();
			List<Soba> sobe1 =DBManager.dajSlobodneSobe(today, today, 1);
			List<Soba> sobe2 =DBManager.dajSlobodneSobe(today, today, 2);
			
	
			textField_26.setText(Integer.toString(sobe1.size()+sobe2.size()));
			int ukupanBroj = DBManager.dajUkupanBrojRazlicitihGostiju();
			textField_25.setText(Integer.toString(ukupanBroj));
			
			int trenutniBroj = DBManager.dajTrenutniBrojGostiju();
			textField_27.setText(Integer.toString(trenutniBroj));


		}

		
	}

	public void unesiGosta()
	{
		if (comboBox.getSelectedItem().toString() == "") {
			JOptionPane.showMessageDialog(null, "Ne mozete unijeti gosta bez statusa", "Info",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if (validiraj() != "") {
			JOptionPane.showMessageDialog(null, validiraj(), "Info",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		Osoba o = new Osoba();
		o.setAdresa(textField_2.getText());
		o.setDatumRodjenja((Date) datePicker.getModel().getValue());

		o.setImePrezime(textField.getText() + " "
				+ textField_1.getText());

		List<Gost> gosti = DBManager.dajGoste();
		for (Gost i : gosti) {

			if (i.getIme().equals(o.getIme())
					&& i.getPrezime().equals(o.getPrezime())) {
				JOptionPane.showMessageDialog(null,
						"Postoji gost s istim imenom i prezimenom",
						"Info", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}

		Klase.Gost g = new Klase.Gost();
		g.setOsoba(o);
		DBManager.saveOsobu(o);
		g.setMjestoRodjenja(textField_4.getText());
		DBManager.saveGosta(g);

		if (comboBox.getSelectedItem().toString() == "Strani") {
			Klase.StraniGost sg = new Klase.StraniGost();

			sg.setBrojPutneIsprave(textField_7.getText());
			sg.setBrojVize(textField_9.getText());
			sg.setDatumDozvoleBoravka((Date) datePicker2.getModel()
					.getValue());
			sg.setDatumUlaskaUBih((Date) datePicker3.getModel()
					.getValue());
			sg.setDrzavljanstvo(textField_5.getText());
			sg.setGost(g);
			sg.setVrstaPutneIsprave((String) comboBox_2
					.getSelectedItem());
			sg.setVrstaVize((String) comboBox_3.getSelectedItem());
			DBManager.saveStranogGosta(sg);
		}
		JOptionPane.showMessageDialog(null,
				"Gost je snimljen",
				"Info", JOptionPane.INFORMATION_MESSAGE);			
		ocistiKontroleUnos();
		
		
		
	}
	
	
	
	
	
	
	public void spasiPromjene() {
		Klase.Gost g = (Klase.Gost) listG.getSelectedValue();
		if (validirajIzmjene() != "") {
			JOptionPane.showMessageDialog(null, validirajIzmjene(), "Info",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		StraniGost sg = new StraniGost();
		if (isStraniGost(g)) {
			sg = DBManager.dajStranogZaGosta(g);

		}
		g.getOsoba().setImePrezime(
				textField_16.getText() + " " + textField_17.getText());
		g.getOsoba().setDatumRodjenja((Date) datePicker4.getModel().getValue());
		g.getOsoba().setAdresa(textField_18.getText());
		g.setMjestoRodjenja(textField_13.getText());

		DBManager.updateGosta(g);
		DBManager.updateOsobu(g.getOsoba());
		JOptionPane.showMessageDialog(null, textField_3.getText(), "Info",
				JOptionPane.INFORMATION_MESSAGE);
		if (textField_3.getText().equals("Strani")) {
			sg.setBrojPutneIsprave(textField_20.getText());
			sg.setBrojVize(textField_22.getText());
			sg.setDatumDozvoleBoravka((Date) datePicker5.getModel().getValue());
			sg.setDatumUlaskaUBih((Date) datePicker6.getModel().getValue());
			sg.setDrzavljanstvo(textField_14.getText());
			sg.setVrstaPutneIsprave(textField_15.getText());

			sg.setVrstaVize(textField_21.getText());
			DBManager.updateStranogGosta(sg);

		}
		DefaultListModel model = (DefaultListModel) listG.getModel();
		int selectedIndex = listG.getSelectedIndex();
		if (selectedIndex != -1) {
			model.remove(selectedIndex);
		}
		ocistiKontrole();

	}

	
	
	@SuppressWarnings("deprecation")
	public void ucitajPodatke()
	{
		ocistiKontrole();
		if (listG.getModel().getSize() == 0)
			return;

		Klase.Gost g = (Klase.Gost) listG.getSelectedValue();
		if (g == null)
			return;

		if (isStraniGost(g)) {

			textField_3.setText("Strani");
			textField_14.setEditable(true);
			textField_15.setEditable(true);
			textField_20.setEditable(true);
			textField_21.setEditable(true);
			textField_22.setEditable(true);
		
			
			datePicker5.setEnabled(true);
			datePicker6.setEnabled(true);
			datePicker5.getJFormattedTextField().setEnabled(true);
			datePicker6.getJFormattedTextField().setEnabled(true);
		
		
		
		
		} else {
			textField_3.setText("Domaci");
			
		
			
		}
		
		datePicker4.setEnabled(true);
		datePicker4.getJFormattedTextField().setEnabled(true);
		textField_13.setEditable(true);
		textField_16.setEditable(true);
		textField_17.setEditable(true);
		textField_18.setEditable(true);

		List<StraniGost> stranigosti = new ArrayList<StraniGost>();
		stranigosti = DBManager.dajStraneGoste();

		String imeprezime = g.getOsoba().getImePrezime();

		String[] parts = imeprezime.split(" ");

		String ime = parts[0];
		String prezime = parts[1];

		textField_16.setText(ime);
		textField_17.setText(prezime);
		textField_18.setText(g.getOsoba().getAdresa());
		textField_13.setText(g.getMjestoRodjenja());
		textField_3.setText("Domaci");
		
		model4.setValue(g.getOsoba().getDatumRodjenja());
    //    model4.setDate(g.getOsoba().getDatumRodjenja().getYear()+1900, g.getOsoba().getDatumRodjenja().getMonth(), g.getOsoba().getDatumRodjenja().getDay()+1);
       
		StraniGost sg = null;
		for (StraniGost pom : stranigosti) {
			if (pom.getGost().getId() == g.getId())
				sg = pom;

		}
		if (sg != null) {
			textField_20.setText(sg.getBrojPutneIsprave());
			textField_22.setText(sg.getBrojVize());
			textField_21.setText(sg.getVrstaVize());
			textField_14.setText(sg.getDrzavljanstvo());
			textField_15.setText(sg.getVrstaPutneIsprave());
			textField_3.setText("Strani");
		
		//	model5.setValue(sg.getDatumDozvoleBoravka());
			model5.setValue(sg.getDatumDozvoleBoravka());
			// model5.setDate(sg.getDatumDozvoleBoravka().getYear()+1900, sg.getDatumDozvoleBoravka().getMonth(),sg.getDatumDozvoleBoravka().getDay()+1);
			model6.setValue(sg.getDatumUlaskaUBih());
		//	model6.setDate(sg.getDatumUlaskaUBih().getYear()+1900, sg.getDatumUlaskaUBih().getMonth(),sg.getDatumUlaskaUBih().getDay()+1);
		

		}

	}
		
	
	
	public void izbrisiGosta(Gost g) {
		List<StraniGost> stranigosti = new ArrayList<StraniGost>();
		stranigosti = DBManager.dajStraneGoste();

		for (StraniGost sg : stranigosti) {
			if (sg.getGost().getId() == g.getId()) {
				DBManager.obrisiStranogGosta(sg);
			}
		}

		Osoba o = g.getOsoba();

		DBManager.obrisiGosta(g);

		DBManager.obrisiOsobu(o);

		ocistiKontrole();

	}

	public boolean isStraniGost(Klase.Gost g) {
		if (g == null)
			System.out.printf("gost je null");

		List<StraniGost> stranigosti = new ArrayList<StraniGost>();
		stranigosti = DBManager.dajStraneGoste();
		for (StraniGost sg : stranigosti) {
			if (sg.getGost() == null)
				System.out.printf("gost  u sg je null");
			if (sg.getGost().getId() == g.getId()) 
					return true;
					}
		return false;
	}

	public void ocistiKontrole() {
		textField_13.setText("");
		textField_14.setText("");
		textField_15.setText("");
		textField_16.setText("");
		textField_17.setText("");
		textField_18.setText("");
		textField_20.setText("");
		textField_21.setText("");
		textField_22.setText("");
		datePicker4.getJFormattedTextField().setText("");
		datePicker5.getJFormattedTextField().setText("");
		datePicker6.getJFormattedTextField().setText("");

		
		textField_14.setEditable(false);
		textField_15.setEditable(false);
		textField_20.setEditable(false);
		textField_21.setEditable(false);
		textField_22.setEditable(false);
		textField_13.setEditable(false);
		textField_16.setEditable(false);
		textField_17.setEditable(false);
		textField_18.setEditable(false);
	
	
		datePicker5.setEnabled(true);
		datePicker6.setEnabled(true);
		datePicker4.setEnabled(true);
		datePicker5.getJFormattedTextField().setEnabled(true);
		datePicker6.getJFormattedTextField().setEnabled(true);
		datePicker4.getJFormattedTextField().setEnabled(true);
	}

	public void ocistiKontroleUnos() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_7.setText("");
		textField_9.setText("");

	}

	public String validiraj() {
		String poruka = "";

		if (!validateFirstName(textField.getText()))
			poruka += "Ime mora biti dugo bar 3 slova, prvo slovo veliko\n";

		if (!validateLastName(textField_1.getText()))
			poruka += "Prezime prezime biti dugo bar 3 slova, prvo slovo veliko!\n";

		if (!validateCity(textField_4.getText()))
			poruka += "Naziv mjesta nije validan!\n";

		if ((Date) datePicker.getModel().getValue() != null) {
			if (!validateDatumRodjenja((Date) datePicker.getModel().getValue()))
				poruka += "Datum rodjenja ne moze biti u buducnosti!\n";
		} else
			poruka += "Morate unijeti datum rodjenja!\n";
		 if(!validateAddress(textField_2.getText()))
		 poruka+="Unesite adresu\n";

		if (comboBox.getSelectedItem() == "Strani") {

			if (!validateNationality(textField_5.getText()))
				poruka += "Drzavljanstvo treba biti napisano velikim slovima, najmanje 2 slova!\n";
			if (!validateBrojPutneIspave(textField_7.getText()))
				poruka += "Putna isprava treba da bude u formatu A123456!\n";
			if ((Date) datePicker2.getModel().getValue() == null
					|| (Date) datePicker3.getModel().getValue() == null)
				poruka += "Morate unijeti sve datume!\n";
			if((Date) datePicker2.getModel().getValue() != null
					&& (Date) datePicker3.getModel().getValue() != null)
			{
Date datumdozvole=(Date) datePicker2.getModel().getValue();
Date datumulaska=(Date) datePicker3.getModel().getValue();
if(datumdozvole.after(datumulaska)) 
				poruka += "Datum ulaska ne moze biti prije datuma dozvole boravka!\n";
			}
			if(!validateBrojVize(textField_9.getText()))
				poruka += "Broj vize treba da bude u formatu A1234567!\n";
			
			
		}

		return poruka;
	}

	public String validirajIzmjene() {
		String poruka = "";

		if (!validateFirstName(textField_16.getText()))
			poruka += "Ime mora biti dugo bar 3 slova, prvo slovo veliko!\n";

		if (!validateLastName(textField_17.getText()))
			poruka += "Prezime  biti dugo bar 3 slova, prvo slovo veliko!\n";

		if (!validateCity(textField_13.getText()))
			poruka += "Naziv mjesta nije validan!\n";

		if ((Date) datePicker4.getModel().getValue() != null) {
			if (!validateDatumRodjenja((Date) datePicker4.getModel().getValue()))
				poruka += "Datum rodjenja ne moze biti u buducnosti!\n";
		} else
			poruka += "Morate unijeti datum rodjenja!\n";
		 if(!validateAddress(textField_18.getText()))
		 poruka+="Unesite adresu\n";

		if (textField_3.getText().equals("Strani")) {

			if (!validateNationality(textField_14.getText()))
				poruka += "Drzavljanstvo treba biti napisano velikim slovima, najmanje 2 slova!\n";

			if (!validateBrojPutneIspave(textField_20.getText()))
				poruka += "Putna isprava treba da bude u formatu A123456!\n";

			if ((Date) datePicker4.getModel().getValue() == null
					|| (Date) datePicker5.getModel().getValue() == null
					|| (Date) datePicker6.getModel().getValue() == null)
				poruka += "Morate unijeti sve datume!\n";
			
			if((Date) datePicker5.getModel().getValue() != null
					&& (Date) datePicker6.getModel().getValue() != null)
			{
Date datumdozvole=(Date) datePicker5.getModel().getValue();
Date datumulaska=(Date) datePicker6.getModel().getValue();
if(datumdozvole.after(datumulaska)) 
				poruka += "Datum ulaska ne moze biti prije datuma dozvole boravka!\n";
			}
			if(!validateBrojVize(textField_22.getText()))
				poruka += "Broj vize treba da bude u formatu A1234567!\n";
		}

		return poruka;
	}

	public static boolean validateFirstName(String firstName) {
		return firstName.matches("^[A-Z]{1}[a-z]{2,}$");
	} 


	public static boolean validateLastName(String lastName) {
		return lastName.matches("^[A-Z]{1}[a-z]{2,}$");
	}

	public static boolean validateCity(String address) {
		return address.matches("([A-Z]{1}[a-z]{1,} *)+");
	} 

	public static boolean validateAddress(String address) {

		return !(address.equals("")||address.equals(" "));
	}

	public static boolean validateNationality(String nationality) {
		return nationality.matches("[A-Z]{2,}");
	}

	public static boolean validateBrojPutneIspave(String brojPutneIspave) {
		return brojPutneIspave.matches("[A-Z]{1}\\d{6}");
	}
	public static boolean validateBrojVize(String brojPutneIspave) {
		return brojPutneIspave.matches("[A-Z]{1}\\d{7}");
	}
	

	public static boolean validateDatumRodjenja(Date datumrodjenja) {
		Date today = new Date();
		if (datumrodjenja.after(today))
			return false;
		return true;
	}
	
	
}
