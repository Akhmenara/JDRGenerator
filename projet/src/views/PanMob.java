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
	private JTable table;
	public static final int width = 300;
	public static final int height = 100;
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
		
		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"For", "Dex", "Cons", "Int", "Sag", "Cha"},
				{new Integer(monstre.getForce()), new Integer(monstre.getDexterite()), new Integer(monstre.getConstitution()),
					new Integer(monstre.getIntelligence()), new Integer(monstre.getSagesse()), new Integer(monstre.getCharisme())},
			},
			new String[] {
				"For", "Dex", "Cons", "Int", "Sag", "Cha"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5112364260408370531L;
			boolean[] rowEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return rowEditables[row];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(37);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(41);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(33);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(34);
		table.getColumnModel().getColumn(5).setResizable(false);
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
		lblNom.setBounds(92, 29, 196, 16);
		add(lblNom);
		setPreferredSize(new Dimension(width,height));
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(btnPlus.getFont().deriveFont(10f));
		btnPlus.setMargin(new Insets(0,0,0,0));
		btnPlus.setFocusable(false);
		btnPlus.setBounds(256, 4, 40, 40);
		add(btnPlus);
		
		btnPlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FenetreMonstreComplet fenetreMob = new FenetreMonstreComplet(monstre);
				fenetreMob.setVisible(true);
			}
		});
	}
}
