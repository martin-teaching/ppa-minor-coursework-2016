package assignment4;
public class MultipleChoiceQuestion {
	private boolean option1;
	private boolean option2;
	private boolean option3;
	private int mark;
	
	
	public MultipleChoiceQuestion(boolean option1, boolean option2, boolean option3, int mark) {
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.mark = mark;
	}
	public boolean getOption1() {
		return option1;
	}
	public void setOption1(boolean option1) {
		this.option1 = option1;
	}
	public boolean getOption2() {
		return option2;
	}
	public void setOption2(boolean option2) {
		this.option2 = option2;
	}
	public boolean getOption3() {
		return option3;
	}
	public void setOption3(boolean option3) {
		this.option3 = option3;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	

}
