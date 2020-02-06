package assignment8;
//Q1.1 - All of this is for Q1.1
public class GoldCoin {
	
	private static int currentNum = 1;
	private int coinNumber;
	
	public GoldCoin(){
		coinNumber = currentNum++;
	}
	
	public int getCoinNumber(){
		return coinNumber;
	}

}
