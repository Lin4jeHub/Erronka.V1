package aplikazioa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Menua extends JFrame {

	private JPanel contentPane;

	// ORRIALDEAREN ID-A
	Menua M;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menua frame = new Menua("Admin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menua(String usuarios) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 467);

		// BACKGROUND-A
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 33, 36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// MENU BARRA
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(237, 207, 82));
		setJMenuBar(menuBar);

		// KUDEATU BOTOIA
		JMenu JMenuKudeatu = new JMenu("Kudeatu");
		menuBar.add(JMenuKudeatu);

		// LANGILEAK BOTOIA(ADMIN ONLY)
		JMenuItem JMILangileak = new JMenuItem("Langileak");
		JMILangileak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LangileKudeaketa lk = new LangileKudeaketa();
				lk.setVisible(true);
				setVisible(false);
			}

		});
		JMenuKudeatu.add(JMILangileak);
		if (usuarios.equals("Admin")) {
			JMILangileak.setEnabled(true);
		} else {
			JMILangileak.setEnabled(false);
		}

		// BEZEROAK BOTOIA
		JMenuItem JMIBezeroak = new JMenuItem("Bezeroak");
		JMenuKudeatu.add(JMIBezeroak);
		
		// FAKTUAK BOTOIA
		JMenu JMenuFakturak = new JMenu("Fakturak");
		menuBar.add(JMenuFakturak);

		// SORTU BOTOIA
		JMenuItem JMISortu = new JMenuItem("Sortu");
		JMenuFakturak.add(JMISortu);

		// IKUSI BOTOIA
		JMenuItem JMIIkusi = new JMenuItem("Ikusi");
		JMenuFakturak.add(JMIIkusi);
		
		// ITXI SAIOA BOTOIA
		JButton ButtonItxiSaioa = new JButton("Itxi Saioa");
		ButtonItxiSaioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});
		ButtonItxiSaioa.setForeground(Color.BLACK);
		ButtonItxiSaioa.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		ButtonItxiSaioa.setBackground(new Color(237, 207, 82));
		ButtonItxiSaioa.setBounds(10, 375, 89, 23);
		contentPane.add(ButtonItxiSaioa);
	}
}
