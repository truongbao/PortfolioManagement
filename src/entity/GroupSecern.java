package entity;

import java.sql.Timestamp;
import java.util.List;

public class GroupSecern {

	private int id;
	private String group_secern_name;
	private int is_deleted; // 1 :xóa hoặc 0 : ko xóa
	private Timestamp created_at;
	private Timestamp updated_at;

	// list này thể hiện mối quan hệ 1-n của GroupSecern-Group
	private List<Group> groups;

	public GroupSecern(int id, String group_secern_name, int is_deleted, Timestamp created_at, Timestamp updated_at,
			List<Group> groups) {
		super();
		this.id = id;
		this.group_secern_name = group_secern_name;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.groups = groups;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public GroupSecern() {
		super();
	}

	public GroupSecern(int id, String group_secern_name, int is_deleted, Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.group_secern_name = group_secern_name;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroup_secern_name() {
		return group_secern_name;
	}

	public void setGroup_secern_name(String group_secern_name) {
		this.group_secern_name = group_secern_name;
	}

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "GroupSecern [id=" + id + ", group_secern_name=" + group_secern_name + ", is_deleted=" + is_deleted
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", groups=" + groups + "]";
	}



}
