package mapper;

import java.util.List;
import entity.Course;

public interface CourseMapper {
	public int insertCourse(Course course);

	public int updateCourse(Course course);

	public int deleteCourseById(int id);

	public List<Course> selectAllCourse();

	public List<Course> selectAllCourseByName(String name);

	public Course selectCourseById(int id);
}
