package fr.eni.papeterie.bo;

public class Ligne {

	private Article article;
	private int qte;

	public Ligne(Article article, int qte) {
		setArticle(article);
		setQte(qte);
	}

	public Article getArticle() {
		return article;
	}

	public int getQte() {
		return qte;
	}
	
	public float getPrix() {
		return article.getPrixUnitaire();
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

}
