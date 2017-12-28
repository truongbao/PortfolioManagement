package mappings;

import java.util.List;

import entity.PortfolioCourseUnit;

public interface PortfolioCourseUnitMapper {
	public int insertPortfolioCourseUnit(PortfolioCourseUnit portfolioCourseUnit);

	public int updatePortfolioCourseUnit(PortfolioCourseUnit portfolioCourseUnit);

	public int deletePortfolioCourseUnitById(int id);

	public List<PortfolioCourseUnit> selectAllPortfolioCourseUnit();

	public List<PortfolioCourseUnit> selectPortfolioCourseUnitById(int id);

}
