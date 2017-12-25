package entity;


public class QuestionAttribute {
	
	private int id;
	private String question_attribute_name;
	
	public QuestionAttribute() {
		super();
	}

	public QuestionAttribute(int id, String question_attribute_name) {
		super();
		this.id = id;
		this.question_attribute_name = question_attribute_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion_attribute_name() {
		return question_attribute_name;
	}

	public void setQuestion_attribute_name(String question_attribute_name) {
		this.question_attribute_name = question_attribute_name;
	}

	@Override
	public String toString() {
		return "QuestionAttribute [id=" + id + ", question_attribute_name="
				+ question_attribute_name + "]";
	}

	
	
	
	

}
