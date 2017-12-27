package mapper;

import java.util.List;

import entity.Course;
import entity.Group;

public interface GroupMapper {
	public int insertGroup(Group group);

	public int updateGroup(Group group);

	public int deleteGroupById(int id);

	public List<Group> selectAllGroup();

	public List<Group> selectGroupById(int id);

	public List<Group> selectGroupByGroupSecernId(int id);
}
