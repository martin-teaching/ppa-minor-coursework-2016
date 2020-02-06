package assignment13.assessment.model.pieces;

/**
 * An entity that serves two purposes:
 * 
 * 1. Abstracts the need to supply id for the passenger interface
 * 2. Abstract the 'beans'; an entity that can be eaten by a herbivore.
 * 
 * @author Martin
 *
 */
public class Vegetable implements Edible, Passenger {

	private String id;
	
	// Not in interface but supplied anyway:
	public Vegetable(String id) {
		
		this.id = id;
		
	}
	
	@Override
	public String getId() {
		
		return id;
	
	}

	@Override
	public void setId(String id) {
		
		this.id = id;
		
	}
	
	// Not in interface but supplied anyway:
	public String toString() {
		
		return id + "";
		
	}
	
	//
	
	private boolean isEaten;
	
	/* (non-Javadoc)
	 * @see assignment13.assessment.model.pieces.Edible#isEaten()
	 * 
	 * We want the beans to be able to respond to when eaten. Abstract to edible type.
	 */
	@Override
	public boolean isEaten() {
		
		return isEaten;
	
	}

	@Override
	public void eat() {
		
		isEaten = true;
		
	}
	
}
