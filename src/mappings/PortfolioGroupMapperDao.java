package mappings;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.ibatis.common.resources.Resources;

import entity.PortfolioGroup;

@Repository
public class PortfolioGroupMapperDao {
	public void insertPortfolioGroup(PortfolioGroup portfolioGroup) throws IOException {

		// PortfolioGroupMapper portfolioGroupMapper =
		// Session.session().getMapper(PortfolioGroupMapper.class);
		// portfolioGroupMapper.insertPortfolioGroup(portfolioGroup);
		// Session.session().commit();
		// Session.session().close();
		/*Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		// create student mapper
		PortfolioGroupMapper portfolioGroupMapper = session.getMapper(PortfolioGroupMapper.class);
		portfolioGroupMapper.insertPortfolioGroup(portfolioGroup);
		session.commit();

		// close session
		session.close(); */

	}
}
