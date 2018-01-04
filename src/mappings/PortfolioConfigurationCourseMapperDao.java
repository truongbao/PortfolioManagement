package mappings;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.ibatis.common.resources.Resources;

import entity.PortfolioConfigurationCourse;

@Repository
public class PortfolioConfigurationCourseMapperDao {
	public int insertPortfolioConfigurationCourse(PortfolioConfigurationCourse portfolioConfigurationCourse)
			throws IOException {
		// PortfolioConfigurationCourseMapper portfolioConfigurationCourseMapper
		// = Session.session()
		// .getMapper(PortfolioConfigurationCourseMapper.class);
		// Session.session().close();

	/*	Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		// create student mapper
		PortfolioConfigurationCourseMapper pccMapper = session.getMapper(PortfolioConfigurationCourseMapper.class);
		int ck = pccMapper.insertPortfolioConfigurationCourse(portfolioConfigurationCourse);
		session.commit();

		// close session
		session.close(); */

		return 1;
	}
}
