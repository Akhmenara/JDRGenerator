package views;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
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
		setResizable(false);
		setTitle("Cr\u00E9ation de monstre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnAleatoire = new JRadioButton("Al\u00E9atoire");
		rdbtnAleatoire.setSelected(true);
		rdbtnAleatoire.setBounds(36, 95, 85, 25);
		contentPane.add(rdbtnAleatoire);
		
		final JComboBox<String> choixMonstre = new JComboBox<String>();
		choixMonstre.setBounds(45, 41, 139, 22);
		for (int i = 0; i<NBR_MONSTRE; choixMonstre.addItem(MONSTRES.get(i++).getNom()));
		contentPane.add(choixMonstre);
		
		JLabel labelChoixMonstre = new JLabel("Choix du monstre");
		labelChoixMonstre.setBounds(45, 12, 139, 16);
		contentPane.add(labelChoixMonstre);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(294, 12, 56, 16);
		contentPane.add(labelNombre);
		
		final JSpinner choixNombre = new JSpinner();
		choixNombre.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		choixNombre.setBounds(277, 41, 117, 22);
		contentPane.add(choixNombre);
		
		final JPanel panEcartType = new JPanel();
		panEcartType.setToolTipText("");
		panEcartType.setBounds(12, 129, 139, 101);
		contentPane.add(panEcartType);
		panEcartType.setLayout(null);
		
		JLabel labelEcartType = new JLabel("Ecart type");
		labelEcartType.setBounds(46, 8, 57, 16);
		panEcartType.add(labelEcartType);
		
		final JSpinner choixEcartType = new JSpinner();
		choixEcartType.setModel(new SpinnerNumberModel(new Integer(2), new Integer(0), null, new Integer(1)));
		choixEcartType.setBounds(31, 37, 72, 22);
		
		panEcartType.add(choixEcartType);
		panEcartType.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{choixEcartType}));
		
		JButton boutonCreer = new JButton("Cr\u00E9er");
		boutonCreer.setBounds(320, 191, 100, 51);
		boutonCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				if (panEcartType.isVisible()) {
					variance = (int) Math.pow((int) choixEcartType.getValue(),2);
				}else {
					variance = 0;
				}
				
				Monstre monstreBase = MONSTRES.get(choixMonstre.getSelectedIndex());
				int nbrMonstre = (int) choixNombre.getValue();
				int[] esperances = {monstreBase.getForce(),
						monstreBase.getDexterite(),
						monstreBase.getConstitution(),
						monstreBase.getIntelligence(),
						monstreBase.getSagesse(),
						monstreBase.getCharisme()};
				int[] variances = {variance,variance,variance,variance,variance,variance};
				Monstre[] mobs = Monstre.creerMonstreAleaNorm(monstreBase.getNom(),esperances,variances,monstreBase.getDesVie(),nbrMonstre);
				//FenetreMonstre[] fenetresMob = new FenetreMonstre[mobs.length];
				//for (int k = 0 ; k < mobs.length; fenetresMob[k] = new FenetreMonstre(mobs[k++]));
				FenetreMonstre fenetresMob = new FenetreMonstre(mobs);
				fenetresMob.setVisible(true);
			}
		});
		
		contentPane.add(boutonCreer);
		rdbtnAleatoire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//panEcartType.setEnabled(!panEcartType.isEnabled());
				panEcartType.setVisible(!panEcartType.isVisible());
				variance = 0;
			}
		});
	}
}
