package fr.eni.papeterie.bo;

public class Ramette extends Article {

	private int grammage;

	public Ramette() {

	}
	
	public Ramette(Integer idArticle, String marque, String ref,  String designation, float pu, int qte, int grammage) {
		setIdArticle(idArticle);
		setReference(ref);
		setMarque(marque);
		setDesignation(designation);
		setPrixUnitaire(pu);
		setQteStock(qte);
		setGrammage(grammage);
	}

	public Ramette( String marque, String ref,  String designation, float pu, int qte, int grammage) {
		this(null, marque, ref, designation, pu, qte, grammage);
	}


	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Article : [idArticle = " + this.getIdArticle() + ", reference = " + this.getReference()
				+ ", marque = " + this.getMarque() + ", designation = " + this.getDesignation() + ", prix unitaire = "
				+ this.getPrixUnitaire() + ", qteStock = " + this.getQteStock() + "]" + " Ramette [grammage = "
				+ this.getGrammage() + "]");

		return result.toString();
	}

}
