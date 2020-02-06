package assignment9;
public class Minesweeper extends Battleship {

	public Minesweeper(int row) {
		
		super(row);
		// super(row, 2);
		
	}
	
	public void positionShip(int row) {
		
		positionShip(row, 2); // It's a neater representation to have this setup inside the class, rather than declared via an external argument. In the Villager example, we could have passed in a string to represent his behaviour.
		
	}
	
	// 5.1
	public boolean hit(int row, int column) {
		
		if ( Math.random() <= 0.5 ) {
			
			return false;
			
		} else {
			
			return super.hit(row, column);
			
		}
	
		
	}
	
}
