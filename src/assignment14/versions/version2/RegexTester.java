package assignment14.versions.version2;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
	 * For 'on Wednesday'. Finds date of next day.
	 * @param day
	 * @return
	 */
	private String nextDay(String day) {
		
		// Number of days between now and number of day (day has to be in uppercase in order to work).
        int plusDays = DayOfWeek.valueOf(day.toUpperCase()).getValue() - LocalDate.now().getDayOfWeek().getValue();
       
        // What we eventually want to do: LocalDate target = LocalDate.now().plusDays(plusDays);.
        
        // If negative, add 7 so next available day.
        // E.g. today is Wednesday (3), user enters Monday (1) = -2. -2 + 7 = 5. Wednesday + 5 = Monday.
        if ( plusDays < 0 ) plusDays += 7;
        
        // Get the date representation of the target date.
        return LocalDate.now().plusDays(plusDays).toString();
    
	}
	
	public RegexTester() {
		
		// Date:
		
		String dateA = "Meet Martin at 1pm on Wednesday 8th March at King's.";
		
		System.out.println( testRegex( "(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day\\s[0-9]{1,2}(st|nd|rd|th)\\s(January|February|March|April|May|June|July|August|September|October|November|December)", dateA ));
		
		String dateB = "Meet Martin at 1pm on 08/03/2017.";
		
		System.out.println( testRegex( "\\d\\d/\\d\\d/\\d\\d\\d\\d", dateB ));
		
		String dateC = "Meet Martin at 1pm on Wednesday.";
		
		System.out.println( testRegex( "(O|o)n\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", dateC ));
	
		// Testing nextDay
		System.out.println( nextDay( testRegex( "(O|o)n\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", dateC ) ) );
		
		String dateD = "Meet Martin at 1pm next Wednesday.";
		
		System.out.println( testRegex( "(N|n)ext\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", dateD ));
		
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
		
		System.out.println( testRegex( "(A|a)t\\s[A-Za-z']+", location ).replace("at ", "") );
		
	}
	
	public static void main(String[] args) {
		
		new RegexTester();
		
	}

}
