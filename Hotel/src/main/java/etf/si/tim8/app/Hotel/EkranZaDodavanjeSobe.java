package etf.si.tim8.app.Hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class EkranZaDodavanjeSobe {

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Balkon");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(10, 112, 102, 18);
		panel_1.add(chckbxNewCheckBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(65, 8, 86, 20);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(65, 36, 86, 20);
		panel_1.add(spinner_1);
		
		JComboBox comboBox = new JComboBox();
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
		
		JRadioButton radioButton = new JRadioButton("Televizor");
		radioButton.setBackground(SystemColor.inactiveCaptionBorder);
		radioButton.setBounds(6, 33, 109, 23);
		panel_2.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Televizor");
		radioButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		radioButton_1.setBounds(6, 59, 109, 23);
		panel_2.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Televizor");
		radioButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		radioButton_2.setBounds(6, 85, 109, 23);
		panel_2.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Televizor");
		radioButton_3.setBackground(SystemColor.inactiveCaptionBorder);
		radioButton_3.setBounds(6, 111, 109, 23);
		panel_2.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("Televizor");
		radioButton_4.setBackground(SystemColor.inactiveCaptionBorder);
		radioButton_4.setBounds(6, 137, 109, 23);
		panel_2.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("Televizor");
		radioButton_5.setBackground(SystemColor.inactiveCaptionBorder);
		radioButton_5.setBounds(6, 163, 109, 23);
		panel_2.add(radioButton_5);
		
		JButton btnDodajSobu = new JButton("Dodaj sobu");
		btnDodajSobu.setBounds(294, 236, 102, 23);
		panel_1.add(btnDodajSobu);
	}
}
