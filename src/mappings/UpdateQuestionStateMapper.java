package mappings;

import entity.UpdateQuestionState;

public interface UpdateQuestionStateMapper {
	
	public UpdateQuestionState selectObjectUQSByState(); 
	
	public int updateQuestionState(UpdateQuestionState updateQuestionState);
	
	

}
