package guiLibrairie;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import daoLibrairie.ThemeDAO;
import entitiesLibrairie.Theme;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JInternalFrameTheme extends JInternalFrame {
	private JTextField textField;
	private Theme theme = new Theme();
	private ThemeDAO themeDAO = new ThemeDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInternalFrameTheme frame = new JInternalFrameTheme();
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
	public JInternalFrameTheme() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thème à ajouter :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-76, 48, 311, 23);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(148, 47, 280, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = textField.getText();
					themeDAO.ajouterTheme(nom);
					JOptionPane.showMessageDialog(null, "Nouveau thème ajouté avec succès", "Nouveau thème", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnNewButton.setBounds(311, 85, 117, 29);
		getContentPane().add(btnNewButton);
		setBounds(-15, -30, 492, 420);

	}

}