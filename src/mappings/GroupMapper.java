package mappings;

import java.util.List;

import entity.Group;

public interface GroupMapper {
	public int insertGroup(Group group);

	public int updateGroup(Group group);

	public int deleteGroupById(int id);

	public List<Group> selectAllGroup();

	public Group selectGroupById(int id);

	public List<Group> selectGroupByGroupSecernId(int id);
	public List<Group> selectGroupNameAndGsNameById(int id);
	 

}
