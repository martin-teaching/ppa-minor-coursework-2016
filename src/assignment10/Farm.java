package assignment10;
import java.util.ArrayList;

public class Farm {
	
	private ArrayList<Field> fields;
	private ArrayList<Harvester> harvesters;
	private int profit;
	
	public Farm() {
		
		this.fields = new ArrayList<Field>();
		this.harvesters = new ArrayList<Harvester>();
		
	}
	
	public void addHarvester(Harvester harvester) {
		
		harvesters.add(harvester);
		
	}
	
	public void addField(String type, int value) {
		
		Field newField = new Field(type, value);
		fields.add(newField);
		
	}
	
	public void harvest() {
		
		int totalHarvestingCapacity = 0;
		
		for ( Harvester harvester : harvesters ) {
			
			System.out.println(harvester.getClass() + " has capacity " + harvester.harvestingCapacity());
			
			totalHarvestingCapacity += harvester.harvestingCapacity();
			
		}
		
		System.out.println("totalHarvestingCapacity: " + totalHarvestingCapacity);
		
		System.out.println("Math.min(totalHarvestingCapacity, fields.size()) " + Math.min(totalHarvestingCapacity, fields.size()));
		
		for ( int i = 0; i < Math.min(totalHarvestingCapacity, fields.size()); i++ ) {
			
			System.out.println("Harvesting field: " + (i + 1));
			profit += fields.get(i).harvest();
			System.out.println("New profit " + profit);
			
		}
		
	}
	
	public int getProfit() {
		
		return profit;
		
	}
	

}
