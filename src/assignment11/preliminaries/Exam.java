package assignment11.preliminaries;

public class Exam {
	
	private NumericalQuestion question1;
	private BooleanQuestion question2;
	private MultipleChoiceQuestion question3;
	private int totalMark;
	
	public Exam(NumericalQuestion question1, BooleanQuestion question2, MultipleChoiceQuestion question3, int totalMark) {
		
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.totalMark = totalMark;
		
	}
	
	/**
	 * A new method added to avoid directly accessing the question1 (Numerical Question) object.
	 * 
	 * @return
	 */
	public int lookAtQuestion1Answer() {
		
		return question1.lookAtAnswer();
		
	}
	
	public int lookAtQuestion1Mark() {
		
		return question1.readMark();
		
	}
	
	public void giveQuestion1Mark(int mark) {
		
		question1.giveMark(mark);
		
	}
	
	public BooleanQuestion lookAtQuestion2() {
		
		return question2;
		
	}
	
	public MultipleChoiceQuestion lookAtQuestion3() {
		
		return question3;
		
	}
	
	public void writeTotalMark(int totalMark) {
		
		this.totalMark = totalMark;
				
	}
	
	public int readTotalMark() {
		
		return totalMark;
		
	}

}
