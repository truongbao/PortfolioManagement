package entity;

import java.sql.Timestamp;

public class QuestionState { // Table update_question_states 
	
	private int id;
	private int service_id;
	private String state;
	private int is_deleted;  //1 :xóa hoặc 0 : ko xóa
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public QuestionState() {
		super();
	}

	public QuestionState(int id, int service_id, String state, int is_deleted,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.service_id = service_id;
		this.state = state;
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

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		return "QuestionState [id=" + id + ", service_id=" + service_id
				+ ", state=" + state + ", is_deleted=" + is_deleted
				+ ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}

	
	

}
