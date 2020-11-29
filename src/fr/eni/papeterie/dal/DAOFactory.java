package fr.eni.papeterie.dal;

public class DAOFactory {
	public static ArticleDAO getArticleDAO() {
		ArticleDAO articleDAO = null;
		try {
			articleDAO = (ArticleDAO) Class.forName("fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return articleDAO;
	}

}
