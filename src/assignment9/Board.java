package assignment9;
import java.util.ArrayList;

public class Board {
	
	// 1.6.1
	private ArrayList<Battleship> ships;
	
	public Board() {
		
		ships = new ArrayList<Battleship>();
		addShips();
		
	}
	
	// 1.6.2
	private void addShips() {
		
		ships.add(new Battleship(0));
		ships.add(new Cruiser(1));
		ships.add(new Cruiser(2));
		ships.add(new Frigate(3));
		ships.add(new Minesweeper(4));
		
	}
	
	// 1.6.2
	public ArrayList<Battleship> getShips() {
		
		return ships;
		
	}

	// 1.6.3
	public boolean hit(int row, int column) {
		
		for ( Battleship ship : ships ) {
			
			if ( ship.hit(row, column) ) return true;
		
		}
		
		return false;
		
	}
	
	// 1.6.4
	public String toString() {
		
		String output = "";
		
		for ( Battleship ship : ships ) {
			
			output += ship;
			
			int size;
			
			// Nice readable way to interact with different types of ships. Allows us to keep parts encapsulated. Method inside Battleship to deal with this is also fine (and neater, but doesn't explore instanceof), as is different toString methods in each subclass.
			if ( ship instanceof Cruiser ) {
				
				size = 4;
			
			} else if ( ship instanceof Frigate ) {
				
				size = 3;
				
			} else if ( ship instanceof Minesweeper ) {
				
				size = 2;
			
			} else {
				
				size = 5;
				
			}
			
			for ( int i = size; i < 5; i++ ) {
				
				output += ", [ ]";
				
			}
			
			output += "\n";
			
		}
		
		return output;
		
	}
	
}
