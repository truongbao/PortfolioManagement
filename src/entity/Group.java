package entity;

import java.sql.Timestamp;

public class Group {
	
	private int id;
	private int group_secern_id;  //khoa ngoai
	private String group_name;
	private int is_deleted;  //1 :xóa hoặc 0 : ko xóa
	private Timestamp created_at;
	private Timestamp updated_at;
	
	private String group_secern_name;
	
	public Group() {
		super();
	}

	//constructor full 7 tham so (co noi bang)
	public Group(int id, int group_secern_id, String group_name,
			int is_deleted, Timestamp created_at, Timestamp updated_at,
			String group_secern_name) {
		super();
		this.id = id;
		this.group_secern_id = group_secern_id;
		this.group_name = group_name;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.group_secern_name = group_secern_name;
	}

	//constructor 6 tham so (ko noi bang)
	public Group(int id, int group_secern_id, String group_name,
			int is_deleted, Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.group_secern_id = group_secern_id;
		this.group_name = group_name;
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

	public int getGroup_secern_id() {
		return group_secern_id;
	}

	public void setGroup_secern_id(int group_secern_id) {
		this.group_secern_id = group_secern_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
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

	public String getGroup_secern_name() {
		return group_secern_name;
	}

	public void setGroup_secern_name(String group_secern_name) {
		this.group_secern_name = group_secern_name;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", group_secern_id=" + group_secern_id
				+ ", group_name=" + group_name + ", is_deleted=" + is_deleted
				+ ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", group_secern_name=" + group_secern_name + "]";
	}

	
	
	

}
