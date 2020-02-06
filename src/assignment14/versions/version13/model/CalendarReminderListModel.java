package assignment14.versions.version13.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractListModel;

public class CalendarReminderListModel extends AbstractListModel<String> {
	
	private ArrayList<String> entries;
	private boolean isCalendar;
	
	/**
	 * Base location for both files
	 */
	public static final String FILE_PREFIX = "resources/coursework14/";
	
	/**
	 * Different files to load depending on what is selected.
	 */
	public static final String CALENDAR = "calendar.txt";
	
	/**
	 * 
	 */
	public static final String REMINDER = "reminders.txt";
	
	/**
	 * Holds current path
	 */
	private String path;
	
	
	/**
	 * Holds current file
	 */
	private File file;
	
	public String testRegex( String pattern, String input ) {
		
	    Pattern compiledPattern = Pattern.compile(pattern);

	    Matcher matcher = compiledPattern.matcher(input);
	    
	    while ( matcher.find() ) {
			
			return matcher.group();
			
		}
	    
	    return null;
	    
	}
	
	public String multiTestRegex(ArrayList<String> patterns, String input ) {
		
		for ( String pattern : patterns ) {
			
			String result = testRegex( pattern, input );
			
			if ( result != null ) return result;
			
		}
		
		return "";
		
	}

	private String nextDay(String day) {
		
		return nextDay(day, 0);
		
	}
	
	private String nextDay(String day, int offset) {
		
        int plusDays = DayOfWeek.valueOf(day.toUpperCase()).getValue() - LocalDate.now().getDayOfWeek().getValue();
        
        if ( plusDays < 0 ) plusDays += 7;
        
        plusDays += offset;
        
        return LocalDate.now().plusDays(plusDays).toString();
    
	}

	private LinkedHashMap<String, String> datePatternsToFormat;
	private ArrayList<String> datePatterns;
	
	private void setUpDatePatterns() {
		
		datePatternsToFormat = new LinkedHashMap<String, String>();
		
		datePatternsToFormat.put("(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day\\s[0-9]{1,2}(st|nd|rd|th)\\s(January|February|March|April|May|June|July|August|September|October|November|December)", "");
		datePatternsToFormat.put("\\d\\d/\\d\\d/\\d\\d\\d\\d", "dd/MM/yyyy");
		datePatternsToFormat.put("(O|o)n\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", "yyyy-MM-dd");
		datePatternsToFormat.put("(N|n)ext\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", "yyyy-MM-dd");
		
		datePatterns = new ArrayList<String>(Arrays.asList(datePatternsToFormat.keySet().toArray(new String[datePatternsToFormat.keySet().size()])));
		
	}
	
	private String getDayOfMonthSuffix(int n) {
		
	    if ( n >= 11 && n <= 13 ) return "th";
	
	    switch (n % 10) {
	    
	        case 1:  return "st";   
	        case 2:  return "nd";
	        case 3:  return "rd";
	        default: return "th";
	    
	    }
	
	}

	public String getDate(String entry) {
		
		for ( Entry<String, String> patternToFormat : datePatternsToFormat.entrySet() ) {
			
			String dateExtract = testRegex(patternToFormat.getKey(), entry);
			
			if ( dateExtract != null ) {
				
				if ( dateExtract.matches(datePatterns.get(2)) ) {
					
					dateExtract = nextDay(dateExtract.replaceAll("(O|o)n", "").trim());
					
				} else if ( dateExtract.matches(datePatterns.get(3)) ) {
					
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
	
	private LinkedHashMap<String, String> timePatternsToFormat;
	
	private void setUpTimePatterns() {
		
		timePatternsToFormat = new LinkedHashMap<String, String>();
		
		timePatternsToFormat.put("[0-9]{2}:[0-9]{2}", "");
		timePatternsToFormat.put("[0-9]{1,2}(am|pm)", "ha");
		timePatternsToFormat.put("in the evening", "");
		timePatternsToFormat.put("in the morning", "");
		
	}
	
	private String getTime(String entry) {
		
		for ( Entry<String, String> patternToFormat : timePatternsToFormat.entrySet() ) {
			
			String timeExtract = testRegex(patternToFormat.getKey(), entry);
			
			if ( timeExtract != null ) {
				
				if ( timeExtract.equals("in the evening") ) {
					
					return "20:00";
					
				} else if ( timeExtract.equals("in the morning") ) {
					
					return "09:00";
					
				}
				
				if ( patternToFormat.getValue().equals("") ) {
					
					return timeExtract;
					
				} else {
				
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternToFormat.getValue());
					
					LocalTime dateTime = LocalTime.parse(timeExtract.toUpperCase(), formatter);
					
					return dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
				
				}
				
			}
		
		}
	
		return "-";
		
	}
	
	public String getLocation(String entry) {
		
		String location = testRegex( "(A|a)t\\s[A-Za-z']+", entry );
		
		if ( location == null ) {
			
			return "-";
			
		} else {
			
			return location.replace("at ", "");
			
		}
		
	}
	
	public String getEvent(String entry) {
		
		ArrayList<String> timePatterns = new ArrayList<String>(Arrays.asList(timePatternsToFormat.keySet().toArray(new String[datePatternsToFormat.keySet().size()])));
		
		return entry.replace(multiTestRegex(datePatterns, entry), "")
				    .replace(multiTestRegex(timePatterns, entry), "")
				    .replace(multiTestRegex( new ArrayList<String>(Arrays.asList(new String[]{"(A|a)t\\s[A-Za-z']+"})), entry), "")
				    .replace("at", "")
				    .replace("on", "")
				    .replace(".", "")
					.trim();
		
	}
	
	/**
	 * To be called by listeners interacting with the model.
	 * 
	 * @param entry
	 * @return
	 */
	public void formatEntry(String entry) {
		
		String formattedEntry = "";
		
		if ( isCalendar ) {
			
			formattedEntry = "Event: " + getEvent(entry) +
					" | Date: " + getDate(entry) + 
					" | Time: " + getTime(entry) + 
					" | Location: " + getLocation(entry);
			
		} else {
		
			// Remove remind me to, and transform first letter to uppercase.
			formattedEntry = entry.replace("Remind me to ", "").substring(0, 1).toUpperCase() + entry.replace("Remind me to ", "").substring(1);
			
			String date = getDate(formattedEntry);
			String time = getTime(formattedEntry);
			
			if ( !getDate(formattedEntry).equals("-") ) {
				
				formattedEntry = getEvent(formattedEntry) + " | " + date;
				
			} else if ( !getTime(formattedEntry).equals("-") ) {
				
				formattedEntry = getEvent(formattedEntry) + " | " + time;
				
			} else if ( !getDate(formattedEntry).equals("-") &&   !getTime(formattedEntry).equals("-") ) {
				
				formattedEntry = getEvent(formattedEntry) + " | " + date + " | " + time;
				
			}
			
		}
		
		entries.add(formattedEntry);
		
		writeToFile(formattedEntry);
		
		fireIntervalAdded(this, entries.size() - 1, entries.size() - 1);
		
	}
	
	/**
	 * Utility method to write to a file.
	 * 
	 * @param entry
	 */
	private void writeToFile(String entry) {
		
		try {

		    file.createNewFile();
		      
		    FileWriter writer = new FileWriter(file, true); 
		      
		    writer.write(entry + "\n");
		    
		    writer.close();
	    
		} catch ( IOException e ) {
		
			System.out.println("Failed to save entry.");
			
		}
		
	}
	
	public CalendarReminderListModel(boolean isCalendar) {
		
		this.isCalendar = isCalendar;
		
		this.entries = new ArrayList<String>();
		
		setUpDatePatterns();
		
		setUpTimePatterns();
		
		// Update current path (based upon whether calendar or reminder).
		if ( isCalendar ) {
			
			path = FILE_PREFIX + CALENDAR;
			
			
		} else {
			
			path = FILE_PREFIX + REMINDER;
			
		}
		
		// Update current file 
		file = new File(path);
		
		// Reading in file content and updating list (easy with list extension).
		Scanner input;
		
		if ( file.exists() ) {
			
			try {
				
				input = new Scanner(file);
				
				while ( input.hasNext() ) {
					
					entries.add(input.nextLine());
					
				}
			
			    input.close();
			    
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			
			}
		
		}
		
	}
	
	public boolean remove(int index) {
		
		if ( index >= 0 && entries.size() > index ) {
			
			entries.remove(index);
			
			try {
				
				Files.delete(Paths.get(path));
			
			} catch (IOException e) {
			
				e.printStackTrace();
			
			}
			
			for ( String item : entries ) {
				
				writeToFile(item);
				
			}
			
			this.fireIntervalRemoved(this, index, index);
			
			return true;
		
		} else {
			
			return false;
			
		}
		
	}

	@Override
	public int getSize() {
		
		return entries.size();
	
	}

	@Override
	public String getElementAt(int index) {
		
		return entries.get(index);
		
	}

}
