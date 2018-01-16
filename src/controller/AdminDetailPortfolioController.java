package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import utility.FileWriterUtils;
import utility.MessengeUtils;

@Controller
@RequestMapping("admin/portfolio")
public class AdminDetailPortfolioController {

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

	// See detail
	/**
	 * 
	 * @param modelMap
	 * @param id_spcf
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/detail/{id_spcf}")
	public String detail(ModelMap modelMap, @PathVariable("id_spcf") int id_spcf) throws IOException {

		ServicePortfolioConfiguration listname = spcfDao.selectServicePortfolioConfigurationById(id_spcf);
		modelMap.addAttribute("listname", listname);

		List<Group> listPortfolioGroup = grDao.selectGroupNameAndGsNameById(id_spcf);

		modelMap.addAttribute("listPortfolioGroup", listPortfolioGroup);
		modelMap.addAttribute("id_spcf", id_spcf);

		List<ServicePortfolioCourse> listPortfolioCourse = spcDao.selectServicePortfolioCourseByCourseName(id_spcf);
		for (ServicePortfolioCourse servicePortfolioCourse : listPortfolioCourse) {
			System.out.println(servicePortfolioCourse.getCourse_id());
			System.out.println(servicePortfolioCourse.getLevel());
			List<PortfolioCourseUnit> listportfolioCourseUnit = pcuDao.selectqaBylevel_course(servicePortfolioCourse);
			PortfolioCourseUnitLevel courseUnitLevel = new PortfolioCourseUnitLevel();
			courseUnitLevel.setQuestion_attribute_list(listportfolioCourseUnit);
			List<PortfolioCourseUnitLevel> level_list = new ArrayList<>();
			level_list.add(courseUnitLevel);
			servicePortfolioCourse.setLevel_list(level_list);
		}

		modelMap.addAttribute("listPortfolioCourse", listPortfolioCourse);

		return "admin.portfolio.detail";
	}
	/**
	 * 
	 * @param modelMap
	 * @param id_spcf
	 * @param ra
	 * @return
	 * @throws IOException
	 */
	
	@RequestMapping("/delete/{id_spcf}")
	public String deleted(ModelMap modelMap, @PathVariable("id_spcf") int id_spcf, RedirectAttributes ra)
			throws IOException {
		

		try {

			int ck = spcfDao.delete_spcf(id_spcf);
			MessengeUtils utils = new MessengeUtils();
			if (ck == 0) {
				utils.new_error_message(" サーバーに問題がある ");
			} else {
				utils.new_sucess_message(" 成功した ");

			}
			ra.addFlashAttribute("msg", utils);
			return "redirect:/admin/portfolio/index";
			
		} catch (Exception e) {

			FileWriterUtils.writeFile("CreatPortfolioController_Show_form_create", e.getMessage());
			MessengeUtils utils = new MessengeUtils();
			utils.new_error_message(" サーバーに問題がある ");

			ra.addFlashAttribute("msg", utils);

			return "redirect:/admin/portfolio/index";
		}
		

	}
}
		

