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
import entity.ServicePortfolioCourse;
import mappings.CourseMapperDao;
import mappings.GroupMapperDao;
import mappings.GroupSecernMapperDao;
import mappings.PortfolioConfigurationCourseMapperDao;
import mappings.PortfolioGroupMapperDao;
import mappings.ServicePortfolioConfigurationMapperDao;
import mappings.ServicePortfolioCourseMapperDao;
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
	@Autowired
	ServicePortfolioCourseMapperDao spcDao;

	// Show form Create
	@RequestMapping("/create")
	public String show_form_create(ModelMap modelMap) throws IOException {
		
		//object bing to view
		ServicePortfolioConfigurationWrapper spcw = new ServicePortfolioConfigurationWrapper();

		List<GroupSecern> listGroupSecern = gsmDao.selectAllGroupSecern();
		for (GroupSecern groupSecern : listGroupSecern) {
			List<Group> groupList = groupDao.selectGroupByGroupSecernId(groupSecern.getId());
			// add default value to group
			groupList.add(0, new Group(-1, "Chưa thiết lập"));
			// load group include groupSecern
			groupSecern.setGroups(groupList);
		}

		// wrap object spcw coverlistGroupSecern
		spcw.setGss(listGroupSecern);

		List<ServicePortfolioCourse> servicePortfolioCourses = spcDao
				.selectServicePortfolioCourseByServiceID(LibraryConstant.SERVER_ID);
		for (ServicePortfolioCourse one_spc : servicePortfolioCourses) {
			// add course name for spc
			Course course = courseDao.selectCourseById(one_spc.getCourse_id());
			one_spc.setCourse_name(course.getCourse_name());
		}
		// wrap object spcw cover servicePortfolioCourses
		spcw.setSpcs(servicePortfolioCourses);

		// add attribute prepare load into view
		modelMap.addAttribute("spcwoutput", spcw);

		return "admin.portfolio.create";
	}

	// Processing create
	@RequestMapping(value = "/insert_spc", method = RequestMethod.POST)
	public String processing_create(ModelMap modelMap,
			@ModelAttribute("spcw") ServicePortfolioConfigurationWrapper spcfw) throws IOException {

		// spcfDao.computeNextID()
		// genarate new spcf id
		int spcf_id = spcfDao.computeNextID();
		// get current_time
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		// insert new ServicePortfolioConfiguration
		ServicePortfolioConfiguration new_spcf = spcfw.getSpcf();
		new_spcf.setId(spcf_id);
		new_spcf.setCreated_at(timestamp);
		new_spcf.setService_id(LibraryConstant.SERVER_ID);
		new_spcf.setState(LibraryConstant.INCOMPLETE);
		// check insert new_spcf state
		int ck = spcfDao.insertServicePortfolioConfiguration(new_spcf);

		if (ck > 0) {
			// insert new ServicePortfolioConfiguration
			List<PortfolioGroup> pgs = spcfw.getPgs();
			for (PortfolioGroup new_pg : pgs) {
				// loại bỏ những group có giá trị -1 = "chưa thiết lập"
				if (new_pg.getGroup_id() != -1) {
					// insert row by row new PortfolioGroup
					new_pg.setCreated_at(timestamp);
					new_pg.setService_portfolio_configuration_id(spcf_id);

					pgDao.insertPortfolioGroup(new_pg);
				}
			}
			List<PortfolioConfigurationCourse> pccs = spcfw.getPccs();
			for (PortfolioConfigurationCourse new_pcc : pccs) {
				// insert row by row new PortfolioConfigurationCourse
				new_pcc.setCreated_at(timestamp);
				// set new service_portfolio_configuration_id
				new_pcc.setService_portfolio_configuration_id(spcf_id);
				pccDao.insertPortfolioConfigurationCourse(new_pcc);
			}
		}
		return "admin.portfolio.create";
	}
}
