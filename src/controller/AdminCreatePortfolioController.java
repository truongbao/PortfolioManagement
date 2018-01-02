package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mappings.CourseMapper;
import mappings.CourseMapperDao;
import mappings.GroupMapperDao;
import mappings.GroupSecernMapperDao;
import utility.LibraryConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Course;
import entity.Group;
import entity.GroupSecern;
import entity.PortfolioGroup;

@Controller
@RequestMapping("admin/portfolio")
public class AdminCreatePortfolioController {

	@Autowired
	GroupSecernMapperDao gsmDao;
	@Autowired
	GroupMapperDao groupDao;
	@Autowired
	CourseMapperDao courseDao;

	// Show form Create
	@RequestMapping("/create")
	public String show_form_create(ModelMap modelMap) throws IOException {

		List<GroupSecern> listGroupSecern = gsmDao.selectAllGroupSecern();

		for (GroupSecern groupSecern : listGroupSecern) {
			List<Group> groupList = groupDao.selectGroupByGroupSecernId(groupSecern.getId());
			groupList.add(0, new Group(-1, "Chưa thiết lập"));
			groupSecern.setGroups(groupList);
		}
		modelMap.addAttribute("listGroupSecern", listGroupSecern);
		List<Course> listCourse = courseDao.selectCourseByServerId(LibraryConstant.SERVER_ID);
		modelMap.addAttribute("listCourse", listCourse);
		return "admin.portfolio.create";
	}

	// Processing create
	@RequestMapping(value = "/deleted", method = RequestMethod.POST)
	public String processing_create(ModelMap modelMap, @ModelAttribute("objPG") PortfolioGroup objPG) {
		return "admin.portfolio.create";
	}

}
