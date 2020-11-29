package fr.eni.papeterie.ihm;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.bll.BLLException;

public class DemoSwingApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EcranPapeterie frame = new EcranPapeterie();
				frame.setVisible(true);
				try {
					EcranCatalogue ecran = new EcranCatalogue();
					ecran.setVisible(true);
				} catch (BLLException | SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
