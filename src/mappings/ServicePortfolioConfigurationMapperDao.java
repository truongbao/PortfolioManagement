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

	public ServicePortfolioConfiguration selectServicePortfolioConfigurationById(int id) throws IOException {
		SqlSession session = Session.sessionFactory().openSession();
		ServicePortfolioConfigurationMapper configurationMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);

		ServicePortfolioConfiguration spc = configurationMapper.selectServicePortfolioConfigurationById(id);

		session.close();
		return spc;
	}

	// lấy hết các recode ứng vs trạng thái is_completing và
	// aggretion_finished_at giảm dần
	public List<ServicePortfolioConfiguration> selectAllByState() throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		ServicePortfolioConfigurationMapper configurationMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);
		List<ServicePortfolioConfiguration> listSPConfiguration = configurationMapper.selectAllByState();
		session.close();

		return listSPConfiguration;
	}

	public int updateStateIsCompleting(ServicePortfolioConfiguration obj) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		ServicePortfolioConfigurationMapper configurationMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);
		int result = configurationMapper.updateStateIsCompleting(obj);
		session.commit();
		session.close();

		return result;
	}

	public int updateStateStatisticalCompleted(ServicePortfolioConfiguration obj) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		ServicePortfolioConfigurationMapper configurationMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);
		int result = configurationMapper.updateStateStatisticalCompleted(obj);
		session.commit();
		session.close();

		return result;
	}

	public int updateServicePortfolioConfigurationIs_Delete(int id) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		ServicePortfolioConfigurationMapper configurationMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);
		int result = configurationMapper.updateServicePortfolioConfigurationIs_Delete(id);
		session.commit();
		session.close();

		return result;
	}

}