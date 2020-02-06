package assignment13.assessment.model.pieces;

/**
 * Used to identify passenger. Class name could be used but less flexible.
 * 
 * Also has benefits in terms of facilitating transfer between name of piece,
 * and piece objects.
 * 
 * @author Martin
 *
 */
public interface Passenger {
	
	public String getId();
	
	public void setId(String id);
	
}
