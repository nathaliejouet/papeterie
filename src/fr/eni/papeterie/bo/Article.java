package fr.eni.papeterie.bo;

public abstract class Article {

	private Integer idArticle;
	private String reference;
	private String marque;
	private String designation;
	private float prixUnitaire;
	private int qteStock;


	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Article : [idArticle = " + this.getIdArticle() + " , reference = " + this.getReference()
				+ ", marque = " + this.getMarque() + ", designation = " + this.getDesignation() + ", prix unitaire = "
				+ this.getPrixUnitaire() + ", qteStock = " + this.getQteStock() + "]");

		return result.toString();

	}

}
