package entity;

import java.sql.Timestamp;
import java.util.List;

public class PortfolioCourseUnitLevel {

	private int id;
	private int service_portfolio_course_id;
	private int level;
	private int is_deleted;
	private Timestamp created_at;
	private Timestamp updated_at;
	private int service_id;
	private int sort_id;
	private int course_id;

	private String question_attribute_name;
	// thể hiện mối quan hệ 1-n của PortfolioCourseUnitLevel-portfoliocourseunit
	private List<PortfolioCourseUnit> question_attribute_list;

	public List<PortfolioCourseUnit> getQuestion_attribute_list() {
		return question_attribute_list;
	}

	public void setQuestion_attribute_list(List<PortfolioCourseUnit> question_attribute_list) {
		this.question_attribute_list = question_attribute_list;
	}

	public PortfolioCourseUnitLevel(int id, int service_portfolio_course_id, int level, int is_deleted,
			Timestamp created_at, Timestamp updated_at, int service_id, int sort_id, int course_id,
			String question_attribute_name, List<PortfolioCourseUnit> question_attribute_list) {
		this.id = id;
		this.service_portfolio_course_id = service_portfolio_course_id;
		this.level = level;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.service_id = service_id;
		this.sort_id = sort_id;
		this.course_id = course_id;
		this.question_attribute_name = question_attribute_name;
		this.question_attribute_list = question_attribute_list;
	}

	public PortfolioCourseUnitLevel(int id, int service_portfolio_course_id, int level, int is_deleted,
			Timestamp created_at, Timestamp updated_at, int service_id, int sort_id, int course_id,
			List<PortfolioCourseUnit> question_attribute_list) {
		this.id = id;
		this.service_portfolio_course_id = service_portfolio_course_id;
		this.level = level;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.service_id = service_id;
		this.sort_id = sort_id;
		this.course_id = course_id;
		this.question_attribute_list = question_attribute_list;
	}

	public PortfolioCourseUnitLevel() {
	}

	public String getQuestion_attribute_name() {
		return question_attribute_name;
	}

	public void setQuestion_attribute_name(String question_attribute_name) {
		this.question_attribute_name = question_attribute_name;
	}

	// Constructor full 9 tham so (co noi bang)
	public PortfolioCourseUnitLevel(int id, int service_portfolio_course_id, int level, int is_deleted,
			Timestamp created_at, Timestamp updated_at, int service_id, int sort_id, int course_id) {
		super();
		this.id = id;
		this.service_portfolio_course_id = service_portfolio_course_id;
		this.level = level;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.service_id = service_id;
		this.sort_id = sort_id;
		this.course_id = course_id;
	}

	// Constructor 6 tham so (ko noi bang)
	public PortfolioCourseUnitLevel(int id, int service_portfolio_course_id, int level, int is_deleted,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
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
		return "PortfolioCourseUnitLevel [id=" + id + ", service_portfolio_course_id=" + service_portfolio_course_id
				+ ", level=" + level + ", is_deleted=" + is_deleted + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", service_id=" + service_id + ", sort_id=" + sort_id + ", course_id=" + course_id + "]";
	}

}
