package assignment4;
public class Exam {
	
	//this will be a question requiring one specific int answer
	private NumericalQuestion question1;
	//this will be a question requiring the int answer to be within an acceptable range
	//private NumericRangeQuestion question2;
	//this will be a true or false question
	private BooleanQuestion question2;
	//this will be a multiple choice question;
	private MultipleChoiceQuestion question3;
	
	//hold the total mark
	private int totalMark;

	

	public Exam(NumericalQuestion question1, BooleanQuestion question2, MultipleChoiceQuestion question3,
			int totalMark) {
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.totalMark = totalMark;
	}

	public NumericalQuestion getQuestion1() {
		return question1;
	}



	public void setQuestion1(NumericalQuestion question1) {
		this.question1 = question1;
	}



	public BooleanQuestion getQuestion2() {
		return question2;
	}



	public void setQuestion2(BooleanQuestion question2) {
		this.question2 = question2;
	}



	public MultipleChoiceQuestion getQuestion3() {
		return question3;
	}



	public void setQuestion3(MultipleChoiceQuestion question3) {
		this.question3 = question3;
	}



	public int getTotalMarks() {
		return totalMark;
	}



	public void setTotalMarks(int totalMarks) {
		this.totalMark = totalMarks;
	}
	
	
	
	
	
	
	
	
	
	
	
}
