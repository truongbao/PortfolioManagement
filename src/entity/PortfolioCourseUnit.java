package entity;

import java.sql.Timestamp;

public class PortfolioCourseUnit {
	
	private int id;
	private int portfolio_course_unit_level_id;
	private int sort_id;
	private int question_attribute_id;
	private int is_deleted;  
	private Timestamp created_at;
	private Timestamp updated_at;
	
	private int service_portfolio_course_id;
	private int level;
	private String question_attribute_name; //table question_attribute
	
	
	public PortfolioCourseUnit() {
		super();
	}


	//constructor full 10 tham số (co noi bang)
	public PortfolioCourseUnit(int id, int portfolio_course_unit_level_id,
			int sort_id, int question_attribute_id, int is_deleted,
			Timestamp created_at, Timestamp updated_at,
			int service_portfolio_course_id, int level,
			String question_attribute_name) {
		super();
		this.id = id;
		this.portfolio_course_unit_level_id = portfolio_course_unit_level_id;
		this.sort_id = sort_id;
		this.question_attribute_id = question_attribute_id;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.service_portfolio_course_id = service_portfolio_course_id;
		this.level = level;
		this.question_attribute_name = question_attribute_name;
	}

	//constructor 7 tham số (ko noi bang)
	public PortfolioCourseUnit(int id, int portfolio_course_unit_level_id,
			int sort_id, int question_attribute_id, int is_deleted,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.portfolio_course_unit_level_id = portfolio_course_unit_level_id;
		this.sort_id = sort_id;
		this.question_attribute_id = question_attribute_id;
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


	public int getPortfolio_course_unit_level_id() {
		return portfolio_course_unit_level_id;
	}


	public void setPortfolio_course_unit_level_id(int portfolio_course_unit_level_id) {
		this.portfolio_course_unit_level_id = portfolio_course_unit_level_id;
	}


	public int getSort_id() {
		return sort_id;
	}


	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}


	public int getQuestion_attribute_id() {
		return question_attribute_id;
	}


	public void setQuestion_attribute_id(int question_attribute_id) {
		this.question_attribute_id = question_attribute_id;
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


	public int getService_portfolio_course_id() {
		return service_portfolio_course_id;
	}


	public void setService_portfolio_course_id(int service_portfolio_course_id) {
		this.service_portfolio_course_id = service_portfolio_course_id;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public String getQuestion_attribute_name() {
		return question_attribute_name;
	}


	public void setQuestion_attribute_name(String question_attribute_name) {
		this.question_attribute_name = question_attribute_name;
	}


	@Override
	public String toString() {
		return "PortfolioCourseUnit [id=" + id
				+ ", portfolio_course_unit_level_id="
				+ portfolio_course_unit_level_id + ", sort_id=" + sort_id
				+ ", question_attribute_id=" + question_attribute_id
				+ ", is_deleted=" + is_deleted + ", created_at=" + created_at
				+ ", updated_at=" + updated_at
				+ ", service_portfolio_course_id="
				+ service_portfolio_course_id + ", level=" + level
				+ ", question_attribute_name=" + question_attribute_name + "]";
	}

	
	
	
	
	

}
