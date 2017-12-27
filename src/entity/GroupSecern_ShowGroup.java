package entity;

import java.util.List;

public class GroupSecern_ShowGroup {
	private int secern_id;
	private String group_secern_name;
	private List<Group> group_list;

	public GroupSecern_ShowGroup() {
		// TODO Auto-generated constructor stub
	}

	public GroupSecern_ShowGroup(int secern_id, String group_secern_name, List<Group> group_list) {
		super();
		this.secern_id = secern_id;
		this.group_secern_name = group_secern_name;
		this.group_list = group_list;
	}

	public int getSecern_id() {
		return secern_id;
	}

	public String getGroup_secern_name() {
		return group_secern_name;
	}

	public void setGroup_secern_name(String group_secern_name) {
		this.group_secern_name = group_secern_name;
	}

	public void setSecern_id(int secern_id) {
		this.secern_id = secern_id;
	}

	public List<Group> getGroup_list() {
		return group_list;
	}

	public void setGroup_list(List<Group> group_list) {
		this.group_list = group_list;
	}

}
