package assignment10;
import java.util.ArrayList;

public class Field {
	
	private ArrayList<Crop> crops;
	public static final int MAX_CROPS = 10;
	
	public Field(String type, int value) {
		
		this.crops = new ArrayList<Crop>();
		plant(type, value);
		
	}
	
	private void plant(String type, int value) {
		
		for ( int i = 0; i < MAX_CROPS; i++ ) {
			
			crops.add(new Crop(type, value));
			
		}
		
	}
	
	public int harvest() {
		
		int profit = 0;
		
		System.out.println("Total number of crops in field: " + crops.size());
		System.out.println("Value of crops in field: " + crops.get(0).getValue());
		
		for ( Crop crop : crops ) {
			
			profit += crop.getValue();
			System.out.println("Profit from individual field: " + profit);
			
		}
		
		crops.clear();
		
		return profit;
		
	}
	

}
