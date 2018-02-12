package views;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


import controllers.Database;
import models.Monstre;


import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Accueil extends JFrame {

	/**
	 * Fenetre d'accueil.
	 */
	private static final long serialVersionUID = 1L;

	private final int VARIANCE = 4;
	
	private JPanel contentPane;
	private int variance = VARIANCE;
	private static ArrayList<Monstre> MONSTRES = Database.getAllMonsters();
	private static int NBR_MONSTRE = MONSTRES.size();
	
	/**
	 * Create the frame.
	 */
	public Accueil() {
		PanChoixMonstre panChoixMob = new PanChoixMonstre();
		JScrollPane scrollPane = new JScrollPane(panChoixMob);
		setResizable(false);
		setTitle("Cr\u00E9ation de monstre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnAleatoire = new JRadioButton("Al\u00E9atoire");
		rdbtnAleatoire.setSelected(true);
		rdbtnAleatoire.setBounds(309, 249, 85, 25);
		contentPane.add(rdbtnAleatoire);
		
		JComboBox<String> choixMonstre = new JComboBox<String>();
		choixMonstre.setBounds(36, 29, 139, 22);
		for (int i = 0; i<NBR_MONSTRE; choixMonstre.addItem(MONSTRES.get(i++).getNom()));
		contentPane.add(choixMonstre);
		
		JLabel labelChoixMonstre = new JLabel("Choix du monstre");
		labelChoixMonstre.setBounds(36, 12, 139, 16);
		contentPane.add(labelChoixMonstre);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(294, 12, 56, 16);
		contentPane.add(labelNombre);
		
		JSpinner choixNombre = new JSpinner();
		choixNombre.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		choixNombre.setBounds(277, 41, 117, 22);
		contentPane.add(choixNombre);
		
		JPanel panEcartType = new JPanel();
		panEcartType.setToolTipText("");
		panEcartType.setBounds(293, 283, 139, 101);
		contentPane.add(panEcartType);
		
		JLabel labelEcartType = new JLabel("Ecart type");
		labelEcartType.setBounds(45, 25, 64, 16);
		panEcartType.add(labelEcartType);
		
		JSpinner choixEcartType = new JSpinner();
		choixEcartType.setModel(new SpinnerNumberModel(new Integer(2), new Integer(0), null, new Integer(1)));
		choixEcartType.setBounds(25, 41, 85, 22);
		
		panEcartType.add(choixEcartType);
		panEcartType.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{choixEcartType}));
		
		JButton boutonCreer = new JButton("Cr\u00E9er");
		boutonCreer.setBounds(294, 109, 100, 51);
		boutonCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ArrayList listeChoix = panChoixMob.getChoix();
				ArrayList<Monstre> listeMobs = new ArrayList<Monstre>(); 
				for (int i = 0;i < listeChoix.size();i++) {
					ArrayList choix = (ArrayList)listeChoix.get(i);
					variance = (int) Math.pow((int)choix.get(2),2);
				
					Monstre monstreBase = (Monstre)(choix.get(0));
					int nbrMonstre = (int)choix.get(1);
					int[] esperances = {monstreBase.getForce(),
						monstreBase.getDexterite(),
						monstreBase.getConstitution(),
						monstreBase.getIntelligence(),
						monstreBase.getSagesse(),
						monstreBase.getCharisme()};
					int[] variances = {variance,variance,variance,variance,variance,variance};
					Monstre[] mobsSuivant = Monstre.creerMonstreAleaNorm(monstreBase.getNom(),esperances,variances,monstreBase.getDesVie(),nbrMonstre);
					for(int j = 0; j < mobsSuivant.length;listeMobs.add(mobsSuivant[j++]));
				}
				Monstre[] mobs = new Monstre[listeMobs.size()];
				listeMobs.toArray(mobs);
				FenetreMonstre fenetreMob = new FenetreMonstre(mobs);
				fenetreMob.setVisible(true);
			}
		});
		contentPane.add(boutonCreer);
		
		JButton buttonPlus = new JButton("+");
		buttonPlus.setBounds(187, 28, 41, 25);
		buttonPlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ecartType;
				if (panEcartType.isVisible()) {
					ecartType = (int) choixEcartType.getValue();
				}else {
					ecartType = 0;
				}
				panChoixMob.addChoix(MONSTRES.get(choixMonstre.getSelectedIndex()),
						(int) choixNombre.getValue(),
						ecartType);
				panChoixMob.repaint();
				scrollPane.repaint();
				repaint();
				
			}
		});
		contentPane.add(buttonPlus);
		
		scrollPane.setBounds(22, 79, 260, 200);
		contentPane.add(scrollPane);
		rdbtnAleatoire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//panEcartType.setEnabled(!panEcartType.isEnabled());
				panEcartType.setVisible(!panEcartType.isVisible());
				variance = 0;
			}
		});
	}
}
