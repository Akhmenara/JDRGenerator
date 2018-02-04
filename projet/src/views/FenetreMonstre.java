package views;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;



import models.Monstre;

public class FenetreMonstre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel[] labelStats = { new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(),
			new JLabel() };
	private JLabel labelNom = new JLabel();
	private JPanel panMonstre = new JPanel();
	/**
	 * Create the frame.
	 */
	public FenetreMonstre(Monstre monstre) {
		
		JLabel[] labelStats = { new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(),
				new JLabel() };
		JLabel labelNom = new JLabel();
		JPanel panMonstre = new JPanel();
		
		this.setTitle("Fiche de " + monstre.getNom());
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		labelNom.setText(monstre.getNom());
		labelStats[0].setText("For : " + Integer.toString(monstre.getForce()));
		labelStats[1].setText("Dex : " + Integer.toString(monstre.getDexterite()));
		labelStats[2].setText("Cons : " + Integer.toString(monstre.getConstitution()));
		labelStats[3].setText("Int : " + Integer.toString(monstre.getIntelligence()));
		labelStats[4].setText("Sag : " + Integer.toString(monstre.getSagesse()));
		labelStats[5].setText("Cha : " + Integer.toString(monstre.getCharisme()));
		for (int i = 0; i < 6; labelStats[i++].setLocation(10, 10 * (i + 1)))
			;
		labelNom.setLocation(10, 10);
		panMonstre.add(labelNom);
		for (int i = 0; i < 6; panMonstre.add(labelStats[i++]))
			;
		this.setContentPane(panMonstre);
		this.setVisible(true);
	}

	public void afficher() {
		this.setVisible(true);
	}

}
