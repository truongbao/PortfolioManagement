package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.ServicePortfolioConfiguration;
import utility.Session;

@Repository
public class ServicePortfolioConfigurationMapperDao {

	public List<ServicePortfolioConfiguration> selectAll() throws IOException{
	    ServicePortfolioConfigurationMapper configurationMapper = 
		Session.session().getMapper(ServicePortfolioConfigurationMapper.class);
			
		List<ServicePortfolioConfiguration> listSPConfiguration = configurationMapper.selectAll();
		
		return listSPConfiguration;
	}
	
	
	
	
	
}