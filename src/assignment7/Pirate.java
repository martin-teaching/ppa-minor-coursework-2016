package assignment7;
/**
 * @author Martin
 *
 */
public class Pirate {
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private Island[] map;
	
	/**
	 * 
	 */
	private GoldCoin[] purse;
	
	/**
	 * 
	 */
	private int coins;
	
	/**
	 * @param name
	 * @param map
	 */
	public Pirate(String name, Island[] map) {
		
		this.name = name;
		this.map = map;
		// Students to choose a sensible upper limit here, as suggested during the lecture.
		purse = new GoldCoin[100];  
		
	}
	
	/**
	 * Search for an island with a given name.
	 * 
	 * @param island
	 */
	public Island search(String name) {
		
		for ( Island location : map ) {
			
			if ( location.getName().equalsIgnoreCase(name) ) {
				
				return location;
				
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * @return
	 */
	public boolean getTreasure(Island island) {
		
		for ( int i = 0; i < island.numberOfLocations(); i++ ) {
			
			TreasureChest chest = island.dig(i);
			
			if ( chest != null ) {
				
				getCoinsFromChest(chest);
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * @param chest
	 */
	private void getCoinsFromChest(TreasureChest chest) {
		
		for ( int coin = 0; coin < TreasureChest.CHEST_SIZE; coin++ ) {
			
			GoldCoin extractedCoin = chest.takeOneGoldCoin();
			
			if ( extractedCoin != null ) {
			
				purse[coins++] = extractedCoin;
			
			}
			
		}
		
	}
	
	/**
	 * @return
	 */
	public int totalCoins() {
		
		return coins;
		
	}
	
	/**
	 * @param phrase
	 */
	public static void speak(String phrase) {
		
		String[] pirateSuffixes = {", arrr!", ", shiver me timbers!", ", avast!", ", ahoy, matey!", ", yo, ho ho!"}; 
		System.out.println(phrase + pirateSuffixes[(int)(Math.random() * pirateSuffixes.length)]);
		
	}

}
