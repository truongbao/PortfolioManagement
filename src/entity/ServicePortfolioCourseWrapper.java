package entity;

import java.util.List;

import entity.Course;

/* 
 * class này được viết với mục đích gọi các course thành 1 list
 * để nhận các request và gửi phản hồi từ ajax gọi đến API định nghĩa (PortfolioInfoRESTAPIController)
*/
public class ServicePortfolioCourseWrapper {
	private List<ServicePortfolioCourse> spcourses;

	public List<ServicePortfolioCourse> getSpcourses() {
		return spcourses;
	}

	public void setSpcourses(List<ServicePortfolioCourse> spcourses) {
		this.spcourses = spcourses;
	}

}
