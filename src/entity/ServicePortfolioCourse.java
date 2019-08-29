package entity;

import java.sql.Timestamp;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "course_id", "course_name", "level_selected", "level_list" })
@JsonIgnoreProperties({ "service_id", "sort_id", "is_deleted", "created_at", "updated_at" })
public class ServicePortfolioCourse {

	private int id;
	private int service_id;
	private int sort_id;
	private int course_id;
	private int is_deleted; // 1 :xóa hoặc 0 : ko xóa
	private Timestamp created_at;
	private Timestamp updated_at;
	private int level;

	// thuộc tính này tạo để load lại dữ liệu vào list
	private int isSelected = 0;
	// thuộc tính này để load question attribute cho spc đã được select
	@Min(1)
	@Max(3)
	private int level_selected = 1;

	private String course_name;
	// list này thể hiện mối quan hệ 1-n của
	// PortfolioCourseUnitLevel-ServicePortfolioCourse
	private List<PortfolioCourseUnitLevel> level_list;
	
	

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel_selected() {
		return level_selected;
	}

	public void setLevel_selected(int level_selected) {
		this.level_selected = level_selected;
	}

	public List<PortfolioCourseUnitLevel> getLevel_list() {
		return level_list;
	}

	public void setLevel_list(List<PortfolioCourseUnitLevel> level_list) {
		this.level_list = level_list;
	}

	public ServicePortfolioCourse() {
		super();
	}

	public int getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
	}

	public ServicePortfolioCourse(int id, int service_id, int sort_id, int course_id, int is_deleted,
			Timestamp created_at, Timestamp updated_at, String course_name, List<PortfolioCourseUnitLevel> level_list,int level) {
		this.id = id;
		this.service_id = service_id;
		this.sort_id = sort_id;
		this.course_id = course_id;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.course_name = course_name;
		this.level_list = level_list;
		this.level = level;
	}

	// constructor full 8 tham so (co noi bang)
	public ServicePortfolioCourse(int id, int service_id, int sort_id, int course_id, int is_deleted,
			Timestamp created_at, Timestamp updated_at, String course_name) {
		super();
		this.id = id;
		this.service_id = service_id;
		this.sort_id = sort_id;
		this.course_id = course_id;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.course_name = course_name;
	}

	// constructor 7 tham so (ko noi bang)
	public ServicePortfolioCourse(int id, int service_id, int sort_id, int course_id, int is_deleted,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.service_id = service_id;
		this.sort_id = sort_id;
		this.course_id = course_id;
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

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Override
	public String toString() {
		return "ServicePortfolioCourse [id=" + id + ", service_id=" + service_id + ", sort_id=" + sort_id
				+ ", course_id=" + course_id + ", is_deleted=" + is_deleted + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", isSelected=" + isSelected + ", level_selected=" + level_selected
				+ ", course_name=" + course_name + ", level_list=" + level_list + "]";
	}



}
