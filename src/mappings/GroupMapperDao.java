package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Group;
import utility.Session;

@Repository
public class GroupMapperDao {
	public List<Group> selectGroupByGroupSecernId(int id) throws IOException {

		GroupMapper groupMapper = Session.session().getMapper(GroupMapper.class);

		List<Group> listGroupSecern = groupMapper.selectGroupByGroupSecernId(id);

		// close session
		Session.session().close();

		return listGroupSecern;
	}
}
