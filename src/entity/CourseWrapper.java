package entity;

import java.util.List;

import entity.Course;

// nhận request từ ajax
public class CourseWrapper {
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> persons) {
		this.courses = persons;
	}
}
