package assignment11.assessment;

/**
 * Overall comments:
 * 
 * Be sure to look out for any violations of Demeter's Law when marking this assignment,
 * and deduct marks accordingly:
 * 
 * [ObjectA].[Method in ObjectA that returns ObjectB]().[Method in ObjectB]()
 * 
 * I have constructed a solution where there is strictly no interaction between Main and Person (i.e.
 * they are strictly decoupled; bar the inheritance from Banker), but it isn't strictly necessary 
 * for the students to do this (e.g. they could create Person objects in Main), so long as they haven't 
 * broken Demeter's Law anywhere.
 * 
 * I have placed a solution that involves stronger interaction between Main and Person in comments. Not
 * all of these approaches directly violate the Law of Demeter, but are a warning sign for potential violations,
 * and some elements of this solution do explicitly violate the law.
 * 
 * Various other alternate approaches are shown in comment (not related to Demeter). Hopefully this isn't confusing.
 * 
 * Class specific comments:
 * 
 * 
 * @author Martin
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Banker mrPoe = new Banker("Mr Poe", 3);
		
		mrPoe.addRelative("Olaf", -10, 10);
		mrPoe.addRelative("Uncle Monty", 10, 20);
		mrPoe.addRelative("Uncle Monty", 100, 200);
		mrPoe.addRelative("Josephine", 5, 100);
		mrPoe.addRelative("Sir", 0, 20);
		
		boolean housed = false;
		
		// Don't want to see any while true loops here!
		while (!housed) {
			
			String preamble;
			
			//if ( mrPoe.getGuardian() == null ) {
			if ( mrPoe.hasGuardian() ) {
				
				preamble = "Moving to live with: ";
			
			} else {
				
				preamble = "Moving to a new guardian: ";
			}

			// Breaks Demeter's Law:
			// System.out.println(preamble + mrPoe.closestRelative().getName());
			System.out.println(preamble + mrPoe.closestRelativeName());
			
			// mrPoe.setGuardian(mrPoe.closestRelative());
			mrPoe.setGuardian(mrPoe.closestRelativeName());
			
			// Breaks Demeter's Law:
			// if ( mrPoe.getGuardian().getFriendliness() < mrPoe.getFriendliness() ) {
			if ( mrPoe.getGuardianFriendliness() < mrPoe.getFriendliness() ) {
				
				// Breaks Demeter's Law:
				// System.out.println(mrPoe.getGuardian().getName() + " is not friendly, relocating.");
				System.out.println(mrPoe.getGuardianName() + " is not friendly, relocating.");
				mrPoe.removeCurrentGuardian();
				
				// More reusable list modification:
				// mrPoe.removeRelativeFromList(mrPoe.getGuardian()); 
				// mrPoe.removeRelativeFromList(mrPoe.getGuarianName());
				
			} else {
				
				housed = true;
				
			}
			
		}

	}

}
