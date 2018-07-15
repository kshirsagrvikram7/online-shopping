package net.vksagar.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundExcetion() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Page is not contructed");
		mv.addObject("errorDescription", "The page you are looking for is not available.");
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		
		//Only for debugging app
		//StringWriter sw = new StringWriter();
		//PrintWriter pw = new PrintWriter(sw);
		//ex.printStackTrace(pw);
		mv.addObject("errorTitle", "Contact your administrator!");
		mv.addObject("errorDescription", ex.toString());
		//mv.addObject("errorDescription", sw.toString()); //For debugging only
		mv.addObject("title", "Error");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not available");
		mv.addObject("errorDescription", "The product you are looking for is not available right now.");
		mv.addObject("title", "Product unavailable");
		
		return mv;
	}
}
