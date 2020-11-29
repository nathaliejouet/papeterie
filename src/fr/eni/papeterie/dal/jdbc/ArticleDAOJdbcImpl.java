package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String TYPE_STYLO = "Stylo";

	// Constructeur
	public ArticleDAOJdbcImpl() {

	}

	@Override
	public void insert(Article a1) throws DALException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int articleId = 0;
		String sql = "INSERT INTO dbo.Articles(reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type) VALUES(?,?,?,?,?,?,?,?)";
		try {
			con = JdbcTools.getConnection();
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, a1.getReference());
			pstmt.setString(2, a1.getMarque());
			pstmt.setString(3, a1.getDesignation());
			pstmt.setFloat(4, a1.getPrixUnitaire());
			pstmt.setInt(5, a1.getQteStock());
			if (a1 instanceof Stylo) {
				pstmt.setNull(6, Types.INTEGER);
				pstmt.setString(7, ((Stylo) a1).getCouleur());
				pstmt.setString(8, "Stylo");
			} else {
				pstmt.setInt(6, ((Ramette) a1).getGrammage());
				pstmt.setString(7, null);
				pstmt.setString(8, "Ramette");
			}
			int rst = pstmt.executeUpdate();
			if (rst == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					articleId = rs.getInt(1);
				}
			}
			a1.setIdArticle(articleId);
		} catch (SQLException e) {
			throw new DALException("Insert article failed - " + a1, e);
		}
	}

	@Override
	public Article selectById(Integer integer) throws DALException {
		Article article = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type "
				+ " FROM articles where idArticle = ?";
		try {
			con = JdbcTools.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, integer);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("idArticle");
				String reference = rs.getString("reference");
				String marque = rs.getString("marque");
				String designation = rs.getString("designation");
				float pu = rs.getFloat("prixUnitaire");
				int qteStock = rs.getInt("qteStock");
				if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {
					String couleur = rs.getString("couleur");
					article = new Stylo(id, marque, reference, designation, pu, qteStock, couleur);
				} else {
					int grammage = rs.getInt("grammage");
					article = new Ramette(id, marque, reference, designation, pu, qteStock, grammage);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	public List<Article> selectAll() throws DALException {
		List<Article> articles = new ArrayList<Article>();
		String sql = "SELECT * FROM dbo.Articles";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			con = JdbcTools.getConnection();
			preparedStatement = con.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Article article = null;
				Integer id = rs.getInt("idArticle");
				String reference = rs.getString("reference");
				String marque = rs.getString("marque");
				String designation = rs.getString("designation");
				float pu = rs.getFloat("prixUnitaire");
				int qteStock = rs.getInt("qteStock");
				String type = rs.getString("type");

				if (type.trim().equals(TYPE_STYLO)) {
					String couleur = rs.getString("couleur");
					article = new Stylo(id, marque, reference, designation, pu, qteStock, couleur);
				} else {
					int grammage = rs.getInt("grammage");
					article = new Ramette(id, marque, reference, designation, pu, qteStock, grammage);
				}
				articles.add(article);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public void update(Article a1) throws DALException, SQLException {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = JdbcTools.getConnection();
			String sql = "UPDATE dbo.Articles SET reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur=? where idArticle=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, a1.getReference());
			preparedStatement.setString(2, a1.getMarque());
			preparedStatement.setString(3, a1.getDesignation());
			preparedStatement.setFloat(4, a1.getPrixUnitaire());
			preparedStatement.setInt(5, a1.getQteStock());
			if (a1 instanceof Stylo) {
				preparedStatement.setString(7, ((Stylo) a1).getCouleur());
				preparedStatement.setNull(6, Types.INTEGER);
			} else {
				preparedStatement.setInt(6, ((Ramette) a1).getGrammage());
				preparedStatement.setNull(7, Types.VARCHAR);
			}
			preparedStatement.setInt(8, a1.getIdArticle());
			preparedStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed - ", e);
			}
		}
	}

	@Override
	public void delete(Integer idArticle) throws DALException, SQLException {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = JdbcTools.getConnection();
			String sql = "DELETE FROM dbo.Articles WHERE idArticle=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, idArticle);
			preparedStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
