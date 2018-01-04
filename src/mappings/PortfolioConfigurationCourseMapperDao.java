package mappings;

import java.io.IOException;

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
}
