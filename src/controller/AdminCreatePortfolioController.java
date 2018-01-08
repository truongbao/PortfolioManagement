package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.Course;
import entity.Group;
import entity.GroupSecern;
import entity.PortfolioConfigurationCourse;
import entity.PortfolioCourseUnit;
import entity.PortfolioCourseUnitLevel;
import entity.PortfolioGroup;
import entity.QuestionAttribute;
import entity.ServicePortfolioConfiguration;
import entity.ServicePortfolioConfigurationWrapper;
import entity.ServicePortfolioCourse;
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
import utility.FileUtils;
import utility.LibraryConstant;
import utility.MessengeUtils;

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
	@Autowired
	PortfolioCourseUnitMapperDao pcuDao;
	@Autowired
	PortfolioCourseUnitLevelMapperDao pculDao;
	@Autowired
	QuestionAttributeMapperDao qaDao;

	// Show form Create
	@RequestMapping("/create")
	public String show_form_create(ModelMap modelMap, RedirectAttributes ra) throws IOException {
		try {
			// object bing to view
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
		} catch (Exception e) {
			MessengeUtils utils = new MessengeUtils();
			utils.new_error_message("Server đang gặp sự cố");
			FileUtils.writeFile("CreatPortfolioController_Show_form_create", e.getMessage());
			ra.addFlashAttribute("msg", e.getMessage());
			return "redirect:/admin/portfolio/index";
		}
		return "admin.portfolio.create";

	}

	// Processing create
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String processing_create(ModelMap modelMap,
			@ModelAttribute("spcw") @Valid ServicePortfolioConfigurationWrapper spcfw, BindingResult result,
			RedirectAttributes ra) throws IOException {

		/*
		 * if (result.hasErrors()) { List<FieldError> errors =
		 * result.getFieldErrors(); for (FieldError error : errors) {
		 * System.out.println(error.getObjectName() + " - " +
		 * error.getDefaultMessage()); } }
		 */
		try {
			if (result.hasErrors()) {
				List<GroupSecern> gss = spcfw.getGss();

				for (int i = 0; i < gss.size(); i++) {
					GroupSecern one_gs = gss.get(i);
					int current_select_gr = one_gs.getGroups().get(0).getId();
					// load lại dữ liệu cho one_gs

					one_gs = gsmDao.selectGroupSecernById(one_gs.getId());

					List<Group> groupList = groupDao.selectGroupByGroupSecernId(one_gs.getId());
					groupList.add(0, new Group(-1, "Chưa thiết lập"));
					if (current_select_gr != -1) {
						for (int j = 0; j < groupList.size(); j++) {
							if (groupList.get(j).getId() == current_select_gr) {
								groupList.get(j).setIsSelected(1);
								break;
							}
						}
					}
					gss.get(i).setGroups(groupList);
				}

				// select all spc from database
				List<ServicePortfolioCourse> spcs = spcDao
						.selectServicePortfolioCourseByServiceID(LibraryConstant.SERVER_ID);
				// select selected spc
				List<PortfolioConfigurationCourse> pccs = spcfw.getPccs();

				for (ServicePortfolioCourse one_spc : spcs) {
					// add course name for spc
					Course course = courseDao.selectCourseById(one_spc.getCourse_id());
					one_spc.setCourse_name(course.getCourse_name());
					if (pccs != null) {
						for (PortfolioConfigurationCourse one_pcc : pccs) {
							if (one_spc.getId() == one_pcc.getService_portfolio_course_id()) {
								one_spc.setIsSelected(1);
								one_spc.setLevel_selected(one_pcc.getLevel());
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
				}
				spcfw.setSpcs(spcs);

				modelMap.addAttribute("spcwoutput", spcfw);
				ra.addFlashAttribute("spcfw", spcfw);
				// return "redirect:/admin/portfolio/create";
				return "admin.portfolio.create";
			} else {

				// spcfDao.computeNextID() // genarate new spcf id
				int spcf_id = spcfDao.computeNextID(); // get current_time
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
					List<GroupSecern> gss = spcfw.getGss();
					System.out.println(gss);
					for (GroupSecern gs : gss) {
						// loại bỏ những group có giá trị -1 = "chưa thiết lập"
						PortfolioGroup new_pg = new PortfolioGroup();
						new_pg.setGroup_id(gs.getGroups().get(0).getId());
						if (new_pg.getGroup_id() != -1) {
							// insert row by row new PortfolioGroup
							new_pg.setCreated_at(timestamp);
							new_pg.setService_portfolio_configuration_id(spcf_id);
							ck *= pgDao.insertPortfolioGroup(new_pg);
						}
					}
					List<PortfolioConfigurationCourse> pccs = spcfw.getPccs();
					System.out.println(pccs);
					for (PortfolioConfigurationCourse new_pcc : pccs) {
						// insert row by row new PortfolioConfigurationCourse
						new_pcc.setCreated_at(timestamp);
						// set new service_portfolio_configuration_id
						new_pcc.setService_portfolio_configuration_id(spcf_id);
						ck *= pccDao.insertPortfolioConfigurationCourse(new_pcc);
					}
				}
				MessengeUtils messengeUtils = new MessengeUtils();
				if (ck > 0) {
					messengeUtils.new_sucess_message("Thêm Thành Công");

				} else {
					messengeUtils.new_error_message("Thêm Thất bại");
				}
				ra.addFlashAttribute("msg", messengeUtils);
				return "redirect:/admin/portfolio/index";
			}
		} catch (Exception e) {
			MessengeUtils utils = new MessengeUtils();
			utils.new_error_message("Server đang gặp sự cố");
			FileUtils.writeFile("CreatPortfolioController_Show_form_create", e.getMessage());
			ra.addFlashAttribute("msg", e.getMessage());
			return "redirect:/admin/portfolio/index";
		}
	}

}
