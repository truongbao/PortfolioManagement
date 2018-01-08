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
import entity.PortfolioGroup;
import entity.ServicePortfolioConfiguration;
import entity.ServicePortfolioCourse;
import mappings.GroupMapperDao;
import mappings.PortfolioConfigurationCourseMapperDao;
import mappings.PortfolioCourseUnitMapperDao;
import mappings.PortfolioGroupMapperDao;
import mappings.ServicePortfolioConfigurationMapperDao;
import mappings.ServicePortfolioCourseMapperDao;
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

	@RequestMapping("/delete/{id_spcf}")
	public String deleted(ModelMap modelMap, @PathVariable("id_spcf") int id_spcf, RedirectAttributes ra)
			throws IOException {
		MessengeUtils messengeUtils = new MessengeUtils();
		
		if (pccDao.updatePortfolioConfigurationCourseByis_deleted(id_spcf) > 0) {
			if (spcfDao.updateServicePortfolioConfigurationIs_Delete(id_spcf) > 0) {
				if (pgDao.updatePortfolioGroupByis_deleted(id_spcf) > 0) {
					messengeUtils.new_sucess_message("Xóa thành công !");
				} else {
					messengeUtils.new_sucess_message("Xóa thành công  !");
				}
			} else {
				messengeUtils.new_error_message("Xóa không thành công ở bảng ServicePortfolioConfiguration !");
			}
		} else {
			messengeUtils.new_error_message("Xóa không thành công ở bảng PortfolioConfigurationCourse !");
		}
		
		ra.addFlashAttribute("msg", messengeUtils);
		 
		 return "redirect:/admin/portfolio/index"; 

	}
}
