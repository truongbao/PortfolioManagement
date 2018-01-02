package mappings;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import entity.PortfolioCourseUnit;
import entity.QuestionAttribute;
import utility.Session;

@Repository
public class QuestionAttributeMapperDao {
	public QuestionAttribute selectQuestionAttributeById(int id) throws IOException {

		QuestionAttributeMapper questionAttributeMapper = Session.session().getMapper(QuestionAttributeMapper.class);

		QuestionAttribute questionAttribute = questionAttributeMapper.selectQuestionAttributeById(id);
		// close session
		Session.session().close();
		return questionAttribute;

	}
}
