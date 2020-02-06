package assignment14.versions.version5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
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

	private String nextDay(String day) {
		
		return nextDay(day, 0);
		
	}
	
	private String nextDay(String day, int offset) {
		
        int plusDays = DayOfWeek.valueOf(day.toUpperCase()).getValue() - LocalDate.now().getDayOfWeek().getValue();
        
        if ( plusDays < 0 ) plusDays += 7;
        
        plusDays += offset;
        
        // We could have formatted here, rather than having to reformat later, but this keeps things consistent.
        return LocalDate.now().plusDays(plusDays).toString();
    
	}
	
	/**
	 * List of patterns
	 */
	private LinkedHashMap<String, String> datePatternsToFormat;
	private String[] datePatterns;
	
	/**
	 * Constructs a list of acceptable date patterns.
	 */
	private void setUpDatePatterns() {
		
		datePatternsToFormat = new LinkedHashMap<String, String>();
		
		// Order here (still) important.
		datePatternsToFormat.put("(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day\\s[0-9]{1,2}(st|nd|rd|th)\\s(January|February|March|April|May|June|July|August|September|October|November|December)", "");
		datePatternsToFormat.put("\\d\\d/\\d\\d/\\d\\d\\d\\d", "dd/MM/yyyy");
		datePatternsToFormat.put("(O|o)n\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", "yyyy-MM-dd");
		datePatternsToFormat.put("(N|n)ext\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", "yyyy-MM-dd");
		
		// To allow us to still access our patterns, we build an array of them:
		datePatterns = datePatternsToFormat.keySet().toArray(new String[datePatternsToFormat.keySet().size()]);
		
	}

	public String getDate(String entry) {
		
		for ( Entry<String, String> patternToFormat : datePatternsToFormat.entrySet() ) {
			
			String dateExtract = testRegex(patternToFormat.getKey(), entry);
			
			if ( dateExtract != null ) {
				
				if ( dateExtract.matches(datePatterns[2]) ) {
					
					dateExtract = nextDay(dateExtract.replaceAll("(O|o)n", "").trim());
					
				} else if ( dateExtract.matches(datePatterns[3]) ) {
					
					dateExtract = nextDay(dateExtract.replaceAll("(N|n)ext", "").trim(), 7);
					
				}
				
				if ( patternToFormat.getValue().equals("") ) {
					
					return dateExtract;
					
				} else {
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternToFormat.getValue());
					
					String[] dateString = LocalDate.parse(dateExtract, formatter).format(DateTimeFormatter.ofPattern("EEEE d MMMM")).toString().split(" ");
					
					return dateString[0] + " " + dateString[1] + getDayOfMonthSuffix(Integer.parseInt(dateString[1])) + " " + dateString[2];
					
				}
				
			}
			
		}
		
		return "-";
		
	}
	
	private String getDayOfMonthSuffix(int n) {
		
	    if ( n >= 11 && n <= 13 ) return "th"; // Different rules for 11, 12 and 13.
	
	    switch (n % 10) {
	    
	        case 1:  return "st"; // General rule 1, 21, 31st etc.
	        case 2:  return "nd"; // General rule 2, 22, 32nd, etc.
	        case 3:  return "rd"; // General rule 3, 23rd, 33rd, etc.
	        default: return "th"; // 4th, 5th 6th, 7th, 8th, 9th, 10th; 24th, 25th 26th, 27th, 28th, 29th, 30th, etc.
	    
	    }
	
	}
	
	/**
	 * Simply to test suffix generator.
	 */
	private void daySuffixTester() {
		
		for ( int i = 1; i < 32; i++ ) {
			
			System.out.println(i + getDayOfMonthSuffix(i));
			
		}

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
		
		String timeD = "Meet Martin at Wednesday 8th March at King's in the morning.";
		
		System.out.println( testRegex( "in the morning", timeD ));
		
		// Location:
		
		String location = "Meet Martin at Wednesday 8th March at King's in the morning.";
		
		// Single word that follows at
		System.out.println( testRegex( "(A|a)t\\s[A-Za-z']+", location ).replace("at ", "") );
		
	}
	
	public static void main(String[] args) {
				
		new RegexTester();
		
	}

}
