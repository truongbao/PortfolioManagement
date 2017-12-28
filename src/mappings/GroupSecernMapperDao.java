package mappings;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import utility.Session;
import entity.GroupSecern;


@Repository
public class GroupSecernMapperDao {

	public 	List<GroupSecern> selectAllGroupSecern() throws IOException{
		
		GroupSecernMapper groupSecernMapper = Session.session().getMapper(GroupSecernMapper.class);
			
		List<GroupSecern> listGroupSecern1  = groupSecernMapper.selectAllGroupSecern();
		
		//close session
		Session.session().close();
		
		return listGroupSecern1;
	}
	
	
}
