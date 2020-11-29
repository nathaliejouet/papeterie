package fr.eni.papeterie.bo;

public class Stylo extends Article {

	private String couleur;

	public Stylo() {

	}

	public Stylo(Integer idArticle, String marque, String ref, String designation, float pu, int qte, String couleur) {
		setIdArticle(idArticle);
		setMarque(marque);
		setReference(ref);
		setDesignation(designation);
		setPrixUnitaire(pu);
		setCouleur(couleur);
		setQteStock(qte);
	}

	public Stylo(String marque, String ref, String designation, float pu, int qte, String couleur) {
		this(null, marque, ref, designation, pu, qte, couleur);
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Article : [idArticle = " + this.getIdArticle() + " , reference = " + this.getReference()
				+ " , marque = " + this.getMarque() + ", designation = " + this.getDesignation() + ", prix unitaire = "
				+ this.getPrixUnitaire() + ", qteStock = " + this.getQteStock() + "]" + " Stylo [couleur = "
				+ this.getCouleur() + "]");

		return result.toString();
	}
}
