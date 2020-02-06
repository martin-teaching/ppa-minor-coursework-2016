package assignment11.preliminaries;

public class Question {
	
	private int mark;
	
	public Question(int mark) {
		
		this.mark = mark;
	}
	
	public int readMark() {
		
		return mark;
		
	}

	public void giveMark(int mark) {
		
		this.mark = mark;
	
	}

}