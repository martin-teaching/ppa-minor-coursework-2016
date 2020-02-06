package assignment4;
public class Marker {
	
	public int markAttempt(Exam attempt, Exam markScheme){
		if(attempt.getQuestion1().getAnswer() == markScheme.getQuestion1().getAnswer()){
			attempt.getQuestion1().setMark(markScheme.getQuestion1().getMark());
		}
		else if(attempt.getQuestion1().getAnswer() >= markScheme.getQuestion1().getAnswer() - 1 
				&& attempt.getQuestion1().getAnswer() <= markScheme.getQuestion1().getAnswer() + 1){
			attempt.getQuestion1().setMark(markScheme.getQuestion1().getMark()-1);
		}
		else if(attempt.getQuestion1().getAnswer() >= markScheme.getQuestion1().getAnswer() - 5 
				&& attempt.getQuestion1().getAnswer() <= markScheme.getQuestion1().getAnswer() + 5){
			attempt.getQuestion1().setMark(markScheme.getQuestion1().getMark()-2);
		}
		
		if(attempt.getQuestion2().getAnswer() == markScheme.getQuestion2().getAnswer()){
			attempt.getQuestion2().setMark(1);
		}
		
		attempt.getQuestion3().setMark(0);
		if(attempt.getQuestion3().getOption1() == markScheme.getQuestion3().getOption1()){
			attempt.getQuestion3().setMark(attempt.getQuestion3().getMark()+1);
		}
		if(attempt.getQuestion3().getOption2() == markScheme.getQuestion3().getOption2()){
			attempt.getQuestion3().setMark(attempt.getQuestion3().getMark()+1);
		}
		if(attempt.getQuestion3().getOption3() == markScheme.getQuestion3().getOption3()){
			attempt.getQuestion3().setMark(attempt.getQuestion3().getMark()+1);
		}
		//do not forget to update the attempt's total mark
		attempt.setTotalMarks(attempt.getQuestion1().getMark() + attempt.getQuestion2().getMark() + attempt.getQuestion3().getMark());
		return attempt.getTotalMarks();
	}

	
	public double convertMarkstoClassification(int marks, int firstBoundary, int upperSecondBoundary, int lowerSecondBoundary){
		if(marks >= firstBoundary){
			return 1.1;
		}
		else if(marks >= upperSecondBoundary){
			return 2.1;
		}
		else if(marks >= lowerSecondBoundary){
			return 2.2;
		}
		else{
			return 0.0;
		}
	}
	
}
