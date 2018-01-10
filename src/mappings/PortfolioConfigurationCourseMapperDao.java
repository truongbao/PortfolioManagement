package mappings;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.PortfolioConfigurationCourse;
import utility.Session;

@Repository
public class PortfolioConfigurationCourseMapperDao {
	public int insertPortfolioConfigurationCourse(PortfolioConfigurationCourse portfolioConfigurationCourse)
			throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		PortfolioConfigurationCourseMapper portfolioConfigurationCourseMapper = session
				.getMapper(PortfolioConfigurationCourseMapper.class);
		int ck = portfolioConfigurationCourseMapper.insertPortfolioConfigurationCourse(portfolioConfigurationCourse);
		session.commit();
		session.close();
		return ck;

	}
	
	public int updatePortfolioConfigurationCourseByis_deleted(int id)
			throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		PortfolioConfigurationCourseMapper portfolioConfigurationCourseMapper = session
				.getMapper(PortfolioConfigurationCourseMapper.class);
		int udbd = portfolioConfigurationCourseMapper.updatePortfolioConfigurationCourseByis_deleted(id);
		session.commit();
		session.close();
		return udbd;

	}
	
	  public List<PortfolioConfigurationCourse> selectPortfolioConfigurationCourseBySPCId(int id) throws IOException {
			
			SqlSession session = Session.sessionFactory().openSession();
			
			PortfolioConfigurationCourseMapper portfolioConfigurationCourseMapper = session.getMapper(PortfolioConfigurationCourseMapper.class);

			List<PortfolioConfigurationCourse> listPortfolioConfigurationCourses = portfolioConfigurationCourseMapper.selectPortfolioConfigurationCourseBySPCId(id);
			session.close();
			return listPortfolioConfigurationCourses;
		}
		
	
	
}
