package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Monstre;

public class FenetreMonstre extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel[] labelStats = {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
	private JLabel labelNom = new JLabel();
	private JPanel panMonstre = new JPanel();
	
	public FenetreMonstre(Monstre monstre) {
		this.setTitle("Fiche de "+ monstre.getNom());
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
		for (int i = 0; i<6; labelStats[i++].setLocation(100,100*i));
		labelNom.setLocation(100, 100);
		panMonstre.add(labelNom, BorderLayout.WEST);
		for (int i = 0; i<6;panMonstre.add(labelStats[i++],BorderLayout.WEST));
		this.setContentPane(panMonstre);
		this.setVisible(true);
	}
	
	public void afficher() {
		this.setVisible(true);
	}

}
