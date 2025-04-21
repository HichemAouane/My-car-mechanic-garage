package projet;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Consultation extends JFrame{
	private JPanel contentPane;
	static Connection connection1  ;
	static Statement stmt1  ;
	private ResultSet rs=null ; 
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultation frame = new Consultation(connection1,stmt1);
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
	public Consultation(Connection connection ,Statement stmt) {
		Connection connection1 = connection ;
		Statement stmt1 = stmt ;
		setTitle("Consultation Employes et Intervenants");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);
		
		JButton btnAfficher = new JButton("Afficher Employe");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt1.executeQuery("SELECT * FROM EMPLOYE");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex) {
					ex.printStackTrace(); 
				}
			}
		});
		btnAfficher.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAfficher.setBounds(611, 191, 132, 40);
		contentPane.add(btnAfficher);
		
		JButton btnAfficher1 = new JButton("Afficher Intevenants");
		btnAfficher1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt1.executeQuery("SELECT * FROM INTERVENANTS");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex) {
					ex.printStackTrace(); 
				}
			}
		});
		btnAfficher1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAfficher1.setBounds(611, 242, 132, 40);
		contentPane.add(btnAfficher1);
		
		
		JButton btnAfficher2 = new JButton("Retour");
		btnAfficher2.addActionListener(new ActionListener() {
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
		btnAfficher2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAfficher2.setBounds(611, 294, 132, 40);
		contentPane.add(btnAfficher2);
		
		
		JLabel lblVeuillezSvpInserer = new JLabel("Choisissez quel table voulez vous consulter: ");
		lblVeuillezSvpInserer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVeuillezSvpInserer.setBounds(51, 103, 512, 50);
		contentPane.add(lblVeuillezSvpInserer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 191, 550, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}

}
