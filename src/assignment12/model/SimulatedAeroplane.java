package assignment12.model;

import java.awt.Rectangle;
import java.util.TreeMap;

import assignment12.assignment5.Aeroplane;
import assignment12.assignment5.Coordinates;

/**
 * Should reuse Aeroplane classes submitted for previous piece of work,
 * making amendments via extension.
 * 
 * @author Martin
 *
 */
public class SimulatedAeroplane extends Aeroplane {
	
	/**
	 * 
	 */
	private int elevation;
	
	/**
	 * 
	 */
	private boolean isTakingOff;
	
	/**
	 * Tracks time at certain speeds, for the purpose of working
	 * out when to elevate.
	 */
	private TreeMap<Integer, Integer> timeAtSpeed;
	
	/**
	 * Conceptualise runway as library object.
	 */
	private Rectangle runway;
	
	/**
	 * 
	 */
	public static final int SPEED_TO_ELEVATE = 10;
	
	/**
	 * 
	 */
	public static final int TIME_AT_SPEED_TO_ELEVATE = 5;
	
	/**
	 * 
	 */
	public static final int ELEVATION_TO_TAKE_OFF = 5;
	
	/**
	 * @param runway
	 */
	public SimulatedAeroplane(Rectangle runway) {
		
		super("", new Coordinates(5, 0), 0, 0, 0);
	
		this.runway = runway;
		
		timeAtSpeed = new TreeMap<Integer, Integer>();
		
		isTakingOff = true;
		
	}
	
	/**
	 * @param x
	 * @param speed
	 */
	public void updatePosition(int x, int speed) {
		
		// Shortcut for average speed * time.
		setCoordinates(x, getCoordinates().getY() + speed);
		
		if ( timeAtSpeed.get(speed) == null ) {
			
			timeAtSpeed.put(speed, 1);
			
		} else {
			
			timeAtSpeed.put(speed, timeAtSpeed.get(speed) + 1);
			
		}
		
		if ( speed >= SPEED_TO_ELEVATE && timeAtSpeed.get(speed) >= TIME_AT_SPEED_TO_ELEVATE ) {
			
			elevation++;
		
		}
		/* Optional reset of time at speed to ensure elevation only occurs if plane spends continuous time at top speed:
		else {
			
			timeAtSpeed.clear();
			
		}*/
		
	}
	
	/**
	 * Queries made of the model during the simulation loop.
	 * 
	 * @return
	 */
	public boolean inFlight() {
		
		// The plane is in flight if its elevation is greater than the elevation to take off, and if it is in the centre of the runway. This logic accounts for the fact that the plane can take off early if both elevation and X position are correct, but if the latter is not correct, the pilot still has time to alter course.
		if ( elevation > ELEVATION_TO_TAKE_OFF && getCoordinates().getX() == runway.getWidth() / 2 ) {
			
			isTakingOff = false;
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	/**
	 * @return
	 */
	public boolean takeOffFailed() {
		
		// Take off fails if the plane is greater than the length (height) of the runway, and the elevation isn't sufficient or the plane is not in the centre of the runway.
		if ( getCoordinates().getY() > runway.getHeight() && ( elevation <= ELEVATION_TO_TAKE_OFF || getCoordinates().getX() != runway.getWidth() / 2 ) ) {
			
			isTakingOff = false;
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}

	/**
	 * @return
	 */
	public boolean isTakingOff() {
		
		return isTakingOff;
		
	}
	
	/**
	 * @return
	 */
	public int getElevation() {
		
		return elevation;
		
	}
	
	/**
	 * 
	 */
	public void resetPosition() {
		
		setCoordinates(5, 0);
		
		elevation = 0;
		
		isTakingOff = true;
		
		timeAtSpeed.clear();
		
	}
	
}