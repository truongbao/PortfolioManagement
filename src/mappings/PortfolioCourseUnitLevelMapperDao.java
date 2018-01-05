package mappings;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.PortfolioCourseUnitLevel;
import utility.Session;

@Repository
public class PortfolioCourseUnitLevelMapperDao {

	public List<PortfolioCourseUnitLevel> selectPortfolioCourseUnitLevelBySPCourseId(int id) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		PortfolioCourseUnitLevelMapper portfolioCourseUnitLevelMapper = session
				.getMapper(PortfolioCourseUnitLevelMapper.class);

		List<PortfolioCourseUnitLevel> portfolioCourseUnitLevels = portfolioCourseUnitLevelMapper
				.selectPortfolioCourseUnitLevelBySPCourseId(id);
		// close session
		session.close();
		return portfolioCourseUnitLevels;
	}
	
}
