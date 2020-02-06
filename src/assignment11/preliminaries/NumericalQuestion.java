package assignment11.preliminaries;

public class NumericalQuestion extends Question {

	private int answer;
	
	public NumericalQuestion(int answer, int mark) {
		
		super(mark);
		this.answer = answer;
		
	}
	
	public int lookAtAnswer() {
		
		return answer;
		
	}
	
}
