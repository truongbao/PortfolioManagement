package mapper;

import java.util.List;

import entity.PortfolioCourseUnitLevel;

public interface PortfolioCourseUnitLevelMapper {
	public void insertPortfolioCourseUnitLevel(PortfolioCourseUnitLevel portfolioCourseUnitLevel);

	public void updatePortfolioCourseUnitLevel(PortfolioCourseUnitLevel portfolioCourseUnitLevel);

	public void deletePortfolioCourseUnitLevelById(int id);

	public List<PortfolioCourseUnitLevel> selectAllPortfolioCourseUnitLevel();

	public List<PortfolioCourseUnitLevel> selectPortfolioCourseUnitLevelById(int id);
}
