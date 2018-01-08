package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Group;
import entity.PortfolioCourseUnit;
import entity.PortfolioCourseUnitLevel;
import entity.ServicePortfolioConfiguration;
import entity.ServicePortfolioCourse;
import mappings.GroupMapperDao;
import mappings.PortfolioConfigurationCourseMapperDao;
import mappings.PortfolioCourseUnitMapperDao;
import mappings.PortfolioGroupMapperDao;
import mappings.ServicePortfolioConfigurationMapperDao;
import mappings.ServicePortfolioCourseMapperDao;

@Controller
@RequestMapping("admin/portfolio")
public class AdminEditPortfolioController {
	
	@Autowired
	ServicePortfolioConfigurationMapperDao spcfDao;
	@Autowired
	GroupMapperDao grDao;
	@Autowired
	ServicePortfolioCourseMapperDao spcDao;
	@Autowired
	PortfolioCourseUnitMapperDao pcuDao;
	@Autowired
	PortfolioConfigurationCourseMapperDao pccDao;
	@Autowired
	PortfolioGroupMapperDao pgDao;
	 
	 
	 //Show form Edit
	 @RequestMapping("/edit/{id_spcf}")
	 public String show_form_edit(ModelMap modelMap, @PathVariable("id_spcf") int id_spcf) throws IOException{
		 //System.out.println("id_spcf: "+id_spcf);
		 
            // 
			ServicePortfolioConfiguration listname = spcfDao.selectServicePortfolioConfigurationById(id_spcf);
			modelMap.addAttribute("listname", listname);

			List<Group> listPortfolioGroup = grDao.selectGroupNameAndGsNameById(id_spcf);

			modelMap.addAttribute("listPortfolioGroup", listPortfolioGroup);
			modelMap.addAttribute("id_spcf", id_spcf);

			List<ServicePortfolioCourse> listPortfolioCourse = spcDao.selectServicePortfolioCourseByCourseName(id_spcf);
			for (ServicePortfolioCourse servicePortfolioCourse : listPortfolioCourse) {
				
				//System.out.println(servicePortfolioCourse.getCourse_id());
				//System.out.println(servicePortfolioCourse.getLevel());
				
				List<PortfolioCourseUnit> listportfolioCourseUnit = pcuDao.selectqaBylevel_course(servicePortfolioCourse);
				
				PortfolioCourseUnitLevel courseUnitLevel = new PortfolioCourseUnitLevel();
				courseUnitLevel.setQuestion_attribute_list(listportfolioCourseUnit);
				
				List<PortfolioCourseUnitLevel> level_list = new ArrayList<>();
				level_list.add(courseUnitLevel);
				
				servicePortfolioCourse.setLevel_list(level_list);
			}

			modelMap.addAttribute("listPortfolioCourse", listPortfolioCourse);
		 
		 
		 
		return "admin.portfolio.edit";
	 }
	 
	 
	 //Processing edit
	 @RequestMapping(value="/edit", method=RequestMethod.POST)
	 public String processing_edit(ModelMap modelMap){
		 
		 
		return "admin.portfolio.edit";
	 }
	 
	
}
