package assignment9;
public class Frigate extends Battleship {
	
	public Frigate(int row) {
		
		super(row);
		// super(row, 3);
		
	}
	
	public void positionShip(int row) {
		
		positionShip(row, 3); // It's a neater representation to have this setup inside the class, rather than declared via an external argument. In the Villager example, we could have passed in a string to represent his behaviour.
		
	}

}
