package org.aposalo.tvscanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.aposalo.tvscanner.model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Product product) {
		String query = "insert into products (name, year, stars, directors, actors, category) values (?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setDate(2, product.getYear());
			ps.setFloat(3, product.getStars());
			ps.setString(4, product.getDirectors());
			ps.setString(5, product.getActors());
			ps.setString(6, product.getCategory());
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Product> read() {
		String query = "Select * from products order by year";
		ArrayList<Product> databaseProducts = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setName(rs.getString("name"));
				product.setYear(rs.getDate("year"));
				product.setStars(rs.getFloat("stars"));
				product.setActors(rs.getString("actors"));
				product.setDirectors(rs.getString("directors"));
				product.setCategory(rs.getString("category"));
				databaseProducts.add(product);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return databaseProducts;
	}

	public void update(Product product) {//TODO updates element from database
		String query = "update ignore products set name = ?, year = ?, stars = ?, directors = ?, actors = ?, category = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setDate(2, product.getYear());
			ps.setFloat(3, product.getStars());
			ps.setString(4, product.getDirectors());
			ps.setString(5, product.getActors());
			ps.setString(6, product.getCategory());
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(Product product) {
		String query = "delete from products where name = ? and year = ?;";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setDate(2, product.getYear());
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
