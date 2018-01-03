package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.PortfolioCourseUnitLevel;
import utility.Session;

@Repository
public class PortfolioCourseUnitLevelMapperDao {

	public List<PortfolioCourseUnitLevel> selectPortfolioCourseUnitLevelBySPCourseId(int id) throws IOException {
		PortfolioCourseUnitLevelMapper portfolioCourseUnitLevelMapper = Session.session()
				.getMapper(PortfolioCourseUnitLevelMapper.class);

		List<PortfolioCourseUnitLevel> portfolioCourseUnitLevels = portfolioCourseUnitLevelMapper
				.selectPortfolioCourseUnitLevelBySPCourseId(id);
		// close session
		Session.session().close();
		return portfolioCourseUnitLevels;
	}
	
}
