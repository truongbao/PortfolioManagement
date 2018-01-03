package mappings;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import entity.PortfolioGroup;
import utility.Session;

@Repository
public class PortfolioGroupMapperDao {
	public int insertPortfolioGroup(PortfolioGroup portfolioGroup) throws IOException {
		PortfolioGroupMapper portfolioGroupMapper = Session.session().getMapper(PortfolioGroupMapper.class);
		Session.session().close();
		return portfolioGroupMapper.insertPortfolioGroup(portfolioGroup);
	}
}
