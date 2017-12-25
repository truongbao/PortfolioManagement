package entity;

import java.sql.Timestamp;

public class PortfolioGroup {
	
	private int id;
	private int group_id; 
	private int service_portfolio_configuration_id;
	private int is_deleted;  //1 :xóa hoặc 0 : ko xóa
	private Timestamp created_at;
	private Timestamp updated_at;
	
	private int service_id;  //service_id : in table  service_portfolio_configurations
	private String name; //name : in table  service_portfolio_configurations
	private String state; //state : in table  service_portfolio_configurations
	private Timestamp aggregation_finished_at; //aggregation_finished_at : in table  service_portfolio_configurations
	
	private String group_name;
	private int group_secern_id; 
	
	public PortfolioGroup() {
		super();
	}

	//constructor full 12 tham so (co noi bang)
	public PortfolioGroup(int id, int group_id,
			int service_portfolio_configuration_id, int is_deleted,
			Timestamp created_at, Timestamp updated_at, int service_id,
			String name, String state, Timestamp aggregation_finished_at,
			String group_name, int group_secern_id) {
		super();
		this.id = id;
		this.group_id = group_id;
		this.service_portfolio_configuration_id = service_portfolio_configuration_id;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.service_id = service_id;
		this.name = name;
		this.state = state;
		this.aggregation_finished_at = aggregation_finished_at;
		this.group_name = group_name;
		this.group_secern_id = group_secern_id;
	}
	
    //constructor 6 tham so (ko noi bang)
	public PortfolioGroup(int id, int group_id,
			int service_portfolio_configuration_id, int is_deleted,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.group_id = group_id;
		this.service_portfolio_configuration_id = service_portfolio_configuration_id;
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

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getService_portfolio_configuration_id() {
		return service_portfolio_configuration_id;
	}

	public void setService_portfolio_configuration_id(
			int service_portfolio_configuration_id) {
		this.service_portfolio_configuration_id = service_portfolio_configuration_id;
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

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public int getGroup_secern_id() {
		return group_secern_id;
	}

	public void setGroup_secern_id(int group_secern_id) {
		this.group_secern_id = group_secern_id;
	}

	@Override
	public String toString() {
		return "PortfolioGroup [id=" + id + ", group_id=" + group_id
				+ ", service_portfolio_configuration_id="
				+ service_portfolio_configuration_id + ", is_deleted="
				+ is_deleted + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", service_id=" + service_id + ", name=" + name
				+ ", state=" + state + ", aggregation_finished_at="
				+ aggregation_finished_at + ", group_name=" + group_name
				+ ", group_secern_id=" + group_secern_id + "]";
	}
    
	
	
	

}
