package net.vksagar.shoppingbackend.dao;

import java.util.List;

import net.vksagar.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);
}
