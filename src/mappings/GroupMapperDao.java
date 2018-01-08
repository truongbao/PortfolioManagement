package mappings;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.Group;
import utility.Session;

@Repository
public class GroupMapperDao {
	public List<Group> selectGroupByGroupSecernId(int id) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		GroupMapper groupMapper = session.getMapper(GroupMapper.class);

		List<Group> listGroupSecern = groupMapper.selectGroupByGroupSecernId(id);

		// close session
		session.close();

		return listGroupSecern;
	}

	public Group selectGroupById(int id) throws IOException {
		SqlSession session = Session.sessionFactory().openSession();

		GroupMapper groupMapper = session.getMapper(GroupMapper.class);

		Group groupSecern = groupMapper.selectGroupById(id);

		// close session
		session.close();

		return groupSecern;
	}
}
