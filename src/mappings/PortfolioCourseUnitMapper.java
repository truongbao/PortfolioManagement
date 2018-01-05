package mappings;

import java.util.List;

import entity.PortfolioCourseUnit;
import entity.ServicePortfolioCourse;

public interface PortfolioCourseUnitMapper {
	public int insertPortfolioCourseUnit(PortfolioCourseUnit portfolioCourseUnit);

	public int updatePortfolioCourseUnit(PortfolioCourseUnit portfolioCourseUnit);

	public int deletePortfolioCourseUnitById(int id);

	public List<PortfolioCourseUnit> selectAllPortfolioCourseUnit();

	public PortfolioCourseUnit selectPortfolioCourseUnitById(int id);

	public List<PortfolioCourseUnit> selectPortfolioCourseUnitByPCULId(int id);
	
	public List<PortfolioCourseUnit> selectqaBylevel_course(ServicePortfolioCourse portfolioCourseUnit);

}
