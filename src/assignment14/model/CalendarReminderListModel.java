package assignment14.model;

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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.AbstractListModel;

import assignment14.model.utils.RegexTester;

/**
 * Makes sense for the model element of the program to be an abstract list model (or another relevant list model).
 * 
 * This means the model can be added directly to the JList in the view, and the communication between the model
 * and the view is handled internally, as opposed to via an explicit observer/observable structure.
 * 
 * @author Martin
 *
 */
public class CalendarReminderListModel extends AbstractListModel<String> {
	
	private ArrayList<String> entries;
	private boolean isCalendar;
	public static final String FILE_PREFIX = "resources/coursework14/";
	public static final String CALENDAR = "calendar.txt";
	public static final String REMINDER = "reminders.txt";
	private String path;
	private File file;
	
	public CalendarReminderListModel(boolean isCalendar) {
		
		this.isCalendar = isCalendar;
		this.entries = new ArrayList<String>();
		datePatternFormats();
		timePatternFormats();
		
		if ( isCalendar ) {
			
			path = FILE_PREFIX + CALENDAR;
			
			
		} else {
			
			path = FILE_PREFIX + REMINDER;
			
		}
		
		file = new File(path);
		
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
	
	/**
	 * @param entry
	 * @throws IOException 
	 */
	public void addEntry(String entry) {
		
		String formattedEntry = "";
		File file;
		
		if ( isCalendar ) {
			
			formattedEntry = "Event: " + getEvent(entry) +
					" | Date: " + getDate(entry) + 
					" | Time: " + getTime(entry) + 
					" | Location: " + getLocation(entry);
			
		} else {
		
			// Uppercase first letter
			formattedEntry = entry.replace("Remind me to ", "").substring(0, 1).toUpperCase() + entry.replace("Remind me to ", "").substring(1);
			
			String date = getDate(formattedEntry);
			String time = getTime(formattedEntry);
			
			if ( !getDate(formattedEntry).equals("-") ) {
				
				formattedEntry = getEvent(formattedEntry) + " | " + date;
				
			} else if ( !getTime(formattedEntry).equals("-") ) {
				
				formattedEntry = getEvent(formattedEntry) + " | " + time;
				
			}
			
		}
		
		entries.add(formattedEntry);
		
		writeToFile(formattedEntry);
		
		fireIntervalAdded(this, entries.size() - 1, entries.size() - 1);
		
	}
	
	// Date:
	
	private LinkedHashMap<String, String> datePatternToFormat;
	private String[] datePatterns;
	
	private void datePatternFormats() {
		
		datePatternToFormat = new LinkedHashMap<String, String>();
		
		datePatternToFormat.put("(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day\\s[0-9]{1,2}(st|nd|rd|th)\\s(January|February|March|April|May|June|July|August|September|October|November|December)", "");
		datePatternToFormat.put("\\d\\d/\\d\\d/\\d\\d\\d\\d", "dd/MM/yyyy");
		datePatternToFormat.put("(O|o)n\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", "yyyy-MM-dd");
		datePatternToFormat.put("(N|n)ext\\s(Mon|Tues|Wednes|Thurs|Fri|Sat|Sun)day", "yyyy-MM-dd");
		
		datePatterns = datePatternToFormat.keySet().toArray(new String[datePatternToFormat.keySet().size()]);
		
	}
	
	private String getDate(String entry) {
		
		for ( Entry<String, String> patternFormat : datePatternToFormat.entrySet() ) {	
		
			String dateExtract = RegexTester.firstPartialMatch(patternFormat.getKey(), entry);
			
			if ( dateExtract != null ) {
		
				if ( dateExtract.matches(datePatterns[2]) ) {
					
					dateExtract = nextDay(dateExtract.replaceAll("(O|o)n", "").trim());
					
				} else if ( dateExtract.matches(datePatterns[3]) ) {
					
					dateExtract = nextDay(dateExtract.replaceAll("(N|n)ext", "").trim(), 7);
					
				}
				
				// Indicates that there's no formatting to do.
				if ( patternFormat.getValue().equals("") ) {
					
					return dateExtract;
					
				} else {
				
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternFormat.getValue());
				
					String[] dateString = LocalDate.parse(dateExtract, formatter).format(DateTimeFormatter.ofPattern("EEEE d MMMM")).toString().split(" ");
					
		        	return dateString[0] + " " + dateString[1] + getDayOfMonthSuffix(Integer.parseInt(dateString[1])) + " " + dateString[2];
		        
				}
	        
			}
			
		}
		
		return "-";
		
	}
	
	private String multiRegexTest(String[] patterns, String entry) {
		
		for ( String regex : patterns ) {
			
			String result = RegexTester.firstPartialMatch(regex, entry);
			
			if ( result != null ) return result;
		
		}
		
		return "-";
		
	}
	
	private String nextDay(String day, int offset) {
		
        int plusDays = DayOfWeek.valueOf(day.toUpperCase()).getValue() - LocalDate.now().getDayOfWeek().getValue();
       
        if ( plusDays < 0 ) plusDays += 7;
        
        plusDays += offset;
        
        return LocalDate.now().plusDays(plusDays).toString();
        
	}
	
	private String nextDay(String day) {
		
		return nextDay(day, 0);
		
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
	
	// Time:
	
	private HashMap<String, String> timePatternToFormat;
	
	private void timePatternFormats() {
		
		timePatternToFormat = new HashMap<String, String>();
		
		timePatternToFormat.put("[0-9]{1,2}(am|pm)", "ha");
		timePatternToFormat.put("[0-9]{1,2}(AM|PM)", "ha");
		timePatternToFormat.put("[0-9]{2}:[0-9]{2}", "HH:mm");
		timePatternToFormat.put("in the evening", "-");
		timePatternToFormat.put("in the morning", "-");
		
	}
	
	private String getTime(String entry) {
		
		for ( Entry<String, String> patternFormat : timePatternToFormat.entrySet() ) {
			
			String result = RegexTester.firstPartialMatch(patternFormat.getKey(), entry);
			
			if ( result != null ) {
				
				if ( result.equals("in the evening") ) {
					
					return "20:00";
					
				} else if ( result.equals("in the morning") ) {
					
					return "09:00";
					
				}
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternFormat.getValue());
				
				LocalTime dateTime = LocalTime.parse(result.toUpperCase(), formatter);
				
				String minutes = dateTime.getMinute() + "";
				
				if ( dateTime.getMinute() == 0 ) minutes += "0";
				
				return dateTime.getHour() + ":" +  minutes;
				
			}
		
		}
	
		return "-";
		
	}
	
	// Location:
	
	private String locationRegex = "(A|a)t\\s[A-Za-z']+";
	
	private String getLocation(String entry) {
		
		return multiRegexTest(new String[]{locationRegex}, entry).replace("at ", "").replace("At ", "") ;
		
	}

	// Event:
	
	private String getEvent(String entry) {
		
		return entry.replace(multiRegexTest(datePatterns, entry), "")
				 .replace(multiRegexTest((String[])new ArrayList<String>(timePatternToFormat.keySet()).toArray(new String[timePatternToFormat.keySet().size()]), entry), "")
				 .replace(multiRegexTest(new String[]{locationRegex}, entry), "")
				 .replace("at", "")
				 .replace("on", "")
				 .replace(".", "")
				 .trim();
	
	}	
	
	//
	
	public boolean remove(int index) {
		
		if ( index >= 0 && entries.size() > index ) {
			
			entries.remove(index);
			
			try {
				
				Files.delete(Paths.get(path));
			
			} catch (IOException e) {
			
				e.printStackTrace();
			
			}
			
			this.fireIntervalRemoved(this, index, index);
			
			return true;
		
		} else {
			
			return false;
			
		}
		
	}
	
	private void writeToFile(String entry) {
		
		try {

		    file.createNewFile();
		      
		    FileWriter writer = new FileWriter(file); 
		      
		    writer.append(entry);
		    
		    writer.close();
	    
		} catch ( IOException e ) {
		
			System.out.println("Failed to save entry.");
			
		}
		
	}
	
	//
	
	@Override
	public int getSize() {
		
		return entries.size();
	
	}

	@Override
	public String getElementAt(int index) {
		
		return entries.get(index);
		
	}

}