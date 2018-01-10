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

	public int setting_new_spcf(ServicePortfolioConfiguration new_spcf, List<GroupSecern> gss,
			List<PortfolioConfigurationCourse> pccs) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SqlSession session = null;
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
				// loại bỏ những group có giá trị -1 = "chưa thiết lập"
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
			return 0;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return 1;
	}

}