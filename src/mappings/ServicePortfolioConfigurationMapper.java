package mappings;

import java.util.List;

import entity.ServicePortfolioConfiguration;

public interface ServicePortfolioConfigurationMapper {

	public int insertServicePortfolioConfiguration(ServicePortfolioConfiguration objSPCF);

	public int updateServicePortfolioConfiguration(ServicePortfolioConfiguration objSPCF);

	public int deleteServicePortfolioConfigurationById(int id);

	public List<ServicePortfolioConfiguration> selectAll();

	public ServicePortfolioConfiguration selectServicePortfolioConfigurationById(int id);

	public int computeNextID();
}
