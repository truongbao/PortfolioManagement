package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mappings.GroupSecernMapperDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.GroupSecern;
import entity.GroupSecern_ShowGroup;
import entity.PortfolioGroup;

@Controller
@RequestMapping("admin/portfolio")
public class AdminCreatePortfolioController {
	
	@Autowired
	GroupSecernMapperDao gsmDao;

	// Show form Create
	@RequestMapping("/create")
	public String show_form_create(ModelMap modelMap) throws IOException {
		
		List<GroupSecern> listGroupSecern1 = gsmDao.selectAllGroupSecern();
		System.out.println(listGroupSecern1);
		
		// get listSPConfiguration
		List<GroupSecern_ShowGroup> listGroup_ShowGroup = new ArrayList<>();
		// List<GroupSecern> listGroupSecern =
		// session.selectList("GroupSecernXML.selectAllGroupSecern");
		//
		// for (GroupSecern groupSecern : listGroupSecern) {
		// List<Group> groupList =
		// session.selectList("GroupXML.selectGroupByGroupSecernId",
		// groupSecern.getId());
		// GroupSecern_ShowGroup each_GroupSecern_ShowGroup = new
		// GroupSecern_ShowGroup();
		// each_GroupSecern_ShowGroup.setGroup_list(groupList);
		// each_GroupSecern_ShowGroup.setSecern_id(groupSecern.getId());
		// each_GroupSecern_ShowGroup.setGroup_secern_name(groupSecern.getGroup_secern_name());
		// listGroup_ShowGroup.add(each_GroupSecern_ShowGroup);
		// }
		modelMap.addAttribute("listGroup_ShowGroup", listGroup_ShowGroup);

		return "admin.portfolio.create";
	}

	// Processing create
	@RequestMapping(value = "/deleted", method = RequestMethod.POST)
	public String processing_create(ModelMap modelMap, @ModelAttribute("objPG") PortfolioGroup objPG) {

		return "admin.portfolio.create";
	}

}
