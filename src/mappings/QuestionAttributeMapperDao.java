package mappings;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.QuestionAttribute;
import utility.Session;

@Repository
public class QuestionAttributeMapperDao {
	public QuestionAttribute selectQuestionAttributeById(int id) throws IOException {
		
		SqlSession session = Session.sessionFactory().openSession();

		QuestionAttributeMapper questionAttributeMapper = session.getMapper(QuestionAttributeMapper.class);

		QuestionAttribute questionAttribute = questionAttributeMapper.selectQuestionAttributeById(id);
		// close session
		session.close();
		return questionAttribute;

	}
}
