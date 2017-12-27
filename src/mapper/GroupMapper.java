package mapper;

import java.util.List;

import entity.Course;
import entity.Group;

public interface GroupMapper {
	public void insertGroup(Group group);

	public void updateGroup(Group group);

	public void deleteGroupById(int id);

	public List<Group> selectAllGroup();

	public List<Group> selectGroupById(int id);

	public List<Group> selectGroupByGroupSecernId(int id);
}
