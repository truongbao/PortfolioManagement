package mappings;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.Course;
import utility.Session;

@Repository
public class CourseMapperDao {
	public List<Course> selectCourseByServerId(int id) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		CourseMapper courseMapper = session.getMapper(CourseMapper.class);

		List<Course> listCourse = courseMapper.selectCourseByServerId(id);

		// close session
		session.close();

		return listCourse;
	}

	public Course selectCourseById(int id) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		CourseMapper courseMapper = session.getMapper(CourseMapper.class);

		Course course = courseMapper.selectCourseById(id);

		// close session
		session.close();

		return course;
	}
}
