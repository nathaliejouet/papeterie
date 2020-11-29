package fr.eni.papeterie.ihm;

import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Stylo;

public class TableCatalogueModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Object[][] data;
	private final String[] columnNames = new String[] { "", "Référence", "Marque", "Désignation", "Prix unitaire",
			"Stock" };

	public TableCatalogueModel() throws BLLException, SQLException {
		super();
		data = parcourCatalogue();
	}

	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	public Object[][] parcourCatalogue() throws BLLException, SQLException {
		Object[][] catalogue = new Object[CatalogueManager.getCatalogue().size()][6];
		try {
			for (int i = 0; i < CatalogueManager.getCatalogue().size(); i++) {
				if (CatalogueManager.getCatalogue().get(i) instanceof Stylo) {
					ImageIcon lblImage1 = new ImageIcon(getClass().getResource("pen.png"));
					catalogue[i][0] = lblImage1;
				} else {
					Icon lblImage2 = new ImageIcon(getClass().getResource("ramette.png"));
					catalogue[i][0] = lblImage2;
				}
				catalogue[i][1] = CatalogueManager.getCatalogue().get(i).getReference();
				catalogue[i][2] = CatalogueManager.getCatalogue().get(i).getMarque();
				catalogue[i][3] = CatalogueManager.getCatalogue().get(i).getDesignation();
				catalogue[i][4] = CatalogueManager.getCatalogue().get(i).getPrixUnitaire();
				catalogue[i][5] = CatalogueManager.getCatalogue().get(i).getQteStock();
			}
		} catch (IndexOutOfBoundsException | NullPointerException | BLLException | SQLException e1) {
			e1.printStackTrace();
		}
		return catalogue;
	}
}
