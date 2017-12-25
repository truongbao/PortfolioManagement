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
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Cat;

@Controller
@RequestMapping("admin/portfolio")
public class AdminIndexController {
	
	
	 @RequestMapping("/index")
	 public String index(ModelMap modelMap) throws IOException{
		 
		// read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // open session
        SqlSession session = sqlSessionFactory.openSession();

        // get all cat
        List<Cat> listCat = session.selectList("CatXML.selectAllCat");
        for (Cat objCat : listCat) {
            System.out.println(objCat.toString());
        } 

        // close session
        session.close();

        
		return "admin.portfolio.index";
	 }
	 
	 @RequestMapping("/create")
	 public String add(ModelMap modelMap){
		return "admin.portfolio.create";
	 }
	 
	 
	 @RequestMapping("/detail")
	 public String detail(ModelMap modelMap){
		return "admin.portfolio.detail";
	 }
	 
	 @RequestMapping("/edit")
	 public String edit(ModelMap modelMap){
		return "admin.portfolio.edit";
	 }
	 
	 
	
}
