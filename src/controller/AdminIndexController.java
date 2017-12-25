package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/portfolio")
public class AdminIndexController {
	
	 @RequestMapping("/index")
	 public String index(ModelMap modelMap){
		return "admin.portfolio.index";
	 }
	 
	 @RequestMapping("/create")
	 public String add(ModelMap modelMap){
		return "admin.portfolio.create";
	 }
	 
	 
	 @RequestMapping("/detail")
	 public String detail(ModelMap modelMap){
		return "admin.portfolio.detail";
	 }
	 
	 @RequestMapping("/edit")
	 public String edit(ModelMap modelMap){
		return "admin.portfolio.edit";
	 }
	 
	 
	
}
