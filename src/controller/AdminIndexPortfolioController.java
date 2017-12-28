package controller;

import java.io.IOException;
import java.util.List;

import mappings.ServicePortfolioConfigurationMapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import utility.Session;
import entity.ServicePortfolioConfiguration;

@Controller
@RequestMapping("admin/portfolio")
public class AdminIndexPortfolioController {
	

	@RequestMapping("/index")
	public String index(ModelMap modelMap) throws IOException {
		
		ServicePortfolioConfigurationMapper configurationMapper = Session.session().getMapper(ServicePortfolioConfigurationMapper.class);
		
		List<ServicePortfolioConfiguration> listSPConfiguration = configurationMapper.selectAll();
		modelMap.addAttribute("listSPConfiguration", listSPConfiguration);
		
		return "admin.portfolio.index";
	}

	// get lại thông tin portfolio khi click button[Update]
	@RequestMapping("/index/{refresh}")
	public String reload_index(ModelMap modelMap, @PathVariable("refresh") String refresh) throws IOException {

		// get listSPConfiguration
		ServicePortfolioConfigurationMapper configurationMapper = Session.session().getMapper(ServicePortfolioConfigurationMapper.class);
		List<ServicePortfolioConfiguration> listSPConfiguration = configurationMapper.selectAll();
		modelMap.addAttribute("listSPConfiguration", listSPConfiguration);

		return "admin.portfolio.index";
	}
	

	
}
