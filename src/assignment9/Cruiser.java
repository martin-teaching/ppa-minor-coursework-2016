package assignment9;
public class Cruiser extends Battleship {
	
	public Cruiser(int row) {
		
		super(row);
		// super(row, 4);
		
	}
	
	public void positionShip(int row) {
		
		positionShip(row, 4); // It's a neater representation to have this setup inside the class, rather than declared via an external argument. In the Villager example, we could have passed in a string to represent his behaviour.
		
	}

}
