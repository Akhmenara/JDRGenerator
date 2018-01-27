package views;
import javax.swing.JFrame;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Monstre;

import java.awt.CardLayout;
import java.awt.Dimension;

public class Accueil {
	private final int ESPERANCE = 10;
	private final int VARIANCE = 2;
	private CardLayout card = new CardLayout();
	
	private JFrame fenetre = new JFrame("Acceuil");
	
	private JButton boutonPlus1Esperance = new JButton("+1");
	private JButton boutonMoins1Esperance = new JButton("-1");
	
	private int esperance = ESPERANCE;
	private JButton boutonEsperance = new JButton("Esperance :" );//+ esperance);
	
	private JPanel panEsperance = new JPanel();
	
	private JButton boutonPlus1Variance = new JButton("+1");
	private JButton boutonMoins1Variance = new JButton("-1");
	
	private int variance = VARIANCE;
	private JButton boutonVariance = new JButton("Variance :" );//+ variance);
	
	private JPanel panVariance = new JPanel();
	
	
	private JTextField zone_text_Esperance = new JTextField(Integer.toString(ESPERANCE));
	
	private JTextField zone_text_Variance = new JTextField(Integer.toString(VARIANCE));
	
	private JPanel content = new JPanel();
	
	private int nbrMonstre = 0;
	public Accueil() {
		fenetre.setSize(1280,720);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLayout(new BorderLayout());
		//panEsperance.add(boutonPlus1Esperance, BorderLayout.EAST);
		panEsperance.add(boutonEsperance, BorderLayout.CENTER);
		//panEsperance.add(boutonMoins1Esperance, BorderLayout.WEST);
		
		zone_text_Esperance.setPreferredSize(new Dimension(150, 30));
		panEsperance.add(zone_text_Esperance);
		
		//panVariance.add(boutonPlus1Variance, BorderLayout.EAST);
		panVariance.add(boutonVariance, BorderLayout.CENTER);
		//panVariance.add(boutonMoins1Variance, BorderLayout.WEST);
		
		zone_text_Variance.setPreferredSize(new Dimension(150, 30));
		panVariance.add(zone_text_Variance);
		
		
		
		
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
				esperance = Integer.parseInt(zone_text_Esperance.getText());
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
				variance = Integer.parseInt(zone_text_Variance.getText());
				int[] esperances = {esperance,esperance,esperance,esperance,esperance,esperance};
				int[] variances = {variance,variance,variance,variance,variance,variance};
				Monstre mob = Monstre.creerMonstreAleaNorm(esperances,variances);
				nbrMonstre++;
				mob.setNom("test" + nbrMonstre);
				FenetreMonstre fenetreMob = new FenetreMonstre(mob);
				
				esperance = ESPERANCE;
				variance = VARIANCE;
				
				zone_text_Esperance.setText(Integer.toString(ESPERANCE));
				zone_text_Variance.setText(Integer.toString(VARIANCE));
				card.show(content, "Esperance");
				
			}
		});
		
		content.setLayout(card);
		
		content.add(panEsperance,"Esperance");
		content.add(panVariance,"Variance");
		
		fenetre.setContentPane(content);
	}
	public void afficher() {
		fenetre.setVisible(true);
	}


	
}