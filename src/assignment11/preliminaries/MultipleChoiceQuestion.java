package assignment11.preliminaries;

public class MultipleChoiceQuestion extends Question {

	private boolean option1;
	private boolean option2;
	private boolean option3;
	
	public MultipleChoiceQuestion(boolean option1, boolean option2, boolean option3, int mark) {
		
		super(mark);
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		
	}
	
	public boolean lookAtOption1Answer() {
		
		return option1;
		
	}
	
	public boolean lookAtOption2Answer() {
		
		return option2;
		
	}
	
	public boolean lookAtOption3Answer() {
		
		return option3;
		
	}
	
}
