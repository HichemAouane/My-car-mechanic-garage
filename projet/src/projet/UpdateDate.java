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

public class UpdateDate extends JFrame{

	private JPanel contentPane;
	static Connection connection1  ;
	static Statement stmt1  ;
	private ResultSet rs=null ; 
	private JTextField txt2;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDate frame = new UpdateDate(connection1,stmt1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateDate(Connection connection ,Statement stmt) {
		setTitle("Mettre a jour une date d'interventions ");
		Connection connection1 = connection ;
		Statement stmt1 = stmt ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Mise a jour faite avec succes");
		lblNewLabel_5.setForeground(new Color(0, 255, 0));
		lblNewLabel_5.setBounds(380, 271, 171, 26);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JButton btnAfficher = new JButton("Mettre a jour");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt1.executeQuery("UPDATE INTERVENTIONS SET DATEINTERV = '"+txt2.getText()+"' WHERE numintervention ="+textField.getText());
					lblNewLabel_5.setVisible(true);
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
		
		JLabel lblVeuillezSvpInserer = new JLabel("Veuillez svp inserer la nouvelle date et le numero de l'intervention :");
		lblVeuillezSvpInserer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVeuillezSvpInserer.setBounds(65, 85, 594, 50);
		contentPane.add(lblVeuillezSvpInserer);
		
		txt2 = new JTextField();
		txt2.setForeground(new Color(192, 192, 192));
		txt2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setText("DD/MM/YY");
		txt2.setBounds(370, 234, 181, 26);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nouvelle Date :");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(370, 202, 106, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(133, 235, 181, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Num intervention :");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(133, 202, 120, 14);
		contentPane.add(lblNewLabel_2);
		
		
	}
}

