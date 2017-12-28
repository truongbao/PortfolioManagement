/*package controller;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Cat;

@Controller
@RequestMapping("/springd3")
public class ConsultController {
	 private final String upload_dir = "uploads";
	
	@RequestMapping("/index-cat")
	public String index() throws IOException{
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
		
		return "anews.anews.index"; //dùng tạm giao diện index để test
	}
	
	
	@RequestMapping("/index-cat-by-name")
	public String getListCatByName() throws IOException{
		 // read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // open session
        SqlSession session = sqlSessionFactory.openSession();

        // get all cat
        List<Cat> listCat = session.selectList("CatXML.selectAllCatByName");
        for (Cat objCat : listCat) {
            System.out.println(objCat.toString());
        } 

        // close session
        session.close();
		
		return "anews.anews.index"; //dùng tạm giao diện index để test
	}
	
	 @RequestMapping("/add-cat")
	 public String add_cat() throws IOException{
		 
		 // read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

	    // open session
	    SqlSession session = sqlSessionFactory.openSession();
	    
	    // insert cat
	    Cat objCat = new Cat(0, "Thần thoại");
		 
	    session.insert("CatXML.insertCat", objCat);  
        session.commit();
        System.out.println("Thêm thành công !");

        // close session
        session.close();
		 
		return "anews.anews.index"; //dùng tạm giao diện index để test
	 }
	 
	
	 @RequestMapping("/edit-cat")
	 public String edit_cat() throws IOException{
		 
		 // read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

	    // open session
	    SqlSession session = sqlSessionFactory.openSession();
	    
	    // update cat
        Cat objCat = session.selectOne("CatXML.selectCatById", 4); //lay ra doi tuong ung vs idCat = 3 , sau đó mới edit
        
        objCat.setTendanhmuctin("Dan Tri");
        
        session.update("CatXML.updateCat", objCat);
        session.commit();
        System.out.println("Edit thành công !");
        
        // close session
        session.close();
		 
		return "anews.anews.index"; //dùng tạm giao diện index để test
	 }
	 
	 
	 
	 @RequestMapping("/del-cat")
	 public String del_cat() throws IOException{
		 
		 // read config file
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

	    // open session
	    SqlSession session = sqlSessionFactory.openSession();
	    
	    // delete cat
        session.delete("CatXML.deleteCatById", 4);
        session.commit();
        System.out.println("Delete suscessful !");        
        
        // close session
        session.close();
		 
		return "anews.anews.index"; //dùng tạm giao diện index để test
	 }
	 
    
	
	 @RequestMapping("/add-news")
	 public String add(){
		 return "anews.anews.add";
	 }
	 
	 @RequestMapping(value="/add" ,method=RequestMethod.POST) //xu ly form
	
	 public String add(@Valid @ModelAttribute ("objItem") News objNews,BindingResult rs, @RequestParam("picture") CommonsMultipartFile  cmf ,
			     HttpServletRequest request){
		
		 if(rs.hasErrors()){
			 return "anews.anews.add";
		 }
		 
		 System.out.println("Ten tin "+objNews.getTentintuc());
		 System.out.println("Mota  "+objNews.getMota());
		 System.out.println("Name File : "+cmf.getOriginalFilename());//lay ten file
		 
		 
		 String fileName = cmf.getOriginalFilename();
		  objNews.setHinhanh(fileName);
		 
		 if(!fileName.isEmpty()){
		 
		 
		 String appPath =  request.getServletContext().getRealPath("");
		 //System.out.println(appPath);

		 //duong dan thu muc chua file
		 String dirPath = appPath + File.separator + upload_dir;  
		 File saveDir = new  File(dirPath);
		 
		 if(!saveDir.exists()){//neu ko ton tai thi tao ra thu muc chua hinh
			 saveDir.mkdir();
		 }
		 //tao duong dan file khi upload lĂªn
		 String filePath = dirPath + File.separator+ fileName;
		 
		 //tien hanh upload
		 File saveFile = new File(filePath);
		 
		 try {
			cmf.transferTo(saveFile);//phuong thuc nay de upload
			System.out.println("upload thanh cong !!");
			System.out.println("Duong dan file: "+filePath);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("upload that bai !!");
		} 
		 }
		 
		 //them tin
		 if(newsDAO.addItem(objNews) > 0){
			 //thanh cong
			 System.out.println("them ok");
			 
		 }else{
			 //that bai
			 System.out.println("them that bai");
		 }
		 
		 
		 return "anews.anews.add";
	 }
	 
	 
	 
	
	
}
*/