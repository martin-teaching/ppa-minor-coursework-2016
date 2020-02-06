package assignment2;
public class Person {
	/*
	 * Question 1.1
	 */
	private int calories;

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	/*
	 * Question 1.4
	 */
	public void eat(Meal meal) {
		calories = calories + meal.calculateCalories();
	}
	
	/*
	 * Question 1.5
	 */
	public void walk(int minutes){
		calories = calories - minutes;
	}

}
