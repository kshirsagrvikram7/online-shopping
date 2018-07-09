package net.vksagar.shoppingbackend.dao;

import java.util.List;

import net.vksagar.shoppingbackend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);
	
	List<Category> list();
	
	Category get(int id);
}
