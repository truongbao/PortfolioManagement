package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.PortfolioGroup;

@Controller
@RequestMapping("admin/portfolio")
public class AdminCreatePortfolioController {
	
	 
	 
	 //Show form Create
	 @RequestMapping("/create")
	 public String show_form_create(ModelMap modelMap){
		return "admin.portfolio.create";
	 }
	 
	 //Processing create
	 @RequestMapping(value="/create", method=RequestMethod.POST)
	 public String processing_create(ModelMap modelMap, @ModelAttribute("objPG") PortfolioGroup objPG){
		 
		 
		return "admin.portfolio.create";
	 }
	 
	 
	 
	 
	
}
