package assignment5;
public class Destination {
	public String name;
	//co-ordinate of destination
	private Coordinates coordinates;
	
	public Destination(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
	
}
