package entity;

import java.util.List;

/* 
 * class này được viết với mục đích nhận dữ liệu từ form gửi về server
*/
public class ServicePortfolioConfigurationWrapper {
	ServicePortfolioConfiguration spcf;

	// hiển thị view từng gs_name đi kèm là danh sách g_name thuộc về 1 gs_name
	List<GroupSecern> gss;

	// lấy dữ liệu danh sách các PortfolioGroup người dùng chọn
	List<PortfolioGroup> pgs;

	// lấy dữ liệu danh sách các ServicePortfolioCourse người dùng chọn
	List<ServicePortfolioCourse> spcs;

	// lấy dữ liệu danh sách các PortfolioConfigurationCourse người dùng chọn
	List<PortfolioConfigurationCourse> pccs;

	public List<PortfolioGroup> getPgs() {
		return pgs;
	}

	public void setPgs(List<PortfolioGroup> pgs) {
		this.pgs = pgs;
	}

	public ServicePortfolioConfiguration getSpcf() {
		return spcf;
	}

	public void setSpcf(ServicePortfolioConfiguration spcf) {
		this.spcf = spcf;
	}

	public List<PortfolioConfigurationCourse> getPccs() {
		return pccs;
	}

	public void setPccs(List<PortfolioConfigurationCourse> pccs) {
		this.pccs = pccs;
	}

	public List<GroupSecern> getGss() {
		return gss;
	}

	public void setGss(List<GroupSecern> gss) {
		this.gss = gss;
	}

	public List<ServicePortfolioCourse> getSpcs() {
		return spcs;
	}

	public void setSpcs(List<ServicePortfolioCourse> spcs) {
		this.spcs = spcs;
	}

	public ServicePortfolioConfigurationWrapper(ServicePortfolioConfiguration spcf, List<GroupSecern> gss,
			List<PortfolioGroup> pgs, List<ServicePortfolioCourse> spcs, List<PortfolioConfigurationCourse> pccs) {
		this.spcf = spcf;
		this.gss = gss;
		this.pgs = pgs;
		this.spcs = spcs;
		this.pccs = pccs;
	}

	public ServicePortfolioConfigurationWrapper() {
	}
}
