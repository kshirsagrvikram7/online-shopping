package net.vksagar.onlineshopping.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.vksagar.shoppingbackend.dao.CategoryDAO;
import net.vksagar.shoppingbackend.dao.ProductDAO;
import net.vksagar.shoppingbackend.dto.Category;
import net.vksagar.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index() {
		logger.info("Inside index()-->");
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
	
	/**
	 * View Single Product
	 */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		//Update view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
}
