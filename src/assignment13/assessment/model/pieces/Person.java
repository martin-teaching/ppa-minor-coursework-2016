package assignment13.assessment.model.pieces;

/**
 * Abstracts the need to supply id for future human passenger classes that extend this class.
 * 
 * @author Martin
 */
public class Person implements Passenger {
	
	private String id;
	
	// Not in interface, but supplied anyway:
	public Person(String id) {
		
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
		
		return id;
		
	}
	
}