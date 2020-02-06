package assignment11.preliminaries;

public class MarkExams {

	public static void main(String[] args) {
		
		NumericalQuestion nqMarkScheme = new NumericalQuestion(31, 3);
		BooleanQuestion bqMarkScheme = new BooleanQuestion(true, 1);
		MultipleChoiceQuestion mcqMarkScheme = new MultipleChoiceQuestion(false, true, false , 3);
		
		Exam markScheme = new Exam(nqMarkScheme, bqMarkScheme, mcqMarkScheme, 7);
		
		NumericalQuestion nqAttempt = new NumericalQuestion(29, 0);
		BooleanQuestion bqAttempt = new BooleanQuestion(true, 0);
		MultipleChoiceQuestion mcqAttempt = new MultipleChoiceQuestion(false, true, false, 0);
		
		Exam examAttempt = new Exam(nqAttempt, bqAttempt, mcqAttempt, 0);
		
		Marker martin = new Marker();
		martin.markAttempt(examAttempt, markScheme);
		
		System.out.println("Question 1: " + nqAttempt.readMark() + " out of " + nqMarkScheme.readMark());
		System.out.println("Question 2: " + bqAttempt.readMark() + " out of " + bqMarkScheme.readMark());
		System.out.println("Question 3: " + mcqAttempt.readMark() + " out of " + mcqMarkScheme.readMark());
		
		System.out.println("Total marks: " + examAttempt.readTotalMark());

		System.out.println(martin.convertMarksToClassification(examAttempt.readTotalMark(), 5, 4, 3));
		
	}

}
