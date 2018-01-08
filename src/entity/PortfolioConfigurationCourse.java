package entity;

import java.sql.Timestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;


public class PortfolioConfigurationCourse {
	
	private int id;
	private int service_portfolio_configuration_id;

	private int service_portfolio_course_id;
	private int level;
	
	private int is_deleted;  //1 :xóa hoặc 0 : ko xóa
	private Timestamp created_at;
	private Timestamp updated_at;
	
	private int service_id;  //service_id : in table  service_portfolio_configurations
	private String name; //name : in table  service_portfolio_configurations
	private String state; //state : in table  service_portfolio_configurations
	private Timestamp aggregation_finished_at; //aggregation_finished_at : in table  service_portfolio_configurations
	
	private int sort_id;  // service_portfolio_courses
	private int course_id;// service_portfolio_courses
	
	public PortfolioConfigurationCourse() {
		super();
	}

	//constructor full 13 tham số (có nối bảng)
	public PortfolioConfigurationCourse(int id,
			int service_portfolio_configuration_id,
			int service_portfolio_course_id, int level, int is_deleted,
			Timestamp created_at, Timestamp updated_at, int service_id,
			String name, String state, Timestamp aggregation_finished_at,
			int sort_id, int course_id) {
		super();
		this.id = id;
		this.service_portfolio_configuration_id = service_portfolio_configuration_id;
		this.service_portfolio_course_id = service_portfolio_course_id;
		this.level = level;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.service_id = service_id;
		this.name = name;
		this.state = state;
		this.aggregation_finished_at = aggregation_finished_at;
		this.sort_id = sort_id;
		this.course_id = course_id;
	}

	
	//constructor 7 tham số (ko nối bảng)
	public PortfolioConfigurationCourse(int id,
			int service_portfolio_configuration_id,
			int service_portfolio_course_id, int level, int is_deleted,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.service_portfolio_configuration_id = service_portfolio_configuration_id;
		this.service_portfolio_course_id = service_portfolio_course_id;
		this.level = level;
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

	public int getService_portfolio_configuration_id() {
		return service_portfolio_configuration_id;
	}

	public void setService_portfolio_configuration_id(
			int service_portfolio_configuration_id) {
		this.service_portfolio_configuration_id = service_portfolio_configuration_id;
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

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getAggregation_finished_at() {
		return aggregation_finished_at;
	}

	public void setAggregation_finished_at(Timestamp aggregation_finished_at) {
		this.aggregation_finished_at = aggregation_finished_at;
	}

	public int getSort_id() {
		return sort_id;
	}

	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	@Override
	public String toString() {
		return "PortfolioConfigurationCourse [id=" + id
				+ ", service_portfolio_configuration_id="
				+ service_portfolio_configuration_id
				+ ", service_portfolio_course_id="
				+ service_portfolio_course_id + ", level=" + level
				+ ", is_deleted=" + is_deleted + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", service_id=" + service_id
				+ ", name=" + name + ", state=" + state
				+ ", aggregation_finished_at=" + aggregation_finished_at
				+ ", sort_id=" + sort_id + ", course_id=" + course_id + "]";
	}

	
	

}
