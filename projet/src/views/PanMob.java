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

public class PanMob extends JPanel {
	private JTable table;
	public static final int width = 300;
	public static final int height = 100;
	/**
	 * Create the panel.
	 * @param monstre 
	 */
	public PanMob(Monstre monstre) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JSpinner spinnerVie = new JSpinner();
		spinnerVie.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinnerVie.setBounds(12, 61, 68, 22);
		add(spinnerVie);
		
		JLabel lblVie = new JLabel("Vie");
		lblVie.setBounds(12, 46, 25, 16);
		add(lblVie);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"For", "Dex", "0", "Int", "Sag", "Cha"},
				{monstre.getForce(), monstre.getDexterite(), monstre.getConstitution(),
					 monstre.getIntelligence(), monstre.getSagesse(), monstre.getCharisme()},
			},
			new String[] {
				"For", "Dex", "Cons", "Int", "Sag", "Cha"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -3825094743687923387L;
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setPreferredWidth(37);
		table.getColumnModel().getColumn(2).setPreferredWidth(41);
		table.getColumnModel().getColumn(3).setPreferredWidth(33);
		table.getColumnModel().getColumn(4).setPreferredWidth(34);
		table.getColumnModel().getColumn(5).setPreferredWidth(38);
		table.setBounds(92, 51, 196, 32);
		add(table);
		
		JSpinner spinnerInitiative = new JSpinner();
		spinnerInitiative.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerInitiative.setBounds(12, 26, 68, 22);
		add(spinnerInitiative);
		
		JLabel lblInitiative = new JLabel("Initiative");
		lblInitiative.setBounds(12, 13, 56, 16);
		add(lblInitiative);
		
		JLabel lblNom = new JLabel(monstre.getNom());
		lblNom.setBounds(108, 22, 56, 16);
		add(lblNom);

	}
}
