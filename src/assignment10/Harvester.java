package assignment10;
public class Harvester {

	private int fuelTankSize;
	private int topSpeed;
	
	public Harvester(int fuelTankSize, int topSpeed) {
		
		this.fuelTankSize = fuelTankSize;
		this.topSpeed = topSpeed;
		
		System.out.println(this.getClass() + " fuelTankSize " + fuelTankSize + " topSpeed " + topSpeed);
		
	}
	
	public int harvestingCapacity() {
		
		return fuelTankSize + topSpeed;
		
	}

}
