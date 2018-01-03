package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.ServicePortfolioCourse;
import utility.Session;

@Repository
public class ServicePortfolioCourseMapperDao {
	public List<ServicePortfolioCourse> selectServicePortfolioCourseByCourseId(int id) throws IOException {
		ServicePortfolioCourseMapper configurationMapper = Session.session()
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> listSPConfiguration = configurationMapper
				.selectServicePortfolioCourseByCourseId(id);

		return listSPConfiguration;
	}

	public List<ServicePortfolioCourse> selectAllServicePortfolioCourse() throws IOException {
		ServicePortfolioCourseMapper configurationMapper = Session.session()
				.getMapper(ServicePortfolioCourseMapper.class);

		List<ServicePortfolioCourse> listSPConfiguration = configurationMapper.selectAllServicePortfolioCourse();

		return listSPConfiguration;
	}

	public ServicePortfolioCourse selectServicePortfolioCourseById(int id) throws IOException {
		ServicePortfolioCourseMapper configurationMapper = Session.session()
				.getMapper(ServicePortfolioCourseMapper.class);

		ServicePortfolioCourse spc = configurationMapper.selectServicePortfolioCourseById(id);

		return spc;
	}
}
