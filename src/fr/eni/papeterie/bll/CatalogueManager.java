package fr.eni.papeterie.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;
import fr.eni.papeterie.ihm.EcranPapeterie;

public class CatalogueManager {

	private static ArticleDAO daoArticle;

	public CatalogueManager() throws BLLException {
		daoArticle = DAOFactory.getArticleDAO();
	}

	public static List<Article> getCatalogue() throws BLLException, SQLException {
		List<Article> articles = null;
		try {
			articles = daoArticle.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération catalogue");
		}
		return articles;
	}

	public void removeArticle(Article art) throws BLLException, SQLException {
		try {
			daoArticle.delete(art.getIdArticle());
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur suppression article ");
		}
	}

	public void updateArticle(Article art) throws BLLException, SQLException {
		try {
			System.out.println(art);
			validerArticle(art);
			daoArticle.update(art);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException ("Erreur modification article ");
		}
	}

	public void addArticle(Article art) throws BLLException, SQLException {
		try {
			daoArticle.insert(art);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur ajout article ");
		}
	}
	
	public void validerArticle (Article art) throws BLLException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();
		if (art == null) {
			throw new BLLException ("Article null");
		}
		
		if(art.getReference()== null || art.getReference().trim().length()== 0) {
			sb.append("La reference article est obligatoire.\n");
			valide = false;
		}
		
		if(art.getMarque()== null || art.getMarque().trim().length()== 0) {
			sb.append("La marque  est obligatoire.\n");
			valide = false;
		}
		
		if(art.getDesignation()== null || art.getDesignation().trim().length()== 0) {
			sb.append("La designation  est obligatoire.\n");
			valide = false;
		}
		
		if(art instanceof Ramette && ((Ramette)art).getGrammage()<=0){
			sb.append("Le grammage doit avoir une valeur positive.\n");
			valide = false;
		}
		
		if(art instanceof Stylo ) {
			Stylo s = (Stylo) art;
			if(s.getCouleur()==null || s.getCouleur().trim().length()==0){
				sb.append("La couleur pour un stylo  est obligatoire.\n");
				valide = false;
			}
		}
		
		if(!valide) {
			throw new BLLException(sb.toString());
		}
	}
}
