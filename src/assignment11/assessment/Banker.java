package assignment11.assessment;

import java.util.Map.Entry;
import java.util.TreeMap;

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
 * Students will likely take two main approaches to the list of relatives: a tree map mapping a Person to
 * a distance, or an Arraylist of a specialised relative type containing the distance information. Both
 * are fine. Be more cautious of other approaches, as they may be less efficient.
 * 
 * @author Martin
 *
 */
public class Banker extends Person {
	
	/**
	 * I don't really want to see String to Integer here, as this often means there is a superfluous
	 * step correlating names to friendliness later.
	 */
	private TreeMap<Person, Integer> relatives;
	private Person currentGuardian;
	
	public Banker(String name, int friendliness) {
		
		super(name, friendliness);
		relatives = new TreeMap<Person, Integer>();
		
	}
	
	/*public void addRelative(Person relative, int distance) {
		
		relatives.put(relative, distance);
	
	}*/

	public void addRelative(String name, int friendliness, int distance) {
		
		relatives.put(new Person(name, friendliness), distance);
	
	}
	
	/*public void setGuardian(Person currentGuardian) {
		
		this.currentGuardian = currentGuardian;
		
	}*/
	
	public void setGuardian(String currentGuardian) {
		
		for ( Entry<Person, Integer> entry : relatives.entrySet() ) {
			
			if (entry.getKey().getName().equals(currentGuardian)) this.currentGuardian = entry.getKey();
			
		}

	}
	
	/*public Person getGuardian() {
		
		return currentGuardian;
		
	}*/
	
	public boolean hasGuardian() {
		
		return currentGuardian != null;
		
	}
	
	public int getGuardianFriendliness() {
		
		return currentGuardian.getFriendliness();
		
	}
	
	public String getGuardianName() {
		
		return currentGuardian.getName();
		
	}
	
	public void removeCurrentGuardian() {
		
		relatives.remove(currentGuardian);
	
	}
	
	/* More reusable permutations on removing relative from list (supporting coupled and non-coupled, resp.):
	 
	   public void removeRelativeFromList(Person person) {
		
		  relatives.remove(person);
		
       }
	
	   public void removeRelativeFromList(String relative) {
		
		for ( Entry<Person, Integer> entry : new HashSet<Entry<Person, Integer>>(relatives.entrySet()) ) {
			
			if (entry.getKey().getName().equals(relative)) relatives.remove(entry.getKey());
			
		}
		
	}*/
	
	public String closestRelativeName() {
		
		return closestRelative().getName();
		
	}
	
	/**
	 * Simple algorithm to iterate through a list of integers,
	 * and find the lowest + and associated object.
	 * 
	 * Students struggled accessing the values stored in a Treemap,
	 * so look at how they have approached this problem.
	 * 
	 * @return
	 */
	private Person closestRelative() {
		
		int closestDistance = Integer.MAX_VALUE;
		Person closestRelative = null;
		
		for ( Entry<Person, Integer> entry : relatives.entrySet() ) {
			
			if ( entry.getValue() < closestDistance ) {
				
				closestRelative = entry.getKey();
				closestDistance = entry.getValue();
				
			}
			
		}
		
		return closestRelative;
		
	}
	
	public String toString() {
		
		return relatives.toString() + " " + currentGuardian;
		
	}
	
}
