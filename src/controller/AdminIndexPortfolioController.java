package controller;

import java.io.IOException;
import java.util.List;

import mappings.ServicePortfolioConfigurationMapperDao;
import mappings.UpdateQuestionStateMapperDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.ServicePortfolioConfiguration;
import entity.UpdateQuestionState;

@Controller
@RequestMapping("admin/portfolio")
public class AdminIndexPortfolioController {
	
	@Autowired
	private ServicePortfolioConfigurationMapperDao spcDao;
	@Autowired
	private UpdateQuestionStateMapperDao uqsDao;
	
	/***
	 * 
	 * @param modelMap
	 * @throws IOException
	 */
	@ModelAttribute
	public void addCommonObject(ModelMap modelMap) throws IOException{
		List<ServicePortfolioConfiguration> listSPConfiguration = spcDao.selectAll();
	    modelMap.addAttribute("listSPConfiguration", listSPConfiguration);
	}
	
	
	/***
	 * 
	 * @return
	 */
	//show list portfolio setting
	@RequestMapping("/index")
	public String index(){
		 return "admin.portfolio.index";
	}
	
	
    /***
     * 
     * @return
     */
	// get lại thông tin portfolio khi click button[Update]
	@RequestMapping("/index/refresh")
	public String reload_index(){
		return "admin.portfolio.index";
	}
	
	
	/***
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	//Display processing in items 9 and 10 when click button [Update exercise information]
	@RequestMapping("/update-exercise-information")
	public String up(ModelMap modelMap) throws IOException {
		
		UpdateQuestionState objUQS = uqsDao.selectObjectUQSByState(); 
		modelMap.addAttribute("objUQS", objUQS);
		
		return "admin.portfolio.index";
	}
	
	
	
	
}
