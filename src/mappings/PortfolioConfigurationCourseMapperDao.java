package mappings;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import entity.PortfolioConfigurationCourse;
import utility.Session;

@Repository
public class PortfolioConfigurationCourseMapperDao {
	public int insertPortfolioConfigurationCourse(PortfolioConfigurationCourse portfolioConfigurationCourse)
			throws IOException {
		PortfolioConfigurationCourseMapper portfolioConfigurationCourseMapper = Session.session()
				.getMapper(PortfolioConfigurationCourseMapper.class);
		Session.session().close();
		return portfolioConfigurationCourseMapper.insertPortfolioConfigurationCourse(portfolioConfigurationCourse);
	}
}
