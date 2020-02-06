package assignment2;
public class Meal {
	/*
	 * Question 1.2
	 */
	private Dish starter;
	private Dish main;
	private Dish dessert;

	public Dish getStarter() {
		return starter;
	}

	public void setStarter(Dish starter) {
		this.starter = starter;
	}

	public Dish getMain() {
		return main;
	}

	public void setMain(Dish main) {
		this.main = main;
	}

	public Dish getDessert() {
		return dessert;
	}

	public void setDessert(Dish dessert) {
		this.dessert = dessert;
	}
	
	/*
	 * Question 1.3
	 */
	public int calculateCalories(){
		return starter.getCalories() + main.getCalories() + dessert.getCalories();
	}

}
