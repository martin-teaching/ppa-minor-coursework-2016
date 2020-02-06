package assignment7;
/**
 * @author Martin
 *
 */
public class GoldCoin {
	
	/**
	 * 
	 */
	private int coinNumber;
	
	/**
	 * 
	 */
	private static int numberOfCoins;
	
	/**
	 * 
	 */
	public GoldCoin() {
		
		coinNumber = numberOfCoins++;
		
	}
	
	/**
	 * @return
	 */
	public int readCoinNumber() {
		
		return coinNumber;
		
	}

}
