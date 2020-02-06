package assignment14.model.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {

	public RegexTester( String pattern, String input ) {
		
		System.out.println("=====================" + input + "=====================");
		
	    Pattern r = Pattern.compile(pattern);

	    Matcher m = r.matcher(input);
	    
	    System.out.println(m.groupCount());
	    
	    if ( m.groupCount() > 0 ) {
	    	
	    	m.find();
	    	
	    	for ( int i = 1; i < m.groupCount() + 1; i++ ) {
	    		
	    		try {
	    		
	    			System.out.println( "Capture group: " + m.group(i) );
	    		
	    		} catch (Exception e ) { System.out.println("Exception thrown on Line 30. Probably capture group not found, and regex does not match."); }
	    		
	    	}
	    	
	    }
 
	    m.reset();
	    
	    if ( m.matches() ) {
	    	
	    	System.out.println( "Matches exactly: " + m.group() );
	    	
	    }
	    
	    m.reset();
	    
	    if ( m.find() ) {
	    	
            System.out.println( "Partial matches: " + m.group() + " (" + m.start(0) + "-" + m.end(0) + ")" );
        
	    }
	    
	    System.out.println(partialMatches(pattern, input, m));
	 
	    System.out.println("===========================================");
	    
	}
	
	public static String firstPartialMatch(String pattern, String input) {
		
		Pattern r = Pattern.compile(pattern);
		
		Matcher m = r.matcher(input);
		
		ArrayList<String> matches = partialMatches(pattern, input, m);
		
		if ( matches.size() > 0 ) {
		
			return matches.get(0);
					
		} else {
			
			return null;
			
		}
		
	}
	
	public static ArrayList<String> partialMatches(String pattern, String input, Matcher m) {
		
		ArrayList<String> partialMatches = new ArrayList<String>();
		
		m.reset();
	    
		while ( m.find() ) {
			
			partialMatches.add( m.group() );
			
		}
		
		return partialMatches;
		        
	}
	
	public static String simpleRegex( String pattern, String input ) {
		
	    Pattern compiledPattern = Pattern.compile(pattern);

	    Matcher matcher = compiledPattern.matcher(input);
	    
	    while ( matcher.find() ) {
			
			return matcher.group();
			
		}
	    
	    return "";
	    
	}
	
	public static void main(String[] args) {
		
		
		
	}
	
}