package mappings;

import java.util.List;

import entity.PortfolioCourseUnitLevel;

public interface PortfolioCourseUnitLevelMapper {
	public int insertPortfolioCourseUnitLevel(PortfolioCourseUnitLevel portfolioCourseUnitLevel);

	public int updatePortfolioCourseUnitLevel(PortfolioCourseUnitLevel portfolioCourseUnitLevel);

	public int deletePortfolioCourseUnitLevelById(int id);

	public List<PortfolioCourseUnitLevel> selectAllPortfolioCourseUnitLevel();

	public List<PortfolioCourseUnitLevel> selectPortfolioCourseUnitLevelById(int id);
}
