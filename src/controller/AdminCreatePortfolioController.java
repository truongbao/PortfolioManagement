package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Course;
import entity.Group;
import entity.GroupSecern;
import entity.PortfolioConfigurationCourse;
import entity.PortfolioGroup;
import entity.ServicePortfolioConfiguration;
import entity.ServicePortfolioConfigurationWrapper;
import mappings.CourseMapperDao;
import mappings.GroupMapperDao;
import mappings.GroupSecernMapperDao;
import mappings.PortfolioConfigurationCourseMapperDao;
import mappings.PortfolioGroupMapperDao;
import mappings.ServicePortfolioConfigurationMapperDao;
import utility.LibraryConstant;

@Controller
@RequestMapping("admin/portfolio")
public class AdminCreatePortfolioController {

	@Autowired
	GroupSecernMapperDao gsmDao;
	@Autowired
	GroupMapperDao groupDao;
	@Autowired
	CourseMapperDao courseDao;
	@Autowired
	ServicePortfolioConfigurationMapperDao spcfDao;
	@Autowired
	PortfolioGroupMapperDao pgDao;
	@Autowired
	PortfolioConfigurationCourseMapperDao pccDao;

	// Show form Create
	@RequestMapping("/create")
	public String show_form_create(ModelMap modelMap) throws IOException {

		List<GroupSecern> listGroupSecern = gsmDao.selectAllGroupSecern();
		for (GroupSecern groupSecern : listGroupSecern) {
			List<Group> groupList = groupDao.selectGroupByGroupSecernId(groupSecern.getId());
			// add default value to group
			groupList.add(0, new Group(-1, "Chưa thiết lập"));
			// load group include groupSecern
			groupSecern.setGroups(groupList);
		}
		modelMap.addAttribute("listGroupSecern", listGroupSecern);
		List<Course> listCourse = courseDao.selectCourseByServerId(LibraryConstant.SERVER_ID);
		modelMap.addAttribute("listCourse", listCourse);
		return "admin.portfolio.create";
	}

	// Processing create
	@RequestMapping(value = "/insert_spc", method = RequestMethod.POST)
	public String processing_create(ModelMap modelMap,
			@ModelAttribute("spcw") ServicePortfolioConfigurationWrapper spcfw) throws IOException {

		// get current_time
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		// insert new ServicePortfolioConfiguration
		ServicePortfolioConfiguration new_spcf = spcfw.getSpcf();
		new_spcf.setCreated_at(timestamp);

		// check insert new_spcf state
		//int ck = spcfDao.insertServicePortfolioConfiguration(new_spcf);

//		if (ck > 0) {
			// insert new ServicePortfolioConfiguration
			List<PortfolioGroup> pgs = spcfw.getPgs();
			for (PortfolioGroup new_pg : pgs) {
				// insert row by row new PortfolioGroup
				new_pg.setCreated_at(timestamp);
				
				// set new service_portfolio_configuration_id

				//pgDao.insertPortfolioGroup(new_pg);
			}
			// insert new PortfolioConfigurationCourses
			
			List<PortfolioConfigurationCourse> pccs = spcfw.getPccs();
			System.out.println(pccs);
			for (PortfolioConfigurationCourse new_pcc : pccs) {
				// insert row by row new PortfolioConfigurationCourse
				new_pcc.setCreated_at(timestamp);
				// set new service_portfolio_configuration_id

//				pccDao.insertPortfolioConfigurationCourse(new_pcc);
			}
//		}

		return "admin.portfolio.create";
	}
}
