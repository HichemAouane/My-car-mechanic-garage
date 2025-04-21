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

public class DetailsInterv extends JFrame{

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
					DetailsInterv frame = new DetailsInterv(connection1,stmt1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DetailsInterv(Connection connection ,Statement stmt) {
		setTitle("Affichage de details d'une intervention choisie ");
		Connection connection1 = connection ;
		Statement stmt1 = stmt ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Num Intervention :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 159, 157, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(218, 154, 233, 26);
		contentPane.add(textField);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt1.executeQuery("SELECT * FROM INTERVENTIONS WHERE NUMINTERVENTION = " +textField.getText());
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
		
		JLabel lblVeuillezSvpInserer = new JLabel("Veuillez svp inserer un numero de l'intervention");
		lblVeuillezSvpInserer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVeuillezSvpInserer.setBounds(77, 71, 403, 50);
		contentPane.add(lblVeuillezSvpInserer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 191, 550, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}

