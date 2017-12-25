package entity;

import java.sql.Timestamp;

public class ServicePortfolioConfiguration {
	
	private int id;
	private int service_id;  
	private String name;
	private String state;
	private Timestamp aggregation_finished_at;
	private int is_deleted;  //1 :xóa hoặc 0 : ko xóa
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public ServicePortfolioConfiguration() {
		super();
	}

	public ServicePortfolioConfiguration(int id, int service_id, String name,
			String state, Timestamp aggregation_finished_at, int is_deleted,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.service_id = service_id;
		this.name = name;
		this.state = state;
		this.aggregation_finished_at = aggregation_finished_at;  
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
		return "ServicePortfolioConfiguration [id=" + id + ", service_id="
				+ service_id + ", name=" + name + ", state=" + state
				+ ", aggregation_finished_at=" + aggregation_finished_at
				+ ", is_deleted=" + is_deleted + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}

	

}
