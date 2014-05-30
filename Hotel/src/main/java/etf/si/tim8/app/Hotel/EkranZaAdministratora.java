package etf.si.tim8.app.Hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Klase.Zaposlenik;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EkranZaAdministratora extends JFrame {

	private JPanel contentPane;
	private Zaposlenik zaposlenik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EkranZaAdministratora frame = new EkranZaAdministratora();
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
	public EkranZaAdministratora() {
		setBounds(100, 100, 746, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSobe = new JButton();
		btnSobe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EkranZaSobeAdministrator().setVisible(true);;
			}
		});
		btnSobe.setText("Sobe");
		btnSobe.setOpaque(true);
		btnSobe.setActionCommand("Rezervacija");
		btnSobe.setBounds(56, 190, 179, 74);
		contentPane.add(btnSobe);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			 new Rezervacija().setVisible(true);
			 
			}
		});
		button.setText("Rezervacija");
		button.setOpaque(true);
		button.setActionCommand("Rezervacija");
		button.setBounds(56, 80, 179, 74);
		contentPane.add(button);
		
		JButton btnPlaanje = new JButton();
		btnPlaanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EkranZaPlacanje().setVisible(true);
			}
		});
		btnPlaanje.setText("Pla\u0107anje");
		btnPlaanje.setOpaque(true);
		btnPlaanje.setActionCommand("Rezervacija");
		btnPlaanje.setBounds(275, 130, 179, 74);
		contentPane.add(btnPlaanje);
		
		JButton btnEvidencijaGostiju = new JButton();
		btnEvidencijaGostiju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EvidencijaGostiju().setVisible(true);
			}
		});
		btnEvidencijaGostiju.setText("Evidencija gostiju");
		btnEvidencijaGostiju.setOpaque(true);
		btnEvidencijaGostiju.setActionCommand("Rezervacija");
		btnEvidencijaGostiju.setBounds(497, 80, 179, 74);
		contentPane.add(btnEvidencijaGostiju);
		
		JButton btnOsoblje = new JButton();
		btnOsoblje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OsobljeN().setVisible(true);
			}
		});
		btnOsoblje.setText("Osoblje");
		btnOsoblje.setOpaque(true);
		btnOsoblje.setActionCommand("Rezervacija");
		btnOsoblje.setBounds(497, 204, 179, 74);
		contentPane.add(btnOsoblje);
	}
	
	public EkranZaAdministratora(Zaposlenik zaposlenik) {
		this.zaposlenik = zaposlenik;
		setBounds(100, 100, 746, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSobe = new JButton();
		btnSobe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EkranZaSobeAdministrator().setVisible(true);;
			}
		});
		btnSobe.setText("Sobe");
		btnSobe.setOpaque(true);
		btnSobe.setActionCommand("Rezervacija");
		btnSobe.setBounds(56, 190, 179, 74);
		contentPane.add(btnSobe);
		
		JButton button = new JButton();
		final Zaposlenik zap = zaposlenik;
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			 new Rezervacija(zap).setVisible(true);
			 
			}
		});
		button.setText("Rezervacija");
		button.setOpaque(true);
		button.setActionCommand("Rezervacija");
		button.setBounds(56, 80, 179, 74);
		contentPane.add(button);
		
		JButton btnPlaanje = new JButton();
		btnPlaanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EkranZaPlacanje().setVisible(true);
			}
		});
		btnPlaanje.setText("Pla\u0107anje");
		btnPlaanje.setOpaque(true);
		btnPlaanje.setActionCommand("Rezervacija");
		btnPlaanje.setBounds(274, 80, 179, 74);
		contentPane.add(btnPlaanje);
		
		JButton btnEvidencijaGostiju = new JButton();
		btnEvidencijaGostiju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EvidencijaGostiju().setVisible(true);
			}
		});
		btnEvidencijaGostiju.setText("Evidencija gostiju");
		btnEvidencijaGostiju.setOpaque(true);
		btnEvidencijaGostiju.setActionCommand("Rezervacija");
		btnEvidencijaGostiju.setBounds(497, 80, 179, 74);
		contentPane.add(btnEvidencijaGostiju);
		
		JButton btnOsoblje = new JButton();
		btnOsoblje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OsobljeN().setVisible(true);
			}
		});
		btnOsoblje.setText("Osoblje");
		btnOsoblje.setOpaque(true);
		btnOsoblje.setActionCommand("Rezervacija");
		btnOsoblje.setBounds(273, 190, 179, 74);
		contentPane.add(btnOsoblje);
		
		JButton btnGalerija = new JButton();
		btnGalerija.setText("Galerija");
		btnGalerija.setOpaque(true);
		btnGalerija.setActionCommand("Rezervacija");
		btnGalerija.setBounds(497, 190, 179, 74);
		contentPane.add(btnGalerija);
		
	}
}
