package mapper;

import java.util.List;

import entity.ServicePortfolioConfiguration;

public interface ServicePortfolioConfigurationMapper {

	public int insertServicePortfolioCourse(ServicePortfolioConfiguration objSPCF);

	public int updateServicePortfolioCourse(ServicePortfolioConfiguration objSPCF);

	public int deleteServicePortfolioCourseById(int id);

	public List<ServicePortfolioConfiguration> selectAllServicePortfolioCourse();

	public ServicePortfolioConfiguration selectServicePortfolioCourseById(int id);

}
