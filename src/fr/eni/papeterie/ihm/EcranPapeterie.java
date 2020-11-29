package fr.eni.papeterie.ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class EcranPapeterie extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CatalogueManager catalogue;
	public static int INDEX = 0;
	private int selectedId;
	private boolean addMode = true;
	private Object selected;
	private JLabel lblReference;
	private JLabel lblDesignation;
	private JLabel lblMarque;
	private JLabel lblStock;
	private JLabel lblPrix;
	private JLabel lblType;
	private JLabel lblGrammage;
	private JLabel lblCouleur;
	private JTextField txtReference;
	private JTextField txtDesignation;
	private JTextField txtMarque;
	private JTextField txtStock;
	private JTextField txtPrix;
	private Box styleBox1;
	private Box styleBox2;
	private JPanel panelRadioButton;
	private JPanel panelCheckBox;
	private JPanel panelComboBox;
	private JPanel panelIcon;
	private JCheckBox btnGramme1;
	private JCheckBox btnGramme2;
	private ButtonGroup btnGroup1;
	private ButtonGroup btnGroup2;
	private JRadioButton btnRamette;
	private JRadioButton btnStylo;
	private JComboBox<String> listeCouleur;
	private String[] elements;
	private JButton btnFlecheGauche;
	private JButton btnNouveau;
	private JButton btnSauvegarde;
	private JButton btnSupprime;
	private JButton btnFlecheDroite;

	public EcranPapeterie() {
		this.setTitle("Papeterie");
		this.setSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM();
	}

	public void initIHM() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

//		Ligne 1
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.insets = new Insets(0, 0, 0, 10);
		panel.add(getLblReference(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 0, 10, 0);
		panel.add(getTxtReference(), gbc);

//		Ligne 2
		gbc.gridy = 1;
		gbc.gridx = 0;
		panel.add(getLblDesignation(), gbc);

		gbc.gridx = 1;
		panel.add(getTxtDesignation(), gbc);

//		Ligne 3
		gbc.gridy = 2;
		gbc.gridx = 0;
		panel.add(getLblMarque(), gbc);

		gbc.gridx = 2;
		panel.add(getTxtMarque(), gbc);

//		Ligne 4
		gbc.gridy = 3;
		gbc.gridx = 0;
		panel.add(getLblStock(), gbc);

		gbc.gridx = 3;
		panel.add(getTxtStock(), gbc);

//		Ligne 5
		gbc.gridy = 4;
		gbc.gridx = 0;
		panel.add(getLblPrix(), gbc);

		gbc.gridx = 4;
		panel.add(getTxtPrix(), gbc);

//		Ligne 6
		gbc.gridy = 6;
		gbc.gridx = 0;
		panel.add(getLblType(), gbc);

		gbc.gridx = 6;
		panel.add(getPanelRadioButton(), gbc);

//		Ligne 7
		gbc.gridy = 7;
		gbc.gridx = 0;
		panel.add(getLblGrammage(), gbc);

		gbc.gridx = 7;
		panel.add(getPanelCheckBox(), gbc);

//		Ligne 8
		gbc.gridy = 8;
		gbc.gridx = 0;
		panel.add(getLblCouleur(), gbc);

		gbc.gridx = 8;
		panel.add(getPanelComboBox(), gbc);

//		Ligne 9
		gbc.gridy = 9;
		gbc.gridx = 0;
		panel.add(getPanelIcon(), gbc);

//      Afficher le panel
		this.setContentPane(panel);
	}

	public JLabel getLblReference() {
		if (lblReference == null) {
			lblReference = new JLabel("Référence ");
		}
		return lblReference;
	}

	public JLabel getLblDesignation() {
		if (lblDesignation == null) {
			lblDesignation = new JLabel("Designation ");
		}
		return lblDesignation;
	}

	public JLabel getLblMarque() {
		if (lblMarque == null) {
			lblMarque = new JLabel("Marque ");
		}
		return lblMarque;
	}

	public JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock ");
		}
		return lblStock;
	}

	public JLabel getLblPrix() {
		if (lblPrix == null) {
			lblPrix = new JLabel("Prix ");
		}
		return lblPrix;
	}

	public JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type ");
		}
		return lblType;
	}

	public JLabel getLblGrammage() {
		if (lblGrammage == null) {
			lblGrammage = new JLabel("Grammage ");
		}
		return lblGrammage;
	}

	public JLabel getLblCouleur() {
		if (lblCouleur == null) {
			lblCouleur = new JLabel("Couleur ");
		}
		return lblCouleur;
	}

	public JTextField getTxtReference() {
		if (txtReference == null) {
			txtReference = new JTextField(20);
		}
		return txtReference;
	}

	public JTextField getTxtDesignation() {
		if (txtDesignation == null) {
			txtDesignation = new JTextField(20);
		}
		return txtDesignation;
	}

	public JTextField getTxtMarque() {
		if (txtMarque == null) {
			txtMarque = new JTextField(20);
		}
		return txtMarque;
	}

	public JTextField getTxtStock() {
		if (txtStock == null) {
			txtStock = new JTextField(20);
		}
		return txtStock;
	}

	public JTextField getTxtPrix() {
		if (txtPrix == null) {
			txtPrix = new JTextField(20);
		}
		return txtPrix;
	}

	public JPanel getPanelRadioButton() {
		if (panelRadioButton == null) {
			panelRadioButton = new JPanel();
			styleBox1 = Box.createVerticalBox();
			btnGroup1 = new ButtonGroup();
			btnRamette = new JRadioButton("Ramette");
			btnRamette.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listeCouleur.setEnabled(false);
					listeCouleur.setSelectedItem(null);
					btnGramme1.setEnabled(true);
					btnGramme2.setEnabled(true);
				}
			});
			btnStylo = new JRadioButton("Stylo");
			btnStylo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listeCouleur.setEnabled(true);
					btnGramme1.setEnabled(false);
					btnGramme2.setEnabled(false);
					btnGroup2.clearSelection();
				}
			});
			btnGroup1.add(btnRamette);
			btnGroup1.add(btnStylo);
			styleBox1.add(btnRamette);
			styleBox1.add(btnStylo);
			panelRadioButton.add(styleBox1);
		}
		return panelRadioButton;
	}

	public JPanel getPanelCheckBox() {
		if (panelCheckBox == null) {
			panelCheckBox = new JPanel();
			styleBox2 = Box.createVerticalBox();
			btnGroup2 = new ButtonGroup();
			btnGramme1 = new JCheckBox("80 grammes");
			btnGramme2 = new JCheckBox("100 grammes");
			btnGroup2.add(btnGramme1);
			btnGroup2.add(btnGramme2);
			styleBox2.add(btnGramme1);
			styleBox2.add(btnGramme2);
			panelCheckBox.add(styleBox2);
		}
		return panelCheckBox;
	}

	public JPanel getPanelComboBox() {
		if (panelComboBox == null) {
			panelComboBox = new JPanel();
			elements = new String[] { "", "Rouge", "Vert", "Bleu", "Noir", "jaune" };
			listeCouleur = new JComboBox<String>(elements);
			listeCouleur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selected = listeCouleur.getSelectedItem();
					String command = e.getActionCommand();
				}
			});
			panelComboBox.add(listeCouleur);
		}
		return panelComboBox;
	}

	public JPanel getPanelIcon() {

		try {
			catalogue = new CatalogueManager();
		} catch (BLLException e2) {
			e2.printStackTrace();
		}

		if (panelIcon == null) {
			panelIcon = new JPanel();
			btnFlecheGauche = new JButton(new ImageIcon(this.getClass().getResource("Back24.gif")));
			btnFlecheGauche.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addMode = false;
					btnRamette.setEnabled(false);
					btnStylo.setEnabled(false);
					listeCouleur.setEnabled(true);
					btnGramme1.setEnabled(true);
					btnGramme2.setEnabled(true);
					if (INDEX == 0) {
						try {
							INDEX = catalogue.getCatalogue().size() - 1;
						} catch (IndexOutOfBoundsException | SQLException | BLLException e1) {
							e1.printStackTrace();
						}
					} else {
						INDEX--;
					}
					afficherArticle(INDEX);
				}
			});
			btnNouveau = new JButton(new ImageIcon(this.getClass().getResource("New24.gif")));
			btnNouveau.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectedId = 0;
					btnRamette.setEnabled(true);
					btnStylo.setEnabled(true);
					btnSupprime.setEnabled(false);
					txtReference.setText("");
					txtDesignation.setText("");
					txtMarque.setText("");
					txtStock.setText("");
					txtPrix.setText("");
					addMode = true;
				}
			});
			btnSauvegarde = new JButton(new ImageIcon(this.getClass().getResource("Save24.gif")));
			btnSauvegarde.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Article art = createArticle(selectedId);
						if (addMode) {
							catalogue.validerArticle(art);
							catalogue.addArticle(art);
							JOptionPane.showMessageDialog(null, "L'article a bien été enregistré");
							afficherArticle(INDEX);
						} else {
							catalogue.validerArticle(art);
							catalogue.updateArticle(art);
							JOptionPane.showMessageDialog(null, "L'article a bien été modifié");
						}
					} catch (BLLException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnSupprime = new JButton(new ImageIcon(this.getClass().getResource("Delete24.gif")));
			btnSupprime.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addMode = false;
					btnRamette.setEnabled(false);
					btnStylo.setEnabled(false);
					btnGramme1.setEnabled(false);
					btnGramme2.setEnabled(false);
					try {
						catalogue.removeArticle(catalogue.getCatalogue().get(INDEX));
						JOptionPane.showMessageDialog(null, "Article supprimé !");
						btnFlecheDroite.setSelected(true);
					} catch (BLLException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnFlecheDroite = new JButton(new ImageIcon(this.getClass().getResource("Forward24.gif")));
			btnFlecheDroite.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addMode = false;
					btnRamette.setEnabled(false);
					btnStylo.setEnabled(false);
					if (btnStylo.isSelected()) {
						listeCouleur.setEnabled(true);
						btnGramme1.setEnabled(false);
						btnGramme2.setEnabled(false);
					} else {
						btnGramme1.setEnabled(true);
						btnGramme2.setEnabled(true);
						listeCouleur.setEnabled(false);
					}
					try {
						if (INDEX > catalogue.getCatalogue().size() - 1) {
							INDEX = 0;
						} else {
							INDEX++;
						}
						afficherArticle(INDEX);
					} catch (IndexOutOfBoundsException | NullPointerException | BLLException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			panelIcon.add(btnFlecheGauche);
			panelIcon.add(btnNouveau);
			panelIcon.add(btnSauvegarde);
			panelIcon.add(btnSupprime);
			panelIcon.add(btnFlecheDroite);
		}
		return panelIcon;
	}

	public void afficherArticle(int i) {
		Article article = null;
		try {
			article = CatalogueManager.getCatalogue().get(i);
			selectedId = article.getIdArticle();
			txtReference.setText(article.getReference());
			txtDesignation.setText(article.getDesignation());
			txtMarque.setText(article.getMarque());
			txtStock.setText(String.valueOf(article.getQteStock()));
			txtPrix.setText(String.valueOf(article.getPrixUnitaire()));
			if (article instanceof Ramette) {
				btnRamette.setSelected(true);
				btnGramme1.setEnabled(true);
				btnGramme2.setEnabled(true);
				listeCouleur.setEnabled(false);
				if (((Ramette) article).getGrammage() == 80) {
					btnGramme1.setSelected(true);
				} else {
					btnGramme2.setSelected(true);
				}
			}
			if (article instanceof Stylo) {
				btnGroup2.clearSelection();
				btnGramme1.setEnabled(false);
				btnGramme2.setEnabled(false);
				listeCouleur.setEnabled(true);
				btnRamette.setSelected(false);
				btnStylo.setSelected(true);
				if (((Stylo) article).getCouleur().equalsIgnoreCase("jaune")) {
					listeCouleur.setSelectedIndex(5);
				} else if (((Stylo) article).getCouleur().equalsIgnoreCase("noir")) {
					listeCouleur.setSelectedIndex(4);
				} else if (((Stylo) article).getCouleur().equalsIgnoreCase("bleu")) {
					listeCouleur.setSelectedIndex(3);
				} else if (((Stylo) article).getCouleur().equalsIgnoreCase("vert")) {
					listeCouleur.setSelectedIndex(2);
				} else if (((Stylo) article).getCouleur().equalsIgnoreCase("rouge")) {
					listeCouleur.setSelectedIndex(1);
				} else {
					listeCouleur.setSelectedIndex(0);
				}
			}
			System.out.println(article);
		} catch (IndexOutOfBoundsException | NullPointerException | BLLException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public Article createArticle(int index) throws BLLException, SQLException {
		Article art = null;
		try {
			if (btnStylo.isSelected()) {
				if (index == 0) {
					art = new Stylo(txtMarque.getText(), txtReference.getText(), txtDesignation.getText(),
							Float.parseFloat(txtPrix.getText()), Integer.parseInt(txtStock.getText()),
							selected.toString());
				} else {
					art = new Stylo(index, txtMarque.getText(), txtReference.getText(), txtDesignation.getText(),
							Float.parseFloat(txtPrix.getText()), Integer.parseInt(txtStock.getText()),
							selected.toString());
				}
			} else {
				int grammage = 0;
				if (btnGramme1.isSelected()) {
					grammage = 80;
				} else {
					grammage = 100;
				}

				if (index == 0) {
					art = new Ramette(txtMarque.getText(), txtReference.getText(), txtDesignation.getText(),
							Float.parseFloat(txtPrix.getText()), Integer.parseInt(txtStock.getText()), grammage);
				} else {
					art = new Ramette(index, txtMarque.getText(), txtReference.getText(), txtDesignation.getText(),
							Float.parseFloat(txtPrix.getText()), Integer.parseInt(txtStock.getText()), grammage);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Merci de remplir correctement les champs");
			throw new BLLException("Erreur - Champs manquants");
		}
		return art;
	}
}
