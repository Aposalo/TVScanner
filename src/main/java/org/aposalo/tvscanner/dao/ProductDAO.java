package org.aposalo.tvscanner.dao;

import java.util.ArrayList;

import org.aposalo.tvscanner.model.Product;

public interface ProductDAO {//DAO Database Access Object
	
	public void create(Product product);
	
	public ArrayList<Product> read();
	
	public void update(Product product);
	
	public void delete(Product product);

}
