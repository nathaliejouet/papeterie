package fr.eni.papeterie.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.eni.papeterie.bll.BLLException;

public class EcranCatalogue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EcranCatalogue() throws BLLException, SQLException {
		super();
		this.setTitle("Catalogue");
		this.setSize(new Dimension(800, 800));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTable table = new JTable(new TableCatalogueModel());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		pack();
	}
}
