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
import javax.swing.SwingConstants;
import java.awt.Color;

public class IntervMois extends JFrame{

	private JPanel contentPane;
	static Connection connection1  ;
	static Statement stmt1  ;
	private ResultSet rs=null ; 
	private JTextField txt1;
	private JTable table; 
	private JTextField txt2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntervMois frame = new IntervMois(connection1,stmt1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IntervMois(Connection connection ,Statement stmt) {
		setTitle("Les interventions faites dans une periode donnée ");
		Connection connection1 = connection ;
		Statement stmt1 = stmt ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Date debut :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 159, 120, 21);
		contentPane.add(lblNewLabel_1);
		
		txt1 = new JTextField();
		txt1.setForeground(new Color(192, 192, 192));
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setText("DD/MM/YY");
		txt1.setColumns(10);
		txt1.setBounds(145, 158, 181, 26);
		contentPane.add(txt1);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt1.executeQuery("SELECT * FROM interventions WHERE dateinterv >= TO_DATE('"+txt1.getText()+"', 'dd/mm/yy') AND datefininterv < TO_DATE('"+txt2.getText()+"', 'dd/mm/yy')");
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
		
		JLabel lblVeuillezSvpInserer = new JLabel("Veuillez svp inserer les deux dates :");
		lblVeuillezSvpInserer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVeuillezSvpInserer.setBounds(145, 78, 358, 50);
		contentPane.add(lblVeuillezSvpInserer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 191, 550, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txt2 = new JTextField();
		txt2.setForeground(new Color(192, 192, 192));
		txt2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setText("DD/MM/YY");
		txt2.setBounds(413, 158, 181, 26);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date fin :");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(341, 166, 62, 14);
		contentPane.add(lblNewLabel);
	}
}

