package mappings;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import utility.Session;
import entity.GroupSecern;


@Repository
public class GroupSecernMapperDao {

	public 	List<GroupSecern> selectAllGroupSecern() throws IOException{
		
		SqlSession session = Session.sessionFactory().openSession();
		
		GroupSecernMapper groupSecernMapper = session.getMapper(GroupSecernMapper.class);
			
		List<GroupSecern> listGroupSecern1  = groupSecernMapper.selectAllGroupSecern();
		
		//close session
		session.close();
		
		return listGroupSecern1;
	}
	
	
}
