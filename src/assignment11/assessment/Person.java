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
 * This class should implement Comparable in order to obtain full quality marks. This makes ordering the list
 * of relatives, whether it is a Treemap or an ArrayList that is sorted using Collections.sort, much more
 * efficient.
 * 
 * @author Martin
 *
 */
public class Person implements Comparable<Person> {
	
	private String name;
	private int friendliness;
	
	public Person(String name, int friendliness) {
		
		this.name = name;
		this.friendliness = friendliness;
		
	}

	public String getName() {
		
		return name;
		
	}
	
	public int getFriendliness() {
		
		return friendliness;
		
	}
	
	/* 
	 * Part of the implementation of Comparable.
	 * 
	 * Might want to make sure that they have strictly written
	 * the name of the class as the parameter type here, rather
	 * than Object (followed by a cast). This fully capitalises
	 * on the typing of the interface.
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Person o) {
		
		return this.name.compareTo(o.name);
		
	}
	
	public String toString() {
		
		return name + " " + friendliness;
		
	}

}
