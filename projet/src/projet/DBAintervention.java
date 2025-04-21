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

	public class DBAintervention extends JFrame {

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

		public DBAintervention(Connection connection ,Statement stmt) {
			setTitle("Menu principal");
			Connection connection1 = connection ;
			Statement stmt1 = stmt ;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 500);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnrequete4 = new JButton("4.Details interventions");
			btnrequete4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					DetailsInterv lib = new DetailsInterv(connection1,stmt);
					lib.setVisible(true);
				}
			});
			btnrequete4.setBounds(387, 166, 136, 38);
			contentPane.add(btnrequete4);
			
			JButton btnrequete3 = new JButton("3.Lister Vehicule");
			btnrequete3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AffichageVehic list = new AffichageVehic(connection1,stmt);
					list.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete3.setBounds(241, 166, 136, 38);
			contentPane.add(btnrequete3);
			
			JButton btnrequete2 = new JButton("2.Affichage emp");
			btnrequete2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NomPreEmp list = new NomPreEmp(connection1,stmt);
					list.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete2.setBounds(387, 118, 136, 38);
			contentPane.add(btnrequete2);
			
			JButton btnrequete1 = new JButton("1.Update Date");
			btnrequete1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdateDate list = new UpdateDate(connection1,stmt);
					list.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete1.setBounds(241, 118, 136, 38);
			contentPane.add(btnrequete1);
			
			JLabel lblNewLabel = new JLabel("Quelle requete voulez vous utiliser");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(224, 57, 334, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnrequete8= new JButton("8.Lister Interv");
			btnrequete8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListerInterv list = new ListerInterv(connection1,stmt);
					list.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete8.setBounds(387, 263, 136, 38);
			contentPane.add(btnrequete8);
			
			JButton btnrequete7 = new JButton("7.Affiche emp");
			btnrequete7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListerEmp emp = new ListerEmp(connection1,stmt);
					emp.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete7.setBounds(241, 263, 136, 38);
			contentPane.add(btnrequete7);
			
			JButton btnrequete6 = new JButton("6.Affiche Vehicule");
			btnrequete6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListerVehicule veh = new ListerVehicule(connection1,stmt);
					veh.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete6.setBounds(387, 214, 136, 38);
			contentPane.add(btnrequete6);
			
			JButton btnrequete5 = new JButton("5.Affiche mode marq");
			btnrequete5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListerModMar ls = new ListerModMar(connection1,stmt);
					ls.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete5.setBounds(241, 214, 136, 38);
			contentPane.add(btnrequete5);
			
			JButton btnrequete9 = new JButton("9.Interv Periode");
			btnrequete9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IntervMois inte = new IntervMois(connection1,stmt);
					inte.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete9.setBounds(241, 313, 136, 38);
			contentPane.add(btnrequete9);
			
			JButton btnrequete10 = new JButton("Retour");
			btnrequete10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChoixUser ch = new ChoixUser(connection1,stmt);
					ch.setVisible(true);
					setVisible(false);
				}
			});
			btnrequete10.setBounds(387, 313, 136, 38);
			contentPane.add(btnrequete10);
		}
	}
