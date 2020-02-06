package assignment13.assessment.model;

import java.util.ArrayList;

import assignment13.assessment.model.pieces.Farmer;
import assignment13.assessment.model.pieces.Herbivore;
import assignment13.assessment.model.pieces.Predator;
import assignment13.assessment.model.pieces.Prey;
import assignment13.assessment.model.pieces.Passenger;
import assignment13.assessment.model.pieces.Vegetable;

public class Bank {
	
	private boolean isLeft;
	private ArrayList<Passenger> pieces;
	private String outcome;
	
	public Bank(boolean isLeft) {
		
		this.isLeft = isLeft;
		pieces = new ArrayList<Passenger>();
		
	}
	
	public boolean isLeft() {
		
		return isLeft;
		
	}
	
	//
	
	public void addToBank(Passenger shippable) {
		
		pieces.add(shippable);
		
	}
	
	public void removeFromBank(Passenger passenger) {
		
		for ( int i = 0; i < pieces.size(); i++ ) {
			
			if ( pieces.get(i).getId().equals(passenger.getId()) ) {
				
				pieces.remove(i);
				
			}
			
		}
		
	}
	
	public boolean contains(Passenger passenger) {
		
		for ( Passenger piece : pieces ) {
			
			if ( piece.getId().equals(passenger.getId()) ) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	//
	
	public boolean eaten() {
		
		Predator predator = null;
		Prey prey = null;
		Herbivore herbivore = null;
		Vegetable vegetable = null;
		
		for ( Passenger content : pieces ) {
			
			if ( content instanceof Farmer ) return false;
			
			if ( content instanceof Predator ) predator = (Predator)content;
			
			if ( content instanceof Prey ) prey = (Prey)content;
			
			if ( content instanceof Herbivore ) herbivore = (Herbivore)content;
			
			if ( content instanceof Vegetable ) vegetable = (Vegetable)content;
			
		}
		
		if ( predator != null && prey != null ) { 
			
			predator.eats(prey);
			outcome = "Predator ate prey.";
			return true;
		
		} else if ( herbivore != null && vegetable != null ) {
			
			herbivore.eats(vegetable);
			outcome = "Herbivore ate vegetable.";
			return true;
			
		}
		
		return false;
			
	}
	
	public String getOutcome() {
		
		return outcome;
		
	}
	
	public boolean allOnBank() {
		
		if ( pieces.size() == 4 ) return true;
		
		return false;
		
	}
	
	//
	
	public String toString() {
		
		return pieces.toString();
		
	}

}
