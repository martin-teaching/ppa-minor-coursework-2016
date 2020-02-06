package assignment13.assessment.model;

import java.util.ArrayList;
import java.util.Observable;

import assignment13.assessment.model.pieces.Beans;
import assignment13.assessment.model.pieces.Farmer;
import assignment13.assessment.model.pieces.Fox;
import assignment13.assessment.model.pieces.Goose;
import assignment13.assessment.model.pieces.Passenger;
import assignment13.assessment.model.pieces.Pieces;

/**
 * This assignment will likely be very tricky to mark.
 * 
 * So, I would advise looking for the following simple things:
 * 
 * 1. That the student can run their code, and show you a simple execution of the game where the game is won, and where the game is lost.
 * 2. That the student adheres to one form of the model view controller paradigm. You'll find different acceptable forms of the diagram here: https://github.kcl.ac.uk/MC/ppa-minor-coursework-ta/tree/ta/briefs/coursework13/e6FdNaws. Students who don't have any form of MVC separation should get at most 2/5.
 * 3. That the student has a reasonable representation in their model, such as not just having a single class called piece, from which everything extends, but appreciating the importance of using interfaces to allow type flexibility.
 *
 * This class effectively wraps river.
 * 
 * @author Martin
 */
public class Game extends Observable {
	
	private int score;
	private River river;
	private ArrayList<Passenger> pieces;
	
	public Game() {
		
		river = new River();
		pieces = new ArrayList<Passenger>();
		pieces.add(new Fox(Pieces.FOX));
		pieces.add(new Goose(Pieces.GOOSE));
		pieces.add(new Beans(Pieces.BEANS));
		pieces.add(new Farmer(Pieces.FARMER));
		
	}
	
	/**
	 * Using indexOf + get here is tricky, as which object to define for comparison?
	 * Can't instantiate interface.
	 * 
	 * @param piece
	 * @return
	 */
	public Passenger pieceToPassenger(String piece) {
		
		for ( Passenger passenger : pieces ) {
			
			if ( passenger.getId().equals(piece) ) {
				
				return passenger;
				
			}
			
		}
		
		return null;
		
	}

	public void start() {
		
		river.addToRightBank(pieceToPassenger(Pieces.FOX));
		river.addToRightBank(pieceToPassenger(Pieces.GOOSE));
		river.addToRightBank(pieceToPassenger(Pieces.BEANS));
		river.addToRightBank(pieceToPassenger(Pieces.FARMER));
		
	}
	
	//
	
	public boolean movePieceToBoat(Passenger passenger) {
		
		if ( river.boatOnLeft() && river.onLeftBank(passenger) && river.spaceForPassenger() ) {
			
			river.removeFromLeftBank(passenger);
			river.addToBoat(passenger);
			setChanged();
			notifyObservers();
			return true;
			
		} else if ( river.boatOnRight() && river.onRightBank(passenger) && river.spaceForPassenger() ) {
			
			river.removeFromRightBank(passenger);
			river.addToBoat(passenger);
			setChanged();
			notifyObservers();
			return true;
			
		}
		
		return false;
		
	}
	
	public void moveBoatLeft() {
		
		score--;
		river.moveBoatLeft();
		setChanged();
		notifyObservers();
		
	}
	
	public boolean movePieceToLeftBank(Passenger passenger) {
		
		if ( river.boatOnLeft() && river.inBoat(passenger) ) {
			
			river.removeFromBoat(passenger);
			river.addToLeftBank(passenger);
			setChanged();
			notifyObservers();
			return true;
			
		}
		
		return false;
		
	}
	
	public void moveBoatRight() {
		
		score--;
		river.moveBoatRight();
		setChanged();
		notifyObservers();
		
	}
	
	public boolean movePieceToRightBank(Passenger passenger) {
		
		if ( river.boatOnRight() && river.inBoat(passenger) ) {
			
			river.removeFromBoat(passenger);
			river.addToRightBank(passenger);
			setChanged();
			notifyObservers();
			return true;
			
		}
		
		return false;
		
	}
	
	//
	
	
	public int getScore() {
		
		return score;
		
	}
	
	public boolean gameOver() {
		
		return gameFailed() || gameSuccess();
		
	}
	
	private boolean gameFailed() {
		
		if ( ( river.boatOnRight() && river.getLeftBank().eaten() ) || river.boatOnLeft() && river.getRightBank().eaten() ) {
			
			return true;
		
		}
		
		return false;
		
	}
	
	private boolean gameSuccess() {
		
		return river.getLeftBank().allOnBank();
		
	}
	
	public String getOutcome() {
		
		if ( gameOver() ) {
			
			if ( river.getLeftBank().eaten() ) {
				
				return river.getLeftBank().getOutcome();
				
			} else if ( river.getRightBank().eaten() ) {
				
				return river.getRightBank().getOutcome();
				
			} else if ( river.getLeftBank().allOnBank() ) {
				
				return "Success!";
				
			}
					
		}
		
		return "";
		
	}
	
	public String toString() {
		
		return river.toString();
		
	}
	
	//
	
	public River getRiver() {
		
		return river;
		
	}	

}