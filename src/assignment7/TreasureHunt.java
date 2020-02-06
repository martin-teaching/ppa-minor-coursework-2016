package assignment7;
import java.util.Scanner;

/**
 * @author Martin
 *
 */
public class TreasureHunt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Island[] map = {new Island("Port Royal", 10), new Island("Tortuga", 10), new Island("Dominica", 10), new Island("Nassau", 10), new Island("Havana", 10), new Island("St Kitts", 10), new Island("Guadeloupe", 10)};
		
		Pirate pirate = new Pirate("Chapbeard", map);
		
		Scanner in = new Scanner(System.in);
		
		String name;
		
		do {
			
			name = in.nextLine();
			
			if ( !name.equals("stop") ) {
				
				Pirate.speak("Searching for " + name);
				
				Island island = pirate.search(name);
				
				if ( island != null ) {
					
					if ( pirate.getTreasure(island) ) {
						
						Pirate.speak("Found treasure on " + name);
						Pirate.speak("The pirate now has " + pirate.totalCoins() + " coins");
						
					} else {
						
						Pirate.speak("No treasure found on " + name);
						
					}
					
					
				} else {
					
					Pirate.speak("No island found with the name " + name);
					
				}
			
			}
			
		} while ( !name.equals("stop") );
		
		in.close();
		
	}

}
