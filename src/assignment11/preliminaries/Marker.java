package assignment11.preliminaries;

/**
 * 
 * For this phase of the work, students practice and demonstrate their understanding of Demeter's Law by fixing a
 * previous violation of it. 
 * 
 * This violation was in a piece of work from last term, CW4.
 * 
 * They were only asked to correct a single instance of this, which will probably be changing 
 * 
 * examAttempt.lookAtQuestion1().lookAtAnswer()
 * 
 * to 
 * 
 * examAttempt.lookAtQuestion1Answer()
 * 
 * with the addition of a new method in Exam.
 * 
 * 
 * @author Martin
 *
 */
public class Marker {

	public int markAttempt(Exam examAttempt, Exam markScheme) {
		
		
		/* Coupled NumericalQuestion object:
		
		if ( examAttempt.lookAtQuestion1().lookAtAnswer() == markScheme.lookAtQuestion1().lookAtAnswer() ) {
			
			examAttempt.lookAtQuestion1().giveMark(markScheme.lookAtQuestion1().readMark());
			
		} else if ( examAttempt.lookAtQuestion1().lookAtAnswer() == markScheme.lookAtQuestion1().lookAtAnswer() - 1 
				 || examAttempt.lookAtQuestion1().lookAtAnswer() == markScheme.lookAtQuestion1().lookAtAnswer() + 1  ) {
			
			examAttempt.lookAtQuestion1().giveMark(markScheme.lookAtQuestion1().readMark() - 1);
			
		} else if ( examAttempt.lookAtQuestion1().lookAtAnswer() >= markScheme.lookAtQuestion1().lookAtAnswer() - 5 
				 && examAttempt.lookAtQuestion1().lookAtAnswer() <= markScheme.lookAtQuestion1().lookAtAnswer() + 5  ) {
		
			examAttempt.lookAtQuestion1().giveMark(1);
		
		} else {
			
			examAttempt.lookAtQuestion1().giveMark(0);
			
		}*/
		
		// Uncoupled NumericalQuestion object:
		if ( examAttempt.lookAtQuestion1Answer() == markScheme.lookAtQuestion1Answer() ) {
			
			examAttempt.giveQuestion1Mark(markScheme.lookAtQuestion1Mark());
			
		} else if ( examAttempt.lookAtQuestion1Answer() == markScheme.lookAtQuestion1Answer() - 1 
				 || examAttempt.lookAtQuestion1Answer() == markScheme.lookAtQuestion1Answer() + 1  ) {
			
			examAttempt.giveQuestion1Mark(markScheme.lookAtQuestion1Mark() - 1);
			
		} else if ( examAttempt.lookAtQuestion1Answer() >= markScheme.lookAtQuestion1Answer() - 5 
				 && examAttempt.lookAtQuestion1Answer() <= markScheme.lookAtQuestion1Answer() + 5  ) {
		
			examAttempt.giveQuestion1Mark(1);
		
		} else {
			
			examAttempt.giveQuestion1Mark(0);
			
		}
		
		// End uncoupling
		
		if ( examAttempt.lookAtQuestion2().lookAtAnswer() == markScheme.lookAtQuestion2().lookAtAnswer() ) {
			
			examAttempt.lookAtQuestion2().giveMark(markScheme.lookAtQuestion2().readMark());
			
		} else {
			
			examAttempt.lookAtQuestion2().giveMark(0);
			
		}
		
		if ( examAttempt.lookAtQuestion3().lookAtOption1Answer() == markScheme.lookAtQuestion3().lookAtOption1Answer() ) {
			
			examAttempt.lookAtQuestion3().giveMark(examAttempt.lookAtQuestion3().readMark() + 1);
	
		}
		
	    if ( examAttempt.lookAtQuestion3().lookAtOption2Answer() == markScheme.lookAtQuestion3().lookAtOption2Answer() ) {
			
			examAttempt.lookAtQuestion3().giveMark(examAttempt.lookAtQuestion3().readMark() + 1);
			
		}
		
	    if ( examAttempt.lookAtQuestion3().lookAtOption3Answer() == markScheme.lookAtQuestion3().lookAtOption3Answer() ) {
			
			examAttempt.lookAtQuestion3().giveMark(examAttempt.lookAtQuestion3().readMark() + 1);
			
		}
	    
	    // Coupled NumericalQuestionObject:
	    // int totalMark = examAttempt.lookAtQuestion1().readMark() + examAttempt.lookAtQuestion2().readMark() + examAttempt.lookAtQuestion3().readMark();
	    
	    // Uncoupled NumericalQuestionObject:
	    int totalMark = examAttempt.lookAtQuestion1Mark() + examAttempt.lookAtQuestion2().readMark() + examAttempt.lookAtQuestion3().readMark();
	    
	    // End uncoupling
	    
	    examAttempt.writeTotalMark(totalMark);
	    
	    return totalMark;
	    
	}
	
	public double convertMarksToClassification(int mark, int firstBoundary, int upperSecondBoundary, int lowerSecondBoundary) {
		
		if ( mark >= firstBoundary ) {
			
			return 1.1;
			
		} else if ( mark >= upperSecondBoundary ) {
			
			return 2.1;
			
		} else if ( mark >= lowerSecondBoundary ) {
			
			return 2.2;
			
		} else {
			
			return 0.0;
			
		}
	
	}
	
}
