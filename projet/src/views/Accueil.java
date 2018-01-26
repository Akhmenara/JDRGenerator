package views;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import models.Monstre;

import java.awt.CardLayout;

public class Accueil {
	private final int ESPERANCE = 10;
	private final int VARIANCE = 2;
	private CardLayout card = new CardLayout();
	
	private JFrame fenetre = new JFrame();
	
	private JButton boutonPlus1Esperance = new JButton("+1");
	private JButton boutonMoins1Esperance = new JButton("-1");
	
	private int esperance = ESPERANCE;
	private JButton boutonEsperance = new JButton("Esperance :" + esperance);
	
	private JPanel panEsperance = new JPanel();
	
	private JButton boutonPlus1Variance = new JButton("+1");
	private JButton boutonMoins1Variance = new JButton("-1");
	
	private int variance = VARIANCE;
	private JButton boutonVariance = new JButton("Variance :" + variance);
	
	private JPanel panVariance = new JPanel();
	
	private Monstre mob;
	private JButton boutonMonstre = new JButton();
	private JPanel panMonstre = new JPanel();
	
	
	private JPanel content = new JPanel();
	public Accueil() {
		fenetre.setTitle("Accueil");
		fenetre.setSize(1280,720);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panEsperance.add(boutonPlus1Esperance, BorderLayout.EAST);
		panEsperance.add(boutonEsperance, BorderLayout.CENTER);
		panEsperance.add(boutonMoins1Esperance, BorderLayout.WEST);
		
		panVariance.add(boutonPlus1Variance, BorderLayout.EAST);
		panVariance.add(boutonVariance, BorderLayout.CENTER);
		panVariance.add(boutonMoins1Variance, BorderLayout.WEST);
		
		panMonstre.add(boutonMonstre);
		
		boutonPlus1Esperance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				esperance++;
				boutonEsperance.setText("Esperance :" + esperance);
			}
		});
		
		boutonMoins1Esperance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				esperance--;
				boutonEsperance.setText("Esperance :" + esperance);
			}
		});
		
		boutonEsperance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				card.show(content, "Variance");
			}
		});
		
		boutonPlus1Variance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				variance++;
				boutonVariance.setText("Variance :" + variance);
			}
		});
		
		boutonMoins1Variance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				variance--;
				boutonVariance.setText("Variance :" + variance);
			}
		});
		
		boutonVariance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int[] esperances = {esperance,esperance,esperance,esperance,esperance,esperance};
				int[] variances = {variance,variance,variance,variance,variance,variance};
				mob = Monstre.creerMonstreAleaNorm(esperances,variances);
				boutonMonstre.setText(mob.toString());
				
				
				card.show(content, "Monstre");
				
			}
		});
		
		boutonMonstre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				esperance = ESPERANCE;
				variance = VARIANCE;
				
				boutonEsperance.setText("Esperance :" + esperance);
				boutonVariance.setText("Variance :" + variance);
				card.show(content, "Esperance");
			}
		});
		content.setLayout(card);
		
		content.add(panEsperance,"Esperance");
		content.add(panVariance,"Variance");
		content.add(panMonstre, "Monstre");
		
		fenetre.setContentPane(content);
	}
	public void afficher() {
		fenetre.setVisible(true);
	}


	
}