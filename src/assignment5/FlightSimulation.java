package assignment5;
public class FlightSimulation {
	public static void main(String[] args){
		
		Destination london = new Destination("London", new Coordinates(40, 30));
		Destination dubai = new Destination("Dubai", new Coordinates(90, 80));
		Destination maldives = new Destination("Maldives", new Coordinates(120, 90));
		
		Aeroplane concorde = new Aeroplane("Concordia", new Coordinates(40,35), 10, 0, 3500);
		
		System.out.println(london.getCoordinates().getX() + " " + london.getCoordinates().getY() + " " + dubai.getCoordinates().getX() + " " + dubai.getCoordinates().getY());
		//Make the plane run through its journeys for one day
		System.out.println("Plane=[" +concorde.getName() + "] travelling from =[" + london.getName() + "] to [" + dubai.getName() + "]");
		System.out.println("Travelled distance=[" + concorde.singleFlight(dubai) + "]");
		System.out.println("Math distance: " + (Math.abs((london.getCoordinates().getX() - dubai.getCoordinates().getX()) + (london.getCoordinates().getY() - dubai.getCoordinates().getY()))));
		System.out.println("Total Distance=["+concorde.getTotalDistance()+"]");
		System.out.println("Coordinates now = ["+concorde.getCoordinates().getX() + "," + concorde.getCoordinates().getY() +"]");
		
		System.out.println("Plane=[" +concorde.getName() + "] travelling from =[" + dubai.getName() + "] to [" + maldives.getName() + "]");
		System.out.println("Travelled distance=[" + concorde.singleFlight(maldives) + "]");
		System.out.println("Total Distance=["+concorde.getTotalDistance()+"]");
		System.out.println("Coordinates now = ["+concorde.getCoordinates().getX() + "," + concorde.getCoordinates().getY() +"]");
		
		System.out.println("Plane=[" +concorde.getName() + "] travelling from =[" + maldives.getName() + "] to [" + dubai.getName() + "]");
		System.out.println("Travelled distance=[" + concorde.singleFlight(dubai) + "]");
		System.out.println("Total Distance=["+concorde.getTotalDistance()+"]");
		System.out.println("Coordinates now = ["+concorde.getCoordinates().getX() + "," + concorde.getCoordinates().getY() +"]");
		
		System.out.println("Plane=[" +concorde.getName() + "] travelling from =[" + dubai.getName() + "] to [" + london.getName() + "]");
		System.out.println("Travelled distance=[" + concorde.singleFlight(london) + "]");
		System.out.println("Total Distance=["+concorde.getTotalDistance()+"]");
		System.out.println("Coordinates now = ["+concorde.getCoordinates().getX() + "," + concorde.getCoordinates().getY() +"]");
		
		
		//make the plan run through it's journeys for many days
		int numOfDays = 120;
		int totalRepairs = 0;
		for(int i = 0; i<numOfDays; i++){
			
			System.out.println("This is day: " + (i+1));
			System.out.println("Total distance travelled until today =[" + concorde.getTotalDistance() + "]");
			if(concorde.getTotalDistance() > concorde.getRepairDistance()){
				System.out.println("The plane will be undergoing repairs for 7 days");
				concorde.setTotalDistance(0);
				i += 6;
				totalRepairs++;
			} else {
				concorde.singleFlight(dubai);
				concorde.singleFlight(maldives);
				concorde.singleFlight(dubai);
				concorde.singleFlight(london);
			}
		}
		
		System.out.println("Total repairs required=[" + totalRepairs + "]");
		
	}
}
