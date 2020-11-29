package fr.eni.papeterie.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.papeterie.bo.Article;

public interface ArticleDAO {

	public List<Article> selectAll() throws DALException, SQLException;

	public void insert(Article a) throws DALException, SQLException;

	public Article selectById(Integer integer) throws DALException, SQLException;

	public void update(Article a) throws DALException, SQLException;

	public void delete(Integer idArticle) throws DALException, SQLException;

}
