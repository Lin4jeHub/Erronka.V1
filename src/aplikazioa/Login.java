package Err3;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtErab;
	private JPasswordField JPassword;
	
	// ORRIALDEAREN ID-A
	Login l;
	
	// ARRAYLIST-A SORTU 1
	ArrayList<LangileKudeaketaClass> usuarios;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		
		// CONTENTPANE-A
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 33, 36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ARRAYLIST-A SORTU 2
		usuarios= new ArrayList<LangileKudeaketaClass> ();
	
		// SORTU ERABILTZAIEAK(ADMINISTRATZAILEAK ETA EZ ADMINISTRATZAILEAK)
		LangileKudeaketaClass erab= new LangileKudeaketaClass("Admin","pepe", "Admin123", 4, 4, "a");
		LangileKudeaketaClass erab1= new LangileKudeaketaClass("Langilea","pepe", "Langilea123", 4, 4, "a");
		
		// ARRAYLIST-EAN SARTU
		usuarios.add(erab);
		usuarios.add(erab1);
		
		// LABEL-AK
		JLabel LabelOngiEtorri = new JLabel("Ongi Etorri!");
		LabelOngiEtorri.setBackground(Color.WHITE);
		LabelOngiEtorri.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 32));
		LabelOngiEtorri.setForeground(new Color(237, 207, 82));
		LabelOngiEtorri.setBounds(316, 69, 202, 53);
		contentPane.add(LabelOngiEtorri);
		
		JLabel LabelMesedez = new JLabel("Mesedez sartu zure datuak");
		LabelMesedez.setForeground(new Color(237, 207, 82));
		LabelMesedez.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 32));
		LabelMesedez.setBounds(190, 133, 464, 53);
		contentPane.add(LabelMesedez);
		
		JLabel LabelErab = new JLabel("Erabiltzailea:");
		LabelErab.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		LabelErab.setForeground(new Color(237, 207, 82));
		LabelErab.setBounds(243, 205, 133, 28);
		contentPane.add(LabelErab);
		
		JLabel LabelPasahitza = new JLabel("Pasahitza:");
		LabelPasahitza.setForeground(new Color(237, 207, 82));
		LabelPasahitza.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		LabelPasahitza.setBounds(241, 256, 111, 28);
		contentPane.add(LabelPasahitza);
		
		// ERABILTZAILEA TEXTFIELD
		txtErab = new JTextField();
		txtErab.setForeground(Color.BLACK);
		txtErab.setBackground(Color.WHITE);
		txtErab.setBounds(375, 212, 160, 21);
		contentPane.add(txtErab);
		txtErab.setColumns(10);
		
		// JPASSWORD-A
		JPassword = new JPasswordField();
		JPassword.setBounds(375, 263, 160, 21);
		contentPane.add(JPassword);
		
		// GARBITU BOTOIA 
		JButton ButtonGarbitu = new JButton("Garbitu");
		ButtonGarbitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtErab.setText(null);
				JPassword.setText(null);
			}
		});
		ButtonGarbitu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		ButtonGarbitu.setBackground(new Color(237, 207, 82));
		ButtonGarbitu.setForeground(UIManager.getColor("infoText"));
		ButtonGarbitu.setBounds(277, 312, 89, 23);
		contentPane.add(ButtonGarbitu);
		
		// SARTU BOTOIA
		JButton ButtonSartu = new JButton("Sartu");
		ButtonSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean egokia =false;
				
				char[] clave = JPassword.getPassword();
				String claveFinal = new String(clave);
				for(int i=0; i<usuarios.size();i++) {
					if(txtErab.getText().equals(usuarios.get(i).getIzena()) && claveFinal.equals(usuarios.get(i).getPasahitza())){
						dispose();
							JOptionPane.showMessageDialog(null, "Ongi Etorri", "Barruan zaude", 
									JOptionPane.INFORMATION_MESSAGE);
							Menua m = new Menua(usuarios.get(i).getIzena());
							m.setVisible(true);
							egokia=true;
					}
				}if(!egokia) {
					JOptionPane.showMessageDialog(null, "Datu desegokiak", "Errorea",JOptionPane.ERROR_MESSAGE);
					txtErab.setText("");
					JPassword.setText("");
					txtErab.requestFocus();
				}
				
			}
		});
		ButtonSartu.setForeground(Color.BLACK);
		ButtonSartu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		ButtonSartu.setBackground(new Color(237, 207, 82));
		ButtonSartu.setBounds(417, 312, 89, 23);
		contentPane.add(ButtonSartu);
	}
}
