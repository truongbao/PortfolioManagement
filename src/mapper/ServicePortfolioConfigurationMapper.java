package mapper;

import java.util.List;

import entity.ServicePortfolioConfiguration;

public interface ServicePortfolioConfigurationMapper {
	
	int insert(ServicePortfolioConfiguration objSPCF);
    int update(ServicePortfolioConfiguration objSPCF);
    int deleteById(int id);
    List<ServicePortfolioConfiguration> selectAllSPC();
    ServicePortfolioConfiguration selectById(int id);

	
}
