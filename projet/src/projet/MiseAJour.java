package projet;


import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MiseAJour extends JFrame{
	private JPanel contentPane;
	static Connection connection1  ;
	static Statement stmt1  ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiseAJour frame = new MiseAJour(connection1,stmt1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiseAJour(Connection connection ,Statement stmt) {
		setTitle("Mettre a jour les info d'un employe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(217, 167,163, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 206, 163, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(217, 248, 163, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(217, 291, 163, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(217, 333, 163, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Num Employe* :");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(92, 172, 99, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom* :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(92, 211, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom* :");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(92, 253, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categorie* :");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(92, 296, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salaire* :");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(92, 338, 61, 14);
		contentPane.add(lblNewLabel_4);
		
		Connection connection1 = connection ;
		Statement stmt1 = stmt ;
		
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EmployesDBA ch = new EmployesDBA(connection, stmt);
					ch.setVisible(true);
					setVisible(false);
				}
				catch(Exception ex) {
					ex.printStackTrace(); 
				}
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRetour.setBounds(490, 294, 120, 40);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel_5 = new JLabel("Mise a jour faite avec succes");
		lblNewLabel_5.setForeground(new Color(0, 255, 0));
		lblNewLabel_5.setBounds(217, 374, 163, 14);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField.setText("");
				lblNewLabel_5.setVisible(false);
			} //si il choisis annuler on vide les champs  textes 
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAnnuler.setBounds(490, 238, 120, 40);
		contentPane.add(btnAnnuler);
		
		
		
		
		
		JButton btnMaj = new JButton("Mettre a jour");
		btnMaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String numemp = textField.getText();
					String nomEmploye = "'"+textField_1.getText()+"'";
				    String prenomEmploye  = "'"+textField_2.getText()+"'";
				    String salaire = textField_4.getText();
				    String cat = "'"+textField_3.getText()+"'";
				    stmt1.executeUpdate("UPDATE EMPLOYE SET NOMEMP = "+nomEmploye+", PRENOMEMP = "+prenomEmploye+", CATEGORIE = "+cat+", SALAIRE = "+ salaire +"WHERE NUMEMPLOYE = "+numemp);
				    lblNewLabel_5.setVisible(true);
				    
				}
				catch(Exception ex) {
					lblNewLabel_5.setVisible(false);
					ex.printStackTrace(); 
					
					
				}
			} //si il choisis annuler on vide les champs  textes 
		});
		
		
		btnMaj.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMaj.setBounds(490, 186, 120, 40);
		contentPane.add(btnMaj);
		JLabel lblVeuillezSvpInserer_1 = new JLabel("Veuillez inserer le numero de lemploye pour lequel vous voulez mettre a jour ses infos :");
		lblVeuillezSvpInserer_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVeuillezSvpInserer_1.setBounds(23, 91, 753, 40);
		contentPane.add(lblVeuillezSvpInserer_1);
		
		
		
		
	}


		
	}


