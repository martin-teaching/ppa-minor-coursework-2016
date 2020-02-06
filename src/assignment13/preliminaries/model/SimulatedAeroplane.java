package assignment13.preliminaries.model;

import java.awt.Rectangle;
import java.util.TreeMap;

import assignment13.preliminaries.assignment5.Aeroplane;
import assignment13.preliminaries.assignment5.Coordinates;

/**
 * Make sure you check each student's preliminary tasks, and that they are
 * able to show you the connections between the different parts of their program.
 * 
 * @author Martin
 *
 */
public class SimulatedAeroplane extends Aeroplane {
	
	/**
	 * 
	 */
	private int time;
	
	/**
	 * 
	 */
	private int elevation;
	
	/**
	 * 
	 */
	private boolean isTakingOff;
	
	/**
	 * 
	 */
	private TreeMap<Integer, Integer> timeAtSpeed;
	
	/**
	 * 
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
	
	public void simulateTakeOff() {
		
		while ( isTakingOff() ) {
			
			updatePosition(getCoordinates().getX(), getSpeed());
			
			time++;
			
			System.out.println(time);
			
			if ( takeOffFailed() || inFlight()  ) {
				
				isTakingOff = false;
				
			}
			
			try { 
				
				Thread.sleep(1000);
			
			} catch ( InterruptedException e ) {}
			
		}

	}
	
	/**
	 * @param x
	 * @param speed
	 */
	private void updatePosition(int x, int speed) {
		
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
		
		// 3. Notifies observers
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * @return
	 */
	public boolean inFlight() {
		
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
		
		if ( getCoordinates().getY() > runway.getHeight() && ( elevation < ELEVATION_TO_TAKE_OFF || getCoordinates().getX() != runway.getWidth() / 2 ) ) {
			
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
	 * @return
	 */
	public int getTime() {
		
		return time;
		
	}
	
	/**
	 * 
	 */
	public void reset() {
		
		time = 0;
		
		setCoordinates(5, 0);
		
		elevation = 0;
		
		timeAtSpeed.clear();
		
		setChanged();
		notifyObservers();
		
		if ( !isTakingOff() ) {
			
			Thread simulateTakeOffContainer = new Thread() {
				
				public void run() {
					
					isTakingOff = true;
					
					simulateTakeOff();
				
				}
				
			};
			
			simulateTakeOffContainer.start();
		
		}
		
	}
	
}