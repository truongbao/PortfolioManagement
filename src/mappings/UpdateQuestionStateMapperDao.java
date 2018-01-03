package mappings;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import utility.Session;
import entity.UpdateQuestionState;

@Repository
public class UpdateQuestionStateMapperDao {

	public UpdateQuestionState selectObjectUQSByState() throws IOException {

		UpdateQuestionStateMapper questionStateMapper = Session.session().getMapper(UpdateQuestionStateMapper.class);

		UpdateQuestionState objUQS = questionStateMapper.selectObjectUQSByState();
		Session.session().close();
		return objUQS;
	}

}
