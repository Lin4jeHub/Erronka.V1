package aplikazioa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LangileKudeaketa extends JFrame {

	private JPanel contentPane;

	// ORRIALDEAREN ID-A
		LangileKudeaketa lk;
		private JTextField TF_Izena;
		private JTextField TF_Abizena;
		private JTextField TF_Tlfn;
		private JTextField TF_Mota;
		private JTextField TF_HE;
		
		private String Izena;
		private String Abizena;
		private String Telefonoa;
		private String Mota;
		private String HE;
		
		private ResultSet rs;
		private Statement st;
		
		private LangileKudeaketaClass datuak;
		

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LangileKudeaketa frame = new LangileKudeaketa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LangileKudeaketa() throws SQLException {
		// BACKGROUND-A
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 33, 36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				// LABEL-AK
		//Izena
		JLabel LabelIzena = new JLabel("Izena");
		LabelIzena.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		LabelIzena.setForeground(new Color(237, 207, 82));
		LabelIzena.setBounds(73, 10, 66, 26);
		contentPane.add(LabelIzena);
		
		//Abizena
		JLabel LabelAbizena = new JLabel("Abizena");
		LabelAbizena.setForeground(new Color(237, 207, 82));
		LabelAbizena.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		LabelAbizena.setBounds(218, 10, 90, 26);
		contentPane.add(LabelAbizena);
		
		//Telefonoa
		JLabel LabelTlfn = new JLabel("Telefonoa");
		LabelTlfn.setForeground(new Color(237, 207, 82));
		LabelTlfn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		LabelTlfn.setBounds(379, 10, 106, 26);
		contentPane.add(LabelTlfn);
		
		//Mota
		JLabel LabelMota = new JLabel("Mota");
		LabelMota.setForeground(new Color(237, 207, 82));
		LabelMota.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		LabelMota.setBounds(561, 10, 59, 26);
		contentPane.add(LabelMota);
		
		//Helbide Elektronikoa
		JLabel LabelHE = new JLabel("Helbide elek");
		LabelHE.setForeground(new Color(237, 207, 82));
		LabelHE.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		LabelHE.setBounds(720, 10, 118, 26);
		contentPane.add(LabelHE);
		
				// TEXTFIELD-AK
		//Izena
		TF_Izena = new JTextField();
		TF_Izena.setBackground(new Color(183, 183, 183));
		TF_Izena.setBounds(29, 46, 154, 21);
		contentPane.add(TF_Izena);
		TF_Izena.setColumns(10);
		
		//Abizena
		TF_Abizena = new JTextField();
		TF_Abizena.setColumns(10);
		TF_Abizena.setBackground(new Color(183, 183, 183));
		TF_Abizena.setBounds(193, 46, 154, 21);
		contentPane.add(TF_Abizena);
		
		//Telefonoa
		TF_Tlfn = new JTextField();
		TF_Tlfn.setColumns(10);
		TF_Tlfn.setBackground(new Color(183, 183, 183));
		TF_Tlfn.setBounds(357, 46, 154, 21);
		contentPane.add(TF_Tlfn);
		
		//Mota
		TF_Mota = new JTextField();
		TF_Mota.setColumns(10);
		TF_Mota.setBackground(new Color(183, 183, 183));
		TF_Mota.setBounds(521, 47, 154, 21);
		contentPane.add(TF_Mota);
		
		//Helbide Elektronikoa
		TF_HE = new JTextField();
		TF_HE.setColumns(10);
		TF_HE.setBackground(new Color(183, 183, 183));
		TF_HE.setBounds(685, 47, 203, 21);
		contentPane.add(TF_HE);
		
				// JLIST-AK
		// IZENA
		JList JL_Izena = new JList();
		JL_Izena.setBackground(new Color(183, 183, 183));
		JL_Izena.setBounds(29, 79, 154, 290);
		contentPane.add(JL_Izena);
		
		//Abizena
		JList JL_Abizenak = new JList();
		JL_Abizenak.setBackground(new Color(183, 183, 183));
		JL_Abizenak.setBounds(193, 79, 154, 290);
		contentPane.add(JL_Abizenak);
		
		//Telefonoa
		JList JL_Tlfn = new JList();
		JL_Tlfn.setBackground(new Color(183, 183, 183));
		JL_Tlfn.setBounds(357, 79, 154, 290);
		contentPane.add(JL_Tlfn);
		
		//Mota
		JList JL_Mota = new JList();
		JL_Mota.setBackground(new Color(183, 183, 183));
		JL_Mota.setBounds(521, 79, 154, 290);
		contentPane.add(JL_Mota);
		
		//Helbide Elektronikoa
		JList JL_HE = new JList();
		JL_HE.setBackground(new Color(183, 183, 183));
		JL_HE.setBounds(685, 79, 203, 290);
		contentPane.add(JL_HE);
		
				// BOTOIAK:
		// Atzera
		JButton ButtonAtzera = new JButton("Atzera");
		ButtonAtzera.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		ButtonAtzera.setBackground(new Color(237, 207, 82));
		ButtonAtzera.setBounds(10, 428, 85, 21);
		contentPane.add(ButtonAtzera);
		
		//Gorde
		JButton ButtonGorde = new JButton("Gorde");
		ButtonGorde.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		ButtonGorde.setBackground(new Color(237, 207, 82));
		ButtonGorde.setBounds(305, 389, 85, 21);
		contentPane.add(ButtonGorde);
		
		//Editatu
		JButton ButtonEditatu = new JButton("Editatu");
		ButtonEditatu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		ButtonEditatu.setBackground(new Color(237, 207, 82));
		ButtonEditatu.setBounds(400, 389, 85, 21);
		contentPane.add(ButtonEditatu);
		
		//Ezabatu
		JButton ButtonEzabatu = new JButton("Editatu");
		ButtonEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonEzabatu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		ButtonEzabatu.setBackground(new Color(237, 207, 82));
		ButtonEzabatu.setBounds(495, 389, 85, 21);
		contentPane.add(ButtonEzabatu);
		
		DatuakHartu();
	}
	
	private void DatuakHartu() throws SQLException
	{
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	//SQL-rekin konexioa hasteko
	java.sql.Connection konexioa;
	konexioa= DriverManager.getConnection("jdbc:mysql://localhost/3_erronka", "root", "");

	//Statement-a sortzeko
	st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

	//Resultset-a sortzeko eta select kontsulta exekutatzeko
	rs = st.executeQuery("SELECT * FROM erabiltzaileak ");

	//Lehenengo pozizioa aukeratzeko
	rs.first();
	DatuakEraikitu();

	while(rs.next())
	{
	//SQL-n dauden datuak hartzeko eta objetu batean eraikitzeko
	DatuakEraikitu();


	}

	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}

	private void DatuakEraikitu() throws SQLException
	{
	    //Nahi ditugun zutabearen datuak autatzeko
	    Izena = rs.getObject("Izena").toString();
	    Abizena = rs.getObject("Abizena").toString();
	    Telefonoa = rs.getObject("Telefonoa").toString();
	    Mota = rs.getObject("Mota").toString();
	    HE = rs.getObject("HE").toString();
	    
	    int TelefonoaInt = Integer.parseInt(Telefonoa);
	    int MotaInt = Integer.parseInt(Mota);
	    
	//Aurreko datuen informazioa objetua eraikitzeko
	   datuak = new LangileKudeaketaClass(Izena, Abizena, TelefonoaInt, MotaInt, HE);
	}
}
