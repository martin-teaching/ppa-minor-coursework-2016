package assignment3;

public class RaceSimulator {
	
	public static void main(String[] args){
		RaceTrack silverstone = new RaceTrack(Integer.parseInt(args[0]), false);
		
		Car car1 = new Car(1, toInt(args[1]), toInt(args[2]), toInt(args[3]), toInt(args[4]), toInt(args[5]), toInt(args[6]), 0);
		Car car2 = new Car(2, toInt(args[7]), toInt(args[8]), toInt(args[9]), toInt(args[10]), toInt(args[11]), toInt(args[12]), 0);
		Car car3 = new Car(3, toInt(args[13]), toInt(args[14]), toInt(args[15]), toInt(args[16]), toInt(args[17]), toInt(args[18]), 0);
		
		System.out.println(silverstone.toString());
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println(car3.toString());
		
		car1.completeLap(silverstone);
		car2.completeLap(silverstone);
		car3.completeLap(silverstone);
		System.out.println("car1 total=" + car1.getTotalTime());
		System.out.println("car2 total=" + car2.getTotalTime());
		System.out.println("car3 total=" + car3.getTotalTime());
		System.out.println("leader="+silverstone.determineRaceLeader(car1, car2, car3).getId());
		
		car1.completeLap(silverstone);
		car2.completeLap(silverstone);
		car3.completeLap(silverstone);
		System.out.println("car1 total=" + car1.getTotalTime());
		System.out.println("car2 total=" + car2.getTotalTime());
		System.out.println("car3 total=" + car3.getTotalTime());
		System.out.println("leader="+silverstone.determineRaceLeader(car1, car2, car3).getId());
		
		silverstone.setRaining(true);
		car1.completeLap(silverstone);
		car2.completeLap(silverstone);
		car3.completeLap(silverstone);
		System.out.println("car1 total=" + car1.getTotalTime());
		System.out.println("car2 total=" + car2.getTotalTime());
		System.out.println("car3 total=" + car3.getTotalTime());
		System.out.println("winner="+silverstone.determineRaceLeader(car1, car2, car3).getId());
		
	}
	
	private static int toInt(String num){
		return Integer.parseInt(num);
	}
}
