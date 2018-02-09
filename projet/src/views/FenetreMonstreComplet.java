package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Monstre;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class FenetreMonstreComplet extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5378233502356265803L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FenetreMonstreComplet(Monstre monstre) {
		setTitle("Nom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnMob = new JTextPane();
		txtpnMob.setEditable(false);
		txtpnMob.setText(monstre.toString());
		txtpnMob.setBounds(92, 65, 254, 149);
		contentPane.add(txtpnMob);
	}
}
