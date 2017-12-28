package mappings;

import java.util.List;

import entity.QuestionAttribute;
import entity.ServicePortfolioConfiguration;

public interface QuestionAttributeMapper {
	public int insertQuestionAttribute(QuestionAttribute questionAttribute);

	public int updateQuestionAttribute(QuestionAttribute questionAttribute);

	public int deleteQuestionAttributeById(int id);

	public List<QuestionAttribute> selectAllQuestionAttribute();

	public QuestionAttribute selectQuestionAttributeById(int id);

}
