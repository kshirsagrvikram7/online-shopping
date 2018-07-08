package net.vksagar.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to Spring MVC!");
		
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
