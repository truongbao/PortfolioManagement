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

		List<Group> listGroup = groupMapper.selectGroupByGroupSecernId(id);

		// close session
		session.close();

		return listGroup;
	}

	public Group selectGroupById(int id) throws IOException {
		SqlSession session = Session.sessionFactory().openSession();

		GroupMapper groupMapper = session.getMapper(GroupMapper.class);

		Group group = groupMapper.selectGroupById(id);
		// close session
		session.close();
		return group;
	}

	public List<Group> selectGroupNameAndGsNameById(int id) throws IOException {

		SqlSession session = Session.sessionFactory().openSession();

		GroupMapper groupmapper = session.getMapper(GroupMapper.class);

		List<Group> listGroup = groupmapper.selectGroupNameAndGsNameById(id);

		// close session
		session.close();
		return listGroup;
	}
}
