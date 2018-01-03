package entity;

import java.util.List;

/* 
 * class này được viết với mục đích nhận dữ liệu từ form gửi về server
*/
public class ServicePortfolioConfigurationWrapper {
	ServicePortfolioConfiguration spcf;

	List<PortfolioGroup> pgs;

	List<PortfolioConfigurationCourse> pccs;

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

	public List<PortfolioGroup> getPgs() {
		return pgs;
	}

	public void setPgs(List<PortfolioGroup> pgs) {
		this.pgs = pgs;
	}

	public ServicePortfolioConfigurationWrapper(ServicePortfolioConfiguration spcf, List<PortfolioGroup> pgs,
			List<PortfolioConfigurationCourse> pccs) {
		this.spcf = spcf;
		this.pgs = pgs;
		this.pccs = pccs;
	}

	public ServicePortfolioConfigurationWrapper() {
	}

}
