package views;


import java.awt.Dimension;

import javax.swing.JPanel;

import models.Monstre;

import java.awt.FlowLayout;

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import java.util.ArrayList;

public class PanChoixMonstre extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7604091213658657080L;
	private int nombreChoix = 0;
	private ArrayList choix = new ArrayList();
	/**
	 * Create the panel.
	 */
	public PanChoixMonstre() {
		setPreferredSize(new Dimension(240,0));
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 0, 0);
		this.addContainerListener(new ContainerListener() {
			
			@Override
			public void componentRemoved(ContainerEvent e) {
				nombreChoix--;
				setPreferredSize(new Dimension(240,40*nombreChoix));
				System.out.println("componentRemoved");
				revalidate();
				
			}
			
			@Override
			public void componentAdded(ContainerEvent e) {
				nombreChoix++;
				setPreferredSize(new Dimension(240,40*nombreChoix));
				System.out.println("componentAdded");
				revalidate();
				
			}
		});
		setLayout(layout);
		validate();
	}
	public void addChoix(Monstre monstre, int nombre,int ecartType) {
		PanUnChoix nouveauChoix = new PanUnChoix(monstre, nombre, ecartType, this);
		add(nouveauChoix);
		choix.add(nouveauChoix.getChoix());
	}
	public ArrayList getChoix() {
		return choix;
	}
	
	public void remove(PanUnChoix comp) {
		choix.remove(comp.getChoix());
		super.remove(comp);
	}
}
