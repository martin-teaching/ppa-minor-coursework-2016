package assignment13.assessment.model.pieces;

/**
 * Represents an animal that eats vegetables. Behaviour cannot be defined 
 * in the animal class, as not all animals can eat vegetables.
 * 
 * @author Martin
 *
 */
public interface Herbivore {
	
	// Directly eats vegetable type
	public void eats(Vegetable vegetable);

}
