package mappings;

import java.util.List;

import entity.PortfolioConfigurationCourse;;

public interface PortfolioConfigurationCourseMapper {
	public int insertPortfolioConfigurationCourse(PortfolioConfigurationCourse portfolioConfigurationCourse);

	public int updatePortfolioConfigurationCourse(PortfolioConfigurationCourse portfolioConfigurationCourse);

	public int deletePortfolioConfigurationCourseById(int id);

	public List<PortfolioConfigurationCourse> selectAllPortfolioConfigurationCourse();

	public List<PortfolioConfigurationCourse> selectPortfolioConfigurationCourseById(int id);
	
	public int updatePortfolioConfigurationCourseByis_deleted(int id);

}
