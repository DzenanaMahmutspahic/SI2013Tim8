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
	final private Zaposlenik zaposlenik;

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
		this.zaposlenik = null;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSobe = new JButton();
		btnSobe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EkranZaPracenjeRaspolozivostiSobaAdmin().setVisible(true);;
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
			dispose();
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
				dispose();
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
				dispose();
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
				dispose();
				new OsobljeN().setVisible(true);
			}
		});
		btnOsoblje.setText("Osoblje");
		btnOsoblje.setOpaque(true);
		btnOsoblje.setActionCommand("Rezervacija");
		btnOsoblje.setBounds(497, 204, 179, 74);
		contentPane.add(btnOsoblje);
	}
	
	public EkranZaAdministratora(Zaposlenik zap) {
		this.zaposlenik = zap;
		setBounds(100, 100, 746, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSobe = new JButton();
		btnSobe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EkranZaPracenjeRaspolozivostiSobaAdmin(zaposlenik).setVisible(true);;
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
			dispose();
			 new Rezervacija(zaposlenik).setVisible(true);
			 
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
				dispose();
				new EkranZaPlacanje(zaposlenik).setVisible(true);
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
				dispose();
				new EvidencijaGostiju(zaposlenik).setVisible(true);
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
				dispose();
				new OsobljeN(zaposlenik).setVisible(true);
			}
		});
		btnOsoblje.setText("Osoblje");
		btnOsoblje.setOpaque(true);
		btnOsoblje.setActionCommand("Rezervacija");
		btnOsoblje.setBounds(497, 204, 179, 74);
		contentPane.add(btnOsoblje);
		
	}
}
