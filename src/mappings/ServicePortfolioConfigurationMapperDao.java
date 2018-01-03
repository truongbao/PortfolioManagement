package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.ServicePortfolioConfiguration;
import utility.Session;

@Repository
public class ServicePortfolioConfigurationMapperDao {

	public List<ServicePortfolioConfiguration> selectAll() throws IOException {
		ServicePortfolioConfigurationMapper spfcMapper = Session.session()
				.getMapper(ServicePortfolioConfigurationMapper.class);

		List<ServicePortfolioConfiguration> listSPConfiguration = spfcMapper.selectAll();
		Session.session().close();
		return listSPConfiguration;
	}

	public int insertServicePortfolioConfiguration(ServicePortfolioConfiguration objSPCF) throws IOException {
		ServicePortfolioConfigurationMapper spfcMapper = Session.session()
				.getMapper(ServicePortfolioConfigurationMapper.class);

		if (spfcMapper.insertServicePortfolioConfiguration(objSPCF) > 0)
			return 1;
		else
			return 0;
	}

	public int computeNextID() throws IOException {
		ServicePortfolioConfigurationMapper spfcMapper = Session.session()
				.getMapper(ServicePortfolioConfigurationMapper.class);

		int next_spc = spfcMapper.computeNextID();
		Session.session().close();
		return next_spc;
	}
}