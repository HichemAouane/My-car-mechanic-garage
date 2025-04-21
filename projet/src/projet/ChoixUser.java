package projet;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class ChoixUser extends JFrame {


	private JPanel contentPane;
	static Connection connection1  ;
	static Statement stmt1  ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixUser frame = new ChoixUser(connection1,stmt1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChoixUser(Connection connection ,Statement stmt) {
		setTitle("Choix d'utilisateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choisissez l'utilisateur que vous voulez utiliser :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblNewLabel.setBounds(101, 83, 562, 64);
		contentPane.add(lblNewLabel);
		
		JButton btnrequete1 = new JButton("DBAINTERVENTIONS");
		btnrequete1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnrequete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBAintervention inte = new DBAintervention(connection, stmt);
				inte.setVisible(true);
				setVisible(false);
			}
		});
		btnrequete1.setBounds(197, 241, 167, 38);
		contentPane.add(btnrequete1);

		JButton btnrequete2 = new JButton("EmployesDBA");
		btnrequete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployesDBA emp = new EmployesDBA(connection, stmt);
				emp.setVisible(true);
				setVisible(false);
			}
		});
		btnrequete2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnrequete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnrequete2.setBounds(403, 241, 167, 38);
		contentPane.add(btnrequete2);
	}
}
