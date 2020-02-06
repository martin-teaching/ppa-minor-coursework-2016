package assignment5;
public class Aeroplane {
	private String name;
	//the coordinates of the plane
	private Coordinates coordinates;
	//the amount a plane can travel in one go on x-axis
	private int speed;
	//the total distance travelled on x and y axis
	private int totalDistance;
	
	/*the average number of days after which the plane develops
	 * a fault and then needs to go for repairs 
	 */
	private int repairDistance;
	

	public Aeroplane(String name, Coordinates coordinates, int speed, int totalDistance,
			int repairDistance) {
		this.name = name;
		this.coordinates = coordinates;
		this.speed = speed;
		this.totalDistance = totalDistance;
		this.repairDistance = repairDistance;
	}




	public int singleFlight(Destination destination){
		
		int startDistance = totalDistance; 
		
		int destX = destination.getCoordinates().getX();
		int destY = destination.getCoordinates().getY();
		
		while((coordinates.getX() != destX) || (coordinates.getY() != destY)){
			
			System.out.println(coordinates.getX() + "," + coordinates.getY() + "->" + destX + " " + destY);
			//move the plane on x axis
			//first, check if the plane has to move positive on x axis
			if(coordinates.getX() < destX){
				//if plane can overshoot, then only move as much as necessary
				int xDifference = destX - coordinates.getX();
				
				if(xDifference < speed){
					coordinates.setX(coordinates.getX() + xDifference);
					totalDistance += xDifference;
					
				}
				//else, move full speed
				else{
					coordinates.setX(coordinates.getX() + speed);
					totalDistance += speed;
					
				}
			}
			//second, check if the plane has to move negative on x axis
			else if(coordinates.getX() > destX){
				//if plane can overshoot, then only move as much as necessary
				int xDifference = coordinates.getX() - destX;
				
				if(xDifference < speed){
					coordinates.setX(coordinates.getX() - xDifference);
					totalDistance += xDifference;
					
				}
				//else, move full speed
				else{
					coordinates.setX(coordinates.getX() - speed);
					totalDistance += speed;
					
				}
			}
			//Now, move plane on y- axis, exactly the same way as y-axis
			//first, check if the plane has to move positive on y axis
			if(coordinates.getY() < destY){
				//if plane can overshoot, then only move as much as necessary
				int yDifference = destY - coordinates.getY();
				if(yDifference < speed){
					coordinates.setY(coordinates.getY() + yDifference);
					totalDistance += yDifference;
					
				}
				//else, move full speed
				else{
					coordinates.setY(coordinates.getY() + speed);
					totalDistance += speed;
					
				}
			}
			//second, check if the plane has to move negative on y axis
			else if(coordinates.getY() > destY){
				//if plane can overshoot, then only move as much as necessary
				int yDifference = coordinates.getY() - destY;
				if(yDifference < speed){
					coordinates.setY(coordinates.getY() - yDifference);
					totalDistance += yDifference;
					
				}
				//else, move full speed
				else{
					coordinates.setY(coordinates.getY() - speed);
					totalDistance += speed;
					
				}
			}
		}
		return totalDistance - startDistance;
	}
	

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(int totalDistance) {
		this.totalDistance = totalDistance;
	}

	public int getRepairDistance() {
		return repairDistance;
	}


	public void setRepairDistance(int repairDistance) {
		this.repairDistance = repairDistance;
	}




	
	
	

}
