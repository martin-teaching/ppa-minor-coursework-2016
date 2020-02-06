package assignment13.assessment.model.pieces;

/**
 * Represents an animal that eats other animals. Cannot be defined in animal class, 
 * as not all animals eat other animals.
 * 
 * @author Martin
 *
 */
public interface Predator {
	
	// Cannot put herbivore here, as not all predators necessarily eat herbivores.
	// Directly eats prey type.
	public void eats(Prey prey);

}
