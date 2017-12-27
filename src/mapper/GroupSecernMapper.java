package mapper;

import java.util.List;

import entity.GroupSecern;

public interface GroupSecernMapper {
	public void insertGroupSecern(GroupSecern groupSecern);

	public void updateGroupSecern(GroupSecern groupSecern);

	public void deleteGroupSecernById(int id);

	public List<GroupSecern> selectAllGroupSecern();

	public List<GroupSecern> selectGroupSecernById(int id);

}
