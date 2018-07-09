package net.vksagar.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.vksagar.shoppingbackend.dao.CategoryDAO;
import net.vksagar.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		//passing categories list
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("userClickHome", true);
		
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout", true);
		
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact", true);
		
		return mv;
	}
	
	/**
	 * Method to load all products based on category
	 */
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		
		//passing categories list
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		
		return mv;
	}
	
	/**
	 * Method to load all products based on category
	 */
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		//categoryDAO to fetch single category
		Category category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		//passing categories list
		mv.addObject("categoryList", categoryDAO.list());
		//passing single category
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
	}
	
	/**
	 * Whole request : http://localhost:8080/onlineshopping/test?greeting=Hi
	 * @param greeting
	 * @return
	 */
/*	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting) {
		ModelAndView mv= new ModelAndView("page");
		if(greeting == null) {
			greeting = "Hello there";
		}
		mv.addObject("greeting", greeting);
		
		return mv;
	}*/
	
	/**
	 * Whole request : Whole request : http://localhost:8080/onlineshopping/test/Hi
	 * @param greeting
	 * @return
	 */
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		ModelAndView mv= new ModelAndView("page");
		if(greeting == null) {
			greeting = "Hello there";
		}
		mv.addObject("greeting", greeting);
		
		return mv;
	}
}
