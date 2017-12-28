package controller;

import java.io.IOException;
import java.util.List;

import mappings.ServicePortfolioConfigurationMapperDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.ServicePortfolioConfiguration;

@Controller
@RequestMapping("admin/portfolio")
public class AdminIndexPortfolioController {
	
	
	@Autowired
	ServicePortfolioConfigurationMapperDao spcDao;

	@RequestMapping("/index")
	public String index(ModelMap modelMap) throws IOException {
		
		List<ServicePortfolioConfiguration> listSPConfiguration = spcDao.selectAll();
		modelMap.addAttribute("listSPConfiguration", listSPConfiguration);
		
		return "admin.portfolio.index";
	}

	// get lại thông tin portfolio khi click button[Update]
	@RequestMapping("/index/{refresh}")
	public String reload_index(ModelMap modelMap, @PathVariable("refresh") String refresh) throws IOException {

		List<ServicePortfolioConfiguration> listSPConfiguration = spcDao.selectAll();
		modelMap.addAttribute("listSPConfiguration", listSPConfiguration);

		return "admin.portfolio.index";
	}
	

	
}
