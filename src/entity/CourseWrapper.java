package entity;

import java.util.List;

import entity.Course;

/* 
 * class này được viết với mục đích gọi các course thành 1 list
 * để nhận các request và gửi phản hồi từ ajax gọi đến API định nghĩa (PortfolioInfoRESTAPIController)
*/
public class CourseWrapper {
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> persons) {
		this.courses = persons;
	}
}
