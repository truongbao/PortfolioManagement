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

		ServicePortfolioConfigurationMapper spfcMapper = session.getMapper(ServicePortfolioConfigurationMapper.class);

		List<ServicePortfolioConfiguration> listSPConfiguration = spfcMapper.selectAll();
		session.close();
		return listSPConfiguration;
	}

	public int insertServicePortfolioConfiguration(ServicePortfolioConfiguration objSPCF) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		ServicePortfolioConfigurationMapper spfcMapper = session.getMapper(ServicePortfolioConfigurationMapper.class);
		int ck = spfcMapper.insertServicePortfolioConfiguration(objSPCF);
		session.commit();
		session.close();
		return ck;
	}

	public int computeNextID() throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		ServicePortfolioConfigurationMapper spfcMapper = session.getMapper(ServicePortfolioConfigurationMapper.class);

		int next_spc = spfcMapper.computeNextID();
		session.close();
		return next_spc;
	}

}