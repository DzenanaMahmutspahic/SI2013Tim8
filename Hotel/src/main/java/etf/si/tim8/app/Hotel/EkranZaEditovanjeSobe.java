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
import javax.swing.DefaultComboBoxModel;

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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Balkon");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(10, 112, 102, 18);
		panel_1.add(chckbxNewCheckBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(79, 11, 115, 20);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(79, 39, 115, 20);
		panel_1.add(spinner_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jednokrevetna", "Dvokrevetna"}));
		comboBox.setBounds(79, 64, 115, 20);
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(79, 89, 115, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnDodajSobu = new JButton("Spasi promjene");
		btnDodajSobu.setBounds(78, 140, 116, 23);
		panel_1.add(btnDodajSobu);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(59, 15, 155, 20);
		panel.add(comboBox_1);
	}
}
