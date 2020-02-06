package assignment13.assessment.model;

import java.util.Arrays;

import assignment13.assessment.model.pieces.Pieces;
import assignment13.assessment.model.pieces.Passenger;

public class Boat {
	
	private Passenger[] passengers;
	private Bank currentBank;
	private int top;
	public static final int CAPACITY = 2;
	
	public Boat(Bank currentBank) {
		
		passengers = new Passenger[CAPACITY];
		this.currentBank = currentBank;
		top = 0;
		
	}
	
	public void addPassenger(Passenger passenger) {
		
		if ( top < passengers.length && passengers[top] == null ) {
			
			passengers[top++] = passenger;
			
		}
		
	}
	
	public void removePassenger(Passenger passenger) {
		
		for ( int i = 0; i < passengers.length; i++ ) {
			
			if ( passengers[i] != null && passengers[i].getId() == passenger.getId() ) {
				
				// Shuffle down, if necessary:
				for ( int j = i; j < passengers.length - 1; j++ ) {
					
					passengers[j] = passengers[j + 1];
					
				}

				passengers[passengers.length - 1] = null;
				top--;
				
			}
			
		}
		
	}
	
	public boolean spaceForPassenger() {
		
		return top < passengers.length;
		
	}

	public boolean contains(Passenger passenger) {
		
		for ( Passenger boardedPassenger : passengers ) {
			
			if ( boardedPassenger.getId().equals(passenger.getId()) ) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public boolean farmerOnBoard() {
		
		for ( Passenger passenger : passengers ) {
			
			if ( passenger.getId().equals(Pieces.FARMER)) return true;
			
		}
		
		return false;
		
	}
	
	//
	
	public void moveToBank(Bank Bank) {
		
		currentBank = Bank;
		
	}
	
	public boolean onLeft() {
		
		return currentBank.isLeft();
		
	}
	
	//
	
	public String toString() {
		
		return Arrays.toString(passengers);
		
	}

}
