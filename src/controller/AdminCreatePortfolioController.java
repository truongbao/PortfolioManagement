package controller;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Group;
import entity.GroupSecern;
import entity.GroupSecern_ShowGroup;
import entity.PortfolioGroup;
import entity.ServicePortfolioConfiguration;
import mappings.GroupSecernMapper;

@Controller
@RequestMapping("admin/portfolio")
public class AdminCreatePortfolioController {

	// Show form Create
	@RequestMapping("/create")
	public String show_form_create(ModelMap modelMap) throws IOException {

		// read config file
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		// open session
		SqlSession session = sqlSessionFactory.openSession();

		GroupSecernMapper groupSecernMapper = session.getMapper(GroupSecernMapper.class);
		List<GroupSecern> listGroupSecern1 = groupSecernMapper.selectAllGroupSecern();
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
		// close session
		session.close();

		return "admin.portfolio.create";
	}

	// Processing create
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String processing_create(ModelMap modelMap, @ModelAttribute("objPG") PortfolioGroup objPG) {

		return "admin.portfolio.create";
	}

}
