package projet;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


	public class AffichageVehic extends JFrame{

		private JPanel contentPane;
		static Connection connection1  ;
		static Statement stmt1  ;
		private ResultSet rs=null ; 
		private JTextField textField;
		private JTable table; 
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AffichageVehic frame = new AffichageVehic(connection1,stmt1);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public AffichageVehic(Connection connection ,Statement stmt) {
			setTitle(" Liste des vehiculs");
			Connection connection1 = connection ;
			Statement stmt1 = stmt ;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 500);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnAfficher = new JButton("Afficher");
			btnAfficher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						rs = stmt1.executeQuery("SELECT * FROM VEHICULE");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex) {
						ex.printStackTrace(); 
					}
				}
			});
			btnAfficher.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnAfficher.setBounds(611, 191, 120, 40);
			contentPane.add(btnAfficher);
			
			JButton btnQuittez = new JButton("Retour");
			btnQuittez.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DBAintervention admin = new DBAintervention(connection1,stmt1);
					admin.setVisible(true);
					setVisible(false);
				}
			});
			btnQuittez.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnQuittez.setBounds(611, 241, 120, 40);
			contentPane.add(btnQuittez);
			
			JLabel lblVeuillezSvpInserer = new JLabel("Liste des vehiculs :");
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
