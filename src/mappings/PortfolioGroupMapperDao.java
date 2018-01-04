package mappings;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;


import org.springframework.stereotype.Repository;

import com.ibatis.common.resources.Resources;

import entity.PortfolioGroup;

@Repository
public class PortfolioGroupMapperDao {

	public int insertPortfolioGroup(PortfolioGroup portfolioGroup) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		PortfolioGroupMapper portfolioGroupMapper = session.getMapper(PortfolioGroupMapper.class);
		session.close();
		return portfolioGroupMapper.insertPortfolioGroup(portfolioGroup);

	}
}
