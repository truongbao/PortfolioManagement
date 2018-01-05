package mappings;

import java.util.List;

import entity.ServicePortfolioConfiguration;

public interface ServicePortfolioConfigurationMapper {

	public int insertServicePortfolioConfiguration(ServicePortfolioConfiguration objSPCF);

	public int updateServicePortfolioConfiguration(ServicePortfolioConfiguration objSPCF);

	public int deleteServicePortfolioConfigurationById(int id);

	public ServicePortfolioConfiguration selectServicePortfolioConfigurationById(int id);

	public int computeNextID();
	
    /* ========================================================= */
	
    public List<ServicePortfolioConfiguration> selectAll();
	
	public List<ServicePortfolioConfiguration> selectAllByState();

	public int updateStateIsCompleting(ServicePortfolioConfiguration obj);
	
	public int updateStateStatisticalCompleted(ServicePortfolioConfiguration obj);
	
	
	
	
	
}
