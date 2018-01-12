package mappings;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.GroupSecern;
import entity.PortfolioConfigurationCourse;
import entity.PortfolioGroup;
import entity.ServicePortfolioConfiguration;
import utility.FileWriterUtils;
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

	// láº¥y háº¿t cÃ¡c recode á»©ng vs tráº¡ng thÃ¡i is_completing vÃ 
	// aggretion_finished_at giáº£m dáº§n
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

	public int deleteServicePortfolioConfiguration(int id) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		ServicePortfolioConfigurationMapper configurationMapper = session
				.getMapper(ServicePortfolioConfigurationMapper.class);
		int result = configurationMapper.deleteServicePortfolioConfiguration(id);
		session.commit();
		session.close();

		return result;
	}

	public int setting_new_spcf(ServicePortfolioConfiguration new_spcf, List<GroupSecern> gss,
			List<PortfolioConfigurationCourse> pccs) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SqlSession session = null;
		int ck =0;
		try {
			session = Session.sessionFactory().openSession();

			ServicePortfolioConfigurationMapper configurationMapper = session
					.getMapper(ServicePortfolioConfigurationMapper.class);
			PortfolioConfigurationCourseMapper pccMapper = session.getMapper(PortfolioConfigurationCourseMapper.class);
			PortfolioGroupMapper pgMapper = session.getMapper(PortfolioGroupMapper.class);

			configurationMapper.insertServicePortfolioConfiguration(new_spcf);
			int gs_length = gss.size();
			for (int gs_index = 0; gs_index < gs_length; gs_index++) {
				GroupSecern gs = gss.get(gs_index);
				// loáº¡i bá»� nhá»¯ng group cÃ³ giÃ¡ trá»‹ -1 = "chÆ°a thiáº¿t láº­p"
				PortfolioGroup new_pg = new PortfolioGroup();
				new_pg.setGroup_id(gs.getGroups().get(0).getId());
				if (new_pg.getGroup_id() != -1) {
					// insert row by row new PortfolioGroup
					new_pg.setCreated_at(timestamp);
					new_pg.setService_portfolio_configuration_id(new_spcf.getId());
					pgMapper.insertPortfolioGroup(new_pg);
				}
			}

			int pccs_length = pccs.size();
			for (int pcc_index = 0; pcc_index < pccs_length; pcc_index++) {

				PortfolioConfigurationCourse new_pcc = pccs.get(pcc_index);
				// insert row by row new PortfolioConfigurationCourse
				new_pcc.setCreated_at(timestamp);
				// set new service_portfolio_configuration_id
				new_pcc.setService_portfolio_configuration_id(new_spcf.getId());
				pccMapper.insertPortfolioConfigurationCourse(new_pcc);
			}
			session.commit();
		} catch (Exception e) {
			if (session != null)
				session.rollback();
			FileWriterUtils.writeFile(e.getMessage(), "Inser new SPCF setting");
			ck= 0;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return ck;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int delete_spcf(int id) {
		SqlSession session = null;
		int ck = 1;
		try {
			session = Session.sessionFactory().openSession();

			ServicePortfolioConfigurationMapper spcfMapper = session
					.getMapper(ServicePortfolioConfigurationMapper.class);
			PortfolioConfigurationCourseMapper pccMapper = session.getMapper(PortfolioConfigurationCourseMapper.class);
			PortfolioGroupMapper pgMapper = session.getMapper(PortfolioGroupMapper.class);

			spcfMapper.deleteServicePortfolioConfiguration(id);
			pgMapper.deletePortfolioGroup(id);
			pccMapper.deletePortfolioConfigurationCourse(id);

			
			
			session.commit();
		} catch (Exception e) {
			if (session != null)
				session.rollback();
			FileWriterUtils.writeFile(e.getMessage(), "delete new SPCF setting");
			ck = 0;
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return ck;

	}

}