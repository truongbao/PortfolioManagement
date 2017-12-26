package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin/portfolio")
public class AdminEditPortfolioController {
	 
	 
	 //Show form Edit
	 @RequestMapping("/edit")
	 public String show_form_edit(ModelMap modelMap){
		 
		 
		return "admin.portfolio.edit";
	 }
	 
	 
	 //Processing edit
	 @RequestMapping(value="/edit", method=RequestMethod.POST)
	 public String processing_edit(ModelMap modelMap){
		 
		 
		return "admin.portfolio.edit";
	 }
	 
	
}
