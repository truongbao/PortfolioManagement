package entity;

import java.sql.Timestamp;

public class Course {
	
	private int id;
	private String course_name;
	private int is_deleted;  //1 :xóa hoặc 0 : ko xóa
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public Course() {
		super();
	}

	public Course(int id, String course_name, int is_deleted,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.course_name = course_name;
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

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
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
		return "Course [id=" + id + ", course_name=" + course_name
				+ ", is_deleted=" + is_deleted + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
	
	
	
	
	

}
