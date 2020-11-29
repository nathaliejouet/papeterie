package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {

	private List<Ligne> lignesPanier;
	private float montant;

	public Panier() {
		lignesPanier = new ArrayList<Ligne>();
	}

	public float getMontant() {
		return montant;
	}

	public Ligne getLigne(int i) {
		return lignesPanier.get(i);
	}

	public List<Ligne> getLignesPanier() {
		return lignesPanier;
	}

	public void addLigne(Article article, int qte) {
		lignesPanier.add(new Ligne(article, qte));
	}

	public void updateLigne(int index, int newQte) {
		lignesPanier.get(index).setQte(newQte);
	}

	public void removeLigne(int index) {
		lignesPanier.remove(index);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < lignesPanier.size(); i++) {
			result.append("Ligne " + i + " : Ligne [qte = " + lignesPanier.get(i).getQte() + " , prix = "
					+ lignesPanier.get(i).getPrix() + " , article = Article[idArticle = "
					+ lignesPanier.get(i).getArticle() + " ]");
			result.append("\n"); 

		}
		return result.toString();
	}

}
