package mapper;

import java.util.List;
import entity.Course;

public interface CourseMapper {
	public void insertCourse(Course course);

	public void updateCourse(Course course);

	public void deleteCourseById(int id);

	public List<Course> selectAllCourse();

	public List<Course> selectAllCourseByName(String name);

	public Course selectCourseById(int id);
}
