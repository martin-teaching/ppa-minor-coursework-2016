package assignment10;

import java.util.ArrayList;
import java.util.Arrays;

public class Harvest {

	public static void main(String[] args) {
		
		Farm farm = new Farm();
		
		farm.addHarvester(new Harvester(1, 1));
		farm.addHarvester(new CombineHarvester(2, 2, 3));
		
		ArrayList<String> produce = new ArrayList<String>(Arrays.asList(new String[]{"Corn", "Wheat", "Oats", "Barley"}));
		
		for ( String product : produce ) {
			
			for (int i = 0; i < 5; i++) {
				
				farm.addField(product, 20);
				
			}
			
		}
		
		farm.harvest();
		
		System.out.println(farm.getProfit());
		
	}
	
}
