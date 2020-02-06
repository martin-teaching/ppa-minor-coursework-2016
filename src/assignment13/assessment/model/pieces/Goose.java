package assignment13.assessment.model.pieces;

public class Goose extends Animal implements Herbivore, Prey {

	private boolean isEaten;
	
	public Goose(String id) {
		
		super(id);
		
	}
	
	@Override
	public boolean isEaten() {
		
		return isEaten;
		
	}

	@Override
	public void eat() {
		
		isEaten = true;
		
	}
	
	/* (non-Javadoc)
	 * @see assignment13.assessment.model.pieces.Herbivore#eats(assignment13.assessment.model.pieces.Vegetable)
	 * 
	 * We want the goose to be able to be able to store whether eaten or not. Abstract to edible class through prey type.
	 */
	@Override
	public void eats(Vegetable vegetable) {
		
		((Edible)vegetable).eat();
		
	}

}