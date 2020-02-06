package assignment4;
public class MarkExams {
	
	public static void main(String args[]){
		//create the numeric question for the mark scheme
		NumericalQuestion nqMarkScheme = new NumericalQuestion(31, 3);
		//create the boolean question for the mark scheme
		BooleanQuestion bqMarkScheme = new BooleanQuestion(true, 1);
		//create the MultiplChoiceQuestion for the mark scheme
		MultipleChoiceQuestion mcpMarkScheme = new MultipleChoiceQuestion(false, true, false, 3);
		//create the markscheme
		Exam markScheme = new Exam(nqMarkScheme, bqMarkScheme, mcpMarkScheme, 7);
		
		//create the numerical question for the attempt
		NumericalQuestion nqAttempt = new NumericalQuestion(29, 0);
		//create the boolean question for the attempt
		BooleanQuestion bqAttempt = new BooleanQuestion(true, 0);
		//create the MultiplChoiceQuestion for the attempt
		MultipleChoiceQuestion mcpAttempt = new MultipleChoiceQuestion(false, true, false, 0);
		//create the attempt
		Exam attempt = new Exam(nqAttempt, bqAttempt, mcpAttempt, 0);

		
		
		//mark the submission
		Marker marker = new Marker();
		marker.markAttempt(attempt, markScheme);
		System.out.println("Marks for Q1: " + attempt.getQuestion1().getMark() + " out of " + markScheme.getQuestion1().getMark());
		System.out.println("Marks for Q2: " + attempt.getQuestion2().getMark() + " out of " + markScheme.getQuestion2().getMark());
		System.out.println("Marks for Q3: " + attempt.getQuestion3().getMark() + " out of " + markScheme.getQuestion3().getMark());
		System.out.println("The total marks awarded to this attempt are: " + attempt.getTotalMarks() + " out of " + markScheme.getTotalMarks());
		
		//convert the mark to a classification;
		System.out.println("The classification is: "+marker.convertMarkstoClassification(attempt.getTotalMarks(), 5, 4, 3));
		
		
	}

}
