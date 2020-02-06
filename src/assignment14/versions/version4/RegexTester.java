package assignment14.versions.version4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
	
	public String testRegex( String pattern, String input ) {
		
		System.out.println("=== " + input + " ===");
		
	    Pattern compiledPattern = Pattern.compile(pattern);

	    Matcher matcher = compiledPattern.matcher(input);
	    
	    while ( matcher.find() ) {
			
			return matcher.group();
			
		}
	    
	    return null;
	    
	}

	/**
	 * Adds flexibility when you do not wish to specify and offset.
	 * 
	 * @param day
	 * @return
	 */
	private String nextDay(String day) {
		
		return nextDay(day, 0);
		
	}
	
	private String nextDay(String day, int offset) {
		
        int plusDays = DayOfWeek.valueOf(day.toUpperCase()).getValue() - LocalDate.now().getDayOfWeek().getValue();
        
        if ( plusDays < 0 ) plusDays += 7;
        
        plusDays += offset;
        
        return LocalDate.now().plusDays(plusDays).toString();
    
	}
	
	/**
	 * List of patterns
	 */
	private ArrayList<String> datePatterns;
	
	/**
	 * Constructs a list of acceptable date patterns.
	 */
	private void setUpDatePatterns() {
		
		datePatterns = new ArrayList<String>();
		
		// Order here important.
		datePatterns.add("(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day\\s[0-9]{1,2}(st|nd|rd|th)\\s(January|February|March|April|May|June|July|August|September|October|November|December)");
		datePatterns.add("\\d\\d/\\d\\d/\\d\\d\\d\\d");
		datePatterns.add("(O|o)n\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day");
		datePatterns.add("(N|n)ext\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day");
		
	}
	
	public String getDate(String entry) {
		
		for ( String pattern : datePatterns ) {
			
			String dateExtract = testRegex(pattern, entry);
			
			if ( dateExtract != null ) {
				
				System.out.println("Matched pattern: " + pattern);
				
				// May feel a little repetitive, but good for extensibility.
				if ( dateExtract.matches(datePatterns.get(2)) ) {
					
					dateExtract = nextDay(dateExtract.replaceAll("(O|o)n", "").trim());
					
				} else if ( dateExtract.matches(datePatterns.get(3)) ) {
					
					dateExtract = nextDay(dateExtract.replaceAll("(N|n)ext", "").trim(), 7);
					
				}
				
				return dateExtract;
				
			}
			
		}
		
		return "-";
		
	}
	
	public RegexTester() {
		
		// Date:
		
		setUpDatePatterns();
		
		String dateA = "Meet Martin at 1pm on Wednesday 8th March at King's.";
		
		System.out.println( getDate(dateA) );
		
		String dateB = "Meet Martin at 1pm on 08/03/2017.";
		
		System.out.println( getDate(dateB) );
		
		String dateC = "Meet Martin at 1pm on Wednesday.";
		
		System.out.println( getDate(dateC) );
		
		String dateD = "Meet Martin at 1pm next Wednesday.";
		
		System.out.println( getDate(dateD) );
		
		// Time:
		
		String timeA = "Meet Martin at 13:00 on Wednesday 8th March at King's.";
		
		System.out.println( testRegex( "[0-9]{2}:[0-9]{2}", timeA ));
		
		String timeB = "Meet Martin at 1pm on Wednesday 8th March at King's.";
		
		System.out.println( testRegex( "[0-9]{1,2}(am|pm)", timeB ));
		
		String timeC = "Meet Martin on Wednesday 8th March at King's in the evening.";
		
		System.out.println( testRegex( "in the evening", timeC ));
		
		String timeD = "Meet Martin on Wednesday 8th March at King's in the morning.";
		
		System.out.println( testRegex( "in the morning", timeD ));
		
		// Location:
		
		String location = "Meet Martin on Wednesday 8th March at King's in the morning.";
		
		// Single word that follows at
		System.out.println( testRegex( "(A|a)t\\s[A-Za-z']+", location ).replace("at", "") );
		
	}
	
	public static void main(String[] args) {
		
		new RegexTester();
		
	}

}
