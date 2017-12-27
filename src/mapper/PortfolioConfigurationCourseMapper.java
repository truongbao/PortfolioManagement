package mapper;

import java.util.List;

import entity.PortfolioConfigurationCourse;;

public interface PortfolioConfigurationCourseMapper {
	public void insertPortfolioConfigurationCourse(PortfolioConfigurationCourse portfolioConfigurationCourse);

	public void updatePortfolioConfigurationCourse(PortfolioConfigurationCourse portfolioConfigurationCourse);

	public void deletePortfolioConfigurationCourseById(int id);

	public List<PortfolioConfigurationCourse> selectAllPortfolioConfigurationCourse();

	public List<PortfolioConfigurationCourse> selectPortfolioConfigurationCourseById(int id);

}
