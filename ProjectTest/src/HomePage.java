import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 11, 611, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 611, 99);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDUCATION LEARNING SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(79, 23, 445, 49);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("AL-QURAN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileIOandArraylist f1= new FileIOandArraylist();
				f1.setVisible(true);
			}
		});
		btnNewButton.setBounds(58, 130, 133, 51);
		panel.add(btnNewButton);
		
		JButton btnJava = new JButton("JAVA");
		btnJava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System f2= new System();
				f2.setVisible(true);
				f2.toFront();
			}
		});
		btnJava.setBounds(58, 199, 133, 51);
		panel.add(btnJava);
		
		JButton btnPlanting = new JButton("PLANTING");
		btnPlanting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plant f3= new Plant(null, rootPaneCheckingEnabled);
				f3.setVisible(true);
				f3.toFront();
				
			}
		});
		btnPlanting.setBounds(58, 261, 133, 51);
		panel.add(btnPlanting);
		
		JButton btnGuitar = new JButton("GUITAR");
		btnGuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuitarProjectTest guitar = new GuitarProjectTest();
				guitar.setVisible(true);
				guitar.toFront();
			}
		});
		btnGuitar.setBounds(58, 323, 133, 51);
		panel.add(btnGuitar);
		
		JTextPane txtpnProvideAQuick = new JTextPane();
		txtpnProvideAQuick.setText("Provide a quick learning about Al-Quran");
		txtpnProvideAQuick.setBounds(218, 144, 245, 20);
		panel.add(txtpnProvideAQuick);
		
		JTextPane txtpnProvideAQuick_1 = new JTextPane();
		txtpnProvideAQuick_1.setText("Provide a quick learning about JAVA");
		txtpnProvideAQuick_1.setBounds(218, 215, 245, 20);
		panel.add(txtpnProvideAQuick_1);
		
		JTextPane txtpnProvideAQuick_2 = new JTextPane();
		txtpnProvideAQuick_2.setText("Provide a quick learning about Planting\r\n");
		txtpnProvideAQuick_2.setBounds(218, 279, 245, 20);
		panel.add(txtpnProvideAQuick_2);
		
		JTextPane txtpnProvideAQuick_3 = new JTextPane();
		txtpnProvideAQuick_3.setText("Provide a quick learning about Guitar");
		txtpnProvideAQuick_3.setBounds(218, 338, 245, 20);
		panel.add(txtpnProvideAQuick_3);
	}
}
