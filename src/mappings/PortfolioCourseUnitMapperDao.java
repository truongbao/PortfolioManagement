package mappings;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.PortfolioCourseUnit;
import utility.Session;

@Repository
public class PortfolioCourseUnitMapperDao {

	public List<PortfolioCourseUnit> selectPortfolioCourseUnitByPCULId(int id) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		PortfolioCourseUnitMapper portfolioCourseUnitMapper = session
				.getMapper(PortfolioCourseUnitMapper.class);

		List<PortfolioCourseUnit> portfolioCourseUnits = portfolioCourseUnitMapper
				.selectPortfolioCourseUnitByPCULId(id);
		// close session
		session.close();
		return portfolioCourseUnits;
	}
}
