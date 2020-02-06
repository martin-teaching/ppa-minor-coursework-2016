package assignment13.assessment.model;

import assignment13.assessment.model.pieces.Passenger;

/**
 * Most methods left protected as wrapped by game.
 * 
 * @author Martin
 *
 */
public class River {
	
	private Bank leftBank;
	private Bank rightBank;
	private Boat boat;
	
	public River() {
		
		leftBank = new Bank(true);
		rightBank = new Bank(false);
		boat = new Boat(rightBank);
		
	}
	
	//
	
	protected boolean boatOnRight() {
		
		return !boat.onLeft();
		
	}
	
	public boolean spaceForPassenger() {
		
		return boat.spaceForPassenger();
		
	}
	
	protected void removeFromRightBank(Passenger piece) {
		
		rightBank.removeFromBank(piece);
		
	}

	protected void addToBoat(Passenger piece) {
		
		boat.addPassenger(piece);
		
	}
	
	protected boolean inBoat(Passenger passenger) {
		
		return boat.contains(passenger);
		
	}
	
	protected boolean moveBoatLeft() {
		
		if ( boat.farmerOnBoard() ) {
			
			boat.moveToBank(leftBank);
			return true;
		
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean boatOnLeft() {
		
		return boat.onLeft();
		
	}
	
	protected void removeFromBoat(Passenger piece) {
		
		boat.removePassenger(piece);
		
	}
	
	protected void addToLeftBank(Passenger piece) {
		
		leftBank.addToBank(piece);
		
	}
	

	public boolean onLeftBank(Passenger shippable) {
		
		return leftBank.contains(shippable);
		
	}
	
	protected void removeFromLeftBank(Passenger piece) {
		
		leftBank.removeFromBank(piece);
		
	}

	protected boolean moveBoatRight() {
		
		if ( boat.farmerOnBoard() ) {
			
			boat.moveToBank(rightBank);
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	protected void addToRightBank(Passenger piece) {
		
		rightBank.addToBank(piece);
		
	}
	
	public boolean onRightBank(Passenger shippable) {
		
		return rightBank.contains(shippable);
		
	}
	
	//
	
	public String toString() {
		
		return leftBank + " | " + boat + " | " + rightBank;
				
	}
	
	// Breaking law of Demeter:
	
	public Bank getLeftBank() {
		
		return leftBank;
		
	}
	
	public Bank getRightBank() {
		
		return rightBank;
		
	}
	
}