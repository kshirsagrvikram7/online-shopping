package net.vksagar.shoppingbackend.dao;

import java.util.List;

import net.vksagar.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> getList();
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
