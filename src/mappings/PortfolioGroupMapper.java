package mappings;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import entity.PortfolioGroup;

public interface PortfolioGroupMapper {

//	@Insert("INSERT INTO portfolio_groups ( GROUP_ID,SERVICE_PORTFOLIO_CONFIGURATION_ID, CREATED_AT) VALUES ( 1, 1, '1-1-1998 2:2:2');")
	public void insertPortfolioGroup(PortfolioGroup portfolioGroup);

	public int updatePortfolioGroup(PortfolioGroup portfolioGroup);

	public int deletePortfolioGroupById(int id);

	public List<PortfolioGroup> selectAllPortfolioGroup();

	public List<PortfolioGroup> selectAllPortfolioGroupByName();

	public PortfolioGroup selectPortfolioGroupById(int id);

}
