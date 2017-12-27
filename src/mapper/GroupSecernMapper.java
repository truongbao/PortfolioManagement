package mapper;

import java.util.List;

import entity.GroupSecern;

public interface GroupSecernMapper {
	public int insertGroupSecern(GroupSecern groupSecern);

	public int updateGroupSecern(GroupSecern groupSecern);

	public int deleteGroupSecernById(int id);

	public List<GroupSecern> selectAllGroupSecern();

	public List<GroupSecern> selectGroupSecernById(int id);

}
