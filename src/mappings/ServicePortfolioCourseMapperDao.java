package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.ServicePortfolioConfiguration;
import entity.ServicePortfolioCourse;
import utility.Session;

@Repository
public class ServicePortfolioCourseMapperDao {
	public List<ServicePortfolioCourse> selectServicePortfolioCourseByCourseId(int id) throws IOException {
		ServicePortfolioCourseMapper servicePortfolioCourseMapper = Session.session()
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> listSPConfiguration = servicePortfolioCourseMapper
				.selectServicePortfolioCourseByCourseId(id);
		Session.session().close();
		return listSPConfiguration;
	}

	public List<ServicePortfolioCourse> selectAllServicePortfolioCourse() throws IOException {
		ServicePortfolioCourseMapper servicePortfolioCourseMapper = Session.session()
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> listSPConfiguration = servicePortfolioCourseMapper
				.selectAllServicePortfolioCourse();
		Session.session().close();
		return listSPConfiguration;
	}

	public ServicePortfolioCourse selectServicePortfolioCourseById(int id) throws IOException {
		ServicePortfolioCourseMapper servicePortfolioCourseMapper = Session.session()
				.getMapper(ServicePortfolioCourseMapper.class);

		ServicePortfolioCourse spc = servicePortfolioCourseMapper.selectServicePortfolioCourseById(id);
		Session.session().close();
		return spc;
	}

	public List<ServicePortfolioCourse> selectServicePortfolioCourseByServiceID(int id) throws IOException {
		ServicePortfolioCourseMapper servicePortfolioCourseMapper = Session.session()
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> servicePortfolioCourses = servicePortfolioCourseMapper
				.selectServicePortfolioCourseByServiceID(id);
		Session.session().close();
		return servicePortfolioCourses;
	}

}
