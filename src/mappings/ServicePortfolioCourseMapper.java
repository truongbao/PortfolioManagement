package mappings;

import java.util.List;

import entity.ServicePortfolioConfiguration;
import entity.ServicePortfolioCourse;;

public interface ServicePortfolioCourseMapper {
	public int insertServicePortfolioCourse(ServicePortfolioCourse servicePortfolioCourse);

	public int updateServicePortfolioCourse(ServicePortfolioCourse servicePortfolioCourse);

	public int deleteServicePortfolioCourseById(int id);

	public List<ServicePortfolioCourse> selectAllServicePortfolioCourse();

	public ServicePortfolioCourse selectServicePortfolioCourseById(int id);

	public List<ServicePortfolioCourse> selectServicePortfolioCourseByCourseId(int id);

	public List<ServicePortfolioCourse> selectServicePortfolioCourseByServiceID(int id);

	
}
