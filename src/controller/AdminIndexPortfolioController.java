package controller;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.ServicePortfolioConfiguration;

@Controller
@RequestMapping("admin/portfolio")
public class AdminIndexPortfolioController {

	@RequestMapping("/index")
	public String index(ModelMap modelMap) throws IOException {
		// read config file
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		// open session
		SqlSession session = sqlSessionFactory.openSession();

		// get listSPConfiguration
		List<ServicePortfolioConfiguration> listSPConfiguration = session
				.selectList("ServicePortfolioConfigurationXML.selectAllSPC");
		modelMap.addAttribute("listSPConfiguration", listSPConfiguration);

		// close session
		session.close();

		return "admin.portfolio.index";
	}

	// get lại thông tin portfolio khi click button[Update]
	@RequestMapping("/index/{refresh}")
	public String reload_index(ModelMap modelMap, @PathVariable("refresh") String refresh) throws IOException {

		// read config file
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		// open session
		SqlSession session = sqlSessionFactory.openSession();

		// get listSPConfiguration
		List<ServicePortfolioConfiguration> listSPConfiguration = session
				.selectList("ServicePortfolioConfigurationXML.selectAllSPC");

		modelMap.addAttribute("listSPConfiguration", listSPConfiguration);

		// close session
		session.close();

		return "admin.portfolio.index";
	}

}
