package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import mappings.ServicePortfolioConfigurationMapperDao;
import mappings.UpdateQuestionStateMapperDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import utility.LibraryConstant;
import entity.ServicePortfolioConfiguration;
import entity.UpdateQuestionState;

@Controller
@RequestMapping("admin/portfolio")
public class AdminIndexPortfolioController {
	
	@Autowired
	ServicePortfolioConfigurationMapperDao spcDao;
	
	@Autowired
	UpdateQuestionStateMapperDao uqsDao;
	
	@Autowired
	AdminIndexPortfolioController adminIndexPortfolioController;
	
	int system_time  = 0;
    final int QT=15000; //kiem tra dinh ky 1 phut = 60000 ms
	

	@RequestMapping("/index")
	public String index(ModelMap modelMap) throws IOException {
		
		 List<ServicePortfolioConfiguration> listSPConfiguration = spcDao.selectAll();
		 modelMap.addAttribute("listSPConfiguration", listSPConfiguration);
		 
		 
		   //https://www.tutorialspoint.com/java/util/timer_schedule_period.htm
		   //public void schedule(TimerTask task,long delay,long period)
		   /*
		    task − Đây là nhiệm vụ được lên kế hoạch.
			delay − Đây là the delay trong milliseconds trước khi nhiệm vụ được thực thi  
			period − Đây là thời gian tính bằng mili giây giữa các lần thực hiện tác vụ tiếp theo.
		  */
		 
		  Timer timer = new Timer();
		 
	      timer.schedule(new TimerTask(){
	    	  //int dem = 1;
	    	  
	    	  @Override
	          public void run() {
	        	  
	        	  //if(dem < 4){
	        	  
	        	  Calendar c = Calendar.getInstance();
					
			      int hour = c.get(Calendar.HOUR_OF_DAY);
			      int minute = c.get(Calendar.MINUTE);
			      int second = c.get(Calendar.SECOND);
					 
			      system_time = hour*3600 + minute*60 + second; //theo don vi (s)
			      int timer = system_time + (1*60) ; //hẹn giờ thực thi theo đơn vị(s) : 1 phut
				 
				  System.out.println("System time : "+system_time+"   Timer : "+timer);
	        	  
				 
				  try {
					  
					 List<ServicePortfolioConfiguration> listSPCByState = spcDao.selectAllByState();
					 
					 for (ServicePortfolioConfiguration objSPCF : listSPCByState) {
						 
						 if(LibraryConstant.INCOMPLETE.equals(objSPCF.getState() ) ){
						 
							 if( spcDao.updateStateIsCompleting(objSPCF) > 0){ //chuyen tu INCOMPLETE -> is_completing
								System.out.println("thanh cong");
							 }else{
								System.out.println("That bai !");
							 }
						 
						 }else{ //la trang thai "is_completing"
							 
							 if( spcDao.updateStateStatisticalCompleted(objSPCF) > 0){ //chuyen tu is_completing -> statistical_completed 
								System.out.println("thanh cong");
							 }else{
								System.out.println("That bai !");
							 }
							 
						 }
						
					 }
					 
					 // cancel();
					
					 
					 
				  } catch (IOException e) {
					 e.printStackTrace();
				  }
				  
				/*System.out.println("dem :"+dem);
				  dem = dem + 1;
				  
	        	}else{
	        		System.out.println("thoat");
	        		cancel();
	        	}*/
				
	        	  
	          }
	    	   
	          
	      },1000*345600,1000*345600);  //4 ngay
	      
	     
	      
		 return "admin.portfolio.index";
		
	}
	

	// get lại thông tin portfolio khi click button[Update]
	@RequestMapping("/index/{refresh}")
	public String reload_index(ModelMap modelMap, @PathVariable("refresh") String refresh) throws IOException {

		List<ServicePortfolioConfiguration> listSPConfiguration = spcDao.selectAll();
		modelMap.addAttribute("listSPConfiguration", listSPConfiguration);

		return "admin.portfolio.index";
	}
	
	//Xử lý hien thi ở mục 9 và 10  khi click button[Update thông tin bài tập]
	@RequestMapping("/update-exercise-information")
	public String up(ModelMap modelMap) throws IOException {

		List<ServicePortfolioConfiguration> listSPConfiguration = spcDao.selectAll();
		modelMap.addAttribute("listSPConfiguration", listSPConfiguration);
		
		UpdateQuestionState objUQS = uqsDao.selectObjectUQSByState(); 
		modelMap.addAttribute("objUQS", objUQS);
		
		return "admin.portfolio.index";
	}
	
	
	
	
}
