package projet;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;

public class ConnetionBDD extends JFrame{
	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JPasswordField passwordField;
	private Connection connection=null ; 
	private Statement stmt= null ;
	private ResultSet rs=null ; 

	private JFrame frame;
	private JTextField userField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnetionBDD frame = new ConnetionBDD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ConnetionBDD() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Connection au base de donnee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Veuillez svp inserer votre Username et Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(181, 152, 436, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD* :");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_2.setBounds(170, 276, 102, 49);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(282, 276, 174, 39);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Warning : Username or Password incorrect");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lblNewLabel_3.setBounds(249, 336, 260, 24);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user = userField.getText();
					String psw = passwordField.getText();
					lblNewLabel_3.setVisible(false);
							Class.forName("oracle.jdbc.driver.OracleDriver") ;
						    connection = DriverManager.getConnection("jdbc:oracle:thin:"+user+"/"+psw+"@localhost");
						    stmt = connection.createStatement();
						    System.out.print("DBAINTERVENTION connected");
						    ChoixUser men = new ChoixUser(connection,stmt);
						    men.setVisible(true);
						    
						    setVisible(false);
				
					}
					catch (Exception ex ){ ex.printStackTrace();lblNewLabel_3.setVisible(true);}
					
			}
		});
		btnNewButton.setBounds(526, 386, 120, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(656, 386, 120, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Bienvenu dans la base de donnees DBAINTERVENTION");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBackground(Color.DARK_GRAY);
		lblNewLabel_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_5.setBounds(21, 23, 596, 69);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Aouane Hichem - Agrane Sabrina");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(32, 371, 207, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("212131078847 - 212131075653");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(32, 406, 196, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("ACAD B");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(103, 431, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		 Image img = new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		 lblNewLabel_7.setIcon(new ImageIcon(img));
		lblNewLabel_7.setBounds(644, 11, 142, 119);
		contentPane.add(lblNewLabel_7);
		
		userField = new JTextField();
		userField.setBounds(282, 212, 174, 39);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("USERNAME* :");
		lblNewLabel_8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(170, 212, 102, 33);
		contentPane.add(lblNewLabel_8);
	}
}
