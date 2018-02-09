package views;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Monstre;

public class PanneauMonstre extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3112265016793549578L;
	private int nombreMonstre = 0;
	/**
	 * Create the panel.
	 */
	public PanneauMonstre(Monstre[] monstres) {
		setLayout(null);
		if (monstres.length > 0){
			setPreferredSize(new Dimension(PanMob.width,PanMob.height*monstres.length));
		}else {
			setPreferredSize(new Dimension(1,20*monstres.length));
		}
		for (int i = 0; i < monstres.length;ajouterMonstre(monstres[i++]));
	}
	
	public void ajouterMonstre(Monstre monstre) {
		PanMob pan = new PanMob(monstre);
		pan.setBounds(0, PanMob.height*nombreMonstre++, PanMob.width, PanMob.height);
		add(pan);
	}
	
}
