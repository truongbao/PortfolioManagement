package mappings;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import utility.Session;
import entity.UpdateQuestionState;

@Repository
public class UpdateQuestionStateMapperDao {

	public UpdateQuestionState selectObjectUQSByState() throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();
		
		UpdateQuestionStateMapper questionStateMapper = session.getMapper(UpdateQuestionStateMapper.class);

		UpdateQuestionState objUQS = questionStateMapper.selectObjectUQSByState();
		session.close();
		return objUQS;
	}

}
