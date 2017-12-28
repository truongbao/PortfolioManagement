/*package mappings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import entity.ServicePortfolioConfiguration;


@Repository
public class ServicePortfolioConfigurationMapperImlp extends SqlMapClientTemplate implements ServicePortfolioConfigurationMapper {
	
	//private static final String NAMESPACE = "user.";
	
	@Autowired(required = true)
	@Qualifier("sqlMapClient")
	public void injectSqlMapClient(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public int insertServicePortfolioConfiguration(
			ServicePortfolioConfiguration objSPCF) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateServicePortfolioConfiguration(
			ServicePortfolioConfiguration objSPCF) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteServicePortfolioConfigurationById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ServicePortfolioConfiguration> selectAll() {
		return queryForList("selectAll");
	}

	@Override
	public ServicePortfolioConfiguration selectServicePortfolioConfigurationById(
			int id) {
		// TODO Auto-generated method stub
		return null;
	}

     
	
}
*/