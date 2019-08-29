package controller;

import java.io.IOException;
import java.util.List;

import mappings.CourseMapperDao;
import mappings.GroupMapperDao;
import mappings.GroupSecernMapperDao;
import mappings.PortfolioConfigurationCourseMapperDao;
import mappings.PortfolioCourseUnitLevelMapperDao;
import mappings.PortfolioCourseUnitMapperDao;
import mappings.PortfolioGroupMapperDao;
import mappings.QuestionAttributeMapperDao;
import mappings.ServicePortfolioConfigurationMapperDao;
import mappings.ServicePortfolioCourseMapperDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import utility.FileWriterUtils;
import utility.LibraryConstant;
import utility.MessengeUtils;
import entity.Course;
import entity.Group;
import entity.GroupSecern;
import entity.PortfolioConfigurationCourse;
import entity.PortfolioCourseUnit;
import entity.PortfolioCourseUnitLevel;
import entity.QuestionAttribute;
import entity.ServicePortfolioConfiguration;
import entity.ServicePortfolioConfigurationWrapper;
import entity.ServicePortfolioCourse;

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
	@Autowired
	PortfolioCourseUnitLevelMapperDao pculDao;
	@Autowired
	GroupSecernMapperDao gsmDao;
	@Autowired
	GroupMapperDao groupDao;
	@Autowired
	CourseMapperDao courseDao;
	@Autowired
	QuestionAttributeMapperDao qaDao;

	// Show form Edit
	@RequestMapping("/edit/{id_spcf}")
	public String show_form_edit(ModelMap modelMap, @PathVariable("id_spcf") int id_spcf) throws IOException {

		System.out.println("id : " + id_spcf);

		// hien thi danh sach group
		try {
			// object bing to view
			ServicePortfolioConfigurationWrapper spcw = new ServicePortfolioConfigurationWrapper();

			List<GroupSecern> listGroupSecern = gsmDao.selectAllGroupSecern();
			List<Group> listGroupName = grDao.selectGroupNameAndGsNameById(id_spcf);
			
			for (int i = 0; i < listGroupSecern.size(); i++) {
				GroupSecern groupSecern = listGroupSecern.get(i);
				List<Group> groupList = groupDao.selectGroupByGroupSecernId(groupSecern.getId());
				// add default value to group
				groupList.add(0, new Group(-1, "Chưa thiết lập"));
				
				for (int j = 0; j < groupList.size(); j++) {
					for (int k = 0; k < listGroupName.size(); k++) {
						if (groupList.get(j).getId() == listGroupName.get(k).getId()) {
							groupList.get(j).setIsSelected(1);
							break;
						}
					}
				}

				// load group include groupSecern
				listGroupSecern.get(i).setGroups(groupList);
			}
			
			
			 ServicePortfolioConfiguration objSPCF = spcfDao.selectServicePortfolioConfigurationById(id_spcf);
			 if(objSPCF != null){
				 modelMap.addAttribute("objSPCF", objSPCF);
			 }

			// wrap object spcw coverlistGroupSecern
			spcw.setGss(listGroupSecern);

			
			List<ServicePortfolioCourse> servicePortfolioCourses = spcDao.selectServicePortfolioCourseByServiceID(LibraryConstant.SERVER_ID);
			List<PortfolioConfigurationCourse> pccs = pccDao.selectPortfolioConfigurationCourseBySPCId(id_spcf);
			System.out.println(pccs);
			
			for (ServicePortfolioCourse one_spc : servicePortfolioCourses) {
				// add course name for spc
				Course course = courseDao.selectCourseById(one_spc.getCourse_id());
				one_spc.setCourse_name(course.getCourse_name());
				
				
				//dang coding .....
				
				// add course name for spc
					for (PortfolioConfigurationCourse objPCC : pccs) {
						if (one_spc.getId() == objPCC.getService_portfolio_course_id()) {
							one_spc.setIsSelected(1);
							one_spc.setLevel_selected(objPCC.getLevel());
							
							List<PortfolioCourseUnitLevel> level_list = pculDao
									.selectPortfolioCourseUnitLevelBySPCourseId(one_spc.getId());
							one_spc.setLevel_list(level_list);
							for (PortfolioCourseUnitLevel one_lv : level_list) {
								List<PortfolioCourseUnit> portfolioCourseUnits = pcuDao
										.selectPortfolioCourseUnitByPCULId(one_lv.getId());
								one_lv.setQuestion_attribute_list(portfolioCourseUnits);
								for (PortfolioCourseUnit pcu : portfolioCourseUnits) {
									QuestionAttribute qa = qaDao
											.selectQuestionAttributeById(pcu.getQuestion_attribute_id());
									pcu.setQuestion_attribute_name(qa.getQuestion_attribute_name());
								}
							}
						}
					}
				
			}
			
			
			// wrap object spcw cover servicePortfolioCourses
			spcw.setSpcs(servicePortfolioCourses);

			// add attribute prepare load into view
			modelMap.addAttribute("spcwoutput", spcw);
		} catch (Exception e) {
			MessengeUtils utils = new MessengeUtils();
			utils.new_error_message("Server đang gặp sự cố");
			FileWriterUtils.writeFile("CreatPortfolioController_Show_form_create", e.getMessage());
			// ra.addFlashAttribute("msg", e.getMessage());
			return "redirect:/admin/portfolio/index";
		}

		return "admin.portfolio.edit";
	}

	


}
