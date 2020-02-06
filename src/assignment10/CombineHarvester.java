package assignment10;

public class CombineHarvester extends Harvester {
	
	private int cutterbarLength;
	
	public CombineHarvester(int fuelCapacity, int speed, int cutterbarLength) {
		
		super(fuelCapacity, speed);
		this.cutterbarLength = cutterbarLength;
		
	}
	
	public int harvestingCapacity() {
		
		return super.harvestingCapacity() * cutterbarLength;
		
	}

}
