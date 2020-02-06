package assignment9;
import java.util.ArrayList;

// Abstract Ship class would work in hiding the ability to specify the size of the ship via the constructor, yet enabling child classes to call this constructor. Would have to be abstract, otherwise don't gain anything over second constructor or overridden method.
public class Battleship {
	
	// Inheritance saves us having an additional name field here.
	
	// 1.2.1
	private ArrayList<Part> parts;
	
	public Battleship(int row) {
		
		parts = new ArrayList<Part>();
		positionShip(row);
		// this(row, 5);
		
	}
	
	/*
	
	Could use second (protected) constructor:
	
	public Battleship(int row, int maxColumn) {
		
		for ( int column = 0; column < maxColumn; column++ ) {
			
			parts.add(new Part(row, column));
			
		}
		
	}
		
	*/
	
	// 1.2.2
	public void positionShip(int row) {
		
		positionShip(row, 5);
		
	}
	
	// 1.2.2
	public void positionShip(int row, int maxColumn) { // Could be protected, or simply combined with previous method.
		
		for ( int column = 0; column < maxColumn; column++ ) {
			
			parts.add(new Part(row, column));
			
		}
		
	}
	
	// 1.2.3
	public boolean hit(int row, int column) {
		
		// Replace next two lines with: if ( part.contains(new Part(row, column)) ) { 
		for ( Part part : parts ) {
			
			if ( part.equals(new Part(row, column)) ) {
				
				part.setDestroyed();
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	// Acceptable solution to not include this, and just do one-way check inside equals.
	private boolean isDestroyed() {
		
		for ( Part part : parts ) {
			
			if ( !part.isDestroyed() ) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	// 1.2.4
	public boolean equals(Object battleship) {
		
		if ( !(battleship instanceof Battleship) ) return false;
		
		if ( isDestroyed() != ((Battleship)battleship).isDestroyed() ) return false; // If one ship is destroyed, and the other is not, then return false. Symmetry is optional, but a nice feature.
		
		return parts.size() == ((Battleship)battleship).parts.size();
		
	}
	
	// 1.2.5
	public String toString() {
		
		return parts.toString().substring(1, parts.toString().length() - 1);
		
	}

}
