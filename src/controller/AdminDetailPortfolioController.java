package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/portfolio")
public class AdminDetailPortfolioController {
	
	 
	 //See detail
	 @RequestMapping("/detail/{id_spcf}")
	 public String detail(ModelMap modelMap, @PathVariable("id_spcf") int id_spcf ){
		 
		 System.out.println("id : "+id_spcf);
		 
		return "admin.portfolio.detail";
	 }
	 
	 
	
	 
	 
	
}
