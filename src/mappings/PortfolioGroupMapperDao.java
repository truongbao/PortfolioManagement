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
		session.close();
		return portfolioGroupMapper.insertPortfolioGroup(portfolioGroup);
	}
}
