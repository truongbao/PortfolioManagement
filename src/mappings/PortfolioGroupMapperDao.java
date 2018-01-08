package mappings;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.PortfolioGroup;
import utility.Session;

@Repository
public class PortfolioGroupMapperDao {

	public int insertPortfolioGroup(PortfolioGroup portfolioGroup) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		PortfolioGroupMapper portfolioGroupMapper = session.getMapper(PortfolioGroupMapper.class);
		int ck = portfolioGroupMapper.insertPortfolioGroup(portfolioGroup);
		session.commit();
		session.close();
		return ck;

	}

	public int updatePortfolioGroupByis_deleted(int id) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		PortfolioGroupMapper groupMapper = session.getMapper(PortfolioGroupMapper.class);
		int result1 = groupMapper.updatePortfolioGroupByis_deleted(id);
		session.commit();
		session.close();

		return result1;
	}
}
