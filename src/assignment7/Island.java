package assignment7;
/**
 * @author Martin
 *
 */
public class Island {
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private TreasureChest[] locations;
	
	/**
	 * @param locations
	 */
	public Island(String name, int locations) {
		
		this.name = name;
		
		this.locations = new TreasureChest[locations];
		
		// Students to choose a sensible way to generate random numbers (Math best as class shown in lecture).
		this.locations[(int)(Math.random() * this.locations.length)] = new TreasureChest();
		
	}
	
	/**
	 * @param location
	 * @return
	 */
	public TreasureChest dig(int location) {
		
		if ( location < 0 || location >= locations.length ) return null;
		
		TreasureChest chest = locations[location];
		locations[location] = null;
		
		return chest;
		
	}
	
	/**
	 * @return
	 */
	public String getName() {
		
		return name;
		
	}
	
	/**
	 * @return
	 */
	public int numberOfLocations() {
		
		return locations.length;
		
	}
	
	
}
