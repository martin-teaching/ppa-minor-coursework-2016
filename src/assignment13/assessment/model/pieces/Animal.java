package assignment13.assessment.model.pieces;

/**
* Abstracts the need to supply id for future animal passenger classes that extend this class.
* 
* @author Martin
*
*/
public class Animal implements Passenger {

	private String id;
	
	// Not in interface, but supplied anyway:
	public Animal(String id) {
		
		setId(id);
		
	}
		
	@Override
	public String getId() {
		
		return id;
	
	}

	@Override
	public void setId(String id) {
		
		this.id = id;
		
	}
	
	// Not in interface, but supplied anyway:
	public String toString() {
		
		return id + "";
		
	}

}