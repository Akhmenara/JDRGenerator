package views;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import models.Monstre;

import javax.swing.JScrollPane;

public class FenetreMonstre extends JFrame {

	private static final long serialVersionUID = 5916356950208824924L;
	private JScrollPane contentPane;
	/**
	 * Create the frame.
	 */
	public FenetreMonstre(Monstre[] monstres) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanneauMonstre panel = new PanneauMonstre(monstres);
		contentPane = new JScrollPane(panel);
		contentPane.getVerticalScrollBar().setUnitIncrement(20);
		add(contentPane);
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				repaint();
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
