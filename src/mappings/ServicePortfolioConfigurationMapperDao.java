package mappings;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.ibatis.common.resources.Resources;

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
		// ServicePortfolioConfigurationMapper spfcMapper = Session.session()
		// .getMapper(ServicePortfolioConfigurationMapper.class);
		//
		// if (spfcMapper.insertServicePortfolioConfiguration(objSPCF) > 0)
		// return 1;
		// else
		// return 0;
		/*
		 * Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		 * SqlSessionFactory sqlSessionFactory = new
		 * SqlSessionFactoryBuilder().build(reader); SqlSession session =
		 * sqlSessionFactory.openSession();
		 * 
		 * // create student mapper ServicePortfolioConfigurationMapper
		 * spcfMapper =
		 * session.getMapper(ServicePortfolioConfigurationMapper.class); int ck
		 * = spcfMapper.insertServicePortfolioConfiguration(objSPCF);
		 * session.commit();
		 * 
		 * // close session session.close();
		 */
		return 1;
	}

	public int computeNextID() throws IOException {
		ServicePortfolioConfigurationMapper spfcMapper = Session.session()
				.getMapper(ServicePortfolioConfigurationMapper.class);

		int next_spc = spfcMapper.computeNextID();
		Session.session().close();
		return next_spc;
	}
}