package views;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Accueil {
	
	private CardLayout card = new CardLayout();
	
	private JFrame fenetre = new JFrame();
	
	private JButton boutonPlus1Esperance = new JButton("+1");
	private JButton boutonMoins1Esperance = new JButton("-1");
	
	private int esperance = 0;
	private JButton boutonEsperance = new JButton("Esperance :" + esperance);
	
	private JPanel panEsperance = new JPanel();
	
	private JButton boutonPlus1Variance = new JButton("+1");
	private JButton boutonMoins1Variance = new JButton("-1");
	
	private int variance = 0;
	private JButton boutonVariance = new JButton("Variance :" + variance);
	
	private JPanel panVariance = new JPanel();
	
	private String[] listContent = {"Esperance","Variance"};
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