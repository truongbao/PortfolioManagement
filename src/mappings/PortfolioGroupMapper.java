package mappings;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import entity.PortfolioGroup;

public interface PortfolioGroupMapper {

	public int insertPortfolioGroup(PortfolioGroup portfolioGroup);

	public int updatePortfolioGroup(PortfolioGroup portfolioGroup);

	public int deletePortfolioGroupById(int id);

	public List<PortfolioGroup> selectAllPortfolioGroup();

	public List<PortfolioGroup> selectAllPortfolioGroupByName();

	public PortfolioGroup selectPortfolioGroupById(int id);

}
