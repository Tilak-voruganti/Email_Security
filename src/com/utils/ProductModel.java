package com.utils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configurations.AppConfig;



public class ProductModel {

	private List<Product> products;

	/*
	 * public ProductModel() { products = new ArrayList<>(); products.add(new
	 * Product("p01", "computer 1", 20)); products.add(new Product("p02",
	 * "computer 2", 21)); products.add(new Product("p03", "laptop 1", 22));
	 * products.add(new Product("p04", "laptop 2", 3)); products.add(new
	 * Product("p05", "laptop 3", 7)); }
	 */

	public List<String> search(String keyword) throws ClassNotFoundException, SQLException {
		ResultSet rs=AppConfig.getDao().getEmails1();
		List<String> names = new ArrayList<String>();
		while(rs.next()) {
			names.add(rs.getString(1));
		}
	
		/*
		 * for (Product product : products) { if
		 * (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
		 * names.add(product.getName()); } }
		 */
		return names;
	}

}