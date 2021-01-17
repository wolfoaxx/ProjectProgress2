import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class GuitarProjectTest extends JFrame {

	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField LastName;
	private JTable table;
	private JFrame frame1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuitarProjectTest frame = new GuitarProjectTest();
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
	public GuitarProjectTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 875, 460);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home Page", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(205, 133, 63));
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new MatteBorder(6, 7, 5, 5, (Color) new Color(205, 133, 63)));
		panel_2.setBounds(0, 0, 870, 436);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guitar Learning System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(167, 22, 440, 49);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 93, 86, 27);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblLastName.setBounds(10, 131, 86, 27);
		panel_2.add(lblLastName);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblRace.setBounds(10, 169, 86, 27);
		panel_2.add(lblRace);
		
		JLabel lblSessionTime = new JLabel("Session Time");
		lblSessionTime.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblSessionTime.setBounds(10, 207, 86, 27);
		panel_2.add(lblSessionTime);
		
		FirstName = new JTextField();
		FirstName.setBounds(121, 99, 131, 20);
		panel_2.add(FirstName);
		FirstName.setColumns(10);
		
		LastName = new JTextField();
		LastName.setColumns(10);
		LastName.setBounds(121, 137, 131, 20);
		panel_2.add(LastName);
		
		JComboBox Race = new JComboBox();
		Race.setModel(new DefaultComboBoxModel(new String[] {"Please Select:", "Malay", "Indian", "Chinese", "Other"}));
		Race.setBounds(121, 175, 131, 20);
		panel_2.add(Race);
		
		JComboBox SessionTime = new JComboBox();
		SessionTime.setModel(new DefaultComboBoxModel(new String[] {"Please Select:", "1Hour", "2Hours", "3Hours", "4Hours"}));
		SessionTime.setBounds(121, 213, 131, 20);
		panel_2.add(SessionTime);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{
						FirstName.getText(),
						LastName.getText(),
						Race.getSelectedItem(),
						SessionTime.getSelectedItem(),
					
						
					
		
				
				});
				
				if (table.getSelectedRow() == -1) {
					if(table.getRowCount()== 0) {
						JOptionPane.showMessageDialog(null, "Information Update!","Guitar Learning System",
								JOptionPane.OK_OPTION);
					}
				}
			}
		});
			
		
		btnNewButton.setBounds(10, 312, 102, 34);
		panel_2.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FirstName.setText("");
				LastName.setText("");
				Race.setSelectedItem("Please Select:");
				SessionTime.setSelectedItem("Please Select:");
				
			}
		});
		btnReset.setBounds(154, 312, 102, 34);
		panel_2.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 99, 508, 247);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Race", "Session Time"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRow()==-1) {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No data available","Guitar Learning System",
								JOptionPane.OK_OPTION);}
					else {
						JOptionPane.showMessageDialog(null, "Select a row to delete","Guitar Learning System",
								JOptionPane.OK_OPTION);}
				}
				
					else {
						model.removeRow(table.getSelectedRow());
						
					
				}
			}
		});
		
		btnDelete.setBounds(79, 357, 102, 34);
		panel_2.add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("Import Saved Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filePath="C:\\Users\\yon\\eclipse-workspace\\ProjectTest\\test.txt";
				File file = new File(filePath);
				
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					Object[] lines =br.lines().toArray();
					
					for(int i = 0; i<lines.length; i++) {
						String[] row=lines[i].toString().split(" ");
						model.addRow(row);
					}
					
				}
			
			catch(FileNotFoundException ex){
					Logger.getLogger(GuitarProjectTest.class.getName()).log(Level.SEVERE,null,ex);
					
			}
			}
		});
		btnNewButton_1.setBounds(279, 378, 136, 23);
		panel_2.add(btnNewButton_1);
		
		JButton btnPrint = new JButton("Save");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath="C:\\Users\\yon\\eclipse-workspace\\ProjectTest\\test.txt";
				File file = new File(filePath);
				
				try {
					FileWriter fw=new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i= 0; i<table.getRowCount(); i++) {
						for(int j=0; j<table.getColumnCount();j++) {
							bw.write(table.getValueAt(i, j).toString()+" ");
						}
						bw.newLine();
					}
					bw.close();
					fw.close();
				} catch(IOException ex) {
					Logger.getLogger(GuitarProjectTest.class.getName()).log(Level.SEVERE,null,ex);
				}
				
				
			}
		});
		btnPrint.setBounds(445, 378, 89, 23);
		panel_2.add(btnPrint);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame1 = new JFrame();
				if (JOptionPane.showConfirmDialog(frame1, "Confirm If You Want To Exit","Guitar Learning System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
					
				}
			}
		});
		btnNewButton_2.setBounds(748, 378, 89, 23);
		panel_2.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Guitar Strings", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(205, 133, 63));
		panel_3.setBounds(0, 0, 870, 436);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Knowing Your Guitar Strings\r\n");
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(216, 11, 328, 23);
		panel_3.add(lblNewLabel_2);
		
		JLabel GuitarImage = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/guitarStrings1.png")).getImage();
		GuitarImage.setIcon(new ImageIcon(img));
		GuitarImage.setBounds(242, 43, 250, 185);
		panel_3.add(GuitarImage);
		
		JTextPane txtpnSaduCanEven = new JTextPane();
		txtpnSaduCanEven.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnSaduCanEven.setText("The order is EADGBE, from the lowest (bottom) string to the highest. Before you begin to really commit this to heart, it might be helpful to have some phrases to match the acronym. Here's a few popular ones:\r\n\r\n-Eddie Ate Dynamite Good Bye Eddie\r\n-Elephants And Donkeys Grow Big Ears\r\n-Eventually America Defied Great Britain's Empire\r\n-Eat All Day Go to Bed Early");
		txtpnSaduCanEven.setBackground(new Color(210, 105, 30));
		txtpnSaduCanEven.setForeground(new Color(0, 0, 0));
		txtpnSaduCanEven.setBounds(10, 233, 850, 146);
		panel_3.add(txtpnSaduCanEven);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Chord", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(205, 133, 63));
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		panel_5.setBounds(0, 0, 870, 436);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Guitar Chord");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(283, 11, 191, 57);
		panel_5.add(lblNewLabel_3);
		
		JTextPane txtpnOneOfThe = new JTextPane();
		txtpnOneOfThe.setBackground(new Color(210, 105, 30));
		txtpnOneOfThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnOneOfThe.setText("One of the first skills that all guitarists learn is how to read a chord diagram. These diagrams are very helpful when it comes to showing chord shapes and their fingerings. Fortunately for us, it\u2019s also a very easy skill to pick up and you\u2019ll be reading chord diagrams like a pro by the end of this lesson!\r\n\r\n");
		txtpnOneOfThe.setBounds(10, 59, 831, 66);
		panel_5.add(txtpnOneOfThe);
		
		JLabel Estring = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/Estring1.png")).getImage();
		Estring.setIcon(new ImageIcon(img1));
		Estring.setBounds(20, 127, 140, 201);
		panel_5.add(Estring);
		
		JLabel Dstring = new JLabel("New label");
		Image img2= new ImageIcon(this.getClass().getResource("/Dstring.png")).getImage();
		Dstring.setIcon(new ImageIcon(img2));
		Dstring.setBounds(170, 127, 140, 201);
		panel_5.add(Dstring);
		
		JLabel chord = new JLabel("");
		Image img3= new ImageIcon(this.getClass().getResource("/chord1.png")).getImage();
		chord.setIcon(new ImageIcon(img3));
		chord.setBounds(317, 121, 494, 207);
		panel_5.add(chord);
		
		JTextPane txtpnTheNumbersAre = new JTextPane();
		txtpnTheNumbersAre.setText("The numbers are telling you which finger you are going to use. The fingers on your left hand are numbered from one through four. Here is what each number represents:\r\n1 - Index Finger || 2 - Middle Finger || 3 - Ring Finger || 4 - Pinky Finger\r\n\r\n\r\n");
		txtpnTheNumbersAre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnTheNumbersAre.setBackground(new Color(210, 105, 30));
		txtpnTheNumbersAre.setBounds(10, 328, 831, 77);
		panel_5.add(txtpnTheNumbersAre);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Strumming", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(205, 133, 63));
		panel_7.setBounds(10, 0, 860, 436);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("HOW TO STRUM?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(27, 11, 374, 56);
		panel_7.add(lblNewLabel_4);
		
		JTextPane txtpnWhileItsImportant = new JTextPane();
		txtpnWhileItsImportant.setText("While it\u2019s important to learn the rudiments and scales when you\u2019re learning to play the guitar, the fun part is when you can start strumming. With a little practice and proper technique, you might be able to start playing songs you recognize sooner than you think\r\n\r\n");
		txtpnWhileItsImportant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnWhileItsImportant.setBackground(new Color(210, 105, 30));
		txtpnWhileItsImportant.setBounds(10, 78, 806, 66);
		panel_7.add(txtpnWhileItsImportant);
		
		JLabel Strum = new JLabel("");
		Image img4= new ImageIcon(this.getClass().getResource("/guitarstrum.png")).getImage();
		Strum.setIcon(new ImageIcon(img4));
		Strum.setBounds(27, 155, 268, 168);
		panel_7.add(Strum);
		
		JLabel patternGuide = new JLabel("");
		Image img5= new ImageIcon(this.getClass().getResource("/patternguide2.png")).getImage();
		patternGuide.setIcon(new ImageIcon(img5));
		patternGuide.setBounds(684, 158, 166, 72);
		panel_7.add(patternGuide);
		
		JTextPane txtpnThisIsThe = new JTextPane();
		txtpnThisIsThe.setText("This is the example of strumming up and down on the guitar.");
		txtpnThisIsThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnThisIsThe.setBackground(new Color(210, 105, 30));
		txtpnThisIsThe.setBounds(26, 334, 269, 44);
		panel_7.add(txtpnThisIsThe);
		
		JTextPane txtpnStrummingGuide = new JTextPane();
		txtpnStrummingGuide.setText("Strumming guide");
		txtpnStrummingGuide.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnStrummingGuide.setBackground(new Color(210, 105, 30));
		txtpnStrummingGuide.setBounds(712, 226, 115, 25);
		panel_7.add(txtpnStrummingGuide);
		
		JLabel pattern1 = new JLabel("");
		Image img6= new ImageIcon(this.getClass().getResource("/patterndown.png")).getImage();
		pattern1.setIcon(new ImageIcon(img6));
		pattern1.setBounds(315, 164, 359, 66);
		panel_7.add(pattern1);
		
		JLabel pattern2 = new JLabel("New label");
		Image img7= new ImageIcon(this.getClass().getResource("/patternupdown.png")).getImage();
		pattern2.setIcon(new ImageIcon(img7));
		pattern2.setBounds(315, 255, 359, 66);
		panel_7.add(pattern2);
		
		JLabel pattern3 = new JLabel("New label");
		Image img8= new ImageIcon(this.getClass().getResource("/pattern3.png")).getImage();
		pattern3.setIcon(new ImageIcon(img8));
		pattern3.setBounds(315, 341, 359, 63);
		panel_7.add(pattern3);
	}
}
