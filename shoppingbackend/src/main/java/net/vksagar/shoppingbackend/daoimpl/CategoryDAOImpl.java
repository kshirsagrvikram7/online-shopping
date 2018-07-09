package net.vksagar.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.vksagar.shoppingbackend.dao.CategoryDAO;
import net.vksagar.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	private static List<Category> categoryList = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is description for TV");
		category.setImageURL("CAT_1.png");
		
		categoryList.add(category);
		
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is description for Mobile");
		category.setImageURL("CAT_2.png");
		
		categoryList.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is description for Laptop");
		category.setImageURL("CAT_3.png");
		
		categoryList.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		
		return categoryList;
	}

	@Override
	public Category get(int id) {
		for(Category category : categoryList) {
			if(category.getId() == id)
				return category;
		}
		return null;
	}

}
