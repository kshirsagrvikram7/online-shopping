package net.vksagar.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.vksagar.onlineshopping.util.FileUploadUtility;
import net.vksagar.shoppingbackend.dao.CategoryDAO;
import net.vksagar.shoppingbackend.dao.ProductDAO;
import net.vksagar.shoppingbackend.dto.Category;
import net.vksagar.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",  required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product submitted successfully.");
			}
		}
		
		return mv;
		
	}
	
	//handle Product submission to DB
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") @Valid Product mProduct,
			BindingResult results, Model model,
			HttpServletRequest request) {
		
		//check if there are any errors
		if(results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product submission.");
			
			return "page";
		}
		logger.info(mProduct.toString());
		
		productDAO.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCatagories() {
		return categoryDAO.list();
	}
}
