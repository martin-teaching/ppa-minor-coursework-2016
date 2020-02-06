package assignment7;
/**
 * @author Martin
 *
 */
public class TreasureChest {
	
	/**
	 * 
	 */
	private GoldCoin[] goldCoins;
	
	/**
	 * 
	 */
	public static final int CHEST_SIZE = 10;
	
	/**
	 * 
	 */
	private int nextCoin;
	
	/**
	 * @param coins
	 * @param diamonds
	 */
	public TreasureChest() {
		
		this.goldCoins = new GoldCoin[TreasureChest.CHEST_SIZE];
		
		for ( int coin = 0; coin < goldCoins.length; coin++ ) {
			
			GoldCoin goldCoin = new GoldCoin();
			goldCoins[coin] = goldCoin;
			
		}
		
		nextCoin = goldCoins.length - 1;
		
	}
	
	/**
	 * @return
	 */
	public GoldCoin takeOneGoldCoin() {
		
		if ( nextCoin >= 0 ) {
			
			GoldCoin extractedCoin = goldCoins[nextCoin];
			goldCoins[nextCoin--] = null;
			return extractedCoin;
		
		} else {
			
			return null;
					
		}
		
	}
	
}
