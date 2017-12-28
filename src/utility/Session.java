package utility;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Session {
	
	public static SqlSession session() throws IOException{
		    // read config file
		    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

			// open session
			SqlSession session = sqlSessionFactory.openSession();
			
			return session;
				
	}
	
	
	
	
	
}
