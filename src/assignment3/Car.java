package assignment3;

public class Car {
	private int id;
	private int fuel;
	private int lowFuelBoost;
	private int highFuelSlowdown;
	private int fuelConsumptionPerLap;
	private int pitStopTime;
	private int rainSlowdown;
	private int totalTime;
	
	
	
	public Car(int id, int fuel, int lowFuelBoost, int highFuelSlowdown, int fuelConsumptionPerLap, int pitStopTime,
			int rainSlowdown, int totalTime) {
		super();
		this.id = id;
		this.fuel = fuel;
		this.lowFuelBoost = lowFuelBoost;
		this.highFuelSlowdown = highFuelSlowdown;
		this.fuelConsumptionPerLap = fuelConsumptionPerLap;
		this.pitStopTime = pitStopTime;
		this.rainSlowdown = rainSlowdown;
		this.totalTime = totalTime;
	}

	public int completeLap(RaceTrack track){
		int lapTime = track.getAverageLapTime();
		if(fuel>50){
			lapTime = lapTime + highFuelSlowdown;
		} 
		else{
			lapTime = lapTime - lowFuelBoost;
		}
		if(track.isRaining()){
			lapTime = lapTime + rainSlowdown;
		}
		fuel = fuel - fuelConsumptionPerLap;
		if(fuel<fuelConsumptionPerLap){
			lapTime = lapTime + pitStopTime;
			fuel = 100;
		}
		totalTime = totalTime + lapTime;
		return lapTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFuel() {
		return fuel;
	}
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	public int getLowFuelBoost() {
		return lowFuelBoost;
	}
	public void setLowFuelBoost(int lowFuelBoost) {
		this.lowFuelBoost = lowFuelBoost;
	}
	public int getHighFuelSlowdown() {
		return highFuelSlowdown;
	}
	public void setHighFuelSlowdown(int highFuelSlowdown) {
		this.highFuelSlowdown = highFuelSlowdown;
	}
	public int getFuelConsumptionPerLap() {
		return fuelConsumptionPerLap;
	}
	public void setFuelConsumptionPerLap(int fuelConsumptionPerLap) {
		this.fuelConsumptionPerLap = fuelConsumptionPerLap;
	}
	public int getPitStopTime() {
		return pitStopTime;
	}
	public void setPitStopTime(int pitStopTime) {
		this.pitStopTime = pitStopTime;
	}
	public int getRainSlowdown() {
		return rainSlowdown;
	}
	public void setRainSlowdown(int rainSlowdown) {
		this.rainSlowdown = rainSlowdown;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", fuel=" + fuel + ", lowFuelBoost=" + lowFuelBoost + ", highFuelSlowdown="
				+ highFuelSlowdown + ", fuelConsumptionPerLap=" + fuelConsumptionPerLap + ", pitStopTime=" + pitStopTime
				+ ", rainSlowdown=" + rainSlowdown + ", totalTime=" + totalTime + "]";
	}
	
		

}
