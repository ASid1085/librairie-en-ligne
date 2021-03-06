package guiLibrairie;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import daoLibrairie.ThemeDAO;
import daoLibrairie.daoMotCle;
import entitiesLibrairie.Editeur;
import entitiesLibrairie.MotCle;
import entitiesLibrairie.Theme;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameNvTheme extends JFrame {
	private JTextField textField;
	private JPanel contentPane;
	private Theme theme = new Theme();
	private ThemeDAO themeDAO = new ThemeDAO();
	private daoMotCle daoMc = new daoMotCle();
	private JTextField txtThemeId;
	private JTextField txtThemeLib;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameNvTheme frame = new JFrameNvTheme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameNvTheme() {
		
		
		getContentPane().setBackground(new Color(255, 248, 220));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thème à ajouter :");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-76, 48, 311, 23);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(148, 47, 280, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		setTitle("Thème");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 369);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThemeId = new JLabel("Thème Id : ");
		lblThemeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThemeId.setFont(new Font("Avenir Next", Font.PLAIN, 13));
		lblThemeId.setBounds(33, 60, 83, 16);
		contentPane.add(lblThemeId);
		
		JLabel lblThemeLib = new JLabel("Thème Libellé :");
		lblThemeLib.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThemeLib.setFont(new Font("Avenir Next", Font.PLAIN, 13));
		lblThemeLib.setBounds(19, 170, 97, 16);
		contentPane.add(lblThemeLib);
		
		txtThemeLib = new JTextField();
		txtThemeLib.setBounds(150, 165, 189, 26);
		txtThemeLib.setFont(new Font("Avenir Next", Font.PLAIN, 13));
		contentPane.add(txtThemeLib);
		txtThemeLib.setColumns(10);
		
		txtThemeId = new JTextField();
		txtThemeId.setBounds(150, 55, 189, 26);
		txtThemeId.setEnabled( false);
		txtThemeId.setFont(new Font("Avenir Next", Font.PLAIN, 13));
		try {
			txtThemeId.setText( themeDAO.ajoutIdTheme());
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		txtThemeId.setEnabled(false);
		contentPane.add(txtThemeId);
		txtThemeId.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = txtThemeLib.getText();
				String id = txtThemeId.getText();
				String idMc = daoMc.ajoutIdMotCle();
				MotCle mc = new MotCle( idMc, nom);
				try {
					themeDAO.ajouterTheme(id, nom);
					daoMc.ajouterMotCle( mc);
					JOptionPane.showMessageDialog(contentPane, "Nouveau thème ajouté avec succès", "Nouveau thème", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnValider.setFont(new Font("Avenir Next", Font.PLAIN, 15));
		btnValider.setBorder(BorderFactory.createMatteBorder(3, 0, 3, 0, Color.ORANGE));
		btnValider.setBounds(69, 256, 97, 41);
		contentPane.add(btnValider);
		
		/*JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAnnuler.setBorder(BorderFactory.createMatteBorder(3, 0, 3, 0, Color.ORANGE));
		btnAnnuler.setBounds(69, 256, 97, 41);
		btnAnnuler.setBounds(258, 257, 97, 41);
		contentPane.add(btnAnnuler);*/
	}

}
