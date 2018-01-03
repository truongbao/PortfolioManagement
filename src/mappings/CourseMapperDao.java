package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Course;
import utility.Session;

@Repository
public class CourseMapperDao {
	public List<Course> selectCourseByServerId(int id) throws IOException {
		CourseMapper courseMapper = Session.session().getMapper(CourseMapper.class);

		List<Course> listCourse = courseMapper.selectCourseByServerId(id);

		// close session
		Session.session().close();

		return listCourse;
	}

	public Course selectCourseById(int id) throws IOException {
		CourseMapper courseMapper = Session.session().getMapper(CourseMapper.class);

		Course course = courseMapper.selectCourseById(id);

		// close session
		Session.session().close();

		return course;
	}
}
