package views;

import javax.swing.JFrame;
import models.Monstre;

import javax.swing.JScrollPane;

public class FenetreMonstre extends JFrame {

	private static final long serialVersionUID = 5916356950208824924L;
	private JScrollPane contentPane;
	/**
	 * Create the frame.
	 */
	public FenetreMonstre(Monstre[] monstres) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanneauMonstre panel = new PanneauMonstre(monstres);
		contentPane = new JScrollPane(panel);
		contentPane.getVerticalScrollBar().setUnitIncrement(20);
		add(contentPane);
	}

}
