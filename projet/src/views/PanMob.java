package views;

import javax.swing.JPanel;

import models.Monstre;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Insets;

public class PanMob extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2931688819744574549L;
	private JTable tableStats;
	public static final int width = 458;
	public static final int height = 100;
	private JTable table;
	/**
	 * Create the panel.
	 * @param monstre 
	 */
	public PanMob(final Monstre monstre) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JSpinner spinnerVie = new JSpinner();
		spinnerVie.setModel(new SpinnerNumberModel(new Integer(monstre.getVie()), null, null, new Integer(1)));
		spinnerVie.setBounds(12, 61, 68, 22);
		add(spinnerVie);
		
		JLabel lblVie = new JLabel("Vie");
		lblVie.setBounds(12, 46, 25, 16);
		add(lblVie);
		
		tableStats = new JTable();
		tableStats.setToolTipText("");
		tableStats.setModel(new DefaultTableModel(
			new Object[][] {
				{"For", monstre.getForce(), "Int", monstre.getIntelligence()},
				{"Dex", monstre.getDexterite(), "Sag", monstre.getSagesse()},
				{"Con", monstre.getConstitution(), "Cha", monstre.getCharisme()},
			},
			new String[] {
				"FDC", "StatFDC", "ISC", "StatISC"
			}
		) {
			private static final long serialVersionUID = 4330217940081730361L;
			boolean[] columnEditables = new boolean[] {
				false, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableStats.getColumnModel().getColumn(0).setResizable(false);
		tableStats.getColumnModel().getColumn(0).setPreferredWidth(31);
		tableStats.getColumnModel().getColumn(1).setResizable(false);
		tableStats.getColumnModel().getColumn(1).setPreferredWidth(37);
		tableStats.getColumnModel().getColumn(2).setResizable(false);
		tableStats.getColumnModel().getColumn(2).setPreferredWidth(41);
		tableStats.getColumnModel().getColumn(3).setResizable(false);
		tableStats.getColumnModel().getColumn(3).setPreferredWidth(33);
		tableStats.setBounds(104, 30, 124, 48);
		add(tableStats);
		
		JSpinner spinnerInitiative = new JSpinner();
		spinnerInitiative.setModel(new SpinnerNumberModel(new Integer(monstre.getInitiative()), new Integer(0), null, new Integer(1)));
		spinnerInitiative.setBounds(12, 26, 68, 22);
		add(spinnerInitiative);
		
		JLabel lblInitiative = new JLabel("Initiative");
		lblInitiative.setBounds(12, 13, 56, 16);
		add(lblInitiative);
		
		JLabel lblNom = new JLabel(monstre.getNom());
		lblNom.setBounds(80, 4, 196, 16);
		add(lblNom);
		setPreferredSize(new Dimension(458, 100));
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(btnPlus.getFont().deriveFont(10f));
		btnPlus.setMargin(new Insets(0,0,0,0));
		btnPlus.setFocusable(false);
		btnPlus.setBounds(416, 2, 40, 40);
		add(btnPlus);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ref", new Integer(monstre.getReflexes())},
				{"Vig", new Integer(monstre.getVigueur())},
				{"Vol", new Integer(monstre.getVolonte())},
			},
			new String[] {
				"Nom", "Stats"
			}
		) {
			private static final long serialVersionUID = 2317249075271782353L;
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(23);
		table.setBounds(252, 30, 49, 48);
		add(table);
		
		btnPlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FenetreMonstreComplet fenetreMob = new FenetreMonstreComplet(monstre);
				fenetreMob.setVisible(true);
			}
		});
	}
}
