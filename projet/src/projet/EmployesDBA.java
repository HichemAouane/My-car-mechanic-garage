package projet;



	import java.awt.EventQueue;
	import java.sql.Connection;
	import java.sql.Statement;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import java.awt.Font;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

	public class EmployesDBA extends JFrame {

		private JPanel contentPane;
		static Connection connection1  ;
		static Statement stmt1  ;

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						EmployesDBA frame = new EmployesDBA(connection1,stmt1);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public EmployesDBA(Connection connection ,Statement stmt) {
			setTitle("EmployesDBA");
			Connection connection1 = connection ;
			Statement stmt1 = stmt ;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 500);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnrequete2 = new JButton("Mise a jour");
			btnrequete2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			btnrequete2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MiseAJour maj = new MiseAJour(connection1,stmt);
					maj.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete2.setBounds(391, 181, 136, 38);
			contentPane.add(btnrequete2);
			
			JButton btnrequete1 = new JButton("Ajout EMP");
			btnrequete1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			btnrequete1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AjoutEmploye aj = new AjoutEmploye(connection1,stmt);
					aj.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete1.setBounds(233, 181, 136, 38);
			contentPane.add(btnrequete1);
			
			JButton btnrequete3 = new JButton("Consulter");
			btnrequete3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			btnrequete1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			btnrequete3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Consultation consu =new Consultation(connection1,stmt);
					consu.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete3.setBounds(312, 244, 136, 38);
			contentPane.add(btnrequete3);
			
			JLabel lblNewLabel = new JLabel("Quelle requete voulez vous utiliser");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(222, 113, 334, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("Retour");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ChoixUser ch = new ChoixUser(connection, stmt);
						ch.setVisible(true);
						setVisible(false);
					}
					catch(Exception ex) {
						ex.printStackTrace(); 
					}
				}
			});
			btnNewButton.setBounds(312, 319, 136, 38);
			contentPane.add(btnNewButton);
		}
	}
