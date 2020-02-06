package assignment11.preliminaries;

public class BooleanQuestion extends Question {

	private boolean answer;
	
	public BooleanQuestion(boolean answer, int mark) {
		
		super(mark);
		this.answer = answer;
		
	}
	
	public boolean lookAtAnswer() {
		
		return answer;
		
	}
	
}
