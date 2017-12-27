package mapper;

import java.util.List;

import entity.PortfolioCourseUnit;

public interface PortfolioCourseUnitMapper {
	public void insertPortfolioCourseUnit(PortfolioCourseUnit portfolioCourseUnit);

	public void updatePortfolioCourseUnit(PortfolioCourseUnit portfolioCourseUnit);

	public void deletePortfolioCourseUnitById(int id);

	public List<PortfolioCourseUnit> selectAllPortfolioCourseUnit();

	public List<PortfolioCourseUnit> selectPortfolioCourseUnitById(int id);

}
