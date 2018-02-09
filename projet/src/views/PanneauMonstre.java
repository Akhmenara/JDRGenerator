package views;

import java.awt.Dimension;

import javax.swing.JPanel;

import models.Monstre;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class PanneauMonstre extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3112265016793549578L;
	private int nombreMonstre = 0;
	/**
	 * Create the panel.
	 */     
	private final Rectangle maximumWindowBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	public PanneauMonstre(Monstre[] monstres) {
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		setLayout(layout);
		taille(monstres.length);
		for (int i = 0; i < monstres.length;ajouterMonstre(monstres[i++]));
	}
	
	private void taille(int nombreMonstre) {
		int tailleX;
		int tailleY;
		if (nombreMonstre < (Integer.divideUnsigned((int)maximumWindowBounds.getWidth(), PanMob.width))){
			tailleX = PanMob.width*nombreMonstre;
			tailleY = PanMob.height;
		}else {
			tailleX = PanMob.width*(
					Integer.divideUnsigned((int)maximumWindowBounds.getWidth(), PanMob.width) + 
					Integer.signum(Integer.remainderUnsigned((int)maximumWindowBounds.getWidth(), PanMob.width))
					);
			tailleY = PanMob.height*(
					Integer.divideUnsigned(nombreMonstre, Integer.divideUnsigned(tailleX,PanMob.width)) +
					Integer.signum(Integer.remainderUnsigned(nombreMonstre, Integer.divideUnsigned(tailleX,PanMob.width)))
					);
		}
		setPreferredSize(new Dimension(tailleX,tailleY));
	}
	
	public void ajouterMonstre(Monstre monstre) {
		PanMob pan = new PanMob(monstre);
		//pan.setBounds(0, PanMob.height*nombreMonstre, PanMob.width, PanMob.height);
		nombreMonstre++;
		add(pan);
	}
	public int getNombreMonstre() {
		return nombreMonstre;
	}
}
