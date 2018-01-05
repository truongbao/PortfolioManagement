package mappings;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import utility.Session;
import entity.ServicePortfolioCourse;

@Repository
public class ServicePortfolioCourseMapperDao {
	public List<ServicePortfolioCourse> selectServicePortfolioCourseByCourseId(int id) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		ServicePortfolioCourseMapper servicePortfolioCourseMapper = session
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> listSPConfiguration = servicePortfolioCourseMapper
				.selectServicePortfolioCourseByCourseId(id);
		session.close();
		return listSPConfiguration;
	}

	public List<ServicePortfolioCourse> selectAllServicePortfolioCourse() throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		ServicePortfolioCourseMapper servicePortfolioCourseMapper = session
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> listSPConfiguration = servicePortfolioCourseMapper
				.selectAllServicePortfolioCourse();
		session.close();
		return listSPConfiguration;
	}

	public ServicePortfolioCourse selectServicePortfolioCourseById(int id) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		ServicePortfolioCourseMapper servicePortfolioCourseMapper = session
				.getMapper(ServicePortfolioCourseMapper.class);

		ServicePortfolioCourse spc = servicePortfolioCourseMapper.selectServicePortfolioCourseById(id);
		session.close();
		return spc;
	}

	public List<ServicePortfolioCourse> selectServicePortfolioCourseByServiceID(int id) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		ServicePortfolioCourseMapper servicePortfolioCourseMapper = session
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> servicePortfolioCourses = servicePortfolioCourseMapper
				.selectServicePortfolioCourseByServiceID(id);
		session.close();
		return servicePortfolioCourses;
	}
	

	public List<ServicePortfolioCourse> selectServicePortfolioCourseByCourseName(int id) throws IOException {
		SqlSession session = Session.sessionFactory().openSession();
		ServicePortfolioCourseMapper configurationMapper = session
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> listSPConfiguration1 = configurationMapper.selectServicePortfolioCourseByCourseName(id);
		session.close();

		return listSPConfiguration1;
	}

}
