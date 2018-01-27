package views;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Monstre;

import java.awt.CardLayout;
import java.awt.Dimension;
import controllers.Database;
public class Accueil {
	private final int ESPERANCE = 1;
	private final int VARIANCE = 4;
	private CardLayout card = new CardLayout();
	
	private JFrame fenetre = new JFrame("Acceuil");
	
	private JButton boutonPlus1Esperance = new JButton("+1");
	private JButton boutonMoins1Esperance = new JButton("-1");
	
	private int esperance = ESPERANCE;
	private JButton boutonEsperance = new JButton("Monstre :" );
	
	private JComboBox<String> choixMonstre = new JComboBox<String>();
	
	private JPanel panEsperance = new JPanel();
	
	private JButton boutonPlus1Variance = new JButton("+1");
	private JButton boutonMoins1Variance = new JButton("-1");
	
	private int variance = VARIANCE;
	private JButton boutonVariance = new JButton("Variance :" );//+ variance);
	
	private JPanel panVariance = new JPanel();
	
	private JLabel labelNbrMontre = new JLabel("Nombre : ");
	private JTextField zone_text_Esperance = new JTextField(Integer.toString(ESPERANCE));
	
	private JTextField zone_text_Variance = new JTextField(Integer.toString(VARIANCE));
	
	private JPanel content = new JPanel();
	private static ArrayList<Monstre> MONSTRES = Database.getAllMonsters();
	private static int NBR_MONSTRE = MONSTRES.size();
	public Accueil() {
		fenetre.setSize(1280,720);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLayout(new BorderLayout());
		//panEsperance.add(boutonPlus1Esperance, BorderLayout.EAST);
		panEsperance.add(boutonEsperance, BorderLayout.CENTER);
		//panEsperance.add(boutonMoins1Esperance, BorderLayout.WEST);
		
		
		
		for (int i = 0; i<NBR_MONSTRE; choixMonstre.addItem(MONSTRES.get(i++).getNom()));
		panEsperance.add(choixMonstre);
		panEsperance.add(zone_text_Esperance);
		zone_text_Esperance.setPreferredSize(new Dimension(150, 30));
		
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
				Monstre monstreBase = MONSTRES.get(choixMonstre.getSelectedIndex());
				int nbrMonstre = Integer.parseInt(zone_text_Esperance.getText());
				int[] esperances = {monstreBase.getForce(),
						monstreBase.getDexterite(),
						monstreBase.getConstitution(),
						monstreBase.getIntelligence(),
						monstreBase.getSagesse(),
						monstreBase.getCharisme()};
				int[] variances = {variance,variance,variance,variance,variance,variance};
				Monstre[] mobs = Monstre.creerMonstreAleaNorm(monstreBase.getNom(),esperances,variances,nbrMonstre);
				FenetreMonstre[] fenetresMob = new FenetreMonstre[mobs.length];
				for (int k = 0 ; k < mobs.length; fenetresMob[k] = new FenetreMonstre(mobs[k++]));
				
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