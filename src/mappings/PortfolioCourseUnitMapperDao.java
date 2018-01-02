package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.PortfolioCourseUnit;
import entity.PortfolioCourseUnitLevel;
import utility.Session;

@Repository
public class PortfolioCourseUnitMapperDao {

	public List<PortfolioCourseUnit> selectPortfolioCourseUnitByPCULId(int id) throws IOException {
		PortfolioCourseUnitMapper portfolioCourseUnitMapper = Session.session()
				.getMapper(PortfolioCourseUnitMapper.class);

		List<PortfolioCourseUnit> portfolioCourseUnits = portfolioCourseUnitMapper
				.selectPortfolioCourseUnitByPCULId(id);
		// close session
		Session.session().close();
		return portfolioCourseUnits;
	}
}
