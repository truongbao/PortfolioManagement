package mappings;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.ServicePortfolioConfiguration;
import utility.Session;

@Repository
public class ServicePortfolioConfigurationMapperDao {

	public List<ServicePortfolioConfiguration> selectAll() throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		ServicePortfolioConfigurationMapper spfcMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);

		List<ServicePortfolioConfiguration> listSPConfiguration = spfcMapper.selectAll();
		session.close();
		return listSPConfiguration;
	}

	public int insertServicePortfolioConfiguration(ServicePortfolioConfiguration objSPCF) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		ServicePortfolioConfigurationMapper spfcMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);

		if (spfcMapper.insertServicePortfolioConfiguration(objSPCF) > 0)
			return 1;
		else
			return 0;
	}

	public int computeNextID() throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		ServicePortfolioConfigurationMapper spfcMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);

		int next_spc = spfcMapper.computeNextID();
		session.close();
		return next_spc;
	}
	
	public ServicePortfolioConfiguration selectServicePortfolioConfigurationById(int id) throws IOException {
		SqlSession session = Session.sessionFactory().openSession();
		ServicePortfolioConfigurationMapper configurationMapper = session.getMapper(ServicePortfolioConfigurationMapper.class);
		
		ServicePortfolioConfiguration spc = configurationMapper.selectServicePortfolioConfigurationById(id);
		
		session.close();
		return spc;
	}
	
	
	
	
	
}