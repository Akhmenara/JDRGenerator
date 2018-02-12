package views;

import javax.swing.JPanel;

import models.Monstre;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class PanUnChoix extends JPanel {
	
	/**
	 * Create the panel.
	 */
	private ArrayList choix = new ArrayList();
	private PanChoixMonstre parent;
	
	
	public PanUnChoix(Monstre monstre, int nombre, int ecartType, PanChoixMonstre parent) {
		choix.add(monstre);
		choix.add(nombre);
		choix.add(ecartType);
		this.parent = parent;
		setLayout(null);
		
		JLabel lblNom = new JLabel(monstre.getNom());
		lblNom.setBounds(0, 13, 54, 16);
		add(lblNom);
		
		JLabel lblNombre = new JLabel(Integer.toString(nombre));
		lblNombre.setBounds(67, 13, 37, 16);
		add(lblNombre);
		JButton btnMoins = new JButton("-");
		btnMoins.setFont(btnMoins.getFont().deriveFont(10f));
		btnMoins.setMargin(new Insets(0,0,0,0));
		btnMoins.setFocusable(false);
		PanUnChoix test = this;
		btnMoins.addActionListener(new ActionListenerSuppression(this));
		btnMoins.setBounds(197, 9, 37, 25);
		add(btnMoins);
		
		JLabel lblEcarttype = new JLabel(Integer.toString(ecartType));
		lblEcarttype.setBounds(120, 13, 37, 16);
		add(lblEcarttype);
		
		setPreferredSize(new Dimension(240,40));
	}
	
	public ArrayList getChoix() {
		
		return choix;
		
	}
	
	public PanChoixMonstre getParent() {
		return this.parent;
	}
	
	public class ActionListenerSuppression implements ActionListener {
		PanUnChoix aSupprimer;
		
		public ActionListenerSuppression(PanUnChoix aSupprimer) {
			this.aSupprimer = aSupprimer;
		}
		
		public void actionPerformed(ActionEvent e) {
			removeAll();
			setVisible(false);
			aSupprimer.getParent().remove(aSupprimer);
			
		}
	}

	
}
